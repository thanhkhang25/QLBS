package DTO;

public class Reports {
    private int ID;
    private ReportType reportType; // Using enum
    private Integer month; // Integer, allows null
    private Integer year;  // Integer, allows null
    private String content;

    // Enum for reportType
    public enum ReportType {
        SALES, INVENTORY, FINANCIAL, CUSTOMER, EMPLOYEE
    }

    // Constructors
    public Reports() {
    }

    // Constructor without ID (for new reports)
    // Note:  Allowing null for month/year might not be ideal,
    // depending on your application's requirements.
    public Reports(ReportType reportType, Integer month, Integer year, String content) {
        this.reportType = reportType;
        this.month = month;
        this.year = year;
        this.content = content;
    }

    // Constructor with ID (for existing reports)
    public Reports(int ID, ReportType reportType, Integer month, Integer year, String content) {
        this.ID = ID;
        this.reportType = reportType;
        this.month = month;
        this.year = year;
        this.content = content;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString() method
    @Override
    public String toString() {
        return "Reports{" +
                "ID=" + ID +
                ", reportType=" + reportType +
                ", month=" + month +
                ", year=" + year +
                ", content='" + content + '\'' +
                '}';
    }
}