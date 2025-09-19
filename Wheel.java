public class Wheel {

    private int basinc;
    private int minbasinc;
    private String konum;


    public Wheel(String konum, int basinc, int minbasinc) {
        this.konum = konum;
        this.basinc = basinc;
        this.minbasinc = minbasinc;

    }

    public int getBasinc() {
        return basinc;
    }

    public int getMinbasinc() {
        return minbasinc;
    }

    public String getKonum() {
        return konum;
    }

    public void setBasinc(int basinc) {
        this.basinc = basinc;

    }

    public boolean basincKontrol() {
        BasincDeger durum = basincDurumu();
        return durum == BasincDeger.DUSUK;


    }

    public void sisir(int psi) {

        basinc += psi;
        System.out.println(konum + " hava basıncı şişirildi: " + psi + " psi");
        System.out.println("Güncel basınç: " + basinc + " (" + basincDurumu().aciklama() + ")");

    }

    public BasincDeger basincDurumu() {
        return BasincDeger.basincaGore(basinc);
    }
}


























