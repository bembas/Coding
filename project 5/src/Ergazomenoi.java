public class Ergazomenoi extends Asfalismenoi {
    private double apodoxes;
    private int Pmeloi;

    public Ergazomenoi(String name, String afm, double kratiseis, double apodoxes, int Pmeloi) {
        super(name, afm, kratiseis);
        this.apodoxes = apodoxes;
        this.Pmeloi = Pmeloi;
    }

    public double KMA() {
        return apodoxes * (1 - getKratiseis()) + Pmeloi * 100;
    }
}
