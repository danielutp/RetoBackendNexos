package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Merchandise;
import com.co.nexos.mercancia.dtos.MerchandiseDto;
import com.co.nexos.mercancia.domain.User;
import com.co.nexos.mercancia.mapper.MerchandiseMappers;
import com.co.nexos.mercancia.repository.MerchandiseRepository;
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

class MerchandiseServiceTest {

    @Mock
    private MerchandiseRepository merchandiseRepository;
    @InjectMocks
    private MerchandiseService mercanciaService;
    @Mock
    private MerchandiseMappers merchandiseMappers;

    private Merchandise merchandise;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        Date date = new Date(1995, 02, 27);

        MerchandiseDto merchandiseDto = new MerchandiseDto("Daniel",2,new Date(), new User());
        merchandiseDto.setFechaIngreso(date);
        merchandiseDto.setNombre("Daniel");
        merchandiseDto.setCantidad(2);
        merchandiseDto.setFechaIngreso(new Date());
        merchandiseDto.setUser(new User());

        merchandise = new Merchandise();
        merchandise.setId(1);
        merchandise.setCantidad(1);
        merchandise.setNombre("cliente");
        merchandise.setFechaIngreso(new Date());
        merchandise.setFechaActualizacion(null);
        merchandise.setUser(new User());

        merchandiseMappers.mercanciaDtoConvertirAMercancia(merchandiseDto);
    }

    @Test
    void listaMercancias() {
        when(merchandiseRepository.findAll()).thenReturn(Arrays.asList(merchandise));
        assertNotNull(mercanciaService.listMerchandise());
    }

    @Test
    void findByIdMercancia() {
        when(merchandiseRepository.findById(merchandise.getId())).thenReturn(Optional.ofNullable(merchandise));
        assertNotNull(mercanciaService.findByIdMerchandise(merchandise.getId()));
    }

    @Test
    void crearMercancia() {
        Mockito.when(merchandiseRepository.save(merchandise)).thenReturn(merchandise);
        MerchandiseDto merchandiseDto = new MerchandiseDto("Daniel",2,new Date(), new User());
        Mockito.when(merchandiseMappers.mercanciaDtoConvertirAMercancia(merchandiseDto)).thenReturn(merchandise);
        assertNotNull(mercanciaService.createMerchandise(merchandiseDto));
    }

    @Test
    void actualizarMercancia() {
        Mockito.when(merchandiseRepository.findById(merchandise.getId())).thenReturn(Optional.ofNullable(merchandise));
        Mockito.when(merchandiseRepository.save(merchandise)).thenReturn(merchandise);
        User user = new User();
        MerchandiseDto merchandiseDto = new MerchandiseDto("Daniel",2,new Date(), user);
        Mockito.when(merchandiseMappers.mercanciaDtoConvertirAMercancia(merchandiseDto)).thenReturn(merchandise);
    }

    @Test
    void eliminarMercancia() {
        merchandiseRepository.deleteById(merchandise.getId());
        verify(merchandiseRepository,times(1)).deleteById(merchandise.getId());
    }
}