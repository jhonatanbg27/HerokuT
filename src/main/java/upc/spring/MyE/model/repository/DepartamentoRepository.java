package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Departamento;
import upc.spring.MyE.model.entity.Persona;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

}
