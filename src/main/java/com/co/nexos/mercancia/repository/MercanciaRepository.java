package com.co.nexos.mercancia.repository;

import com.co.nexos.mercancia.domain.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {
}
