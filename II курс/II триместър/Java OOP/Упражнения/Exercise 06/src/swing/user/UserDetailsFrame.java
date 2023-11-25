package swing.user;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicVerticalLayoutManager;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

public class UserDetailsFrame extends JFrame {
    private String firstName;
    private String fullName;
    private String category;
    private JTextField firstNameField;
    private JTextField fullNameField;
    private JTextField categoryField;

    public UserDetailsFrame(){
        this(null, null, null);
    }
    public UserDetailsFrame(String firstName, String fullName, String category){
        this.firstName =firstName;
        this.fullName = fullName;
        this.category = category;
        init();
    }

    private void init() {
        setSize(400,400);

        firstNameField = new JTextField(firstName);
        firstNameField.setSize(100,30);
        firstNameField.setBorder(new MetalBorders.TextFieldBorder());
        fullNameField = new JTextField(fullName);
        fullNameField.setSize(110,30);
        fullNameField.setBorder(new MetalBorders.TextFieldBorder());
        categoryField = new JTextField(category);
        categoryField.setBorder(new MetalBorders.TextFieldBorder());
        categoryField.setSize(120,30);
        BorderLayout manager = new BorderLayout();
        manager.layoutContainer(this);
        manager.addLayoutComponent("Center", firstNameField);
        manager.addLayoutComponent("Center", fullNameField);
        manager.addLayoutComponent("Center", categoryField);
        setLayout(manager);
    }
}
