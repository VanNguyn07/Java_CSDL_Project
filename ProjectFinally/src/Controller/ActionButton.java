package Controller;

import View.SearchView;
import View.UpdateView;
import View.VehicleManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton implements ActionListener {

    private VehicleManagerView vehicleManagerView;
    private UpdateView updateView;
    private SearchView searchView;

    public ActionButton(VehicleManagerView vehicleManagerView){
        this.vehicleManagerView = vehicleManagerView;
    }

    public  ActionButton(UpdateView updateView){
        this.updateView = updateView;
    }

    public ActionButton(SearchView searchView){
        this.searchView = searchView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Add")){
            this.vehicleManagerView.executeAdd();
        } else if (src.equals("Delete")) {
            this.vehicleManagerView.executeDelete();
        } else if (src.equals("Update")) {
            this.vehicleManagerView.executeUpdateOfVehicleView();
        } else if (src.equals("OK")) {
//            ((UpdateView) SwingUtilities.getWindowAncestor((Component) e.getSource())).update(); // Gọi `update` từ `UpdateView`
            this.updateView.executeUpdate();
        }else if(src.equals("Reset")){
            this.vehicleManagerView.resetUI();
        } else if (src.equals("Confirm")) {
            this.searchView.executeSearch();
        } else if (src.equals("Search")) {
            this.vehicleManagerView.searchUI();
        } else if (src.equals("Back")) {
            this.vehicleManagerView.executeBack();
        }
    }
}
