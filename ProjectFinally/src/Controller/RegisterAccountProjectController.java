package Controller;

import View.RegisterAccountProjectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAccountProjectController implements ActionListener {
    private RegisterAccountProjectView finalExamProjectView;

    public RegisterAccountProjectController(RegisterAccountProjectView finalExamProjectView){
        this.finalExamProjectView = finalExamProjectView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println("ban da nhan nut");
        if (src.equals("Register")){
            this.finalExamProjectView.connectRegisterAndLogin();
        }
    }
}
