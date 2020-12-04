/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.List;

/**
 *
 * @author Tamara
 */
public interface Repository<T> {
    List<T> getAll();
    void add(T param)throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;

   // T get(K id);
    
   // List<T> getAll(City city);

    
}
