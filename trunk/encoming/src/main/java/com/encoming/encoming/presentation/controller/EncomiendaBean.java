/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FAMILIA
 */
@ManagedBean
@SessionScoped
public class EncomiendaBean {
    
    private String name;
    private String lastName;
    private Integer idClient;
    private String mail;
    private Integer phone;
    private String adress;
    private String type;
    private String volume;
    private String priority;
    private float weight;
    private Integer idReceiver;
    private String nameReceiver;
    private String lastNamesReceiver;
    private Integer phoneReceiver;
    private String mailReceiver;
    private String adressReceiver;
    

//    public EncomiendaBean() {
//    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the phone
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the idReceiver
     */
    public Integer getIdReceiver() {
        return idReceiver;
    }

    /**
     * @param idReceiver the idReceiver to set
     */
    public void setIdReceiver(Integer idReceiver) {
        this.idReceiver = idReceiver;
    }

    /**
     * @return the nameReceiver
     */
    public String getNameReceiver() {
        return nameReceiver;
    }

    /**
     * @param nameReceiver the nameReceiver to set
     */
    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    /**
     * @return the lastNamesReceiver
     */
    public String getLastNamesReceiver() {
        return lastNamesReceiver;
    }

    /**
     * @param lastNamesReceiver the lastNamesReceiver to set
     */
    public void setLastNamesReceiver(String lastNamesReceiver) {
        this.lastNamesReceiver = lastNamesReceiver;
    }

    /**
     * @return the phoneReceiver
     */
    public Integer getPhoneReceiver() {
        return phoneReceiver;
    }

    /**
     * @param phoneReceiver the phoneReceiver to set
     */
    public void setPhoneReceiver(Integer phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    /**
     * @return the mailReceiver
     */
    public String getMailReceiver() {
        return mailReceiver;
    }

    /**
     * @param mailReceiver the mailReceiver to set
     */
    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    /**
     * @return the adressReceiver
     */
    public String getAdressReceiver() {
        return adressReceiver;
    }

    /**
     * @param adressReceiver the adressReceiver to set
     */
    public void setAdressReceiver(String adressReceiver) {
        this.adressReceiver = adressReceiver;
    }
}
