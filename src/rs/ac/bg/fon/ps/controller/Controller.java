/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.List;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.repository.Repository;
import rs.ac.bg.fon.ps.repository.db.DbRepository;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbCity;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbDeliverer;
import rs.ac.bg.fon.ps.repository.db.impl.RepositoryDbOperator;
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
    
    private static Controller controller;

    private Controller() {
        this.repositoryOperator = new RepositoryDbOperator();
        this.repositoryCity= new RepositoryDbCity();
        this.repositoryDeliverer= new RepositoryDbDeliverer();
        this.repositoryRestaurant=new RepositoryDbRestaurant();
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
    
    
    public List<City> getAllCities(){
        return repositoryCity.getAll();
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
          List<Deliverer> products=null;
        ((DbRepository)repositoryDeliverer).connect();
        try{
            products = repositoryDeliverer.getAll();
            ((DbRepository)repositoryDeliverer).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DbRepository)repositoryDeliverer).rollback();
            throw e;
        }finally{
            ((DbRepository)repositoryDeliverer).disconnect();
        }
        return products;
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

//    public List<Restaurant> getAllRestaurants(City city) throws Exception {
//         List<Restaurant> restaurants=null;
//        ((DbRepository)repositoryRestaurant).connect();
//        try{
//            restaurants = repositoryRestaurant.getAll(city);
//            ((DbRepository)repositoryRestaurant).commit();
//        }catch(Exception e){
//            e.printStackTrace();
//            ((DbRepository)repositoryRestaurant).rollback();
//            throw e;
//        }finally{
//            ((DbRepository)repositoryRestaurant).disconnect();
//        }
//        return restaurants;
//    }

    
}
