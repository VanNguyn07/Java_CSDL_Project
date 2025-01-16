package View;

import Controller.ActionButton;
import Database.ConnectionJDBC;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchView extends JFrame {
    public JTextField textField1;
    private VehicleManagerView vehicleManagerView;

    public SearchView(VehicleManagerView vehicleManagerView){
        this.vehicleManagerView = vehicleManagerView;
        this.setTitle("Search");
        this.setSize(350,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initSearch();
        this.iconSearch();
        this.setVisible(true);
    }

    public  void initSearch(){
        Font font = new Font("Arial",Font.BOLD | Font.ITALIC, 20);
        // Thêm các thành phần vào panel
        JLabel label1 = new JLabel("Search by area",JLabel.CENTER);
        label1.setFont(font);
//        label1.setForeground(Color.CYAN);

        textField1 = new JTextField(JTextField.CENTER);
        textField1.setFont(font);
        textField1.setHorizontalAlignment(JTextField.CENTER); // set font word at Center
        GridLayout gridLayout = new GridLayout(2,2,0,10);

        JButton button = new JButton("Confirm");
        button.setFont(font);
        button.addActionListener(new ActionButton(this));

        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
//        panel.setBackground(Color.YELLOW);

        panel.add(label1); // row 1 col 1
        panel.add(textField1);//row 1 col 1
        panel.add(new JLabel(""));//row 2 col 1
        panel.add(button);//row 2 col 2
        this.add(panel);
    }

    public void executeSearch(){
        try{
            Connection connection = ConnectionJDBC.getConnection();

            String sql = "SELECT * FROM Table_Project_Finally " +
                    " WHERE Area = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,textField1.getText());

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("Hang " + rs);

            int countColumn = rs.getMetaData().getColumnCount();

            vehicleManagerView.defaultTableModel.setColumnCount(0);
            vehicleManagerView.defaultTableModel.setRowCount(0);

            for(int i = 1; i <= countColumn; i++){
                vehicleManagerView.defaultTableModel.addColumn(rs.getMetaData().getColumnName(i));
            }

            Object row[] = new Object[countColumn];
            while (rs.next()){
                for(int i = 1; i <= countColumn; i++){
                    row [i-1] = rs.getObject(i);
                }
                vehicleManagerView.defaultTableModel.addRow(row);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        int countRow = vehicleManagerView.defaultTableModel.getRowCount();
        if(countRow == 0){
            JOptionPane.showMessageDialog(this,"The area you are searching for is invalid or does not exist","Warning",JOptionPane.WARNING_MESSAGE);
        }

        this.dispose();
        vehicleManagerView.setVisible(true);
    }

    public void iconSearch(){
        URL urlSearch = SearchView.class.getResource("Search.png");
        Image imageSearch = Toolkit.getDefaultToolkit().createImage(urlSearch);
        this.setIconImage(imageSearch);
    }
}
