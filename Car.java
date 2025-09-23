/*import java.util.Scanner;

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


 */

import java.util.Scanner;
import java.util.function.Consumer;

public class Car {
    private Wheel onSol;
    private Wheel onSag;
    private Wheel arkaSol;
    private Wheel arkaSag;
    private FuelTank depo;
    private int mesafe;

    // 🔹 Logger eklendi
    private Consumer<String> logger;

    public Car(Consumer<String> logger) {
        this.depo = new FuelTank(50);
        this.onSol = new Wheel("Ön Sol", 33, 27);
        this.onSag = new Wheel("Ön Sağ", 33, 27);
        this.arkaSol = new Wheel("Arka Sol", 33, 27);
        this.arkaSag = new Wheel("Arka Sağ", 33, 27);
        this.mesafe = 0;
        this.logger = logger;
    }

    // 🔹 Mesajları loglama
    private void log(String mesaj) {
        if (logger != null) {
            logger.accept(mesaj + "\n"); // GUI
        } else {
            System.out.println(mesaj);   // Terminal
        }
    }

    public void ilerle(int km) {
        int güncelYakit = depo.getAnlik();
        int harcananYakit = km / 10;

        if (güncelYakit < harcananYakit) {
            log("Yeterli yakıt yok! Lütfen yakıt doldurun.");
            return;
        }

        Scanner inp = new Scanner(System.in);
        String cevap;
        boolean sorun = false;

        if (onSol.basincKontrol()) {
            log(onSol.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            log("Havasını doldurmak ister misiniz? (evet/hayır)");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                log("Kaç psi basmak istiyorsunuz?");
                int hava = Integer.parseInt(inp.nextLine());
                log("Hava şişiriliyor...");
                onSol.sisir(hava);
            }
        }

        if (onSag.basincKontrol()) {
            log(onSag.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            log("Havasını doldurmak ister misiniz? (evet/hayır)");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                log("Kaç psi basmak istiyorsunuz?");
                int hava = Integer.parseInt(inp.nextLine());
                log("Hava şişiriliyor...");
                onSag.sisir(hava);
            }
        }

        if (arkaSol.basincKontrol()) {
            log(arkaSol.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            log("Havasını doldurmak ister misiniz? (evet/hayır)");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                log("Kaç psi basmak istiyorsunuz?");
                int hava = Integer.parseInt(inp.nextLine());
                log("Hava şişiriliyor...");
                arkaSol.sisir(hava);
            }
        }

        if (arkaSag.basincKontrol()) {
            log(arkaSag.getKonum() + " tekerleğin havası çok düşük!");
            sorun = true;
            log("Havasını doldurmak ister misiniz? (evet/hayır)");
            cevap = inp.nextLine();
            if (cevap.equalsIgnoreCase("evet")) {
                log("Kaç psi basmak istiyorsunuz?");
                int hava = Integer.parseInt(inp.nextLine());
                log("Hava şişiriliyor...");
                arkaSag.sisir(hava);
            }
        }

        if (sorun) {
            log("Aracı çalıştırma, lastik basınçlarını kontrol et!");
            return;
        } else {
            log("Tüm lastikler normal, yola çıkabilirsin.");
        }

        depo.doldur(-harcananYakit);
        mesafe += km;
        log(km + " km yol gidildi.");
        log("Kalan yakıt: " + depo.getAnlik());
    }

    public void printStatus() {
        log("-------- ARAÇ DURUMU --------");
        log("Kalan Yakıt: " + depo.getAnlik() + " litre");
        log("Kat Edilen Mesafe: " + mesafe + " km");
        log("Sağ Ön Tekerlek Basıncı: " + onSag.getBasinc() + " psi");
        log("Sol Ön Tekerlek Basıncı: " + onSol.getBasinc() + " psi");
        log("Arka Sağ Tekerlek Basıncı: " + arkaSag.getBasinc() + " psi");
        log("Arka Sol Tekerlek Basıncı: " + onSol.getBasinc() + " psi");
    }

    public void yakitDoldur(int litre) {
        depo.doldur(litre);

    }

    public void tekerlekBasincleri() {
        log("Sağ Ön Tekerlek Basıncı: " + onSag.getBasinc() + " psi");
        log("Sol Ön Tekerlek Basıncı: " + onSol.getBasinc() + " psi");
        log("Arka Sağ Tekerlek Basıncı: " + arkaSag.getBasinc() + " psi");
        log("Arka Sol Tekerlek Basıncı: " + onSol.getBasinc() + " psi");
    }
    public int getMesafe() {
        return mesafe;
    }

}

