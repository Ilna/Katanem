package gr.hua.dit.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement(name = "Cars")
@Entity
@Table(name = "Cars")
public class Cars implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	
	
	   @Id
	   @Column(name = "Plates")
	   private String plates;

	   @Column(name = "Year")
	   private int year;

	   @Column(name = "Cubic")
	   private int cubic;

	   @Column(name = "Type")
	   private String type;
	   
	   @Column(name="Color")
	   private String color;
	   
	   @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
               CascadeType.DETACH, CascadeType.REFRESH})
@JoinColumn(name="OwnerId")
@JsonIgnore
private Customer customer;

	   
	public Cars() {
		super();
	}

	public Cars(String plates, int year, int cubic, String type, String color) {
		super();
		this.plates = plates;
		this.year = year;
		this.cubic = cubic;
		this.type = type;
		this.color = color;
	}

	public String getPlates() {
		return plates;
	}

	public void setPlates(String plates) {
		this.plates = plates;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCubic() {
		return cubic;
	}

	public void setCubic(int cubic) {
		this.cubic = cubic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cars [plates=" + plates + ", year=" + year + ", cubic=" + cubic + ", type=" + type + ", color=" + color
				+ ", ownerId="+ "]";
	}

		   
	   
}
	   