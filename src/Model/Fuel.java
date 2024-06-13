package Model;

public class Fuel {

    private String FluelName;
    private String TankID;
    private Double CostPrice;
    private Double SalePrice;
    private Double Liter;
    int FuelID;

    public Fuel(String FluelName, String TankID, Double CostPrice, Double SalePrice, Double Liter) {
        this.FluelName = FluelName;
        this.TankID = TankID;
        this.CostPrice = CostPrice;
        this.SalePrice = SalePrice;
        this.Liter = Liter;
    }

    public String getFluelName() {
        return FluelName;
    }

    public void setFluelName(String FluelName) {
        this.FluelName = FluelName;
    }

    public String getTankID() {
        return TankID;
    }

    public void setTankID(String TankID) {
        this.TankID = TankID;
    }

    public Double getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(Double CostPrice) {
        this.CostPrice = CostPrice;
    }

    public Double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(Double SalePrice) {
        this.SalePrice = SalePrice;
    }

    public Double getLiter() {
        return Liter;
    }

    public void setLiter(Double Liter) {
        this.Liter = Liter;
    }

    public int getFuelID() {
        return FuelID;
    }

    public void setFuelID(int FuelID) {
        this.FuelID = FuelID;
    }

}
