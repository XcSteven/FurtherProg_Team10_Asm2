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
	private int distance;

	public Booking() {
	}

	public Booking(long id, ZonedDateTime dateCreated, String startLocation,
				   String endLocation, ZonedDateTime pickup, ZonedDateTime dropoff,
				   int distance){
		super();
		this.id = id;
		this.dateCreated = dateCreated;
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
