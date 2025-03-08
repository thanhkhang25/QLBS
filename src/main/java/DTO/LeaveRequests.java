package DTO;

import java.sql.Date;

public class LeaveRequests {
    private int ID;
    private Integer employeeID; // Integer to allow null
    private LeaveType leaveType;
    private Date startDate;
    private Date endDate;
    private Status status;
    private String note;

    // Constructors
    public LeaveRequests() {
    }

    public LeaveRequests(Integer employeeID, LeaveType leaveType, Date startDate, Date endDate, Status status, String note) {
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.note = note;
    }

    // Constructor with ID (for existing requests)
    public LeaveRequests(int ID, Integer employeeID, LeaveType leaveType, Date startDate, Date endDate, Status status, String note) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.note = note;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
	
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // toString() method (for debugging)
    @Override
    public String toString() {
        return "LeaveRequests{" +
                "ID=" + ID +
                ", employeeID=" + employeeID +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                '}';
    }



    public enum LeaveType {
        VACATION, SICK_LEAVE, PERSONAL_LEAVE, MATERNITY_LEAVE, PATERNITY_LEAVE, BEREAVEMENT_LEAVE, OTHER
    }

    public enum Status {
        PENDING, APPROVED, REJECTED, CANCELLED
    }

}