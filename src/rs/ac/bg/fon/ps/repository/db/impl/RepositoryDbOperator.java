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
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DbRepository;

/**
 *
 * @author Tamara
 */
public class RepositoryDbOperator implements DbRepository<Operator> {

    @Override
    public List<Operator> getAll() {
        try {
            String sql = "SELECT * FROM operator";
            List<Operator> operators = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Operator operator = new Operator();
                operator.setOperatorID(rs.getLong("operatorID"));
                operator.setOperatorName(rs.getString("operatorName"));
                operator.setOperatorLastname(rs.getString("operatorLastname"));
                operator.setUsername(rs.getString("username"));
                operator.setPassword(rs.getString("password"));
                operators.add(operator);
            }
            rs.close();
            statement.close();
            return operators;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void add(Operator param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Operator param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Operator param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
