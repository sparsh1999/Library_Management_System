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

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IssueBook extends JFrame {

	private PreparedStatement ps;
	private ResultSet rs;
	private JPanel contentPane;
	private JTextField bid;
	private JTextField bname;
	private JTextField bed;
	private JTextField bpub;
	private JTextField bpri;
	private JTextField bpag;
	private JTextField bsid;
	private JTextField bsnam;
	private JTextField bfather;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		super("Issue Book");
		
		final Connection con = DBInfo.DBConnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 555);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "IssueBook", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 127, 80), 2), "New Book", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(128, 0, 0)));
		panel.setBounds(25, 44, 398, 312);
		contentPane.add(panel);
		
		final JLabel l1 = new JLabel("Book ID");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l1.setBounds(24, 38, 68, 24);
		panel.add(l1);
		
		bid = new JTextField();
		bid.setColumns(10);
		bid.setBounds(114, 40, 143, 22);
		panel.add(bid);
		
		final JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l2.setBounds(24, 78, 68, 24);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Edition");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l3.setBounds(24, 115, 68, 24);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Publisher");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l4.setBounds(24, 156, 68, 24);
		panel.add(l4);
		
		JLabel l5 = new JLabel("Price");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l5.setBounds(24, 200, 68, 24);
		panel.add(l5);
		
		final JLabel l6 = new JLabel("Pages");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l6.setBounds(24, 244, 68, 24);
		panel.add(l6);
		
		 bname = new JTextField();
		bname.setColumns(10);
		bname.setBounds(114, 80, 143, 22);
		panel.add(bname);
		
		bed = new JTextField();
		bed.setColumns(10);
		bed.setBounds(114, 117, 143, 22);
		panel.add(bed);
		
		bpub = new JTextField();
		bpub.setColumns(10);
		bpub.setBounds(114, 158, 143, 22);
		panel.add(bpub);
		
		bpri = new JTextField();
		bpri.setColumns(10);
		bpri.setBounds(114, 202, 143, 22);
		panel.add(bpri);
		
		bpag = new JTextField();
		bpag.setColumns(10);
		bpag.setBounds(114, 246, 143, 22);
		panel.add(bpag);
		
		JButton SearchB = new JButton("Search");
		SearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String bid1 = bid.getText();
				if (!bid1.trim().isEmpty())
				{
					int bid2 = Integer.valueOf(bid1);
					String query = "select * from bookdetails where book_id = "+bid2;
					
					try {
						ps = con.prepareStatement(query);
						rs = ps.executeQuery();
						rs.next();
						bname.setText(rs.getString("name"));
						bpag.setText(String.valueOf(rs.getInt("pages")));
						bpri.setText(String.valueOf(rs.getFloat("edition")));
						bpub.setText(rs.getString("publisher"));
						bed.setText(String.valueOf(rs.getInt("edition")));
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "No Book is registered with this id");
						e.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter the book id");
				}
			}
		});
		SearchB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("search.png")));
		SearchB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchB.setBounds(289, 38, 97, 25);
		panel.add(SearchB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255), 2), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(0, 206, 209)));
		panel_1.setBounds(489, 44, 427, 312);
		contentPane.add(panel_1);
		
		JLabel ls1 = new JLabel("Student ID");
		ls1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls1.setBounds(27, 38, 74, 23);
		panel_1.add(ls1);
		
		JLabel ls2 = new JLabel("Name");
		ls2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls2.setBounds(27, 74, 74, 23);
		panel_1.add(ls2);
		
		JLabel ls3 = new JLabel("Father's Name");
		ls3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls3.setBounds(27, 110, 87, 23);
		panel_1.add(ls3);
		
		JLabel ls4 = new JLabel("Course");
		ls4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls4.setBounds(27, 148, 74, 23);
		panel_1.add(ls4);
		
		JLabel ls5 = new JLabel("Branch");
		ls5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls5.setBounds(27, 184, 74, 23);
		panel_1.add(ls5);
		
		JLabel ls6 = new JLabel("Year");
		ls6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls6.setBounds(27, 220, 74, 23);
		panel_1.add(ls6);
		
		JLabel ls7 = new JLabel("Semester");
		ls7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ls7.setBounds(27, 256, 74, 23);
		panel_1.add(ls7);
		
		bsid = new JTextField();
		bsid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bsid.setColumns(10);
		bsid.setBounds(139, 38, 136, 22);
		panel_1.add(bsid);
		
		bsnam = new JTextField();
		bsnam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bsnam.setColumns(10);
		bsnam.setBounds(139, 75, 136, 22);
		panel_1.add(bsnam);
		
		bfather = new JTextField();
		bfather.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bfather.setColumns(10);
		bfather.setBounds(139, 111, 136, 22);
		panel_1.add(bfather);
		
		final JTextField course = new JTextField();
		course.setBounds(139, 149, 136, 22);
		panel_1.add(course);
		
		final JTextField year = new JTextField();
		year.setBounds(139, 221, 136, 22);
		panel_1.add(year);
		
		final JTextField sem = new JTextField();
		sem.setBounds(139, 257, 136, 22);
		panel_1.add(sem);
		
		final JTextField bran = new JTextField();
		bran.setBounds(139, 185, 136, 22);
		panel_1.add(bran);
		
		JButton SearchS = new JButton("Search");
		SearchS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id = bsid.getText();
				if (!id.trim().isEmpty())
				{
					int id1  = Integer.valueOf(id);
					String query = "select * from studentdetail where id = "+id1;
					
					try {
						ps = con.prepareStatement(query);
						rs = ps.executeQuery();
						rs.next();
						
						bsnam.setText(rs.getString("name"));
						bfather.setText(rs.getString("father"));
						course.setText(rs.getString("course"));
						bran.setText(rs.getString("branch"));
						year.setText(String.valueOf(rs.getInt("year")));
						sem.setText(String.valueOf(rs.getInt("sem")));
						
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "No Student registered with this ID");
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter the Student Id");
				}
			}
		});
		SearchS.setIcon(new ImageIcon(getClass().getClassLoader().getResource("search.png")));
		SearchS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SearchS.setBounds(311, 37, 104, 25);
		panel_1.add(SearchS);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		button_1.setBounds(701, 443, 108, 25);
		contentPane.add(button_1);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Date Of Issue");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(512, 380, 97, 25);
		contentPane.add(lblNewLabel);
		
		final JDateChooser date = new JDateChooser();
		date.setBounds(634, 380, 136, 25);
		contentPane.add(date);
		
		JButton btnNewButton = new JButton("Issue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				java.sql.Date date1 = new Date(date.getDate().getTime());
				String Bname = bname.getText();
				String Sname = bsnam.getText();
				int Bid = Integer.valueOf(bid.getText());
				int Sid = Integer.valueOf(bsid.getText());
				if (!date1.toString().isEmpty()||!Bname.trim().isEmpty()||!Sname.trim().isEmpty())
				{
					String query = "insert into statistic(bookid,studid,bookname,studname,dateofissue) values(?,?,?,?,?)";
					try 
					{
						ps = con.prepareStatement(query);
						ps.setDate(5, date1);
						ps.setString(3,Bname);
						ps.setString(4,Sname);
						ps.setInt(1, Bid);
						ps.setInt(2, Sid);
						ps.execute();
						ps.close();
						con.close();
						
						JOptionPane.showMessageDialog(null, "Book Issued Succesfully");
						bid.setText(null);bname.setText(null);bpub.setText(null);bed.setText(null);bpri.setText(null);bpag.setText(null);
					    bsid.setText(null);bfather.setText(null);bsnam.setText(null);year.setText(null);sem.setText(null);
					    bran.setText(null);course.setText(null);
						
					}
					catch (Exception e)
					{
						System.out.print(e);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Fill All the Entries !!");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok1.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(547, 444, 108, 25);
		contentPane.add(btnNewButton);
	}
}
