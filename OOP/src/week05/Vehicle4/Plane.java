package week05.Vehicle4;

public class Plane extends Vehicle{
    public void showPlaneInfo(){
        System.out.print("Plane detail is, ");
        showInfo();
    }
    
    public void setPlaneInfo(int s, String t) {
        setFuel(s);
        setTopSpeed(t);
    }
    
    public void fly() {
        if (getFuel() < 200){
            System.out.println("Please add fuel.");
        }
        else {
            System.out.println("Fly.");
            setFuel(getFuel() - 200);
        }
    }
}
