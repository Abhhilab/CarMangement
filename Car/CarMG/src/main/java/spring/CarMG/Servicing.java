package spring.CarMG;

public class Servicing {
	private Long id;
    private String servicingDate;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServicingDate() {
		return servicingDate;
	}
	public void setServicingDate(String servicingDate) {
		this.servicingDate = servicingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Servicing(Long id, String servicingDate, String status) {
		super();
		this.id = id;
		this.servicingDate = servicingDate;
		this.status = status;
	}


}
