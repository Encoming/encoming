/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import com.encoming.encoming.businesslogic.facade.FacadeFactory;
import com.encoming.encoming.vo.VehicleVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean
@RequestScoped
public class VehicleBean implements Serializable{

    private List<SelectItem> models;
    private ArrayList<String> tipos;
    private List<SelectItem> manufacturers;
    private List<SelectItem> capacities;
    private Integer idVehicle;
    private String type;
    private String manufacturer;
    private String model;
    private String capacity;
    private String status;
    private Integer idDriver;
    private Integer idPoint;
    private Integer plateNumbers;
    private String plateLetters;

    /**
     * Creates a new instance of VehicleBean
     */
    public VehicleBean() {
    }

    public List<SelectItem> getModels() {
        if (models == null) {
            models = new ArrayList<SelectItem>();
            for (int i = 1987; i < 2012; i++) {
                models.add(new SelectItem(i));
            }
        }
        return models;
    }

    public void setModels(List<SelectItem> models) {
        this.models = models;
    }

    public ArrayList<String> getTipos() {
        if (tipos == null) {
            tipos = new ArrayList<String>();
            tipos.add("Camioneta");
            tipos.add("Camión Con Carrocería Volco (Volqueta)");
            tipos.add("Camión Con Carrocería Estacas");
            tipos.add("Camión Con Carrocería Furgón");
            tipos.add("Picó");
            tipos.add("Planchón");
            tipos.add("Portacontenedor");
            tipos.add("Recolector");
            tipos.add("Reparto");
            tipos.add("Tractocamión");
        }
        return tipos;
    }

    public void setTipos(ArrayList<String> type) {
        this.tipos = type;
    }

