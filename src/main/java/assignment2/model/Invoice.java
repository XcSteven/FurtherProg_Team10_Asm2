package assignment2.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "invoice")
public class Invoice {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@CreatedDate
	private ZonedDateTime dateCreated;

	@Column
	private int totalCharge;

	public Invoice() {
	}

	public Invoice(long id, ZonedDateTime dateCreated, int totalCharge){
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
