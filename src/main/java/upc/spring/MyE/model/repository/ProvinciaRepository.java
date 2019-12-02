package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Persona;
import upc.spring.MyE.model.entity.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
