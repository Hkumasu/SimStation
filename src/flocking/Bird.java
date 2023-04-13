/*
4/13/2023 - Hazuki Sugahara: Created the file
*/

package flocking;

import mvc.*;
import simstation;

class Bird extends Agent {
  
  int speed;
  
  public Bird() {
    super();
    heading = Heading.random();
    speed = utilities.rng.nextInt(5) + 1;
  }
  
  public void update() {
    //add statement
  }
    
