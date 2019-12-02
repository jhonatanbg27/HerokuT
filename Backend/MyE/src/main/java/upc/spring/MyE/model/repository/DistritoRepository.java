package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Distrito;
import upc.spring.MyE.model.entity.Persona;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>{

}
