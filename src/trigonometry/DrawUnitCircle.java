import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DrawUnitCircle extends JFrame {

    public static JFrame frame = new JFrame() {{
        setSize(900, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }};

    public static Graphics drawCircle(Graphics g, int x, int y, int width, int height) {
        int raio = width / 2;
        int centerX = x + raio;
        int centerY = y + raio;
        g.drawOval(x, y, width, height);
        g.drawLine(x, centerY, x + width, centerY);
        g.drawLine(centerX, y, centerX, y + height);
        return g;
    }

    public static void drawSeno(double sen, double angle) {
        double finalAng = angle % 360.0;
        System.out.println(finalAng);
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                int height = (getSize().height / 2);
                int width = height;
                int raio = width / 2;
                int x = (getSize().width / 2) - raio;
                int y = (getSize().height / 2) - raio;
                double cos = 0;
                if (finalAng <= 90 || finalAng > 270) {
                    cos = Math.sqrt(1 - Math.pow(sen, 2));
                } else {
                    cos = -(Math.sqrt(1 - Math.pow(sen, 2)));
                }
                int translateX = (int) (raio * cos);
                int translateY = (int) (raio * sen);
                int centerX = x + raio;
                int centerY = y + raio;
                g = drawCircle(g, x, y, width, height);

                if (Math.abs(sen) > 0 && Math.abs(sen) <= 1) {
                    g.drawLine(centerX, centerY - translateY, centerX + translateX, centerY - translateY);
                    g.drawLine(centerX, centerY, centerX + translateX, centerY - translateY);
                    g.setColor(Color.BLUE);
                    g.drawLine(centerX, centerY, centerX, centerY - translateY);
                    g.setColor(Color.BLACK);
                    g.drawString("" + sen, centerX + (translateX / 6), centerY - translateY / 2);
                }
            }
        };

        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void drawCos(double cos, double angle) {
        double finalAng = angle % 360.0;
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                int height = (getSize().height / 2);
                int width = height;
                int raio = width / 2;
                int x = (getSize().width / 2) - raio;
                int y = (getSize().height / 2) - raio;
                double sen = 0;
                if (finalAng < 180) {
                    sen = Math.sqrt(1 - Math.pow(cos, 2));
                } else {
                    sen = -(Math.sqrt(1 - Math.pow(cos, 2)));
                }
                int translateX = (int) (raio * cos);
                int translateY = (int) (raio * sen);
                int centerX = x + raio;
                int centerY = y + raio;
                g = drawCircle(g, x, y, width, height);

                if (Math.abs(cos) > 0 && Math.abs(cos) < 1) {
                    g.drawLine(centerX, centerY, centerX + translateX, centerY - translateY);
                    g.drawLine(centerX + translateX, centerY, centerX + translateX, centerY - translateY);
                    g.setColor(Color.BLUE);
                    g.drawLine(centerX, centerY, centerX + (int) (raio * cos), centerY);
                    g.setColor(Color.BLACK);
                    g.drawString("" + cos, centerX + (int) ((raio * cos) / 2), centerY - (int) ((raio * sen) / 4));
                }
            }
        };

        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
}
