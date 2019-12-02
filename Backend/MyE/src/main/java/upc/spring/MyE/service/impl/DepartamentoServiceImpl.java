package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Departamento;
import upc.spring.MyE.model.entity.Departamento;
import upc.spring.MyE.model.repository.DepartamentoRepository;
import upc.spring.MyE.model.repository.DepartamentoRepository;
import upc.spring.MyE.service.DepartamentoService;
import upc.spring.MyE.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoRepository DepartamentoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Departamento> findAll() throws Exception {
		return DepartamentoRepo.findAll();
	}

	@Transactional
	@Override
	public Departamento save(Departamento t) throws Exception {
		return DepartamentoRepo.save(t);
	}

	@Transactional
	@Override
	public Departamento update(Departamento t) throws Exception {
		return DepartamentoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Departamento> findById(Integer id) throws Exception {
		return DepartamentoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		DepartamentoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		DepartamentoRepo.deleteAll();
	}

	

}