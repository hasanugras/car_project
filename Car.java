import java.util.Scanner;

public class Car {
    private Wheel onSol;
    private Wheel onSag;
    private Wheel arkaSol;
    private Wheel arkaSag;
    private FuelTank depo;
    private int mesafe;


    public Car() {
        this.depo = new FuelTank(50);
        this.onSol = new Wheel("Ön Sol", 33, 27);
        this.onSag = new Wheel("Ön Sağ", 33, 27);
        this.arkaSol = new Wheel("Arka Sağ", 33, 27);
        this.arkaSag = new Wheel("Arka Sağ", 33, 27);
        this.mesafe = 0;

    }

    boolean sorun = false;


    public void ilerle(int km) {
        int güncelYakit = depo.getAnlik();
        int harcananYakit = km / 10;
        if (depo.getAnlik() < harcananYakit) {
            System.out.println("Yeterli yakıt yok! Lütfen yakıt doldurun.");

        }


        Scanner inp = new Scanner(System.in);
        String cevap;


        if (onSol.basincKontrol()) {
            System.out.println(onSol.getKonum() + "Tekerleğin Havası Çok düşük,İlerleme Verimli Değil");
            sorun = true;
            System.out.println("havasını doldurmak ister misiniz?  ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.println("kaç psı basmak istiyorsunuz?");
                int hava = inp.nextInt();
                inp.nextLine();
                System.out.println("hava şişiriliyor...");
                onSol.sisir(hava);

            }


        }
        if (onSag.basincKontrol()) {
            System.out.println(onSag.getKonum() + "Tekerleğin Havası Çok düşük,İlerleme Verimli Değil");
            sorun = true;
            System.out.println("havasını doldurmak ister misiniz?  ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.println("kaç psı basmak istiyorsunuz?");
                int hava = inp.nextInt();
                inp.nextLine();
                System.out.println("hava şişiriliyor...");
                onSag.sisir(hava);


            }
            if (arkaSol.basincKontrol()) {
                System.out.println(arkaSol.getKonum() + "Tekerleğin Havası Çok düşük,İlerleme Verimli Değil");
                sorun = true;
                System.out.println("havasını doldurmak ister misiniz?  ");
                cevap = inp.nextLine();
                if (cevap.equalsIgnoreCase("evet")) {
                    System.out.println("kaç psı basmak istiyorsunuz?");
                    int hava = inp.nextInt();
                    inp.nextLine();
                    System.out.println("hava şişiriliyor...");
                    arkaSol.sisir(hava);


                }

            }
            if (arkaSag.basincKontrol()) {
                System.out.println(arkaSag.getKonum() + "Tekerleğin Havası Çok düşük,İlerleme Verimli Değil");
                sorun = true;
                System.out.println("havasını doldurmak ister misiniz?  ");
                cevap = inp.nextLine();
                if (cevap.equalsIgnoreCase("evet")) {
                    System.out.println("kaç psı basmak istiyorsunuz?");
                    int hava = inp.nextInt();
                    inp.nextLine();
                    System.out.println("hava şişiriliyor...");
                    arkaSol.sisir(hava);

                }

            }
            if (sorun) {
                System.out.println("Aracı çalıştırma, lastik basınçlarını kontrol et!");
            } else {
                System.out.println("Tüm lastikler normal, yola çıkabilirsin.");

            }
            depo.doldur(-harcananYakit);
            mesafe += km;
            System.out.println(km + "Km Yol Gidildi");
            System.out.println("kalan yakıt miktarı :" + depo.getAnlik());


        }



    }
    public void printStatus(){
        System.out.println("-------- ARAÇ DURUMU --------");
        System.out.println("Kalan Yakıt :" + depo.getAnlik() + "litre");
        System.out.println("Kat Edilen Mesafe :" + mesafe + "km");
        System.out.println("Sağ Ön Tekerlek Basıncı :" + onSag.getBasinc() + "psi" );
        System.out.println("Sol Ön Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );
        System.out.println("Arka Sağ Tekerlek Basıncı :" + arkaSag.getBasinc() + "psi" );
        System.out.println("Arka Sol Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );


    }
    public void yakitDoldur(int litre){
        depo.doldur(litre);


    }
    public void tekerlekBasincleri(){
        System.out.println("Sağ Ön Tekerlek Basıncı :" + onSag.getBasinc() + "psi" );
        System.out.println("Sol Ön Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );
        System.out.println("Arka Sağ Tekerlek Basıncı :" + arkaSag.getBasinc() + "psi" );
        System.out.println("Arka Sol Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );

    }
}
