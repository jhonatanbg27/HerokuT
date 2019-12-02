package upc.spring.MyE.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import upc.spring.MyE.model.entity.Empleado;
import upc.spring.MyE.service.EmpleadoService;


@RestController
@RequestMapping("/empleados")
@Api(value = "REST para Empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService EmpleadoServ;
	
	@ApiOperation("Fetch all Empleados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleado>> fetchAll(){
		try {
			List<Empleado> Empleados=EmpleadoServ.findAll();
			return new ResponseEntity<List<Empleado>>(Empleados,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Empleado>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Empleado")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Empleado Empleado){
		try {
			Empleado tmp=EmpleadoServ.save(Empleado);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Empleado")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Empleado Empleado){
		try {
			Optional<Empleado> buscado=EmpleadoServ.findById(Empleado.getEmpleadoId());
			if(buscado.isPresent()) {
				EmpleadoServ.update(Empleado);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Empleados")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			EmpleadoServ.deleteAll();
			return new ResponseEntity<String>("Empleados eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Empleado by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Empleado> Empleado=EmpleadoServ.findById(id);
			if(Empleado.isPresent()) {
				return new ResponseEntity<Empleado>(Empleado.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Empleado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Empleado by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Empleado> Empleado=EmpleadoServ.findById(id);
			if(Empleado.isPresent()) {
				EmpleadoServ.deleteById(id);
				return new ResponseEntity<String>("Empleado eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
