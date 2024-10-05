

package Model;

public class Employee {

    public Employee(){
        
    }
    int eid;
    public Employee(String fname, String lname, String address, String nic, String gender, String dob, int mobile, int land, String email, String bank, String branch, int acc, String holder, double salary, String position, String hire, String empType, String schedule) {
        this.lname = lname;
        this.fname = fname;
        this.dob = dob;
        this.address = address;
        this.nic = nic;
        this.gender = gender;
        this.email = email;
        this.bank = bank;
        this.branch = branch;
        this.holder = holder;
        this.position = position;
        this.hire = hire;
        this.schedule = schedule;
        this.empType = empType;
        this.salary = salary;
        this.mobile = mobile;
        this.land = land;
        this.acc = acc;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getLand() {
        return land;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }



    public int getEmployeeID() {
        return eid;
    }

    public void setEmployeeID(int eid) {
        this.eid = eid;
    }
    private String lname, fname, dob, address, nic, gender, email, bank, branch, holder, position, hire, schedule, empType;
    private Double salary;
    private int mobile, land, acc;

    
}
