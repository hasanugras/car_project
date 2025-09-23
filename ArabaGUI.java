import javax.swing.*;
import java.awt.*;

public class ArabaGUI extends JFrame {

    private Car araba;
    private JTextArea output;
    private ArabaPanel arabaPanel;

    public ArabaGUI() {
        setTitle("Araba Simülasyonu");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Çıktıları göster
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        // Araba paneli
        arabaPanel = new ArabaPanel();
        arabaPanel.setPreferredSize(new Dimension(600, 200));
        add(arabaPanel, BorderLayout.NORTH);

        // Car nesnesi
        araba = new Car(mesaj -> output.append(mesaj + "\n"));

        // Buton paneli
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));

        JButton ilerleBtn = new JButton("İlerle");
        JButton yakitBtn = new JButton("Yakıt Doldur");
        JButton basincBtn = new JButton("Basınç Kontrol");
        JButton durumBtn = new JButton("Durum");
        JButton cikisBtn = new JButton("Çıkış");

        panel.add(ilerleBtn);
        panel.add(yakitBtn);
        panel.add(basincBtn);
        panel.add(durumBtn);
        panel.add(cikisBtn);

        add(panel, BorderLayout.SOUTH);

        // Buton aksiyonları
        ilerleBtn.addActionListener(e -> ilerleAraba());
        yakitBtn.addActionListener(e -> yakitDoldur());
        basincBtn.addActionListener(e -> tekerlekKontrol());
        durumBtn.addActionListener(e -> durumGoster());
        cikisBtn.addActionListener(e -> System.exit(0));
    }

    private void ilerleAraba() {
        String input = JOptionPane.showInputDialog(this, "Kaç km gitmek istiyorsunuz?");
        if (input != null) {
            int km = Integer.parseInt(input);

            // 🔹 Önce Car sınıfı mantığını çalıştır
            int oncekiMesafe = araba.getMesafe(); // Car sınıfına getMesafe() ekleyelim
            araba.ilerle(km);
            int mesafeGidilen = araba.getMesafe() - oncekiMesafe;

            if (mesafeGidilen > 0) {
                output.append(mesafeGidilen + " km ilerlemeye çalışıldı.\n");

                // 🔹 Sadece gerçekten ilerlediyse paneli hareket ettir
                arabaPanel.ilerle(mesafeGidilen);
            }
        }
    }


    private void yakitDoldur() {
        String input = JOptionPane.showInputDialog(this, "Kaç litre yakıt doldurmak istiyorsunuz?");
        if (input != null) {
            int litre = Integer.parseInt(input);
            araba.yakitDoldur(litre);
            output.append(litre + " litre yakıt eklenmeye çalışıldı.\n");
        }
    }

    private void tekerlekKontrol() {
        araba.tekerlekBasincleri();
        output.append("Tekerlek basınçları kontrol edildi.\n");
    }

    private void durumGoster() {
        araba.printStatus();
        output.append("Durum gösterildi.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArabaGUI gui = new ArabaGUI();
            gui.setVisible(true);
        });
    }
}
