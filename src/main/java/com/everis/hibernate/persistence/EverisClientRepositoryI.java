package com.everis.hibernate.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio: gestión de clientes.
 * 
 * @author isa
 *
 */

@Repository
public interface EverisClientRepositoryI extends JpaRepository<EverisClient, Long> {

	/**
	 * Método que obtiene un cliente por id
	 * 
	 * @param idCLient
	 * @return EverisClient
	 */
	public EverisClient findByIdCLient(final long idClient);

	/**
	 * Método que obtiene un cliente por nombre y apellidos
	 * 
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return List<EverisClient>
	 */
	public List<EverisClient> findByNameAndFirstLastNameAndSecondLastName(final String name, final String firstLastName,
			final String secondLastName);
	

	/**
	 * Método que obtiene un cliente por dni o por nombre o primer o segundo apellido
	 * 
	 * @param dni
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return
	 */
	public List<EverisClient> findByDniOrNameOrFirstLastNameOrSecondLastName(final String dni,final String name, final String firstLastName,
			final String secondLastName);
	

}
