import comps.*;
//импотрированы все классы из comps

import java.util.ArrayList;
//импотрирован класс ArrayList
import java.util.List;
//импотрирован класс List
import java.util.Random;
// импортирован класс Random

public class Main {
    //тестовый класс

    public static void main(String[] args) {
        //точка начала метода
        Random random = new Random();
        //объект класса Random
        List<ComputingMachinery> noteBooks = new ArrayList<>();
        //объект ArrayList, тип List, объекты в ArrayList принадлежат NoteBook\PC
        List<ComputingMachinery> PCs = new ArrayList<>();
        //объект ArrayList, тип List, объекты в ArrayList принадлежат PC\NoteBook
        Model[] models = {Model.DELL, Model.ASUS};
        //массив Model, для рамдомного присвоения их в цикле
        for (int i = 0; i <= 50; i++) {
            //цикл for проработает 50 раз
            noteBooks.add(new NoteBook(random.nextInt(1000 - 300) + 300, models[random.nextInt(models.length)]));
            //Добавляет новый элемент в конец списка noteBooks, рандомятся: price, Model(спомощью объекта random)
            PCs.add(new PC(random.nextInt(1000 - 300) + 300, models[random.nextInt(models.length)], random.nextInt(27 - 19) + 19));
            //Добавляет новый элемент в конец списка PCs, рандомятся: price, Model(спомощью объекта random), diagonal
        }
        System.out.println(totalPrice((ArrayList<ComputingMachinery>) noteBooks) + totalPrice((ArrayList<ComputingMachinery>) PCs));
        //sout( цена всех ComputingMachinery = метод totalPrice(noteBooks преобразование в тип ArrayList<ComputingMachinery> для totalPrice))
        setDiscount((ArrayList<ComputingMachinery>) noteBooks, 20);
        setDiscount((ArrayList<ComputingMachinery>) PCs, 20);
        System.out.println(totalPrice((ArrayList<ComputingMachinery>) noteBooks) + totalPrice((ArrayList<ComputingMachinery>) PCs));
        //sout( цена всех ComputingMachinery = метод totalPrice(noteBooks преобразование в тип ArrayList<ComputingMachinery> для totalPrice))(с учетом скидки)
        search((ArrayList<ComputingMachinery>) PCs, Model.ASUS, 600, 400);
    }

    public static int totalPrice(ArrayList<ComputingMachinery> computingMachineries) {
        //метод возвращает итогувую цену одного ArrayList<ComputingMachinery>, принимает ArrayList<ComputingMachinery>
        int a = 0;
        //то что вернет метод, то что будет плюсоваться с ценой каждого обьекта ArrayList<ComputingMachinery>
        for (ComputingMachinery comp :
            //цикл foreach, comp - объект типа ComputingMachinery
                computingMachineries) {
            //comp из принятого ArrayList
            a = a + comp.getPrice();
            //подсчет цены
        }
        return a;
        //то что вернул метод
    }

    public static void setDiscount(ArrayList<ComputingMachinery> computingMachineries, int percent) {
        //метод вызывает метод discount у всех принятых ArrayList<ComputingMachinery>, принимает int для метода discount
        for (ComputingMachinery comp :
                computingMachineries) {
            //цикл foreach, comp - объект типа ComputingMachinery
            //comp из принятого ArrayList
            comp.discount(percent);
            //метод ComputingMachinery который менянет цену с учетом скидки
        }
    }

    public static void search(ArrayList<ComputingMachinery> computingMachineries, Model model, int topPrice, int bottomPrice) {
        //метод для поиска обькта в ArrayList, по модели и вехнего, нижнего порогов цены
        int count = 1;
        //счет найденых обьктов
        for (ComputingMachinery comp :
                computingMachineries) {
            //цикл foreach, comp - объект типа ComputingMachinery
            if (comp.getModel().equals(model) && comp.getPrice() < topPrice && comp.getPrice() > bottomPrice) {
                //условие: модель, и цена подходят к данным
                System.out.println(comp + " " + count);
                //sout обьект из ArrayList и счетчик
                count++;
                //счетчик пребовляется
            }
        }
    }
}
