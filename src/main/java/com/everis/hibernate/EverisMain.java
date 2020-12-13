package com.everis.hibernate;

import java.util.List;

/**
 * Clase Principal main
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.services.EverisClientServiceI;

@SpringBootApplication
public class EverisMain implements CommandLineRunner {

	/** Servicio cliente */

	@Autowired
	private EverisClientServiceI clientService;

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EverisMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de clientes
		EverisClient client1 = new EverisClient();
		client1.setName("José Manuel");
		client1.setFirstLastName("Orozco");
		client1.setSecondLastName("Puerto");
		client1.setDni("76688559K");

		EverisClient client2 = new EverisClient();
		client2.setName("Isabel");
		client2.setFirstLastName("Orozco");
		client2.setSecondLastName("Puerto");
		client2.setDni("75755887N");

		EverisClient client3 = new EverisClient();
		client3.setName("Noelia");
		client3.setFirstLastName("Galindo");
		client3.setSecondLastName("García");
		client3.setDni("76654569K");

		EverisClient client4 = new EverisClient();
		client4.setName("Dani");
		client4.setFirstLastName("Mateo");
		client4.setSecondLastName("Nogal");
		client4.setDni("76656769K");

		clientService.insert(client1);
		clientService.insert(client2);
		clientService.insert(client3);
		clientService.insert(client4);

		System.out.println("------------");

		// Obtención de un listado de todos los clientes
		final List<EverisClient> everisClientList = clientService.searchAll();
		if (!CollectionUtils.isEmpty(everisClientList)) {
			for (EverisClient client : everisClientList) {
				System.out.println(client.toString());
			}
		} else {
			System.out.println("No existen clientes");
		}

		System.out.println("------------");

		// Búsqueda de cliente por nombre y apellidos
		final List<EverisClient> everisClientByName = clientService
				.getClientByNameAndFirstLastNameAndSecondLastName("Dani", "Mateo", "Nogal");
		if (!CollectionUtils.isEmpty(everisClientByName)) {
			for (EverisClient client : everisClientByName) {
				System.out.println(client.toString());
			}
		} else {
			System.out.println("No existe ningún cliente con ese nombre");
		}

		System.out.println("------------");

		// Eliminación cliente
		clientService.delete(client2);

		// Actualización de clientes
		client3.setName("José Luís");
		client3.setSecondLastName("Mascareña");
		client3.setDni("31209545S");

		// Modificación de cliente3
		clientService.update(client3);

		// Búsqueda de cliente por id
		final EverisClient everisClientById = clientService.getClientByIdClient(3);

		System.out.println(everisClientById.toString());

	}

}
