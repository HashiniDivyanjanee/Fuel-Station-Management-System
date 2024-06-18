package Model;

public class Shedule {

    int scheduleID;

    String pumper, pump, fuelType, TankID, Date, Time, Status;
    Double StartMeter, EndMeter;

    public Shedule(String pumper, String pump, String fuelType, Double StartMeter, String TankID, String Date, String Time, String Status, Double EndMeter) {
        this.pumper = pumper;
        this.pump = pump;
        this.fuelType = fuelType;
        this.TankID = TankID;
        this.Date = Date;
        this.Time = Time;
        this.Status = Status;
        this.StartMeter = StartMeter;
        this.EndMeter = EndMeter;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getPumper() {
        return pumper;
    }

    public void setPumper(String pumper) {
        this.pumper = pumper;
    }

    public String getPump() {
        return pump;
    }

    public void setPump(String pump) {
        this.pump = pump;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTankID() {
        return TankID;
    }

    public void setTankID(String TankID) {
        this.TankID = TankID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Double getStartMeter() {
        return StartMeter;
    }

    public void setStartMeter(Double StartMeter) {
        this.StartMeter = StartMeter;
    }

    public Double getEndMeter() {
        return EndMeter;
    }

    public void setEndMeter(Double EndMeter) {
        this.EndMeter = EndMeter;
    }

}
