/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.DelivererStatus;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbDeliverer implements DbRepository<Deliverer> {

    @Override
    public List<Deliverer> getAll() {
        try {
            String sql = "SELECT d.delivererID as delivererID, d.delivererName as delivererName, "
             + "delivererLastname,delivererPhone,delivererStatus, c.cityID as cid, c.cityName as cname FROM deliverer d inner join city c ON (d.cityID=c.cityID)";
            List<Deliverer> deliverers = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Deliverer deliverer=new Deliverer();
                deliverer.setDelivererID(rs.getLong("delivererID"));
                deliverer.setDelivererName(rs.getString("delivererName"));
                deliverer.setDelivererLastname(rs.getString("delivererLastname"));
                deliverer.setDelivererPhone(rs.getString("delivererPhone"));
                deliverer.setDelivererStatus(DelivererStatus.valueOf(rs.getString("delivererStatus")));
                
                City city=new City();
                city.setCityID(rs.getLong("cid"));
                city.setCityName(rs.getString("cname"));
                
                deliverer.setDelivererCity(city);
                deliverers.add(deliverer);
            }
            rs.close();
            statement.close();
            return deliverers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void add(Deliverer deliverer) throws Exception {
        try {
            String sql = "INSERT INTO deliverer(delivererName,delivererLastname,delivererPhone,delivererStatus,cityID) VALUES(?,?,?,?,?)";

            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, deliverer.getDelivererName());
            statement.setString(2, deliverer.getDelivererLastname());
            statement.setString(3, deliverer.getDelivererPhone());
            statement.setString(4, deliverer.getDelivererStatus().toString());
            statement.setLong(5, deliverer.getDelivererCity().getCityID());
            statement.executeUpdate();
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long delivererID = rsKey.getLong(1);
                deliverer.setDelivererID(delivererID);
            } else {
                throw new Exception("Deliverer id is not generated!");
            }
            rsKey.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Deliverer can not be saved");
        }
    }

    @Override
    public void edit(Deliverer deliverer) throws Exception {
        try {
            String sql="UPDATE deliverer SET "
                    + "delivererName='"+deliverer.getDelivererName()+"', "
                    + "delivererLastname='"+deliverer.getDelivererLastname()+"', "
                    + "delivererPhone='"+deliverer.getDelivererPhone()+"',"
                    + "delivererStatus='"+deliverer.getDelivererStatus()+"',"
                    + "cityID="+deliverer.getDelivererCity().getCityID()+" "
            + "WHERE delivererID="+deliverer.getDelivererID();
            System.out.println(sql);
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update deliverer DB error: \n" + ex.getMessage());
        }
      }

    @Override
    public void delete(Deliverer deliverer) throws Exception {
        try {
            String sql="DELETE FROM deliverer WHERE delivererID="+deliverer.getDelivererID();
            System.out.println(sql);
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Delete product DB error: \n"+ex.getMessage());
        }
      }

    @Override
    public List<Deliverer> findByQuery(String sql) throws Exception {
        try {
            List<Deliverer> deliverers = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Deliverer deliverer=new Deliverer();
                deliverer.setDelivererID(rs.getLong("delivererID"));
                deliverer.setDelivererName(rs.getString("delivererName"));
                deliverer.setDelivererLastname(rs.getString("delivererLastname"));
                deliverer.setDelivererPhone(rs.getString("delivererPhone"));
                deliverer.setDelivererStatus(DelivererStatus.valueOf(rs.getString("delivererStatus")));
                
                City city=new City();
                city.setCityID(rs.getLong("cid"));
                city.setCityName(rs.getString("cname"));
                
                deliverer.setDelivererCity(city);
                deliverers.add(deliverer);

            }
            rs.close();
            statement.close();
            return deliverers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
