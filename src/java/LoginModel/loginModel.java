/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginModel;

import Dao.LoginDao;
import Domain.Login;
import LocationDao.GenericDao;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class loginModel {
    private Login log = new Login();
    private List<Login> logList = new GenericDao().FindAll(Login.class);
    private String uname = new String();
    private String psd = new String();
    
    public String searchingCredentials() throws IOException {
            String msg = "";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Login us = checkUser(psd, uname);
        Optional<Login> op = Optional.ofNullable(log);
         if (op.isPresent()) {
            if (us.getRoleType().equals("admin")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", log);
                ec.redirect(ec.getRequestContextPath() + "/faces/startbootstrap-sb-admin-2-gh-pages/index.xhtml");
                return "faces/startbootstrap-sb-admin-2-gh-pages/index.xhtml?faces-redirect=true";
            }  else if (us.getRoleType().equals("Patient")) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", log);
                ec.redirect(ec.getRequestContextPath() + "/faces/startbootstrap-sb-admin-2-gh-pages/index_2.xhtml");
                return "faces/startbootstrap-sb-admin-2-gh-pages/index_2.xhtml?faces-redirect=true";
            } else if (us.getRoleType().equals("Manager")) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", log);
                ec.redirect(ec.getRequestContextPath() + "/faces/startbootstrap-sb-admin-2-gh-pages/ManagerDashboard.xhtml");
                return "faces/startbootstrap-sb-admin-2-gh-pages/AddHM.xhtml?faces-redirect=true";
            } else if (us.getRoleType().equals("Doctor")) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", log);
                ec.redirect(ec.getRequestContextPath() + "/faces/startbootstrap-sb-admin-2-gh-pages/DoctViewAppointment.xhtml");
                return "faces/startbootstrap-sb-admin-2-gh-pages/Appointment.xhtml?faces-redirect=true";
            }
            
            else {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", log);
                ec.redirect(ec.getRequestContextPath() + "/faces/Logg/index.xhtml");
                return "faces/Logg/index.xhtml?faces-redirect=true";
            }
        } else {
            ec.redirect(ec.getRequestContextPath() + "/faces/Admin/index.xhtml");
        }
        return msg;
    }

    public Login checkUser(String psw, String un) {
        List<Login> u = new LoginDao().login(psw, un);
        if (!u.isEmpty()) {
            return u.get(0);
        } else {
            return null;
        }
    }

    public Login getLog() {
        return log;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    public List<Login> getLogList() {
        return logList;
    }

    public void setLogList(List<Login> logList) {
        this.logList = logList;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
    public void login(){
   RequestContext context=RequestContext.getCurrentInstance();
   context.execute("swal('Login Success!','You are Logged in!','Success')");
   }
    
}
