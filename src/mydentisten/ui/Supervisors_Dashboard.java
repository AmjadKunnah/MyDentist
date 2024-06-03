package mydentisten.ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.border.LineBorder;

/**
*
* @author amjad azim
*/

/*Supervisors Dashboard frame after successful login as user type "Supervisor" */
public class Supervisors_Dashboard extends JFrame {

	
	/*Variables*/
	
	//JLabel
	private JLabel exitLbl;
	private JLabel minimizeLbl;
	private JLabel lblSupervisorsDashboard;
	private JLabel lblAmjadAzim;
	
	//JButton
	private JButton btnMainPage;
	private JButton btnPatientPage;
	private JButton btnAppointmentPage;
	private JButton btnStaffPage;
	private JButton btnInvoicePage;
	private JButton btnRevenues;
	private JButton btnLogout;
	private JButton btnDeveloper;
	
	//JDesktopPane
	private JDesktopPane desktopPane;
	
	//String
	public String supervisorName, supervisorLast_Name, supervisorUsername, supervisorUser_Type;
	
	/*End of Variables*/

	
	
	/*Panels*/
	private JPanel contentPane;
	private JPanel MenuPanel;
	private JPanel Headerpanel;
	private JPanel panelExit;
	private JPanel panelMinimize;
	/*End Of Panels*/

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					 /* setting UI theme and LookAndFeel of the application */
					try {
					    UIManager.setLookAndFeel( new FlatLightLaf() );
					} catch( UnsupportedLookAndFeelException ex ) {
			            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                    } 
					
			        /* Create and display the form */
					Supervisors_Dashboard frame = new Supervisors_Dashboard();
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
	public Supervisors_Dashboard() {
		addComponentListener(new ComponentAdapter() {
			
			/* When Supervisors Dashboard Opened when a supervisor login  */

			@Override
			public void componentShown(ComponentEvent e) {
		
					/*Supervisors Homepage Object*/
					Supervisors_Homepage supervisordHomepage = new Supervisors_Homepage();
					
					/*Set Supervisor Name, Last Name, Username, User Type*/
					supervisordHomepage.textFieldName.setText(supervisorName);
					supervisordHomepage.textFieldLastName.setText(supervisorLast_Name);
					supervisordHomepage.textFieldUsername.setText(supervisorUsername);
					supervisordHomepage.textFieldUserType.setText(supervisorUser_Type);
					/*End of Supervisor set Name, Last Name, Username, User Type*/

					/*Clear desktopPane*/
					desktopPane.removeAll();
					/*Add Supervisors Homepage Window to desktopPane*/
					desktopPane.add(supervisordHomepage).setVisible(true);
					/*Change Home button background color to white*/
					changeButtonBackground(btnMainPage);
			
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 550);
		/*set no decoration for the frame */
		setUndecorated(true);
		/*set the frame in the center of the screen */
		setLocationRelativeTo(null);
		/*set rounded corners for the frame */
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		/* frame title */		
		setTitle("Supervisors Dashboard");
		/*frame icon*/
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/MyDentist2.png"));
			Image image2 = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			setIconImage(image2);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		/*End of frame icon*/

		/*Content Panel*/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*End of Content Panel*/

		/*Header Panel */
		Headerpanel = new JPanel();
		Headerpanel.setLayout(null);
		Headerpanel.setBackground(new Color(216, 191, 216));
		Headerpanel.setBounds(0, 0, 856, 28);
		contentPane.add(Headerpanel);
		/*End of Header Panel */


		/*Header Panel Title */		
		lblSupervisorsDashboard = new JLabel("Supervisors Dashboard - Home Page");
		lblSupervisorsDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorsDashboard.setForeground(Color.BLACK);
		lblSupervisorsDashboard.setFont(new Font("Kartika", Font.BOLD, 24));
		lblSupervisorsDashboard.setBounds(10, 0, 770, 26);
		Headerpanel.add(lblSupervisorsDashboard);
		/*End of Header Panel Title */		
		
		
		/*Minimize Panel*/
		panelMinimize = new JPanel();
		panelMinimize.addMouseListener(new MouseAdapter() {
			
			/*Minimize Window when Mouse clicked*/
			@Override
			public void mouseClicked(MouseEvent e) {
				minimizeLblMouseClicked(e);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeLbl.setForeground(Color.BLACK);	
				panelMinimize.setBackground(new Color(216, 191, 216));
				panelMinimize.setBorder(new LineBorder(new Color(216, 191, 216), 1, true));
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeLbl.setForeground(Color.WHITE);	
				panelMinimize.setBackground(new Color(102, 51, 153));
				panelMinimize.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));

			}
		});
		panelMinimize.setBorder(new LineBorder(new Color(216, 191, 216), 1, true));
		panelMinimize.setBackground(new Color(216, 191, 216));
		panelMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMinimize.setBounds(787, 1, 25, 25);
		Headerpanel.add(panelMinimize);
		panelMinimize.setLayout(null);
		/*End of Minimize Panel*/
		
		
		/*- JLabel */		
		minimizeLbl = new JLabel();
		minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLbl.setBounds(0, 0, 25, 25);
		panelMinimize.add(minimizeLbl);
		minimizeLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeLbl.setText("-");
		minimizeLbl.setFont(new Font("Kartika", Font.BOLD, 36));
		/*End of - JLabel */		
		
		
		/*Exit Panel*/
		panelExit = new JPanel();
		panelExit.addMouseListener(new MouseAdapter() {
			
			/*Close window when mouse clicked */
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Confirm Close Application 
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close the application?","Confirm Application Closing",JOptionPane.YES_NO_OPTION);
				
				if(a == 0)
				{
					JOptionPane.showMessageDialog(null, "Thank you "+supervisorName+" "+supervisorLast_Name+","+ "\n See you next time.");
					exitLblMouseClicked(e);
				}			
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				exitLbl.setForeground(new Color(204, 0, 0));
				panelExit.setBackground(new Color(216, 191, 216));
				panelExit.setBorder(new LineBorder(new Color(216, 191, 216), 1, true));

			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				exitLbl.setForeground(Color.WHITE);
				panelExit.setBackground(new Color(204, 0, 0));
				panelExit.setBorder(new LineBorder(new Color(204, 0, 0), 1, true));

			}
		
		});
		panelExit.setBorder(new LineBorder(new Color(216, 191, 216), 1, true));
		panelExit.setBackground(new Color(216, 191, 216));
		panelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelExit.setBounds(821, 1, 25, 25);
		Headerpanel.add(panelExit);
		panelExit.setLayout(null);
		/*End of Exit Panel*/
		

