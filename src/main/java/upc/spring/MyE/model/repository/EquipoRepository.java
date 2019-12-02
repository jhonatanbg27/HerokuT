package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Equipo;
import upc.spring.MyE.model.entity.Persona;

public interface EquipoRepository extends JpaRepository<Equipo, Integer>{

}
