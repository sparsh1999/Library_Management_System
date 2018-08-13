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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField edition;
	private JTextField pub;
	private JTextField price;
	private JTextField page;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		super("New Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "New Book", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 69, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookId.setBounds(24, 38, 68, 24);
		contentPane.add(lblBookId);
		
		id = new JTextField();
		id.setBounds(114, 40, 143, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(24, 78, 68, 24);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdition.setBounds(24, 115, 68, 24);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPublisher.setBounds(24, 156, 68, 24);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(24, 200, 68, 24);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPages.setBounds(24, 244, 68, 24);
		contentPane.add(lblPages);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(114, 80, 143, 22);
		contentPane.add(name);
		
		edition = new JTextField();
		edition.setColumns(10);
		edition.setBounds(114, 117, 143, 22);
		contentPane.add(edition);
		
		pub = new JTextField();
		pub.setColumns(10);
		pub.setBounds(114, 158, 143, 22);
		contentPane.add(pub);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(114, 202, 143, 22);
		contentPane.add(price);
		
		page = new JTextField();
		page.setColumns(10);
		page.setBounds(114, 246, 143, 22);
		contentPane.add(page);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id1 = id.getText();
				String book1 = name.getText();
				String edi1 = edition.getText();
				String pub1 = pub.getText();
				String price1 = price.getText();
				String page1 = page.getText();
				
				if (!id1.trim().isEmpty()||!book1.trim().isEmpty()||!edi1.trim().isEmpty()||!pub1.trim().isEmpty()||!price1.trim().isEmpty()||!page1.trim().isEmpty())
				{
					int id2 = Integer.valueOf(id1);
					int edi2 = Integer.valueOf(edi1);
					int page2 = Integer.valueOf(page1);
					float price2 = Float.valueOf(price1);
					
					Connection con = DBInfo.DBConnect();
					String query = "insert into bookdetails(book_id,name,edition,publisher,price,pages) values(?,?,?,?,?,?)";
					try {
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, id2);
						ps.setString(2, book1);
						ps.setInt(3, edi2);
						ps.setString(4, pub1);
						ps.setFloat(5, price2);
						ps.setInt(6, page2);
						ps.execute();
						ps.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Book Registered Succesfully ");
						id.setText(null);name.setText(null);edition.setText(null);pub.setText(null);
						price.setText(null);price.setText(null);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Fill All The Details !!");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok1.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(62, 298, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(185, 298, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
