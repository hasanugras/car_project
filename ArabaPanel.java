import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class ArabaPanel extends JPanel {
    private int x = 50;

    // Yeni: animasyonlu ilerleme
    public void ilerle(int km) {
        // km kadar pixele çevir, mesela 1 km = 5 pixel
        int hedefX = x + km * 5;

        // Küçük adımlarla hareket ettir
        new Thread(() -> {
            while (x < hedefX) {
                x += 2; // her adımda 2 pixel ilerle
                repaint(); // paneli tekrar çiz
                try {
                    Thread.sleep(20); // 20 ms bekle
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(x, 100, 100, 50); // araba gövdesi
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + 10, 140, 20, 20); // sol teker
        g.fillOval(x + 70, 140, 20, 20); // sağ teker
    }
}
