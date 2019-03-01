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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hatice
 */
public class KullaniciMatrisOlustur extends JFrame implements ActionListener {

    static double[][] matris;
    static int satir, sutun;
    static String sonucyaz = "<html>   ";

    public KullaniciMatrisOlustur() {

        super("Kullanıcının Matris Oluşturması Ve Matrisin Tersini Hesaplama");
        this.setLayout(null);
        this.setSize(1100, 700);
        this.setLocation(150, 20);
        this.setVisible(true); //görünürlük
        this.setResizable(false);

        panel1olustur();
        panel2olustur(" ");
        panel3olustur(0, 0, "");
        panel4olustur("", "");
        hesapla.setVisible(false);

    }

    public static void sonucyaz(double[][] mt) {
        mt = Hesaplama.amatrisinintersi;
        for (int i = 0; i < sutun; i++) {
            for (int j = 0; j < satir; j++) {
                sonucyaz += Math.round(mt[i][j] * 1000000.0) / 1000000.0 + " &nbsp &nbsp ";
            }
            sonucyaz += " <br> ";
        }

    }

    public void panel1olustur() {
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 295, 195);
        panel1.setBackground(Color.decode("#aaaaaa"));
        panel1.setLayout(null);

        satirL = new JLabel("Satır sayısını giriniz   : ");
        satirL.setBounds(5, 15, 220, 25);
        satirL.setFont(font2);
        panel1.add(satirL);

        satirT = new JTextField(15);
        satirT.setBounds(225, 15, 35, 25);
        panel1.add(satirT);

        sutunL = new JLabel("Sütun sayısını giriniz :");
        sutunL.setBounds(5, 50, 220, 25);
        sutunL.setFont(font2);
        panel1.add(sutunL);

        sutunT = new JTextField(15);
        sutunT.setBounds(225, 50, 35, 25);
        panel1.add(sutunT);

