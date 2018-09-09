void drawCar(double x, double y, double r, String ID) {
  if(ID.equals("car")) {  
    fill(255, 255, 255);
    ellipse((float) x, (float) y, (float) r, (float) r);
  } else {
    fill(0, 255, 255);
    ellipse((float) x, (float) y, (float) r, (float) r);
  }
}

void renderSystem() {
  for(int i = 0; i < main.vehicles.size(); i++) {
    if(main.vehicles.get(i).ID.equals("car")) {  
      stroke(255);
      drawCar(main.vehicles.get(i).x, main.vehicles.get(i).y, main.vehicles.get(i).r, main.vehicles.get(i).ID);
    }
  }
}
