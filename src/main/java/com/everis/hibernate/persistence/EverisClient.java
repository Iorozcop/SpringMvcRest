package com.everis.hibernate.persistence;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Entidad de cliente.
 * 
 * @author Isabel Orozco Puerto
 * 
 */
@Entity
@Table(name = "t_client")
public class EverisClient implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/**ID del cliente*/
	private long idCLient;
	
	/**Nombre cliente*/
	private String name;
	
	/**Apellido1 del cliente*/
	private String firstLastName;
	
	/**Apellido2 del cliente*/
	private String secondLastName;
	
	/**Dni cliente*/
	private String dni;

	
	// GETTER AND SETTER //
	
	/**
	 * @return the idCLient
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCLient")
	public long getIdCLient() {
		return idCLient;
	}

	/**
	 * @param idCLient the idCLient to set
	 */
	public void setIdCLient(long idCLient) {
		this.idCLient = idCLient;
	}

	/**
	 * @return the name
	 */
	@Column(name = "c_name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstLastName
	 */
	@Column(name = "c_first_last_name")
	public String getFirstLastName() {
		return firstLastName;
	}

	/**
	 * @param firstLastName the firstLastName to set
	 */
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	/**
	 * @return the secondLastName
	 */
	@Column(name = "c_second_Last_Name")
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * @param secondLastName the secondLastName to set
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * @return the dni
	 */
	
	@Column(name = "c_dni", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "idCLient = " + idCLient + ", name = " + name + ", firstLastName = " + firstLastName
				+ ", secondLastName = " + secondLastName + ", dni = " + dni ;
	}
		
}
