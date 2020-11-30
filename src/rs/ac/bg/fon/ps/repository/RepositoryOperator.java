/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Operator;

/**
 *
 * @author Tamara
 */
public class RepositoryOperator {
    private final List <Operator> operators;

    public RepositoryOperator() {
        this.operators=new ArrayList<Operator>(){
            {
                add(new Operator(1l, "Admin", "Admin", "admin", "admin"));
                add(new Operator(2l, "Admin2", "Admin2", "admin2", "admin2"));
                add(new Operator(3l, "Admin3", "Admin3", "admin3", "admin3"));
            }
        };
        //operators.add(new Operator(1l, "Admin", "Admin", "admin", "admin"));
    }

    public List<Operator> getOperators() {
        return operators;
    }
    
    
}
