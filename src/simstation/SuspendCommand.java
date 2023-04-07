/*
4/4/23 - Hazuki Sugahara: Created the file
4/4/23 - Hazuki Sugahara: Modified the file
*/

package simstation;

import mvc.*;

public class SuspendCommand extends Command {
  public SuspendCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation m = (Simulation)model;
        m.suspend();
    }
}
