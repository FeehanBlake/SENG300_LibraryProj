package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setBackground(new Color(255, 220, 190));

        //JLabels
        topBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
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
        sortLabel.setBounds(50, 160, 120, 30);
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
        searchTextField.setBackground(new Color(255, 220, 190));
        searchTextField.setForeground(new Color(100, 65, 35));
        searchTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));

        searchComboBox = new JComboBox<>();
        searchComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        searchComboBox.setBounds(370,120,130,30);
        searchComboBox.setBackground(new Color(255, 220, 190));
        searchComboBox.setForeground(new Color(100, 65, 35));
        searchComboBox.addItem("Book ID");
        searchComboBox.addItem("ISBN");

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setFont(new Font("Serif", Font.PLAIN, 20));
        searchButton.setBounds(510,120,110,30);
        searchButton.setBackground(new Color(255, 220, 190));
        searchButton.setForeground(new Color(100, 65, 35));
        searchButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Sort Feature
        sortComboBox = new JComboBox<>();
        sortComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        sortComboBox.setBounds(120,160,180,30);
        sortComboBox.setBackground(new Color(255, 220, 190));
        sortComboBox.setForeground(new Color(100, 65, 35));
        sortComboBox.addItem("Author (ascending");
        sortComboBox.addItem("Author (descending)");
        sortComboBox.addItem("Publication Year (ascending)");
        sortComboBox.addItem("Publication Year (descending)");

        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        sortButton.setFont(new Font("Serif", Font.PLAIN, 20));
        sortButton.setBounds(470,160,110,30);
        sortButton.setBackground(new Color(255, 220, 190));
        sortButton.setForeground(new Color(100, 65, 35));
        sortButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Catalog Display
        catalogTextArea = new JTextArea();
        catalogTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        catalogTextArea.setBackground(new Color(255, 220, 190));
        catalogTextArea.setForeground(new Color(100, 65, 35));
        catalogTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        catalogTextArea.setEditable(false);
        catalogScrollPane = new JScrollPane(catalogTextArea);
        catalogScrollPane.setBackground(new Color(255, 220, 190));
        catalogScrollPane.setForeground(new Color(100, 65, 35));
        catalogScrollPane.setBounds(50,250,700,270);

        //Return to menu button
        backButton = new JButton("❮❮ Return to Menu");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Serif", Font.PLAIN, 20));
        backButton.setBounds(300,490,200,40);
        backButton.setBackground(new Color(255, 220, 190));
        backButton.setForeground(new Color(100, 65, 35));
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

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            String searchText = searchTextField.getText();
            String searchAction = searchComboBox.getSelectedItem().toString();

            JOptionPane.showMessageDialog(null, "Search Option: " + searchAction + "Search Text: " + searchText, "Search Result: Add result", JOptionPane.INFORMATION_MESSAGE);
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
