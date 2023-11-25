package spring.CarMG;

public class Car {
    private Long id;
    private String model;
    private String color;
    private String purchaseDate;
	public Car(Long id, String model, String color, String purchaseDate) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.purchaseDate = purchaseDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
