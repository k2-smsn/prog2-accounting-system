/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datePanel;

/**
 *
 * @author k2
 */

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.Component;

public class DatePanel extends JPanel{
    private JSpinner dateSpinner;

    public DatePanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT)); //flow components to left

        JLabel label = new JLabel("Date:");
        label.setPreferredSize(new Dimension(100, 40));
        label.setFont(new Font("MV Boli", Font.PLAIN, 24));

        SpinnerDateModel model = new SpinnerDateModel(
                new Date(),   // initial value
                null,         // no min
                null,         // no max
                java.util.Calendar.DAY_OF_MONTH
        );

        dateSpinner = new JSpinner(model);
        dateSpinner.setPreferredSize(new Dimension(180, 40));
        dateSpinner.setFont(new Font("MV Boli", Font.PLAIN, 24));

        // Format date
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(editor);
        
        //Font setting
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(label, dateSpinner));
        setFont(c);

        add(label);
        add(dateSpinner);
    }

    // Get date as LocalDate 
    public LocalDate getDate() {
        Date date = (Date) dateSpinner.getValue();
        return date.toInstant()
                   .atZone(ZoneId.systemDefault())
                   .toLocalDate();
    }
    
    public void setFont(ArrayList<Component> comps) { //set font function
        for (int i = 0; i < comps.size(); i++) {
            comps.get(i).setFont(new Font("MV Boli", Font.PLAIN, 24));
        }
    }

}

