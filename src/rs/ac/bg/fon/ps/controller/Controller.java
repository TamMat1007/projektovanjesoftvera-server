/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.List;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Delivery;
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.Restaurant;
import rs.ac.bg.fon.ps.repository.Repository;
import rs.ac.bg.fon.ps.repository.db.DbRepository;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbCity;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbDeliverer;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbDelivery;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbOperator;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbProduct;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbRestaurant;

/**
 *
 * @author Tamara
 */
public class Controller {
    
    private final Repository repositoryOperator;
    private final Repository repositoryCity;
    private final Repository repositoryDeliverer;
    private final Repository repositoryRestaurant;
    private final Repository repositoryProduct;
    private final Repository repositoryDelivery;
    
    private static Controller controller;

    private Controller() {
        this.repositoryOperator = new RepositoryDbOperator();
        this.repositoryCity= new RepositoryDbCity();
        this.repositoryDeliverer= new RepositoryDbDeliverer();
        this.repositoryRestaurant=new RepositoryDbRestaurant();
        this.repositoryProduct= new RepositoryDbProduct();
        this.repositoryDelivery= new RepositoryDbDelivery();
    }
    
    public static Controller getInstance() {
        if(controller==null) controller=new Controller();
        return controller;
    }
    
    public Operator login(String username, String password) throws Exception{
        List<Operator> operators=repositoryOperator.getAll();
        for(Operator operater :operators){
            if(operater.getUsername().equals(username)&& operater.getPassword().equals(password)){
                return operater;
            }
        }
       // return null;
       throw new Exception("Unknown operator");
    }
    
    
    public List<City> getAllCities()throws Exception{
        List<City> cities=null;
        ((DbRepository)repositoryCity).connect();
        try{
            cities = repositoryCity.getAll();
            ((DbRepository)repositoryCity).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryCity).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryCity).disconnect();
        }
        return cities;
    }
    
    public void addDeliverer(Deliverer deliverer) throws Exception{
         ((DbRepository)repositoryDeliverer).connect();
        try{
            repositoryDeliverer.add(deliverer);
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
    }
    
    public List<Deliverer> getAllDeliverers() throws Exception{
          List<Deliverer> deliverers=null;
        ((DbRepository)repositoryDeliverer).connect();
        try{
            deliverers = repositoryDeliverer.getAll();
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
        return deliverers;
    }
    
    public List<Deliverer> getAllFreeDeliverersFromCity(City city) throws Exception{
        List<Deliverer> deliverers=null;
        String sql="SELECT d.delivererID as delivererID, d.delivererName as delivererName, delivererLastname,delivererPhone,delivererStatus, "
                + "c.cityID as cid, c.cityName as cname FROM deliverer d inner join city c ON (d.cityID=c.cityID) where d.cityID="+ city.getCityID()+" and delivererStatus='FREE'";
        ((DbRepository)repositoryDeliverer).connect();
        try{
            deliverers = repositoryDeliverer.findByQuery(sql);
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
        return deliverers;
    }

    public void deleteDeliverer(Deliverer deliverer) throws Exception {
       ((DbRepository)repositoryDeliverer).connect();
        try{
            repositoryDeliverer.delete(deliverer);
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
    }
    
     public void editDeliverer(Deliverer deliverer) throws Exception {
        ((DbRepository)repositoryDeliverer).connect();
        try{
            ((DbRepository)repositoryDeliverer).edit(deliverer);
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
    }

    public List<Restaurant> getAllRestaurantsFromCity(City city) throws Exception {
        List<Restaurant> restaurants=null;
        String sql="SELECT r.restaurantID as restaurantID, r.restaurantName as restaurantName, "
             + "restaurantAddress,restaurantPhone,openWorkingDay,closedWorkingDay,openWeekend,closedWeekend, c.cityID as cid, c.cityName as cname FROM restaurant r inner join city c ON (r.cityID=c.cityID) where r.cityID="+ city.getCityID();
        ((DbRepository)repositoryRestaurant).connect();
        try{
            restaurants = repositoryRestaurant.findByQuery(sql);
            ((DbRepository)repositoryRestaurant).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryRestaurant).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryRestaurant).disconnect();
        }
        return restaurants;
    }

    public List<Restaurant> getAllRestaurants() throws Exception {
          List<Restaurant> restaurants=null;
        ((DbRepository)repositoryRestaurant).connect();
        try{
            restaurants = repositoryRestaurant.getAll();
            ((DbRepository)repositoryRestaurant).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryRestaurant).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryRestaurant).disconnect();
        }
        return restaurants;
    }

    public List<Product> getAllProductsFromRestaurant(Restaurant restaurant) throws Exception {
        List<Product> products=null;
        String sql="SELECT productOrderNumber,productName,productPrice,currency,r.restaurantID as restaurantID, r.restaurantName as restaurantName ,restaurantAddress,"
                + "restaurantPhone,openWorkingDay,closedWorkingDay,openWeekend,closedWeekend,c.cityID AS cid, c.cityName AS cname"
                + " FROM product p INNER JOIN restaurant r ON(p.restaurantID=r.restaurantID)INNER JOIN city c ON (r.cityID=c.cityID)WHERE p.restaurantID="+ restaurant.getRestaurantID();
        ((DbRepository)repositoryProduct).connect();
        try{
            products = repositoryProduct.findByQuery(sql);
            ((DbRepository)repositoryProduct).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryProduct).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryProduct).disconnect();
        }
        return products;

    }   

    public void saveDelivery(Delivery delivery) throws Exception {
         ((DbRepository) repositoryDelivery).connect();
        try {
            repositoryDelivery.add(delivery);
            ((DbRepository) repositoryDelivery).commit();
        } catch (Exception e) {
            e.printStackTrace();
            ((DbRepository) repositoryDelivery).rollback();
            throw e;
        } finally {
            ((DbRepository) repositoryDelivery).disconnect();
        }
    }

    
}