        matrisolustur = new JButton(" Matris Oluştur ");
        matrisolustur.setActionCommand("matrisolustur");
        matrisolustur.addActionListener(this);
        matrisolustur.setBounds(60, 100, 150, 25);
        hesapla = new JButton(" Hesapla ");
        hesapla.setActionCommand("hesapla");
        hesapla.addActionListener(this);
        hesapla.setBounds(60, 145, 150, 25);
        panel1.add(hesapla);
        panel1.add(matrisolustur);
        this.add(panel1);
    }

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

    public void panel4olustur(String txt, String yaz) {
        panel4.setBounds(590, 0, 505, 195);
        panel4.setBackground(Color.decode("#aaaaaa"));
        panel4.setLayout(null);

        yazi = new JLabel(yaz);
        yazi.setBounds(5, 5, 470, 25);
        yazi.setFont(font2);

        sonuc = new JLabel(txt);
        sonuc.setBounds(5, 35, 470, 150);
        sonuc.setFont(font1);

        panel4.add(yazi);
        panel4.add(sonuc);
        this.add(panel4);
    }

    public void panel3olustur(int satirs, int sutuns, String yaz) {

        panel3.setBounds(290, 0, 300, 195);
        panel3.setBackground(Color.decode("#aaaaaa"));
        panel3.setLayout(null);
        panel3.setVisible(true);

        yazi1 = new JLabel(yaz);
        yazi1.setBounds(20, 5, 305, 20);
        yazi1.setFont(font2);
        panel3.add(yazi1);

        int x = 20, y = 30, e = 30, b = 20;
        if (satirs >= 1) {
            if (sutuns >= 1) {
                a00 = new JTextField(15);
                a00.setBounds(x, y, e, b);
                panel3.add(a00);
            }
            if (sutuns >= 2) {
                a01 = new JTextField(15);
                a01.setBounds(x + 60, y, e, b);
                panel3.add(a01);
            }
            if (sutuns >= 3) {
                a02 = new JTextField(15);
                a02.setBounds(x + 120, y, e, b);
                panel3.add(a02);
            }
            if (sutuns >= 4) {
                a03 = new JTextField(15);
                a03.setBounds(x + 180, y, e, b);
                panel3.add(a03);
            }
            if (sutuns >= 5) {
                a04 = new JTextField(15);
                a04.setBounds(x + 240, y, e, b);
                panel3.add(a04);
            }
        }
        if (satirs >= 2) {
            if (sutuns >= 1) {
                a10 = new JTextField(15);
                a10.setBounds(x, y + 30, e, b);
                panel3.add(a10);
            }
            if (sutuns >= 2) {
                a11 = new JTextField(15);
                a11.setBounds(x + 60, y + 30, e, b);
                panel3.add(a11);
            }
            if (sutuns >= 3) {
                a12 = new JTextField(15);
                a12.setBounds(x + 120, y + 30, e, b);
                panel3.add(a12);
            }
            if (sutuns >= 4) {
                a13 = new JTextField(15);
                a13.setBounds(x + 180, y + 30, e, b);
                panel3.add(a13);
            }
            if (sutuns >= 5) {
                a14 = new JTextField(15);
                a14.setBounds(x + 240, y + 30, e, b);
                panel3.add(a14);
            }
        }
        if (satirs >= 3) {
            if (sutuns >= 1) {
                a20 = new JTextField(15);
                a20.setBounds(x, y + 60, e, b);
                panel3.add(a20);
            }
            if (sutuns >= 2) {
                a21 = new JTextField(15);
                a21.setBounds(x + 60, y + 60, e, b);
                panel3.add(a21);
            }
            if (sutuns >= 3) {
                a22 = new JTextField(15);
                a22.setBounds(x + 120, y + 60, e, b);
                panel3.add(a22);
            }
            if (sutuns >= 4) {
                a23 = new JTextField(15);
                a23.setBounds(x + 180, y + 60, e, b);
                panel3.add(a23);
            }
            if (sutuns >= 5) {
                a24 = new JTextField(15);
                a24.setBounds(x + 240, y + 60, e, b);
                panel3.add(a24);
            }
        }
        if (satirs >= 4) {
            if (sutuns >= 1) {
                a30 = new JTextField(15);
                a30.setBounds(x, y + 90, e, b);
                panel3.add(a30);
            }
            if (sutuns >= 2) {
                a31 = new JTextField(15);
                a31.setBounds(x + 60, y + 90, e, b);
                panel3.add(a31);
            }
            if (sutuns >= 3) {
                a32 = new JTextField(15);
                a32.setBounds(x + 120, y + 90, e, b);
                panel3.add(a32);
            }
            if (sutuns >= 4) {
                a33 = new JTextField(15);
                a33.setBounds(x + 180, y + 90, e, b);
                panel3.add(a33);
            }
            if (sutuns >= 5) {
                a34 = new JTextField(15);
                a34.setBounds(x + 240, y + 90, e, b);
                panel3.add(a34);
            }
        }
        if (satirs >= 5) {

            if (sutuns >= 1) {
                a40 = new JTextField(15);
                a40.setBounds(x, y + 120, e, b);
                panel3.add(a40);
            }
            if (sutuns >= 2) {
                a41 = new JTextField(15);
                a41.setBounds(x + 60, y + 120, e, b);
                panel3.add(a41);
            }
            if (sutuns >= 3) {
                a42 = new JTextField(15);
                a42.setBounds(x + 120, y + 120, e, b);
                panel3.add(a42);
            }
            if (sutuns >= 4) {
                a43 = new JTextField(15);
                a43.setBounds(x + 180, y + 120, e, b);
                panel3.add(a43);
            }
            if (sutuns >= 5) {
                a44 = new JTextField(15);
                a44.setBounds(x + 240, y + 120, e, b);
                panel3.add(a44);
            }
        }

        this.add(panel3);

    }

    public void matrisbilgilerial(int satirs, int sutuns) {
        matris = new double[satirs][sutuns];
        if (satirs >= 1) {
            if (sutuns >= 1) {
                matris[0][0] = Double.parseDouble(a00.getText());
            }
            if (sutuns >= 2) {
                matris[0][1] = Double.parseDouble(a01.getText());
            }
            if (sutuns >= 3) {
                matris[0][2] = Double.parseDouble(a02.getText());
            }
            if (sutuns >= 4) {
                matris[0][3] = Double.parseDouble(a03.getText());
            }
            if (sutuns >= 5) {
                matris[0][4] = Double.parseDouble(a04.getText());
            }
        }
        if (satirs >= 2) {
            if (sutuns >= 1) {
                matris[1][0] = Double.parseDouble(a10.getText());
            }
            if (sutuns >= 2) {
                matris[1][1] = Double.parseDouble(a11.getText());
            }
            if (sutuns >= 3) {
                matris[1][2] = Double.parseDouble(a12.getText());
            }
            if (sutuns >= 4) {
                matris[1][3] = Double.parseDouble(a13.getText());
            }
            if (sutuns >= 5) {
                matris[1][4] = Double.parseDouble(a14.getText());
            }
        }
        if (satirs >= 3) {
            if (sutuns >= 1) {
                matris[2][0] = Double.parseDouble(a20.getText());
            }
            if (sutuns >= 2) {
                matris[2][1] = Double.parseDouble(a21.getText());
            }
            if (sutuns >= 3) {
                matris[2][2] = Double.parseDouble(a22.getText());
            }
            if (sutuns >= 4) {
                matris[2][3] = Double.parseDouble(a23.getText());
            }
            if (sutuns >= 5) {
                matris[2][4] = Double.parseDouble(a24.getText());
            }
        }
        if (satirs >= 4) {
            if (sutuns >= 1) {
                matris[3][0] = Double.parseDouble(a30.getText());
            }
            if (sutuns >= 2) {
                matris[3][1] = Double.parseDouble(a31.getText());
            }
            if (sutuns >= 3) {
                matris[3][2] = Double.parseDouble(a32.getText());
            }
            if (sutuns >= 4) {
                matris[3][3] = Double.parseDouble(a33.getText());
            }
            if (sutuns >= 5) {
                matris[3][4] = Double.parseDouble(a34.getText());
            }
        }
        if (satirs >= 5) {
            if (sutuns >= 1) {
                matris[4][0] = Double.parseDouble(a40.getText());
            }
            if (sutuns >= 2) {
                matris[4][1] = Double.parseDouble(a41.getText());
            }
            if (sutuns >= 3) {
                matris[4][2] = Double.parseDouble(a42.getText());
            }
            if (sutuns >= 4) {
                matris[4][3] = Double.parseDouble(a43.getText());
            }
            if (sutuns >= 5) {
                matris[4][4] = Double.parseDouble(a44.getText());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("matrisolustur")) {
            panel4.removeAll();
            panel4.revalidate();
            panel4.repaint();
            String satirst = satirT.getText();
            String sutunst = sutunT.getText();
            if (satirst.equals("") || sutunst.equals("")) {
                JOptionPane.showMessageDialog(null, "Eksik bilgi girdiniz ...");
            } else {
                satir = Integer.parseInt(satirst);
                sutun = Integer.parseInt(sutunst);
                if (satir < 6 && satir > 0 && sutun < 6 && sutun > 0 && satir != sutun) {
                    panel3.removeAll();
                    panel3.revalidate();
                    panel3.repaint();
                    panel3olustur(satir, sutun, "A Matrisi");
                    hesapla.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Satır ve sütun sayısı birbirinden farklı ve [1-5] arasında bir rakam olmalıdır.");
                }
            }

        } else if (text.equals("hesapla")) {
            matrisbilgilerial(satir, sutun);
            Hesaplama.matrisial(matris);
            sonucyaz = "<html> ";
            sonucyaz(Hesaplama.amatrisinintersi);
            sonuc.setVisible(false);
            yazi.setVisible(false);
            panel4.removeAll();
            panel4.revalidate();
            panel4.repaint();
            panel4olustur(sonucyaz, "A Matrisin Tersi");

            yazdir = Hesaplama.yazi + "\n" + Hesaplama.yazi1 + "\n" + Hesaplama.yazi2 + "\n" + Hesaplama.yazi7
                    + "\n" + Hesaplama.yazi6 + "\n" + Hesaplama.yazi10 + "\n" + Hesaplama.yazi12 + "\n" + Hesaplama.yazi11 + "\n"
                    + Hesaplama.yazi13 + "\n" + Hesaplama.yazi15;

            panel2olustur(yazdir);

        }

    }
    String yazdir;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JTextArea text = new JTextArea();
    JScrollPane sp = new JScrollPane(text);
    JLabel satirL, sutunL, czm, sonuc, yazi, yazi1;
    JTextField satirT, sutunT;
    JButton matrisolustur, hesapla;
    JTextField a00, a01, a02, a03, a04;
    JTextField a10, a11, a12, a13, a14;
    JTextField a20, a21, a22, a23, a24;
    JTextField a30, a31, a32, a33, a34;
    JTextField a40, a41, a42, a43, a44;
    Font font1 = new Font("Comic San MS", Font.CENTER_BASELINE, 16);
    Font font2 = new Font("Comic San MS", Font.CENTER_BASELINE, 20);
    Font font3 = new Font("Comic San MS", Font.CENTER_BASELINE, 14);

}
