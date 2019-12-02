package upc.spring.MyE.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Null;

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

import com.sun.istack.Nullable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import upc.spring.MyE.model.entity.Persona;
import upc.spring.MyE.service.PersonaService;


@RestController
@RequestMapping("/personas")
@Api(value = "REST para Personas")
public class PersonaRestController {

	@Autowired
	private PersonaService PersonaServ;
	
	@ApiOperation("Fetch all Personas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> fetchAll(){
		try {
			List<Persona> Personas=PersonaServ.findAll();
			return new ResponseEntity<List<Persona>>(Personas,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Persona")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Persona Persona){
		try {
			Persona tmp=PersonaServ.save(Persona);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update Persona")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Persona Persona){
		try {
			Optional<Persona> buscado=PersonaServ.findById(Persona.getPersonaId());
			if(buscado.isPresent()) {
				PersonaServ.update(Persona);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @ApiOperation("Remove all Personas")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			PersonaServ.deleteAll();
			return new ResponseEntity<String>("Personas eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Persona by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Persona> Persona=PersonaServ.findById(id);
			if(Persona.isPresent()) {
				return new ResponseEntity<Persona>(Persona.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove Persona by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Persona> Persona=PersonaServ.findById(id);
			if(Persona.isPresent()) {
				PersonaServ.deleteById(id);
				return new ResponseEntity<String>("Persona eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("login")
	@GetMapping(value="/{usuario}/{contraseña}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> fetchByLogin(@PathVariable("usuario") String usuario, @PathVariable("contraseña") String contraseña){
		try {
			Persona persona = PersonaServ.fetchByLogin(usuario, contraseña);
			if(persona !=null)
				return new ResponseEntity<Persona>(persona, HttpStatus.OK);
			else {		
				persona=new Persona();
				persona.setPersonaId(-1);
				return new ResponseEntity<Persona>(persona, HttpStatus.OK);
				}
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
