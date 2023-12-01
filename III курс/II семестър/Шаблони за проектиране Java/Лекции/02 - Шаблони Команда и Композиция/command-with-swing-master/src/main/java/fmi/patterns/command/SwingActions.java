package fmi.patterns.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Демонстрира шаблона Команда, чрез използване на Swing Actions
 */
public class SwingActions extends JFrame {
	public SwingActions() {
		super("Swing Actions");
		setupGUI();
	}

	private void setupGUI() {
		JToolBar tb;
		JMenu fileMenu;
		JTextArea ta;
		Action openAction;
		Action closeAction;

		// Създава toolbar и меню.
		tb = new JToolBar();
		fileMenu = new JMenu("Файл");
		
		// Създава текстовата област, в която ще се извежда резултата.
		ta = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(ta);

		// Подреждане на съдържанието.
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(400, 150));
		contentPane.add(tb, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		setContentPane(contentPane); 
		
		// Настройка на менюто.
		JMenuBar mb = new JMenuBar();
		mb.add(fileMenu);
		setJMenuBar(mb);

		// Създаване на действие за "Отвори".
		ImageIcon openIcon = new ImageIcon("open.png");
		openAction = new AbstractAction("Отвори", openIcon) {
			public void actionPerformed(ActionEvent e) {
				ta.append("Действието 'Отвори' от " + e.getActionCommand() + "\n");
			}
		};

		// Използване на action за добавяне на бутон в toolbar-a.
		JButton openButton = tb.add(openAction);
		openButton.setText("");
		openButton.setActionCommand("Бутон Отвори");
		openButton.setToolTipText("Това е бутона за отваряне");

		// Използване на action за добавяне на опция във менюто Файл.
		JMenuItem openMenuItem = fileMenu.add(openAction);
		//openMenuItem.setIcon(null);
		openMenuItem.setActionCommand("Опция в менюто за отваряне");

		// По подобен начин се създава action за "Затваряне" и 
		// се използва за добавяне на бутон в toolbar-a и опция в менюто.
		// Кодът е оставен за самостоятелна работа.
	}

	public static void main(String[] args) {
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

		SwingActions frame = new SwingActions();
		frame.pack();
		frame.setVisible(true);
	}
}