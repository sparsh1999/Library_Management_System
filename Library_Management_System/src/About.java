import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		super("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 377);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("sparsh.jpg")));
		label.setBounds(32, 26, 200, 252);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(331, 42, 254, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Version 1.1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(402, 94, 126, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCopyrightsSel = new JLabel("Copyrights @ Self");
		lblCopyrightsSel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCopyrightsSel.setBounds(385, 126, 200, 50);
		contentPane.add(lblCopyrightsSel);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL --  SPARSHSINGHAL95@GMAIL.COM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(310, 189, 306, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton button = new JButton("Back");
		button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 14));
		button.setBounds(488, 252, 97, 25);
		contentPane.add(button);
	}
}
