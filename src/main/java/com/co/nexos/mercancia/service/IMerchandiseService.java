package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Merchandise;
import com.co.nexos.mercancia.domain.MerchandiseDto;

import java.util.List;
import java.util.Optional;

public interface IMerchandiseService {
    public List<Merchandise> listMerchandise();

    public Optional<Merchandise> findByIdMerchandise(Integer id);
    public Merchandise createMerchandise(MerchandiseDto merchandiseDto);

    public Merchandise updateMerchandise(Integer id, Integer idUser, MerchandiseDto merchandiseDto);

    public Merchandise deleteMerchandise(Integer id, Integer idUser);

    public Merchandise findMerchandiseName(String name);
}
