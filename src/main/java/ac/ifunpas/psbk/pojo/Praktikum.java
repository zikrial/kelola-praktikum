package ac.ifunpas.psbk.pojo;

public class Praktikum {
	
	private int id;
	private String mataPraktikum;
	private String ruangan;
	private String hari;
	private String jam;
	
	public Praktikum() {
		
	}
	
	public Praktikum(int id, String mataPraktikum, String ruangan, String hari, String jam) {
		this.id = id;
		this.mataPraktikum = mataPraktikum;
		this.ruangan = ruangan;
		this.hari = hari;
		this.jam = jam;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMataPraktikum() {
		return mataPraktikum;
	}
	public void setMataPraktikum(String mataPraktikum) {
		this.mataPraktikum = mataPraktikum;
	}
	public String getRuangan() {
		return ruangan;
	}
	public void setRuangan(String ruangan) {
		this.ruangan = ruangan;
	}
	public String getHari() {
		return hari;
	}
	public void setHari(String hari) {
		this.hari = hari;
	}
	public String getJam() {
		return jam;
	}
	public void setJam(String jam) {
		this.jam = jam;
	}
	
	
}
