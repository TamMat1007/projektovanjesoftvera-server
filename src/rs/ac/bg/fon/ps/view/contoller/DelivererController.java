/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.City;
import rs.ac.bg.fon.ps.domain.Deliverer;
import rs.ac.bg.fon.ps.domain.DelivererStatus;
import rs.ac.bg.fon.ps.domain.Operator;
import rs.ac.bg.fon.ps.view.constant.Constants;
import rs.ac.bg.fon.ps.view.cordinator.MainCordinator;
import rs.ac.bg.fon.ps.view.form.FrmDeliverer;
import rs.ac.bg.fon.ps.view.form.util.FormMode;

/**
 *
 * @author Tamara
 */
public class DelivererController {
    private final FrmDeliverer frmDeliverer;

    public DelivererController(FrmDeliverer frmDeliverer) {
        this.frmDeliverer=frmDeliverer;
        addActionListeners();
    }

    public void openForm(FormMode formMode) {
        Operator operator = (Operator) MainCordinator.getInstance().getParam(Constants.PARAM_CURRENT_OPERATOR);
        frmDeliverer.getLblCurrentOperator().setText("Current operator: "+operator.getOperatorName()+" " + operator.getOperatorLastname());
        frmDeliverer.setLocationRelativeTo(MainCordinator.getInstance().getMainContoller().getFrmMain());
        prepareView(formMode);
        frmDeliverer.setVisible(true);
    }

    private void addActionListeners() {
        frmDeliverer.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
            private void save() {
                Deliverer deliverer=getDelivererFromForm();
                try {
                    Controller.getInstance().addDeliverer(deliverer);
                    JOptionPane.showMessageDialog(frmDeliverer, "Deliverer successfully saved");
                    frmDeliverer.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(FrmDeliverer.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(frmDeliverer, ex.getMessage());
                }
            }
        });
        
