package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Modelo;
import upc.spring.MyE.model.entity.Modelo;
import upc.spring.MyE.model.repository.ModeloRepository;
import upc.spring.MyE.model.repository.ModeloRepository;
import upc.spring.MyE.service.ModeloService;
import upc.spring.MyE.service.ModeloService;

@Service
public class ModeloServiceImpl implements ModeloService{

	@Autowired
	private ModeloRepository ModeloRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Modelo> findAll() throws Exception {
		return ModeloRepo.findAll();
	}

	@Transactional
	@Override
	public Modelo save(Modelo t) throws Exception {
		return ModeloRepo.save(t);
	}

	@Transactional
	@Override
	public Modelo update(Modelo t) throws Exception {
		return ModeloRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Modelo> findById(Integer id) throws Exception {
		return ModeloRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ModeloRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		ModeloRepo.deleteAll();
	}

	

}