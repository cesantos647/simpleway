// Param experimental constant for repulsion
Server main = new Server(0.9, 700, 700);
VectorMap map = new VectorMap();

void setup() {
  size(700, 700);
  for(int i = 0; i < 90; i++) { 
    main.addVehicle(Math.random()*600, Math.random()*600, 10, "car");
  }
  exampleOne();
}

void draw() {
  background(0);
  main.run();
  renderSystem();
}

void exampleOne() {
  for(int i = 0; i < 36; i++) {
    main.addVehicle(100 + (7 * i), 700 - (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(0 + (7 * i), 600 - (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(100 + (7 * i), 0 + (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(0 + (7 * i), 100 + (7 * i), 10, "boundary");
  }
  
  for(int i = 0; i < 36; i++) {
    main.addVehicle(600 - (7 * i), 0 + (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(700 - (7 * i), 100 + (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(700 - (7 * i), 600 - (7 * i), 10, "boundary");
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(600 - (7 * i), 700 - (7 * i), 10, "boundary");
  }
}
