package Model;

import Database.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class AccountManager {

        public ArrayList<String> getInstance(String inputUsername,String inputPassword) {
            // trả về một ArrayList với 2 tham số để check thông tin đăng nhập

            ArrayList<String> getDataFromCSDL = new ArrayList<>();
            // luôn luôn khởi tạo danh sách để lưu thông tin dữ liệu từ CSDL
            try {
                Connection conn = ConnectionJDBC.getConnection();

                String sql = "SELECT * FROM Table_Login " +
                        " WHERE Username = ? AND Password = ?";
                // Tạo một mẫu câu lệnh SQL cố định và chx gắn kết CSDL với các tham số là placeholder (?)

                PreparedStatement pre = conn.prepareStatement(sql);// câu lệnh SQL được gửi đến CSDL để chuẩn bị trước

                pre.setString(1, inputUsername);
                pre.setString(2, inputPassword);
                // gán giá trị thực tế vào hai dấu ? in câu lệnh SQL

                // Thực thi câu lệnh
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");

                    getDataFromCSDL.add(username);
                    getDataFromCSDL.add(password);
                }
                System.out.println("Input Username: " + inputUsername);
                System.out.println("Input Password: " + inputPassword);

                conn.close();
                pre.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return getDataFromCSDL;
        }

        }


//    public ArrayList<LoginAccountModel> registeredAccounts;
//    public AccountManager(){
//        this.registeredAccounts = new ArrayList<>();







