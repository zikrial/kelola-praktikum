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

import ac.ifunpas.psbk.pojo.Praktikum;
import ac.ifunpas.psbk.utilities.DatabaseUtilities2;

@ManagedBean(name = "dtDataPraktikum")
@SessionScoped
public class PraktikumDao {

	@PostConstruct
	public List<Praktikum> lihatPraktikum() throws SQLException {
		List<Praktikum> listPraktikum;
		Connection con = DatabaseUtilities2.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM praktikum");
			listPraktikum = new ArrayList<>();
			while (rs.next()) {
				Praktikum praktikum = new Praktikum();
				praktikum.setId(rs.getInt("id"));
				praktikum.setMataPraktikum(rs.getString("mata_praktikum"));
				praktikum.setRuangan(rs.getString("ruangan"));
				praktikum.setHari(rs.getString("hari"));
				praktikum.setJam(rs.getString("jam"));

				listPraktikum.add(praktikum);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return listPraktikum;
	}

	public int tambahPraktikum(Praktikum praktikum) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("INSERT INTO praktikum (id, mata_praktikum, ruangan, hari, jam) VALUES (?, ?, ?, ?, ?)");
			stat.setInt(1, praktikum.getId());
			stat.setString(2, praktikum.getMataPraktikum());
			stat.setString(3, praktikum.getRuangan());
			stat.setString(4, praktikum.getHari());
			stat.setString(5, praktikum.getJam());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int ubahPraktikum(Praktikum praktikum) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("UPDATE praktikum SET id=?, mata_praktikum=?, ruangan=?, hari=?, jam=? WHERE id=?");
			stat.setInt(1, praktikum.getId());
			stat.setString(2, praktikum.getMataPraktikum());
			stat.setString(3, praktikum.getRuangan());
			stat.setString(4, praktikum.getHari());
			stat.setString(5, praktikum.getJam());
			stat.setInt(6, praktikum.getId());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int hapusPraktikum(int id) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("DELETE FROM praktikum WHERE id=?");
			stat.setInt(1, id);
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
