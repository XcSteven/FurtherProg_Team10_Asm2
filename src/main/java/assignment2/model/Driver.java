package assignment2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "driver")
public class Driver {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@CreatedDate
	@Column(name = "created_date")
	@JsonFormat(pattern = "dd.MM.YYYY")
	@CreationTimestamp
	private ZonedDateTime dateCreated;


	private String license;
	private String phone;
	private double rating;

	@OneToOne(mappedBy="driver")
	private Car car;
	public Driver() {
	}

	public Driver(long id, ZonedDateTime dateCreated, Car car, String license,
				   String phone, double rating) {
		super();
		this.car = car;
		this.id = id;
		this.dateCreated = dateCreated;
		this.license = license;
		this.phone = phone;
		this.rating = rating;
	}

	// Getters
	public long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public Car getCar() {
		return car;
	}

	public String getLicense() {
		return license;
	}
	public String getPhone() {
		return phone;
	}
	public double getRating() {
		return rating;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
