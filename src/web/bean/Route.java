package web.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ROUTE")
public class Route {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String startpoint;
	String endpoint;
	
	Date traveldate;

	public int getId() {
		return id;
	}

	public Date getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(Date date) {
		this.traveldate = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
