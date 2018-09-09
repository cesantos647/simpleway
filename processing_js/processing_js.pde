// Param experimental constant for repulsion
Server main = new Server(0.9, 700, 700);
VectorMap map = new VectorMap();

void setup() {
  size(700, 700);
  exampleOne();
}

void draw() {
  background(0);
  main.run();
  renderSystem();
}

void exampleOne() {
  for(int i = 0; i < 36; i++) {
    main.addVehicle(100 + (7 * i), 700 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(0 + (7 * i), 600 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(100 + (7 * i), 0 + (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(0 + (7 * i), 100 + (7 * i), 10, "boundary", 0);
  }
  
  for(int i = 0; i < 36; i++) {
    main.addVehicle(600 - (7 * i), 0 + (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(700 - (7 * i), 100 + (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(700 - (7 * i), 600 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(600 - (7 * i), 700 - (7 * i), 10, "boundary", 0);
  }
  double[][] init = {
    {0, 100}, 
    {600, 100}
  };
  for(int i = 0; i < 15; i++) { 
    main.addVehicle(Math.random() * init[0][1] + init[0][0], 600, 10, "car", 1);
  }
  for(int i = 0; i < 15; i++) { 
    main.addVehicle(Math.random() * init[1][1] + init[1][0], 600, 10, "car", 2);
  }
}

void exampleTwo() {
  for(int i = 0; i < 50; i++) {
    main.addVehicle(250, 700 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 50; i++) {
    main.addVehicle(450, 700 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(250 - (7 * i), 350 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(450 + (7 * i), 350 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(350 + (7 * i), 250 - (7 * i), 10, "boundary", 0);
  }
  for(int i = 0; i < 36; i++) {
    main.addVehicle(350 - (7 * i), 250 - (7 * i), 10, "boundary", 0);
  }
  double[][] init = {
    {300, 100}, 
    {300, 100}
  };
  for(int i = 0; i < 30; i++) { 
    main.addVehicle(Math.random() * init[0][1] + init[0][0], 600, 10, "car", 3);
  }
  for(int i = 0; i < 30; i++) { 
    main.addVehicle(Math.random() * init[0][1] + init[0][0], 600, 10, "car", 2);
  }
}
