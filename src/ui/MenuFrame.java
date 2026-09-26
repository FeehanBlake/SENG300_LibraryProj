package ui;



import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MenuFrame extends JPanel implements ActionListener {

    MainFrame frame;

    JLabel topBorderLabel;
    JLabel titleLabel;
    JLabel menuChoiceLabel;
    JLabel topTenLabel;
    JLabel bottomBorderLabel;
    JTextArea topTenTextArea;
    JButton catalogButton;
    JButton specificsButton;
    JButton addDeleteButton;

    public MenuFrame(MainFrame frame) {
        this.frame = frame;

        this.setLayout(null);
        this.setBackground(new Color(235,220,190));

        //JLabels
        topBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        topBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        topBorderLabel.setFont(new Font("Serif", Font.BOLD, 45));
        topBorderLabel.setBounds(0, 10, 800, 40);
        topBorderLabel.setForeground(new Color(100,65,35));

        titleLabel = new JLabel("║ ║ ║ Library Menu ║ ║ ║");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 45));
        titleLabel.setBounds(0,40,800,70);
        titleLabel.setForeground(new Color(100,65,35));

        menuChoiceLabel = new JLabel("Select a Library Option");
        menuChoiceLabel.setHorizontalAlignment(JLabel.CENTER);
        menuChoiceLabel.setFont(new Font("Serif", Font.BOLD, 25));
        menuChoiceLabel.setBounds(400,170,350,30);
        menuChoiceLabel.setForeground(new Color(100,65,35));

        topTenLabel = new JLabel("Top Ten Books by Rating");
        topTenLabel.setHorizontalAlignment(JLabel.CENTER);
        topTenLabel.setFont(new Font("Serif", Font.BOLD, 25));
        topTenLabel.setBounds(50,170,300,30);
        topTenLabel.setForeground(new Color(100,65,35));

        bottomBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        bottomBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomBorderLabel.setFont(new Font("Serif", Font.BOLD, 45));
        bottomBorderLabel.setBounds(0, 500, 800, 40);
        bottomBorderLabel.setForeground(new Color(100,65,35));

        //Top Ten Box
        topTenTextArea = new JTextArea("Top Ten List Goes Here");
        topTenTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        topTenTextArea.setBounds(50,210,300,230);
        topTenTextArea.setBackground(new Color(235,220,190));
        topTenTextArea.setForeground(new Color(100,65,35));
        topTenTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        topTenTextArea.setEditable(false);

        //Buttons
        catalogButton = new JButton("Catalog");
        catalogButton.addActionListener(this);
        catalogButton.setFont(new Font("Serif", Font.PLAIN, 20));
        catalogButton.setBounds(450,220,250,60);
        catalogButton.setBackground(new Color(100,65,35));
        catalogButton.setForeground(new Color(235,220,190));
        catalogButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        specificsButton = new JButton("Specifics");
        specificsButton.addActionListener(this);
        specificsButton.setFont(new Font("Serif", Font.PLAIN, 20));
        specificsButton.setBounds(450,290,250,60);
        specificsButton.setBackground(new Color(100,65,35));
        specificsButton.setForeground(new Color(235,220,190));
        specificsButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        addDeleteButton = new JButton("Add/Delete Book");
        addDeleteButton.addActionListener(this);
        addDeleteButton.setFont(new Font("Serif", Font.PLAIN, 20));
        addDeleteButton.setBounds(450,360,250,60);
        addDeleteButton.setBackground(new Color(100,65,35));
        addDeleteButton.setForeground(new Color(235,220,190));
        addDeleteButton.setBorder(new BevelBorder(BevelBorder.RAISED));

        this.add(topBorderLabel);
        this.add(titleLabel);
        this.add(menuChoiceLabel);
        this.add(topTenLabel);
        this.add(bottomBorderLabel);
        this.add(topTenTextArea);
        this.add(catalogButton);
        this.add(specificsButton);
        this.add(addDeleteButton);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == catalogButton) {
            frame.showScreen("BookCatalog");
        }
        if (e.getSource() == specificsButton) {
            frame.showScreen("BookSpecificts");
        }
        if (e.getSource() == addDeleteButton) {
            frame.showScreen("Add/Delete Book");
        }
    }
}
