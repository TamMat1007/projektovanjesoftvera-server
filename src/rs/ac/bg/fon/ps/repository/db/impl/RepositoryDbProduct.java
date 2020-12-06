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
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.Restaurant;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbProduct implements DbRepository<Product> {

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Product param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Product param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findByQuery(String sql) throws Exception {
        try {
            List<Product> products = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Product product=new Product();
                product.setProductOrderNumber(rs.getInt("productOrderNumber"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getBigDecimal("productPrice"));
                product.setCurrency(rs.getString("currency"));
                
                Restaurant restaurant=new Restaurant();
                restaurant.setRestaurantID(rs.getLong("r.restaurantID"));
                restaurant.setRestaurantName(rs.getString("r.restaurantName"));
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
                product.setRestaurant(restaurant);
                products.add(product);


            }
            rs.close();
            statement.close();
            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
}
