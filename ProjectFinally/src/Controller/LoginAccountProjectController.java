package Controller;

import View.LoginAccountProjectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAccountProjectController implements ActionListener {
    private LoginAccountProjectView loginAccountProjectView;

    public LoginAccountProjectController(LoginAccountProjectView loginAccountProjectView){
        this.loginAccountProjectView = loginAccountProjectView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Login")){
            this.loginAccountProjectView.callVehicleManagerView();
        } else if (src.equals("Register")) {
            this.loginAccountProjectView.callRegisterAccountProjectView();
        }
    }
}
