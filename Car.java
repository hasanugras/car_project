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
        this.arkaSol = new Wheel("Arka Sol", 33, 27);
        this.arkaSag = new Wheel("Arka Sağ", 33, 27);
        this.mesafe = 0;

    }




    public void ilerle(int km) {
        int güncelYakit = depo.getAnlik();
        int harcananYakit = km / 10;

        if (depo.getAnlik() < harcananYakit) {
            System.out.println("Yeterli yakıt yok! Lütfen yakıt doldurun.");
            return;
        }

        Scanner inp = new Scanner(System.in);
        String cevap;
        boolean sorun = false;

        if (onSol.basincKontrol()) {
            System.out.println(onSol.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            System.out.print("Havasını doldurmak ister misiniz? ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.print("Kaç psi basmak istiyorsunuz? ");
                int hava =inp.nextInt();
                inp.nextLine();
                System.out.println("Hava şişiriliyor...");
                onSol.sisir(hava);
            }
        }

        if (onSag.basincKontrol()) {
            System.out.println(onSag.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            System.out.print("Havasını doldurmak ister misiniz? ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.print("Kaç psi basmak istiyorsunuz? ");
                int hava = Integer.parseInt(inp.nextLine());
                System.out.println("Hava şişiriliyor...");
                onSag.sisir(hava);
            }
        }

        if (arkaSol.basincKontrol()) {
            System.out.println(arkaSol.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            System.out.print("Havasını doldurmak ister misiniz? ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.print("Kaç psi basmak istiyorsunuz? ");
                int hava = Integer.parseInt(inp.nextLine());
                System.out.println("Hava şişiriliyor...");
                arkaSol.sisir(hava);
            }
        }

        if (arkaSag.basincKontrol()) {
            System.out.println(arkaSag.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            System.out.print("Havasını doldurmak ister misiniz? ");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                System.out.print("Kaç psi basmak istiyorsunuz? ");
                int hava = Integer.parseInt(inp.nextLine());
                System.out.println("Hava şişiriliyor...");
                arkaSag.sisir(hava); // düzelttim
            }
        }

        if (sorun) {
            System.out.println("Aracı çalıştırma, lastik basınçlarını kontrol et!");
            return;
        } else {
            System.out.println("Tüm lastikler normal, yola çıkabilirsin.");
        }


        depo.doldur(-harcananYakit);
        mesafe += km;
        System.out.println(km + " km yol gidildi.");
        System.out.println("Kalan yakıt: " + depo.getAnlik());
    }

    public void printStatus(){
        System.out.println("-------- ARAÇ DURUMU --------");
        System.out.println("Kalan Yakıt :" + depo.getAnlik() + "litre");
        System.out.println("Kat Edilen Mesafe :" + mesafe + "km");
        System.out.println("Sağ Ön Tekerlek Basıncı :" + onSag.getBasinc() + "psi" );
        System.out.println("Sol Ön Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );
        System.out.println("Arka Sağ Tekerlek Basıncı :" + arkaSag.getBasinc() + "psi" );
        System.out.println("Arka Sol Tekerlek Basıncı :" + arkaSol.getBasinc() + "psi" );


    }
    public void yakitDoldur(int litre){
        depo.doldur(litre);


    }
    public void tekerlekBasincleri(){
        System.out.println("Sağ Ön Tekerlek Basıncı :" + onSag.getBasinc() + "psi" );
        System.out.println("Sol Ön Tekerlek Basıncı :" + onSol.getBasinc() + "psi" );
        System.out.println("Arka Sağ Tekerlek Basıncı :" + arkaSag.getBasinc() + "psi" );
        System.out.println("Arka Sol Tekerlek Basıncı :" + arkaSol.getBasinc() + "psi" );

    }
}
