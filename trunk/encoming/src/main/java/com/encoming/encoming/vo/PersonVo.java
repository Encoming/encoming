/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.vo;

/**
 *
 * @author germanpinerosm
 */
public class PersonVo implements IValueObject {
    
    private Integer idPerson;
    private String name;
    private String lastanames;
    private String mail;
    private Integer phone;
    private String adress;

    /**
     * @return the idPerson
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

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
     * @return the lastanames
     */
    public String getLastanames() {
        return lastanames;
    }

    /**
     * @param lastanames the lastanames to set
     */
    public void setLastanames(String lastanames) {
        this.lastanames = lastanames;
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
    
}
