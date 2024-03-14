import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Podstawowe extends JPanel {
    int[][] tablica = new int[20][20];
    boolean[][] odkryte;
    ImageIcon again = new ImageIcon("C:\\Users\\jessi\\OneDrive\\Pulpit\\Saper\\Saper\\again.png");
    ImageIcon bck = new ImageIcon("C:\\Users\\jessi\\OneDrive\\Pulpit\\Saper\\Saper\\back.png");

    JLabel gameOver;
    JLabel win;
    JButton jeszczeRaz;
    JButton back;

    int rozmiark = 30;
    int x = 35;
    int y = 100;
    int wiersz, kolumna;

    public Podstawowe(Tablica tablica) {

        
        this.tablica = tablica.tablica;
        this.odkryte = new boolean[20][20];
        this.gameOver = new JLabel("GAME OVER");
        this.gameOver.setBounds(230, 300, 700, 100);
        this.win = new JLabel("YOU WIN");
        this.win.setBounds(230, 300, 700, 100);
        this.jeszczeRaz = new JButton();
        this.jeszczeRaz.setBounds(350,730,80,40);
        this.back = new JButton();
        this.back.setBounds(250,730,80,40);
       
        int buttonWidth = 100;
        int buttonHeight = 40;
        jeszczeRaz.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        back.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));

        // Skaluj obrazki do rozmiaru przycisków
        Image againImage = again.getImage().getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);
        Image bckImage = bck.getImage().getScaledInstance(buttonWidth, buttonHeight, java.awt.Image.SCALE_SMOOTH);

      
        jeszczeRaz.setIcon(new ImageIcon(againImage));
        back.setIcon(new ImageIcon(bckImage));
        setLayout(null);


add(back);
add(jeszczeRaz);
        Font font = new Font("Arial", Font.BOLD, 50); 
        gameOver.setFont(font);
        gameOver.setForeground(Color.WHITE);
        win.setFont(font);
        win.setForeground(Color.WHITE);


//naciskanie na pola
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                wiersz = (mouseY - 100) / (rozmiark + 1);
                kolumna = (mouseX - 35) / (rozmiark + 1);
               
                if (wiersz >= 0 && wiersz < 20 && kolumna >= 0 && kolumna < 20) {
                    //odkryte[wiersz][kolumna] = true;
                    Wyswietlanie0(wiersz,kolumna);
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        int currentX = 35;
        int currentY = 100;
    //rysowanie kratek 
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                g.setColor(Color.BLACK);
                g.fillRect(currentX, currentY, rozmiark, rozmiark);
                Liczby(i, j, g, currentX, currentY); 
                currentX += rozmiark + 1;
            }
            currentX = 35;
            currentY += rozmiark + 1;
        }
    }
    //po nacisnieciu 
    protected void Liczby(int i, int j, Graphics g, int currentX, int currentY) {
        if (odkryte[i][j]) {
            if (tablica[i][j] != 0) {
                if (tablica[i][j] == 9) {
                    drawBomb(g, currentX + 2, currentY + 2, rozmiark - 4, rozmiark - 4);
                } else {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Arial", Font.PLAIN, 16));
                    g.drawString(String.valueOf(tablica[i][j]), currentX + 12, currentY + 20);
                }
            }
        }
    }
    //obrazek bomby
    private void drawBomb(Graphics g, int x, int y, int width, int height) {
        try {
            Image image = ImageIO.read(new File("C:\\Users\\jessi\\OneDrive\\Pulpit\\Saper\\Saper\\Bomba-min.jpg"));
            g.drawImage(image, x, y, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void Wyswietlanie0(int i, int j) {
    if (i >= 0 && i < 20 && j >= 0 && j < 20 && !odkryte[i][j]) {
        if (tablica[i][j] == 0) {
            // Odkryj sąsiednie pola rekurencyjnie
            odkryte[i][j] = true;
            Wyswietlanie0(i, j + 1);
            Wyswietlanie0(i, j - 1);
            Wyswietlanie0(i - 1, j);
            Wyswietlanie0(i + 1, j);
            Wyswietlanie0(i + 1, j + 1);
            Wyswietlanie0(i + 1, j - 1);
            Wyswietlanie0(i - 1, j + 1);
            Wyswietlanie0(i - 1, j - 1);
        } else {
            odkryte[i][j] = true;

            if(tablica[i][j]==9){
                Stop();
            }
        }
    }
    int suma = 0;
    for (int s = 0; s < 20; s++) {
        for (int k = 0; k < 20; k++) {
            if (odkryte[s][k]) {
                suma++;
            }
        }
    }
    if (suma == (20 * 20) - iloscBomb()) {
        Win();
    }
}
private int iloscBomb() {
    int iloscBomb = 0;
    for (int s = 0; s < 20; s++) {
        for (int k = 0; k < 20; k++) {
            if (tablica[s][k] == 9) {
                iloscBomb++;
            }
        }
    }
    return iloscBomb;
}
    private void Stop() {
        
        add(gameOver);
        for(int s=0;s<20;s++){
            for(int k=0;k<20;k++){
                if(tablica[s][k]==9){
                    odkryte[s][k]=true;
                }
                
            }
        }
        repaint();
    }
    private void Win() {
        
        add(win);
        repaint();
    }
}    
