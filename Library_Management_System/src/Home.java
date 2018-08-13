import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 697);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mntmNewMenuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("close.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About");
		mntmNewMenuItem_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("user.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 160, 122));
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("library.png")));
		lblNewLabel.setBounds(25, 23, 100, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LIBRARY");
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(126, 26, 77, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel_2.setForeground(new Color(255, 69, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(126, 47, 177, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setForeground(new Color(32, 178, 170));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(492, 23, 137, 43);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2), "Operations", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 69, 0)));
		panel.setBounds(35, 115, 594, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton lblNewLabel_4 = new JButton("");
		lblNewLabel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				NewBook book = new NewBook();
				book.setVisible(true);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("book.png")));
		lblNewLabel_4.setBounds(31, 32, 135, 143);
		panel.add(lblNewLabel_4);
		
		JButton lblNewLabel_5 = new JButton("");
		lblNewLabel_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				Statistic stat = new Statistic();
				stat.setVisible(true);
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("statistics-icon.png")));
		lblNewLabel_5.setBounds(218, 32, 135, 143);
		panel.add(lblNewLabel_5);
		
		JButton lblNewLabel_6 = new JButton("");
		lblNewLabel_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				NewStudent stud = new NewStudent();
				stud.setVisible(true);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addusericon.png")));
		lblNewLabel_6.setBounds(426, 32, 135, 143);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewBook.setBounds(62, 175, 88, 27);
		panel.add(lblNewBook);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblStatistics.setBounds(242, 175, 88, 27);
		panel.add(lblStatistics);
		
		JLabel lblNewStudent = new JLabel("New Student");
		lblNewStudent.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewStudent.setBounds(451, 175, 88, 27);
		panel.add(lblNewStudent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 2), "Operations", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), Color.MAGENTA));
		panel_1.setBounds(35, 359, 594, 227);
		contentPane.add(panel_1);
		
		JButton label = new JButton("");
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				IssueBook issue = new IssueBook();
				issue.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("issue.png")));
		label.setBounds(31, 32, 135, 138);
		panel_1.add(label);
		
		JButton label_1 = new JButton("");
		label_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				ReturnBook return1 = new ReturnBook();
				return1.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("return.png")));
		label_1.setBounds(216, 32, 135, 138);
		panel_1.add(label_1);
		
		JButton label_2 = new JButton("");
		label_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				About about = new About();
				about.setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("devloper.png")));
		label_2.setBounds(426, 32, 135, 138);
		panel_1.add(label_2);
		
		JLabel lblIssue = new JLabel("Issue");
		lblIssue.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblIssue.setBounds(80, 170, 88, 27);
		panel_1.add(lblIssue);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblReturn.setBounds(263, 170, 88, 27);
		panel_1.add(lblReturn);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAbout.setBounds(472, 170, 57, 27);
		panel_1.add(lblAbout);
	}
}
