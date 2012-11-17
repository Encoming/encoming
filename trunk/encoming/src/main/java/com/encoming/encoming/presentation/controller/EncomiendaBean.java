package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.EncomingFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.businesslogic.facade.ShippingFacade;
import com.encoming.encoming.vo.EncomingVo;
import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.vo.PersonVo;
import com.encoming.encoming.vo.PointVo;
import com.encoming.encoming.vo.ShippingVo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Andrezz
 */
@ManagedBean
@ViewScoped
public class EncomiendaBean {

    private List<SelectItem> points;
    private boolean skip;
    private static final Logger logger = Logger.getLogger(EncomiendaBean.class.getName());
    private String name;
    private String lastNames;
    private Integer idPerson;
    private String mail;
    private Integer phone;
    private String adress;
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
    private boolean validator = true;

    public String dateTime() {
        Date fecha = new Date();
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss  a", Locale.getDefault());
        String fecha2 = formato2.format(fecha);
        return fecha2;

    }

    public void addPerson(ActionEvent actionEvent) {
//        Persona que envia el paquete
        PersonVo personVo = new PersonVo();
        personVo.setName(getName());
        personVo.setLastName(getLastNames());
        personVo.setIdPerson(getIdPerson());
        personVo.setMail(getMail());
        personVo.setPhone(getPhone());
        personVo.setAdress(getAdress());
        try {
            createperson(personVo);
        } catch (Exception e) {
            validator = false;
            addMessage("Error al ingresar el cliente");
        }


//        Persona que recibe el paquete
        PersonVo personRVo = new PersonVo();
        personRVo.setName(getNameReceiver());
        personRVo.setLastName(getLastNamesReceiver());
        personRVo.setIdPerson(getIdReceiver());
        personRVo.setMail(getMailReceiver());
        personRVo.setPhone(getPhoneReceiver());
        personRVo.setAdress(getAdressReceiver());
        try {
            createperson(personRVo);
        } catch (Exception e) {
            validator = false;
            addMessage("Error al ingresar el destinatario");
        }

        if (validator) {
//        Persistencia del paquete q se va a enviar  
            EncomingVo encomingVo = new EncomingVo();
            encomingVo.setPriority(getPriority());
            encomingVo.setType(getType());
            encomingVo.setVolume(getVolume());
            encomingVo.setWeight(getWeigth());
            encomingVo.setReceived_packet(dateTime());
            try {
                createencoming(encomingVo);
            } catch (Exception e) {
                validator = false;
                addMessage("error al asignar el paquete");
            }
//        Creacion de una shipping
            ShippingVo shippingVo = new ShippingVo();
            shippingVo.setIdReceiver(getIdReceiver());
            shippingVo.setIdPerson(getIdPerson());
            shippingVo.setCost(2333);
            shippingVo.setIdEncoming(1);
            shippingVo.setIdVehicle(1);
            shippingVo.setIdRoute(1);
            shippingVo.setSendedDate(null);
            shippingVo.setArrivedDate(null);
            //shippingVo.setIdInvoice(idReceiver);
            try {
                createshipping(shippingVo);
            } catch (Exception e) {
                validator = false;
                addMessage("No se pudo guardar el envío");
            }
        }
        if (validator) {
            addMessage("Los datos han sido guardados");
        }
    }

    public void createshipping(ShippingVo shipping) {
        ShippingFacade shippingFacade = FacadeFactory.getInstance().getShippingFacade();
        shippingFacade.persist(shipping);
    }

    public void createperson(PersonVo person) {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        personFacade.persist(person);
    }

    public void createencoming(EncomingVo paquete) {
        EncomingFacade encomingFacade = FacadeFactory.getInstance().getEncomingFacade();
        encomingFacade.persist(paquete);

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<SelectItem> getPoints() {
        if (points == null) {
            points = new ArrayList<SelectItem>();
            List<PointVo> pointList = FacadeFactory.getInstance().getPointFacade().getList();
            if (pointList != null) {
                for (PointVo point : pointList) {
                    points.add(new SelectItem(point.getName()));
                }
            }
        }
        return points;
    }

    public static Logger getLogger() {
        return logger;
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
        getLogger().log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        getLogger().log(Level.INFO, "Next step:{0}", event.getNewStep());

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
