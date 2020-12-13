package com.everis.hibernate.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.services.EverisClientServiceI;

/**
 * Controller gestión de clientes
 * 
 * @author isa
 *
 */

@Controller
public class EverisClientController {

	@Autowired
	private EverisClientServiceI clientService;

	/**
	 * Método para mostrar clientes
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showClientView")
	public String showClient(Model model) {

		// obtención de los clientes
		final List<EverisClient> clientList = clientService.searchAll();

		// carga de los clientes obtenidos
		model.addAttribute("clientListView", clientList);
		model.addAttribute("btnDropClient", false); // para controlar la visibilidad del botón en el html

		return "showClient";

	}

	/**
	 * Método para eliminar clientes
	 * 
	 * @param idCLient
	 * @param model
	 * @return
	 */
	@PostMapping("/actDropClient")
	public String deleteClient(@RequestParam String idCLient, Model model) {
		
		// Eliminación de cliente
		clientService.deleteById(Long.valueOf(idCLient));

		return "redirect:showClientView";
	}

	/**
	 * Método de búsqueda de clientes
	 * 
	 * @param searchedClient
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/searchClientBy")
	public String searchClientBy(@ModelAttribute EverisClient searchedClient, Model model) throws Exception {

		// Búsqueda por nombre, apellidos o dni

		List<EverisClient> clientList = new ArrayList<EverisClient>();

		final String clientDni = searchedClient.getDni();
		final String clientName = searchedClient.getName();
		final String clientFLN = searchedClient.getFirstLastName();
		final String clientSLN = searchedClient.getSecondLastName();
		
		
		if (StringUtils.hasText(clientDni) || (StringUtils.hasText(clientName) || StringUtils.hasText(clientFLN) || StringUtils.hasText(clientSLN))) {

			// Búsqueda por dni o nombre o apellidos.
			clientList = clientService.getClientByDniOrNameOrFirstLastNameOrSecondLastName(clientDni, clientName, clientFLN, clientSLN);

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		// carga de los clientes obtenidos
		model.addAttribute("clientListView", clientList);
		model.addAttribute("btnDropClient", true);

		return "showClient";

	}

	/**
	 * Método de insercción de nuevo cliente
	 * 
	 * @param newClient
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/actAddClient")
	public String submitAddClientForm(@Valid @ModelAttribute EverisClient newClient, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros erróneos.");

		} else {
			clientService.insert(newClient);
		}

		return "redirect:showClientView";
	}

}
