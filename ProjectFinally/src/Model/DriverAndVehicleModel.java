package Model;

import java.sql.Date;

public class DriverAndVehicleModel {
    private String nameDriver;
    private String gender;
    private String telephone;
    private Date dateOfBirth;
    private String CCCD;
    private String area;

    private String vehicleType;
    private String vehicleName;
    private String vehicleNo;

    private String username;
    private String password;

    public DriverAndVehicleModel(String username, String password){
        this.username = username;
        this.password = password;

    }

    public DriverAndVehicleModel(String vehicleNo){
        this.vehicleNo = vehicleNo;
    }

    public DriverAndVehicleModel(String nameDriver, String gender, String telephone,Date dateOfBirth,String CCCD,String area,String vehicleNo){
        this.nameDriver = nameDriver;
        this.gender = gender;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.CCCD = CCCD;
        this.area = area;
        this.vehicleNo = vehicleNo;
    }


    public DriverAndVehicleModel(String nameDriver, String gender, String telephone,Date dateOfBirth, String CCCD, String area, String vehicleType, String vehicleName, String vehicleNo){
        this.nameDriver = nameDriver;
        this.gender = gender;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.CCCD = CCCD;
        this.area = area;

        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;

        this.vehicleNo = vehicleNo;

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVehicleName() {
                    return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
                    this.vehicleName = vehicleName;
    }

    public String getVehicleNo() {
                    return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
                    this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
                    return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
                    this.vehicleType = vehicleType;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

