package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.entity.Person;
import com.encoming.encoming.entity.Package;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Andrezz
 */
@ManagedBean
@SessionScoped
public class EncomiendaBean {
        
    private Person person = new Person();
    private Package pack = new Package();
    private Person client = new Person();
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
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
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
    
    public void comparation(FacesContext arg0, UIComponent arg1, Object arg2, Object arg3)
         throws ValidatorException {
      if (((String)arg2)==((String)arg3)) {
         throw new ValidatorException(new FacesMessage("La cuidad orgen y destino coinciden"));
      }
   }
    
    
}
