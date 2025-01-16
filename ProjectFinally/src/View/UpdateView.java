package View;

import Controller.ActionButton;
import Controller.ActionTextFieldUpdateView;
import Controller.ActionTextFieldVehicleView;
import DAO.DAOVehicleManager;
import Model.DriverAndVehicleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;

public class UpdateView extends JFrame {
    Font font = new Font("Arial",Font.BOLD| Font.ITALIC,16);
    public JTextField textField_VehicleNo,textField_Phone,textField_NameDriver,textField_CCCD;
    private JRadioButton radioButton_male;
    private JRadioButton radioButton_female;
    private JComboBox<String> comboBox_day;
    private JComboBox<String> comboBox_month;
    private JComboBox<Object> comboBox_year;
    private JTextArea textArea_Area;

    private VehicleManagerView vehicleManagerView;
    private String vehicleNo;

    public UpdateView(VehicleManagerView vehicleManagerView,String vehicleNo){
        this.vehicleManagerView = vehicleManagerView;
        this.vehicleNo = vehicleNo;
        this.setTitle("Update Information");
        this.setSize(450,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.initJPanel();
        this.initIconUpdate();
        this.primaryKey();
        this.setVisible(true);
    }

    public void primaryKey(){
        // Đảm bảo set lại giá trị cho textField_VehicleNo
        if(vehicleNo != null){
            this.textField_VehicleNo.setText(vehicleNo);
            this.textField_VehicleNo.setEditable(false);
            this.textField_VehicleNo.setCaretPosition(0);
        }
    }

    public void initJPanel(){
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,this.getWidth(),this.getHeight());
//        panel.setBackground(Color.MAGENTA);
        this.add(panel);

        JLabel label_VehicleNo = new JLabel(" VehicleNo");
        label_VehicleNo.setBounds(30,30,90,20);
        label_VehicleNo.setFont(font);
//        label_VehicleNo.setBackground(Color.BLUE);
        label_VehicleNo.setOpaque(true);
        panel.add(label_VehicleNo);

        textField_VehicleNo = new JTextField();
        textField_VehicleNo.setFont(font);
        textField_VehicleNo.setBounds(150,30,160,20);
//        textField_VehicleNo.setCaretPosition(0);
        panel.add(textField_VehicleNo);

        JLabel label_NameDriver = new JLabel("Name Driver");
        label_NameDriver.setBounds(30,60,110,20);
        label_NameDriver.setFont(font);
//        label_NameDriver.setBackground(Color.BLUE);
//        label_NameDriver.setOpaque(true);
        panel.add(label_NameDriver);


        textField_NameDriver = new JTextField();
        textField_NameDriver.setFont(font);
        textField_NameDriver.setBounds(150,60,160,20);
        textField_NameDriver.addKeyListener(new ActionTextFieldUpdateView(this));
        panel.add(textField_NameDriver);

        JLabel label_Gender = new JLabel("Gender");
        label_Gender.setBounds(30,90,110,20);
        label_Gender.setFont(font);
//        label_Gender.setBackground(Color.BLUE);
//        label_Gender.setOpaque(true);
        panel.add(label_Gender);

        radioButton_male = new JRadioButton("Male");
        radioButton_male.setBounds(150,90,70,20);
        panel.add(radioButton_male);

        radioButton_female = new JRadioButton("Female");
        radioButton_female.setBounds(220,90,70,20);
        panel.add(radioButton_female);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton_male);
        buttonGroup.add(radioButton_female);

        JLabel label_Phone  = new JLabel("Telephone");
        label_Phone.setBounds(30,120,110,20);
        label_Phone.setFont(font);
//        label_Phone.setBackground(Color.BLUE);
//        label_Phone.setOpaque(true);
        panel.add(label_Phone);

        textField_Phone = new JTextField();
        textField_Phone.setFont(font);
        textField_Phone.setBounds(150,120,160,20);
        textField_Phone.addKeyListener(new ActionTextFieldUpdateView(this));
        panel.add(textField_Phone);

        JLabel label_DOB  = new JLabel("Date Of Birth");
        label_DOB.setBounds(30,150,110,20);
        label_DOB.setFont(font);
//        label_DOB.setBackground(Color.BLUE);
//        label_DOB.setOpaque(true);
        panel.add(label_DOB);

        String day [] ={"01","02","03","04","05","06","07","08","09"};
        comboBox_day = new JComboBox<>(day);
        comboBox_day.setBounds(150,150,40,20);
        panel.add(comboBox_day);
        for (int i = 10; i <= 31; i++){
            comboBox_day.addItem(i+"");
        }

        String month [] ={"01","02","03","04","05","06","07","08","09"};
        comboBox_month = new JComboBox<>(month);
        comboBox_month.setBounds(200,150,40,20);
        panel.add(comboBox_month);
        for (int i = 10; i <= 12; i++){
            comboBox_month.addItem(i+"");
        }

        comboBox_year = new JComboBox<>();
        comboBox_year.setBounds(250,150,60,20);
        for (int i = 1970; i <= 2006; i++){
            comboBox_year.addItem(i+"");
        }
        panel.add(comboBox_year);

