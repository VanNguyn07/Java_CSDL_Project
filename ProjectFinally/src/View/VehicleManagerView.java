package View;

import Controller.ActionButton;
import Controller.ActionTextFieldVehicleView;
import Controller.MouseController;
import DAO.DAOSearch;
import DAO.DAOVehicleManager;
import Database.ConnectionJDBC;
import Model.SearchModel;
import Model.DriverAndVehicleModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;

public class VehicleManagerView extends JFrame {
    Font font = new Font("Arial",Font.BOLD|Font.ITALIC,16);
    private JButton button_Add, button_Delete, button_Update, button_Reset, button_search, button_GoBack;
    private JFrame frame;
    public JTable detailTable;
    public JTextField textField_VehicleNo;
    private JScrollPane scrollPane_Table;
    public JTextField textField_Name,textField_Phone,textField_CCCD,textField_VehicleName;
    private JRadioButton radioButton_Male,radioButton_Female;
    private JComboBox<Object> comboBox_Date,comboBox_Month,comboBox_Year;
    private JTextArea textArea_Area;
    private JComboBox<String> comboBox_Vehicle;
    public DefaultTableModel defaultTableModel;
    private ButtonGroup group;
    private int selectedRow;

    public VehicleManagerView(){

        this.setTitle("Vehicle Manager System");
        this.setSize(910,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.labelTitle();
        this.infoDriver();
        this.infoVehicle();
        this.detailTable();
        this.initIcon();
        this.setVisible(true);
    }

    public void labelTitle(){
        JPanel panel_Title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_Title.setBounds(0,0,this.getWidth(),60);
//        panel_Title.setBackground(Color.MAGENTA);

        JLabel label_Title = new JLabel("Vehicle Manager System",JLabel.CENTER);
        label_Title.setFont(new Font("Serif" , Font.CENTER_BASELINE, 40));
        label_Title.setBorder(BorderFactory.createEmptyBorder(3,0,0,0));
        panel_Title.add(label_Title);

        this.add(panel_Title);
    }

    public void infoDriver(){
        JPanel panel_Driver = new JPanel(null);
        panel_Driver.setBounds(25,65,400,300);
//        panel_Driver.setBackground(Color.GRAY);

        JLabel label_Name = new JLabel("Name Driver");
        label_Name.setFont(font);
        label_Name.setBounds(30,30,100,20);
//        label_Name.setBackground(Color.MAGENTA);
        label_Name.setOpaque(true);

//        ActionTextFieldVehicleView ac = new ActionTextFieldVehicleView(this);

        textField_Name = new JTextField();
        textField_Name.setBounds(180,30,160,20);
        textField_Name.setFont(font);
        textField_Name.addKeyListener(new ActionTextFieldVehicleView(this));

        panel_Driver.add(textField_Name);
        panel_Driver.add(label_Name);

        JLabel label_Gender = new JLabel("Gender");
        label_Gender.setFont(font);
        label_Gender.setBounds(30,70,100,20);
//        label_Gender.setBackground(Color.MAGENTA);
        label_Gender.setOpaque(true);

        radioButton_Male = new JRadioButton("Male");
        radioButton_Male.setBounds(180,70,70,20);

        radioButton_Female = new JRadioButton("Female");
        radioButton_Female.setBounds(250,70,70,20);

        group = new ButtonGroup();
        group.add(radioButton_Male);
        group.add(radioButton_Female);
        group.clearSelection();

        panel_Driver.add(label_Gender);
        panel_Driver.add(radioButton_Male);
        panel_Driver.add(radioButton_Female);

        JLabel label_Phone = new JLabel("Telephone");
        label_Phone.setFont(font);
        label_Phone.setBounds(30,110,100,20);
//        label_Phone.setBackground(Color.MAGENTA);
        label_Phone.setOpaque(true);

        textField_Phone = new JTextField();
        textField_Phone.setBounds(180,110,160,20);
        textField_Phone.setFont(font);
        textField_Phone.addKeyListener(new ActionTextFieldVehicleView(this));
        textField_Phone.setCaretPosition(0);

        panel_Driver.add(textField_Phone);
        panel_Driver.add(label_Phone);

        JLabel label_DOB = new JLabel("Date Of Birth");
        label_DOB.setFont(font);
        label_DOB.setBounds(30,150,110,20);
//        label_DOB.setBackground(Color.MAGENTA);
        label_DOB.setOpaque(true);

        String [] date = {"01","02","03","04","05","06","07","08","09"};
        comboBox_Date = new JComboBox<>(date);
        comboBox_Date.setBounds(180,150,40,20);
        for (int i = 10; i <= 31; i++){
            comboBox_Date.addItem(i+"");
        }

        String [] month = {"01","02","03","04","05","06","07","08","09"};
        comboBox_Month = new JComboBox<>(month);
        comboBox_Month.setBounds(230,150,40,20);
        for (int i = 10; i <= 12; i++){
            comboBox_Month.addItem(i+"");
        }

        comboBox_Year = new JComboBox<>();
        comboBox_Year.setBounds(280,150,60,20);
        for (int i = 1970; i <= 2006; i++){
            comboBox_Year.addItem(i+"");
        }

        panel_Driver.add(label_DOB);
        panel_Driver.add(comboBox_Date);
        panel_Driver.add(comboBox_Month);
        panel_Driver.add(comboBox_Year);

        JLabel label_CCCD = new JLabel("CCCD");
        label_CCCD.setFont(font);
        label_CCCD.setBounds(30,190,80,20);
//        label_CCCD.setBackground(Color.MAGENTA);
        label_CCCD.setOpaque(true);

        textField_CCCD = new JTextField();
        textField_CCCD.setBounds(180,190,160,20);
        textField_CCCD.setFont(font);
        textField_CCCD.addKeyListener(new ActionTextFieldVehicleView(this));

        panel_Driver.add(label_CCCD);
        panel_Driver.add(textField_CCCD);

        JLabel label_Area = new JLabel("Area");
        label_Area.setFont(font);
        label_Area.setBounds(30,230,80,20);
//        label_Area.setBackground(Color.MAGENTA);
        label_Area.setOpaque(true);

        textArea_Area = new JTextArea();
        textArea_Area.setLineWrap(true);
        textArea_Area.setWrapStyleWord(true);
        textArea_Area.setFont(font);

        JScrollPane scrollPane_Area = new JScrollPane(textArea_Area);
        scrollPane_Area.setBounds(180,230,160,50);

        panel_Driver.add(label_Area);
        panel_Driver.add(scrollPane_Area);

        Border border_info = BorderFactory.createLineBorder(Color.RED,3);
        TitledBorder titledBorder_info = BorderFactory.createTitledBorder(border_info,"Driver Information");
        panel_Driver.setBorder(titledBorder_info);

        this.add(panel_Driver);
    }

    public void infoVehicle(){
        JPanel panel_Vehicle = new JPanel(null);
        panel_Vehicle.setBounds(465,65,410,300);
//        panel_Vehicle.setBackground(Color.yellow);

        JLabel label_Vehicle = new JLabel("Vehicle Type");
        label_Vehicle.setFont(font);
        label_Vehicle.setBounds(30,30,100,20);
//        label_Vehicle.setBackground(Color.MAGENTA);
        label_Vehicle.setOpaque(true);

        String vehicleType [] = {"Car", "Motorbike"};
        comboBox_Vehicle = new JComboBox<>(vehicleType);
        comboBox_Vehicle.setBounds(180,30,90,20);

        panel_Vehicle.add(label_Vehicle);
        panel_Vehicle.add(comboBox_Vehicle);

        JLabel label_VehicleName = new JLabel("Vehicle Name");
        label_VehicleName.setFont(font);
        label_VehicleName.setBounds(30,80,110,20);
//        label_VehicleName.setBackground(Color.MAGENTA);
        label_VehicleName.setOpaque(true);

        textField_VehicleName = new JTextField();
        textField_VehicleName.setBounds(180,80,160,20);
        textField_VehicleName.setFont(font);

        panel_Vehicle.add(label_VehicleName);
        panel_Vehicle.add(textField_VehicleName);

        JLabel label_VehicleNo = new JLabel("Vehicle.No");
        label_VehicleNo.setFont(font);
        label_VehicleNo.setBounds(30,130,110,20);
//        label_VehicleNo.setBackground(Color.MAGENTA);
//        label_VehicleNo.setOpaque(true);

        textField_VehicleNo = new JTextField();
        textField_VehicleNo.setBounds(180,130,160,20);
        textField_VehicleNo.setFont(font);

        panel_Vehicle.add(label_VehicleNo);
        panel_Vehicle.add(textField_VehicleNo);

        Border border_Vehicle = BorderFactory.createLineBorder(Color.RED,3);
        TitledBorder titledBorder_Vehicle = BorderFactory.createTitledBorder(border_Vehicle,"Vehicle Information");
        panel_Vehicle.setBorder(titledBorder_Vehicle);

        ActionListener ac = new ActionButton(this);

        ImageIcon imageIcon_Add = new ImageIcon(getClass().getResource("IconAdd.png"));
        button_Add = new JButton("Add",imageIcon_Add);
        button_Add.setFont(font);
        button_Add.setBounds(30,180,116,40);
        button_Add.setBackground(Color.GREEN);
        button_Add.addActionListener(new ActionButton(this));
//        button_Add.addActionListener(ac);

        ImageIcon imageIcon_Delete = new ImageIcon(getClass().getResource("IconDelete.png"));
        button_Delete = new JButton("Delete",imageIcon_Delete);
        button_Delete.setFont(font);
        button_Delete.setBounds(155,180,115,40);
        button_Delete.setBackground(Color.RED);
        button_Delete.addActionListener(ac);

        ImageIcon imageIcon_Update = new ImageIcon(getClass().getResource("IconUpdate.png"));
        button_Update = new JButton("Update",imageIcon_Update);
        button_Update.setFont(font);
        button_Update.setBounds(30,240,116,40);
        button_Update.setBackground(Color.GREEN);
        button_Update.addActionListener(ac);

        ImageIcon imageIcon_Statistics = new ImageIcon(getClass().getResource("Reset.png"));
        button_Reset = new JButton("Reset",imageIcon_Statistics);
        button_Reset.setFont(font);
        button_Reset.setBounds(155,240,116,40);
        button_Reset.setBackground(Color.GREEN);
        button_Reset.addActionListener(new ActionButton(this));

        ImageIcon imageIcon_Search = new ImageIcon(getClass().getResource("Search.png"));
        button_search = new JButton("Search", imageIcon_Search);
        button_search.setFont(font);
        button_search.setBounds(280,180,115,40);
        button_search.setBackground(Color.GREEN);
        button_search.addActionListener(new ActionButton(this));

        ImageIcon imageIcon_GoBack = new ImageIcon(getClass().getResource("GoBack.png"));
        button_GoBack = new JButton("Back", imageIcon_GoBack);
        button_GoBack.setFont(font);
        button_GoBack.setBounds(280,240,115,40);
        button_GoBack.setBackground(Color.GREEN);
        button_GoBack.addActionListener(new ActionButton(this));

        panel_Vehicle.add(button_Add);
        panel_Vehicle.add(button_Delete);
        panel_Vehicle.add(button_Update);
        panel_Vehicle.add(button_Reset);
        panel_Vehicle.add(button_search);
        panel_Vehicle.add(button_GoBack);
        this.add(panel_Vehicle);
    }

    public void executeBack(){
        try{
            Connection connection = ConnectionJDBC.getConnection();

            String sql = "SELECT * FROM Table_Project_Finally ";
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);

            int countColumn = rs.getMetaData().getColumnCount();
            defaultTableModel.setColumnCount(0);
            defaultTableModel.setRowCount(0);
            for(int i = 1; i <= countColumn; i++){
                defaultTableModel.addColumn(rs.getMetaData().getColumnName(i));
            }

            Object [] row = new Object[countColumn];
            while (rs.next()){
                for(int i = 1; i <= countColumn; i++){
                    row[i-1] = rs.getObject(i);
                }
                defaultTableModel.addRow(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void resetUI(){
        textField_Name.setText("");
        textField_Phone.setText("");
        textArea_Area.setText("");
        textField_VehicleName.setText("");
        textField_CCCD.setText("");
        textField_VehicleNo.setText("");
        group.clearSelection();
        comboBox_Date.setSelectedIndex(0);
        comboBox_Month.setSelectedIndex(0);
        comboBox_Year.setSelectedIndex(0);
        comboBox_Vehicle.setSelectedIndex(0);
    }

    public void searchUI(){
        this.setVisible(false);
        new SearchView(this);
    }

    public void detailTable(){
        JPanel panel_Table = new JPanel(null);
        panel_Table.setBounds(0,380,this.getWidth(),130);

        MouseController mouseController = new MouseController(this);

        defaultTableModel = new DefaultTableModel();// tạo mô hình gồm column, row

        try{
            Connection connection = ConnectionJDBC.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Table_Project_Finally";

            ResultSet resultSet = statement.executeQuery(sql);

            int countColumn = resultSet.getMetaData().getColumnCount();// get metaData or get numbers column in table SQL server

            for (int i = 1; i <= countColumn; i++){
                defaultTableModel.addColumn(resultSet.getMetaData().getColumnName(i)); // get name of columns in table SQL server and add default
            }

            Object row [] = new Object[countColumn];
            while(resultSet.next()){// Duyệt qua từng hàng trong bảng
                for (int i = 1; i <= countColumn; i++){
                    row [i - 1] = resultSet.getObject(i);//lấy dữ liệu ở hàng thứ i thuộc cột thứ i
                }
                defaultTableModel.addRow(row);
            }

            connection.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        detailTable = new JTable(defaultTableModel);

        detailTable.addMouseListener(mouseController);

        scrollPane_Table = new JScrollPane(detailTable);
        scrollPane_Table.setBounds(20,0, 855,130);

        Border border_Table = BorderFactory.createLineBorder(Color.RED,3);
        TitledBorder titledBorder_Table = BorderFactory.createTitledBorder(border_Table,"Details All Information");
        scrollPane_Table.setBorder(titledBorder_Table);

//        subPanel_Table.add(scrollPane_Table);
        panel_Table.add(scrollPane_Table);
        this.add(panel_Table);
    }

    public void initIcon(){
        URL urlIcon = VehicleManagerView.class.getResource("IconVehicle.png");
        Image imageIcon = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(imageIcon);
    }

    public void clickTable() {

        selectedRow = detailTable.getSelectedRow();
        System.out.println("Selected Row: " + selectedRow);

        this.textField_Name.setText(detailTable.getValueAt(selectedRow,0).toString());
        //getValueAt trả về một đối tượng
        if (detailTable.getValueAt(selectedRow,1).equals("Male")){
            this.radioButton_Male.setSelected(true);
        }else if(detailTable.getValueAt(selectedRow,1).equals("Female")){
            this.radioButton_Female.setSelected(true);
        }

        this.textField_Phone.setText(detailTable.getValueAt(selectedRow,2).toString().trim());
//        System.out.println(defaultTableModel.getValueAt(selectedRow,2));
//        this.textField_Phone.setCaretPosition(0);

        String dob = detailTable.getValueAt(selectedRow,3).toString();

        String [] dobParts = dob.split("-");// tách chuỗi ra thành năm tháng ngày
        comboBox_Year.setSelectedItem(dobParts[0]);
        comboBox_Month.setSelectedItem(dobParts[1]);
        comboBox_Date.setSelectedItem(dobParts[2]);

        this.textField_CCCD.setText(detailTable.getValueAt(selectedRow,4).toString());

        this.textArea_Area.setText(detailTable.getValueAt(selectedRow,5).toString());

        String vehicleType = detailTable.getValueAt(selectedRow,6).toString();
        comboBox_Vehicle.setSelectedItem(vehicleType);

        this.textField_VehicleName.setText(detailTable.getValueAt(selectedRow,7).toString());

        this.textField_VehicleNo.setText(detailTable.getValueAt(selectedRow,8).toString().trim());
//        this.textField_VehicleNo.setCaretPosition(0);
    }

        public void executeAdd(){
            try{
                if (textField_Name.getText().trim().isEmpty() ||
                        textField_Phone.getText().trim().isEmpty() ||
                        textField_CCCD.getText().trim().isEmpty() ||
                        textArea_Area.getText().trim().isEmpty() ||
                        textField_VehicleName.getText().trim().isEmpty() ||
                        textField_VehicleNo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill out all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String gender;
                if (radioButton_Male.isSelected()){
                    gender =  this.radioButton_Male.getText();
                }else if (radioButton_Female.isSelected()){
                    gender = this.radioButton_Female.getText();
                }else{
                    JOptionPane.showMessageDialog(this, "Please select gender!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String day = (String) comboBox_Date.getSelectedItem();
                String month = (String) comboBox_Month.getSelectedItem();
                String year = (String) comboBox_Year.getSelectedItem();

                String DOB =  year + "-" + month + "-" + day;
                Date sqlDate;
                try {
                    sqlDate = Date.valueOf(DOB); // Chuyển đổi sang java.sql.Date
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Invalid date of birth!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String vehicleType = (String) comboBox_Vehicle.getSelectedItem();

                DriverAndVehicleModel davm; // đối tượng chứa dữ liệu
                davm = new DriverAndVehicleModel(textField_Name.getText(),// truyền các trường dữ liệu mà user nhập
                        gender,
                        textField_Phone.getText(),
                        sqlDate,
                        textField_CCCD.getText(),
                        textArea_Area.getText(),
                        vehicleType,
                        textField_VehicleName.getText(),
                        textField_VehicleNo.getText());
                if (ConnectionJDBC.getConnection() != null){

                    int result =  DAOVehicleManager.getInstance().insert(davm);

                    if (result > 0){
                        JOptionPane.showMessageDialog(this,"You have successfully registered! ","Success",JOptionPane.INFORMATION_MESSAGE);
                        // Thêm dữ liệu vào bảng
                        Object addRowValue [] = {textField_Name.getText(),
                                gender,
                                textField_Phone.getText(),
                                sqlDate,
                                textField_CCCD.getText(),
                                textArea_Area.getText(),
                                vehicleType,
                                textField_VehicleName.getText(),
                                textField_VehicleNo.getText()};

                                defaultTableModel.addRow(addRowValue);

                    }else{
                        JOptionPane.showMessageDialog(this,"Account has existed","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, " connection null!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"An error occurred","Error",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        public void executeDelete(){
            DriverAndVehicleModel dr = new DriverAndVehicleModel(textField_VehicleNo.getText());
            DAOVehicleManager.getInstance().delete(dr);

            textField_Name.setText("");
            group.clearSelection();
            textField_Phone.setText("");
            comboBox_Date.setSelectedIndex(0);
            comboBox_Month.setSelectedIndex(0);
            comboBox_Year.setSelectedIndex(0);
            textField_CCCD.setText("");
            textArea_Area.setText("");
            textField_VehicleName.setText("");
            textField_VehicleNo.setText("");
            comboBox_Vehicle.setSelectedIndex(0);

            selectedRow = detailTable.getSelectedRow();

            if(selectedRow != -1){
                defaultTableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this,"You have deleted your account","Success",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Please select a account to Delete","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }

        public void executeUpdateOfVehicleView() {
            selectedRow = detailTable.getSelectedRow();

            if (selectedRow != -1){
                String getVehicleNoFromTable = (String) this.defaultTableModel.getValueAt(selectedRow,8);
                System.out.println("Vehile No" + getVehicleNoFromTable);
                new UpdateView(this,getVehicleNoFromTable);
                this.setVisible(false);// Ẩn vehicleManagerView
            }else{
                JOptionPane.showMessageDialog(this,"Please you must to account to Update","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }

        public void checkTextFieldPhone(){

            String regex = "\\d+";// only input number and don't accept String Empty

            String getDataFromTextFieldPhone = textField_Phone.getText();

            if (!getDataFromTextFieldPhone.matches(regex)){
                textField_Phone.setText(getDataFromTextFieldPhone.replaceAll("[^\\d]",""));
            }
        }

        public void checkTextFieldCCCD(){

            String regex = "\\d+";// only input number and don't accept String Empty

            String getDataFromTextFieldCCCD = textField_CCCD.getText();

            if (!getDataFromTextFieldCCCD.matches(regex)){
                textField_CCCD.setText(getDataFromTextFieldCCCD.replaceAll("[^\\d]",""));
            }
        }

        public void checkTextFieldNameDriver(){
        String regex = "^[a-zA-Z ]+$";

        String getDataFromTextFieldNameDriver = textField_Name.getText();

        if (!getDataFromTextFieldNameDriver.matches(regex)){
            textField_Name.setText(getDataFromTextFieldNameDriver.replaceAll("[^a-zA-Z ]",""));// dấu ^ trong[] là phủ định
        }
        }
}
