package Controller;

import View.UpdateView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionTextFieldUpdateView implements KeyListener {

    private UpdateView updateView;

    public ActionTextFieldUpdateView(UpdateView updateView){
        this.updateView  = updateView;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    this.updateView.checkTextFieldNameDriverUpdate();
    this.updateView.checkTextFieldPhoneUpdate();
    this.updateView.checkTextFieldCCCDUpdate();
    }
}
