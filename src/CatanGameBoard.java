import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JApplet;
import javax.swing.JPanel;

import java.net.*;
import java.io.*;
import java.util.*;

public class CatanGameBoard extends JPanel {

    static Dimension screenSize;
    Polygon[] polygons = new Polygon[19];
    static Point[] points = new Point[54];



    public static void setVerticesIndex() {
        for (int i = 0; i < 3; i++) {
            points[i] = new Point(-400, (int) (-200 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 4; i++) {
            points[i + 3] = new Point(-350, (int) (-300 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 4; i++) {
            points[i + 7] = new Point(-250, (int) (-300 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 5; i++) {
            points[i + 11] = new Point(-200, (int) (-400 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 5; i++) {
            points[i + 16] = new Point(-100, (int) (-400 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 6; i++) {
            points[i + 21] = new Point(-50, (int) (-500 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 6; i++) {
            points[i + 27] = new Point(50, (int) (-500 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 5; i++) {
            points[i + 33] = new Point(100, (int) (-400 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 5; i++) {
            points[i + 38] = new Point(200, (int) (-400 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 4; i++) {
            points[i + 43] = new Point(250, (int) (-300 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 4; i++) {
            points[i + 47] = new Point(350, (int) (-300 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }

        for (int i = 0; i < 3; i++) {
            points[i + 51] = new Point(400, (int) (-200 * Math.sin(Math.PI/3) + i * 200 * Math.sin(Math.PI/3)));
        }
    }

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        polygons[0] = makeHexagon(0, 400 * Math.sin(Math.PI/3));

        for (int i = 0; i < 2; i++) {
            polygons[i + 1] = makeHexagon(-150 + i * 300, 300 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 3] = makeHexagon(-300 + i * 300, 200 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 6] = makeHexagon(-150 + i * 300, 100 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 8] = makeHexagon(-300 + i * 300,0);
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 11] = makeHexagon(-150 + i * 300, -100 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 13] = makeHexagon(-300 + i * 300, -200 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 16] = makeHexagon(-150 + i * 300, -300 * Math.sin(Math.PI/3));
        }

        polygons[18] = makeHexagon(0, -400 * Math.sin(Math.PI/3));

        for (int j = 0; j < 19; j++) {
            g.drawPolygon(polygons[j]);
        }
	}

    public static Polygon makeHexagon(double x, double y) {
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (screenSize.width/2 + x + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + y + 100 * Math.sin(i * 2 * Math.PI / 6))));
        return p;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Catan");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVerticesIndex();
        Container contentPane = new Container();
        JScrollPane scrollPane = new JScrollPane(new CatanGameBoard()); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add("Center", scrollPane);
        frame.setSize(screenSize.width,screenSize.height);
        frame.setVisible(true);
        frame.show();
    }
}