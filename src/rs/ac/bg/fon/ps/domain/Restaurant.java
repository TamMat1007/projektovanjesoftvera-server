/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import com.mysql.cj.util.TimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Tamara
 */
public class Restaurant {
    private Long restaurantID;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
    private Date openWorkingDay;
    private Date closedWorkingDay;
    private Date openWeekend;
    private Date closedWeekend;
    private City city;
    private List<Product> products;

            
    public Restaurant() {
        products=new ArrayList<>();
    }

    public Restaurant(Long restaurantID, String restaurantName, String restaurantAddress, String restaurantPhone, Date openWorkingDay, Date closedWorkingDay, Date openWeekend, Date closedWeekend,City city) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        this.openWorkingDay = openWorkingDay;
        this.closedWorkingDay = closedWorkingDay;
        this.openWeekend = openWeekend;
        this.closedWeekend = closedWeekend;
        this.city=city;
    }

    public Date getClosedWeekend() {
        return closedWeekend;
    }

    public void setClosedWeekend(Date closedWeekend) {
        this.closedWeekend = closedWeekend;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public Date getOpenWorkingDay() {
        return openWorkingDay;
    }

    public void setOpenWorkingDay(Date openWorkingDay) {
        this.openWorkingDay = openWorkingDay;
    }

    public Date getClosedWorkingDay() {
        return closedWorkingDay;
    }

    public void setClosedWorkingDay(Date closedWorkingDay) {
        this.closedWorkingDay = closedWorkingDay;
    }

    public Date getOpenWeekend() {
        return openWeekend;
    }

    public void setOpenWeekend(Date openWeekend) {
        this.openWeekend = openWeekend;
    }
    
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    

    @Override
    public String toString() {
        return  restaurantName ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.restaurantID);
        hash = 47 * hash + Objects.hashCode(this.restaurantName);
        hash = 47 * hash + Objects.hashCode(this.restaurantAddress);
        hash = 47 * hash + Objects.hashCode(this.restaurantPhone);
        hash = 47 * hash + Objects.hashCode(this.openWorkingDay);
        hash = 47 * hash + Objects.hashCode(this.closedWorkingDay);
        hash = 47 * hash + Objects.hashCode(this.openWeekend);
        hash = 47 * hash + Objects.hashCode(this.closedWeekend);
        
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
        final Restaurant other = (Restaurant) obj;
        if (!Objects.equals(this.restaurantName, other.restaurantName)) {
            return false;
        }
        return true;
    }

   
    
    
}
