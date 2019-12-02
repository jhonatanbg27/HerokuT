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
import upc.spring.MyE.model.entity.Ejemplar;
import upc.spring.MyE.service.EjemplarService;


@RestController
@RequestMapping("/ejemplares")
@Api(value = "REST para Ejemplars")
public class EjemplarRestController {

	@Autowired
	private EjemplarService EjemplarServ;
	
	@ApiOperation("Fetch all Ejemplars")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ejemplar>> fetchAll(){
		try {
			List<Ejemplar> Ejemplars=EjemplarServ.findAll();
			return new ResponseEntity<List<Ejemplar>>(Ejemplars,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Ejemplar>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Ejemplar")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Ejemplar Ejemplar){
		try {
			Ejemplar tmp=EjemplarServ.save(Ejemplar);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Ejemplar")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Ejemplar Ejemplar){
		try {
			Optional<Ejemplar> buscado=EjemplarServ.findById(Ejemplar.getEjemplarId());
			if(buscado.isPresent()) {
				EjemplarServ.update(Ejemplar);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Ejemplars")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			EjemplarServ.deleteAll();
			return new ResponseEntity<String>("Ejemplars eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Ejemplar by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ejemplar> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Ejemplar> Ejemplar=EjemplarServ.findById(id);
			if(Ejemplar.isPresent()) {
				return new ResponseEntity<Ejemplar>(Ejemplar.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Ejemplar>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Ejemplar>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Ejemplar by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Ejemplar> Ejemplar=EjemplarServ.findById(id);
			if(Ejemplar.isPresent()) {
				EjemplarServ.deleteById(id);
				return new ResponseEntity<String>("Ejemplar eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
