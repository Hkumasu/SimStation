/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file
4/11/23 - Jelinne Ramos: Modified execute method
*/

package simstation;

import mvc.*;

public class StatsCommand extends Command {
  public StatsCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation m = (Simulation)model;
        m.stats();
    }
}
