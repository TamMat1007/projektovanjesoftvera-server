/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Delivery;
import rs.ac.bg.fon.ps.domain.DeliveryItem;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbDelivery implements DbRepository<Delivery>{

     @Override
    public void add(Delivery delivery) throws Exception {
//       try {
//            Connection connection = DBConnectionFactory.getInstance().getConnection();
//            String sql = "INSERT INTO delivery(dateOfCreation,deliveryStatus,consumerAddress,consumerPhone,deliveryCost,totalAmount,operatorID,delivererID) VALUES (?,?,?,?,?,?,?,?)";
//            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            statement.setDate(1,new java.sql.Date(delivery.getDateOfCreation().getTime()));
//            statement.setString(2,String.valueOf(delivery.getDeliveryStatus()));
//            statement.setString(3,delivery.getConsumerAddress());
//            statement.setString(4,delivery.getConsumerPhone());
//            statement.setBigDecimal(5, delivery.getDeliveryCost());
//            statement.setBigDecimal(6, delivery.getItemsAmount());
//            statement.setInt(7,(delivery.getOperator().getOperatorID()));
//            statement.setInt(8,(delivery.getDeliverer().getDelivererID()));
//            
//            statement.executeUpdate();
//            ResultSet rsKey = statement.getGeneratedKeys();
//            if (rsKey.next()) {
//                Long deliveryID = rsKey.getLong(1);
//                delivery.setDeliveryID(deliveryID);
//                sql = "INSERT INTO deliveryitem(deliveryID,itemOrderNumber,product_id,price,quantity,unit,total) VALUES (?,?,?,?,?,?,?)";
//                statement = connection.prepareStatement(sql);
//                for (DeliveryItem item : delivery.getDeliveryItems()) {
//                    statement.setLong(1, delivery.getDeliveryID());
//                    statement.setLong(2, item.getItemOrderNumber());
//             //       statement.setLong(3, item.getProduct().getProductID());
//                    statement.setBigDecimal(4, item.getProductPrice());
//                    statement.setBigDecimal(5, item.getQuantity());
//                    statement.setBigDecimal(6, item.getItemTotal());
//                    statement.executeUpdate();
//                }
//            } else {
//                throw new Exception("Delivery id is not generated!");
//            }
//            rsKey.close();
//            statement.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
    }
    
    @Override
    public List<Delivery> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Delivery param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Delivery param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Delivery> findByQuery(String sql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
