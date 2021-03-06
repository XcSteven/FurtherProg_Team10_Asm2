package assignment2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "driver")
public class Driver {
	
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
	private String license;
	private String phone;
	private double rating;

	@OneToOne
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	@JsonManagedReference

	private Car car;
	public Driver() {
	}

	public Driver(Long id, ZonedDateTime dateCreated, Car car, String license,
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
	public Long getId() {
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
	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "Driver{" +
				"id=" + id +
				", dateCreated=" + dateCreated +
				", license='" + license + '\'' +
				", phone='" + phone + '\'' +
				", rating=" + rating +
				", car=" + car +
				'}';
	}
}
