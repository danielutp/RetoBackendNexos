package com.co.nexos.mercancia.controller;

import com.co.nexos.mercancia.domain.Usuario;
import com.co.nexos.mercancia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public List<Usuario> listaMercacias() {
        return usuarioService.listaUsuarios();
    }
}
