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
import ac.ifunpas.psbk.bean.dao.PraktikumDao;
import ac.ifunpas.psbk.pojo.Praktikum;

@ManagedBean(name = "dtBasicPraktikum")
@SessionScoped
public class DtDataPraktikum extends BaseBean implements Serializable{
	private static List<Praktikum> listPraktikum;
	private Praktikum praktikum;
	private Praktikum selectedPraktikum;
	
	@PostConstruct
	public void init() {
		praktikum = new Praktikum();
		try {
			PraktikumDao con = new PraktikumDao();
			listPraktikum = con.lihatPraktikum();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
    
	public void addPraktikum(){
		PraktikumDao con = new PraktikumDao();

            try {
                con.tambahPraktikum(praktikum);
                listPraktikum.add(praktikum);
                reset();
                redirect("/ui/menu_praktikum/praktikum.xhtml");
            } catch (SQLException e) {
    			e.printStackTrace();
            }
	}
	
	public void deletePraktikum(int id) {
		PraktikumDao con = new PraktikumDao();

		if(id != 0) {
	        try {
	            con.hapusPraktikum(id);
	            reset();
	            redirect("/ui/menu_praktikum/praktikum.xhtml");
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
		} else {
			messageError("Data Kosong, Harap Isi!");
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


	public List<Praktikum> getListPraktikum() {
		return listPraktikum;
	}
	
	private void reset() {
		praktikum = new Praktikum();
	}
	
	public Praktikum getPraktikum() {
		return praktikum;
	}

	public void setPraktikum(Praktikum praktikum) {
		this.praktikum = praktikum;
	}

	public Praktikum getSelectedPraktikum() {
		return selectedPraktikum;
	}

	public void setSelectedPraktikum(Praktikum selectedPraktikum) {
		this.selectedPraktikum = selectedPraktikum;
	}
}