		/*X JLabel */		
		exitLbl = new JLabel();
		exitLbl.setHorizontalAlignment(SwingConstants.CENTER);
		exitLbl.setBounds(0, 0, 25, 25);
		panelExit.add(exitLbl);
		exitLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLbl.setText("X");
		exitLbl.setForeground(new Color(204, 0, 0));
		exitLbl.setFont(new Font("Kartika", Font.BOLD, 18));
		/*End of X JLabel */		


		/*Menu Panel*/		
		MenuPanel = new JPanel();
		MenuPanel.setLayout(null);
		MenuPanel.setBackground(new Color(102, 51, 153));
		MenuPanel.setBounds(0, 28, 206, 522);
		contentPane.add(MenuPanel);
		/*End of Menu Panel*/
		

		/*Main Page Button*/				
		btnMainPage = new JButton("Home");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Supervisors Homepage Object*/
				Supervisors_Homepage supervisordHomepage = new Supervisors_Homepage();
			
				/*Set Supervisor Name, Last Name, Username, User Type*/
				supervisordHomepage.textFieldName.setText(supervisorName);
				supervisordHomepage.textFieldLastName.setText(supervisorLast_Name);
				supervisordHomepage.textFieldUsername.setText(supervisorUsername);
				supervisordHomepage.textFieldUserType.setText(supervisorUser_Type);
				/*End of Supervisor set Name, Last Name, Username, User Type*/

				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Homepage Window to desktopPane*/
				desktopPane.add(supervisordHomepage).setVisible(true);
				/*Set Header Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Home Page");
				/*Change button background color to white*/
				changeButtonBackground(btnMainPage);
			}
		});
		btnMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMainPage.setName("HomePage");
		btnMainPage.setIconTextGap(10);
		btnMainPage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMainPage.setHorizontalAlignment(SwingConstants.LEFT);
		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		btnMainPage.setFocusable(false);
		btnMainPage.setBorderPainted(false);
		btnMainPage.setBackground(new Color(102, 51, 153));
		btnMainPage.setBounds(0, 43, 206, 34);
		   /* set icon to button */
		try
		 {
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"btnMainPage.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnMainPage.setIcon(new ImageIcon(image2));
			btnMainPage.setIconTextGap(10);

		 }
		catch (Exception e)
		 {
			System.out.println(e);
		 } 
			/* End of set icon to button */

		MenuPanel.add(btnMainPage);
		/*End of Main Page Button*/	
		

		/*Patient Page Button*/		
		btnPatientPage = new JButton("Patients");
		btnPatientPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Supervisors Patients Page Object*/
				Supervisors_PatientsPage supervisorPatientpage = new Supervisors_PatientsPage();
				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Patients Page Window to desktopPane*/
				desktopPane.add(supervisorPatientpage).setVisible(true);
				/*Set Header Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Patients Page");
				/*Change button background color to white*/
				changeButtonBackground(btnPatientPage);
			}
		});
		btnPatientPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPatientPage.setName("PatientsPage");
		btnPatientPage.setIconTextGap(10);
		btnPatientPage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPatientPage.setHorizontalAlignment(SwingConstants.LEFT);
		btnPatientPage.setForeground(Color.WHITE);
		btnPatientPage.setFont(new Font("Kartika", Font.BOLD, 20));
		btnPatientPage.setFocusable(false);
		btnPatientPage.setBorderPainted(false);
		btnPatientPage.setBackground(new Color(102, 51, 153));
		btnPatientPage.setBounds(0, 88, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"dentist patient.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnPatientPage.setIcon(new ImageIcon(image2));
			btnPatientPage.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	       /* End of set icon to button */
		
		MenuPanel.add(btnPatientPage);
		/*End of Patient Page Button*/	
		
		
		/*Appointment Page Button*/		
		btnAppointmentPage = new JButton("Appointments");
		btnAppointmentPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Supervisors Appointments Page Object*/
				Supervisors_AppointmentsPage supervisorsAppointmentsPage = new Supervisors_AppointmentsPage();
				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Appointments Page Window to desktopPane*/
				desktopPane.add(supervisorsAppointmentsPage).setVisible(true);
				/*Set Header Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Appointments Page");
				/*Change button background color to white*/
				changeButtonBackground(btnAppointmentPage);
			}
		});
		btnAppointmentPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAppointmentPage.setName("AppointmentsPage");
		btnAppointmentPage.setIconTextGap(10);
		btnAppointmentPage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAppointmentPage.setHorizontalAlignment(SwingConstants.LEFT);
		btnAppointmentPage.setForeground(Color.WHITE);
		btnAppointmentPage.setFont(new Font("Kartika", Font.BOLD, 20));
		btnAppointmentPage.setFocusable(false);
		btnAppointmentPage.setBorderPainted(false);
		btnAppointmentPage.setBackground(new Color(102, 51, 153));
		btnAppointmentPage.setBounds(0, 133, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"calendar.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnAppointmentPage.setIcon(new ImageIcon(image2));
			btnAppointmentPage.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	      /* End of set icon to button */
		
		MenuPanel.add(btnAppointmentPage);
		/*End of Appointment Page Button*/	
		

		/*Staff Page Button*/		
		btnStaffPage = new JButton("Staff");
		btnStaffPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Supervisors Staff Page Object*/
				Supervisors_StaffPage supervisorsStaffPage = new Supervisors_StaffPage();
			
				/*Set Supervisor Name*/
				supervisorsStaffPage.supervisorName = supervisorName;
				/*End of Supervisor set Name*/

				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Main Page Window to desktopPane*/
				desktopPane.add(supervisorsStaffPage).setVisible(true);
				/*Set Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Staff Page");
				/*Change button background color to white*/
				changeButtonBackground(btnStaffPage);
			}
		});
		btnStaffPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStaffPage.setName("StaffPage");
		btnStaffPage.setIconTextGap(10);
		btnStaffPage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnStaffPage.setHorizontalAlignment(SwingConstants.LEFT);
		btnStaffPage.setForeground(Color.WHITE);
		btnStaffPage.setFont(new Font("Kartika", Font.BOLD, 20));
		btnStaffPage.setFocusable(false);
		btnStaffPage.setBorderPainted(false);
		btnStaffPage.setBackground(new Color(102, 51, 153));
		btnStaffPage.setBounds(0, 268, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"medical-staff.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnStaffPage.setIcon(new ImageIcon(image2));
			btnStaffPage.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	      /* End of set icon to button */
		
		MenuPanel.add(btnStaffPage);
		/*End of Staff Page Button*/
		

		/*Invoice Page Button*/		
		btnInvoicePage = new JButton("Invoices");
		btnInvoicePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*Supervisors Invoices Page Object*/
				Supervisors_InvoicesPage supervisorsInvoicesPage = new Supervisors_InvoicesPage();
				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Invoices Page Window to desktopPane*/
				desktopPane.add(supervisorsInvoicesPage).setVisible(true);
				/*Set Header Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Invoices Page");
				/*Change button background color to white*/
				changeButtonBackground(btnInvoicePage);
			}
		});
		btnInvoicePage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInvoicePage.setName("InvoicesPage");
		btnInvoicePage.setIconTextGap(10);
		btnInvoicePage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInvoicePage.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoicePage.setForeground(Color.WHITE);
		btnInvoicePage.setFont(new Font("Kartika", Font.BOLD, 20));
		btnInvoicePage.setFocusable(false);
		btnInvoicePage.setBorderPainted(false);
		btnInvoicePage.setBackground(new Color(102, 51, 153));
		btnInvoicePage.setBounds(0, 178, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"invoice.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnInvoicePage.setIcon(new ImageIcon(image2));
			btnInvoicePage.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	      /* End of set icon to button */
		
		MenuPanel.add(btnInvoicePage);
		/*End of Invoice Page Button*/	
		

		/*Revenues Page Button*/		
		btnRevenues = new JButton("Revenues");
		btnRevenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Supervisors Revenues Page Object*/
				Supervisors_RevenuesPage supervisorsRevenuesPage = new Supervisors_RevenuesPage();
				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Supervisors Revenues Page Window to desktopPane*/
				desktopPane.add(supervisorsRevenuesPage).setVisible(true);
				/*Set Header Title*/
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Revenues Page");
				/*Change button background color to white*/
				changeButtonBackground(btnRevenues);
			}
		});
		btnRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRevenues.setName("RevenuesPage");
		btnRevenues.setIconTextGap(10);
		btnRevenues.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRevenues.setHorizontalAlignment(SwingConstants.LEFT);
		btnRevenues.setForeground(Color.WHITE);
		btnRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		btnRevenues.setFocusable(false);
		btnRevenues.setBorderPainted(false);
		btnRevenues.setBackground(new Color(102, 51, 153));
		btnRevenues.setBounds(0, 223, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"dental-record.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnRevenues.setIcon(new ImageIcon(image2));
			btnRevenues.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	      /* End of set icon to button */
		
		MenuPanel.add(btnRevenues);
		/*End of Revenues Page Button*/	
		

		/*Logout Page Button*/		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*Change button background color to white*/
				changeButtonBackground(btnLogout);
				
				// Login Page object
				LoginPage loginPage = new LoginPage();
				
				
				// Confirm Logout 
				
				int a = JOptionPane.showConfirmDialog(null, "Do you want to logout?","Confirm Logout",JOptionPane.YES_NO_OPTION);
				
				
				if(a == 0)
				{
					JOptionPane.showMessageDialog(null, "Thank you "+supervisorName+" "+supervisorLast_Name+"," + "\n See you next time.");
					loginPage.main(null);
					setVisible(false);

				}				
			
			}
		});
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setName("LogoutPage");
		btnLogout.setIconTextGap(10);
		btnLogout.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Kartika", Font.BOLD, 20));
		btnLogout.setFocusable(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(102, 51, 153));
		btnLogout.setBounds(0, 313, 206, 34);
		   /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"log-out.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnLogout.setIcon(new ImageIcon(image2));
			btnLogout.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
           /* End of set icon to button */
		
		MenuPanel.add(btnLogout);
		/*End of Logout Page Button*/
		

		/*Developer Page Button*/		
		btnDeveloper = new JButton("Developer");
		btnDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Developer Page Object*/
				DeveloperPage developerPage = new DeveloperPage();
				/*End of Developer Page Object*/
				
				/*Clear desktopPane*/
				desktopPane.removeAll();
				/*Add Developer Page Window to desktopPane*/
				desktopPane.add(developerPage).setVisible(true);
				lblSupervisorsDashboard.setText("Supervisors Dashboard - Developer Page");
				/*Change button background color to white*/
				changeButtonBackground(btnDeveloper);
			}
		});
		btnDeveloper.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeveloper.setName("DeveloperPage");
		btnDeveloper.setIconTextGap(10);
		btnDeveloper.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDeveloper.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeveloper.setForeground(Color.WHITE);
		btnDeveloper.setFont(new Font("Kartika", Font.BOLD, 20));
		btnDeveloper.setFocusable(false);
		btnDeveloper.setBorderPainted(false);
		btnDeveloper.setBackground(new Color(102, 51, 153));
		btnDeveloper.setBounds(0, 358, 206, 34);
		  /* set icon to button */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"Developer.png"));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnDeveloper.setIcon(new ImageIcon(image2));
			btnDeveloper.setIconTextGap(10);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		  /* End of set icon to button */
				
		MenuPanel.add(btnDeveloper);
		/*End of Developer Page Button*/		

		
		/*Rights Label*/		
		lblAmjadAzim = new JLabel("© AMJAD AZIM |2023|ALL RIGHTS RESERVED");
		lblAmjadAzim.setForeground(Color.WHITE);
		lblAmjadAzim.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblAmjadAzim.setBounds(0, 497, 206, 14);
		MenuPanel.add(lblAmjadAzim);
		/*End of Rights Label*/		
		
		
		/*Desktop Pane*/		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(206, 28, 650, 522);
		contentPane.add(desktopPane);
		/*End of Desktop Pane*/		


	}
	
	
	/*
	 * ***************************************
	 *               
	 *               
	 *               Methods
	 *               
	 *               
	 * ***************************************
	 */
	
	
	
	
	
	 /*
     * ***************************************
     *     X JLabel for close window Method
     * ***************************************
     */
	private void exitLblMouseClicked(java.awt.event.MouseEvent evt) 
	{
        System.exit(0);
	}
	/*
     * *****************************************
     *  End of X JLabel for close window Method
     * *****************************************
     */
	
	
	
	/*
	 * ***************************************
	 *   - JLabel for minimize window Method
	 * ***************************************
	 */
	private void minimizeLblMouseClicked(java.awt.event.MouseEvent evt) 
	{
		setState(java.awt.Frame.ICONIFIED);
	}
	/*
	 * *********************************************
	 *   End of - JLabel for minimize window Method
	 * *********************************************
	 */
	
	
	
	/*
	 * ***************************************
	 *    Change buttons Background  Method
	 * ***************************************
	 */
	public void changeButtonBackground(JButton button)
	{
		if(button == btnMainPage)
		{
			//change clicked button background color to white
			btnMainPage.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnMainPage.setForeground(new Color(102, 51, 153));

			
			//keep the other buttons background color 
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);


		}
		
		
		else if(button == btnPatientPage)
		{
			//change clicked button background color to white
			btnPatientPage.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnPatientPage.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnAppointmentPage)
		{
			//change clicked button background color to white
			btnAppointmentPage.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnAppointmentPage.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnInvoicePage)
		{
			//change clicked button background color to white
			btnInvoicePage.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnInvoicePage.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnRevenues)
		{
			//change clicked button background color to white
			btnRevenues.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnRevenues.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnStaffPage)
		{
			//change clicked button background color to white
			btnStaffPage.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnStaffPage.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnLogout)
		{
			//change clicked button background color to white
			btnLogout.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnLogout.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnDeveloper.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnDeveloper.setForeground(Color.WHITE);

		}
		
		
		else if(button == btnDeveloper)
		{
			//change clicked button background color to white
			btnDeveloper.setBackground(Color.WHITE);
			
			//change clicked button Foreground color to purple
			btnDeveloper.setForeground(new Color(102, 51, 153));
			
			//keep the other buttons background color 
			btnMainPage.setBackground(new Color(102, 51, 153));
			btnPatientPage.setBackground(new Color(102, 51, 153));
			btnAppointmentPage.setBackground(new Color(102, 51, 153));
			btnInvoicePage.setBackground(new Color(102, 51, 153));
			btnRevenues.setBackground(new Color(102, 51, 153));
			btnStaffPage.setBackground(new Color(102, 51, 153));
			btnLogout.setBackground(new Color(102, 51, 153));
			
			//keep the other buttons Foreground color
			btnMainPage.setForeground(Color.WHITE);
			btnPatientPage.setForeground(Color.WHITE);
			btnAppointmentPage.setForeground(Color.WHITE);
			btnInvoicePage.setForeground(Color.WHITE);
			btnRevenues.setForeground(Color.WHITE);
			btnStaffPage.setForeground(Color.WHITE);
			btnLogout.setForeground(Color.WHITE);

		}
	}
}
