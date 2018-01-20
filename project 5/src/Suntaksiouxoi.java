public class Suntaksiouxoi extends Asfalismenoi{

    private double suntaksh;

    public Suntaksiouxoi(String name, String afm, double kratiseis, double suntaksh) {
        super(name, afm, kratiseis);
        this.suntaksh = suntaksh;
    }

    public double KMA() {
        return suntaksh * (1 - getKratiseis());
    }
}
