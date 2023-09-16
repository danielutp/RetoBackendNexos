package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.dtos.MerchandiseDto;
import com.co.nexos.mercancia.domain.User;
import com.co.nexos.mercancia.repository.UserRepository;
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

class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Date date = new Date(1995, 02, 27);

        MerchandiseDto merchandiseDto = new MerchandiseDto("Daniel", 2, new Date(), new User());
        merchandiseDto.setFechaIngreso(date);
        merchandiseDto.setNombre("Daniel");
        merchandiseDto.setCantidad(2);
        merchandiseDto.setFechaIngreso(new Date());
        merchandiseDto.setUser(new User());

        user = new User();
        user.setId(1);
        user.setMerchandises(new ArrayList<>());
        user.setNombre("cliente");
        user.setFechaIngreso(new Date());
        user.setEdad(23);
    }
    @Test
    void listaUsuarios() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(userService.listaUsuarios());
    }
}