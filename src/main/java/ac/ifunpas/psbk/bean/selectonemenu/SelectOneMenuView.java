package ac.ifunpas.psbk.bean.selectonemenu;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean(name = "selectOneMenuView")
@SessionScoped
public class SelectOneMenuView {
	private String city;
	private List<String> listCity;
	
	private String rtl;

	private String kota;
	private List<SelectItem> listKota;

	@PostConstruct
	public void init() {
		SelectItemGroup g1 = new SelectItemGroup("Jawa Barat");
		g1.setSelectItems(new SelectItem[] { new SelectItem("Bandung", "Bandung"), new SelectItem("Tasikmalaya", "Tasikmalaya"),
				new SelectItem("Cimahi", "Cimahi") });

		SelectItemGroup g2 = new SelectItemGroup("Jawa Tengah");
		g2.setSelectItems(new SelectItem[] { new SelectItem("Semarang", "Semarang"), new SelectItem("Surakarta", "Surakarta"),
				new SelectItem("Tegal", "Tegal") });

		listKota = new ArrayList<SelectItem>();
		listKota.add(g1);
		listKota.add(g2);
		listCity = new ArrayList<String>();
		listCity.add("Bandung");
		listCity.add("Jakarta");
		listCity.add("Surabaya");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getListCity() {
		return listCity;
	}

	public void setListCity(List<String> listCity) {
		this.listCity = listCity;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public List<SelectItem> getListKota() {
		return listKota;
	}

	public void setListKota(List<SelectItem> listKota) {
		this.listKota = listKota;
	}

	public String getRtl() {
		return rtl;
	}

	public void setRtl(String rtl) {
		this.rtl = rtl;
	}
}
