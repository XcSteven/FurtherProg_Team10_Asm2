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
	private double totalCharge;

	public Invoice() {
	}

	public Invoice(long id, ZonedDateTime dateCreated, double totalCharge) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.totalCharge = totalCharge;
	}

	// Getters
	public long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public double getTotalCharge() {
		return totalCharge;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
}
