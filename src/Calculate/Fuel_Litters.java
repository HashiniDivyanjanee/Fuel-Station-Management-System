package Calculate;

public class Fuel_Litters {

    public static double Vfill(double d, double l, double f) {
        double p = Math.PI;
        double r = d / 2;

        double segmentArea = Math.acos((r - f) / r) * r * r - (r - f) * Math.sqrt(d * f - f * f);
        double fillVolume = (segmentArea * l)/1000;

        return fillVolume;
    }
}
