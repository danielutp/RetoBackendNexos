package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import com.co.nexos.mercancia.config.exceptions.NotFoundException;
import com.co.nexos.mercancia.domain.Merchandise;
import com.co.nexos.mercancia.domain.MerchandiseDto;
import com.co.nexos.mercancia.mapper.MerchandiseMappers;
import com.co.nexos.mercancia.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService implements IMerchandiseService {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    private final MerchandiseMappers merchandiseMappers = new MerchandiseMappers();

    @Override
    public List<Merchandise> listMerchandise() {
        return merchandiseRepository.findAll();
    }

    @Override
    public Optional<Merchandise> findByIdMerchandise(Integer id){
        Optional<Merchandise> mercancia = merchandiseRepository.findById(id);
        if(mercancia.isEmpty()) throw new NotFoundException("Mercancia no encontrado");
        return mercancia;
    }

    @Override
    public Merchandise createMerchandise(MerchandiseDto merchandiseDto) {
        Date date = new Date();
        if (merchandiseDto.getFechaIngreso().after(date)){
            throw new BadRequestException("La fecha debe ser menor a la actual");
        }
        Merchandise merchandise = merchandiseMappers.mercanciaDtoConvertirAMercancia(merchandiseDto);
        return merchandiseRepository.save(merchandise);
    }

    @Override
    public Merchandise updateMerchandise(Integer id, Integer idUser, MerchandiseDto merchandiseDto) {
        Date date = new Date();
        Merchandise merchandise;
        try{
            merchandise = merchandiseRepository.findById(id).get();
        }catch (Exception e){
            throw new BadRequestException("La mercancia no existe");
        }
        if (!merchandise.getUser().getId().equals(idUser)) {
            throw new BadRequestException("No es el mismo usuario que lo creo");
        } else if (merchandise.getFechaIngreso().after(date)) {
            throw new BadRequestException("La fecha debe ser menor a la actual");
        }
        merchandise = merchandiseMappers.mercanciaDtoConvertirAMercancia(merchandiseDto);
        merchandise.setId(id);
        merchandise.setFechaActualizacion(new Date());
        merchandiseRepository.save(merchandise);
        return merchandise;
    }

    @Override
    public Merchandise deleteMerchandise(Integer id, Integer idUser) {
        Merchandise merchandise;
        try{
            merchandise = merchandiseRepository.findById(id).get();

        }catch (Exception e){
            throw new BadRequestException("La mercancia no existe");
        }
        if (!merchandise.getUser().getId().equals(idUser)) {
            throw new BadRequestException("No es el mismo usuario que lo creo");
        }
        merchandise.setFechaActualizacion(new Date());
        merchandiseRepository.delete(merchandise);
        return merchandise;
    }

    @Override
    public Merchandise findMerchandiseName(String dataToSearch) {
        Merchandise merchandise;
        try{
            merchandise = merchandiseRepository.findByName(dataToSearch);
        }catch (Exception e){
            throw new BadRequestException("No hay mercancia con ese nombre");
        }
        return merchandise;

    }
}