/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.NotificationDao;
import Domain.Notification;
import static Modle.MouthlyModel.ACCOUNT_SID;
import static Modle.MouthlyModel.AUTH_TOKEN;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CarineU
 */
@ManagedBean
@SessionScoped
public class NotifiedModel {
    private Notification notails=new Notification();
    List<Notification> Listnot = new NotificationDao().findAll(Notification.class);
    Notification notifier = new Notification();
    String messages = new String();
  NotificationDao moDao=new NotificationDao();
     List<Notification> po = new ArrayList<>();
    private String searchKey=new String();
    
    public static final String ACCOUNT_SID = "AC47420e584fddd10be40ff0d375f03bc2";
    public static final String AUTH_TOKEN = "af193fad729a70c877e55683f8c50425";
   @PostConstruct
  public void init(){
  Listnot= new NotificationDao().findAll(Notification.class);
    
}
  public void createNotification(){
  
   messages = new  NotificationDao().save(notifier);
//        Listmothy = new MothDao().findAll(Monthly.class);
//        monthly = new  Monthly();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(notifier.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("+13475073429"), "Doctor not available").create(); 
         System.out.println(message.getSid());
         Listnot = new NotificationDao().findAll(Notification.class);
        notifier = new  Notification();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(messages));
  
  
  
  
  }

    public Notification getNotails() {
        return notails;
    }

    public void setNotails(Notification notails) {
        this.notails = notails;
    }

    public List<Notification> getListnot() {
        return Listnot;
    }

    public void setListnot(List<Notification> Listnot) {
        this.Listnot = Listnot;
    }

    

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public NotificationDao getMoDao() {
        return moDao;
    }

    public void setMoDao(NotificationDao moDao) {
        this.moDao = moDao;
    }

    public List<Notification> getPo() {
        return po;
    }

    public void setPo(List<Notification> po) {
        this.po = po;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Notification getNotifier() {
        return notifier;
    }

    public void setNotifier(Notification notifier) {
        this.notifier = notifier;
    }
  
  
}
