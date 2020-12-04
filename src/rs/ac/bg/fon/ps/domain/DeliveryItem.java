/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Tamara
 */
public class DeliveryItem {
    private int itemOrderNumber;
    private Delivery delivery;
    //Restaurant restaurant;
    private Product product;
    private BigDecimal productPrice;
    private BigDecimal quantity;
    private BigDecimal itemTotal;

    public DeliveryItem() {
    }

    public DeliveryItem(int itemOrderNumber, Delivery delivery, Product product, BigDecimal productPrice, BigDecimal quantity, BigDecimal itemAmount) {
        this.itemOrderNumber = itemOrderNumber;
        this.delivery = delivery;
        this.product = product;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.itemTotal = itemAmount;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getItemOrderNumber() {
        return itemOrderNumber;
    }

    public void setItemOrderNumber(int itemOrderNumber) {
        this.itemOrderNumber = itemOrderNumber;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DeliveryItem{" + "itemOrderNumber=" + itemOrderNumber + ", delivery=" + delivery + ", product=" + product + ", productPrice=" + productPrice + ", quantity=" + quantity + ", itemAmount=" + itemTotal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.itemOrderNumber;
        hash = 41 * hash + Objects.hashCode(this.delivery);
        hash = 41 * hash + Objects.hashCode(this.product);
        hash = 41 * hash + Objects.hashCode(this.productPrice);
        hash = 41 * hash + Objects.hashCode(this.quantity);
        hash = 41 * hash + Objects.hashCode(this.itemTotal);
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
        final DeliveryItem other = (DeliveryItem) obj;
        if (this.itemOrderNumber != other.itemOrderNumber) {
            return false;
        }
        if (!Objects.equals(this.delivery, other.delivery)) {
            return false;
        }
        return true;
    }
    
    
}
