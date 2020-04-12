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

import ac.ifunpas.psbk.pojo.User;
import ac.ifunpas.psbk.utilities.DatabaseUtilities2;

@ManagedBean(name = "dtDataUser")
@SessionScoped
public class UserDao {

	@PostConstruct
	public List<User> lihatUser() throws SQLException {
		List<User> listUser;
		Connection con = DatabaseUtilities2.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM user");
			listUser = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id_user"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

				listUser.add(user);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return listUser;
	}

	public int tambahUser(User user) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("INSERT INTO user (id_user, name, email, password, role_id) VALUES (?, ?, ?, ?, 2)");
			stat.setInt(1, user.getId());
			stat.setString(2, user.getName());
			stat.setString(3, user.getEmail());
			stat.setString(4, user.getPassword());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int ubahUser(User user) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("UPDATE user SET id_user=?, name=?, email=? WHERE id_user=?");
			stat.setInt(1, user.getId());
			stat.setString(2, user.getName());
			stat.setString(3, user.getEmail());
			stat.setInt(4, user.getId());
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public int hapusUser(int id) throws SQLException {
		Connection con = DatabaseUtilities2.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement("DELETE FROM user WHERE id_user=?");
			stat.setInt(1, id);
			return stat.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
