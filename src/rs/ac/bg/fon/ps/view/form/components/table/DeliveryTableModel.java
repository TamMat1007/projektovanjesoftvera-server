/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.form.components.table;

import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Delivery;
import rs.ac.bg.fon.ps.domain.DeliveryItem;

/**
 *
 * @author Tamara
 */
public class DeliveryTableModel extends AbstractTableModel{
    private final Delivery delivery;
    private final String[] columnNames={"Order No.","Product","Product price", "Quantity","Total"};

    public DeliveryTableModel(Delivery delivery) {
        this.delivery = delivery;
    }
    

    @Override
    public int getRowCount() {
        if (delivery.getDeliveryItems()==null) return 0;
        return delivery.getDeliveryItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DeliveryItem deliveryItem = delivery.getDeliveryItems().get(rowIndex);
        switch(columnIndex){
            case 0: return deliveryItem.getItemOrderNumber();
            case 1: return deliveryItem.getProduct();
            case 2: return deliveryItem.getProductPrice();
            case 3: return deliveryItem.getQuantity();
            case 4: return deliveryItem.getItemTotal();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
    
}