        JLabel label_CCCD  = new JLabel("CCCD");
        label_CCCD.setBounds(30,180,110,20);
        label_CCCD.setFont(font);
//        label_CCCD.setBackground(Color.BLUE);
        label_CCCD.setOpaque(true);
        panel.add(label_CCCD);

        textField_CCCD = new JTextField();
        textField_CCCD.setFont(font);
        textField_CCCD.setBounds(150,180,160,20);
        textField_CCCD.addKeyListener(new ActionTextFieldUpdateView(this));
        panel.add(textField_CCCD);

        JLabel label_Area  = new JLabel("Area");
        label_Area.setBounds(30,210,110,20);
        label_Area.setFont(font);
//        label_Area.setBackground(Color.BLUE);
        label_Area.setOpaque(true);
        panel.add(label_Area);

        textArea_Area = new JTextArea();
        textArea_Area.setFont(font);
        textArea_Area.setBounds(150,210,160,50);
        textArea_Area.setWrapStyleWord(true);// xuống dòng tại ranh giới của từ
        textArea_Area.setLineWrap(true);// xuống dòng tự động
        panel.add(textArea_Area);

        ActionListener ac = new ActionButton(this);
        JButton button_Ok = new JButton("OK");
        button_Ok.setBounds(330,260,80,40);
        button_Ok.addActionListener(ac);
        panel.add(button_Ok);
    }

    public void executeUpdate(){
        if (textField_NameDriver.getText().trim().isEmpty() ||
                textField_Phone.getText().trim().isEmpty() ||
                textField_CCCD.getText().trim().isEmpty() ||
                textArea_Area.getText().trim().isEmpty() ||
                textField_VehicleNo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String gender ="";
        if (radioButton_male.isSelected()){
            gender = this.radioButton_male.getText();
        } else if (radioButton_female.isSelected()) {
            gender = this.radioButton_female.getText();
        }else{
            JOptionPane.showMessageDialog(this,"Please select gender!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String day = (String) comboBox_day.getSelectedItem();
        String month = (String)comboBox_month.getSelectedItem();
        String year = (String)comboBox_year.getSelectedItem();

        String DOB = year + "-" + month + "-" + day;

        Date sqlDate = null;
        try{
            sqlDate = java.sql.Date.valueOf(DOB);
        }catch (IllegalArgumentException e){
             JOptionPane.showMessageDialog(this,"Invalid date of birth","Warning",JOptionPane.WARNING_MESSAGE);
        }

        DriverAndVehicleModel da = new DriverAndVehicleModel(textField_NameDriver.getText(),
                gender,
                textField_Phone.getText(),
                sqlDate,
                textField_CCCD.getText(),
                textArea_Area.getText(),
                textField_VehicleNo.getText());

        DAOVehicleManager.getInstance().update(da);

        // UPDATE dữ liệu ở bảng
        int selectedRow = vehicleManagerView.detailTable.getSelectedRow();
        if (selectedRow != -1){
            vehicleManagerView.defaultTableModel.setValueAt(textField_NameDriver.getText(),selectedRow,0);
            vehicleManagerView.defaultTableModel.setValueAt(gender,selectedRow,1);
            vehicleManagerView.defaultTableModel.setValueAt(textField_Phone.getText(),selectedRow,2);
            vehicleManagerView.defaultTableModel.setValueAt(sqlDate,selectedRow,3);
            vehicleManagerView.defaultTableModel.setValueAt(textField_CCCD.getText(),selectedRow,4);
            vehicleManagerView.defaultTableModel.setValueAt(textArea_Area.getText(),selectedRow,5);
            JOptionPane.showMessageDialog(this,"Updated Successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
        }
        this.dispose(); // Đóng cửa sổ UpdateView
        vehicleManagerView.setVisible(true); // Hiển thị lại VehicleManagerView
    }
    public void checkTextFieldNameDriverUpdate(){
        String regex = "^[a-zA-z]+$";

        String  getDataFromTextFieldNameDriver = textField_NameDriver.getText();
        if (!getDataFromTextFieldNameDriver.matches(regex)){
            textField_NameDriver.setText(getDataFromTextFieldNameDriver.replaceAll("[^a-zA-z]",""));
        }
    }

    public void checkTextFieldCCCDUpdate(){

        String regex = "\\d+";// only input number and don't accept String Empty

        String getDataFromTextFieldCCCD = textField_CCCD.getText();

        if (!getDataFromTextFieldCCCD.matches(regex)){
            textField_CCCD.setText(getDataFromTextFieldCCCD.replaceAll("[^\\d]",""));
        }
    }
    public void checkTextFieldPhoneUpdate(){

        String regex = "\\d+";// only input number and don't accept String Empty

        String getDataFromTextFieldPhone = textField_Phone.getText();

        if (!getDataFromTextFieldPhone.matches(regex)){
            textField_Phone.setText(getDataFromTextFieldPhone.replaceAll("[^\\d]",""));
        }
    }

    public void initIconUpdate(){
        URL urlIconUpdate = UpdateView.class.getResource("Update.png");
        Image imageIconUpdate = Toolkit.getDefaultToolkit().createImage(urlIconUpdate);
        this.setIconImage(imageIconUpdate);
    }
}
