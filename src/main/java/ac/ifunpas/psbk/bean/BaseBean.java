package ac.ifunpas.psbk.bean;


import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


public class BaseBean {
	


	protected FacesContext fc() {
		return FacesContext.getCurrentInstance();
	}

	protected ExternalContext externalContext() {
		return fc().getExternalContext();
	}

	protected HttpServletRequest servletRequest() {
		return (HttpServletRequest) externalContext().getRequest();
	}

	protected void messageInfo(String message) {
		fc().addMessage("globalMessages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
	}

	protected void messageWarn(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
	}

	protected void messageError(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
	}

	protected void messageFatal(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
	}

	protected void messageInfoSaveDataSucces() {
		// message sukses ok bro
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proses simpan data sukses"));
	}

	protected void messageInfoUpdateDataSucces() {
		// message update sukses
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proses Update data sukses"));
	}

	protected void messageInfoDeleteDataSucces() {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Data telah dihapus"));
	}
		
}
