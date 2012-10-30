package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.businesslogic.facade.PointFacade;
import com.encoming.encoming.entity.Person;
import com.encoming.encoming.entity.Package;
import com.encoming.encoming.vo.ClientVo;
import com.encoming.encoming.vo.PersonVo;
import com.encoming.encoming.vo.PointVo;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Andrezz
 */
@ManagedBean
@SessionScoped
public class EncomiendaBean {
        
    private boolean skip;
    private static final Logger logger = Logger.getLogger(EncomiendaBean.class.getName()); 
    
    private String name;
    private String lastNames;
    private String idPerson;
    private String mail;
    private String phone;
    private String adress;
    
    private String type;
    private String volume;
    private String priority;
    private String weigth;
    private String originCity;
    private String destinationCity;
    
    private String idReceiver;
    private String nameReceiver;
    private String lastNamesReceiver;
    private String phoneReceiver;
    private String mailReceiver;
    private String adressReceiver;
    
    
    public void addPerson(ActionEvent actionEvent) {

        PersonVo personVo = new PersonVo();
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        System.out.println(getPhone());
        System.out.println(getPhone());
        System.out.println(getPhone());
        System.out.println(getPhone());
        System.out.println(getPhone());
        System.out.println(getPhone());

        personVo.setName(getName());
        personVo.setLastName(getLastNames());
        personVo.setIdPerson(Integer.parseInt(getIdPerson()));
        personVo.setMail(getMail());
        personVo.setPhone(Integer.parseInt(getPhone()));
        personVo.setAdress(getAdress());

        personFacade.persist(personVo);
        
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado una nueva Persona",
                "Nombre:" + name
                + "\n\nApellido:" + lastNames
                + ", :" + idPerson));
    }
    
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
           
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }

    public EncomiendaBean() {
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getLastNamesReceiver() {
        return lastNamesReceiver;
    }

    public void setLastNamesReceiver(String lastNamesReceiver) {
        this.lastNamesReceiver = lastNamesReceiver;
    }

    public String getPhoneReceiver() {
        return phoneReceiver;
    }

    public void setPhoneReceiver(String phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    public String getMailReceiver() {
        return mailReceiver;
    }

    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    public String getAdressReceiver() {
        return adressReceiver;
    }

    public void setAdressReceiver(String adressReceiver) {
        this.adressReceiver = adressReceiver;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
      
}
