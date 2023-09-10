package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.repository.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercanciaService implements IMercanciaService{

    @Autowired
    private MercanciaRepository mercanciaRepository;
    @Override
    public List<Mercancia> listaMercancias() {
        return mercanciaRepository.findAll();
    }

    @Override
    public Mercancia findByIdMercancia(Integer id) {
        var mercancia = mercanciaRepository.findById(id);
        return mercancia.get();
    }

    @Override
    public Mercancia crearMercancia(Mercancia mercancia) {
        return mercanciaRepository.save(mercancia);
    }

    @Override
    public Mercancia actualizarMercancia(Integer id, Mercancia mercancia) {
        mercancia.setId(id);
        return mercanciaRepository.save(mercancia);
    }

    @Override
    public Mercancia eliminarMercancia(Integer id) {
        return null;
    }
}
