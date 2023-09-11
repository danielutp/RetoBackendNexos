package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.domain.Usuario;
import com.co.nexos.mercancia.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Date date = new Date(1995, 02, 27);

        MercanciaDto mercanciaDto = new MercanciaDto("Daniel", 2, new Date(), new Usuario());
        mercanciaDto.setFechaIngreso(date);
        mercanciaDto.setNombre("Daniel");
        mercanciaDto.setCantidad(2);
        mercanciaDto.setFechaIngreso(new Date());
        mercanciaDto.setUsuario(new Usuario());

        usuario = new Usuario();
        usuario.setId(1);
        usuario.setMercancias(new ArrayList<>());
        usuario.setNombre("cliente");
        usuario.setFechaIngreso(new Date());
        usuario.setEdad(23);
    }
    @Test
    void listaUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));
        assertNotNull(usuarioService.listaUsuarios());
    }
}