    public List<SelectItem> getManufacturers() {
        if (manufacturers == null) {
            //<editor-fold defaultstate="collapsed" desc="Manufacturers">
            manufacturers = new ArrayList<SelectItem>();
            manufacturers.add(new SelectItem("Agrale "));
            manufacturers.add(new SelectItem("American Motors "));
            manufacturers.add(new SelectItem("Ample "));
            manufacturers.add(new SelectItem("Aro "));
            manufacturers.add(new SelectItem("Asia "));
            manufacturers.add(new SelectItem("Asia Towner "));
            manufacturers.add(new SelectItem("Austin "));
            manufacturers.add(new SelectItem("Autocar "));
            manufacturers.add(new SelectItem("Barreiros "));
            manufacturers.add(new SelectItem("Baw "));
            manufacturers.add(new SelectItem("Beijing "));
            manufacturers.add(new SelectItem("Bock Wall "));
            manufacturers.add(new SelectItem("Buick "));
            manufacturers.add(new SelectItem("Chana "));
            manufacturers.add(new SelectItem("Chana (Star Van) "));
            manufacturers.add(new SelectItem("Changfeng "));
            manufacturers.add(new SelectItem("Changfeng (Minivan) "));
            manufacturers.add(new SelectItem("Changhe "));
            manufacturers.add(new SelectItem("Changhe (Minivan) "));
            manufacturers.add(new SelectItem("Chery "));
            manufacturers.add(new SelectItem("Chevrolet "));
            manufacturers.add(new SelectItem("Chevrolet N200 "));
            manufacturers.add(new SelectItem("Chevrolet Super Carry "));
            manufacturers.add(new SelectItem("Citroen "));
            manufacturers.add(new SelectItem("Dacia "));
            manufacturers.add(new SelectItem("Daewoo "));
            manufacturers.add(new SelectItem("Daewoo Damas "));
            manufacturers.add(new SelectItem("Daihatsu "));
            manufacturers.add(new SelectItem("Datsun "));
            manufacturers.add(new SelectItem("Delta "));
            manufacturers.add(new SelectItem("Desoto "));
            manufacturers.add(new SelectItem("Deutz "));
            manufacturers.add(new SelectItem("Dfm (Dong Feng Motor) "));
            manufacturers.add(new SelectItem("Dfm - Dong Feng Motor (Van Pasajeros - Familiy) "));
            manufacturers.add(new SelectItem("Dina "));
            manufacturers.add(new SelectItem("Dodge "));
            manufacturers.add(new SelectItem("Dragon "));
            manufacturers.add(new SelectItem("Ernest Gruber "));
            manufacturers.add(new SelectItem("Eurostar "));
            manufacturers.add(new SelectItem("Fargo "));
            manufacturers.add(new SelectItem("Faw "));
            manufacturers.add(new SelectItem("Faw Ami "));
            manufacturers.add(new SelectItem("Fiat "));
            manufacturers.add(new SelectItem("Ford "));
            manufacturers.add(new SelectItem("Forland "));
            manufacturers.add(new SelectItem("Foton "));
            manufacturers.add(new SelectItem("Freightliner "));
            manufacturers.add(new SelectItem("G.M.C "));
            manufacturers.add(new SelectItem("Gaz "));
            manufacturers.add(new SelectItem("Golden "));
            manufacturers.add(new SelectItem("Golden Dragon "));
            manufacturers.add(new SelectItem("Gonow "));
            manufacturers.add(new SelectItem("Great Wall "));
            manufacturers.add(new SelectItem("Grove "));
            manufacturers.add(new SelectItem("Gwm "));
            manufacturers.add(new SelectItem("Gwm (Great Wall Motor) "));
            manufacturers.add(new SelectItem("Hafei "));
            manufacturers.add(new SelectItem("Hafei (Zhongyi - Minyi - Xinyi - Luzun) "));
            manufacturers.add(new SelectItem("Haima (F Star) "));
            manufacturers.add(new SelectItem("Hersa "));
            manufacturers.add(new SelectItem("Higer "));
            manufacturers.add(new SelectItem("Hino "));
            manufacturers.add(new SelectItem("Honda "));
            manufacturers.add(new SelectItem("Huali "));
            manufacturers.add(new SelectItem("Hualin (Minivan) "));
            manufacturers.add(new SelectItem("Hyundai "));
            manufacturers.add(new SelectItem("Ifa "));
            manufacturers.add(new SelectItem("Infinity "));
            manufacturers.add(new SelectItem("International "));
            manufacturers.add(new SelectItem("Isuzu "));
            manufacturers.add(new SelectItem("Iveco "));
            manufacturers.add(new SelectItem("Jac "));
            manufacturers.add(new SelectItem("Jiangchan "));
            manufacturers.add(new SelectItem("Jinbei "));
            manufacturers.add(new SelectItem("Jmc "));
            manufacturers.add(new SelectItem("Kaizer "));
            manufacturers.add(new SelectItem("Kamaz "));
            manufacturers.add(new SelectItem("Kenworth "));
            manufacturers.add(new SelectItem("Kia "));
            manufacturers.add(new SelectItem("Kiamaster "));
            manufacturers.add(new SelectItem("Kraz "));
            manufacturers.add(new SelectItem("Land Rover "));
            manufacturers.add(new SelectItem("Lifan (Minivan) "));
            manufacturers.add(new SelectItem("Lorain "));
            manufacturers.add(new SelectItem("Mack "));
            manufacturers.add(new SelectItem("Magirus "));
            manufacturers.add(new SelectItem("Magirus Deutz "));
            manufacturers.add(new SelectItem("Man "));
            manufacturers.add(new SelectItem("Marmon "));
            manufacturers.add(new SelectItem("Mazda "));
            manufacturers.add(new SelectItem("Mercedes Benz "));
            manufacturers.add(new SelectItem("Mercury "));
            manufacturers.add(new SelectItem("Mitsubishi "));
            manufacturers.add(new SelectItem("Mudan "));
            manufacturers.add(new SelectItem("Nissan "));
            manufacturers.add(new SelectItem("Non Plus Ultra "));
            manufacturers.add(new SelectItem("Pegaso "));
            manufacturers.add(new SelectItem("Peterbilt "));
            manufacturers.add(new SelectItem("Peugeot "));
            manufacturers.add(new SelectItem("Ph - Omega "));
            manufacturers.add(new SelectItem("Ramirez "));
            manufacturers.add(new SelectItem("Renault "));
            manufacturers.add(new SelectItem("Renno "));
            manufacturers.add(new SelectItem("Reo "));
            manufacturers.add(new SelectItem("Saic "));
            manufacturers.add(new SelectItem("Saic (Minivan - Supervan) "));
            manufacturers.add(new SelectItem("Saic-Wuling "));
            manufacturers.add(new SelectItem("Saturn "));
            manufacturers.add(new SelectItem("Scania "));
            manufacturers.add(new SelectItem("Schacman "));
            manufacturers.add(new SelectItem("Seagrave "));
            manufacturers.add(new SelectItem("Shuanghuan "));
            manufacturers.add(new SelectItem("Sinotruck "));
            manufacturers.add(new SelectItem("Sizu "));
            manufacturers.add(new SelectItem("Skoda "));
            manufacturers.add(new SelectItem("Soyat "));
            manufacturers.add(new SelectItem("Ssangyong "));
            manufacturers.add(new SelectItem("Steyr "));
            manufacturers.add(new SelectItem("Studebaker "));
            manufacturers.add(new SelectItem("Suzuki "));
            manufacturers.add(new SelectItem("Suzuki Carry "));
            manufacturers.add(new SelectItem("T-King "));
            manufacturers.add(new SelectItem("Tata "));
            manufacturers.add(new SelectItem("Tianma "));
            manufacturers.add(new SelectItem("Tmd "));
            manufacturers.add(new SelectItem("Toyota "));
            manufacturers.add(new SelectItem("Uaz "));
            manufacturers.add(new SelectItem("Ufo "));
            manufacturers.add(new SelectItem("Volkswagen "));
            manufacturers.add(new SelectItem("Volvo "));
            manufacturers.add(new SelectItem("Wartburg "));
            manufacturers.add(new SelectItem("Western Star "));
            manufacturers.add(new SelectItem("White "));
            manufacturers.add(new SelectItem("Willco "));
            manufacturers.add(new SelectItem("Willys "));
            manufacturers.add(new SelectItem("World Star "));
            manufacturers.add(new SelectItem("Wuling (Minivan - Supervan) "));
            manufacturers.add(new SelectItem("Xinkai "));
            manufacturers.add(new SelectItem("Yaxing "));
            manufacturers.add(new SelectItem("Yutong "));
            manufacturers.add(new SelectItem("Zahav "));
            manufacturers.add(new SelectItem("Zhongxing "));
            manufacturers.add(new SelectItem("Zna "));
            manufacturers.add(new SelectItem("Zongshen "));
            manufacturers.add(new SelectItem("Zx Auto "));
            manufacturers.add(new SelectItem("Otras Marcas "));
            //</editor-fold>
        }
        return manufacturers;
    }

