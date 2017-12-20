package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Customer")
@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	
	
	 @Id
	   @Column(name = "IdentityNumber")
	   private String identityNumber;

	   @Column(name = "Name")
	   private String name;

	   @Column(name = "Surname")
	   private String surname;

	   @Column(name = "TaxNumber")
	   private int taxNumber;
	   
	   @Column(name="DateCarLicence")
	   private String DateCarLicence;
	   
	   @Column(name = "History")
	   private String history;
	   
	   

	
	public Customer(String identityNumber, String name, String surname, int taxNumber, String dateCarLicence,
			String history) {
		super();
		this.identityNumber = identityNumber;
		this.name = name;
		this.surname = surname;
		this.taxNumber = taxNumber;
		DateCarLicence = dateCarLicence;
		this.history = history;
	}




	public Customer() {
		
	}




	public String getIdentityNumber() {
		return identityNumber;
	}




	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSurname() {
		return surname;
	}




	public void setSurname(String surname) {
		this.surname = surname;
	}




	public int getTaxNumber() {
		return taxNumber;
	}




	public void setTaxNumber(int taxNumber) {
		this.taxNumber = taxNumber;
	}




	public String getDateCarLicence() {
		return DateCarLicence;
	}




	public void setDateCarLicence(String dateCarLicence) {
		DateCarLicence = dateCarLicence;
	}




	public String getHistory() {
		return history;
	}




	public void setHistory(String history) {
		this.history = history;
	}

	
	

	   
}
