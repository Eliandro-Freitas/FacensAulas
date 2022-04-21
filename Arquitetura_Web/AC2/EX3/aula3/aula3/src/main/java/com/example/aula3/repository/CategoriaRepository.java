package com.example.aula3.repository;

import java.util.List;

import com.example.aula3.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
    @Query(value = "SELECT * FROM tb_categoria u WHERE u.cat_nome = ?1", nativeQuery = true)
    List<Categoria> findCategoriaByName(String cat_name); 

    @Query(value = "SELECT COUNT(*) FROM tb_produto WHERE u.id_catetogia = ?1", nativeQuery = true)
    List<Categoria> getCategoriaCountByProduto_Id(int id_catetogia);
}