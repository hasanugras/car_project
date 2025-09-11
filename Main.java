import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Araba Similasyonuna Hoşgeldiniz!");



        boolean cikis = true;

        while (cikis){
            System.out.println("1- Aracı İlerlet");
            System.out.println("2- Yakıt Doldur");
            System.out.println("3- Tekerlek Basıncını Kontrol Et");
            System.out.println("4- Aracın Durumunu Görüntüle");
            System.out.println("5- Çıkış yap");

            System.out.print("Lütfen Seçmek İstediğiniz İşlemi Giriniz : ");
            int secim = inp.nextInt();

            if (secim ==1){
                System.out.println("Aracı İlerlertmeyi Seçtiniz");

            } else if (secim ==2) {
                System.out.println("Yakıt Dolduruluyor Lütfen Doldurmak İstediğiniz Miktarı Söyleyin :");


            } else if (secim ==3) {
                System.out.println("tekerlek basıncı kontrol ediliyor");


            } else if (secim ==4) {
                System.out.println("Araç Durumu :");


            }else if (secim == 5 ){
                System.out.println("Programdan çıkılıyor ... İyi Yolculuklar");
                cikis = false;
            }else{
                System.out.println("Yanlış");
            }


        }
    }
}
