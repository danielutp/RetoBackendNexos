package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.mapper.MercanciaMappers;
import com.co.nexos.mercancia.repository.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Mercancia findByIdMercancia(Integer id){
        var mercancia = mercanciaRepository.findById(id);
        return mercancia.get();
    }

    @Override
    public Mercancia crearMercancia(MercanciaDto mercanciaDto) {
        Date date = new Date();
        if (mercanciaDto.getFechaIngreso().after(date)){
            throw new BadRequestException("La fecha debe ser menor a la actual");
        }
        Mercancia mercancia = MercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto);
        return mercanciaRepository.save(mercancia);
    }

    @Override
    public Mercancia actualizarMercancia(Integer id,Integer idUser, MercanciaDto mercanciaDto) {
        Date date = new Date();
        Mercancia mercancia = MercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto);
        mercancia.setId(id);
        if (mercancia.getFechaIngreso().after(date)) {
            throw new BadRequestException("La fecha debe ser menor a la actual");
        } else if (mercancia.getUsuario().getId().equals(idUser) && mercancia.getId() != null){
            mercancia.setFechaActualizacion(new Date());
            mercanciaRepository.save(mercancia);
        }
        return mercancia;
    }

    @Override
    public Mercancia eliminarMercancia(Integer id) {
        Mercancia mercancia = mercanciaRepository.findById(id).get();
        if (mercancia.getId() == null) {
            throw new BadRequestException ("No existe esa mercancia correctamente");
        }
        mercanciaRepository.delete(mercancia);
        return mercancia;
    }
}