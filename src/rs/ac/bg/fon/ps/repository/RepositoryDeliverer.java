/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Deliverer;

/**
 *
 * @author Tamara
 */
public class RepositoryDeliverer {
    private final List<Deliverer> deliverers;
    
    public RepositoryDeliverer(){
        deliverers=new ArrayList<>();
    }
    
    public void add(Deliverer deliverer){
        deliverers.add(deliverer);
    }

    public List<Deliverer> getDeliverers() {
        return deliverers;
    }

    public void delete(Deliverer deliverer) throws Exception {
        int index=deliverers.indexOf(deliverer);
        if(index>=0){
            deliverers.remove(index);
        }else{
            throw new Exception("Error: Deliverer does not exist!");
        }
    }
    
   
    
}
