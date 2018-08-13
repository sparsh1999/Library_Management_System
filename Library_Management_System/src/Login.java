import javax.swing.JPanel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login extends JPanel {
	private JTextField username;
	private JTextField password;

	/**
	 * Create the panel.
	 */
	public static void main(String[] args)
	{
		
	}
	public Login() {
		
		setBounds(0,0,370,273);
		setBorder(new TitledBorder(new LineBorder(new Color(135, 206, 250), 2), "Login", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,25), new Color(0, 0, 255)));
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(57, 78, 65, 23);
		add(lblUsername);
		
		JLabel lblPassoword = new JLabel("Password");
		lblPassoword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassoword.setBounds(57, 117, 65, 23);
		add(lblPassoword);
		
		username = new JTextField();
		username.setBounds(155, 78, 116, 22);
		add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(155, 117, 116, 22);
		add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SignUp sign = new SignUp();
				sign.setVisible(true);
				JFrame frame = (JFrame) Login.this.getTopLevelAncestor();
				frame.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(211, 163, 105, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log IN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String user = username.getText().toString();
				String pass = password.getText().toString();
				System.out.println(user+pass);
				if (!user.trim().isEmpty()&&!pass.trim().isEmpty())
				{
					try 
					{
						Connection conn = DBInfo.DBConnect();
						String query = "select * from details where username = ? and password = ?";
						PreparedStatement ps = conn.prepareStatement(query);
						ps.setString(1, user);
						ps.setString(2, pass);
						ResultSet rs = ps.executeQuery();
						rs.next();
						if (rs.getString("username").equalsIgnoreCase(user)&&rs.getString("password").equalsIgnoreCase(pass))
						{
							JFrame frame = (JFrame) Login.this.getTopLevelAncestor();
							frame.setVisible(false);
							Welcome welcome = new  Welcome();
							welcome.setVisible(true);	
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong Entries!! Please Check ");		
						}
					}
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, "Wrong Entries!! Please Check ");			
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill all the entries");
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok1.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(98, 163, 101, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Forgot Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ForgotPassword frame = new ForgotPassword();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("forgot.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(161, 206, 155, 25);
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Trouble Loggin !!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(48, 208, 116, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Signin.png")));
		lblNewLabel_1.setBounds(279, 81, 24, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("key.png")));
		lblNewLabel_2.setBounds(279, 117, 25, 20);
		add(lblNewLabel_2);
		

	}
}
