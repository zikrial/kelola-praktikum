package ac.ifunpas.psbk.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;



@ManagedBean(name = "menuModelBean")
@SessionScoped
public class MenuModelBean extends BaseBean implements Serializable {



	private MenuModel menuModel;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	@PostConstruct
	public void init() {
		menuModel = new DefaultMenuModel();

		doListMenu();
	}



	private void doListMenu() {

		DefaultMenuItem beranda = new DefaultMenuItem();
		beranda.setUrl("/sample_jsf/faces/ui/home.xhtml");
		beranda.setValue("Beranda");
		beranda.setIcon("fa fa-server");

//		DefaultMenuItem asisten = new DefaultMenuItem();
//		beranda.setUrl("/173040027/faces/ui/datatable/row_expansion.xhtml");
//		beranda.setValue("Asisten");


		DefaultSubMenu asistenMenu = new DefaultSubMenu();
		asistenMenu.setLabel("Asisten");
//		
//		DefaultMenuItem commandButtonItem = new DefaultMenuItem();
//		commandButtonItem.setUrl("/173040027/faces/ui/button/command_button.xhtml");
//		commandButtonItem.setValue("Command Button");
//		buttonSubMenu.addElement(commandButtonItem);

		DefaultMenuItem commandButtonItem = new DefaultMenuItem();
		commandButtonItem.setUrl("/sample_jsf/faces/ui/menu_asisten/asisten.xhtml");
		commandButtonItem.setValue("Menu Asisten");
		asistenMenu.addElement(commandButtonItem);
		
//		DefaultMenuItem selectOneItem = new DefaultMenuItem();
//		selectOneItem.setUrl("/173040027/faces/ui/selectonemenu/selectonemenu_example_hk.xhtml");
//		selectOneItem.setValue("Select One Menu");
//		
//		DefaultSubMenu tableSubMenu = new DefaultSubMenu();
//		tableSubMenu.setLabel("Data Table");
//		
//		DefaultMenuItem tableBasicItem = new DefaultMenuItem();
//		tableBasicItem.setUrl("/173040027/faces/ui/datatable/basic.xhtml");
//		tableBasicItem.setValue("Basic");
//		tableSubMenu.addElement(tableBasicItem);
		
//		DefaultMenuItem tableSelectionItem = new DefaultMenuItem();
//		tableSelectionItem.setUrl("/173040027/faces/ui/datatable/selection.xhtml");
//		tableSelectionItem.setValue("Selection");
//		commandButtonItem.setIcon("fa fa-list-alt");
//		tableSubMenu.addElement(tableSelectionItem);
//		
//		DefaultMenuItem tableColumnesItem = new DefaultMenuItem();
//		tableColumnesItem.setUrl("/173040027/faces/ui/datatable/columns.xhtml");
//		tableColumnesItem.setValue("Columns");
//		tableSubMenu.addElement(tableColumnesItem);
//		
//		DefaultMenuItem tableFacetItem = new DefaultMenuItem();
//		tableFacetItem.setUrl("/173040027/faces/ui/datatable/facet.xhtml");
//		tableFacetItem.setValue("facet");
//		commandButtonItem.setIcon("fa fa-list-alt");
//		tableSubMenu.addElement(tableFacetItem);
//
//
//		DefaultMenuItem tableGroupItem = new DefaultMenuItem();
//		tableGroupItem.setUrl("/173040027/faces/ui/datatable/group.xhtml");
//		tableGroupItem.setValue("Group");
//		tableSubMenu.addElement(tableGroupItem);
//		
//		DefaultMenuItem tableEditItem = new DefaultMenuItem();
//		tableEditItem.setUrl("/173040027/faces/ui/datatable/edit.xhtml");
//		tableEditItem.setValue("Edit");
//		tableSubMenu.addElement(tableEditItem);
//		
//		DefaultMenuItem tableRowExpansionItem = new DefaultMenuItem();
//		tableRowExpansionItem.setUrl("/173040027/faces/ui/datatable/row_expansion.xhtml");
//		tableRowExpansionItem.setValue("Row Expansion");
//		tableSubMenu.addElement(tableRowExpansionItem);
//		
//		
//		DefaultMenuItem tableColorItem = new DefaultMenuItem();
//		tableColorItem.setUrl("/173040027/faces/ui/datatable/color.xhtml");
//		tableColorItem.setValue("Color");
//		tableSubMenu.addElement(tableColorItem);
//		
//		DefaultMenuItem tableFilterItem = new DefaultMenuItem();
//		tableFilterItem.setUrl("/173040027/faces/ui/datatable/filter.xhtml");
//		tableFilterItem.setValue("Filter");
//		tableSubMenu.addElement(tableFilterItem);
//		

		menuModel.addElement(beranda);
//		menuModel.addElement(asisten);
		menuModel.addElement(asistenMenu);
//		menuModel.addElement(selectOneItem);
//		menuModel.addElement(tableSubMenu);

	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	
}
