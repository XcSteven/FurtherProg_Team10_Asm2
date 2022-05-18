package assignment2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name= "customer")
public class Customer {
	
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
	private String name;
	private String address;
	private String phone;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Set<Booking> bookings;

	public Customer() {
	}


	public Customer(Long id, ZonedDateTime dateCreated, String name, String address, String phone) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	//Getters
	public Long getId() {
		return id;
	}
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public Set<Booking> getBookings() {
		return bookings;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setBookings(Booking booking) {
		this.bookings.add(booking);
	}
}
