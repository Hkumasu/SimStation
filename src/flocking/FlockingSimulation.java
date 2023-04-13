/*
4/13/2023 - Hazuki Sugahara: Created the file 
*/

package flocking;

import mvc.*;
import simstation.*;
import java.awt.*;

Class FlockingSimulation extends Simulation {
  
  public void populate() {
   //add statement 
  }
  
  public String getStatus() {
  
  }
  
  public static void main(String[] args) {
    AppPanel panel = new SimulationPanel(new Flockingfactory());
    panel.display();
  }
}

class FlockingFactory extends SimStationFactory {
  public Model makeModel() { return new FlockingSimulation(); }
  public String getTitle() { return "Flocking"; }
}
