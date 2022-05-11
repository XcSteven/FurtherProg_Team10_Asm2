package assignment2.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "driver")
public class Driver {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@CreatedDate
	private ZonedDateTime dateCreated;

	@Column
	private String license;
	private String phone;
	private int rating;

	public Driver() {
	}

	public Driver(long id, ZonedDateTime dateCreated, String license,
				   String phone, int rating){
		super();
		this.id = id;
		this.dateCreated = dateCreated;
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
