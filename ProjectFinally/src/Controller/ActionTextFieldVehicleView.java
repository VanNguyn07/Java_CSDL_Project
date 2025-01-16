package Controller;

import View.VehicleManagerView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionTextFieldVehicleView implements KeyListener {

    private VehicleManagerView vehicleManagerView;

    public ActionTextFieldVehicleView(VehicleManagerView vehicleManagerView){
        this.vehicleManagerView = vehicleManagerView;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
      this.vehicleManagerView.checkTextFieldNameDriver();
      this.vehicleManagerView.checkTextFieldPhone();
      this.vehicleManagerView.checkTextFieldCCCD();
    }

}
