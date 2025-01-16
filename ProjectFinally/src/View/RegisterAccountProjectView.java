package View;

import Controller.RegisterAccountProjectController;
import DAO.DAOVehicleManager;
import Database.ConnectionJDBC;
import Model.AccountManager;
import Model.DriverAndVehicleModel;
import Model.LoginAccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class RegisterAccountProjectView extends JFrame {
    private JPanel panel, panel2;
    private JTextField textField_username;
    private JPasswordField passwordField;
    private AccountManager accountManager;
    private JPasswordField confirmPasswordField;

    public RegisterAccountProjectView(){
//        this.accountManager = new AccountManager();
        this.setTitle("Register");
        this.setSize(580,450);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initJPanelForImage();
        this.initJLabelJTextFieldJButtonForJPanel();
        this.initIcon();

        this.setVisible(true);
    }

    public void initJPanelForImage(){
        panel = new JPanel(null);
        panel.setBounds(0,0,this.getWidth(),150);
        panel.setBackground(Color.RED);
        InitVehicleDrawFromJPanel initVehicleDrawFromJPanel = new InitVehicleDrawFromJPanel("VehicleJPanel.png","Account Registration");
        initVehicleDrawFromJPanel.setBounds(0,0,this.getWidth(),150);
        panel.add(initVehicleDrawFromJPanel);
        this.add(panel);
    }

    public void initJLabelJTextFieldJButtonForJPanel(){
        panel2 = new JPanel(null);
        panel2.setBounds(0,150,this.getWidth(),300);
        panel2.setBackground(Color.LIGHT_GRAY);

        JLabel labelTextFiled = new JLabel("Enter Your Username");
        labelTextFiled.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        labelTextFiled.setBounds(50,30,200,30);
        panel2.add(labelTextFiled);

        JLabel labelTextFiled2 = new JLabel("Enter Your Password");
        labelTextFiled2.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        labelTextFiled2.setBounds(50,80,200,30);
        panel2.add(labelTextFiled2);

        JLabel labelTextFiled3 = new JLabel("Confirm Your Password");
        labelTextFiled3.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        labelTextFiled3.setBounds(50,130,200,30);
        panel2.add(labelTextFiled3);

        textField_username = new JTextField();
        textField_username.setBounds(270,30,220,25);
        panel2.add(textField_username);

        passwordField = new JPasswordField();
        passwordField.setBounds(270,80,220,25);
        panel2.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(270,130,220,25);
        panel2.add(confirmPasswordField);
// TẠO NÚT NHẤN ĐĂNG KÍ TÀI KHOẢN VÀ XỬ LÍ HÀNH ĐỘNG KHI NHẤN
        ActionListener ac = new RegisterAccountProjectController(this);

        JButton button = new JButton("Register");
        button.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        button.setBounds(50,200,440,30);
        button.addActionListener(ac);
        panel2.add(button);
        this.add(panel2);
    }

    public void initIcon(){
        URL urlIcon = RegisterAccountProjectView.class.getResource("Icon.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(img);
    }

    public boolean connectRegisterAndLogin(){
        String userName = this.textField_username.getText();
        String password = new String(this.passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.equals(confirmPassword)){
            if (!userName.isEmpty() && !password.isEmpty()){

                DriverAndVehicleModel dri = new DriverAndVehicleModel(userName,password);

                DAOVehicleManager.getInstance().insertRegister(dri);// add account vào CSDL
                JOptionPane.showMessageDialog(this, "Account successfully registered!","Success",JOptionPane.INFORMATION_MESSAGE);

                //mở giao diện đăng nhập
                new LoginAccountProjectView();
                this.dispose();// đóng  cửa sổ hiện tại
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
        }
        return false;
    }
}
class InitVehicleDrawFromJPanel extends JPanel{
    private Image image;
    private String text;

    public InitVehicleDrawFromJPanel(String imagePath,String text){
        this.image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(RegisterAccountProjectView.class.getResource(imagePath))).getImage();
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);// this ở đây là cái JPanel

        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Arial",Font.BOLD| Font.ITALIC,40));

        g.drawString(text,100,90);
    }
}

