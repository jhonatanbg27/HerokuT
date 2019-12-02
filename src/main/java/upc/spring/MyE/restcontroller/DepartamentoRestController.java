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
import upc.spring.MyE.model.entity.Departamento;
import upc.spring.MyE.service.DepartamentoService;


@RestController
@RequestMapping("/departamentos")
@Api(value = "REST para Departamentos")
public class DepartamentoRestController {

	@Autowired
	private DepartamentoService DepartamentoServ;
	
	@ApiOperation("Fetch all Departamentos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departamento>> fetchAll(){
		try {
			List<Departamento> Departamentos=DepartamentoServ.findAll();
			return new ResponseEntity<List<Departamento>>(Departamentos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Departamento>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Departamento")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Departamento Departamento){
		try {
			Departamento tmp=DepartamentoServ.save(Departamento);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Departamento")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Departamento Departamento){
		try {
			Optional<Departamento> buscado=DepartamentoServ.findById(Departamento.getDepartamentoId());
			if(buscado.isPresent()) {
				DepartamentoServ.update(Departamento);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Departamentos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			DepartamentoServ.deleteAll();
			return new ResponseEntity<String>("Departamentos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Departamento by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Departamento> Departamento=DepartamentoServ.findById(id);
			if(Departamento.isPresent()) {
				return new ResponseEntity<Departamento>(Departamento.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Departamento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Departamento by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Departamento> Departamento=DepartamentoServ.findById(id);
			if(Departamento.isPresent()) {
				DepartamentoServ.deleteById(id);
				return new ResponseEntity<String>("Departamento eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
