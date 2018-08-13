import java.awt.BorderLayout;
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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SignUp extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp()
	{
		super("Sign UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 338);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2), "Sign Up", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,25), Color.RED));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name'");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 49, 71, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(42, 85, 71, 23);
		contentPane.add(label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(42, 121, 71, 23);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Arial", Font.BOLD, 14));
		lblSecurityQuestion.setBounds(42, 157, 125, 23);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnswer.setBounds(42, 193, 71, 23);
		contentPane.add(lblAnswer);
		
		final JTextField name = new JTextField();
		name.setBounds(185, 49, 171, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		final JTextField username = new JTextField();
		username.setColumns(10);
		username.setBounds(185, 85, 171, 22);
		contentPane.add(username);
		
		final JTextField password = new JTextField();
		password.setColumns(10);
		password.setBounds(185, 121, 171, 22);
		contentPane.add(password);
		
		final JTextField answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(185, 193, 171, 22);
		contentPane.add(answer);
		
		final JComboBox quest = new JComboBox();
		quest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quest.setBounds(185, 157, 171, 22);
		quest.addItem("What is your Mother Tongue");
		quest.addItem("What is your Childhood Name");
		quest.addItem("What is your Favourite Animal");
		quest.addItem("What is your School Name");
		contentPane.add(quest);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String name1 = name.getText();
				String pass = password.getText();
				String answer1 = answer.getText();
				String username1 = username.getText();
				String question = (String) quest.getSelectedItem();
				
				//System.out.println(answer1+pass+name1+username1);
				
				if (!name1.trim().isEmpty()&&!pass.trim().isEmpty()&&!answer1.trim().isEmpty()&&!username1.trim().isEmpty())
				{
					Connection con = DBInfo.DBConnect();
					String query = "insert into details(name,username,password,securityquestion,answer) values(?,?,?,?,?)";
					
					try {
						PreparedStatement ps =  con.prepareStatement(query);
						ps.setString(1, name1);
						ps.setString(2,username1);
						ps.setString(3,pass);
						ps.setString(4, question);
						ps.setString(5,answer1 );
						
						ps.execute();
						ps.close();
						con.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"please fill all the entries");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok1.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(81, 253, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				LoginPage frame = new LoginPage();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(219, 253, 97, 25);
		contentPane.add(btnNewButton_1);
		
		
	}
}
