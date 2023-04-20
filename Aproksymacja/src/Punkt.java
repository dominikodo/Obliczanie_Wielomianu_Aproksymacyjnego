public class Punkt {

    private double x;
    private double y;

    Punkt() {
        x=0;
        y=0;
    }

    Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }

    void setLocation (double x, double y){
        this.x = x;
        this.y = y;
    }

}
