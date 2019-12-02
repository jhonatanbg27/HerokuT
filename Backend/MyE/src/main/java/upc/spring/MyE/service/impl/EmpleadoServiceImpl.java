package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Empleado;
import upc.spring.MyE.model.entity.Empleado;
import upc.spring.MyE.model.repository.EmpleadoRepository;
import upc.spring.MyE.model.repository.EmpleadoRepository;
import upc.spring.MyE.service.EmpleadoService;
import upc.spring.MyE.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository EmpleadoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findAll() throws Exception {
		return EmpleadoRepo.findAll();
	}

	@Transactional
	@Override
	public Empleado save(Empleado t) throws Exception {
		return EmpleadoRepo.save(t);
	}

	@Transactional
	@Override
	public Empleado update(Empleado t) throws Exception {
		return EmpleadoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Empleado> findById(Integer id) throws Exception {
		return EmpleadoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		EmpleadoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		EmpleadoRepo.deleteAll();
	}

	

}