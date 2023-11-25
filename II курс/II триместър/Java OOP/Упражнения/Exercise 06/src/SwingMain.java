import swing.user.UserDetailsFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Arrays;

public class SwingMain {
    private static String[] columnNames = {"Name", "Full Name", "User type"};

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(300, 500);
        //DefaultTableColumnModel columnConfig = createColumnConfig();

        String[][] users = getData();
        JTable table = createTable(users);
        JScrollPane scrollPane = new JScrollPane(table);

/*        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);*/
        jFrame.setJMenuBar(createMenu(users, table));
        jFrame.add(scrollPane);
        jFrame.setVisible(true);

    }

    private static JMenuBar createMenu(String[][] data, JTable table) {
        JButton sort = new JButton("Sort");
        sort.addActionListener(l -> {
            int selectedColumn = table.getSelectedColumn();
            int sortIndex = selectedColumn < 0 ? 0 : selectedColumn;
            Arrays.sort(data, (first, second) -> first[sortIndex].compareTo(second[sortIndex]));
            ((DefaultTableModel) table.getModel()).setDataVector(data, columnNames);
            table.repaint();
        });
        sort.setSize(100, 30);
        JMenuBar menubar = new JMenuBar();
        JButton addUser = new JButton("Add user");
        addUser.addActionListener(l->{
            new UserDetailsFrame().setVisible(true);
        });
        menubar.add(addUser);
        menubar.add(new JButton("Edit"));
        menubar.add(new JButton("Remove"));
        menubar.add(sort);
        return menubar;
    }

    private static JTable createTable(String[][] users) {

        //JTable table = new JTable(users, columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(5, 3);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.setDataVector(users, columnNames);

        JTable table = new JTable(tableModel);
        table.setBounds(30, 40, 200, 300);
        return table;
    }

    private static String[][] getData() {
        String[][] users = {{"Ivan", "Ivan Ivanov", "Student"},
                {"Ivan3", "Ivan3 Ivanov", "Student"},
                {"Ivan6", "Ivan8 Ivanov", "Student"},
                {"Ivan8", "Ivan6 Ivanov", "Professor"},
                {"Ivan1", "Ivan2 Ivanov", "Student"},
                {"Ivan2", "Ivan1 Ivanov", "Student"}};
        return users;
    }

    private static DefaultTableColumnModel createColumnConfig() {
        DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
        TableColumn nameColumn = new TableColumn();
        nameColumn.setHeaderValue("Name");
        TableColumn fullNameColumn = new TableColumn();
        fullNameColumn.setHeaderValue("Full Name");
        TableColumn userTypeColumn = new TableColumn();
        userTypeColumn.setHeaderValue("User type");
        columnModel.addColumn(nameColumn);
        columnModel.addColumn(fullNameColumn);
        columnModel.addColumn(userTypeColumn);
        return columnModel;
    }
}
