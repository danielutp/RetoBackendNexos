package com.co.nexos.mercancia.controller;


import com.co.nexos.mercancia.service.UsuarioService;
import com.co.nexos.mercancia.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<Response> listaUsuarioss() {
        response.restart();
        response.message = "La lista de usuarios es : ";
        response.data = usuarioService.listaUsuarios();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }
}
