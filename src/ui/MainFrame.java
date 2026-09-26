package ui;

import bookHandling.Book;
import io.ImportCSV;
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
    String dataStructureChoice;
    MenuFrame menuFrame;

    MainFrame() {
        this.setTitle("Library Application");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(235,220,190));

        //Screens
        mainPanel.add(new LaunchFrame(this), "Launch");
        //mainPanel.add(new MenuFrame(this), "Menu"); check refactor on next line - needed to change so it creates frame after csv loads
        menuFrame = new MenuFrame(this);
        mainPanel.add(menuFrame, "Menu");


        this.add(mainPanel);
        this.setVisible(true);
    }
    public void showScreen(String name) {
        layout.show(mainPanel, name);
    }
    public void choiceDataStructure(String structure) {
        if (structure.equals("ArrayList")) {
            books = new ArrayList<>();
            dataStructureChoice = "ArrayList";
        }
        else if (structure.equals("LinkedList")) {
            books = new LinkedList<>();
            dataStructureChoice = "LinkedList";
        }

        ImportCSV.readFile("books.csv", books);
        menuFrame.displayTopTenBooks(); //reference comment in line 32

        mainPanel.add(new BookCatalogFrame(this), "BookCatalog"); //Needed to move here after choice
        layout.show(mainPanel, "Menu"); //Needed this as well to show menu after data has loaded
    }
    public List<Book> getBooks() {
        return books;
    }
    public String getDataStructureChoice() {
        return dataStructureChoice; //allowing the rest of the system to base search from this choice
    }
}
