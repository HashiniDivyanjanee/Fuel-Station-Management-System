package Calculate;

public class Fuel_Litters {

    public static double Vfill(double d, double l, double f) {

//        double p = Math.PI;
//        double r = d / 2;
//        double tank, fill, segment, a, theta,theta1, x, sin;
//
//        x=r-f;
//        
//        theta = Math.atan2(x, r);
//        theta1 = theta*2;
//        
//        sin = Math.sin(theta1);
//        
//        a=0.5*(r*r)*(theta-theta1);
//        
//        
//        tank = p * (r * r) * l;
//        segment = a-l;
//
//        fill = tank - segment;
        double p = Math.PI;
        double r = d / 2;

        double segmentArea = Math.acos((r - f) / r) * r * r - (r - f) * Math.sqrt(d * f - f * f);
        double fillVolume = (segmentArea * l)/1000;

        return fillVolume;
    }
}
