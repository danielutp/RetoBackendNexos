package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Usuario;
import com.co.nexos.mercancia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

}
