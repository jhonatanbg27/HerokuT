package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Ejemplar;
import upc.spring.MyE.model.entity.Ejemplar;
import upc.spring.MyE.model.repository.EjemplarRepository;
import upc.spring.MyE.model.repository.EjemplarRepository;
import upc.spring.MyE.service.EjemplarService;
import upc.spring.MyE.service.EjemplarService;

@Service
public class EjemplarServiceImpl implements EjemplarService{

	@Autowired
	private EjemplarRepository EjemplarRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Ejemplar> findAll() throws Exception {
		return EjemplarRepo.findAll();
	}

	@Transactional
	@Override
	public Ejemplar save(Ejemplar t) throws Exception {
		return EjemplarRepo.save(t);
	}

	@Transactional
	@Override
	public Ejemplar update(Ejemplar t) throws Exception {
		return EjemplarRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Ejemplar> findById(Integer id) throws Exception {
		return EjemplarRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		EjemplarRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		EjemplarRepo.deleteAll();
	}

	

}