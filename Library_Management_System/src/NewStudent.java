import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;


public class NewStudent extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField father;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewStudent frame = new NewStudent();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NewStudent() {
		super("New Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 414);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2), "New Student", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 99, 71)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 38, 74, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(27, 74, 74, 23);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(27, 110, 87, 23);
		contentPane.add(lblFathersName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(27, 148, 74, 23);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBranch.setBounds(27, 184, 74, 23);
		contentPane.add(lblBranch);
		
		JLabel lblSemester = new JLabel("Year");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemester.setBounds(27, 220, 74, 23);
		contentPane.add(lblSemester);
		
		JLabel lblYear = new JLabel("Semester");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(27, 256, 74, 23);
		contentPane.add(lblYear);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setBounds(139, 38, 136, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(139, 75, 136, 22);
		contentPane.add(name);
		
		father = new JTextField();
		father.setFont(new Font("Tahoma", Font.PLAIN, 14));
		father.setColumns(10);
		father.setBounds(139, 111, 136, 22);
		contentPane.add(father);
		
		final JComboBox course = new JComboBox();
		course.setBounds(139, 149, 136, 22);
		course.addItem("Btech");
		course.addItem("Mtech");
		course.addItem("Mbbs");
		course.addItem("BCom");
		contentPane.add(course);
		
		final JComboBox year = new JComboBox();
		year.setBounds(139, 221, 136, 22);
		year.addItem(1);year.addItem(2);year.addItem(3);year.addItem(4);
		contentPane.add(year);
		
		final JComboBox sem = new JComboBox();
		sem.setBounds(139, 257, 136, 22);
		sem.addItem(1);sem.addItem(2);sem.addItem(3);sem.addItem(4);sem.addItem(5);sem.addItem(6);sem.addItem(7);sem.addItem(8);
		contentPane.add(sem);
		
		final JComboBox branch = new JComboBox();
		branch.setBounds(139, 185, 136, 22);
		branch.addItem("CSE");
		branch.addItem("MECH");
		branch.addItem("CIVIL");
		branch.addItem("ECE");
		contentPane.add(branch);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name1 = name.getText();
				String id1 = id.getText();
				String father1 = father.getText();
				String branch1 =  (String) branch.getSelectedItem();
				int year1 =    (int) year.getSelectedItem();
				int sem1 = (int) sem.getSelectedItem();
				String course1 =  (String) course.getSelectedItem();
				
				if (!name1.trim().isEmpty()||!id1.trim().isEmpty()||!father1.trim().isEmpty())
				{
					Connection con = DBInfo.DBConnect();
					
//					int year2 = Integer.valueOf(year1);
//					int sem2 = Integer.valueOf(sem1);
					int id2 = Integer.valueOf(id1);
					String query = "insert into studentdetail(id,name,father,course,branch,year,sem) values(?,?,?,?,?,?,?)";
					
					try {
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(2, name1);
						ps.setString(3, father1);
					    ps.setInt(1, id2);
					    ps.setString(4, course1);
					    ps.setString(5, branch1);
					    ps.setInt(6, year1);
					    ps.setInt(7, sem1);
					    
					    ps.execute();
					    ps.close();
					    con.close();
					    
					    JOptionPane.showMessageDialog(null,"Student Registered Successfully");
					    name.setText(null);  id.setText(null);  father.setText(null);
					    
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please fill all the entries");
				}
			}
		});
		btnRegister.setIcon(new ImageIcon(getClass().getClassLoader().getResource("user.png")));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(71, 309, 101, 25);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(209, 309, 97, 25);
		contentPane.add(btnBack);
		
		
	}
}
