/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tamara
 */
public class Delivery {
    private Long deliveryID;
    private Date dateOfCreation;
    private DeliveryStatus deliveryStatus;
    private String consumerAddress;
    private String consumerPhone;
    private Double deliveryPrice;
    private Double totalAmount;

    public Delivery() {
    }

    public Delivery(Long deliveryID, Date dateOfCreation, DeliveryStatus deliveryStatus, String consumerAddress, String consumerPhone, Double deliveryPrice, Double totalAmount) {
        this.deliveryID = deliveryID;
        this.dateOfCreation = dateOfCreation;
        this.deliveryStatus = deliveryStatus;
        this.consumerAddress = consumerAddress;
        this.consumerPhone = consumerPhone;
        this.deliveryPrice = deliveryPrice;
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Long deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(String consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    public String getConsumerPhone() {
        return consumerPhone;
    }

    public void setConsumerPhone(String consumerPhone) {
        this.consumerPhone = consumerPhone;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return "Delivery{" + "deliveryID=" + deliveryID + ", dateOfCreation=" + dateOfCreation + ", deliveryStatus=" + deliveryStatus + ", consumerAddress=" + consumerAddress + ", consumerPhone=" + consumerPhone + ", deliveryPrice=" + deliveryPrice + ", totalAmount=" + totalAmount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.deliveryID);
        hash = 83 * hash + Objects.hashCode(this.dateOfCreation);
        hash = 83 * hash + Objects.hashCode(this.deliveryStatus);
        hash = 83 * hash + Objects.hashCode(this.consumerAddress);
        hash = 83 * hash + Objects.hashCode(this.consumerPhone);
        hash = 83 * hash + Objects.hashCode(this.deliveryPrice);
        hash = 83 * hash + Objects.hashCode(this.totalAmount);
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
        final Delivery other = (Delivery) obj;
        if (!Objects.equals(this.deliveryID, other.deliveryID)) {
            return false;
        }
        return true;
    }
    
    
}
