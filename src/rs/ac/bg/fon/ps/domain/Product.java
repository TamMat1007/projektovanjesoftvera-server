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
public class Product {
    private Restaurant restaurant;
    private int productOrderNumber;
    private String productName;
    private BigDecimal productPrice;
    private String currency;

    public Product() {
    }

    public Product(Restaurant restaurant, int productOrderNumber, String productName, BigDecimal productPrice, String currency) {
        this.restaurant = restaurant;
        this.productOrderNumber = productOrderNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getProductOrderNumber() {
        return productOrderNumber;
    }

    public void setProductOrderNumber(int productOrderNumber) {
        this.productOrderNumber = productOrderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return getProductName() ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.restaurant);
        hash = 53 * hash + this.productOrderNumber;
        hash = 53 * hash + Objects.hashCode(this.productName);
        hash = 53 * hash + Objects.hashCode(this.productPrice);
        hash = 53 * hash + Objects.hashCode(this.currency);
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
        final Product other = (Product) obj;
        if (this.productOrderNumber != other.productOrderNumber) {
            return false;
        }
        if (!Objects.equals(this.restaurant, other.restaurant)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
