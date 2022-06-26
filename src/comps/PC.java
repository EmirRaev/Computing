package comps;

public class PC  extends ComputingMachinery{

    private int diagonal;

    public PC(int price, Model model, int diagonal) {
        super(price, model);
        this.diagonal = diagonal;
    }


    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "PC{" +
                "price=" + getPrice() +
                ", model=" + getModel() +
                ", diagonal=" + diagonal +
                '}';
    }
}
