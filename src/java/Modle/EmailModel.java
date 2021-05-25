/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Domain.Email;
import org.primefaces.context.RequestContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class EmailModel {
    private String FromEmail;
    private String Email;
    private String Subject;
    private String Content;

    public String getFromEmail() {
        return FromEmail;
    }

    public void setFromEmail(String FromEmail) {
        this.FromEmail = FromEmail;
    }

    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

 

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

 
    
    
    public void send(){
try{
        //MailSender mailSender=new MailSender();
        Email email=new Email();
        email.from(FromEmail);
        email.to("niringiyimanaeric1@gmail.com");
        email.subject(Subject);
        email.text(Content);
        email.send();
 
         RequestContext context = RequestContext.getCurrentInstance();
        context.execute("swal('Congratulation','Message Sent!','success')");
        }
    catch (Exception e){
    e.getMessage();
 }
    
}
  
    
}
