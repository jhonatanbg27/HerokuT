package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Lugar;
import upc.spring.MyE.model.entity.Lugar;
import upc.spring.MyE.model.repository.LugarRepository;
import upc.spring.MyE.model.repository.LugarRepository;
import upc.spring.MyE.service.LugarService;
import upc.spring.MyE.service.LugarService;

@Service
public class LugarServiceImpl implements LugarService{

	@Autowired
	private LugarRepository LugarRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Lugar> findAll() throws Exception {
		return LugarRepo.findAll();
	}

	@Transactional
	@Override
	public Lugar save(Lugar t) throws Exception {
		return LugarRepo.save(t);
	}

	@Transactional
	@Override
	public Lugar update(Lugar t) throws Exception {
		return LugarRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Lugar> findById(Integer id) throws Exception {
		return LugarRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		LugarRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		LugarRepo.deleteAll();
	}

	

}