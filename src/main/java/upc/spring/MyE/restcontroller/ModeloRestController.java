package upc.spring.MyE.restcontroller;

import java.io.Serializable;
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
import upc.spring.MyE.model.entity.Modelo;

import upc.spring.MyE.service.ModeloService;



@RestController
@RequestMapping("/modelos")
@Api(value = "REST para Modelos")
public class ModeloRestController implements Serializable {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModeloService ModeloServ;
	
	@ApiOperation("Fetch all Modelos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Modelo>> fetchAll(){
		try {
			List<Modelo> Modelos=ModeloServ.findAll();
			return new ResponseEntity<List<Modelo>>(Modelos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Modelo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Modelo")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Modelo Modelo){
		try {
			Modelo tmp=ModeloServ.save(Modelo);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Modelo")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Modelo Modelo){
		try {
			Optional<Modelo> buscado=ModeloServ.findById(Modelo.getModeloId());
			if(buscado.isPresent()) {
				ModeloServ.update(Modelo);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Modelos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			ModeloServ.deleteAll();
			return new ResponseEntity<String>("Modelos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Modelo by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modelo> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Modelo> Modelo=ModeloServ.findById(id);
			if(Modelo.isPresent()) {
				return new ResponseEntity<Modelo>(Modelo.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Modelo by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Modelo> Modelo=ModeloServ.findById(id);
			if(Modelo.isPresent()) {
				ModeloServ.deleteById(id);
				return new ResponseEntity<String>("Modelo eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
