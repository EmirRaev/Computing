package comps;

public class NoteBook extends ComputingMachinery {

    public NoteBook(int price, Model model) {
        super(price, model);
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "price=" + getPrice() +
                ", model=" + getModel() +
                '}';
    }
}