    public void setManufacturers(List<SelectItem> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public List<SelectItem> getCapacities() {
        if (capacities == null) {
            capacities = new ArrayList<SelectItem>();
            //<editor-fold defaultstate="collapsed" desc="Capacidades">
            capacities.add(new SelectItem("Hasta 1 ton."));
            capacities.add(new SelectItem("Más de 1 y hasta 2 ton."));
            capacities.add(new SelectItem("Más de 2 y hasta 4 ton."));
            capacities.add(new SelectItem("Más de 4 y hasta 6 ton."));
            capacities.add(new SelectItem("Más de 6 y hasta 9 ton."));
            capacities.add(new SelectItem("Más de 9 y hasta 12 ton"));
            capacities.add(new SelectItem("Más de 12 y hasta 16 ton."));
            capacities.add(new SelectItem("Más de 16 y hasta 20 ton."));
            capacities.add(new SelectItem("Más de 20 y hasta 25 ton."));
            capacities.add(new SelectItem("Más de 25 Y hasta 30 ton."));
            capacities.add(new SelectItem("Más de 30 ton."));
            //</editor-fold>

        }

        return capacities;
    }

    public void setCapacities(List<SelectItem> capacities) {
        this.capacities = capacities;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Integer idPoint) {
        this.idPoint = idPoint;
    }

    public Integer getPlateNumbers() {
        return plateNumbers;
    }

    public void setPlateNumbers(Integer plateNumbers) {
        this.plateNumbers = plateNumbers;
    }

    public String getPlateLetters() {
        return plateLetters;
    }

    public void setPlateLetters(String plateLetters) {
        this.plateLetters = plateLetters;
    }

    public void addVehicle(ActionEvent actionEvent) {

        VehicleVo vehicleVo = new VehicleVo();

        vehicleVo.setCapacity(getCapacity());
        vehicleVo.setIdDriver(getIdDriver());
        vehicleVo.setIdPoint(getIdPoint());
        vehicleVo.setManufacturer(getManufacturer());
        vehicleVo.setModel(getModel());
        vehicleVo.setPlateLetters(getPlateLetters());
        vehicleVo.setPlateNumber(getPlateNumbers());
        vehicleVo.setStatus(getStatus());
        vehicleVo.setType(getType());

        FacadeFactory.getInstance().getVehicleFacade().persist(vehicleVo);
    }
}