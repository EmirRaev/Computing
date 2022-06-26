package comps;

public abstract class ComputingMachinery {
    private int price;
    private Model model;

    public void discount(int percent){
        double a = this.price / 100 * percent;
        this.price = (int) (this.price - a);
    }

    public ComputingMachinery(int price, Model model) {
        this.price = price;
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
