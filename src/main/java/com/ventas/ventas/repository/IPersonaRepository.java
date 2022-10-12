package com.ventas.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.ventas.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

}
