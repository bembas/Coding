public abstract class Asfalismenoi {

    private String name;
    private String afm;
    private double kratiseis;


    public Asfalismenoi(String name, String afm, double kratiseis) {
        this.name = name;
        this.afm = afm;
        this.kratiseis = kratiseis;
    }

    public double getKratiseis(){
        return kratiseis;
    }

    public abstract double KMA();

    public String getName() {
        return name;
    }
}




