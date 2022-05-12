package assignment2.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "car")
public class Car {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@CreatedDate
	private ZonedDateTime dateCreated;

	@Column
	private String VIN;
	private String make;
	private String model;
	private String color;
	private boolean convertible;
	private double rating;
	private String licensePlate;
	private double ratePerKm;

	
	public Car() {
	}

	public Car(long id, ZonedDateTime dateCreated, String VIN, String make,
			   String model, String color, boolean convertible, double rating,
			   String licensePlate, double ratePerKm) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.VIN = VIN;
		this.make = make;
		this.model= model;
		this.color = color;
		this.convertible = convertible;
		this.rating = rating;
		this.licensePlate = licensePlate;
		this.ratePerKm = ratePerKm;
	}

	// Getters
	public long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public String getVIN() {
		return VIN;
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

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setVIN(String VIN) {
		this.VIN = VIN;
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
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public void setRatePerKm(int ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
}