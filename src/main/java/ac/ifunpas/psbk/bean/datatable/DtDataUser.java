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

import java.io.Serializable;

import org.primefaces.event.RowEditEvent;

import ac.ifunpas.psbk.bean.BaseBean;
import ac.ifunpas.psbk.bean.dao.UserDao;
import ac.ifunpas.psbk.pojo.Car;
import ac.ifunpas.psbk.pojo.User;

@ManagedBean(name = "dtBasicUser")
@SessionScoped
public class DtDataUser extends BaseBean implements Serializable {

	private static List<User> listUser;
	private User user;
	private User selectedUser;
	
	@PostConstruct
	public void init() {
		user = new User();
		try {
			UserDao con = new UserDao();
			listUser = con.lihatUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
    
	public void addAsisten(){
		UserDao con = new UserDao();

            try {
                con.tambahUser(user);
                listUser.add(user);
                reset();
            } catch (SQLException e) {
    			e.printStackTrace();
            }
	}
	
	public void deleteAsisten(int id) {
		UserDao con = new UserDao();

        try {
            con.hapusUser(id);
            listUser.remove(user);
            reset();
        } catch (SQLException e) {
			e.printStackTrace();
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

	public List<User> getListUser() {
		return listUser;
	}
	
	private void reset() {
		user = new User();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

}
