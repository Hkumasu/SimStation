/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file
*/

package simstation;

import mvc.*;

public class ResumeCommand extends Command {
  public ResumeCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation m = (Simulation)model;
        m.resume();
    }
}
