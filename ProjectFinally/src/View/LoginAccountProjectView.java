package View;

import Controller.LoginAccountProjectController;
import Database.ConnectionJDBC;
import Model.AccountManager;
import Model.LoginAccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginAccountProjectView extends JFrame {
    private JPanel panel,panel2;
    private JTextField textField;
    private JPasswordField passwordField;
//    private AccountManager accountManager ;
    public LoginAccountProjectView(){

//        this.accountManager = new AccountManager();

        this.setTitle("Login");
        this.setSize(580,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.JPanelForImage();
        this.initIcon();
        this.initJPanel();

        JPanelDraw jPanelDraw = new JPanelDraw("VehicleJPanel1.jpg","Login Account");
        jPanelDraw.setBounds(0,0,this.getWidth(),150);
        panel.add(jPanelDraw);
        this.add(panel);
        this.setVisible(true);
    }

    public void JPanelForImage(){
        panel = new JPanel(null);
        panel.setBounds(0,0,this.getWidth(),150);
        panel.setBackground(Color.GRAY);
        this.add(panel);

    }

    public void initIcon(){
        URL urlIcon = LoginAccountProjectView.class.getResource("Icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(image);
    }

    public void initJPanel(){
        panel2 = new JPanel(null);
        panel2.setBounds(0,150,this.getWidth(),250);
        panel2.setBackground(Color.CYAN);

        JLabel label = new JLabel("Enter Your Username");
        label.setBounds(50,30,200,30);
        label.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        panel2.add(label);

        JLabel label2 = new JLabel("Enter Your Password");
        label2.setBounds(50,80,200,30);
        label2.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        panel2.add(label2);

        textField = new JTextField();
        textField.setBounds(270,30,220,25);
        panel2.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(270,80,220,25);
        panel2.add(passwordField);

        ActionListener ac = new LoginAccountProjectController(this);

        JButton button = new JButton("Login");
        button.setBounds(50,150,300,30);
        button.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        button.addActionListener(ac);
        panel2.add(button);

        JButton button_register = new JButton("Register");
        button_register.setBounds(370,150,120,30);
        button_register.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        button_register.addActionListener(ac);
        panel2.add(button_register);
        this.add(panel2);
    }

    public boolean callVehicleManagerView(){
        String userName = this.textField.getText().trim();
        String password = new String(this.passwordField.getPassword()).trim();

        AccountManager acc = new AccountManager();// tạo mới đối tượng AccountManager để use phương thức getInstance
        ArrayList<String> arr = acc.getInstance(userName,password);
        System.out.println("Array: " + arr);
        if (arr.size() >= 2){
//            textField.setText(arr.get(0));
//            passwordField.setText(arr.get(1));
            JOptionPane.showMessageDialog(this,"Login successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
            new VehicleManagerView();
            this.dispose();
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "No accounts found in the database or you have not entered", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
            }

    public void callRegisterAccountProjectView() {
        new RegisterAccountProjectView();
        this.dispose();
    }
}

class JPanelDraw extends JPanel{
    private Image image;
    private String text;

    public JPanelDraw(String imagePath, String text){
        this.image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(LoginAccountProjectView.class.getResource(imagePath))).getImage();
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image,0,0,this.getWidth(),150,this);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,50));

        g.drawString(text,100,90);
    }
    }

