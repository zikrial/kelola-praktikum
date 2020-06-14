package ac.ifunpas.psbk.bean.datatable;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import ac.ifunpas.psbk.bean.BaseBean;
import ac.ifunpas.psbk.bean.dao.JadwalDao;
import ac.ifunpas.psbk.pojo.Jadwal;
import ac.ifunpas.psbk.pojo.Praktikum;
import ac.ifunpas.psbk.pojo.User;

@ManagedBean(name = "dtBasicJadwal")
@SessionScoped
public class DtDataJadwal extends BaseBean implements Serializable{
	private static List<Jadwal> listJadwal;
	private static List<User> listUser;
	private static List<Praktikum> listPraktikum;
	private Jadwal jadwal;
	private Jadwal selectedJadwal;
	private User user;
	private Praktikum praktikum;
	
	@PostConstruct
	public void init() {
		jadwal = new Jadwal();
		try {
			JadwalDao con = new JadwalDao();
			listJadwal = con.lihatJadwal();
			listPraktikum = con.lihatNamaPraktikum();
			listUser = con.lihatNamaAsisten();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
    
	public void addJadwal(){
		JadwalDao con = new JadwalDao();

            try {
                con.tambahJadwal(jadwal);
                listJadwal.add(jadwal);
                reset();
                redirect("/ui/menu_jadwal/jadwal.xhtml");
            } catch (SQLException e) {
    			e.printStackTrace();
            }
	}
	
	public void deleteJadwal(int id) {
		JadwalDao con = new JadwalDao();

        try {
            con.hapusJadwal(id);
            reset();
            redirect("/ui/menu_jadwal/jadwal.xhtml");
        } catch (SQLException e) {
			e.printStackTrace();
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


	public List<Jadwal> getListJadwal() {
		return listJadwal;
	}

	public List<User> getListUser() {
		return listUser;
	}
	
	public List<Praktikum> getListPraktikum() {
		return listPraktikum;
	}
	
	private void reset() {
		jadwal = new Jadwal();
	}
	
	public Jadwal getjadwal() {
		return jadwal;
	}

	public void setJadwal(Jadwal jadwal) {
		this.jadwal = jadwal;
	}

	public Jadwal getSelectedJadwal() {
		return selectedJadwal;
	}

	public void setSelectedJadwal(Jadwal selectedJadwal) {
		this.selectedJadwal = selectedJadwal;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Praktikum getPraktikum() {
		return praktikum;
	}

	public void setPraktikum(Praktikum praktikum) {
		this.praktikum = praktikum;
	}

}
