import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Cursor;


public class Welcome extends JFrame implements Runnable{

	private JPanel contentPane;
	private  Thread th ;
	 static JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		super("Welcome");
		th = new Thread((Runnable)this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 401);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("     @ LM System 1.1");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 23, 329, 72);
		contentPane.add(lblNewLabel);
		
		 progressBar = new JProgressBar();
		 progressBar.setForeground(new Color(0, 255, 0));
		 progressBar.setStringPainted(true);
		 progressBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		progressBar.setBounds(87, 108, 186, 26);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("book_pages_turning.gif")));
		lblNewLabel_1.setBounds(97, 158, 202, 167);
		contentPane.add(lblNewLabel_1);
		
		th.start();
	}
	@Override
	public void run() 
	{
		try
		{
			for (int i =0;i<=100;i++)
			{
				int v = progressBar.getValue();
				
			    int m = progressBar.getMaximum();
			    if (v<m)
			    {
			    	progressBar.setValue(v+1);
			    }
			    else
			    {
			    	setVisible(false);
			    	Home home = new Home();
			    	home.setVisible(true);
			    	
			    	break;
			    }
			    Thread.sleep(20);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
