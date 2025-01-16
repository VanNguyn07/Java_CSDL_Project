package Controller;

import View.VehicleManagerView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController implements MouseListener {

    private VehicleManagerView vehicleManagerView;

    public MouseController(VehicleManagerView vehicleManagerView){
        this.vehicleManagerView = vehicleManagerView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.vehicleManagerView.clickTable();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
