public class EmployeeAtt {
    String id,name,dob,email,joindate,userType;
    String vacationLeave;
    String sickLeave;

    public EmployeeAtt(String id, String name, String dob, String email, String joindate, String userType, String vacationLeave, String sickLeave) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.joindate = joindate;
        this.userType = userType;
        this.vacationLeave = vacationLeave;
        this.sickLeave = sickLeave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getVacationLeave() {
        return vacationLeave;
    }

    public void setVacationLeave(String vacationLeave) {
        this.vacationLeave = vacationLeave;
    }

    public String getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(String sickLeave) {
        this.sickLeave = sickLeave;
    }
}
