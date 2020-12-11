/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.DelivererStatus;
import rs.ac.bg.fon.ps.domain.Restaurant;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbRestaurant implements DbRepository<Restaurant>{

    @Override
    public List<Restaurant> getAll() {
         try {
            String sql = "SELECT r.restaurantID as restaurantID, r.restaurantName as restaurantName, "
             + "restaurantAddress,restaurantPhone,openWorkingDay,closedWorkingDay,openWeekend,closedWeekend, c.cityID as cid, c.cityName as cname FROM restaurant r inner join city c ON (r.cityID=c.cityID)";
            List<Restaurant> restaurants = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Restaurant restaurant=new Restaurant();
                restaurant.setRestaurantID(rs.getLong("restaurantID"));
                restaurant.setRestaurantName(rs.getString("restaurantName"));
                restaurant.setRestaurantAddress(rs.getString("restaurantAddress"));
                restaurant.setRestaurantPhone(rs.getString("restaurantPhone"));
                Date oworkingd=new Date(rs.getDate("openWorkingDay").getTime());
                restaurant.setOpenWorkingDay(oworkingd);
                Date cworkingd=new Date(rs.getDate("closedWorkingDay").getTime());
                restaurant.setClosedWorkingDay(cworkingd);
                Date oweekd=new Date(rs.getDate("openWeekend").getTime());
                restaurant.setOpenWeekend(oweekd);
                Date cweekd=new Date(rs.getDate("closedWeekend").getTime());
                restaurant.setClosedWeekend(cweekd);
                
                City city=new City();
                city.setCityID(rs.getLong("cid"));
                city.setCityName(rs.getString("cname"));
                
                restaurant.setCity(city);
                restaurants.add(restaurant);
            }
            rs.close();
            statement.close();
            return restaurants;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(Restaurant param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Restaurant param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Restaurant param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurant> findByQuery(String sql) {
        try {
            List<Restaurant> restaurants = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Restaurant restaurant=new Restaurant();
                restaurant.setRestaurantID(rs.getLong("restaurantID"));
                restaurant.setRestaurantName(rs.getString("restaurantName"));
                restaurant.setRestaurantAddress(rs.getString("restaurantAddress"));
                restaurant.setRestaurantPhone(rs.getString("restaurantPhone"));
                Date oworkingd=new Date(rs.getDate("openWorkingDay").getTime());
                restaurant.setOpenWorkingDay(oworkingd);
                Date cworkingd=new Date(rs.getDate("closedWorkingDay").getTime());
                restaurant.setOpenWorkingDay(cworkingd);
                Date oweekd=new Date(rs.getDate("openWeekend").getTime());
                restaurant.setOpenWorkingDay(oweekd);
                Date cweekd=new Date(rs.getDate("closedWeekend").getTime());
                restaurant.setOpenWorkingDay(cweekd);
                
                City city=new City();
                city.setCityID(rs.getLong("cid"));
                city.setCityName(rs.getString("cname"));
                
                restaurant.setCity(city);
                restaurants.add(restaurant);

            }
            rs.close();
            statement.close();
            return restaurants;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    
}
