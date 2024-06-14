package Model;

public class Customer {

    private String Name, Nic, Address, Email, CardType, VehicleNo, VehicleType, FuelType, ExpireDate;
    private int Mobile, Landline, Fax, CardNo, Cvv;

    public Customer(String Name, String Nic, String Address, int Mobile, int Landline, int Fax, String Email, String CardType, int CardNo, String ExpireDate, int Cvv, String VehicleNo, String VehicleType, String FuelType) {
        this.Name = Name;
        this.Nic = Nic;
        this.Address = Address;
        this.Email = Email;
        this.CardType = CardType;
        this.VehicleNo = VehicleNo;
        this.VehicleType = VehicleType;
        this.FuelType = FuelType;
        this.ExpireDate = ExpireDate;
        this.Mobile = Mobile;
        this.Landline = Landline;
        this.Fax = Fax;
        this.CardNo = CardNo;
        this.Cvv = Cvv;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String Nic) {
        this.Nic = Nic;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String CardType) {
        this.CardType = CardType;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String VehicleNo) {
        this.VehicleNo = VehicleNo;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String VehicleType) {
        this.VehicleType = VehicleType;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int Mobile) {
        this.Mobile = Mobile;
    }

    public int getLandline() {
        return Landline;
    }

    public void setLandline(int Landline) {
        this.Landline = Landline;
    }

    public int getFax() {
        return Fax;
    }

    public void setFax(int Fax) {
        this.Fax = Fax;
    }

    public int getCardNo() {
        return CardNo;
    }

    public void setCardNo(int CardNo) {
        this.CardNo = CardNo;
    }

    public int getCvv() {
        return Cvv;
    }

    public void setCvv(int Cvv) {
        this.Cvv = Cvv;
    }

}
