package mydentisten.ui;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import mydentisten.database.ConnectionFactory;

/**
*
* @author amjad azim
*/

public class Supervisors_RevenuesPage extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*Variables*/
    
	//JLabel
    private JLabel labelTodayRevenues_panelCardMainRevenuesPage;
	private JLabel labelSearchRevenues_panelCardMainRevenuesPage;
	private JLabel lblSearchRevenues1_panelCardMainRevenuesPage;
    private JLabel lblTodayRevenues1_panelCardMainRevenuesPage;
    private JLabel lblDayRevenuesPageTitle_panelCardTodayRevenues;
    private JLabel lblSearchRevenuesPageTitle_panelCardSearchRevenues;
    private JLabel lblRevenueResult_panelCardTodayRevenues;
	private JLabel lblEnterDayDate_panelCardTodayRevenues;
	
	//JButton
	private JButton backBtn_panelCardSearchRevenues;
	private JButton btnEnterTodayRevenues_panelCardTodayRevenues;
	private JButton backBtn_panelCardTodayRevenues;
	private JButton BtnClearField_panelCardTodayRevenues;
	
    //String
	final static String  TodayRevenuesPanel = "Today Revenues";
	final static String  SearchRevenuesPanel = "Search Revenues ";
	final static String  MainRevenuesPagePanel = "Main Revenues Page";
	
	//JTextField
	private static JTextField textRevenuesResult_panelCardTodayRevenues;

	//JDateChooser
	private static JDateChooser RevenuesDate_panelCardTodayRevenues;

    //Connection
    private static Connection connection = ConnectionFactory.getConnection();

	/*End of Variables*/

    
	/*Panels*/
    private JPanel panelCards;
	private JPanel panelCardMainRevenuesPage;
	private JPanel panelTodayRevenues_panelCardMainRevenuesPage;
	private JPanel panelSearchRevenues_panelCardMainRevenuesPage;
	private JPanel panelCardTodayRevenues;
	private JPanel panelTotalDayRevenues_panelCardTodayRevenues;
	private JPanel panelCardSearchRevenues;
	/*End Of Panels*/

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisors_RevenuesPage frame = new Supervisors_RevenuesPage();
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
	public Supervisors_RevenuesPage() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		setBackground(Color.WHITE);
		setFocusable(false);
		setFrameIcon(null);
		setBounds(0, 0, 650, 522);
		getContentPane().setLayout(null);
		
		
		/*Cards Panel*/
		panelCards = new JPanel();
		panelCards.setBackground(Color.WHITE);
		panelCards.setBounds(0, 0, 650, 496);
		getContentPane().add(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		/*End of Cards Panel*/
		
		
		/*Card Main Revenues Page Panel*/
		panelCardMainRevenuesPage = new JPanel();
		panelCardMainRevenuesPage.setBackground(Color.WHITE);
		panelCards.add(panelCardMainRevenuesPage, MainRevenuesPagePanel);
		panelCardMainRevenuesPage.setLayout(null);
		/*End of Card Main Revenues Page Panel*/

		
		/*Today Revenues Panel panelCardMainRevenuesPage*/
		panelTodayRevenues_panelCardMainRevenuesPage = new JPanel();
		panelTodayRevenues_panelCardMainRevenuesPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Today Revenues Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, TodayRevenuesPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelTodayRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelTodayRevenues_panelCardMainRevenuesPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelTodayRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelTodayRevenues_panelCardMainRevenuesPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelTodayRevenues_panelCardMainRevenuesPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTodayRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelTodayRevenues_panelCardMainRevenuesPage.setBackground(Color.WHITE);
		panelTodayRevenues_panelCardMainRevenuesPage.setBounds(391, 174, 180, 167);
		panelCardMainRevenuesPage.add(panelTodayRevenues_panelCardMainRevenuesPage);
		panelTodayRevenues_panelCardMainRevenuesPage.setLayout(null);
		/*End of Today Revenues Panel panelCardMainRevenuesPage*/

		
		/*Today Revenues Label panelCardMainRevenuesPage*/
		labelTodayRevenues_panelCardMainRevenuesPage = new JLabel("Day");
		labelTodayRevenues_panelCardMainRevenuesPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelTodayRevenues_panelCardMainRevenuesPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelTodayRevenues_panelCardMainRevenuesPage.setBounds(10, 56, 160, 35);
		panelTodayRevenues_panelCardMainRevenuesPage.add(labelTodayRevenues_panelCardMainRevenuesPage);
		/*End of Today Revenues Label panelCardMainRevenuesPage*/

		
		/*Today Revenues 1 Label panelCardMainRevenuesPage*/
		lblTodayRevenues1_panelCardMainRevenuesPage = new JLabel("Revenues");
		lblTodayRevenues1_panelCardMainRevenuesPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodayRevenues1_panelCardMainRevenuesPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTodayRevenues1_panelCardMainRevenuesPage.setBounds(10, 87, 160, 35);
		panelTodayRevenues_panelCardMainRevenuesPage.add(lblTodayRevenues1_panelCardMainRevenuesPage);
		/*End of Today Revenues 1 Label panelCardMainRevenuesPage*/
		
		
		/*Search Revenues Panel panelCardMainRevenuesPage*/
		panelSearchRevenues_panelCardMainRevenuesPage = new JPanel();
		panelSearchRevenues_panelCardMainRevenuesPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search Revenues Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SearchRevenuesPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchRevenues_panelCardMainRevenuesPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchRevenues_panelCardMainRevenuesPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchRevenues_panelCardMainRevenuesPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchRevenues_panelCardMainRevenuesPage.setLayout(null);
		panelSearchRevenues_panelCardMainRevenuesPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchRevenues_panelCardMainRevenuesPage.setBackground(Color.WHITE);
		panelSearchRevenues_panelCardMainRevenuesPage.setBounds(82, 174, 180, 167);
		panelCardMainRevenuesPage.add(panelSearchRevenues_panelCardMainRevenuesPage);
		/*End of Search Revenues Panel panelCardMainRevenuesPage*/
		
		
		
		/*Search Revenues Label panelCardMainRevenuesPage*/
		labelSearchRevenues_panelCardMainRevenuesPage = new JLabel("Search");
		labelSearchRevenues_panelCardMainRevenuesPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchRevenues_panelCardMainRevenuesPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchRevenues_panelCardMainRevenuesPage.setBounds(10, 56, 160, 35);
		panelSearchRevenues_panelCardMainRevenuesPage.add(labelSearchRevenues_panelCardMainRevenuesPage);
		/*End of Search Revenues Label panelCardMainRevenuesPage*/

		
		/*Search Revenues 1 Label panelCardMainRevenuesPage*/
		lblSearchRevenues1_panelCardMainRevenuesPage = new JLabel("Revenues");
		lblSearchRevenues1_panelCardMainRevenuesPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchRevenues1_panelCardMainRevenuesPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchRevenues1_panelCardMainRevenuesPage.setBounds(10, 87, 160, 35);
		panelSearchRevenues_panelCardMainRevenuesPage.add(lblSearchRevenues1_panelCardMainRevenuesPage);
		/*End of Search Revenues 1 Label panelCardMainRevenuesPage*/

		
		/*Card Today Revenues Page Panel*/
		panelCardTodayRevenues = new JPanel();
		panelCardTodayRevenues.setBackground(Color.WHITE);
		panelCards.add(panelCardTodayRevenues, TodayRevenuesPanel);
		panelCardTodayRevenues.setLayout(null);
		/*End of Card Today Revenues Page Panel*/

		
		/*Card Search Revenues Page Panel*/
		panelCardSearchRevenues = new JPanel();
		panelCardSearchRevenues.setLayout(null);
		panelCardSearchRevenues.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchRevenues, SearchRevenuesPanel);
		/*End of Card Search Revenues Page Panel*/

		
		/*Back Button panelCardSearchRevenues*/
		backBtn_panelCardSearchRevenues = new JButton();
		backBtn_panelCardSearchRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardSearchRevenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Main Revenues Page Panel card when mouse clicked
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, MainRevenuesPagePanel);
			}
		});
		backBtn_panelCardSearchRevenues.setText("Back");
		backBtn_panelCardSearchRevenues.setForeground(Color.WHITE);
		backBtn_panelCardSearchRevenues.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardSearchRevenues.setFocusable(false);
		backBtn_panelCardSearchRevenues.setBackground(new Color(204, 0, 0));
		backBtn_panelCardSearchRevenues.setBounds(271, 432, 105, 35);
		panelCardSearchRevenues.add(backBtn_panelCardSearchRevenues);
		/*End of Back Button panelCardSearchRevenues*/
		
		
		/*Total Day Revenues Panel panelCardTodayRevenues*/
		panelTotalDayRevenues_panelCardTodayRevenues = new JPanel();
		panelTotalDayRevenues_panelCardTodayRevenues.setLayout(null);
		panelTotalDayRevenues_panelCardTodayRevenues.setBackground(new Color(102, 51, 153));
		panelTotalDayRevenues_panelCardTodayRevenues.setBounds(106, 110, 439, 198);
		panelCardTodayRevenues.add(panelTotalDayRevenues_panelCardTodayRevenues);
		/*End of Total Day Revenues Panel panelCardTodayRevenues*/

		
		/*Enter Today Revenues Button panelCardTodayRevenues*/
		btnEnterTodayRevenues_panelCardTodayRevenues = new JButton();
		btnEnterTodayRevenues_panelCardTodayRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnterTodayRevenues_panelCardTodayRevenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				/*
				 * THIS CODE FOR CALCULATING
				 * REVENUES FROM SELCTED DATE
				 * USING SUM FUNCTION
				 * IT CALCULATE ALL THE SELCTED COLUMN
				 * IN THIS CASE I CHOOSED SERVICE PRICE COLUMN
				 */

				
				
				
				//Check empty spaces
				if(RevenuesDate_panelCardTodayRevenues.getDate()==null )
			    //If there are empty spaces show message
				{ JOptionPane.showMessageDialog(null, "Please Enter Date"); }
				
				//Continue after "Check empty spaces"
			    else {
				PreparedStatement preparedStatement;
				
				//date to string
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
				String DayDate              = dFormat.format(RevenuesDate_panelCardTodayRevenues.getDate());
				//End date to string
				
				try {
					preparedStatement = connection.prepareStatement("SELECT SUM(Service_Price) total FROM Invoices WHERE `Date` = ?");
					preparedStatement.setString(1, DayDate);
					ResultSet resaultset = preparedStatement.executeQuery();
					
					//If Revenues for selected Date available
					if(resaultset.next())
					{
						//Revenue Integer To String
						String TotalRevenues = Integer.toString(resaultset.getInt(1));
						//End Revenue Integer To String

						//Set text to textField
						textRevenuesResult_panelCardTodayRevenues.setText(TotalRevenues +" SDG");
						
						//Close database
						preparedStatement.close();

					}
					
					//If Revenues for selected Date not available
					else
					{
						//Show message
						JOptionPane.showMessageDialog(null, "No Revenues For Selected Date");
						//Close database
						preparedStatement.close();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			}
		});
		btnEnterTodayRevenues_panelCardTodayRevenues.setText("Enter");
		btnEnterTodayRevenues_panelCardTodayRevenues.setForeground(Color.WHITE);
		btnEnterTodayRevenues_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 17));
		btnEnterTodayRevenues_panelCardTodayRevenues.setFocusable(false);
		btnEnterTodayRevenues_panelCardTodayRevenues.setBackground(new Color(102, 51, 153));
		btnEnterTodayRevenues_panelCardTodayRevenues.setBounds(170, 83, 105, 35);
		panelTotalDayRevenues_panelCardTodayRevenues.add(btnEnterTodayRevenues_panelCardTodayRevenues);
		/*End of Enter Today Revenues Button panelCardTodayRevenues*/

		
		
		/*Enter Day Date Label panelCardTodayRevenues*/
		lblEnterDayDate_panelCardTodayRevenues = new JLabel("Enter Day Date");
		lblEnterDayDate_panelCardTodayRevenues.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDayDate_panelCardTodayRevenues.setForeground(Color.WHITE);
		lblEnterDayDate_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		lblEnterDayDate_panelCardTodayRevenues.setFocusable(false);
		lblEnterDayDate_panelCardTodayRevenues.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblEnterDayDate_panelCardTodayRevenues.setBounds(34, 36, 180, 36);
		panelTotalDayRevenues_panelCardTodayRevenues.add(lblEnterDayDate_panelCardTodayRevenues);
		/*End of Enter Day Date Label panelCardTodayRevenues*/

		
		/*Revenues Result textField panelCardTodayRevenues*/
		textRevenuesResult_panelCardTodayRevenues = new JTextField();
		textRevenuesResult_panelCardTodayRevenues.setEditable(false);
		textRevenuesResult_panelCardTodayRevenues.setToolTipText("إجمالي الإيرادات");
		textRevenuesResult_panelCardTodayRevenues.setHorizontalAlignment(SwingConstants.CENTER);
		textRevenuesResult_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		textRevenuesResult_panelCardTodayRevenues.setColumns(10);
		textRevenuesResult_panelCardTodayRevenues.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textRevenuesResult_panelCardTodayRevenues.setBounds(236, 129, 171, 36);
		panelTotalDayRevenues_panelCardTodayRevenues.add(textRevenuesResult_panelCardTodayRevenues);
		/*End of Revenues Result textField panelCardTodayRevenues*/

		
		/*Revenues Date JDateChooser panelCardTodayRevenues*/
		RevenuesDate_panelCardTodayRevenues = new JDateChooser();
		RevenuesDate_panelCardTodayRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RevenuesDate_panelCardTodayRevenues.setToolTipText("التاريخ");
		RevenuesDate_panelCardTodayRevenues.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		RevenuesDate_panelCardTodayRevenues.setBounds(236, 36, 171, 36);
		panelTotalDayRevenues_panelCardTodayRevenues.add(RevenuesDate_panelCardTodayRevenues);
		/*End of Revenues Date JDateChooser panelCardTodayRevenues*/
		
		
		/*Revenue Result Label panelCardTodayRevenues*/
		lblRevenueResult_panelCardTodayRevenues = new JLabel("Revenue");
		lblRevenueResult_panelCardTodayRevenues.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevenueResult_panelCardTodayRevenues.setForeground(Color.WHITE);
		lblRevenueResult_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		lblRevenueResult_panelCardTodayRevenues.setFocusable(false);
		lblRevenueResult_panelCardTodayRevenues.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblRevenueResult_panelCardTodayRevenues.setBounds(34, 129, 180, 36);
		panelTotalDayRevenues_panelCardTodayRevenues.add(lblRevenueResult_panelCardTodayRevenues);
		/*End of Revenue Result Label panelCardTodayRevenues*/

		
		/*Clear Field Button panelCardTodayRevenues*/
		BtnClearField_panelCardTodayRevenues = new JButton();
		BtnClearField_panelCardTodayRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearField_panelCardTodayRevenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear Fields
				ClearAll();
			}
		});
		BtnClearField_panelCardTodayRevenues.setText("Clear");
		BtnClearField_panelCardTodayRevenues.setForeground(Color.WHITE);
		BtnClearField_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearField_panelCardTodayRevenues.setFocusable(false);
		BtnClearField_panelCardTodayRevenues.setBackground(new Color(46, 139, 87));
		BtnClearField_panelCardTodayRevenues.setBounds(331, 426, 105, 35);
		panelCardTodayRevenues.add(BtnClearField_panelCardTodayRevenues);
		/*End of Clear Field Button panelCardTodayRevenues*/
		
		
		/*Back Button panelCardTodayRevenues*/
		backBtn_panelCardTodayRevenues = new JButton();
		backBtn_panelCardTodayRevenues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardTodayRevenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Main Revenues Page Panel card when mouse clicked
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, MainRevenuesPagePanel);
				
				// Clear Fields
				ClearAll();
			}
		});
		backBtn_panelCardTodayRevenues.setText("Back");
		backBtn_panelCardTodayRevenues.setForeground(Color.WHITE);
		backBtn_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardTodayRevenues.setFocusable(false);
		backBtn_panelCardTodayRevenues.setBackground(new Color(204, 0, 0));
		backBtn_panelCardTodayRevenues.setBounds(216, 426, 105, 35);
		panelCardTodayRevenues.add(backBtn_panelCardTodayRevenues);
		/*End of Back Button panelCardTodayRevenues*/
		
		
		/*Day Revenues Page Title Label panelCardTodayRevenues*/
		lblDayRevenuesPageTitle_panelCardTodayRevenues = new JLabel("Day Revenues Page");
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setForeground(Color.BLACK);
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setFocusable(false);
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDayRevenuesPageTitle_panelCardTodayRevenues.setBounds(167, 0, 317, 36);
		panelCardTodayRevenues.add(lblDayRevenuesPageTitle_panelCardTodayRevenues);
		panelCards.add(panelCardSearchRevenues, SearchRevenuesPanel);
		/*End of Day Revenues Page Title Label panelCardTodayRevenues*/

		
		/*Search Revenues Page Title Label panelCardSearchRevenues*/
		lblSearchRevenuesPageTitle_panelCardSearchRevenues = new JLabel("Search Revenues Page");
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setForeground(Color.BLACK);
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setFocusable(false);
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchRevenuesPageTitle_panelCardSearchRevenues.setBounds(167, 0, 317, 36);
		panelCardSearchRevenues.add(lblSearchRevenuesPageTitle_panelCardSearchRevenues);
		/*End of Search Revenues Page Title Label panelCardSearchRevenues*/


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
     * **************************************************
     *   Clear All Fields For Today Revenues Card Method
     * **************************************************
     */
   public static void ClearAll()
   {
	   textRevenuesResult_panelCardTodayRevenues.setText(null);
	   RevenuesDate_panelCardTodayRevenues.setDate(null);
	   
   }
   /*
    * ********************************************************
    *  End of Clear All Fields For Today Revenues Card Method
    * ********************************************************
    */
}
