import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Statistic extends JFrame {

	private JPanel contentPane;
	private JTable issue;
	private JTable return1;
	private Connection con ;
	private ResultSet rs,rs1;
	private PreparedStatement ps,ps1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistic frame = new Statistic();
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
	public Statistic() {
		super("Statistic");
		con = DBInfo.DBConnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 571);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 99, 71), 2), "Issue Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), Color.MAGENTA));
		panel.setBounds(25, 26, 886, 215);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 43, 813, 143);
		panel.add(scrollPane);
		
		issue = new JTable();
		scrollPane.setViewportView(issue);
		issue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "Return Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("arial",Font.BOLD,20), new Color(255, 0, 0)));
		panel_1.setBounds(25, 280, 886, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 47, 811, 153);
		panel_1.add(scrollPane_1);
		
		return1 = new JTable();
		scrollPane_1.setViewportView(return1);
		
		JButton button5 = new JButton("Back");
		button5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("signup.png")));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Home frame = new Home();
				frame.setVisible(true);
				JFrame fram1 = (JFrame) contentPane.getTopLevelAncestor();
				fram1.setVisible(false);
			}
		});
		button5.setBounds(794, 249, 97, 32);
		contentPane.add(button5);
		
		issuetable();
		returntable();

	}
	
	public void issuetable()
	{
		// to update the fine 
		int fine;
		Date date;
		Calendar cal = Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		Date utilSqlDate = new Date(utilDate.getTime());
		long diff , updatedFine;
		
		try 
		{
			String fineUpdate = "select studid,bookid,dateofissue from statistic where returndate is null";
			
			ps1 = con.prepareStatement(fineUpdate);
			rs1 = ps1.executeQuery();
			while (rs1.next())
			{
//				 fine = rs.getInt("fine");
				 date = rs1.getDate("dateofissue");
				 
//				  diff = rdate.getDate().getTime() - idate.getDate().getTime();
//				 updatedFine = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				 
                 diff = utilSqlDate.getTime()-date.getTime() ;
                 updatedFine = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                 
                 if (updatedFine>15)
					{
                	 updatedFine *= 3;
					}
					else
					{
						updatedFine =0;
					}
                 
                 String updateFineInTable = "update statistic set fine = "+updatedFine+" where bookid = "+rs1.getInt("bookid")+" and studid = "+rs1.getInt("studid");
			     
                 ps = con.prepareStatement(updateFineInTable);
     			 ps.execute();
			}
			
			
			// to get the table 
			String query = "Select * from statistic where returndate is  null ";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			issue.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.print(e);
		}
	}
	public void returntable()
	{
	   try 
	  {
		String query = "Select * from statistic where returndate is not null  ";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		return1.setModel(DbUtils.resultSetToTableModel(rs));
	  }
	  catch (Exception e)
	  {
		e.printStackTrace();
		System.out.print(e);
	  }
	}
	
	
	
	
}
