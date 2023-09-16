package com.co.nexos.mercancia.repository;

import com.co.nexos.mercancia.domain.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Integer> {

    @Query(value = "SELECT m FROM Merchandise m WHERE m.nombre LIKE %:data% ")
    Merchandise findByName(@Param("data") String data);
}
