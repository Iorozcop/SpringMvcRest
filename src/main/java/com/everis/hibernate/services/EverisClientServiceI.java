package com.everis.hibernate.services;

import java.util.List;
import com.everis.hibernate.persistence.EverisClient;

/**
 * Servicio: gestión de clientes.
 * 
 * @author isa
 *
 */

public interface EverisClientServiceI {

	/**
	 * Método para insertar un cliente
	 * 
	 * @param entity
	 */
	public void insert(EverisClient entity);

	/**
	 * Método para mostrar todos los clientes
	 * 
	 * @return List<EverisClient>
	 */
	public List<EverisClient> searchAll();

	/**
	 * Método para buscar por id
	 * 
	 * @param id
	 * @return EverisClient
	 */
	public EverisClient getClientByIdClient(final long idClient);

	/**
	 * Método para eliminar un cliente
	 * 
	 * @param entity
	 */
	public void delete(EverisClient entity);
	
	/**
	 * Método para eliminar por id
	 * 
	 * @param idClient
	 */
	public void deleteById(final long idClient);

	/**
	 * Método para realizar un cambio en un cliente
	 * 
	 * @param entity
	 */
	public void update(EverisClient entity);

	/**
	 * Método para buscar por nombre y apellidos del cliente
	 * 
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return List<EverisClient>
	 */
	public List<EverisClient> getClientByNameAndFirstLastNameAndSecondLastName(final String name,
			final String firstLastName, final String secondLastName);

			
	/**
	 * Método para buscar por dni o nombre o primer o segundo apellido
	 * 
	 * @param dni
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return List<EverisClient>
	 */
	public List<EverisClient> getClientByDniOrNameOrFirstLastNameOrSecondLastName(final String dni, final String name,
			final String firstLastName, final String secondLastName);
	
}
