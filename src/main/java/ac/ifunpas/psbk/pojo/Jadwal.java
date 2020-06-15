package ac.ifunpas.psbk.pojo;

public class Jadwal {
	
	private int id;
	private int idAsisten;
	private int idPraktikum;
	private String namaUser;
	private String namaPraktikum;
	private String hariPraktikum;
	private String jamPraktikum;

	public Jadwal() {
		
	}
	
	public Jadwal(int id, int idAsisten, int idPraktikum) {
		this.id = id;
		this.idAsisten = idAsisten;
		this.idPraktikum = idPraktikum;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAsisten() {
		return idAsisten;
	}

	public void setIdAsisten(int idAsisten) {
		this.idAsisten = idAsisten;
	}

	public int getIdPraktikum() {
		return idPraktikum;
	}

	public void setIdPraktikum(int idPraktikum) {
		this.idPraktikum = idPraktikum;
	}
	public String getNamaUser() {
		return namaUser;
	}

	public void setNamaUser(String namaUser) {
		this.namaUser = namaUser;
	}

	public String getNamaPraktikum() {
		return namaPraktikum;
	}

	public void setNamaPraktikum(String namaPraktikum) {
		this.namaPraktikum = namaPraktikum;
	}

	public String getHariPraktikum() {
		return hariPraktikum;
	}

	public void setHariPraktikum(String hariPraktikum) {
		this.hariPraktikum = hariPraktikum;
	}

	public String getJamPraktikum() {
		return jamPraktikum;
	}

	public void setJamPraktikum(String jamPraktikum) {
		this.jamPraktikum = jamPraktikum;
	}

}
