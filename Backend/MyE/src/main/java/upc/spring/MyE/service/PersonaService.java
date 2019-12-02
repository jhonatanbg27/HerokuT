package upc.spring.MyE.service;

import org.springframework.data.jpa.repository.Query;

import upc.spring.MyE.model.entity.Persona;

public interface PersonaService extends CrudService<Persona, Integer> {
	Persona fetchByLogin(String usuario, String contraseña);
}
