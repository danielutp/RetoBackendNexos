package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import com.co.nexos.mercancia.config.exceptions.NotFoundException;
import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.mapper.MercanciaMappers;
import com.co.nexos.mercancia.repository.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MercanciaService implements IMercanciaService{

    @Autowired
    private MercanciaRepository mercanciaRepository;

    private MercanciaMappers mercanciaMappers = new MercanciaMappers();

    @Override
    public List<Mercancia> listaMercancias() {
        return mercanciaRepository.findAll();
    }

    @Override
    public Optional<Mercancia> findByIdMercancia(Integer id){
        Optional<Mercancia> mercancia = mercanciaRepository.findById(id);
        if(mercancia.isEmpty()) throw new NotFoundException("Mercancia no encontrado");
        return mercancia;
    }

    @Override
    public Mercancia crearMercancia(MercanciaDto mercanciaDto) {
        Date date = new Date();
        if (mercanciaDto.getFechaIngreso().after(date)){
            throw new BadRequestException("La fecha debe ser menor a la actual");
        }
        Mercancia mercancia = mercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto);
        return mercanciaRepository.save(mercancia);
    }

    @Override
    public Mercancia actualizarMercancia(Integer id,Integer idUser, MercanciaDto mercanciaDto) {
        Date date = new Date();
        Mercancia mercancia = new Mercancia();
        try{
            mercancia = mercanciaRepository.findById(id).get();
        }catch (Exception e){
            throw new BadRequestException("La mercancia no existe");
        }
        if (!mercancia.getUsuario().getId().equals(idUser)) {
            throw new BadRequestException("No es el mismo usuario que lo creo");
        } else if (mercancia.getFechaIngreso().after(date)) {
            throw new BadRequestException("La fecha debe ser menor a la actual");
        }
        mercancia = mercanciaMappers.mercanciaDtoConvertirAMercancia(mercanciaDto);
        mercancia.setId(id);
        mercancia.setFechaActualizacion(new Date());
        mercanciaRepository.save(mercancia);
        return mercancia;
    }

    @Override
    public Mercancia eliminarMercancia(Integer id,Integer idUser) {
        Mercancia mercancia;
        try{
            mercancia = mercanciaRepository.findById(id).get();

        }catch (Exception e){
            throw new BadRequestException("La mercancia no existe");
        }
        if (!mercancia.getUsuario().getId().equals(idUser)) {
            throw new BadRequestException("No es el mismo usuario que lo creo");
        }
        mercancia.setFechaActualizacion(new Date());
        mercanciaRepository.delete(mercancia);
        return mercancia;
    }
}