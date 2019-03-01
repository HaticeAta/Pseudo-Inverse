/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisintersi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Hatice
 */
public class RastgeleMatrisOlustur extends JFrame implements ActionListener {

    static double[][] matris;
    static int satir;   // M
    static int sutun;   // N

    public RastgeleMatrisOlustur() {

        super("Rastgele Matris Oluşturma Ve Matrisin Tersini Hesaplama");
        this.setLayout(null);

        this.setLayout(null);
        this.setSize(1100, 700);
        this.setLocation(150, 20);
        this.setVisible(true); //görünürlük
        this.setResizable(false);

        panel1olustur("");

        panel3olustur();
        panel4olustur("", "");
        panel2olustur("");
        hesapla.setVisible(false);
    }

    static String mat = "<html> ";
    static String sonucyaz = "<html> ";

    public static void matrisyaz(double[][] mt) {

        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                mat += mt[i][j] + " &nbsp &nbsp &nbsp ";
            }
            mat += " <br> ";
        }

    }

    public static void sonucyaz(double[][] mt) {

        for (int i = 0; i < sutun; i++) {
            for (int j = 0; j < satir; j++) {
                sonucyaz += Math.round(mt[i][j] * 1000000.0) / 1000000.0 + " &nbsp &nbsp &nbsp ";
            }
            sonucyaz += " <br> ";
        }

    }

    public void panel1olustur(String yaz) {   // Rastgele Matrisi Gösterir

        panel1.setBounds(290, 0, 300, 195);
        panel1.setBackground(Color.decode("#aaaaaa"));
        panel1.setLayout(null);

        yazi1 = new JLabel(yaz);
        yazi1.setBounds(5, 5, 290, 25);
        yazi1.setFont(font1);
        panel1.add(yazi1);

        matt = new JLabel(mat + " </html>");
        matt.setBounds(5, 30, 290, 130);
        matt.setFont(font2);
        matt.setBackground(Color.red);
        panel1.add(matt);

        this.add(panel1);

    }
    JTextArea text = new JTextArea();
    JScrollPane sp = new JScrollPane(text);
    JPanel panel2 = new JPanel();

    public void panel2olustur(String textt) {

        panel2.setBounds(0, 195, 1095, 475);
        panel2.setBackground(Color.decode("#aaaaaa"));
        panel2.setLayout(null);

        czm = new JLabel("Cözüm : ");
        czm.setBounds(5, 5, 200, 20);
        czm.setFont(font1);
        panel2.add(czm);
        text.setFont(font3);

        text.setText(textt);
        text.setWrapStyleWord(true);

        text.setBounds(5, 30, 1075, 435);
        sp.setBounds(5, 30, 1075, 435);
        panel2.add(sp);
        this.add(panel2);
    }

    public void panel3olustur() {
        panel3 = new JPanel();
        panel3.setBounds(0, 0, 295, 195);
        panel3.setBackground(Color.decode("#aaaaaa"));
        panel3.setLayout(null);

        yenimatris = new JButton(" Yeni Matris Oluştur ");
        yenimatris.setActionCommand("yenimatris");
        yenimatris.addActionListener(this);
        yenimatris.setBounds(40, 60, 200, 25);
        panel3.add(yenimatris);

        hesapla = new JButton(" Hesapla ");
        hesapla.setActionCommand("hesapla");
        hesapla.addActionListener(this);
        hesapla.setBounds(40, 105, 200, 25);
        panel3.add(hesapla);

        this.add(panel3);
    }

    public void panel4olustur(String txt, String yaz) {

        panel4.setBounds(590, 0, 505, 195);
        panel4.setLayout(null);
        panel4.setBackground(Color.decode("#aaaaaa"));

        yazi2 = new JLabel(yaz);
        yazi2.setBounds(5, 5, 490, 25);
        yazi2.setFont(font1);
        panel4.add(yazi2);

        sonuc = new JLabel(txt);
        sonuc.setBounds(5, 30, 490, 150);
        sonuc.setFont(font2);

        panel4.add(sonuc);
        this.add(panel4);
    }

    public static void matrisolustur() {

        Random rand = new Random();

        ///   Virgülden sonra 1 basamak yazdırmak için
        ///   double sayi = Math.round(a*10.0)/10.0;
        ///   double say ;
        ///   say=Math.round((rand.nextDouble()*8.9+1)*10.0)/10.0;
        do {
            satir = rand.nextInt(5) + 1;
            sutun = rand.nextInt(5) + 1;
        } while (satir == sutun);

        matris = new double[satir][sutun];

        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                matris[i][j] = Math.round((rand.nextDouble() * 7.9 + 1) * 10.0) / 10.0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("yenimatris")) {

            hesapla.setVisible(true);
            matrisolustur();
            mat = "<html> ";
            matrisyaz(matris);
            panel1.removeAll();
            panel1.revalidate();
            panel1.repaint();

            panel4.removeAll();
            panel4.revalidate();
            panel4.repaint();

            yazi1.setVisible(false);
            panel1olustur("A Matrisi: ");
        } else if (text.equals("hesapla")) {
            Hesaplama.matrisial(matris);
            sonucyaz = "<html> ";
            sonucyaz(Hesaplama.amatrisinintersi);
            sonuc.setVisible(false);
            panel4.removeAll();
            panel4.revalidate();
            panel4.repaint();
            panel4olustur(sonucyaz, "A Matrisinin Tersi");

            yazdir = Hesaplama.yazi + "\n"+ Hesaplama.yazi1 + "\n" + Hesaplama.yazi2+ "\n"+Hesaplama.yazi7
                    + "\n"+Hesaplama.yazi6+"\n"+Hesaplama.yazi10+"\n"+Hesaplama.yazi12+"\n"+Hesaplama.yazi11+"\n"+
                    Hesaplama.yazi13+"\n"+Hesaplama.yazi15;

            panel2olustur(yazdir);

        }
    }
    String yazdir;
    JPanel panel1 = new JPanel();

    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    Font font1 = new Font("Comic San MS", Font.CENTER_BASELINE, 20);
    Font font2 = new Font("Comic San MS", Font.CENTER_BASELINE, 16);
    Font font3 = new Font("Comic San MS", Font.CENTER_BASELINE, 14);
    JLabel matt, sonuc, czm, yazi1, yazi2;

    JButton yenimatris, hesapla;
}
