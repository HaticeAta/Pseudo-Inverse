/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisintersi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hatice
 */
public class MatrisinTersi extends JFrame implements ActionListener {

    JButton birincibuton;
    JButton ikincibuton;
    JPanel panel;
    JLabel arkaplan;

    public MatrisinTersi() {
        super("KARE OLMAYAN MATRİSİN SÖZDE TERSİNİ BULMA");
        this.setSize(630, 400);
        this.setLocation(350, 120);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        birincibuton = new JButton(" Rastgele Matris Oluşturma ");
        birincibuton.setActionCommand("ilkbuton");
        birincibuton.addActionListener(this);
        birincibuton.setBackground(Color.decode("#cccccc"));
        birincibuton.setBounds(165, 140, 300, 30);

        ikincibuton = new JButton(" Kullanıcının Matris Oluşturması ");
        ikincibuton.setActionCommand("ikincibuton");
        ikincibuton.addActionListener(this);
        ikincibuton.setBackground(Color.decode("#cccccc"));
        ikincibuton.setBounds(165, 200, 300, 30);

        arkaplan = new JLabel();
        arkaplan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice\\Desktop\\MatrisinTersi\\resim\\mat.jpeg"));
        arkaplan.setBounds(0, 0, 630, 400);
        arkaplan.setLayout(null);

        this.add(panel);
        panel.add(birincibuton);
        panel.add(ikincibuton);
        panel.add(arkaplan);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MatrisinTersi uygulama = new MatrisinTersi();
            } catch (Exception e) {
                System.out.println("Uygulama Başlatılamadi");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("ilkbuton")) {
            RastgeleMatrisOlustur random = new RastgeleMatrisOlustur();
        } else if (text.equals("ikincibuton")) {
            KullaniciMatrisOlustur sayigir = new KullaniciMatrisOlustur();
        }
    }

}
