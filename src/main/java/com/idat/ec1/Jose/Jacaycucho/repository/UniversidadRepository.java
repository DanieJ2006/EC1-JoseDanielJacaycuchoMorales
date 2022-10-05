package com.idat.ec1.Jose.Jacaycucho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec1.Jose.Jacaycucho.model.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer>{

}
