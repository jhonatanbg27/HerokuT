package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.entity.Cliente;
import upc.spring.MyE.model.repository.ClienteRepository;
import upc.spring.MyE.model.repository.ClienteRepository;
import upc.spring.MyE.service.ClienteService;
import upc.spring.MyE.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository ClienteRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		return ClienteRepo.findAll();
	}

	@Transactional
	@Override
	public Cliente save(Cliente t) throws Exception {
		return ClienteRepo.save(t);
	}

	@Transactional
	@Override
	public Cliente update(Cliente t) throws Exception {
		return ClienteRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		return ClienteRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ClienteRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		ClienteRepo.deleteAll();
	}

	

}