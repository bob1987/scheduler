import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 2nd level design
 */

public class Main {

    public static void main(String[] args)  throws IOException{

        buildWindowAndFrames();

    }

    public static void buildWindowAndFrames() throws IOException {



        JFrame frame = new JFrame();
        frame.setSize(1600, 1000);
        frame.setTitle("Professor Scheduling App");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel viewExistingPanel = new JPanel();
        tabbedPane.addTab("View Current", null, viewExistingPanel, null);

        JPanel createNewSchedulePanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.gridx = 0;
        c.gridy = 0;
        JLabel chartTitleLabel = new JLabel();
        chartTitleLabel.setText("Chart Title:");
        createNewSchedulePanel.add(chartTitleLabel, c);

        c.gridx = 1;
        final JTextField chartTitleTextField = new JTextField("", 30);
        createNewSchedulePanel.add(chartTitleTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel numberOfProfessorsLabel = new JLabel();
        numberOfProfessorsLabel.setText("Number of Professors:");
        createNewSchedulePanel.add(numberOfProfessorsLabel, c);

        c.gridx = 1;
        createNewSchedulePanel.add(numberOfProfessorsLabel);
        final JTextField numberOfProfessorsTextField = new JTextField("", 30);
        createNewSchedulePanel.add(numberOfProfessorsTextField, c);
        createNewSchedulePanel.add(numberOfProfessorsTextField);
        tabbedPane.addTab("Create New Schedule", null, createNewSchedulePanel, null);

        JButton createButton = new JButton();
        createButton.setText("Create Schedule");
        c.gridy = 2;
        c.gridx = 0;
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String chartTitle = chartTitleTextField.getText();
                //out.println(chartTitle);
                String numberOfProfessors = numberOfProfessorsTextField.getText();
                // out.println(numberOfProfessors);
                if(StringUtils.isBlank(chartTitle) && StringUtils.isBlank(numberOfProfessors)) {
                    JOptionPane.showMessageDialog(null, "Both fields must be filled in!", null, JOptionPane.ERROR_MESSAGE);
                } else if(StringUtils.isBlank(chartTitle)) {
                    JOptionPane.showMessageDialog(null, "Chart title must be filled in!", null, JOptionPane.ERROR_MESSAGE);
                } else if(StringUtils.isBlank(numberOfProfessors)) {
                    JOptionPane.showMessageDialog(null, "Number of Professors must be filled in!", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    Integer professors;
                    try {
                        professors = Integer.parseInt(numberOfProfessors);
                        createNewSchedule(chartTitle, professors);
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Please enter a number!", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });
        createNewSchedulePanel.add(createButton, c);

        frame.add(tabbedPane);
        frame.setVisible(true);

    }

    public static void createNewSchedule(String chartTitle, int numberOfProfessors) throws IOException {
        JFrame frame = new JFrame();
        frame.setSize(1600, 1000);
        frame.setTitle(chartTitle);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel addDataPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 20;
        JLabel professor = new JLabel("Professor Name");
        addDataPanel.add(professor, c);


        c.gridx = 1;
        JLabel monday = new JLabel("Monday Office Hours");
        addDataPanel.add(monday, c);
        //monday.setSize(100,300);

        c.gridx = 2;
        JLabel tuesday = new JLabel("Tuesday Office Hours");
        addDataPanel.add(tuesday, c);


        c.gridx = 3;
        JLabel wednesday = new JLabel("Wednesday Office Hours");
        addDataPanel.add(wednesday, c);


        c.gridx = 4;
        JLabel thursday = new JLabel("Thursday Office Hours");
        addDataPanel.add(thursday, c);


        c.gridx = 5;
        JLabel friday = new JLabel("Friday Office Hours");
        addDataPanel.add(friday, c);


        c.gridx = 6;
        JLabel saturday = new JLabel("Saturday Office Hours");
        addDataPanel.add(saturday, c);


        c.gridx = 7;
        JLabel roomNum = new JLabel("Room Number");
        addDataPanel.add(roomNum, c);

        c.gridx = 8;
        JLabel phoneNum = new JLabel("Phone Number");
        addDataPanel.add(phoneNum, c);

        c.gridx = 9;
        JLabel eMail = new JLabel("E-Mail Address");
        addDataPanel.add(eMail, c);


        final Collection<JTextField> textFields = new ArrayList<JTextField>();
        c.gridy = 1;
        for(int i = 1 ; i<=numberOfProfessors ; i++) {
            for(int j = 1 ; j<=10 ; j++) {
                c.gridx = j-1;
                JTextField textField = new JTextField("", 30);
                addDataPanel.add(textField, c);
                textFields.add(textField);
                System.out.println("textField: " + textField);
                System.out.println("eMail: " + eMail);

                //textField.setSize(75, 45);
            }
            c.gridy += 1;
        }

        c.gridx = 4;
        c.gridy = 40;

        JButton save = new JButton("Save");
        addDataPanel.add(save, c);
        String fileLocation = JOptionPane.showInputDialog ("Enter a file location u want to save the file as" +  "Ex) c:\\TESTTTTT\\Project3.txt" );
        java.io.File file = new java.io.File(fileLocation);
        java.io.PrintWriter out = new PrintWriter(file);
        out.println("CHART TITLE:");
        out.println(chartTitle);
        out.println("Number of Professors:");
        out.println(numberOfProfessors);
        out.println("Got the file to save... ");
        out.println(professor);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<JTextField> readMe = textFields;
                for(JTextField textField : readMe) {
                    System.out.println(textField.getText());
                }
            }
        });

        out.close();
        frame.add(addDataPanel);
        frame.setVisible(true);
    }
}

