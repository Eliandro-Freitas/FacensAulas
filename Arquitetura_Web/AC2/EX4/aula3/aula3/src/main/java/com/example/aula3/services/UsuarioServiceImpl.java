package com.example.aula3.services;

import com.example.aula3.dto.UsuarioDTO;
import com.example.aula3.entity.Perfil;
import com.example.aula3.entity.Usuario;
import com.example.aula3.exceptions.RegraNegocioException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    @Transactional
    public Usuario salvar(UsuarioDTO dto) {
        return null;
    }
}
