package DAO;

import Database.ConnectionJDBC;
import Model.DriverAndVehicleModel;

import java.sql.*;

public class DAOVehicleManager implements DAOInterface<DriverAndVehicleModel> {
    public static DAOVehicleManager getInstance() {
        return new DAOVehicleManager();
    }

    @Override
    public int insert(DriverAndVehicleModel d) {
        try{
            Connection con = ConnectionJDBC.getConnection();
            String checkDataExisted = "SELECT COUNT(*) FROM Table_Project_Finally" +// trả về một hàng duy nhất với một cột duy nhất
                    " WHERE VehicleNo = ?";

            PreparedStatement pre = con.prepareStatement(checkDataExisted);
            pre.setString(1,d.getVehicleNo());

            ResultSet resultSet = pre.executeQuery();

            if(resultSet.next() && resultSet.getInt(1) > 0){
                System.out.println("Data already existed!");
                return 0;// nghừng chèn nếu dữ liệu đã tồn tại
            }

            String sql = " INSERT INTO Table_Project_Finally(NameDriver, Gender, Telephone, DateOfBirth, CCCD, Area, VehicleType, VehicleName,  VehicleNo) " +
                    " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, d.getNameDriver());
            ps.setString(2, d.getGender());
            ps.setString(3, d.getTelephone());
            ps.setDate(4, d.getDateOfBirth());
            ps.setString(5, d.getCCCD());
            ps.setString(6, d.getArea());
            ps.setString(7, d.getVehicleType());
            ps.setString(8, d.getVehicleName());
            ps.setString(9, d.getVehicleNo());

            int check = ps.executeUpdate();

            System.out.println( check +" The line appeared is: " );

            con.close();
            ps.close();

            return check;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(DriverAndVehicleModel d) {
        try{
            Connection connection = ConnectionJDBC.getConnection();

            String sql = "DELETE FROM Table_Project_Finally " +
                    "WHERE  VehicleNo = ?";


            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, d.getVehicleNo());// Chỉ số 1 nó Không liên quan gì đến vị trí cột trong bảng\
            // mà nó lại chỉ số của tham số ?
            // tham số d.getVehicleNo() nó chỉ đại diện cho giá trị mà mk use condition WHERE

            int checkDelete = pre.executeUpdate();
            System.out.println(checkDelete +" The line deleted ");

            connection.close();
            pre.close();

            return checkDelete;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DriverAndVehicleModel d) {

        try{
            Connection conn = ConnectionJDBC.getConnection();

            String sql = "UPDATE Table_Project_Finally " +
                    "SET NameDriver  = ?, Gender = ?, Telephone = ?, DateOfBirth = ?, CCCD = ?, Area = ?" +
                    "WHERE  VehicleNo = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,d.getNameDriver());
            ps.setString(2,d.getGender());
            ps.setString(3,d.getTelephone());
            ps.setDate(4,d.getDateOfBirth());
            ps.setString(5,d.getCCCD());
            ps.setString(6,d.getArea());
            ps.setString(7,d.getVehicleNo());

            int checkUpdate = ps.executeUpdate();
            System.out.println(checkUpdate + " The line Updated");

            return checkUpdate;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertRegister(DriverAndVehicleModel d) {

        try{
            Connection conn = ConnectionJDBC.getConnection();

            if (conn == null) {
                System.out.println("Kết nối thất bại!");
            } else {
                System.out.println("Kết nối thành công!");
            }

            String sql = "INSERT INTO Table_Login (Username, Password)" +
                    " VALUES (?,?)";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,d.getUsername());
            pre.setString(2,d.getPassword());

            int check = pre.executeUpdate();
            System.out.println(check + " The line Added");
            return check;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int search(DriverAndVehicleModel driverAndVehicleModel) {
        return 0;
    }
}

