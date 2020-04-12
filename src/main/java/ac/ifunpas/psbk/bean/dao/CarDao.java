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

import ac.ifunpas.psbk.pojo.Car;
import ac.ifunpas.psbk.utilities.DatabaseUtilities;

@ManagedBean(name = "dtDataCar")
@SessionScoped
public class CarDao {

    @PostConstruct
    public List<Car> lihatCar() throws SQLException {
        List<Car> listCar;
        Connection con = DatabaseUtilities.getConnection();

        try {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM car");
            listCar = new ArrayList<>();
            while (rs.next()) {
                Car cr = new Car();
                cr.setId(rs.getString("id"));
                cr.setBrand(rs.getString("brand"));
                cr.setYear(rs.getInt("year"));
                cr.setColor(rs.getString("color"));

                listCar.add(cr);
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return listCar;
    }
    
    public int tambahCar(Car car) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try {
            PreparedStatement stat = con.prepareStatement("INSERT INTO car (id, brand, color, year) VALUES (?,?,?,?)");
            stat.setString(1, car.getId());
            stat.setString(2, car.getBrand());
            stat.setString(3, car.getColor());
            stat.setInt(4, car.getYear());
            return stat.executeUpdate();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
