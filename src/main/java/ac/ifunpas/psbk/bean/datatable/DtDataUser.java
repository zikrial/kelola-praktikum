package ac.ifunpas.psbk.bean.datatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.IOException;
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
                redirect("/ui/menu_asisten/asisten.xhtml");
            } catch (SQLException e) {
    			e.printStackTrace();
            }
	}
	
	public void deleteAsisten(int id) {
		UserDao con = new UserDao();

		if(id != 0) {
	        try {
	            con.hapusUser(id);
	            reset();
	            redirect("/ui/menu_asisten/asisten.xhtml");
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
		} else {
			messageError("Data Kosong Harap Isi!");
		}
	}
	
	public String redirect(String inp_url) {
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		ExternalContext extContext = ctx.getExternalContext();
		String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, inp_url));
		try {

			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);

		}
		return null;

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
