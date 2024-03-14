import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

public class Wyswietlanie extends JFrame{
    Wyswietlanie() {

setSize(700,1000);
setTitle("Saper");

napis = new JLabel("Saper");        
latwePrzycisk = new JButton("Łatwy");
sredniPrzycisk = new JButton("Średni");
trudnyPrzycisk = new JButton("Trudny");
JPanel panel = new Podstawowe(new Tablica(0));

add(napis);
add(latwePrzycisk);
add(sredniPrzycisk);
add(trudnyPrzycisk);
latwePrzycisk.setBounds(300, 100, 100, 40);
sredniPrzycisk.setBounds(300, 150, 100, 40);
trudnyPrzycisk.setBounds(300, 200, 100, 40);

setLayout(new BorderLayout());

latwePrzycisk.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Tablica tablica = new Tablica(50);
        latwePrzycisk.setVisible(false);
        sredniPrzycisk.setVisible(false);
        trudnyPrzycisk.setVisible(false);
        add(new Podstawowe(tablica), BorderLayout.CENTER);

    }
});

sredniPrzycisk.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        Tablica tablica = new Tablica(75);
        latwePrzycisk.setVisible(false);
        sredniPrzycisk.setVisible(false);
        trudnyPrzycisk.setVisible(false);
        add(new Podstawowe(tablica), BorderLayout.CENTER);
    }
});

trudnyPrzycisk.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        Tablica tablica = new Tablica(100);
        latwePrzycisk.setVisible(false);
        sredniPrzycisk.setVisible(false);
        trudnyPrzycisk.setVisible(false);
        add(new Podstawowe(tablica), BorderLayout.CENTER);
    }
});

napis.setBounds(325,50,150,20);


Font font = new Font("Arial", Font.BOLD, 20); 
napis.setFont(font);


}
  private JLabel napis;  
  private JButton latwePrzycisk;
  private JButton sredniPrzycisk;
  private JButton trudnyPrzycisk;

}
