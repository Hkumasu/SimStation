/*
4/13/23 - Hazuki Sugahara: Created the file
4/14/23 - Hazuki Sugahara: Modified the file
*/

package plague;

import java.awt.*;
import java.util.List;
import simstation.*;

public class PlagueView extends SimulationView{

    public PlagueView(PlagueSimulation s) { super(s); }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation s = (Simulation) model;
        List<Agent> agents = s.getAgents();
        Graphics2D gc2d = (Graphics2D) gc;
        gc2d.setColor(Color.GRAY);
        gc2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        Host host;
        for (Agent a : agents) {
            host = (Host) a;
            if(host.getInfected())
                gc.setColor(Color.RED);
            else gc.setColor(Color.green);
            gc.fillOval(a.getXc(), a.getYc(),5,5);
        }
    }
}
