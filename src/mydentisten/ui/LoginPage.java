package mydentisten.ui;

import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;

import mydentisten.database.ConnectionFactory;
import mydentisten.dto.UsersDTO;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*
* @author amjad azim
*/

public class LoginPage {

	/*Variables*/
	
	//JLabel
	private JLabel exitLbl;
	private JLabel minimizeLbl;
	private JLabel lblUsename;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JLabel lblMydentistlogo = new JLabel("");

	//JButton
	private JButton btnLogIn;
	private JButton btnShowhide;
	private JButton btnClear;
	
	//JTextField
	private JTextField textFieldUsername;
	
	//JPasswordField
	private JPasswordField passwordField;
	
	//JComboBox
	private JComboBox comboBoxUserType;
	
	/*End of Variables*/

	
	
	/*Frame and Panels*/
	private JFrame frame;
	private JPanel BodyPanel;
	private JPanel Headerpanel;
	private JPanel panelExit;
	private JPanel panelMinimize;
	/*End of Panels*/

	
	

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
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*set no decoration for the frame */
		frame.setUndecorated(true);
		/*set the frame in the center of the screen */
		frame.setLocationRelativeTo(null);
		/*set rounded corners for the frame */
		frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 20, 20));
		/* frame title */		
		frame.setTitle("Login");
		/* frame layout */		
		frame.getContentPane().setLayout(null);
		/*frame icon*/
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/MyDentist2.png"));
			Image image2 = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			frame.setIconImage(image2);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		/*End of frame icon*/
		
		
		/* Header Panel */
		Headerpanel = new JPanel();
		Headerpanel.setLayout(null);
		Headerpanel.setBackground(new Color(216, 191, 216));
		Headerpanel.setBounds(0, 0, 468, 28);
		frame.getContentPane().add(Headerpanel);
		/*End of Header Panel */

		
		/* Login Title */		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Kartika", Font.BOLD, 24));
		lblLogin.setBounds(68, 0, 325, 26);
		Headerpanel.add(lblLogin);
		/*End of Login Title */		

		
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
					JOptionPane.showMessageDialog(null, "Thank you, "+"\n See you next time.");
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
		panelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelExit.setBackground(new Color(216, 191, 216));
		panelExit.setBounds(436, 1, 25, 25);
		Headerpanel.add(panelExit);
		panelExit.setLayout(null);
		/*End of Exit Panel*/

		
		/* X JLabel */		
		exitLbl = new JLabel();
		exitLbl.setHorizontalAlignment(SwingConstants.CENTER);
		exitLbl.setBounds(0, 0, 25, 25);
		panelExit.add(exitLbl);
		exitLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLbl.setText("X");
		exitLbl.setForeground(new Color(204, 0, 0));
		exitLbl.setFont(new Font("Kartika", Font.BOLD, 18));
		/*End of X JLabel */		

		
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
		panelMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMinimize.setBackground(new Color(216, 191, 216));
		panelMinimize.setBounds(402, 1, 25, 25);
		Headerpanel.add(panelMinimize);
		panelMinimize.setLayout(null);
		/*End of Minimize Panel*/

		
		/* - JLabel */		
		minimizeLbl = new JLabel();
		minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLbl.setBounds(0, 0, 25, 25);
		panelMinimize.add(minimizeLbl);
		minimizeLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeLbl.setText("-");
		minimizeLbl.setFont(new Font("Kartika", Font.BOLD, 36));
		/*End of - JLabel */		


		/*Body Panel*/
		BodyPanel = new JPanel();
		BodyPanel.setLayout(null);
		BodyPanel.setBackground(Color.WHITE);
		BodyPanel.setBounds(0, 27, 468, 342);
		frame.getContentPane().add(BodyPanel);
		/*End of Body Panel*/

		/*Login Button*/
		btnLogIn = new JButton("Login");
		btnLogIn.addActionListener(new ActionListener() {
			/*Login when login button clicked*/
			public void actionPerformed(ActionEvent e) {
				LoginButton();
			}
		});
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setName("log-out.png");
		btnLogIn.setIconTextGap(10);
		btnLogIn.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Kartika", Font.BOLD, 17));
		btnLogIn.setFocusable(false);
		btnLogIn.setBorderPainted(false);
		btnLogIn.setBackground(new Color(102, 51, 153));
		btnLogIn.setBounds(92, 283, 116, 34);
		BodyPanel.add(btnLogIn);
		/*End of Login Button*/

		/*Username JLabel*/
		lblUsename = new JLabel("Username");
		lblUsename.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsename.setForeground(Color.BLACK);
		lblUsename.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUsename.setFocusable(false);
		lblUsename.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUsename.setBounds(27, 115, 171, 36);
		BodyPanel.add(lblUsename);
		/*End of Username JLabel*/

		/*Password JLabel*/
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPassword.setFocusable(false);
		lblPassword.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPassword.setBounds(27, 162, 171, 36);
		BodyPanel.add(lblPassword);
		/*End of Password JLabel*/
		
		/*Username JTextField*/
		textFieldUsername = new JTextField();
		textFieldUsername.setToolTipText("Username");
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setFont(new Font("Kartika", Font.PLAIN, 19));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldUsername.setBounds(208, 115, 171, 36);
		BodyPanel.add(textFieldUsername);
		/*End of Username JTextField*/

		/*Password JPasswordField*/
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordField.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordField.setBounds(208, 162, 171, 36);
		BodyPanel.add(passwordField);
		/*End of Password JPasswordField*/

		/*Show Button */
		btnShowhide = new JButton("Show");
		btnShowhide.addActionListener(new ActionListener() {
			/*Show or Hide Password when show button clicked*/
			public void actionPerformed(ActionEvent e) {
				ShowAndHidePasswordButton();
			}
		});
		btnShowhide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowhide.setForeground(Color.WHITE);
		btnShowhide.setFont(new Font("Kartika", Font.BOLD, 14));
		btnShowhide.setFocusable(false);
		btnShowhide.setBackground(new Color(102, 51, 153));
		btnShowhide.setBounds(389, 162, 69, 36);
		BodyPanel.add(btnShowhide);
		/*End of Show Button */

		/*Clear Button */
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			/*Clear Username, Password, User Type fields when clear button clicked*/
			public void actionPerformed(ActionEvent e) {
				ClearButton();
			}
		});
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setName("log-out.png");
		btnClear.setIconTextGap(10);
		btnClear.setHorizontalTextPosition(SwingConstants.LEFT);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Kartika", Font.BOLD, 17));
		btnClear.setFocusable(false);
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(46, 139, 87));
		btnClear.setBounds(218, 283, 116, 34);
		BodyPanel.add(btnClear);
		/*End of Clear Button */
		
		/*User Type comboBox */
		comboBoxUserType = new JComboBox();
		comboBoxUserType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Select User Type", "Supervisor", "Receptionist"}));
		comboBoxUserType.setFont(new Font("Kartika", Font.BOLD, 20));
		comboBoxUserType.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxUserType.setBounds(27, 219, 352, 36);
		BodyPanel.add(comboBoxUserType);
		/*End of User Type comboBox */

		
		/*JLabel Logo */		
		lblMydentistlogo = new JLabel("");
		lblMydentistlogo.setBounds(174, 11, 160, 93);
		/* add icon to JLabel */
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/MyDentist.png"));
			Image image2 = image.getScaledInstance(lblMydentistlogo.getHeight(), lblMydentistlogo.getWidth(), Image.SCALE_SMOOTH);
			lblMydentistlogo.setIcon(new ImageIcon(image2));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		/* End of add icon to JLabel */

		BodyPanel.add(lblMydentistlogo);
		/*End of JLabel Logo */




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
		frame.setState(java.awt.Frame.ICONIFIED);
	}
	/*
	 * *********************************************
	 *   End of - JLabel for minimize window Method
	 * *********************************************
	 */
	
	
	
	
	/*
	 * *****************************************
	 *   Show and Hide Password Button Method
	 * *****************************************
	 */
	private void ShowAndHidePasswordButton()
	{
    	if(btnShowhide.getText().equals("Show"))
    	{
    		passwordField.setEchoChar('\u0000');
    		btnShowhide.setText("Hide");
    	}
    	else
    	{
    		passwordField.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		btnShowhide.setText("Show");
    	}
	}
	/*
	 * ***********************************************
	 *   End of Show and Hide Password Button Method
	 * ***********************************************
	 */
	
	
	
	
	/*
	 * ************************************************************
	 *   Clear Username, Password User Type Fields Button Method
	 * ************************************************************
	 */
	private void ClearButton()
	{
		textFieldUsername.setText("");
		passwordField.setText("");
		comboBoxUserType.setSelectedIndex(0);
		passwordField.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		btnShowhide.setText("Show");
	}
	/*
	 * ****************************************************************
	 *  End of Clear Username, Password User Type Fields Button Method
	 * ****************************************************************
	 */
	
	
	
	
	/*
	 * *************************
	 *   Login Button Method
	 * *************************
	 */
	@SuppressWarnings("deprecation")
	private void LoginButton()
	{
		/*check if username and password fields are empty*/ 
		if(textFieldUsername.getText().isEmpty() || passwordField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Please fill username and password fields");
		}
		
		/*if username and password fields are not empty*/ 
		else
		{	
			
		/*check if User Type not selected*/ 
		if(comboBoxUserType.getSelectedItem()== "Select User Type")
		{
		 JOptionPane.showMessageDialog(null, "Please Select User Type");
		}
		
		/*if User Type selected*/ 
		else 
		{
		String userType = (String) comboBoxUserType.getSelectedItem();	
		String username = textFieldUsername.getText();
		@SuppressWarnings("deprecation")
		String password = passwordField.getText();
		
		/*Verification login*/
		if(new ConnectionFactory().checkLogin(username, password, userType))
		{
			/*Get Name, Last Name, Username, User Type From Database */
		     String query = "SELECT * FROM Users WHERE Username= ? AND Password= ? AND User_Type= ?";
		     Connection con;
		     PreparedStatement preparedStatement;
		     ResultSet resultset;

		        try {
		        	con = ConnectionFactory.getConnection();
		        	preparedStatement = con.prepareStatement(query);
		        	preparedStatement.setString(1, username);
		        	preparedStatement.setString(2, password);
		        	preparedStatement.setString(3, userType);
		            resultset = preparedStatement.executeQuery();
		            
			/*When supervisor selected, show supervisors dashboard*/
			if(userType == "Supervisor")
			{
				/*Login Page dispose*/
				frame.dispose();
				/* Supervisors Dashboard Object*/
				Supervisors_Dashboard supervisorsDashboard = new Supervisors_Dashboard();
				
				/*Get Supervisors Name, Last Name, Username, User Type From Database*/
				supervisorsDashboard.supervisorName = resultset.getString(3);
				supervisorsDashboard.supervisorLast_Name = resultset.getString(4);
				supervisorsDashboard.supervisorUsername = resultset.getString(9);
				supervisorsDashboard.supervisorUser_Type = resultset.getString(11);
				preparedStatement.close();
				/*End of Get Supervisors Name, Last Name, Username, User Type From Database*/
				
				/*Supervisors Dashboard appear*/
				supervisorsDashboard.setVisible(true);
			}
			
			/*When receptionist selected, show receptionists dashboard*/
			else if(userType == "Receptionist")
			{
				/*Login Page dispose*/
				frame.dispose();
				/* Receptionists Dashboard Object*/
				Receptionists_Dashboard receptionistsDashboard = new Receptionists_Dashboard();
				
				/*Get Receptionist Name, Last Name, Username, User Type From Database*/
				receptionistsDashboard.receptionistName = resultset.getString(3);
				receptionistsDashboard.receptionistLast_Name = resultset.getString(4);
				receptionistsDashboard.receptionistUsername = resultset.getString(9);
				receptionistsDashboard.receptionistUser_Type = resultset.getString(11);
				preparedStatement.close();
				/*End of Get Receptionist Name, Last Name, Username, User Type From Database*/

				/* Receptionists Dashboard appear*/
				receptionistsDashboard.setVisible(true);
			}
			
		 	
        
		        } catch (Exception ex) {
            ex.printStackTrace();
        }
		}
		
		/*If login not Verification show message*/
		else {
	           JOptionPane.showMessageDialog(
	                   null,
	                   "Invalid username or password or user type.");
	        }
		}
		} 
	}
	/*
	 * ****************************
	 *  End of Login Button Method
	 * ****************************
	 */
}
