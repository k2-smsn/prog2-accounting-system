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
import java.util.Date;

public class DatePanel extends JPanel{
    private JSpinner dateSpinner;

    public DatePanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("Date:");

        SpinnerDateModel model = new SpinnerDateModel(
                new Date(),   // initial value
                null,         // no min
                null,         // no max
                java.util.Calendar.DAY_OF_MONTH
        );

        dateSpinner = new JSpinner(model);

        // Format date
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(editor);

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

}

