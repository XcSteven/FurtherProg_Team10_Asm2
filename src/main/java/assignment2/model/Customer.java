package assignment2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "customer")
public class Customer {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	@CreatedDate
	@Column(name = "created_date")
	@JsonFormat(pattern = "dd.MM.YYYY")
	@CreationTimestamp
	private ZonedDateTime dateCreated;

	@Column
	private String name;
	private String address;
	private String phone;


	public Customer() {
	}


	public Customer(long id, ZonedDateTime dateCreated, String name, String address, String phone) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	//Getters
	public long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
