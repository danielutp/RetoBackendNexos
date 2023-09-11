package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.domain.Usuario;
import com.co.nexos.mercancia.mapper.MercanciaMappers;
import com.co.nexos.mercancia.repository.MercanciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MercanciaServiceTest {

    @Mock
    private MercanciaRepository mercanciaRepository;
    @InjectMocks
    private MercanciaService mercanciaService;
    @Mock
    private MercanciaMappers mercanciaMappers;

    private Mercancia mercancia;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        Date date = new Date(1995, 02, 27);

        MercanciaDto mercanciaDto = new MercanciaDto("Daniel",2,new Date(), new Usuario());
        mercanciaDto.setFechaIngreso(date);
        mercanciaDto.setNombre("Daniel");
        mercanciaDto.setCantidad(2);
        mercanciaDto.setFechaIngreso(new Date());
        mercanciaDto.setUsuario(new Usuario());

        mercancia = new Mercancia();
        mercancia.setId(1);
        mercancia.setCantidad(1);
        mercancia.setNombre("cliente");
        mercancia.setFechaIngreso(new Date());
        mercancia.setFechaActualizacion(null);
        mercancia.setUsuario(new Usuario());

        mercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto);
    }

    @Test
    void listaMercancias() {
        when(mercanciaRepository.findAll()).thenReturn(Arrays.asList(mercancia));
        assertNotNull(mercanciaService.listaMercancias());
    }

    @Test
    void findByIdMercancia() {
        when(mercanciaRepository.findById(mercancia.getId())).thenReturn(Optional.ofNullable(mercancia));
        assertNotNull(mercanciaService.findByIdMercancia(mercancia.getId()));
    }

    @Test
    void crearMercancia() {
        Mockito.when(mercanciaRepository.save(mercancia)).thenReturn(mercancia);
        MercanciaDto mercanciaDto = new MercanciaDto("Daniel",2,new Date(), new Usuario());
        Mockito.when(mercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto)).thenReturn(mercancia);
        assertNotNull(mercanciaService.crearMercancia(mercanciaDto));
    }

    @Test
    void actualizarMercancia() {
        Mockito.when(mercanciaRepository.findById(mercancia.getId())).thenReturn(Optional.ofNullable(mercancia));
        Mockito.when(mercanciaRepository.save(mercancia)).thenReturn(mercancia);
        MercanciaDto mercanciaDto = new MercanciaDto("Daniel",2,new Date(), new Usuario());
        Mockito.when(mercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto)).thenReturn(mercancia);

        Mercancia response = mercanciaService.actualizarMercancia(1,1,mercanciaDto);

        assertNotNull(response);
    }

    @Test
    void eliminarMercancia() {
        mercanciaRepository.deleteById(mercancia.getId());
        verify(mercanciaRepository,times(1)).deleteById(mercancia.getId());
    }
}