package DTO;

import java.sql.Date;

public class Users {
    private int ID;
    private String username;
    private String password; // Consider using a char[] for security
    private Integer roleID; // Use Integer to allow for null (foreign key constraint)
    private String name;
    private Date birthday;
    private Gender gender; // Could be an enum, see below
    private String address;
    private String email;
    private String phoneNumber;
    private boolean status;

    // Constructors

    public Users() {
    }
   
    //Constructor without the ID, for inserting to database.
    public Users(String username, String password, Integer roleID, String name, Date birthday, Gender gender, String address, String email, String phoneNumber, boolean status) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

	public Users(int ID, String username, String password, Integer roleID, String name, Date birthday, Gender gender, String address, String email, String phoneNumber, boolean status) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    // Getters and Setters (standard)

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // toString() method (for debugging)

    @Override
    public String toString() {
        return "Users{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' + // Consider not including password in toString()
                ", roleID=" + roleID +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}';
    }



    public enum Gender {
        MALE, FEMALE, OTHER
    }


}