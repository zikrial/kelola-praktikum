package ac.ifunpas.psbk.pojo;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private int id_role;
	
//	public User(int id, String name, String email) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	
}
