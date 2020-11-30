/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.City;

/**
 *
 * @author Tamara
 */
public class RepositoryCity {

    private final List<City> cities;

    public RepositoryCity() {
        cities = new ArrayList<City>() {
            {
                add(new City(1l, "CityA"));
                add(new City(2l, "CityB"));
                add(new City(3l, "CityC"));
                add(new City(4l, "CityD"));
                
            }
        };
    }

    public List<City> getCities() {
        return cities;
    }

}
