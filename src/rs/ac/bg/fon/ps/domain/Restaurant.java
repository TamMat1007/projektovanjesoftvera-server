/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import com.mysql.cj.util.TimeUtil;
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
    private TimeUtil openWorkingDay;
    private TimeUtil closedWorkingDay;
    private TimeUtil openWeekend;
    private TimeUtil closedWeekend;

    public Restaurant() {
    }

    public Restaurant(Long restaurantID, String restaurantName, String restaurantAddress, String restaurantPhone, TimeUtil openWorkingDay, TimeUtil closedWorkingDay, TimeUtil openWeekend, TimeUtil closedWeekend) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
        this.openWorkingDay = openWorkingDay;
        this.closedWorkingDay = closedWorkingDay;
        this.openWeekend = openWeekend;
        this.closedWeekend = closedWeekend;
    }

    public TimeUtil getClosedWeekend() {
        return closedWeekend;
    }

    public void setClosedWeekend(TimeUtil closedWeekend) {
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

    public TimeUtil getOpenWorkingDay() {
        return openWorkingDay;
    }

    public void setOpenWorkingDay(TimeUtil openWorkingDay) {
        this.openWorkingDay = openWorkingDay;
    }

    public TimeUtil getClosedWorkingDay() {
        return closedWorkingDay;
    }

    public void setClosedWorkingDay(TimeUtil closedWorkingDay) {
        this.closedWorkingDay = closedWorkingDay;
    }

    public TimeUtil getOpenWeekend() {
        return openWeekend;
    }

    public void setOpenWeekend(TimeUtil openWeekend) {
        this.openWeekend = openWeekend;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "restaurantID=" + restaurantID + ", restaurantName=" + restaurantName + ", restaurantAddress=" + restaurantAddress + ", restaurantPhone=" + restaurantPhone + ", openWorkingDay=" + openWorkingDay + ", closedWorkingDay=" + closedWorkingDay + ", openWeekend=" + openWeekend + ", closedWeekend=" + closedWeekend + '}';
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
