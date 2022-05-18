package assignment2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name= "booking")
public class Booking {
	
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
	private String startLocation;
	private String endLocation;
	private String startTime;
	private String endTime;
	private double distance;

	private Long customer_id;
	@OneToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	@JsonManagedReference
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	@JsonBackReference
	private Customer customer;

	public Booking() {
	}

	public Booking(Long id, ZonedDateTime dateCreated, String startLocation,
				   String endLocation, String startTime, String endTime,
				   double distance, Long customer_id) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.distance = distance;
		this.customer_id = customer_id;
	}

	// Getters
	public Long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public double getDistance() {
		return distance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
}
