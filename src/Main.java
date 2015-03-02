import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bobby Ore on 3/1/15.
 */

public class Main {

    public static void main(String[] args) {
        buildWindowAndFrames();
    }

    public static void buildWindowAndFrames() {
        JFrame frame = new JFrame();
        frame.setSize(900, 1000);
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
        final JTextField chartTitleTextField = new JTextField("", 20);
        createNewSchedulePanel.add(chartTitleTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel numberOfProfessorsLabel = new JLabel();
        numberOfProfessorsLabel.setText("Number of Professors:");
        createNewSchedulePanel.add(numberOfProfessorsLabel, c);

        c.gridx = 1;
        createNewSchedulePanel.add(numberOfProfessorsLabel);
        final JTextField numberOfProfessorsTextField = new JTextField("", 20);
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
                String numberOfProfessors = numberOfProfessorsTextField.getText();
                if(StringUtils.isBlank(chartTitle) && StringUtils.isBlank(numberOfProfessors)) {
                    JOptionPane.showMessageDialog(null, "Both fields must be filled in!", null, JOptionPane.ERROR_MESSAGE);
                } else if(StringUtils.isBlank(chartTitle)) {
                    JOptionPane.showMessageDialog(null, "Chart title must be filled in.", null, JOptionPane.ERROR_MESSAGE);
                } else if(StringUtils.isBlank(numberOfProfessors)) {
                    JOptionPane.showMessageDialog(null, "Number of Professors must be filled in", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Chart Title: " + chartTitle);
                    System.out.println("Number of Professors: " + numberOfProfessors);
                }
            }
        });
        createNewSchedulePanel.add(createButton, c);

        frame.add(tabbedPane);
        frame.show();
    }
}
