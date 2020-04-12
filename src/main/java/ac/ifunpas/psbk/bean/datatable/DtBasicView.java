package ac.ifunpas.psbk.bean.datatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ac.ifunpas.psbk.bean.dao.CarDao;
import ac.ifunpas.psbk.pojo.Car;
import ac.ifunpas.psbk.utilities.DatabaseUtilities;

@ManagedBean(name = "dtBasicView")
@SessionScoped
public class DtBasicView {

	private static List<Car> listCar;
	private static List<Car> selectedListCar;
	private static List<Car> filteredListCar;
	private Car selectedCar;

	@PostConstruct
	public void init() {
		try {
			CarDao con = new CarDao();
			listCar = con.lihatCar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		CarDao con = new CarDao();
//		listCar = con.lihatCar();

//		Car car1 = new Car();
//		car1.setId("001");
//		car1.setBrand("BMW");
//		car1.setYear(1999);
//		car1.setColor("Blue");
//
//		Car car2 = new Car();
//		car2.setId("002");
//		car2.setBrand("Mercedes");
//		car2.setYear(2005);
//		car2.setColor("Green");
//
//		Car car3 = new Car();
//		car3.setId("003");
//		car3.setBrand("Ferrari");
//		car3.setYear(1998);
//		car3.setColor("White");
//
//		Car car4 = new Car();
//		car4.setId("004");
//		car4.setBrand("Nissan");
//		car4.setYear(1800);
//		car4.setColor("Black");
//
//		Car car5 = new Car();
//		car5.setId("005");
//		car5.setBrand("Harley");
//		car5.setYear(2002);
//		car5.setColor("Grey");
//
//		listCar.add(car1);
//		listCar.add(car2);
//		listCar.add(car3);
//		listCar.add(car4);
//		listCar.add(car5);
		
	}
    
	public void add() {
		Car car6 = new Car();
		int kode = listCar.size()+1;
		car6.setId(Integer.toString(kode));
		
		car6.setBrand("BMW");
		car6.setYear(2010);
		car6.setColor("Grey");
		

		CarDao con = new CarDao();

            try {
                con.tambahCar(car6);
                listCar.add(car6);
            } catch (SQLException ex) {
            
            }
        }

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Car> getListCar() {
		return listCar;
	}

	public static List<Car> getSelectedListCar() {
		return selectedListCar;
	}

	public static void setSelectedListCar(List<Car> selectedListCar) {
		DtBasicView.selectedListCar = selectedListCar;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public static List<Car> getFilteredListCar() {
		return filteredListCar;
	}

	public static void setFilteredListCar(List<Car> filteredListCar) {
		DtBasicView.filteredListCar = filteredListCar;
	}

}
