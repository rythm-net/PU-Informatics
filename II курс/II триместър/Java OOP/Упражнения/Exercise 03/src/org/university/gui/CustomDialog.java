package org.university.gui;

import org.university.enums.DialogType;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CustomDialog extends JDialog implements ActionListener, PropertyChangeListener {

    private String typedText;
    private JTextField textField;
    private JOptionPane optionPane;

    private String okLabel = "Ok";
    private String cancelLabel = "Cancel";

    private PersonDataGUI parentGui;

    private DialogType type;

    public CustomDialog(String text, PersonDataGUI parent, DialogType type) {
        setTitle("Избор на сортиране");

        this.parentGui = parent;
        this.textField = new JTextField(2);
        this.type = type;

        Object[] array = {text, textField};
        Object[] options = {okLabel, cancelLabel};

        optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);

        setContentPane(optionPane);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                optionPane.setValue(JOptionPane.CLOSED_OPTION);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                textField.requestFocusInWindow();
            }
        });

        textField.addActionListener(this);

        optionPane.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();

        if (isVisible() && (evt.getSource() == optionPane)
            && (JOptionPane.VALUE_PROPERTY.equals(propertyName) ||
                JOptionPane.INPUT_VALUE_PROPERTY.equals(propertyName))) {

            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                return;
            }

            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            if (value.equals(okLabel)) {

                if (textField.getText() != null && !textField.getText().trim().isEmpty()) {
                    typedText = textField.getText();
                    int  intValue = Integer.parseInt(typedText);

                    if (DialogType.SORT.equals(type) && intValue >= 1 && intValue <= 5) {
                        parentGui.sortTable(intValue, parentGui.table, PersonDataGUI.people);
                        clearAndHide();
                    } else if (DialogType.FILTER.equals(type) && (intValue >= 1 && intValue <= 3)) {
                        parentGui.filterTable(intValue, parentGui.table, PersonDataGUI.people);
                        clearAndHide();
                    } else {
                        textField.selectAll();

                        JOptionPane.showMessageDialog(CustomDialog.this,
                            "Съжаляваме, стойността: " + typedText + " не е валидна!",
                            "Грешка!!!", JOptionPane.ERROR_MESSAGE
                        );

                        typedText = null;
                        textField.requestFocusInWindow();
                    }

                } else {
                    JOptionPane.showMessageDialog(CustomDialog.this,
                        "Съжаляваме, трябва да въведете стойност!",
                        "Грешка!!!", JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                typedText = null;
                clearAndHide();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(okLabel);
    }

    private void clearAndHide() {
        textField.setText(null);
        setVisible(false);
    }
}
