/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.User;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import service.Userservice;

/**
 *
 * @author Youness
 */
@ManagedBean
@SessionScoped
public class UserControler {

    private User user=new User();
    private Userservice uService=new Userservice();
    public UserControler() {
    }
    
    //************** dial date **********************
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
   //****************************************

     public String save(){
        
    
        uService.save(user);
        
        return null;
    }
    
    public User loadById(int id){
        return uService.findById(id);
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Userservice getuService() {
        return uService;
    }

    public void setuService(Userservice uService) {
        this.uService = uService;
    }
    
    
}
