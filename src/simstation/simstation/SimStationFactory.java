/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file
*/

package simstation;

import mvc.*;

public class SimStationFactory implements AppFactory {
      public Model makeModel() { return new Simulation(); }

    public View makeView(Model m) {
        return new SimulationView((Simulation)m);
    }

    public String[] getEditCommands() { return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE", "Reset"}; }

    public Command makeEditCommand(Model model, String type, Object source) {
        if(type == "Start")
            return new StartCommand(model);
        else if (type == "Suspend" )//create new statements for each commands
            return new SuspendCommand(model);
        else if (type == "Resume")
            return new ResumeCommand(model);
        else if (type == "Stats")
            return new StatsCommand(model);
        else if (type == "Stop")
            return new StopCommand(model);
        return null;
    }

    public String getTitle() { return "SimStation"; }

    public String[] getHelp() {
        return new String[] {
                "Start: ",
                "Suspend: ",
                "Resume: ",
                "Stats: ",
                "Stop: ",
        };
    }

    public String about() {
        return "Rohith Iyengar, Jelinne Quelina Ramos, Hazuki Sugahara" + "\n2023. All rights reserved.";
    }
}
