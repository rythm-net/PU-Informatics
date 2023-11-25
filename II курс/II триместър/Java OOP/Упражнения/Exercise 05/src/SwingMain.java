import javax.swing.*;

public class SwingMain {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        String[][] users = {
                {"Ivan", "Ivanov", "Student"},
                {"Peter", "Petrov", "Professor"}
        };
        String[] columnNames = {"First name", "Last name", "User type"};
        JTable userTable = new JTable(users, columnNames);
        jFrame.add(new JScrollPane(userTable));
        jFrame.setVisible(true);
    }
}
