package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Lugar;
import upc.spring.MyE.model.entity.Persona;

public interface LugarRepository extends JpaRepository<Lugar, Integer>{

}
