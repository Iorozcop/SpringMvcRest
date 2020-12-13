package com.everis.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller de página principal
 * 
 * @author isa
 *
 */

@Controller
@RequestMapping("/*")
public class EverisSystemController {
	
	/**
	 * Método que redirecciona a la página principal
	 * 
	 * @return
	 */
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	/**
	 * Método para redireccionar a la página de gestión de clientes
	 * 
	 * @return
	 */
	@GetMapping("/clientView")
	public String redirectToClientController() {
		return "redirect:showClientView";
	}
	
	/**
	 * Método para redireccionar a la página de buscar cliente
	 * 
	 * @return
	 */
	@GetMapping("/searchClientView")
	public String redirectToSearchClientController() {
		return "formSearchClientBy";
	}
	
	/**
	 * Método para redireccionar a la página de añadir nuevo cliente
	 * 
	 * @return
	 */
	@GetMapping("/newClientView")
	public String redirectToNewClientController() {
		return "newClient";
	}
}
