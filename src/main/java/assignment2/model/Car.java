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
	private int rating;
	private String licensePlate;
	private int ratePerKm;

	
	public Car() {
	}

	public Car(long id, ZonedDateTime dateCreated, String VIN, String make,
			   String model, String color, boolean convertible, int rating,
			   String licensePlate, int ratePerKm){
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
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
