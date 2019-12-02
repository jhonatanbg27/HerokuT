package upc.spring.MyE.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import upc.spring.MyE.model.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	@Query("SELECT p FROM Persona p WHERE p.NombreUsuario= :usuario and p.Psw = :Psw")
	Persona fetchByLogin(String usuario, String Psw);
}