        frmDeliverer.addEnableChangesBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }
        });

        frmDeliverer.addCancelBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
            private void cancel() {
                frmDeliverer.dispose();
            }
        });

        frmDeliverer.addDeleteBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                Deliverer deliverer = getDelivererFromForm();
                try {
                    Controller.getInstance().deleteDeliverer(deliverer);
                    JOptionPane.showMessageDialog(frmDeliverer, "Deliverer deleted successfully!\n", "Delete deliverer", JOptionPane.INFORMATION_MESSAGE);
                    frmDeliverer.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmDeliverer, "Error deleting deliverer!\n" + ex.getMessage(), "Delete deliverer", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DelivererController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        frmDeliverer.addEditBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

            private void edit() {
                Deliverer deliverer = getDelivererFromForm();
                try {
                    Controller.getInstance().editDeliverer(deliverer);
                    JOptionPane.showMessageDialog(frmDeliverer, "Deliverer changed successfully!\n", "Edit deliverer", JOptionPane.INFORMATION_MESSAGE);
                    frmDeliverer.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmDeliverer, "Error editting deliverer!\n" + ex.getMessage(), "Edit deliverer", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DelivererController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    
    private void prepareView(FormMode formMode) {
        fillCbDelivererStatus();
        fillCbDelivererCity();
        setupComponents(formMode);
    }
 
    private void fillCbDelivererStatus() {
        frmDeliverer.getCbDelivererStatus().removeAllItems();
        for(DelivererStatus status:DelivererStatus.values()){
            frmDeliverer.getCbDelivererStatus().addItem(status);
        }
    }

    private void fillCbDelivererCity() {
        frmDeliverer.getCbDelivererCity().removeAllItems();
        List<City> cities=Controller.getInstance().getAllCities();
        for(City city: cities){
            frmDeliverer.getCbDelivererCity().addItem(city);
        }
    }     
    
    private void setupComponents(FormMode formMode) {
        switch(formMode){
            case FORM_ADD:
                frmDeliverer.getBtnCancel().setEnabled(true);
                frmDeliverer.getBtnDelete().setEnabled(false);
                frmDeliverer.getBtnEdit().setEnabled(false);
                frmDeliverer.getBtnEnableChanges().setEnabled(false);
                frmDeliverer.getBtnSave().setEnabled(true);

                frmDeliverer.getTxtDelivererID().setEnabled(true);
                frmDeliverer.getTxtDelivererName().setEnabled(true);
                frmDeliverer.getTxtDelivererLastname().setEnabled(true);
                frmDeliverer.getTxtDelivererPhone().setEnabled(true);
                frmDeliverer.getCbDelivererStatus().setEnabled(true);
                frmDeliverer.getCbDelivererCity().setEnabled(true);
                break;
            case FORM_VIEW:
                frmDeliverer.getBtnCancel().setEnabled(true);
                frmDeliverer.getBtnDelete().setEnabled(true);
                frmDeliverer.getBtnEdit().setEnabled(false);
                frmDeliverer.getBtnEnableChanges().setEnabled(true);
                frmDeliverer.getBtnSave().setEnabled(false);

                frmDeliverer.getTxtDelivererID().setEnabled(false);
                frmDeliverer.getTxtDelivererName().setEnabled(false);
                frmDeliverer.getTxtDelivererLastname().setEnabled(false);
                frmDeliverer.getTxtDelivererPhone().setEnabled(false);
                frmDeliverer.getCbDelivererStatus().setEnabled(false);
                frmDeliverer.getCbDelivererCity().setEnabled(false);

                //get deliverer
                Deliverer deliverer = (Deliverer) MainCordinator.getInstance().getParam(Constants.PARAM_DELIVERER);
                frmDeliverer.getTxtDelivererID().setText(deliverer.getDelivererID()+ "");
                frmDeliverer.getTxtDelivererName().setText(deliverer.getDelivererName());
                frmDeliverer.getTxtDelivererLastname().setText(deliverer.getDelivererLastname());
                frmDeliverer.getTxtDelivererPhone().setText(deliverer.getDelivererPhone());
                frmDeliverer.getCbDelivererStatus().setSelectedItem(DelivererStatus.valueOf(deliverer.getDelivererStatus().toString()));
                frmDeliverer.getCbDelivererCity().setSelectedItem(deliverer.getDelivererCity());
                break;
            case FORM_EDIT:
                frmDeliverer.getBtnCancel().setEnabled(true);
                frmDeliverer.getBtnDelete().setEnabled(false);
                frmDeliverer.getBtnEdit().setEnabled(true);
                frmDeliverer.getBtnEnableChanges().setEnabled(false);
                frmDeliverer.getBtnSave().setEnabled(false);

                //zabrani izmenu vrednosti
                frmDeliverer.getTxtDelivererID().setEnabled(false);
                frmDeliverer.getTxtDelivererName().setEnabled(true);
                frmDeliverer.getTxtDelivererLastname().setEnabled(true);
                frmDeliverer.getTxtDelivererPhone().setEnabled(true);
                frmDeliverer.getCbDelivererStatus().setEnabled(true);
                frmDeliverer.getCbDelivererCity().setEnabled(true);
                break;
        }
    }
    
    
    private Deliverer getDelivererFromForm() {
        Deliverer deliverer = new Deliverer();
                    deliverer.setDelivererID(Long.parseLong(frmDeliverer.getTxtDelivererID().getText().trim()));
                    deliverer.setDelivererName(frmDeliverer.getTxtDelivererName().getText().trim());
                    deliverer.setDelivererLastname(frmDeliverer.getTxtDelivererLastname().getText().trim());
                    deliverer.setDelivererPhone(frmDeliverer.getTxtDelivererPhone().getText().trim());
                    deliverer.setDelivererStatus((DelivererStatus) frmDeliverer.getCbDelivererStatus().getSelectedItem());
                    deliverer.setDelivererCity((City) frmDeliverer.getCbDelivererCity().getSelectedItem());
                    return deliverer;
    }

}
