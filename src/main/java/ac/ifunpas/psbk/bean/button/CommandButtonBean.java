package ac.ifunpas.psbk.bean.button;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ac.ifunpas.psbk.bean.BaseBean;

@ManagedBean(name = "commandButtonBean")
@SessionScoped
public class CommandButtonBean extends BaseBean{
    public void buttonAction() {
        messageInfo("Command button diklik");
    }
}
