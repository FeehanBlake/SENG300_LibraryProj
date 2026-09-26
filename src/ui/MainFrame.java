package ui;

import bookHandling.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    CardLayout layout = new CardLayout();
    JPanel mainPanel = new JPanel(layout);
    List<Book> books;

    MainFrame() {
        this.setTitle("Library Application");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(235,220,190));

        //Screens
        mainPanel.add(new LaunchFrame(this), "Launch");
        mainPanel.add(new MenuFrame(this), "Menu");
        mainPanel.add(new BookCatalogFrame(this), "BookCatalog");

        this.add(mainPanel);
        this.setVisible(true);
    }
    public void showScreen(String name) {
        layout.show(mainPanel, name);
    }
}
