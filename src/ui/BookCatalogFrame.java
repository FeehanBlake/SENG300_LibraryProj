package ui;

import bookHandling.Book;
import algorithms.Search;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; //needed to import had bug - duh

public class BookCatalogFrame extends JPanel implements ActionListener {

    MainFrame frame;

    JLabel topBorderLabel;
    JLabel titleLabel;
    JLabel searchLabel;
    JLabel sortLabel;
    JLabel bottomBorderLabel;
    JTextField searchTextField;
    JComboBox<String> sortComboBox;
    JComboBox<String> searchComboBox;
    JTextArea catalogTextArea;
    JScrollPane catalogScrollPane;
    JButton searchButton;
    JButton sortButton;
    JButton backButton;

    public BookCatalogFrame(MainFrame frame) {
        this.frame = frame;

        this.setLayout(null);
        this.setBackground(new Color(233, 218, 189));

        //JLabels
        topBorderLabel = new JLabel("                  ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        topBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        topBorderLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        topBorderLabel.setBounds(0, 10, 800, 40);
        topBorderLabel.setForeground(new Color(100, 65, 35));

        titleLabel = new JLabel("Complete Book Catalog");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        titleLabel.setBounds(0, 55, 800, 60);
        titleLabel.setForeground(new Color(100, 65, 35));

        searchLabel = new JLabel("Search Here: ");
        searchLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        searchLabel.setBounds(50, 120, 110, 30);
        searchLabel.setForeground(new Color(100, 65, 35));

        sortLabel = new JLabel("Sort Order By: ");
        sortLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        sortLabel.setBounds(50, 160, 200, 30);
        sortLabel.setForeground(new Color(100, 65, 35));

        bottomBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        bottomBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomBorderLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        bottomBorderLabel.setBounds(0, 500, 800, 40);
        bottomBorderLabel.setForeground(new Color(100, 65, 35));

        //Search Feature
        searchTextField = new JTextField();
        searchTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        searchTextField.setBounds(160, 120, 200, 30);
        searchTextField.setBackground(new Color(233, 218, 189));
        searchTextField.setForeground(new Color(100, 65, 35));
        searchTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));

        searchComboBox = new JComboBox<>();
        searchComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        searchComboBox.setBounds(370,120,130,30);
        searchComboBox.setBackground(new Color(233, 218, 189));
        searchComboBox.setForeground(new Color(100, 65, 35));
        searchComboBox.addItem("Book ID");
        searchComboBox.addItem("ISBN");

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setFont(new Font("Serif", Font.PLAIN, 20));
        searchButton.setBounds(510,120,110,30);
        searchButton.setForeground(new Color(233, 218, 189));
        searchButton.setBackground(new Color(100, 65, 35));
        searchButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Sort Feature
        sortComboBox = new JComboBox<>();
        sortComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        sortComboBox.setBounds(180,160,320,30);
        sortComboBox.setBackground(new Color(233, 218, 189));
        sortComboBox.setForeground(new Color(100, 65, 35));
        sortComboBox.addItem("Author (ascending)");
        sortComboBox.addItem("Author (descending)");
        sortComboBox.addItem("Publication Year (ascending)");
        sortComboBox.addItem("Publication Year (descending)");

        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        sortButton.setFont(new Font("Serif", Font.PLAIN, 20));
        sortButton.setBounds(510,160,110,30);
        sortButton.setForeground(new Color(233, 218, 189));
        sortButton.setBackground(new Color(100, 65, 35));
        sortButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Catalog Display
        catalogTextArea = new JTextArea();
        catalogTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        catalogTextArea.setBackground(new Color(233, 218, 189));
        catalogTextArea.setForeground(new Color(100, 65, 35));
        catalogTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        catalogTextArea.setEditable(false);
        catalogScrollPane = new JScrollPane(catalogTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        catalogScrollPane.setBounds(50,200,700,270);

        //Return to menu button
        backButton = new JButton("❮❮ Return to Menu");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Serif", Font.PLAIN, 20));
        backButton.setBounds(0,13,200,40);
        backButton.setForeground(new Color(233, 218, 189));
        backButton.setBackground(new Color(100, 65, 35));
        backButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        this.add(topBorderLabel);
        this.add(titleLabel);
        this.add(searchLabel);
        this.add(sortLabel);
        this.add(bottomBorderLabel);
        this.add(catalogScrollPane);
        this.add(searchTextField);
        this.add(searchComboBox);
        this.add(searchButton);
        this.add(sortComboBox);
        this.add(sortButton);
        this.add(backButton);
        this.setVisible(true);

        //Calls how we are to display books in catalog text area
        displayBooks();

    }
    private void displayBooks(){
        List<Book> books = frame.getBooks();
        int i;

        catalogTextArea.setText(""); //clean slate first

        for (i =0; i < books.size(); ++i) {
            Book book = books.get(i);

            catalogTextArea.append("Title: " + book.getTitle() + "\n");
            catalogTextArea.append("Author: " + book.getAuthors() + "\n");
            catalogTextArea.append("Book ID: " + book.getBook_id() + "\n");
            catalogTextArea.append("ISBN: " + book.getIsbn() + "\n");
            catalogTextArea.append("Publication Year: " + book.getOriginal_publication_year() + "\n");
            catalogTextArea.append("Average Rating: " + book.getAverage_rating() + "\n");
            catalogTextArea.append("*****************************************\n");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            String searchText = searchTextField.getText();
            String searchAction = searchComboBox.getSelectedItem().toString();
            List<Book> books = frame.getBooks();
            Book result = null; //empty for if/when its found

            if (searchAction.equals("Book ID")){
                try {
                    int bookID = Integer.parseInt(searchText); //only as type Integer

                    //choosing search method based on datatype choice from user
                    if (frame.getDataStructureChoice().equals("ArrayList")){
                        result = Search.binarySearchBooks(books, bookID);
                    }
                    if (frame.getDataStructureChoice().equals("LinkedList")){
                        result = Search.linearSearchBooks(books, bookID);
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Book ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (searchAction.equals("ISBN")){
                //choosing search method based on datatype choice from user
                if (frame.getDataStructureChoice().equals("ArrayList")){
                    result = Search.binarySearchBooks(books, searchText);
                }
                if (frame.getDataStructureChoice().equals("LinkedList")){
                    result = Search.linearSearchBooks(books, searchText);
                }
            }
            if (result != null){
                JOptionPane.showMessageDialog(null,
                        "Title: " + result.getTitle() + "\n"
                + "Author: " + result.getAuthors() + "\n"
                + "Book ID: " + result.getBook_id() + "\n"
                + "ISBN: " + result.getIsbn() + "\n"
                + "Publication Year: " + result.getOriginal_publication_year() + "\n"
                + "Average Rating: " + result.getAverage_rating(), "Search Results", JOptionPane.INFORMATION_MESSAGE);

            }
            else {
                JOptionPane.showMessageDialog(null, "Not Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == sortButton){
            String sortAction = sortComboBox.getSelectedItem().toString();

            JOptionPane.showMessageDialog(null, "Sort Option: " + sortAction, "Sort Result: Add result", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == backButton){
            frame.showScreen("Menu");
        }
    }
}
