/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.util.Objects;

/**
 *
 * @author Tamara
 */
public class Deliverer {
    private Long delivererID;
    private String delivererName;
    private String delivererLastname;
    private String delivererPhone;
    //enum?
    private DelivererStatus delivererStatus;
    private City delivererCity;

    public Deliverer() {
    }

    public Deliverer(Long delivererID, String delivererName, String delivererLastname, String delivererPhone, DelivererStatus delivererStatus, City delivererCity) {
        this.delivererID = delivererID;
        this.delivererName = delivererName;
        this.delivererLastname = delivererLastname;
        this.delivererPhone = delivererPhone;
        this.delivererStatus = delivererStatus;
        this.delivererCity = delivererCity;
    }

    public Long getDelivererID() {
        return delivererID;
    }

    public void setDelivererID(Long delivererID) {
        this.delivererID = delivererID;
    }

    public String getDelivererName() {
        return delivererName;
    }

    public void setDelivererName(String delivererName) {
        this.delivererName = delivererName;
    }

    public String getDelivererLastname() {
        return delivererLastname;
    }

    public void setDelivererLastname(String delivererLastname) {
        this.delivererLastname = delivererLastname;
    }

    public String getDelivererPhone() {
        return delivererPhone;
    }

    public void setDelivererPhone(String delivererPhone) {
        this.delivererPhone = delivererPhone;
    }

    public DelivererStatus getDelivererStatus() {
        return delivererStatus;
    }

    public void setDelivererStatus(DelivererStatus delivererStatus) {
        this.delivererStatus = delivererStatus;
    }

    public City getDelivererCity() {
        return delivererCity;
    }

    public void setDelivererCity(City delivererCity) {
        this.delivererCity = delivererCity;
    }

    @Override
    public String toString() {
        return getDelivererName()+" "+ getDelivererLastname();
        //return "Deliverer{" + "DelivererID=" + delivererID + ", DelivererName=" + delivererName + ", DelivererLastname=" + delivererLastname + ", DelivererPhone=" + delivererPhone + ", delivererStatus=" + delivererStatus + ", city=" + delivererCity + '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.delivererID);
        hash = 71 * hash + Objects.hashCode(this.delivererName);
        hash = 71 * hash + Objects.hashCode(this.delivererLastname);
        hash = 71 * hash + Objects.hashCode(this.delivererPhone);
        hash = 71 * hash + Objects.hashCode(this.delivererStatus);
        hash = 71 * hash + Objects.hashCode(this.delivererCity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deliverer other = (Deliverer) obj;
        if (!Objects.equals(this.delivererID, other.delivererID)) {
            return false;
        }
        return true;
    }
    
    
}
