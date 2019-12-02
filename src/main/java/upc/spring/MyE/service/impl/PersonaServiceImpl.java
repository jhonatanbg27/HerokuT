package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Persona;
import upc.spring.MyE.model.repository.PersonaRepository;
import upc.spring.MyE.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository PersonaRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Persona> findAll() throws Exception {
		return PersonaRepo.findAll();
	}

	@Transactional
	@Override
	public Persona save(Persona t) throws Exception {
		return PersonaRepo.save(t);
	}

	@Transactional
	@Override
	public Persona update(Persona t) throws Exception {
		return PersonaRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Persona> findById(Integer id) throws Exception {
		return PersonaRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		PersonaRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		PersonaRepo.deleteAll();
	}

	@Override
	public Persona fetchByLogin(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return PersonaRepo.fetchByLogin(usuario, contraseña);
	}

}