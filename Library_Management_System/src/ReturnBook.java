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
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.mysql.cj.util.StringUtils;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class ReturnBook extends JFrame {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JPanel contentPane;
	private JTextField bid;
	private JTextField sid;
	private JTextField sname;
	private JTextField bname;
	private JTextField fine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		super("Return Book");
		con = DBInfo.DBConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 437);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0), 2), "Return Book", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 20, 147)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 37, 68, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(32, 78, 68, 22);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentName.setBounds(32, 122, 95, 22);
		contentPane.add(lblStudentName);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookName.setBounds(32, 163, 95, 22);
		contentPane.add(lblBookName);
		
		final JDateChooser idate = new JDateChooser();
		idate.setBounds(140, 206, 133, 22);
		contentPane.add(idate);
		
		bid = new JTextField();
		bid.setBounds(140, 38, 133, 22);
		contentPane.add(bid);
		bid.setColumns(10);
		
		sid = new JTextField();
		sid.setColumns(10);
		sid.setBounds(140, 79, 133, 22);
		contentPane.add(sid);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(139, 123, 134, 22);
		contentPane.add(sname);
		
		bname = new JTextField();
		bname.setColumns(10);
		bname.setBounds(139, 164, 134, 22);
		contentPane.add(bname);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String bid1 = bid.getText();
				if (!bid1.trim().isEmpty())
				{
					int bid2 = Integer.valueOf(bid1);
					String query = "select * from statistic where bookid = "+bid2;
					
					try {
						ps = con.prepareStatement(query);
						rs = ps.executeQuery();
						rs.next();
						
						sid.setText(String.valueOf(rs.getInt("studid")));
						sname.setText(rs.getString("studname"));
						bname.setText(rs.getString("bookname"));
						idate.setDate(rs.getDate("dateofissue"));
						ps.execute();
						rs.close();
						ps.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Book Not Found");
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill the Entries");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("search.png")));
		btnNewButton.setBounds(285, 37, 95, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(32, 206, 84, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnDate.setBounds(32, 250, 84, 22);
		contentPane.add(lblReturnDate);
		
		final JDateChooser rdate = new JDateChooser();
		rdate.setBounds(140, 250, 133, 22);
		contentPane.add(rdate);
		
		JButton bfine = new JButton("Fine");
		bfine.setIcon(null);
		bfine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String rdate3 = String.valueOf(rdate.getDate());
				//System.out.println(rdate3);
				if (!rdate3.trim().isEmpty()&&rdate.getDate()!=null)
				{
					long diff = rdate.getDate().getTime() - idate.getDate().getTime();
					long fine1 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					//System.out.println(fine1);
					if (fine1>15)
					{
						fine1 = (fine1-15)* 3;
					}
					else
					{
						fine1 =0;
					}
					fine.setText(String.valueOf(fine1));
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter a return date to calculate fine");
				}
			}
		});
		bfine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bfine.setBounds(285, 206, 95, 22);
		contentPane.add(bfine);
		
		JButton lblReturn = new JButton("Return");
		lblReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String bid1 = bid.getText();
				if (!bid1.trim().isEmpty())
				{
					int bid2 = Integer.valueOf(bid1);
					int fine1 = Integer.valueOf(fine.getText());
					
					if (fine1>15)
					{
						fine1 = (fine1-15)*3;
					}
					else
					{
						fine1 =0;
					}
					
					Date date1 = new Date(rdate.getDate().getTime());
					System.out.println(date1);
					String query = "update statistic set returndate = '"+date1+"' ,fine = "+fine1+" where bookid = "+bid2;
					try {
						ps = con.prepareStatement(query);
						 ps.execute();
						
						 rs.close();
						 ps.close();
						 con.close();
						 JOptionPane.showMessageDialog(null, "Book Succesfully Returned");
						 bid.setText(null);sid.setText(null);
						 bname.setText(null);sname.setText(null);
						 idate.setDate(null);rdate.setDate(null);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Fill all the entries");
				}
			}
		});
		lblReturn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("save.png")));
		lblReturn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReturn.setBounds(84, 315, 107, 35);
		contentPane.add(lblReturn);
		
		JButton lblBack = new JButton("Back");
		lblBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		lblBack.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBack.setBounds(214, 315, 107, 35);
		contentPane.add(lblBack);
		
		fine = new JTextField();
		fine.setColumns(10);
		fine.setBounds(295, 251, 50, 22);
		contentPane.add(fine);
		
		JLabel lblNewLabel_2 = new JLabel("RS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(356, 256, 24, 16);
		contentPane.add(lblNewLabel_2);
	}
}
