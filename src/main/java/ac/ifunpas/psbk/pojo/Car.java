package ac.ifunpas.psbk.pojo;

public class Car {

	private String id;
	private Integer year;
	private String brand;
	private String color;

	public Car() {
		
	}

	public Car(String id, Integer year, String brand, String color) {
		this.id = id;
		this.year = year;
		this.brand = brand;
		this.color = color;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
