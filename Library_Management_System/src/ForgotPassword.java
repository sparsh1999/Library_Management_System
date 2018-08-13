import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.sun.javafx.util.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ForgotPassword extends JFrame {
	private PreparedStatement ps;
	private ResultSet res;
	private JPanel contentPane;
	private JTextField username;
	private JTextField name;
	private JTextField secq;
	private JTextField answer;
	private JTextField pass;
	private static Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
					frame.setVisible(true);
//					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPassword() {
		super("Forgot Password");
		con = DBInfo.DBConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 100,100,499, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,25), new Color(255, 69, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(42, 51, 76, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(42, 88, 76, 23);
		contentPane.add(lblName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question");
		lblYourSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourSecurityQuestion.setBounds(42, 127, 144, 23);
		contentPane.add(lblYourSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnswer.setBounds(42, 165, 76, 23);
		contentPane.add(lblAnswer);
		
		JLabel lblYourPassword = new JLabel("Your Password");
		lblYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourPassword.setBounds(42, 204, 108, 23);
		contentPane.add(lblYourPassword);
		
		username = new JTextField();
		username.setBounds(198, 52, 116, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(198, 89, 116, 22);
		contentPane.add(name);
		
		secq = new JTextField();
		secq.setColumns(10);
		secq.setBounds(198, 128, 116, 22);
		contentPane.add(secq);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(198, 166, 116, 22);
		contentPane.add(answer);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(198, 205, 116, 22);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String user = username.getText();
				if (user.trim()!=null)
				{
					String query = "select name,password,securityquestion from details where username = '"+user+"' ;";
					try {
						 ps = con.prepareStatement(query);
						res = ps.executeQuery();
						res.next();
						name.setText(res.getString("name"));
					//	pass.setText(res.getString("password"));
						secq.setText(res.getString("securityquestion"));
						//con.close();
						ps.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "No User registered with this Username");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter a username");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("search.gif")));
		btnNewButton.setBounds(329, 51, 105, 25);
		contentPane.add(btnNewButton);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String user = username.getText();
				if (answer.getText().trim()!=null)
				{
					String query = "select answer,password from details where username = '"+user+"' ;";
					try {
						ps = con.prepareStatement(query);
						res = ps.executeQuery();
						res.next();
						String answerget = res.getString("answer");
						if (answer.getText().equalsIgnoreCase(answerget))
						{
							pass.setText(res.getString("password"));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong Answer");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Answer");
				}
			}
		});
		btnRetrieve.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRetrieve.setIcon(new ImageIcon(getClass().getClassLoader().getResource("user.png")));
		btnRetrieve.setBounds(326, 165, 108, 25);
		contentPane.add(btnRetrieve);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
					fram1.setVisible(false);
			}
			
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBack.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		btnBack.setBounds(329, 204, 97, 25);
		contentPane.add(btnBack);
	}
}
