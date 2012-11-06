package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.businesslogic.facade.PackageFacade;
import com.encoming.encoming.vo.ClientVo;
import com.encoming.encoming.vo.PersonVo;
import com.encoming.encoming.vo.PackageVo;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Andrezz
 */
@ManagedBean
@ApplicationScoped
public class EncomiendaBean {

    private boolean skip;
    private static Logger logger = Logger.getLogger(EncomiendaBean.class.getName());
    
    private String name;
    private String lastNames;
    private Integer idPerson;
    private String mail;
    private Integer phone;
    private String adress;
    
    private Integer idPackage;
    private String type;
    private String volume;
    private String priority;
    private float weigth;
    private String originCity;
    private String destinationCity;
    
    private Integer idReceiver;
    private String nameReceiver;
    private String lastNamesReceiver;
    private Integer phoneReceiver;
    private String mailReceiver;
    private String adressReceiver;

    public void addPerson(ActionEvent actionEvent) {

        //        Persona que envia el paquete
        PersonVo personVo = new PersonVo();
        personVo.setName(getName());
        personVo.setLastName(getLastNames());
        personVo.setIdPerson(getIdPerson());
        personVo.setMail(getMail());
        personVo.setPhone(getPhone());
        personVo.setAdress(getAdress());
        createperson(personVo);

        ClientVo clientVo = new ClientVo();

//        Persona que recibe el paquete
        PersonVo personRVo = new PersonVo();
        personRVo.setName(getNameReceiver());
        personRVo.setLastName(getLastNamesReceiver());
        personRVo.setIdPerson(getIdReceiver());
        personRVo.setMail(getMailReceiver());
        personRVo.setPhone(getPhoneReceiver());
        personRVo.setAdress(getAdressReceiver());
        createperson(personRVo);

        //   Persistencia del paquete que se va a enviar        
        PackageVo packageVo = new PackageVo();
        idPackage=123;
        //packageVo.setIdPackage(idPackage);
        packageVo.setPriority(getPriority());
        packageVo.setType(getType());
        packageVo.setVolume(getVolume());
        packageVo.setWeight(getWeigth());
        createpackage(packageVo);

    }

    public void createperson(PersonVo person) {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        personFacade.persist(person);
    }

    public void createpackage(PackageVo paquete) {
        PackageFacade packageFacade = FacadeFactory.getInstance().getPackageFacade();
        packageFacade.persist(paquete);

    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger aLogger) {
        logger = aLogger;
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

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
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

    public Integer getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Integer idReceiver) {
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

    public Integer getPhoneReceiver() {
        return phoneReceiver;
    }

    public void setPhoneReceiver(Integer phoneReceiver) {
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

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String onFlowProcess(FlowEvent event) {
        getLogger().info("Current wizard step:" + event.getOldStep());
        getLogger().info("Next step:" + event.getNewStep());

        if (isSkip()) {
            setSkip(false);   //reset in case user goes back  
            return "confirm";
        } else {
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
}
