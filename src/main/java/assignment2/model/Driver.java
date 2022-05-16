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

	@OneToOne(mappedBy = "car")
	private Car car;

	@Column
	private String license;
	private String phone;
	private double rating;

	public Driver() {
	}

	public Driver(long id, ZonedDateTime dateCreated, String license,
				   String phone, double rating) {
		super();
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
