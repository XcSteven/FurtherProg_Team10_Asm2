package assignment2.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "booking")
public class Booking {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	@CreatedDate
	private ZonedDateTime dateCreated;

	@Column
	private String startLocation;
	private String endLocation;
	private ZonedDateTime pickup;
	private ZonedDateTime dropoff;
	private double distance;

	public Booking() {
	}

	public Booking(long id, ZonedDateTime dateCreated, String startLocation,
				   String endLocation, ZonedDateTime pickup, ZonedDateTime dropoff,
				   double distance) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.distance = distance;
	}

	// Getters
	public long getId() {
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
	public ZonedDateTime getPickup() {
		return pickup;
	}
	public ZonedDateTime getDropoff() {
		return dropoff;
	}
	public double getDistance() {
		return distance;
	}

	// Setters
	public void setId(int id) {
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
	public void setPickup(ZonedDateTime pickup) {
		this.pickup = pickup;
	}
	public void setDropoff(ZonedDateTime dropoff) {
		this.dropoff = dropoff;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}