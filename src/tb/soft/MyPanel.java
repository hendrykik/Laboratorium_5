package tb.soft;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private int xMouse = 600;
    private int yMouse = 600;
    Random rand = new Random();
    private static int a;
    private static int b;
    private static int c;
    private static int r;
    private static int figura = 1;
    JButton loginButton = new JButton("ucieka");
    JButton resetButton = new JButton("reset");
    ArrayList<figure> figury = new ArrayList();

    MyPanel() {
        this.setLayout((LayoutManager)null);
        this.setPreferredSize(new Dimension(500, 300));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.loginButton.setBounds(250, 150, 100, 30);
        this.loginButton.addMouseListener(this);
        this.add(this.loginButton);
        this.resetButton.setBounds(350, 150, 100, 30);
        this.resetButton.addActionListener(this);
        this.add(this.resetButton);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        a = this.rand.nextInt(256);
        b = this.rand.nextInt(256);
        c = this.rand.nextInt(256);
        r = this.rand.nextInt(70) + 10;
        Iterator var3 = this.figury.iterator();

        while(var3.hasNext()) {
            Object k = var3.next();
            if (((figure)k).figura1 == 1) {
                g2D.setColor(new Color(((figure)k).a1, ((figure)k).b1, ((figure)k).c1));
                g2D.fillOval(((figure)k).x1, ((figure)k).y1, ((figure)k).r1, ((figure)k).r1);
            }

            if (((figure)k).figura1 == 2) {
                g2D.setColor(new Color(((figure)k).a1, ((figure)k).b1, ((figure)k).c1));
                g2D.fillRect(((figure)k).x1, ((figure)k).y1, ((figure)k).r1, ((figure)k).r1);
            }
        }

        figure jeden = new figure(this.xMouse - r / 2, this.yMouse - r / 2, r, r, figura, a, b, c);
        this.figury.add(jeden);
        g2D.setColor(new Color(a, b, c));
        if (figura == 1) {
            g2D.fillOval(this.xMouse - r / 2, this.yMouse - r / 2, r, r);
        }

        if (figura == 2) {
            g2D.fillRect(this.xMouse - r / 2, this.yMouse - r / 2, r, r);
        }

    }

    public void actionPerformed(ActionEvent e) {
        this.loginButton.setBounds(250, 150, 100, 30);
        r = 0;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        char k = e.getKeyChar();
        if (k == 'o') {
            figura = 1;
            this.whereMouse();
            this.repaint();
        }

        if (k == 'k') {
            figura = 2;
            this.whereMouse();
            this.repaint();
        }

    }

    public void keyReleased(KeyEvent e) {
    }

    private void whereMouse() {
        Point tu = MouseInfo.getPointerInfo().getLocation();
        this.xMouse = tu.x - this.getLocationOnScreen().x;
        this.yMouse = tu.y - this.getLocationOnScreen().y;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        int wid = this.loginButton.getWidth();
        if (e.getX() < wid - 20) {
            Random r = new Random();
            int szer = r.nextInt(400);
            int wys = r.nextInt(270);
            this.loginButton.setBounds(szer, wys, 100, 30);
        }

    }

    public void mouseExited(MouseEvent e) {
    }
}

