/*
4/4/23 - Hazuki Sugahara: Created the file
*/

package mvc;

public abstract class Command {
    protected Model model;

    public Command(Model model) {
        super();
        this.model = model;
    }

    public abstract void execute() throws Exception ;

}
