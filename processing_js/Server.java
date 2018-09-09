import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Server {
  public List<Vehicle> vehicles = new ArrayList<Vehicle>();
  double k;
  double w;
  double h;
  
  Server(double ok, double ow, double oh) {
    k = ok;
    w = ow;
    h = oh;
  }
  
  void addVehicle(double x, double y, double r, String ID, int pID) {
    vehicles.add(new Vehicle(x, y, r, k, w, h, ID, pID));
  }
  
  Vehicle[] convertArray() {
    Vehicle[] vehicleData = new Vehicle[vehicles.size()];
    for(int i = 0; i < vehicleData.length; i++) {
      vehicleData[i] = vehicles.get(i);
    }
    
    return vehicleData;
  }
  
  void run() {
    for(int i = 0; i < vehicles.size(); i++) {
      vehicles.get(i).calculateVector(convertArray());
    }
    for(int i = 0; i < vehicles.size(); i++) {
      vehicles.get(i).applyVector();
    }
  }
}
