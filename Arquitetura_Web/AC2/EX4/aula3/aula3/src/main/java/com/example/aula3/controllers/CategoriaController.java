package com.example.aula3.controllers;

import java.util.List;
import java.util.Optional;

import com.example.aula3.entity.Categoria;
import com.example.aula3.entity.Perfil;
import com.example.aula3.repository.CategoriaRepository;
import com.example.aula3.repository.PerfilRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * PerfilController
 */
@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/{id}")    
    public Categoria getById(@PathVariable int id){
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Perfil não encontrado."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);  
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id){
        categoriaRepository.findById(id)
            .map(categoria -> {
                categoriaRepository.delete(categoria);
                return categoria;
            })
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Perfil não encontrado"));        
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable int id, 
                                        @RequestBody Perfil perfil){
         categoriaRepository.findById(id)
                .map(categoriaExistente ->{
                    perfil.setId(categoriaExistente.getId_categoria());
                    categoriaRepository.save(categoriaExistente);
                    return categoriaExistente;
                }) 
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Perfil não encontrado.")); 
    }

    @GetMapping
    public List<Categoria> find(Categoria filtro){
        ExampleMatcher matcher = ExampleMatcher.matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                        StringMatcher.CONTAINING);

        Example example = Example.of(filtro,matcher);
        return categoriaRepository.findAll(example);
    }
    
    
    @RequestMapping(value = {"/teste/{nome}","/teste2/{nome}"}, 
                    method = RequestMethod.GET,
                    consumes = {"application/json","application/xml"},
                    produces = {"application/json","application/xml"})
    public String testePerfil(@PathVariable("nome") String nomePerfil){
        return String.format("Olá %s",nomePerfil );
    }
    
}