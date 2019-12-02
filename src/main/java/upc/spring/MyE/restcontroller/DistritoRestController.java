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
import upc.spring.MyE.model.entity.Distrito;
import upc.spring.MyE.service.DistritoService;


@RestController
@RequestMapping("/distritos")
@Api(value = "REST para Distritos")
public class DistritoRestController {

	@Autowired
	private DistritoService DistritoServ;
	
	@ApiOperation("Fetch all Distritos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Distrito>> fetchAll(){
		try {
			List<Distrito> Distritos=DistritoServ.findAll();
			return new ResponseEntity<List<Distrito>>(Distritos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Distrito>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Distrito")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Distrito Distrito){
		try {
			Distrito tmp=DistritoServ.save(Distrito);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Distrito")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Distrito Distrito){
		try {
			Optional<Distrito> buscado=DistritoServ.findById(Distrito.getDistritoId());
			if(buscado.isPresent()) {
				DistritoServ.update(Distrito);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Distritos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			DistritoServ.deleteAll();
			return new ResponseEntity<String>("Distritos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Distrito by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Distrito> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Distrito> Distrito=DistritoServ.findById(id);
			if(Distrito.isPresent()) {
				return new ResponseEntity<Distrito>(Distrito.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Distrito>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Distrito>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Distrito by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Distrito> Distrito=DistritoServ.findById(id);
			if(Distrito.isPresent()) {
				DistritoServ.deleteById(id);
				return new ResponseEntity<String>("Distrito eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
