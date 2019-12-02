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
import upc.spring.MyE.model.entity.Provincia;
import upc.spring.MyE.service.ProvinciaService;


@RestController
@RequestMapping("/provincias")
@Api(value = "REST para Provincias")
public class ProvinciaRestController {

	@Autowired
	private ProvinciaService ProvinciaServ;
	
	@ApiOperation("Fetch all Provincias")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Provincia>> fetchAll(){
		try {
			List<Provincia> Provincias=ProvinciaServ.findAll();
			return new ResponseEntity<List<Provincia>>(Provincias,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Provincia>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Provincia")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Provincia Provincia){
		try {
			Provincia tmp=ProvinciaServ.save(Provincia);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Provincia")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Provincia Provincia){
		try {
			Optional<Provincia> buscado=ProvinciaServ.findById(Provincia.getProvinciaId());
			if(buscado.isPresent()) {
				ProvinciaServ.update(Provincia);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Provincias")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			ProvinciaServ.deleteAll();
			return new ResponseEntity<String>("Provincias eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Provincia by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Provincia> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Provincia> Provincia=ProvinciaServ.findById(id);
			if(Provincia.isPresent()) {
				return new ResponseEntity<Provincia>(Provincia.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Provincia>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Provincia>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Provincia by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Provincia> Provincia=ProvinciaServ.findById(id);
			if(Provincia.isPresent()) {
				ProvinciaServ.deleteById(id);
				return new ResponseEntity<String>("Provincia eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
