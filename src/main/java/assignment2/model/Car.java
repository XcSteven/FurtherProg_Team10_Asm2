package assignment2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name= "car")
public class Car {
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
	private String vehicleId;
	private String make;
	private String model;
	private String color;
	private boolean convertible;
	private double rating;
	private String licensePlate;
	private double ratePerKm;

	private Long driverId;

	@OneToOne
	@JsonBackReference
	private Driver driver;

	public Car() {
	}

	public Car(Long id, ZonedDateTime dateCreated, String vehicleId, String make,
			   String model, String color, boolean convertible, double rating,
			   String licensePlate, double ratePerKm, Long driverId) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.vehicleId = vehicleId;
		this.make = make;
		this.model= model;
		this.color = color;
		this.convertible = convertible;
		this.rating = rating;
		this.licensePlate = licensePlate;
		this.ratePerKm = ratePerKm;
		this.driverId = driverId;
	}

	// Getters
	public Long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public boolean isConvertible() {
		return convertible;
	}
	public double getRating() {
		return rating;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public double getRatePerKm() {
		return ratePerKm;
	}

	public Long getDriverId(){return  driverId;}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public void setDriverId(Long driverId) {	this.driverId = driverId;}
}
