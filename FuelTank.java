import java.util.Scanner;

public class FuelTank {
    private int anlik;
    private  int kapasite;
    private int x ;


  public FuelTank (int kapasite){
      this.anlik=0;
      this.kapasite= kapasite;
      this.x=x;

  }


    public int getKapasite() {
        return kapasite;
    }

    public int getAnlik() {
        return anlik;
    }
    public int getX(){
      return x;
    }


    public void doldur(int litre){
        System.out.println("Şu An Güncel Olarak Yakıt Miktarı :" + anlik);
        if (anlik + litre<=kapasite){
            anlik+=litre;
            System.out.println("Yakıt Dolduruldu");
            System.out.println("Mevcut Yakıt Miktarı : " + (anlik + litre));

        }else{
            x = kapasite-anlik;
            anlik +=x;
            System.out.println("Depo Kapasitesi Aşıldı" + x + "Litre Doldurulabildi");
















        }


   }
}



