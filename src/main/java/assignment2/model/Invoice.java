package assignment2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "invoice")
public class Invoice {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	@Column(name = "created_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@CreationTimestamp
	private ZonedDateTime dateCreated;

	@Column
	private double totalCharge;

	@OneToOne
	@JsonBackReference
	private Booking booking;
	public Invoice() {
	}

	public Invoice(Long id, ZonedDateTime dateCreated, double totalCharge) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.totalCharge = totalCharge;
	}

	// Getters
	public Long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public double getTotalCharge() {
		return totalCharge;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}
}
