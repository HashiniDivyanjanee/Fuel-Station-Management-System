package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Purchase {

    int grnID;
    String Spplier;
    LocalDate Date;
    LocalTime Time;
    double subTotal, Add_Discount, Total;

    public Purchase(String Spplier,double subTotal, double Add_Discount, double Total, LocalDate Date, LocalTime Time ) {
        this.Spplier = Spplier;
        this.Date = Date;
        this.Time = Time;
        this.subTotal = subTotal;
        this.Add_Discount = Add_Discount;
        this.Total = Total;
    }

    public Purchase() {
    }

    public int getGrnID() {
        return grnID;
    }

    public void setGrnID(int grnID) {
        this.grnID = grnID;
    }

    public String getSpplier() {
        return Spplier;
    }

    public void setSpplier(String Spplier) {
        this.Spplier = Spplier;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime Time) {
        this.Time = Time;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getAdd_Discount() {
        return Add_Discount;
    }

    public void setAdd_Discount(double Add_Discount) {
        this.Add_Discount = Add_Discount;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

}
