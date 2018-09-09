class Vehicle {

  // x and y coordinates of the vehicles respectively
  double x;
  double y;
  
  // X-Velocity and Y-Velocity of the vehicles respectively
  double xVel = 0;
  double yVel = 0;
  
  // X-Acceleration and Y-Acceleration of the vehicles respectively
  double xAcc = 0;
  double yAcc = 0;
  
  // Radius of car and repulsion constant respectively
  double r;
  double k;
  
  // Size of simulation system by width and height respectively
  double w;
  double h;
  
  // Target location for really basic demonstration of code
  double px = 0;
  double py = 0;
  
  // String ID
  String ID;
  
  // Vector Map
  VectorMap vecMap = new VectorMap();
  
  Vehicle(double ox, double oy, double or, double ok, double ow, double oh, String nID) {
    x = ox;
    y = oy;
    r = or;
    k = ok;
    w = ow;
    h = oh;
    ID = nID;
    //vecMap.solve(1, 1);
  }
  
  // Calculates car new vector to avoid collision utilizing Newton's Equation of Gravity * -1
  // Basically makes the car act as a magnet :D
  public void calculateVector(Vehicle[] vehicleData) {
    backup(350, 350);
    
    
    double nxVel = 0;
    double nyVel = 0;
    
    for(int i = 0; i < vehicleData.length; i++) {
      double distance = Math.sqrt(Math.pow(x - vehicleData[i].x , 2) +  Math.pow(y - vehicleData[i].y , 2));
      double xS = (x - vehicleData[i].x) / distance;
      double yS = (y - vehicleData[i].y) / distance;
      
      if(distance >= 0.5) {  
        nxVel += xS * (k * vehicleData[i].r) / (Math.pow(distance, 2));
        nyVel += yS * (k * vehicleData[i].r) / (Math.pow(distance, 2));
      }
    }
    
    nxVel += calculateBoundary()[0];
    nyVel += calculateBoundary()[1];
    
    if(ID.equals("car")) {
      xVel += nxVel;
      yVel += nyVel;
    }
    
    vectorCap();
  }
  
  private double[] calculateBoundary() {
    double xS = 0;
    double yS = 0;
    
    if(x > w / 2) {
      xS = x - w;
    } else {
      xS = x;
    }
    
    if(y > h / 2) {
      yS = y - h;
    } else {
      yS = y;
    }
    
    double[] vel = {
      (k * 1) / xS, 
      (k * 1) / yS
    };
    
    return vel;
  }
  
  private void vectorCap() {
    double vec = Math.sqrt(Math.pow(xVel, 2) + Math.pow(yVel, 2));
    if(vec > 0.5) {  
      xVel *= (0.5 / vec);
      yVel *= (0.5 / vec);
    }
  }
  
  private void basicDirection() {
    int nx = (int)Math.round(x / 70);
    int ny = (int)Math.round(y / 70);
    
    if(nx > vecMap.map.length - 1) {
      nx = vecMap.map.length - 1;
    }
    
    if(ny > vecMap.map.length - 1) {
      ny = vecMap.map.length - 1;
    }
    
    if(vecMap.map[nx][ny] == 'u') {
      yVel -= 0.05;
    }
    if(vecMap.map[nx][ny] == 'd') {
      yVel += 0.05;
    }
    if(vecMap.map[nx][ny] == 'l') {
      xVel -= 0.05;
    }
    if(vecMap.map[nx][ny] == 'r') {
      xVel += 0.05;
    }
    
    vectorCap();
  }
  
  private void backup(double px, double py) {
    double distance = Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
    double xS = (px - x) / distance;
    double yS = (py - y) / distance;
    if(distance != 0 && ID.equals("car")) {  
      xVel += xS * 0.05;
      yVel += yS * 0.05;
    }
    
    vectorCap();
  }
  
  void applyVector() {
    x += xVel;
    y += yVel;
  }
  
}
