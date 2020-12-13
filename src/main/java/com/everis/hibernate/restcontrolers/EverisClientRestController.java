package com.everis.hibernate.restcontrolers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.services.EverisClientServiceI;

/**
 * RestController de Cliente
 * 
 * @author Isabel Orozco Puerto
 * 
 */

@RestController
@RequestMapping("/clients")
public class EverisClientRestController {

	/**
	 * Inyección del servicio
	 */
	@Autowired
	private EverisClientServiceI clientService;

	/**
	 * Método para mostrar todos los clientes
	 * 
	 * @return List<EverisClient>
	 */
	@GetMapping
	public List<EverisClient> getAllclients() {
		return clientService.searchAll();
	}

	/**
	 * Método para eliminar un cliente por id
	 * 
	 * @param idClient
	 */
	@DeleteMapping("/{idClient}")
	public void deleteClient(@PathVariable Long idClient) {
		clientService.deleteById(idClient);
	}

	/**
	 * Método para insertar un nuevo cliente
	 * 
	 * @param newClient
	 */
	@PutMapping("/client")
	public void addClient(@RequestBody EverisClient newClient) {
		clientService.insert(newClient);
	}

	/**
	 * Método para buscar por multiples campos
	 * @param searchedClient
	 * @return List<EverisClient>
	 * @throws Exception
	 */
	@GetMapping("/client")
	public List<EverisClient> searchBy(@RequestBody EverisClient searchedClient) throws Exception {

		// Búsqueda por nombre, apellidos o dni
		List<EverisClient> clientList = new ArrayList<EverisClient>();

		final String clientDni = searchedClient.getDni();
		final String clientName = searchedClient.getName();
		final String clientFLN = searchedClient.getFirstLastName();
		final String clientSLN = searchedClient.getSecondLastName();

		if (StringUtils.hasText(clientDni) || (StringUtils.hasText(clientName) || StringUtils.hasText(clientFLN)
				|| StringUtils.hasText(clientSLN))) {

			// Búsqueda por dni o nombre o apellidos.
			clientList = clientService.getClientByDniOrNameOrFirstLastNameOrSecondLastName(clientDni, clientName,
					clientFLN, clientSLN);

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		return clientList;
	}

}
