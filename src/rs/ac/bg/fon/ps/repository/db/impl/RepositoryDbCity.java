/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.DelivererStatus;
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbCity implements DbRepository<City> {

    @Override
    public List<City> getAll() {
        try {
            String sql = "SELECT * FROM city";
            List<City> cities = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                City city=new City();
                city.setCityID(rs.getLong("cityID"));
                city.setCityName(rs.getString("cityName"));
                
                cities.add(city);
            }
            rs.close();
            statement.close();
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void add(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
