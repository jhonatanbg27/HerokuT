package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Equipo;
import upc.spring.MyE.model.repository.EquipoRepository;
import upc.spring.MyE.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService{

	@Autowired
	private EquipoRepository EquipoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Equipo> findAll() throws Exception {
		return EquipoRepo.findAll();
	}

	@Transactional
	@Override
	public Equipo save(Equipo t) throws Exception {
		return EquipoRepo.save(t);
	}

	@Transactional
	@Override
	public Equipo update(Equipo t) throws Exception {
		return EquipoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Equipo> findById(Integer id) throws Exception {
		return EquipoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		EquipoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		EquipoRepo.deleteAll();
	}

}