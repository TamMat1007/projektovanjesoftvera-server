/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.server;

import java.net.ServerSocket;
import java.net.Socket;
import rs.ac.bg.fon.ps.communication.Receiver;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.communication.Sender;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.Delivery;
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.domain.Restaurant;

/**
 *
 * @author Tamara
 */
public class Server {
    
    public void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept(); //predstavlja klijenta
            System.out.println("Connected!");
            handleClient(socket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void handleClient(Socket socket) throws Exception {
        Sender sender = new Sender(socket);
        Receiver receiver = new Receiver(socket);

        while (true) {
            Request request = (Request) receiver.receive();
            Response response = new Response();
            try {
                switch (request.getOperation()) {
                    case LOGIN:
                        Operator operator = (Operator) request.getArgument();
                        response.setResult(Controller.getInstance().login(operator.getUsername(), operator.getPassword()));
                        break;
                    case GET_ALL_CITIES:
                        response.setResult(Controller.getInstance().getAllCities());
                        break;
                    case GET_ALL_DELIVERERS:
                        response.setResult(Controller.getInstance().getAllDeliverers());
                        break;
                    case GET_ALL_FREE_DELIVERERS_FROM_CITY:
                        City delivererCity = (City) request.getArgument();
                        response.setResult(Controller.getInstance().getAllFreeDeliverersFromCity(delivererCity));
                        break;
                    case ADD_DELIVERER:
                        Deliverer delivererInsert = (Deliverer) request.getArgument();
                        Controller.getInstance().addDeliverer(delivererInsert);
                        response.setResult(delivererInsert);
                        break;
                    case EDIT_DELIVERER:
                        Deliverer delivererEdit = (Deliverer) request.getArgument();
                        Controller.getInstance().editDeliverer(delivererEdit);
                        break;
                    case DELETE_DELIVERER:
                        Deliverer delivererDelete = (Deliverer) request.getArgument();
                        Controller.getInstance().deleteDeliverer(delivererDelete);
                        break;
                    case GET_ALL_RESTAURANTS:
                        response.setResult(Controller.getInstance().getAllRestaurants());
                        break;
                    case GET_ALL_RESTAURANTS_FROM_CITY:
                        City restaurantCity = (City) request.getArgument();
                        response.setResult(Controller.getInstance().getAllRestaurantsFromCity(restaurantCity));
                        break;
                    case GET_ALL_PRODUCTS_FROM_RESTAURANTS:
                        Restaurant productRestaurant=(Restaurant) request.getArgument();
                        response.setResult(Controller.getInstance().getAllProductsFromRestaurant(productRestaurant));
                        break;
                    case ADD_DELIVERY:
                        Delivery deliveryInsert = (Delivery) request.getArgument();
                        Controller.getInstance().saveDelivery(deliveryInsert);
                        response.setResult(deliveryInsert);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setException(e);
            }
            sender.send(response);
        }
    }
}
