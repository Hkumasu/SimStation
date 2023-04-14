/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file
4/13/23 - Jelinne Ramos: Modified paintComponent
*/

package simstation;

import mvc.*;

public class SimulationView extends View {
  public SimulationView(Simulation s) {
        super(s);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation s = (Simulation) model;
        List<Agent> agents = s.getAgents();
        Graphics2D gc2d = (Graphics2D) gc;
        gc2d.setColor(Color.GRAY);
        gc2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Agent a : agents) {
            gc.setColor(Color.WHITE);
            gc.fillOval(a.xc, a.yc,5,5);
        }
    }
}
