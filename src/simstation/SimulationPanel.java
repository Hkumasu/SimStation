/*
4/4/23 - Hazuki Sugahara: Created the file
4/8/23 - Hazuki Sugahara: Created the file
*/

package simstation;

import mvc.*;

public class SimulationPanel extends AppPanel {
  public class SimulationPanel extends AppPanel{

    public SimulationPanel(AppFactory factory) {
        super(factory);

        this.model.addPropertyChangeListener(this);
        // FrogView created and added by AppPanel constructor

        this.setLayout(new GridLayout(1, 2));
        // controlPanel inherited from AppPanel
        controlPanel.setLayout(new GridLayout(0, 1));

        JPanel p = new JPanel();
        JButton b = new JButton("Start");
        b.addActionListener(this);
        p.add(b);
        controlPanel.add(p);

        p = new JPanel();
        b = new JButton("Suspend");
        b.addActionListener(this);
        p.add(b);
        controlPanel.add(p);

        p = new JPanel();
        b = new JButton("Resume");
        b.addActionListener(this);
        p.add(b);
        controlPanel.add(p);

        p = new JPanel();
        b = new JButton("Stop");
        b.addActionListener(this);
        p.add(b);
        controlPanel.add(p);

        p = new JPanel();
        b = new JButton("Stats");
        b.addActionListener(this);
        p.add(b);
        controlPanel.add(p);
    }

    public static void main(String[] args) {
        AppFactory factory = new SimStationFactory();
        AppPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
}
