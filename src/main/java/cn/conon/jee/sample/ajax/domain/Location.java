package cn.conon.jee.sample.ajax.domain;

public class Location {
	private int locationId;
	private String city;

	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", locationId=" + locationId + "]\n";
	}

}
