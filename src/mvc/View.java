package mvc;

/*
4/4/23 - Hazuki Sugahara: Created the file
*/

public class View extends JPanel implements PropertyChangeListener {

    protected Model model;

    public View(Model model) {
        super();
        this.model = model;
        //model.addPropertyChangeListener(this);
        // optional border around the view component
        setBorder(LineBorder.createGrayLineBorder());
    }

    public Model getModel() {return model; }

    // called by File/Open and File/New
    public void setModel(Model newModel) {
        this.model = newModel;
        if (newModel != null) {
            this.model.addPropertyChangeListener(this);
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent arg0) { this.repaint(); }

}
