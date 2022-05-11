package assignment2.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name= "customer")
public class Customer {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	@CreatedDate
	private ZonedDateTime dateCreated;

	@Column
	private String name;


	public Customer() {
	}


	public Customer(long id, ZonedDateTime dateCreated, String name){
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.name = name;
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
