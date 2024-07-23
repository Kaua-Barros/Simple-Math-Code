package trigonometry;


import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DrawTrigonometricFunctions {

    private static final DecimalFormat formatDouble = new DecimalFormat("#.##");
    private static double formatNum(double x) {
        return Double.parseDouble((formatDouble.format(x)).replace(",", "."));
    }

    public static void drawFunctionSen(double interval, double period) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);

                int offsetY = getHeight() / 2;
                int offsetX = getWidth() / 2;
                final int scale = 90;
                int zoom = 1;

                for (double i = -getWidth() / 2.0; i <= getWidth() / 2.0; i += 0.5) {
                    int cont = (int) i;
                    if (cont == i) {
                        g.drawString("" + cont, offsetX + (scale * cont), offsetY + 10);
                        if(cont != 0) {
                            g.drawString("" + cont, offsetX + 10, offsetY - (scale * cont));
                        }
                    }
                    g.drawLine(offsetX + (scale * zoom * cont), 0, offsetX + (scale * zoom * cont), getHeight());
                    g.drawLine(0, offsetY - (scale * zoom * cont), getWidth(), offsetY - (scale  * zoom * cont));
                    double radians = i * CalcTrigonometry.DEGREES_TO_RADIANS;
                    double value = Sen.taylorSerieSen(radians / period);
                    int x = (int) (offsetX + (i * 1.570796 * (zoom))); // 90° equivalem a 1.570796 rad
                    int y = (int) (offsetY - ((scale * value)) * interval);
                    g.fillOval(x, y, 2 * (zoom), 2 * (zoom));
                }
            }
        };

        JFrame frame = CalcTrigonometry.frame;
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void drawFunctionCos(double interval, double period) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);

                int offsetY = getHeight() / 2;
                int offsetX = getWidth() / 2;
                final int scale = 90;
                int zoom = 1;

                for (double i = -getWidth() / 2.0; i <= getWidth() / 2.0; i += 0.5) {
                    int cont = (int) i;
                    if (cont == i) {
                        g.drawString("" + cont, offsetX + (scale * cont), offsetY + 10);
                        if(cont != 0) {
                            g.drawString("" + cont, offsetX + 10, offsetY - (scale * cont));
                        }
                    }
                    g.drawLine(offsetX + (scale * zoom * cont), 0, offsetX + (scale * zoom * cont), getHeight());
                    g.drawLine(0, offsetY - (scale * zoom * cont), getWidth(), offsetY - (scale  * zoom * cont));
                    double radians = i * CalcTrigonometry.DEGREES_TO_RADIANS;
                    double value = Cos.taylorSerieCos(radians / period);
                    int x = (int) (offsetX + (i * 1.570796 * (zoom))); // 90° equivalem a 1.570796 rad
                    int y = (int) (offsetY - ((scale * value)) * interval);
                    g.fillOval(x, y, 2 * (zoom), 2 * (zoom));
                }
            }
        };

        JFrame frame = CalcTrigonometry.frame;
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void drawFunctionTan(double interval, double period) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);

                int offsetY = getHeight() / 2;
                int offsetX = getWidth() / 2;
                final int scale = 90;
                int zoom = 1;

                for (double i = -getWidth() / 2.0; i <= getWidth() / 2.0; i += 0.05) {
                    i = formatNum(i);
                    int cont = (int) i;
                    if (cont == i) {
                        g.drawString("" + cont, offsetX + (scale * cont), offsetY + 15);
                        if(cont != 0) {
                            g.drawString("" + cont, offsetX + 15, offsetY - (scale * cont));
                        }
                    }
                    g.drawLine(offsetX + (scale * zoom * cont), 0, offsetX + (scale * zoom * cont), getHeight());
                    g.drawLine(0, offsetY - (scale * zoom * cont), getWidth(), offsetY - (scale  * zoom * cont));
                    double radians = i * CalcTrigonometry.DEGREES_TO_RADIANS;
                    double value = Tangent.taylorSerieTan(radians / period);
                    int x = (int) (offsetX + (i * 1.570796 * (zoom))); // 90° equivalem a 1.570796 rad
                    int y = (int) (offsetY - ((scale * value)) * interval);
                    g.fillOval(x, y, 2 * (zoom), 2 * (zoom));
                }
            }
        };

        JFrame frame = CalcTrigonometry.frame;
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
}
