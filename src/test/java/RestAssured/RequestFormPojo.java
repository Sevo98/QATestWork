package RestAssured;

public class RequestFormPojo {
    private String fullName;
    private String mail;
    private String phone;
    private String comment;
    private String department;
    private String position;
    private String agreement;

    public RequestFormPojo() {}

    public RequestFormPojo(String department, String position, String agreement) {
        this.department = department;
        this.position = position;
        this.agreement = agreement;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getComment() {
        return comment;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getAgreement() {
        return agreement;
    }
}
