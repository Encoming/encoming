package com.encoming.encoming.presentation.controller;
import com.encoming.encoming.businesslogic.facade.EncomingFacade;
import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.businesslogic.facade.PersonFacade;
import com.encoming.encoming.businesslogic.facade.ShippingFacade;
import com.encoming.encoming.businesslogic.facade.VehicleFacade;
import com.encoming.encoming.businesslogic.facade.PointFacade;
import com.encoming.encoming.businesslogic.facade.RouteFacade;
import com.encoming.encoming.businesslogic.facade.InvoiceFacade;
import com.encoming.encoming.presentation.controller.AdminMenuBean;
import com.encoming.encoming.vo.EncomingVo;
import com.encoming.encoming.vo.PersonVo;
import com.encoming.encoming.vo.PointVo;
import com.encoming.encoming.vo.ShippingVo;
import com.encoming.encoming.vo.InvoiceVo;
import com.encoming.encoming.vo.RouteVo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
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
    private Integer originCity;
    private Integer destinationCity;
    private Integer idReceiver;
    private String nameReceiver;
    private String lastNamesReceiver;
    private Integer phoneReceiver;
    private String mailReceiver;
    private String adressReceiver;
    private String origin;
    private String destinity;
    private boolean validator = true;
    boolean enBD = true;

    public String dateTime() {
        Date fecha = new Date();
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss  a", Locale.getDefault());
        String fecha2 = formato2.format(fecha);
        return fecha2;
    }
    
      public void printPdf(ActionEvent evt) {
       System.out.println("ENTRA EN EL METODO PRINT");

        try {
            String directorioArchivos;
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            directorioArchivos = ctx.getRealPath("/") + "invoices";
            String name1 = directorioArchivos + "/document-report.pdf";
            Document invoice = new Document();
            PdfWriter.getInstance(invoice, new FileOutputStream(name1));

            invoice.open();
            invoice.add(new Paragraph("DATOS DEL CLIENTE\n"));
            invoice.add(new Paragraph("Documento: " + getIdPerson()));
            invoice.add(new Paragraph("Nombre: " + getName()));
            invoice.add(new Paragraph("Apellido: " + getLastNames()));
            invoice.add(new Paragraph("E-mail: " + getMail()));
            invoice.add(new Paragraph("Teléfono: " + getPhone()));
            invoice.add(new Paragraph("Dirección: " + getAdress()));
            invoice.add(new Paragraph("DATOS DE LA ENCOMIENDA\n"));
            invoice.add(new Paragraph("Ciudad de Origen: " + getOriginCity()));
            invoice.add(new Paragraph("Ciudad de Destino: " + getDestinationCity()));
            invoice.add(new Paragraph("Peso: " + getWeigth()));
            invoice.add(new Paragraph("Tipo: " + getType()));
            invoice.add(new Paragraph("Volumen: " + getVolume()));
            invoice.add(new Paragraph("Prioridad: " + getPriority()));
            invoice.add(new Paragraph("DATOS DEL DESTINATARIO\n"));
            invoice.add(new Paragraph("Documento: " + getIdReceiver()));
            invoice.add(new Paragraph("Nombre: " + getNameReceiver()));
            invoice.add(new Paragraph("Apellido: " + getLastNamesReceiver()));
            invoice.add(new Paragraph("E-mail: " + getMailReceiver()));
            invoice.add(new Paragraph("Teléfono: " + getPhoneReceiver()));
            invoice.add(new Paragraph("Dirección: " + getAdressReceiver()));
            invoice.close();

            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition",
                    "inline=filename=" + name1);
            try {
                response.getOutputStream().write(getBytesFromFile(new File(name1)));
                response.getOutputStream().flush();
                response.getOutputStream().close();
                context.responseComplete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (!enBD) {
            try {
                createperson(personVo);
            } catch (Exception e) {
                validator = false;
                addMessage("Error al ingresar el cliente");
            }
        } else {
            try {
                updateperson(personVo);
            } catch (Exception e) {
                validator = false;
                addMessage("Error al actualizar el cliente");
            }
        }

//      Persona que recibe el paquete
        PersonVo personRVo = new PersonVo();
        personRVo.setName(getNameReceiver());
        personRVo.setLastName(getLastNamesReceiver());
        personRVo.setIdPerson(getIdReceiver());
        personRVo.setMail(getMailReceiver());
        personRVo.setPhone(getPhoneReceiver());
        personRVo.setAdress(getAdressReceiver());
        if (!enBD) {
            try {
                createperson(personRVo);
            } catch (Exception e) {
                validator = false;
                addMessage("Error al ingresar el destinatario");
            }
        } else {
            try {
                updateperson(personRVo);
            } catch (Exception e) {
                validator = false;
                addMessage("Error al actualizar el destinatario");
            }
        }

        if (validator) {

//        Persistencia del paquete q se va a enviar  
            EncomingVo encomingVo = new EncomingVo();
            encomingVo.setPriority("Alta");
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
            try {
                ShippingVo shippingVo = new ShippingVo();
                shippingVo.setIdReceiver(getIdReceiver());
                System.out.println(getIdReceiver());
                shippingVo.setIdPerson(getIdPerson());
                System.out.println(getIdPerson());
                shippingVo.setIdEncoming(findMaxIdEncoming());
                System.out.println("Encomienda " + findMaxIdEncoming());

                shippingVo.setIdVehicle(findFreeVehicle(getOriginCity()));
                System.out.println("Id vehicle " + findFreeVehicle(getOriginCity()));

                shippingVo.setIdRoute(findIdRoute(getOriginCity(), getDestinationCity()));
                System.out.println(" ID de la ruta " + findIdRoute(getOriginCity(), getDestinationCity()));
                shippingVo.setSendedDate(null);
                shippingVo.setArrivedDate(null);
                shippingVo.setCost(calculateCost(encomingVo, shippingVo.getIdRoute()));
                //shippingVo.setIdInvoice(idReceiver);
                createshipping(shippingVo);
            } catch (Exception e) {
                validator = false;
                addMessage("No se pudo guardar el envío");
            }
        }

        if (validator) {
            InvoiceVo invoiceVo = new InvoiceVo();
            invoiceVo.setIdEncoming(findMaxIdEncoming());
            invoiceVo.setIdShipping(findMaxIdShipping());
            invoiceVo.setMoment(new Date());
            invoiceVo.setReceiver(getNameReceiver());
            invoiceVo.setSender(getName());
            try {
                createInvoice(invoiceVo);
            } catch (Exception e) {
                validator = false;
                addMessage("No se pudo guardar Recibo");
            }
        }
        if (validator) {
            addMessage("Los datos han sido guardados");
        } else {
            addMessage("Error!! Los datos no pudieron ser guardados");
        }
    }

    public Integer findMaxIdEncoming() {
        EncomingFacade encomingFacade = FacadeFactory.getInstance().getEncomingFacade();
        return encomingFacade.findMaxIdEncoming();
    }

    public Integer findMaxIdShipping() {
        ShippingFacade shippingFacade = FacadeFactory.getInstance().getShippingFacade();
        return shippingFacade.findMaxIdShipping();
    }

//  Este método busca el id de una ruta teniendo en cuenta la cuidad de origen y la ciudad de destino    
    public Integer findIdRoute(Integer originCity, Integer destinationCity) {
        RouteFacade routeFacade = FacadeFactory.getInstance().getRouteFacade();
        Integer a = routeFacade.findIdRoute(getOriginCity(), getDestinationCity());
        if (a != null) {
            System.out.println(a);
            return a;
        } else {
            RouteVo routeVo = new RouteVo();

            routeVo.setDestinationPoint(getDestinationCity());
            routeVo.setOriginPoint(getOriginCity());
            routeVo.setNumberKilometers(-1);
            try {
                System.out.println("si entra ene l try de la ruta");
                createRoute(routeVo);
                System.out.println("si persiste la ruta");
                return FacadeFactory.getInstance().getRouteFacade()
                        .findIdRoute(getOriginCity(), getDestinationCity());


            } catch (Exception e) {
//                validator = false;
                addMessage("No se pudo crear una nueva ruta");
            }
            return 0;
        }
    }

    public void findPerson(ActionEvent actionEvent) {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        PersonVo personVo;
        try {
            personVo = personFacade.findPerson(getIdPerson());
            setName(personVo.getName());
            setLastNames(personVo.getLastName());
            setIdPerson(personVo.getIdPerson());
            setAdress(personVo.getAdress());
            setMail(personVo.getMail());
            setPhone(personVo.getPhone());
            addMessage("La persona ya se encuentra en la BD");
        } catch (NullPointerException e) {
            addMessage("La persona no se encuentra en la BD");
            setName(null);
            setLastNames(null);
            //setIdPerson(null);
            setAdress(null);
            setMail(null);
            setPhone(null);
            enBD = false;
        }
    }

    public void findReceiver() {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        PersonVo personVo;
        try {
            personVo = personFacade.findPerson(getIdReceiver());
            setNameReceiver(personVo.getName());
            setLastNamesReceiver(personVo.getLastName());
            setIdReceiver(personVo.getIdPerson());
            setAdressReceiver(personVo.getAdress());
            setMailReceiver(personVo.getMail());
            setPhoneReceiver(personVo.getPhone());
            addMessage("La persona ya se encuentra en la BD");
        } catch (NullPointerException e) {
            addMessage("La persona no se encuentra en la BD");
            setNameReceiver(null);
            setLastNamesReceiver(null);
            //setIdReceiver(null);
            setAdressReceiver(null);
            setMailReceiver(null);
            setPhoneReceiver(null);
            enBD = false;
        }
    }

//  Este método busca el id de un vehículo que se encuentre en una ciudad y q además esté libre
    public Integer findFreeVehicle(Integer idPoint) {
        VehicleFacade vehicleFacade = FacadeFactory.getInstance().getVehicleFacade();
        return vehicleFacade.findFreeVehicle(getOriginCity());
    }

//  Este método busca el id de un punto teniendo en cuenta el nombre de una ciudad
    public Integer findIdPoint(String originCity) {
        PointFacade pointFacade = FacadeFactory.getInstance().getPointFacade();
        return pointFacade.findIdPoint(originCity);
    }

    private Integer findNewIdRoute() {
        RouteFacade routeFacade = FacadeFactory.getInstance().getRouteFacade();
        return routeFacade.findNewIdRoute();
    }

    public void createshipping(ShippingVo shipping) {
        ShippingFacade shippingFacade = FacadeFactory.getInstance().getShippingFacade();
        shippingFacade.persist(shipping);
    }

    public void createInvoice(InvoiceVo invoice) {
        InvoiceFacade invoiceFacade = FacadeFactory.getInstance().getInvoiceFacade();
        invoiceFacade.persist(invoice);
    }

    public void createperson(PersonVo person) {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        personFacade.persist(person);
    }

    public void createencoming(EncomingVo paquete) {
        EncomingFacade encomingFacade = FacadeFactory.getInstance().getEncomingFacade();
        encomingFacade.persist(paquete);
    }

    public void createRoute(RouteVo route) {
        RouteFacade routeFacade = FacadeFactory.getInstance().getRouteFacade();
        routeFacade.persist(route);
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

    public Integer getIdReceiver() {
        return idReceiver;
    }

    public Integer getOriginCity() {
        return originCity;
    }

    public void setOriginCity(Integer originCity) {
        this.originCity = originCity;
        setOrigin(findNamePoint(getOriginCity()));
    }

    public Integer getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(Integer destinationCity) {
        this.destinationCity = destinationCity;
        setDestinity(findNamePoint(getDestinationCity()));
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

    public void updateperson(PersonVo person) {
        PersonFacade personFacade = FacadeFactory.getInstance().getPersonFacade();
        personFacade.update(person);
    }

    public void backToTop() {
        AdminMenuBean a = new AdminMenuBean();
        setSkip(true);
        setName(null);
        setLastNames(null);
        setIdPerson(null);
        setAdress(null);
        setMail(null);
        setPhone(null);
        setNameReceiver(null);
        setLastNamesReceiver(null);
        setIdReceiver(null);
        setAdressReceiver(null);
        setMailReceiver(null);
        setPhoneReceiver(null);
        a.getShipping();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestinity() {
        return destinity;
    }

    public void setDestinity(String destinity) {
        this.destinity = destinity;
    }

    public String findNamePoint(Integer idPoint) {
        PointFacade pointFacade = FacadeFactory.getInstance().getPointFacade();
        return pointFacade.findNamePoint(idPoint);
    }

    public Double findKm(Integer idRoute) {
        RouteFacade routeFacade = FacadeFactory.getInstance().getRouteFacade();
        return routeFacade.findKm(idRoute);
    }

    public Double calculateCost(EncomingVo encomingVo, Integer idRoute) {
        String type1 = encomingVo.getType();
        Float weight = encomingVo.getWeight();
        Double costo = 2000.00;
        if (type1.equals("Caja")) {
            costo = weight * 1.12;
        }
        if (type1.equals("Sobre")) {
            costo = weight * 1.07;
        }
        if (type1.equals("Otro")) {
            costo = weight * 1.17;
        }
        return costo;
    }
    
    


    public static byte[] getBytesFromFile(File file) throws IOException {
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            throw new IOException("File is too large!");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        InputStream is = new FileInputStream(file);
        try {
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
        } finally {
            is.close();
        }
        if (offset < bytes.length) {
            throw new IOException("No se pudo leer completamente el archivo " + file.getName());
        }
        return bytes;
    }
}
