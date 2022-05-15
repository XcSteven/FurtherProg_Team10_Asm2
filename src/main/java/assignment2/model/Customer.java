package assignment2.model;

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
	private ZonedDateTime dateCreated;

	@Column
	private String name;


	public Customer() {
	}


	public Customer(long id, ZonedDateTime dateCreated, String name) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.name = name;
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
}
