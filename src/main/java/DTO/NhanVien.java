/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author xuand
 */
public class Employees {
    private int ID;
    private String position;
    private double baseSalary;  // Changed to double to match DECIMAL(12,2)
    private double salaryCoefficient; // Changed to double to match DECIMAL(5,2)
    private double allowance; // Changed to double to match DECIMAL(10,2)
    private Date startDate;
    private boolean status; // Renamed to match the BIT type (true/false)


    public Employees() {

    }

    // Constructor with ID only (useful for lookups or deletions)
    public Employees(int ID) {
        this.ID = ID;
    }
    
    // Constructor with all data (for example when inserting into a database.)
    public Employees(int ID, String position, double baseSalary, double salaryCoefficient, double allowance, Date startDate, boolean status) {
        this.ID = ID;
        this.position = position;
        this.baseSalary = baseSalary;
        this.salaryCoefficient = salaryCoefficient;
        this.allowance = allowance;
        this.startDate = startDate;
        this.status = status;
    }
    
    // Constructor when id is not provided. For database insertions when id is auto_increment.
     public Employees( String position, double baseSalary, double salaryCoefficient, double allowance, Date startDate, boolean status) {        
        this.position = position;
        this.baseSalary = baseSalary;
        this.salaryCoefficient = salaryCoefficient;
        this.allowance = allowance;
        this.startDate = startDate;
        this.status = status;
    }


    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {  // Use isStatus() for boolean getters
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //  toString() method (optional but very useful for debugging)
    @Override
    public String toString() {
        return "NHANVIEN{" +
                "ID=" + ID +
                ", position='" + position + '\'' +
                ", baseSalary=" + baseSalary +
                ", salaryCoefficient=" + salaryCoefficient +
                ", allowance=" + allowance +
                ", startDate=" + startDate +
                ", status=" + status +
                '}';
    }
}