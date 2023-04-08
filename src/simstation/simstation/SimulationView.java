/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file
*/

package simstation;

import mvc.*;

public class SimulationView extends View {
  public SimulationView(Simulation s) {
        super(s);
    }

    public void paintComponent(Graphics gc) {
        Simulation simulation = (Simulation)model;
        Color oldColor = gc.getColor();
        Iterator<Point> it = simulation.iterator();
        while(it.hasNext()) {
            Point point = it.next();
            gc.fillOval(point.x, point.y, 10, 10);
        }
        gc.setColor(Color.white);
        gc.fillOval(simulation.getLocation().x, simulation.getLocation().y, 10, 10);
    }
}
