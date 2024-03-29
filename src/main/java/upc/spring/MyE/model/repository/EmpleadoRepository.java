package upc.spring.MyE.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Empleado;
import upc.spring.MyE.model.entity.Persona;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
