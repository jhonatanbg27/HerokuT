package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Orden;
import upc.spring.MyE.model.entity.Orden;
import upc.spring.MyE.model.repository.OrdenRepository;
import upc.spring.MyE.model.repository.OrdenRepository;
import upc.spring.MyE.service.OrdenService;
import upc.spring.MyE.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	private OrdenRepository OrdenRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Orden> findAll() throws Exception {
		return OrdenRepo.findAll();
	}

	@Transactional
	@Override
	public Orden save(Orden t) throws Exception {
		return OrdenRepo.save(t);
	}

	@Transactional
	@Override
	public Orden update(Orden t) throws Exception {
		return OrdenRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Orden> findById(Integer id) throws Exception {
		return OrdenRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		OrdenRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		OrdenRepo.deleteAll();
	}

	

}