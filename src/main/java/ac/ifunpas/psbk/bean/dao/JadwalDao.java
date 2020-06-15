package ac.ifunpas.psbk.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ac.ifunpas.psbk.pojo.Jadwal;
import ac.ifunpas.psbk.pojo.Praktikum;
import ac.ifunpas.psbk.pojo.User;
import ac.ifunpas.psbk.utilities.DatabaseUtilities2;

@ManagedBean(name = "dtDataJadwal")
@SessionScoped
public class JadwalDao {

	@PostConstruct
	public List<Jadwal> lihatJadwal() throws SQLException {
		List<Jadwal> listJadwal;
		Connection con = DatabaseUtilities2.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM jadwal a JOIN praktikum b ON a.id_praktikum=b.id JOIN user c ON a.id_assistant=c.id_user");
			listJadwal = new ArrayList<>();
			while (rs.next()) {
				Jadwal jadwal = new Jadwal();
				jadwal.setId(rs.getInt("id"));
				jadwal.setIdAsisten(rs.getInt("id_assistant"));
				jadwal.setIdPraktikum(rs.getInt("id_praktikum"));
				jadwal.setNamaUser(rs.getString("name"));
				jadwal.setNamaPraktikum(rs.getString("mata_praktikum"));
				jadwal.setHariPraktikum(rs.getString("hari"));
				jadwal.setJamPraktikum(rs.getString("jam"));

				listJadwal.add(jadwal);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return listJadwal;
	}
	
	public List<User> lihatNamaAsisten() throws SQLException {
		List<User> listUser;
		Connection con = DatabaseUtilities2.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT id_user,name FROM user");
			listUser = new ArrayList<>();
			while (rs.next()) {
				User user= new User();
				user.setId(rs.getInt("id_user"));
				user.setName(rs.getString("name"));
				listUser.add(user);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return listUser;
	}
	
	public List<Praktikum> lihatNamaPraktikum() throws SQLException {
		List<Praktikum> listPraktikum;
		Connection con = DatabaseUtilities2.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT id,mata_praktikum,hari,jam FROM praktikum");
			listPraktikum = new ArrayList<>();
			while (rs.next()) {
				Praktikum praktikum = new Praktikum();
				praktikum.setId(rs.getInt("id"));
				praktikum.setMataPraktikum(rs.getString("mata_praktikum"));
				praktikum.setHari(rs.getString("hari"));
				praktikum.setJam("jam");
				listPraktikum.add(praktikum);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return listPraktikum;
	}

	public int tambahJadwal(Jadwal jadwal) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("INSERT INTO jadwal (id, id_assistant, id_praktikum) VALUES (?, ?, ?)");
			stat.setInt(1, jadwal.getId());
			stat.setInt(2, jadwal.getIdAsisten());
			stat.setInt(3, jadwal.getIdPraktikum());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int ubahJadwal(Jadwal jadwal) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("UPDATE jadwal SET id=?, id_assistant=?, id_praktikum=? WHERE id=?");
			stat.setInt(1, jadwal.getId());
			stat.setInt(2, jadwal.getIdAsisten());
			stat.setInt(3, jadwal.getIdPraktikum());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int hapusJadwal(int id) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("DELETE FROM jadwal WHERE id=?");
			stat.setInt(1, id);
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
