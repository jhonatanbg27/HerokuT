package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Provincia;
import upc.spring.MyE.model.entity.Provincia;
import upc.spring.MyE.model.repository.ProvinciaRepository;
import upc.spring.MyE.model.repository.ProvinciaRepository;
import upc.spring.MyE.service.ProvinciaService;
import upc.spring.MyE.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

	@Autowired
	private ProvinciaRepository ProvinciaRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Provincia> findAll() throws Exception {
		return ProvinciaRepo.findAll();
	}

	@Transactional
	@Override
	public Provincia save(Provincia t) throws Exception {
		return ProvinciaRepo.save(t);
	}

	@Transactional
	@Override
	public Provincia update(Provincia t) throws Exception {
		return ProvinciaRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Provincia> findById(Integer id) throws Exception {
		return ProvinciaRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ProvinciaRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		ProvinciaRepo.deleteAll();
	}

	

}