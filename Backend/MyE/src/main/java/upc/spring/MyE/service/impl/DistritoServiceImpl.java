package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Distrito;
import upc.spring.MyE.model.entity.Distrito;
import upc.spring.MyE.model.repository.DistritoRepository;
import upc.spring.MyE.model.repository.DistritoRepository;
import upc.spring.MyE.service.DistritoService;
import upc.spring.MyE.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService{

	@Autowired
	private DistritoRepository DistritoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Distrito> findAll() throws Exception {
		return DistritoRepo.findAll();
	}

	@Transactional
	@Override
	public Distrito save(Distrito t) throws Exception {
		return DistritoRepo.save(t);
	}

	@Transactional
	@Override
	public Distrito update(Distrito t) throws Exception {
		return DistritoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		return DistritoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		DistritoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		DistritoRepo.deleteAll();
	}

	

}