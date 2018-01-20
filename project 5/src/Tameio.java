import java.util.ArrayList;

public  class Tameio {

    private String titlos;
    private String edra;


    private ArrayList<Asfalismenoi> asfalismenoi = new ArrayList<Asfalismenoi>();

    public Tameio(String titlos, String edra) {
        this.titlos = titlos;
        this.edra = edra;
    }

    public void addAsfalismeno(Asfalismenoi asfalismenos) {
        asfalismenoi.add(asfalismenos);
    }


    public String getTitlos() {
        return titlos;
    }


    public void GetPrint(){
        for(Asfalismenoi asfalismenos:asfalismenoi) {
            System.out.println("Onomateponumo : " + asfalismenos.getName());
            System.out.println("Οι καθαρές μηνιαίες αποδοχές είναι " + asfalismenos.KMA());
        }
    }
}