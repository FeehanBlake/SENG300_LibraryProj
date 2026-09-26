package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LaunchFrame extends JPanel implements ActionListener {

    JButton button;
    JLabel launchTitleLabel;
    JLabel topBorderLabel;
    JLabel underTitleLabel;
    JLabel bottomBorderLabel;
    JCheckBox arrayListCheckBox;
    JCheckBox linkedListCheckBox;

    MainFrame frame;

    public LaunchFrame(MainFrame frame) {
        this.frame = frame;

        this.setLayout(null);
        this.setBackground(new Color(235, 220, 190));

        //JLabels
        topBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        topBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        topBorderLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        topBorderLabel.setBounds(0, 10, 800, 40);
        topBorderLabel.setForeground(new Color(100, 65, 35));

        launchTitleLabel = new JLabel("Welcome to the Library Application!");
        launchTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        launchTitleLabel.setVerticalAlignment(JLabel.CENTER);
        launchTitleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        launchTitleLabel.setBounds(0, 60, 800, 80);
        launchTitleLabel.setForeground(new Color(100, 65, 35));

        underTitleLabel = new JLabel("***Please select the data structure you would like to use***");
        underTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        underTitleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        underTitleLabel.setBounds(0, 160, 800, 40);
        underTitleLabel.setForeground(new Color(100, 65, 35));

        bottomBorderLabel = new JLabel("║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║ ║");
        bottomBorderLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomBorderLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        bottomBorderLabel.setBounds(0, 500, 800, 40);
        bottomBorderLabel.setForeground(new Color(100, 65, 35));

        //CheckBoxes
        arrayListCheckBox = new JCheckBox("Array List");
        arrayListCheckBox.setFont(new Font("Serif", Font.PLAIN, 22));
        arrayListCheckBox.setBounds(250, 210, 150, 40);
        arrayListCheckBox.setBackground(new Color(235, 220, 190));
        arrayListCheckBox.setForeground(new Color(100, 65, 35));

        linkedListCheckBox = new JCheckBox("LinkedList");
        linkedListCheckBox.setFont(new Font("Serif", Font.PLAIN, 22));
        linkedListCheckBox.setBounds(400, 210, 150, 40);
        linkedListCheckBox.setBackground(new Color(235, 220, 190));
        linkedListCheckBox.setForeground(new Color(100, 65, 35));

        //JButton
        button = new JButton("Enter");
        button.addActionListener(this);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setBounds(325, 280, 150, 50);
        button.setBackground(new Color(99, 64, 35));
        button.setForeground(new Color(233, 218, 189));
        button.setBorder(new BevelBorder(BevelBorder.RAISED));

        this.add(launchTitleLabel);
        this.add(topBorderLabel);
        this.add(underTitleLabel);
        this.add(bottomBorderLabel);
        this.add(arrayListCheckBox);
        this.add(linkedListCheckBox);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            // Validate and enforce checkbox
            if (arrayListCheckBox.isSelected() == linkedListCheckBox.isSelected()) {


                JOptionPane.showMessageDialog(null, "Please Select Only One Data Structure!", "Library Application",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            if (arrayListCheckBox.isSelected()) {
                frame.choiceDataStructure("ArrayList");
            }
            else {
                frame.choiceDataStructure("LinkedList");
            }

            // Continue to menu panel after validation
            frame.showScreen("Menu");
        }
    }
}
