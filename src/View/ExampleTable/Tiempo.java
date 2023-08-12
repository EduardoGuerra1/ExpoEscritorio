package View.ExampleTable;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tiempo extends JComboBox<String> {

    private final List<String> timeList = new ArrayList<>();

    public Tiempo() {
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        timeList.add("07:00");
        timeList.add("07:15");
        timeList.add("07:50");
        timeList.add("08:25");
        timeList.add("08:55");
        timeList.add("09:30");
        timeList.add("10:05");
        timeList.add("10:20");
        timeList.add("10:55");
        timeList.add("11:30");
        timeList.add("11:40");
        timeList.add("12:15");
        timeList.add("13:10");
        timeList.add("13:45");
        timeList.add("14:20");
        timeList.add("14:35");
        timeList.add("15:10");
        timeList.add("15:45");

        for (String time : timeList) {
            addItem(time);
        }

        setPreferredSize(new Dimension(150, getPreferredSize().height));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" Time: " + getSelectedTime());
            }
        });
    }

    public String getSelectedTime() {
        return (String) getSelectedItem();
    }
}
