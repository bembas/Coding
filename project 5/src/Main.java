import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Tameio Tameio1 = new Tameio("Trapezikwn", "Ermou 20 Athina");
        Tameio Tameio2 = new Tameio("Ygeionomikwn", "Panepistimiou 45 Athina");
        Tameio Tameio3 = new Tameio("Nomikwn", "Solwnos 15 Athina");

        ArrayList<Tameio> tameia = new ArrayList<Tameio>();
        tameia.add(Tameio1);
        tameia.add(Tameio2);
        tameia.add(Tameio3);

        InputForm form = new InputForm(tameia);

    }

}
