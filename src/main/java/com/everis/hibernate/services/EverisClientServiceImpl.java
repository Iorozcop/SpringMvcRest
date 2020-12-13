package com.everis.hibernate.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.persistence.EverisClientRepositoryI;

/**
 * Clase de implementación de Servicio
 * 
 * @author Isabel Orozco Puerto
 * 
 */
@Service
public class EverisClientServiceImpl implements EverisClientServiceI {

	/** Repositorio: t_client */
	@Autowired
	private EverisClientRepositoryI clientRepository;

	@Override
	public void insert(EverisClient entity) {
		clientRepository.save(entity);
	}

	@Override
	public List<EverisClient> searchAll() {
		return clientRepository.findAll();
	}

	@Override
	public EverisClient getClientByIdClient(final long idClient) {
		final EverisClient client = clientRepository.findByIdCLient(idClient);
		return client;
	}

	@Override
	public void delete(EverisClient entity) {
		clientRepository.delete(entity);
	}
	
	@Override
	public void deleteById(final long idClient) {
		clientRepository.deleteById(idClient);
	}

	@Override
	public void update(EverisClient entity) {
		clientRepository.save(entity);
	}

	@Override
	public List<EverisClient> getClientByNameAndFirstLastNameAndSecondLastName(final String name,
			final String firstLastName, final String secondLastName) {
		List<EverisClient> list = clientRepository.findByNameAndFirstLastNameAndSecondLastName(name, firstLastName,
				secondLastName);
		return list;
	}
	
	@Override
	public List<EverisClient> getClientByDniOrNameOrFirstLastNameOrSecondLastName(String dni, String name,
			String firstLastName, String secondLastName) {
		List<EverisClient> list = clientRepository.findByDniOrNameOrFirstLastNameOrSecondLastName(dni, name, firstLastName, secondLastName);
		return list;
	}

}
