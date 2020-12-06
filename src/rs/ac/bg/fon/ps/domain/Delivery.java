/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private BigDecimal deliveryCost;
    private BigDecimal itemsAmount;
    private Operator operator;
    private Deliverer deliverer;
    private List <DeliveryItem> deliveryItems;

    public Delivery() {
        this.deliveryItems=new ArrayList<>();
        this.itemsAmount=BigDecimal.ZERO;
    }

    public Delivery(Long deliveryID, Date dateOfCreation, DeliveryStatus deliveryStatus, String consumerAddress, String consumerPhone, BigDecimal deliveryCost, BigDecimal itemsAmount, Operator operator, Deliverer deliverer, List<DeliveryItem> deliveryItems) {
        this.deliveryID = deliveryID;
        this.dateOfCreation = dateOfCreation;
        this.deliveryStatus = deliveryStatus;
        this.consumerAddress = consumerAddress;
        this.consumerPhone = consumerPhone;
        this.deliveryCost = deliveryCost;
        this.itemsAmount = itemsAmount;
        this.operator = operator;
        this.deliverer = deliverer;
        this.deliveryItems = deliveryItems;
    }


    public BigDecimal getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(BigDecimal itemsAmount) {
        this.itemsAmount = itemsAmount;
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

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

     public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public List <DeliveryItem> getDeliveryItems() {
        return deliveryItems;
    }

    public void setDeliveryItems(List <DeliveryItem> deliveryItems) {
        this.deliveryItems = deliveryItems;
        
    }
    
    
    @Override
    public String toString() {
        return deliveryID + ", date=" + dateOfCreation ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.deliveryID);
        hash = 83 * hash + Objects.hashCode(this.dateOfCreation);
        hash = 83 * hash + Objects.hashCode(this.deliveryStatus);
        hash = 83 * hash + Objects.hashCode(this.consumerAddress);
        hash = 83 * hash + Objects.hashCode(this.consumerPhone);
        hash = 83 * hash + Objects.hashCode(this.deliveryCost);
        hash = 83 * hash + Objects.hashCode(this.itemsAmount);
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
