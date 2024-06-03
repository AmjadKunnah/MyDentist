package mydentisten.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.toedter.calendar.JDateChooser;

import mydentisten.dao.PatientsDAO;
import mydentisten.database.ConnectionFactory;
import mydentisten.dto.PatientsDTO;
import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;

/**
*
* @author amjad azim
*/

public class Receptionists_PatientsPage extends JInternalFrame {
	
	
	/*Variables*/
	
	//String
	final static String  PatientsRecordPanel = "Patients Record";
	final static String  AddPatientPanel = "Add Patient";
	final static String  PatientsMainPanel = "Patients Main";
	final static String  UpdatePatientPanel = "Update Patient";
	final static String  DeletePatientPanel = "Delete Patient";
	public String receptionistName;

	//JTable
	private static JTable table;
	
	//JLabel
	private static JLabel lblPatientID2_AddPatientPanel;
	private JLabel labelPatientsRecord;
	private JLabel labelAddPatient;
	private JLabel lblPatientSearch__PatientRecordPanel;
	private JLabel lblPatientSearchEnterID__PatientRecordPanel;
	private JLabel lblPatientName_AddPatientPanel;
	private JLabel lblPatientContactNO_AddPatientPanel;
	private JLabel lblPatientAddress_AddPatientPanel;
	private JLabel lblPatientGender_AddPatientPanel;
	private JLabel lblPatientID_AddPatientPanel;
	private JLabel lblPatientDateOfBirth_AddPatientPanel;
	private JLabel lblDeletePatient;
	private JLabel lblUpdatePatient;
	private JLabel lblPatientName_UpdatePatientPanel;
	private JLabel lblPatientContactNO_UpdatePatientPanel;
	private JLabel lblPatientAddress_UpdatePatientPanel;
	private JLabel lblPatientGender_UpdatePatientPanel;
	private JLabel lblPatientID_UpdatePatientPanel;
	private JLabel lblPatientDateOfBirth_UpdatePatientPanel;
	private JLabel lblPatientSearch_UpdatePatientPanel;
	private JLabel lblPatientSearchEnterID_UpdatePatientPanel;
	private JLabel lblPatientID2_UpdatePatientPanel;
	private JLabel lblPatientName_DeletePatientPanel;
	private JLabel lblPatientContactNO_DeletePatientPanel;
	private JLabel lblPatientAddress_DeletePatientPanel;
	private JLabel lblPatientGender_DeletePatientPanel;
	private JLabel lblPatientID_DeletePatientPanel;
	private JLabel lblPatientDateOfBirth_DeletePatientPanel;
	private JLabel lblPatientSearch_DeletePatientPanel;
	private JLabel lblPatientSearchEnterID_DeletePatientPanel;
	private JLabel lblPatientID2_DeletePatientPanel;
	private JLabel lblAddPatientTitle_AddPatientPanel;
	private JLabel lblUpdatePatientTitle_UpdatePatientPanel;
	private JLabel lblDeletePatientTitle_DeletePatientPanel;
	private JLabel lblPatientsRecordTitle_PatientRecordPanel;
	
	//JTextField
	private static JTextField textFieldPatientName_AddPatientPanel;
	private static JTextField textFieldContactNO_AddPatientPanel;
	private static JTextField textFieldAddress_AddPatientPanel;
	private JTextField textFieldEnterPatientID_PatientRecordPanel;
	private JTextField textFieldName_UpdatePatientPanel;
	private JTextField textFieldPhoneNO_UpdatePatientPanel;
	private JTextField textFieldAddress_UpdatePatientPanel;
	private JTextField textFieldEnterPatientID_UpdatePatientPanel;
	private JTextField textFieldName_DeletePatientPanel;
	private JTextField textFieldEnterPatientID_DeletePatientPanel;
	private JTextField textField_PhoneNO_DeletePatientPanel;
	private JTextField textFieldAddress_DeletePatientPanel;
	
	//JButton
	private JButton BtnAddPatient_AddPatientPanel;
	private JButton BtnEmptyField_AddPatientPanel;
	private JButton backBtn_AddPatientPanel;
	private JButton BtnNewID_AddPatientPanel;
	private JButton backBtn_PatientRecordPanel;
	private JButton btnSearch__PatientRecordPanel;
	private JButton BtnEmptyField_PatientRecordPanel;
	private JButton BtnUpdatePatient_UpdatePatientPanel;
	private JButton BtnEmptyField_UpdatePatientPanel;
	private JButton backBtn_UpdatePatientPanel;
	private JButton btnSearch_UpdatePatientPanel;
	private JButton backBtn_DeletePatientPanel;
	private JButton BtnDeletePatient_DeletePatientPanel;
	private JButton BtnEmptyField_DeletePatientPanel;
	private JButton btnSearch_DeletePatientPanel;
	
	//JDateChooser
	private JDateChooser PatientDateOfBirth_AddPatientPanel;
	private JDateChooser PatientDateOfBirth_UpdatePatientPanel;
	private JDateChooser PatientDateOfBirth_DeletePatientPanel;
	
	//JComboBox
	private static JComboBox comboBoxGender_AddPatientPanel;
	private JComboBox comboBoxGender_UpdatePatientPanel;
	private JComboBox comboBoxGender_DeletePatientPanel;
	
	//JScrollPane
	private JScrollPane scrollPane_PatientRecordPanel;
	
	//JSeparator
	private JSeparator separatorHorizontal;
	private JSeparator separatorVertical;
	
	/*End of Variables*/

	
	/*Panels*/	
	private JPanel panelCards;
	private JPanel panelCardMain;
	private JPanel panelPatientRecord;
	private JPanel panelAddPatient;
	private JPanel panelCardPatientRecord;
	private JPanel panelCardAddPatient;
	private JPanel panelPatientSearch_PatientRecordPanel;
	private JPanel panelDeletePatient;
	private JPanel panelUpdatePatient;
	private JPanel panelCardUpdatePatient;
	private JPanel panelPatientSearch_UpdatePatientPanel;	
	private JPanel panelCardDeletePatient;
	private JPanel panelPatientSearch_DeletePatientPanel;
	/*End Of Panels*/

	





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Receptionists_PatientsPage frame = new Receptionists_PatientsPage();
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
	public Receptionists_PatientsPage() {
		getContentPane().setBackground(Color.WHITE);
		setFocusable(false);
		setBorder(null);
		setBackground(Color.WHITE);
		setFrameIcon(null);
		setBounds(0, 0, 650, 522);
		getContentPane().setLayout(null);
		
		
		/*Cards Panel*/
		panelCards = new JPanel();
		panelCards.setBackground(Color.WHITE);
		panelCards.setBounds(0, 0, 650, 496);
		getContentPane().add(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		/*End Of Cards Panel*/

		
		/*Main Card Panel*/
		panelCardMain = new JPanel();
		panelCardMain.setBackground(Color.WHITE);
		panelCards.add(panelCardMain, PatientsMainPanel);
		panelCardMain.setLayout(null);
		/*End Of Main Card Panel*/

		
		/*Patient Record Panel*/
		panelPatientRecord = new JPanel();
		panelPatientRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Patients Record Card Panel When Mouse Clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, PatientsRecordPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelPatientRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelPatientRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelPatientRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelPatientRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelPatientRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPatientRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelPatientRecord.setBackground(Color.WHITE);
		panelPatientRecord.setBounds(387, 278, 180, 167);
		panelCardMain.add(panelPatientRecord);
		panelPatientRecord.setLayout(null);
		/*End Of Patient Record Panel*/
		
		
		/*Patients Record Label*/
		labelPatientsRecord = new JLabel("Patients Record");
		labelPatientsRecord.setForeground(Color.BLACK);
		labelPatientsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelPatientsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelPatientsRecord.setBounds(10, 64, 160, 35);
		panelPatientRecord.add(labelPatientsRecord);
		/*End Of Patients Record Label*/
		
		
		/*Add Patient Panel*/
		panelAddPatient = new JPanel();
		panelAddPatient.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Add Patient Card Panel When Mouse Clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AddPatientPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddPatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAddPatient.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddPatient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAddPatient.setBackground(new Color(216, 191, 216));
			}
		});
		panelAddPatient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAddPatient.setLayout(null);
		panelAddPatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAddPatient.setBackground(Color.WHITE);
		panelAddPatient.setBounds(78, 47, 180, 167);
		panelCardMain.add(panelAddPatient);
		/*End Of Add Patient Panel*/
		
		
		/*Add Patient Label*/
		labelAddPatient = new JLabel("Add Patient");
		labelAddPatient.setForeground(Color.BLACK);
		labelAddPatient.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddPatient.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddPatient.setBounds(10, 64, 160, 35);
		panelAddPatient.add(labelAddPatient);
		/*End Of Add Patient Label*/

		
		/*Patient Record Card Panel*/
		panelCardPatientRecord = new JPanel();
		panelCardPatientRecord.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
	            // show database data to table
				ShowDatatBaseDataToTable();
			}
		});
		panelCardPatientRecord.setBackground(Color.WHITE);
		panelCards.add(panelCardPatientRecord, PatientsRecordPanel);
		panelCardPatientRecord.setLayout(null);
		/*End Of Patient Record Card Panel*/
		  
	 	
		/*Back Button PatientRecordPanel*/
		backBtn_PatientRecordPanel = new JButton();
		backBtn_PatientRecordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_PatientRecordPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Back to main card panel
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, PatientsMainPanel);
                
				// Clear all fields 
				textFieldEnterPatientID_PatientRecordPanel.setText(null);
			}
		});
		backBtn_PatientRecordPanel.setText("Back");
		backBtn_PatientRecordPanel.setForeground(Color.WHITE);
		backBtn_PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_PatientRecordPanel.setFocusable(false);
		backBtn_PatientRecordPanel.setBackground(new Color(204, 0, 0));
		backBtn_PatientRecordPanel.setBounds(223, 425, 105, 35);
		panelCardPatientRecord.add(backBtn_PatientRecordPanel);
		/*End Of Back Button PatientRecordPanel*/

		
		/*Add Patient Card Panel*/
		panelCardAddPatient = new JPanel();
		panelCardAddPatient.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// When the page open new Patient ID created
				RandomPatientID();
			}
		});
		panelCardAddPatient.setLayout(null);
		panelCardAddPatient.setBackground(Color.WHITE);
		panelCards.add(panelCardAddPatient, AddPatientPanel);
		/*End Of Add Patient Card Panel*/

		
		/*Back Button AddPatientPanel*/
		backBtn_AddPatientPanel = new JButton();
		backBtn_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_AddPatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Back to main card panel
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, PatientsMainPanel);

				
				// Clear all fields 
				clearButtonAddPatientPanel();
				// New ID number
				RandomPatientID();	
			}
		});
		backBtn_AddPatientPanel.setText("Back");
		backBtn_AddPatientPanel.setForeground(Color.WHITE);
		backBtn_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_AddPatientPanel.setFocusable(false);
		backBtn_AddPatientPanel.setBackground(new Color(204, 0, 0));
		backBtn_AddPatientPanel.setBounds(153, 405, 105, 35);
		panelCardAddPatient.add(backBtn_AddPatientPanel);
		/*End Of Back Button AddPatientPanel*/

		
	    /*Add cards to panel card*/
		panelCards.add(panelCardMain, PatientsMainPanel);
	    /*End Of Add cards to panel card*/

		
	    /*Separator Horizontal*/
		separatorHorizontal = new JSeparator();
		separatorHorizontal.setBorder(null);
		separatorHorizontal.setForeground(new Color(216, 191, 216));
		separatorHorizontal.setBackground(new Color(102, 51, 153));
		separatorHorizontal.setBounds(154, 243, 343, 2);
		panelCardMain.add(separatorHorizontal);
	    /*End Of Separator Horizontal*/

	    /*Separator Vertical*/		
		separatorVertical = new JSeparator();
		separatorVertical.setBorder(null);
		separatorVertical.setOrientation(SwingConstants.VERTICAL);
		separatorVertical.setForeground(new Color(216, 191, 216));
		separatorVertical.setBackground(new Color(102, 51, 153));
		separatorVertical.setBounds(322, 80, 2, 343);
		panelCardMain.add(separatorVertical);
	    /*End Of Separator Vertical*/

		
	    /*Delete Patient Panel*/
		panelDeletePatient = new JPanel();
		panelDeletePatient.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Delete Patient Card Panel When Mouse Clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DeletePatientPanel);	
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeletePatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDeletePatient.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeletePatient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDeletePatient.setBackground(new Color(216, 191, 216));
			}
		});
		panelDeletePatient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDeletePatient.setLayout(null);
		panelDeletePatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDeletePatient.setBackground(Color.WHITE);
		panelDeletePatient.setBounds(78, 278, 180, 167);
		panelCardMain.add(panelDeletePatient);
	    /*End Of Delete Patient Panel*/
		
		
	    /*Delete Patient Label panelDeletePatient*/
		lblDeletePatient = new JLabel("Delete Patient");
		lblDeletePatient.setForeground(Color.BLACK);
		lblDeletePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletePatient.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeletePatient.setBounds(10, 64, 160, 35);
		panelDeletePatient.add(lblDeletePatient);
	    /*End Of Delete Patient LabelpanelDeletePatient*/

		
	    /*Update Patient Panel*/
		panelUpdatePatient = new JPanel();
		panelUpdatePatient.addMouseListener(new MouseAdapter() {

			    /*
			     * Show Update Patient Card Panel When Mouse Clicked
			     */
				@Override
				public void mouseClicked(MouseEvent e) {
					CardLayout cl = (CardLayout) (panelCards.getLayout());
					cl.show(panelCards, UpdatePatientPanel);
				}
				
				/*
				 * Change Panel Color When Mouse Exited Panel
				 */
				@Override
				public void mouseExited(MouseEvent e) {
					panelUpdatePatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
					panelUpdatePatient.setBackground(Color.WHITE);
				}
				
				/*
				 * Change Panel Color When Mouse Entered Panel
				 */
				@Override
				public void mouseEntered(MouseEvent e) {
					panelUpdatePatient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					panelUpdatePatient.setBackground(new Color(216, 191, 216));
				}
			
			
		});
		panelUpdatePatient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUpdatePatient.setLayout(null);
		panelUpdatePatient.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelUpdatePatient.setBackground(Color.WHITE);
		panelUpdatePatient.setBounds(387, 47, 180, 167);
		panelCardMain.add(panelUpdatePatient);
	    /*End Of Update Patient Panel*/

		
	    /*Update Patient Label panelUpdatePatien*/
		lblUpdatePatient = new JLabel("Update Patient");
		lblUpdatePatient.setForeground(Color.BLACK);
		lblUpdatePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePatient.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdatePatient.setBounds(10, 64, 160, 35);
		panelUpdatePatient.add(lblUpdatePatient);
		panelCards.add(panelCardPatientRecord, PatientsRecordPanel);
	    /*End Of Update Patient Label panelUpdatePatient*/

		
		/*ScrollPane PatientRecordPanel*/
		scrollPane_PatientRecordPanel = new JScrollPane();
		scrollPane_PatientRecordPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_PatientRecordPanel.setBounds(45, 71, 553, 138);
		panelCardPatientRecord.add(scrollPane_PatientRecordPanel);
		/*End Of ScrollPane PatientRecordPanel*/
		
		
		/*Table ScrollPane PatientRecordPanel*/
		table = new JTable();
		scrollPane_PatientRecordPanel.setViewportView(table);
		/*End of Table ScrollPane PatientRecordPanel*/

		
		/*Patient Search Panel PatientRecordPanel*/
		panelPatientSearch_PatientRecordPanel = new JPanel();
		panelPatientSearch_PatientRecordPanel.setLayout(null);
		panelPatientSearch_PatientRecordPanel.setBackground(new Color(102, 51, 153));
		panelPatientSearch_PatientRecordPanel.setBounds(45, 221, 553, 144);
		panelCardPatientRecord.add(panelPatientSearch_PatientRecordPanel);
		/*End Of Patient Search Panel PatientRecordPanel*/

		
		/*Patient Search Label PatientRecordPanel*/
		lblPatientSearch__PatientRecordPanel = new JLabel("Patient Search");
		lblPatientSearch__PatientRecordPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearch__PatientRecordPanel.setForeground(Color.WHITE);
		lblPatientSearch__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientSearch__PatientRecordPanel.setFocusable(false);
		lblPatientSearch__PatientRecordPanel.setBorder(null);
		lblPatientSearch__PatientRecordPanel.setBounds(185, 11, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(lblPatientSearch__PatientRecordPanel);
		/*End Of Patient Search Label PatientRecordPanel*/

		
		/*Search Button PatientRecordPanel*/
		btnSearch__PatientRecordPanel = new JButton();
		btnSearch__PatientRecordPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Search Patient
				 */
				
								
				//check if enter patient ID field is empty 
				if(textFieldEnterPatientID_PatientRecordPanel.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
				
				// else continue after "check if enter patient ID field is empty "
				else          
				{
					Connection connection = ConnectionFactory.getConnection();
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
						preparedatatement.setString(1, textFieldEnterPatientID_PatientRecordPanel.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if patient ID correct
						if(resultset.next())
						{
							//Data from database to table
						ResultSet resaultsetData = preparedatatement.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(resaultsetData));
						
						// Close database
						preparedatatement.close();
						}
						
						// if patient ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! patient ID not exist, please enter the right patient ID");}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 


				}
				
				
			
			}
		});
		btnSearch__PatientRecordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch__PatientRecordPanel.setText("Search");
		btnSearch__PatientRecordPanel.setForeground(Color.WHITE);
		btnSearch__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch__PatientRecordPanel.setFocusable(false);
		btnSearch__PatientRecordPanel.setBackground(new Color(102, 51, 153));
		btnSearch__PatientRecordPanel.setBounds(426, 65, 117, 35);
		panelPatientSearch_PatientRecordPanel.add(btnSearch__PatientRecordPanel);
		/*End Of Search Button PatientRecordPanel*/

		
		/*Patient search EnterID Label PatientRecordPanel*/
		lblPatientSearchEnterID__PatientRecordPanel = new JLabel("Enter Patient ID");
		lblPatientSearchEnterID__PatientRecordPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearchEnterID__PatientRecordPanel.setForeground(Color.WHITE);
		lblPatientSearchEnterID__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 15));
		lblPatientSearchEnterID__PatientRecordPanel.setFocusable(false);
		lblPatientSearchEnterID__PatientRecordPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblPatientSearchEnterID__PatientRecordPanel.setBounds(10, 65, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(lblPatientSearchEnterID__PatientRecordPanel);
		/*End Of Patient search EnterID Label PatientRecordPanel*/

		
		/*Enter Patient ID textField PatientRecordPanel*/
		textFieldEnterPatientID_PatientRecordPanel = new JTextField();
		textFieldEnterPatientID_PatientRecordPanel.setToolTipText("Patient ID");
		textFieldEnterPatientID_PatientRecordPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterPatientID_PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterPatientID_PatientRecordPanel.setColumns(10);
		textFieldEnterPatientID_PatientRecordPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterPatientID_PatientRecordPanel.setBounds(217, 65, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(textFieldEnterPatientID_PatientRecordPanel);
		/*End of Enter Patient ID textField PatientRecordPanel*/

		
		/*Empty Field Button PatientRecordPanel*/
		BtnEmptyField_PatientRecordPanel = new JButton();
		BtnEmptyField_PatientRecordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnEmptyField_PatientRecordPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Clear all fields 
				textFieldEnterPatientID_PatientRecordPanel.setText(null);
			
				// show database data to table
				ShowDatatBaseDataToTable();	
			}
		});
		BtnEmptyField_PatientRecordPanel.setText("Clear");
		BtnEmptyField_PatientRecordPanel.setForeground(Color.WHITE);
		BtnEmptyField_PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnEmptyField_PatientRecordPanel.setFocusable(false);
		BtnEmptyField_PatientRecordPanel.setBackground(new Color(46, 139, 87));
		BtnEmptyField_PatientRecordPanel.setBounds(338, 425, 105, 35);
		panelCardPatientRecord.add(BtnEmptyField_PatientRecordPanel);
		/*End Of Empty Field Button PatientRecordPanel*/

		
		/*Patients Record Title Label PatientRecordPanel*/
		lblPatientsRecordTitle_PatientRecordPanel = new JLabel("Patients Record Page");
		lblPatientsRecordTitle_PatientRecordPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientsRecordTitle_PatientRecordPanel.setForeground(Color.BLACK);
		lblPatientsRecordTitle_PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientsRecordTitle_PatientRecordPanel.setFocusable(false);
		lblPatientsRecordTitle_PatientRecordPanel.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblPatientsRecordTitle_PatientRecordPanel.setBounds(168, 0, 317, 36);
		panelCardPatientRecord.add(lblPatientsRecordTitle_PatientRecordPanel);
		/*End Of Patients Record Title Label PatientRecordPanel*/

		
		panelCards.add(panelCardAddPatient, AddPatientPanel);
		
		
		/*Patient Name Label AddPatientPanel*/
		lblPatientName_AddPatientPanel = new JLabel("Name");
		lblPatientName_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientName_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientName_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientName_AddPatientPanel.setFocusable(false);
		lblPatientName_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientName_AddPatientPanel.setBounds(140, 133, 171, 36);
		panelCardAddPatient.add(lblPatientName_AddPatientPanel);
		/*End Of Patient Name Label AddPatientPanel*/

		
		/*Patient Contact NO Label AddPatientPanel*/
		lblPatientContactNO_AddPatientPanel = new JLabel("Phone NO.");
		lblPatientContactNO_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientContactNO_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientContactNO_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientContactNO_AddPatientPanel.setFocusable(false);
		lblPatientContactNO_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientContactNO_AddPatientPanel.setBounds(140, 180, 171, 36);
		panelCardAddPatient.add(lblPatientContactNO_AddPatientPanel);
		/*End Of Patient Contact NO Label AddPatientPanel*/

		
		/*Patient Name textField AddPatientPanel*/
		textFieldPatientName_AddPatientPanel = new JTextField();
		textFieldPatientName_AddPatientPanel.setToolTipText("Name");
		textFieldPatientName_AddPatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientName_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientName_AddPatientPanel.setColumns(10);
		textFieldPatientName_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientName_AddPatientPanel.setBounds(329, 134, 171, 36);
		panelCardAddPatient.add(textFieldPatientName_AddPatientPanel);
		/*End Of Patient Name textField AddPatientPanel*/

		
		/*Patient Address Label AddPatientPanel*/
		lblPatientAddress_AddPatientPanel = new JLabel("Address");
		lblPatientAddress_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientAddress_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientAddress_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientAddress_AddPatientPanel.setFocusable(false);
		lblPatientAddress_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientAddress_AddPatientPanel.setBounds(140, 231, 171, 36);
		panelCardAddPatient.add(lblPatientAddress_AddPatientPanel);
		/*End Of Patient Address Label AddPatientPanel*/

		
		/*Patient Gender Label AddPatientPanel*/
		lblPatientGender_AddPatientPanel = new JLabel("Gender");
		lblPatientGender_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientGender_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientGender_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientGender_AddPatientPanel.setFocusable(false);
		lblPatientGender_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientGender_AddPatientPanel.setBounds(140, 278, 171, 36);
		panelCardAddPatient.add(lblPatientGender_AddPatientPanel);
		/*End Of Patient Gender Label AddPatientPanel*/

		
		/*Patient ID Label AddPatientPanel*/
		lblPatientID_AddPatientPanel = new JLabel("Patient ID");
		lblPatientID_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientID_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_AddPatientPanel.setFocusable(false);
		lblPatientID_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_AddPatientPanel.setBounds(140, 86, 171, 36);
		panelCardAddPatient.add(lblPatientID_AddPatientPanel);
		/*End Of Patient ID Label AddPatientPanel*/

		
		/*Patient Date Of Birth Label AddPatientPanel*/
		lblPatientDateOfBirth_AddPatientPanel = new JLabel("Date Of Birth");
		lblPatientDateOfBirth_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientDateOfBirth_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientDateOfBirth_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientDateOfBirth_AddPatientPanel.setFocusable(false);
		lblPatientDateOfBirth_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientDateOfBirth_AddPatientPanel.setBounds(140, 325, 171, 36);
		panelCardAddPatient.add(lblPatientDateOfBirth_AddPatientPanel);
		/*End Of Date Of Birth Label AddPatientPanel*/

		
		/*Patient ID 2 Label AddPatientPanel*/
		lblPatientID2_AddPatientPanel = new JLabel("");
		lblPatientID2_AddPatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientID2_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		lblPatientID2_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID2_AddPatientPanel.setForeground(Color.BLACK);
		lblPatientID2_AddPatientPanel.setBounds(329, 86, 91, 37);
		lblPatientID2_AddPatientPanel.setBackground(new Color(102, 51, 153));
		panelCardAddPatient.add(lblPatientID2_AddPatientPanel);
		/*End Of Patient ID 2 Label AddPatientPanel*/

		
		/*Contact NO textField AddPatientPanel*/
		textFieldContactNO_AddPatientPanel = new JTextField();
		textFieldContactNO_AddPatientPanel.setToolTipText("Phone NO.");
		textFieldContactNO_AddPatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldContactNO_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldContactNO_AddPatientPanel.setColumns(10);
		textFieldContactNO_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldContactNO_AddPatientPanel.setBounds(329, 180, 171, 36);
		panelCardAddPatient.add(textFieldContactNO_AddPatientPanel);
		/*End Of Contact NO textField AddPatientPanel*/

		
		/*Address textField AddPatientPanel*/
		textFieldAddress_AddPatientPanel = new JTextField();
		textFieldAddress_AddPatientPanel.setToolTipText("Address");
		textFieldAddress_AddPatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAddress_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldAddress_AddPatientPanel.setColumns(10);
		textFieldAddress_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldAddress_AddPatientPanel.setBounds(329, 231, 171, 36);
		panelCardAddPatient.add(textFieldAddress_AddPatientPanel);
		/*End Of Address textField AddPatientPanel*/

		
		/*Gender comboBox AddPatientPanel*/
		comboBoxGender_AddPatientPanel = new JComboBox();
		comboBoxGender_AddPatientPanel.setToolTipText("Gender");
		comboBoxGender_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_AddPatientPanel.setFocusable(false);
		comboBoxGender_AddPatientPanel.setModel(new DefaultComboBoxModel(new String[] {"Choose Gender", "Male", "Female"}));
		comboBoxGender_AddPatientPanel.setBackground(Color.WHITE);
		comboBoxGender_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_AddPatientPanel.setBounds(329, 278, 171, 36);
		panelCardAddPatient.add(comboBoxGender_AddPatientPanel);
		/*End Of Gender comboBox AddPatientPanel*/

		
		/*Patient Date Of Birth JDateChooser AddPatientPanel*/
		PatientDateOfBirth_AddPatientPanel = new JDateChooser();
		PatientDateOfBirth_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatientDateOfBirth_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		PatientDateOfBirth_AddPatientPanel.setBounds(329, 325, 171, 36);
		panelCardAddPatient.add(PatientDateOfBirth_AddPatientPanel);
		/*End Of Patient Date Of Birth JDateChooser AddPatientPanel*/

		
		/*Add Patient Button AddPatientPanel*/
		BtnAddPatient_AddPatientPanel = new JButton();
		BtnAddPatient_AddPatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Add New Patient
				 */
				
				
				//check if there any empty spaces
				if(lblPatientID2_AddPatientPanel.getText().isEmpty() || textFieldPatientName_AddPatientPanel.getText().isEmpty() || 
				   textFieldContactNO_AddPatientPanel.getText().isEmpty() || textFieldAddress_AddPatientPanel.getText().isEmpty() ||
				   comboBoxGender_AddPatientPanel.getSelectedIndex()==0 || PatientDateOfBirth_AddPatientPanel.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no number Entered in Name Field
					if(textFieldPatientName_AddPatientPanel.getText().contains("0") || textFieldPatientName_AddPatientPanel.getText().contains("1") ||
					   textFieldPatientName_AddPatientPanel.getText().contains("2") || textFieldPatientName_AddPatientPanel.getText().contains("3") ||
					   textFieldPatientName_AddPatientPanel.getText().contains("4") || textFieldPatientName_AddPatientPanel.getText().contains("5") ||
					   textFieldPatientName_AddPatientPanel.getText().contains("6") || textFieldPatientName_AddPatientPanel.getText().contains("7") ||
					   textFieldPatientName_AddPatientPanel.getText().contains("8") || textFieldPatientName_AddPatientPanel.getText().contains("9")  )
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name field"); }
					
					//else continue after "check no number Entered in Name Field"
					else               
					{
						//check no string Entered in Contact NO. Field
						if((textFieldContactNO_AddPatientPanel.getText().contains("a") || textFieldContactNO_AddPatientPanel.getText().contains("b") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("c") || textFieldContactNO_AddPatientPanel.getText().contains("d") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("e") || textFieldContactNO_AddPatientPanel.getText().contains("f") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("g") || textFieldContactNO_AddPatientPanel.getText().contains("h") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("i") || textFieldContactNO_AddPatientPanel.getText().contains("j") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("k") || textFieldContactNO_AddPatientPanel.getText().contains("l") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("m") || textFieldContactNO_AddPatientPanel.getText().contains("n") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("o") || textFieldContactNO_AddPatientPanel.getText().contains("p") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("q") || textFieldContactNO_AddPatientPanel.getText().contains("r") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("s") || textFieldContactNO_AddPatientPanel.getText().contains("t") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("u") || textFieldContactNO_AddPatientPanel.getText().contains("v") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("w") || textFieldContactNO_AddPatientPanel.getText().contains("x") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("y") || textFieldContactNO_AddPatientPanel.getText().contains("z") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("A") || textFieldContactNO_AddPatientPanel.getText().contains("B") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("C") || textFieldContactNO_AddPatientPanel.getText().contains("D") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("E") || textFieldContactNO_AddPatientPanel.getText().contains("F") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("G") || textFieldContactNO_AddPatientPanel.getText().contains("H") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("I") || textFieldContactNO_AddPatientPanel.getText().contains("J") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("K") || textFieldContactNO_AddPatientPanel.getText().contains("L") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("M") || textFieldContactNO_AddPatientPanel.getText().contains("N") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("O") || textFieldContactNO_AddPatientPanel.getText().contains("P") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("Q") || textFieldContactNO_AddPatientPanel.getText().contains("R") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("S") || textFieldContactNO_AddPatientPanel.getText().contains("T") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("U") || textFieldContactNO_AddPatientPanel.getText().contains("V") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("W") || textFieldContactNO_AddPatientPanel.getText().contains("X") ||
								   textFieldContactNO_AddPatientPanel.getText().contains("Y") || textFieldContactNO_AddPatientPanel.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in contact NO field"); }
						
						//else continue after "check no string Entered in Contact NO. Field"
						else          
						{
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
							String DofB              = dFormat.format(PatientDateOfBirth_AddPatientPanel.getDate());
							// End date to string

							// text to integer
							int PhoneNO = Integer.parseInt(textFieldContactNO_AddPatientPanel.getText()); 
							// End text to integer
							
							// Set data to "PatientsDTO" object
							PatientsDTO patientDTO = new PatientsDTO();
							patientDTO.setPatientID(lblPatientID2_AddPatientPanel.getText());
							patientDTO.setName(textFieldPatientName_AddPatientPanel.getText());
							patientDTO.setGender((String) comboBoxGender_AddPatientPanel.getSelectedItem());
							patientDTO.setBirthday(DofB);
							patientDTO.setPhoneNO(PhoneNO);
							patientDTO.setAddress(textFieldAddress_AddPatientPanel.getText());
							patientDTO.setAdded_By(receptionistName);
							// End of Set data to "PatientsDTO" object

							// Send data to "addPatientDAO" method
							new PatientsDAO().addPatientDAO(patientDTO);
							// End of Send data to "addPatientDAO" method

						}
					}		
				}
			}
		});
		BtnAddPatient_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnAddPatient_AddPatientPanel.setText("Add");
		BtnAddPatient_AddPatientPanel.setForeground(Color.WHITE);
		BtnAddPatient_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnAddPatient_AddPatientPanel.setFocusable(false);
		BtnAddPatient_AddPatientPanel.setBackground(new Color(102, 51, 153));
		BtnAddPatient_AddPatientPanel.setBounds(383, 405, 105, 35);
		panelCardAddPatient.add(BtnAddPatient_AddPatientPanel);
		/*End of Add Patient Button AddPatientPanel*/

		
		/*Empty Field Button AddPatientPanel*/
		BtnEmptyField_AddPatientPanel = new JButton();
		BtnEmptyField_AddPatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear all fields 
				clearButtonAddPatientPanel();
				// new ID number
				RandomPatientID();	
			}
		});
		BtnEmptyField_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnEmptyField_AddPatientPanel.setText("Clear");
		BtnEmptyField_AddPatientPanel.setForeground(Color.WHITE);
		BtnEmptyField_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnEmptyField_AddPatientPanel.setFocusable(false);
		BtnEmptyField_AddPatientPanel.setBackground(new Color(46, 139, 87));
		BtnEmptyField_AddPatientPanel.setBounds(268, 405, 105, 35);
		panelCardAddPatient.add(BtnEmptyField_AddPatientPanel);
		/*End Of Empty Field Button AddPatientPanel*/

		
		/*New ID Button AddPatientPanel*/
		BtnNewID_AddPatientPanel = new JButton();
		BtnNewID_AddPatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewID_AddPatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// New ID Number
				RandomPatientID();
				
			}
		});
		BtnNewID_AddPatientPanel.setText("New ID");
		BtnNewID_AddPatientPanel.setForeground(Color.WHITE);
		BtnNewID_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewID_AddPatientPanel.setFocusable(false);
		BtnNewID_AddPatientPanel.setBackground(new Color(102, 51, 153));
		BtnNewID_AddPatientPanel.setBounds(422, 86, 78, 35);
		panelCardAddPatient.add(BtnNewID_AddPatientPanel);
		/*End Of New ID Button AddPatientPanel*/

		
		/*Add Patient Title Label AddPatientPanel*/
		lblAddPatientTitle_AddPatientPanel = new JLabel("Add Patient Page");
		lblAddPatientTitle_AddPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPatientTitle_AddPatientPanel.setForeground(Color.BLACK);
		lblAddPatientTitle_AddPatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAddPatientTitle_AddPatientPanel.setFocusable(false);
		lblAddPatientTitle_AddPatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAddPatientTitle_AddPatientPanel.setBounds(168, 0, 317, 36);
		panelCardAddPatient.add(lblAddPatientTitle_AddPatientPanel);
		/*End Of Add Patient Title Label AddPatientPanel*/

		
		/*Update Patient Card Panel*/
		panelCardUpdatePatient = new JPanel();
		panelCardUpdatePatient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelCardUpdatePatient.setLayout(null);
		panelCardUpdatePatient.setBackground(Color.WHITE);
		panelCards.add(panelCardUpdatePatient, UpdatePatientPanel);
		/*End Of Update Patient Card Panel*/

		
		/*Back Button UpdatePatientPanel*/
		backBtn_UpdatePatientPanel = new JButton();
		backBtn_UpdatePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Back to main card panel
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, PatientsMainPanel);

				// Clear all fields 
				clearButtonUpdatePatientPanel();
			}
		});
		backBtn_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_UpdatePatientPanel.setText("Back");
		backBtn_UpdatePatientPanel.setForeground(Color.WHITE);
		backBtn_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_UpdatePatientPanel.setFocusable(false);
		backBtn_UpdatePatientPanel.setBackground(new Color(204, 0, 0));
		backBtn_UpdatePatientPanel.setBounds(146, 406, 105, 35);
		panelCardUpdatePatient.add(backBtn_UpdatePatientPanel);
		/*End Of Back Button UpdatePatientPanel*/

		
		/*Patient Name Label UpdatePatientPanel*/
		lblPatientName_UpdatePatientPanel = new JLabel("Name");
		lblPatientName_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientName_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientName_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientName_UpdatePatientPanel.setFocusable(false);
		lblPatientName_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientName_UpdatePatientPanel.setBounds(22, 135, 171, 36);
		panelCardUpdatePatient.add(lblPatientName_UpdatePatientPanel);
		/*End Of Patient Name Label UpdatePatientPanel*/

		
		/*Patient Contact NO Label UpdatePatientPanel*/
		lblPatientContactNO_UpdatePatientPanel = new JLabel("Phone NO.");
		lblPatientContactNO_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientContactNO_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientContactNO_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientContactNO_UpdatePatientPanel.setFocusable(false);
		lblPatientContactNO_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientContactNO_UpdatePatientPanel.setBounds(22, 182, 171, 36);
		panelCardUpdatePatient.add(lblPatientContactNO_UpdatePatientPanel);
		/*End Of Patient Contact NO Label UpdatePatientPanel*/

		
		/*Name text Field UpdatePatientPanel*/
		textFieldName_UpdatePatientPanel = new JTextField();
		textFieldName_UpdatePatientPanel.setToolTipText("Name");
		textFieldName_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldName_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldName_UpdatePatientPanel.setColumns(10);
		textFieldName_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldName_UpdatePatientPanel.setBounds(203, 136, 171, 36);
		panelCardUpdatePatient.add(textFieldName_UpdatePatientPanel);
		/*End Of Name text Field UpdatePatientPanel*/

		
		/*Patient Address Label UpdatePatientPanel*/
		lblPatientAddress_UpdatePatientPanel = new JLabel("Address");
		lblPatientAddress_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientAddress_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientAddress_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientAddress_UpdatePatientPanel.setFocusable(false);
		lblPatientAddress_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientAddress_UpdatePatientPanel.setBounds(22, 233, 171, 36);
		panelCardUpdatePatient.add(lblPatientAddress_UpdatePatientPanel);
		/*End Of Patient Address Label UpdatePatientPanel*/

		
		/*Patient Gender Label UpdatePatientPanel*/
		lblPatientGender_UpdatePatientPanel = new JLabel("Gender");
		lblPatientGender_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientGender_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientGender_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientGender_UpdatePatientPanel.setFocusable(false);
		lblPatientGender_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientGender_UpdatePatientPanel.setBounds(22, 280, 171, 36);
		panelCardUpdatePatient.add(lblPatientGender_UpdatePatientPanel);
		/*End Of Patient Gender Label UpdatePatientPanel*/

		
		/*Patient ID Label UpdatePatientPanel*/
		lblPatientID_UpdatePatientPanel = new JLabel("Patient ID");
		lblPatientID_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientID_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_UpdatePatientPanel.setFocusable(false);
		lblPatientID_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_UpdatePatientPanel.setBounds(22, 88, 171, 36);
		panelCardUpdatePatient.add(lblPatientID_UpdatePatientPanel);
		/*End Of Patient ID Label UpdatePatientPanel*/

		
		/*Patient Date Of Birth Label UpdatePatientPanel*/
		lblPatientDateOfBirth_UpdatePatientPanel = new JLabel("Date Of Birth");
		lblPatientDateOfBirth_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientDateOfBirth_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientDateOfBirth_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientDateOfBirth_UpdatePatientPanel.setFocusable(false);
		lblPatientDateOfBirth_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientDateOfBirth_UpdatePatientPanel.setBounds(22, 327, 171, 36);
		panelCardUpdatePatient.add(lblPatientDateOfBirth_UpdatePatientPanel);
		/*End Of Patient Date Of Birth Label UpdatePatientPanel*/

		
		/*Patient Search Panel UpdatePatientPanel*/
		panelPatientSearch_UpdatePatientPanel = new JPanel();
		panelPatientSearch_UpdatePatientPanel.setLayout(null);
		panelPatientSearch_UpdatePatientPanel.setBackground(new Color(102, 51, 153));
		panelPatientSearch_UpdatePatientPanel.setBounds(427, 88, 200, 275);
		panelCardUpdatePatient.add(panelPatientSearch_UpdatePatientPanel);
		/*End Of Patient Search Panel UpdatePatientPanel*/

		
		/*Patient Search Label UpdatePatientPanel*/
		lblPatientSearch_UpdatePatientPanel = new JLabel("Patient Search");
		lblPatientSearch_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearch_UpdatePatientPanel.setForeground(Color.WHITE);
		lblPatientSearch_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientSearch_UpdatePatientPanel.setFocusable(false);
		lblPatientSearch_UpdatePatientPanel.setBorder(null);
		lblPatientSearch_UpdatePatientPanel.setBounds(10, 11, 180, 36);
		panelPatientSearch_UpdatePatientPanel.add(lblPatientSearch_UpdatePatientPanel);
		/*End Of Patient Search Label UpdatePatientPanel*/

		
		/*Button Search UpdatePatientPanel*/
		btnSearch_UpdatePatientPanel = new JButton();
		btnSearch_UpdatePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Search Patient
				 */
				
								
				//check if enter patient ID field is empty 
				if(textFieldEnterPatientID_UpdatePatientPanel.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
				
				// else continue after "check if enter patient ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
			    		preparedstatement.setString(1, textFieldEnterPatientID_UpdatePatientPanel.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if patient ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(6));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(5);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								PatientDateOfBirth_UpdatePatientPanel.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblPatientID2_UpdatePatientPanel.setText(resultset.getString(2));
							textFieldName_UpdatePatientPanel.setText(resultset.getString(3));
							textFieldPhoneNO_UpdatePatientPanel.setText(phoneNO);
							textFieldAddress_UpdatePatientPanel.setText(resultset.getString(7));
							comboBoxGender_UpdatePatientPanel.setSelectedItem(resultset.getString(4));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if patient ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! patient ID not exist, please enter the right patient ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			
			}
		});
		btnSearch_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_UpdatePatientPanel.setText("Search");
		btnSearch_UpdatePatientPanel.setForeground(Color.WHITE);
		btnSearch_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_UpdatePatientPanel.setFocusable(false);
		btnSearch_UpdatePatientPanel.setBackground(new Color(102, 51, 153));
		btnSearch_UpdatePatientPanel.setBounds(10, 229, 180, 35);
		panelPatientSearch_UpdatePatientPanel.add(btnSearch_UpdatePatientPanel);
		/*End Of Button Search UpdatePatientPanel*/

		
		/*Patient Search Enter ID Label UpdatePatientPanel*/
		lblPatientSearchEnterID_UpdatePatientPanel = new JLabel("Enter Patient ID");
		lblPatientSearchEnterID_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearchEnterID_UpdatePatientPanel.setForeground(Color.WHITE);
		lblPatientSearchEnterID_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 15));
		lblPatientSearchEnterID_UpdatePatientPanel.setFocusable(false);
		lblPatientSearchEnterID_UpdatePatientPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblPatientSearchEnterID_UpdatePatientPanel.setBounds(10, 79, 180, 36);
		panelPatientSearch_UpdatePatientPanel.add(lblPatientSearchEnterID_UpdatePatientPanel);
		/*End Of Patient Search Enter ID Label UpdatePatientPanel*/

		
		/*Enter Patient ID text Field UpdatePatientPanel*/
		textFieldEnterPatientID_UpdatePatientPanel = new JTextField();
		textFieldEnterPatientID_UpdatePatientPanel.setToolTipText("Patient ID");
		textFieldEnterPatientID_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterPatientID_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterPatientID_UpdatePatientPanel.setColumns(10);
		textFieldEnterPatientID_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterPatientID_UpdatePatientPanel.setBounds(10, 159, 180, 36);
		panelPatientSearch_UpdatePatientPanel.add(textFieldEnterPatientID_UpdatePatientPanel);
		/*End Of Enter Patient ID text Field UpdatePatientPanel*/

		
		/*Patient ID 2 Label UpdatePatientPanel*/
		lblPatientID2_UpdatePatientPanel = new JLabel("");
		lblPatientID2_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientID2_UpdatePatientPanel.setForeground(Color.BLACK);
		lblPatientID2_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		lblPatientID2_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID2_UpdatePatientPanel.setBackground(new Color(102, 51, 153));
		lblPatientID2_UpdatePatientPanel.setBounds(203, 88, 171, 37);
		panelCardUpdatePatient.add(lblPatientID2_UpdatePatientPanel);
		/*End Of Patient ID 2 Label UpdatePatientPanel*/

		
		/*Phone NO text Field UpdatePatientPanel*/
		textFieldPhoneNO_UpdatePatientPanel = new JTextField();
		textFieldPhoneNO_UpdatePatientPanel.setToolTipText("Phone NO.");
		textFieldPhoneNO_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPhoneNO_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPhoneNO_UpdatePatientPanel.setColumns(10);
		textFieldPhoneNO_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPhoneNO_UpdatePatientPanel.setBounds(203, 182, 171, 36);
		panelCardUpdatePatient.add(textFieldPhoneNO_UpdatePatientPanel);
		/*End Of Phone NO text Field UpdatePatientPanel*/

		
		/*Address text Field UpdatePatientPanel*/
		textFieldAddress_UpdatePatientPanel = new JTextField();
		textFieldAddress_UpdatePatientPanel.setToolTipText("Address");
		textFieldAddress_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAddress_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldAddress_UpdatePatientPanel.setColumns(10);
		textFieldAddress_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldAddress_UpdatePatientPanel.setBounds(203, 233, 171, 36);
		panelCardUpdatePatient.add(textFieldAddress_UpdatePatientPanel);
		/*End Of Address text Field UpdatePatientPanel*/

		
		/*Gender comboBox UpdatePatientPanel*/
		comboBoxGender_UpdatePatientPanel = new JComboBox();
		comboBoxGender_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_UpdatePatientPanel.setModel(new DefaultComboBoxModel(new String[] {"Choose Gender", "Male", "Female"}));
		comboBoxGender_UpdatePatientPanel.setToolTipText("Gender");
		comboBoxGender_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_UpdatePatientPanel.setFocusable(false);
		comboBoxGender_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_UpdatePatientPanel.setBackground(Color.WHITE);
		comboBoxGender_UpdatePatientPanel.setBounds(203, 280, 171, 36);
		panelCardUpdatePatient.add(comboBoxGender_UpdatePatientPanel);
		/*End Of Gender comboBox UpdatePatientPanel*/

		
		/*Patient date of birth JDateChooser UpdatePatientPanel*/
		PatientDateOfBirth_UpdatePatientPanel = new JDateChooser();
		PatientDateOfBirth_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatientDateOfBirth_UpdatePatientPanel.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatientDateOfBirth_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		PatientDateOfBirth_UpdatePatientPanel.setBounds(203, 327, 171, 36);
		panelCardUpdatePatient.add(PatientDateOfBirth_UpdatePatientPanel);
		/*End Of Patient date of birth JDateChooser UpdatePatientPanel*/

		
		/*Patient Update Button UpdatePatientPanel*/
		BtnUpdatePatient_UpdatePatientPanel = new JButton();
		BtnUpdatePatient_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUpdatePatient_UpdatePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				/*
				 *     Update Patient
				 */
				
				
				//check if there any empty spaces
				if(lblPatientID2_UpdatePatientPanel.getText().isEmpty() || textFieldName_UpdatePatientPanel.getText().isEmpty() || 
				   textFieldPhoneNO_UpdatePatientPanel.getText().isEmpty() || textFieldAddress_UpdatePatientPanel.getText().isEmpty() ||
				   comboBoxGender_UpdatePatientPanel.getSelectedIndex()==0 || PatientDateOfBirth_UpdatePatientPanel.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no number Entered in Name Field
					if(textFieldName_UpdatePatientPanel.getText().contains("0") || textFieldName_UpdatePatientPanel.getText().contains("1") ||
					   textFieldName_UpdatePatientPanel.getText().contains("2") || textFieldName_UpdatePatientPanel.getText().contains("3") ||
					   textFieldName_UpdatePatientPanel.getText().contains("4") || textFieldName_UpdatePatientPanel.getText().contains("5") ||
					   textFieldName_UpdatePatientPanel.getText().contains("6") || textFieldName_UpdatePatientPanel.getText().contains("7") ||
					   textFieldName_UpdatePatientPanel.getText().contains("8") || textFieldName_UpdatePatientPanel.getText().contains("9")  )
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name field"); }
					
					//else continue after "check no number Entered in Name Field"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldPhoneNO_UpdatePatientPanel.getText().contains("a") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("b") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("c") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("d") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("e") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("f") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("g") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("h") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("i") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("j") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("k") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("l") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("m") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("n") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("o") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("p") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("q") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("r") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("s") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("t") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("u") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("v") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("w") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("x") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("y") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("z") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("A") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("B") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("C") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("D") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("E") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("F") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("G") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("H") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("I") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("J") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("K") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("L") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("M") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("N") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("O") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("P") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("Q") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("R") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("S") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("T") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("U") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("V") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("W") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("X") ||
								textFieldPhoneNO_UpdatePatientPanel.getText().contains("Y") || textFieldPhoneNO_UpdatePatientPanel.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
							String DofB              = dFormat.format(PatientDateOfBirth_UpdatePatientPanel.getDate());
							// End date to string
							
							// text to integer
							int PhoneNO = Integer.parseInt(textFieldPhoneNO_UpdatePatientPanel.getText());   
							// End text to integer
							
							// Set data to "PatientsDTO" object
							PatientsDTO patientDTO = new PatientsDTO();
							patientDTO.setPatientID(lblPatientID2_UpdatePatientPanel.getText());
							patientDTO.setName(textFieldName_UpdatePatientPanel.getText());
							patientDTO.setGender((String) comboBoxGender_UpdatePatientPanel.getSelectedItem());
							patientDTO.setBirthday(DofB);
							patientDTO.setPhoneNO(PhoneNO);
							patientDTO.setAddress(textFieldAddress_UpdatePatientPanel.getText());
							patientDTO.setAdded_By(receptionistName);
							// End of Set data to "PatientsDTO" object
							
							// Send data to "checkPatientDAO" method
							new PatientsDAO().checkPatientDAO(patientDTO);
							// End of Send data to "checkPatientDAO" method

						}
					}	
				}
			
			}
		});
		BtnUpdatePatient_UpdatePatientPanel.setText("Update");
		BtnUpdatePatient_UpdatePatientPanel.setForeground(Color.WHITE);
		BtnUpdatePatient_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnUpdatePatient_UpdatePatientPanel.setFocusable(false);
		BtnUpdatePatient_UpdatePatientPanel.setBackground(new Color(102, 51, 153));
		BtnUpdatePatient_UpdatePatientPanel.setBounds(376, 406, 105, 35);
		panelCardUpdatePatient.add(BtnUpdatePatient_UpdatePatientPanel);
		/*End Of Patient Update Button UpdatePatientPanel*/

		
		/*Empty Field Button UpdatePatientPanel*/
		BtnEmptyField_UpdatePatientPanel = new JButton();
		BtnEmptyField_UpdatePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnEmptyField_UpdatePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 // Clear all fields 
				clearButtonUpdatePatientPanel();
			}
		});
		BtnEmptyField_UpdatePatientPanel.setText("Clear");
		BtnEmptyField_UpdatePatientPanel.setForeground(Color.WHITE);
		BtnEmptyField_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnEmptyField_UpdatePatientPanel.setFocusable(false);
		BtnEmptyField_UpdatePatientPanel.setBackground(new Color(46, 139, 87));
		BtnEmptyField_UpdatePatientPanel.setBounds(261, 406, 105, 35);
		panelCardUpdatePatient.add(BtnEmptyField_UpdatePatientPanel);
		/*End Of Empty Field Button UpdatePatientPanel*/

		
		/*Update Patient Title UpdatePatientPanel*/
		lblUpdatePatientTitle_UpdatePatientPanel = new JLabel("Update Patient Page");
		lblUpdatePatientTitle_UpdatePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePatientTitle_UpdatePatientPanel.setForeground(Color.BLACK);
		lblUpdatePatientTitle_UpdatePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdatePatientTitle_UpdatePatientPanel.setFocusable(false);
		lblUpdatePatientTitle_UpdatePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblUpdatePatientTitle_UpdatePatientPanel.setBounds(168, 0, 317, 36);
		panelCardUpdatePatient.add(lblUpdatePatientTitle_UpdatePatientPanel);
		/*End Of Update Patient Title UpdatePatientPanel*/

		
		/*Delete Patient Card Panel*/
		panelCardDeletePatient = new JPanel();
		panelCardDeletePatient.setLayout(null);
		panelCardDeletePatient.setBackground(Color.WHITE);
		panelCards.add(panelCardDeletePatient, DeletePatientPanel);
		/*End Of Delete Patient Card Panel*/

		
		/*Back Button DeletePatientPanel*/
		backBtn_DeletePatientPanel = new JButton();
		backBtn_DeletePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * Back to main card panel
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, PatientsMainPanel);

				// Clear all fields 
				clearButtonDeletePatientPanel();
			
			}
		});
		backBtn_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_DeletePatientPanel.setText("Back");
		backBtn_DeletePatientPanel.setForeground(Color.WHITE);
		backBtn_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_DeletePatientPanel.setFocusable(false);
		backBtn_DeletePatientPanel.setBackground(new Color(204, 0, 0));
		backBtn_DeletePatientPanel.setBounds(146, 406, 105, 35);
		panelCardDeletePatient.add(backBtn_DeletePatientPanel);
		/*End Of Back Button DeletePatientPanel*/

		
		/*Patient Name Label DeletePatientPanel*/
		lblPatientName_DeletePatientPanel = new JLabel("Name");
		lblPatientName_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientName_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientName_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientName_DeletePatientPanel.setFocusable(false);
		lblPatientName_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientName_DeletePatientPanel.setBounds(22, 135, 171, 36);
		panelCardDeletePatient.add(lblPatientName_DeletePatientPanel);
		/*End Of Patient Name Label DeletePatientPanel*/

		
		/*Patient Contact NO Label DeletePatientPanel*/
		lblPatientContactNO_DeletePatientPanel = new JLabel("Phone NO.");
		lblPatientContactNO_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientContactNO_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientContactNO_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientContactNO_DeletePatientPanel.setFocusable(false);
		lblPatientContactNO_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientContactNO_DeletePatientPanel.setBounds(22, 182, 171, 36);
		panelCardDeletePatient.add(lblPatientContactNO_DeletePatientPanel);
		/*End Of Patient Contact NO Label DeletePatientPanel*/

		
		/*Name textField DeletePatientPanel*/
		textFieldName_DeletePatientPanel = new JTextField();
		textFieldName_DeletePatientPanel.setEnabled(false);
		textFieldName_DeletePatientPanel.setToolTipText("Name");
		textFieldName_DeletePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldName_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldName_DeletePatientPanel.setColumns(10);
		textFieldName_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldName_DeletePatientPanel.setBounds(203, 136, 171, 36);
		panelCardDeletePatient.add(textFieldName_DeletePatientPanel);
		/*End Of Name textField DeletePatientPanel*/

		
		/*Patient Address DeletePatientPanel*/
		lblPatientAddress_DeletePatientPanel = new JLabel("Address");
		lblPatientAddress_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientAddress_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientAddress_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientAddress_DeletePatientPanel.setFocusable(false);
		lblPatientAddress_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientAddress_DeletePatientPanel.setBounds(22, 233, 171, 36);
		panelCardDeletePatient.add(lblPatientAddress_DeletePatientPanel);
		/*End Of Patient Address Label DeletePatientPanel*/

		
		/*Patient Gender Label DeletePatientPanel*/
		lblPatientGender_DeletePatientPanel = new JLabel("Gender");
		lblPatientGender_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientGender_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientGender_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientGender_DeletePatientPanel.setFocusable(false);
		lblPatientGender_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientGender_DeletePatientPanel.setBounds(22, 280, 171, 36);
		panelCardDeletePatient.add(lblPatientGender_DeletePatientPanel);
		/*End Of Patient Gender Label DeletePatientPanel*/

		
		/*Patient ID Label DeletePatientPanel*/
		lblPatientID_DeletePatientPanel = new JLabel("Patient ID");
		lblPatientID_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientID_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_DeletePatientPanel.setFocusable(false);
		lblPatientID_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_DeletePatientPanel.setBounds(22, 88, 171, 36);
		panelCardDeletePatient.add(lblPatientID_DeletePatientPanel);
		/*End Of Patient ID Label DeletePatientPanel*/

		
		/*Patient Date of birth Label DeletePatientPanel*/
		lblPatientDateOfBirth_DeletePatientPanel = new JLabel("Date Of Birth");
		lblPatientDateOfBirth_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientDateOfBirth_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientDateOfBirth_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientDateOfBirth_DeletePatientPanel.setFocusable(false);
		lblPatientDateOfBirth_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientDateOfBirth_DeletePatientPanel.setBounds(22, 327, 171, 36);
		panelCardDeletePatient.add(lblPatientDateOfBirth_DeletePatientPanel);
		/*End Of Patient Date of birth Label DeletePatientPanel*/

		
		/*Patient Search Panel DeletePatientPanel*/
		panelPatientSearch_DeletePatientPanel = new JPanel();
		panelPatientSearch_DeletePatientPanel.setLayout(null);
		panelPatientSearch_DeletePatientPanel.setBackground(new Color(102, 51, 153));
		panelPatientSearch_DeletePatientPanel.setBounds(427, 88, 200, 275);
		panelCardDeletePatient.add(panelPatientSearch_DeletePatientPanel);
		/*End Of Patient Search Panel DeletePatientPanel*/

		
		/*Patient Search Label DeletePatientPanel*/
		lblPatientSearch_DeletePatientPanel = new JLabel("Patient Search");
		lblPatientSearch_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearch_DeletePatientPanel.setForeground(Color.WHITE);
		lblPatientSearch_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientSearch_DeletePatientPanel.setFocusable(false);
		lblPatientSearch_DeletePatientPanel.setBorder(null);
		lblPatientSearch_DeletePatientPanel.setBounds(10, 11, 180, 36);
		panelPatientSearch_DeletePatientPanel.add(lblPatientSearch_DeletePatientPanel);
		/*End Of Patient Search Label DeletePatientPanel*/

		
		/*Search Button DeletePatientPanel*/
		btnSearch_DeletePatientPanel = new JButton();
		btnSearch_DeletePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Search Patient
				 */
										
				//check if enter patient ID field is empty 
				if(textFieldEnterPatientID_DeletePatientPanel.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
				
				// else continue after "check if enter patient ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
			    		preparedstatement.setString(1, textFieldEnterPatientID_DeletePatientPanel.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if patient ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(6));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(5);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								PatientDateOfBirth_DeletePatientPanel.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblPatientID2_DeletePatientPanel.setText(resultset.getString(2));
							textFieldName_DeletePatientPanel.setText(resultset.getString(3));
							textField_PhoneNO_DeletePatientPanel.setText(phoneNO);
							textFieldAddress_DeletePatientPanel.setText(resultset.getString(7));
							comboBoxGender_DeletePatientPanel.setSelectedItem(resultset.getString(4));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if patient ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! patient ID not exist, please enter the right patient ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSearch_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_DeletePatientPanel.setText("Search");
		btnSearch_DeletePatientPanel.setForeground(Color.WHITE);
		btnSearch_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_DeletePatientPanel.setFocusable(false);
		btnSearch_DeletePatientPanel.setBackground(new Color(102, 51, 153));
		btnSearch_DeletePatientPanel.setBounds(10, 229, 180, 35);
		panelPatientSearch_DeletePatientPanel.add(btnSearch_DeletePatientPanel);
		/*End Of Search Button DeletePatientPanel*/

		
		/*Patient Search Enter ID Label DeletePatientPanel*/
		lblPatientSearchEnterID_DeletePatientPanel = new JLabel("Enter Patient ID");
		lblPatientSearchEnterID_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearchEnterID_DeletePatientPanel.setForeground(Color.WHITE);
		lblPatientSearchEnterID_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 15));
		lblPatientSearchEnterID_DeletePatientPanel.setFocusable(false);
		lblPatientSearchEnterID_DeletePatientPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblPatientSearchEnterID_DeletePatientPanel.setBounds(10, 79, 180, 36);
		panelPatientSearch_DeletePatientPanel.add(lblPatientSearchEnterID_DeletePatientPanel);
		/*End Of Patient Search Enter ID Label DeletePatientPanel*/

		
		/*Enter Patient ID textField DeletePatientPanel*/
		textFieldEnterPatientID_DeletePatientPanel = new JTextField();
		textFieldEnterPatientID_DeletePatientPanel.setToolTipText("Patient ID");
		textFieldEnterPatientID_DeletePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterPatientID_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterPatientID_DeletePatientPanel.setColumns(10);
		textFieldEnterPatientID_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterPatientID_DeletePatientPanel.setBounds(10, 159, 180, 36);
		panelPatientSearch_DeletePatientPanel.add(textFieldEnterPatientID_DeletePatientPanel);
		/*End Of Enter Patient ID textField DeletePatientPanel*/

		
		/*Patient ID 2 Label DeletePatientPanel*/
		lblPatientID2_DeletePatientPanel = new JLabel("");
		lblPatientID2_DeletePatientPanel.setEnabled(false);
		lblPatientID2_DeletePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientID2_DeletePatientPanel.setForeground(Color.BLACK);
		lblPatientID2_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		lblPatientID2_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID2_DeletePatientPanel.setBackground(new Color(102, 51, 153));
		lblPatientID2_DeletePatientPanel.setBounds(203, 88, 171, 37);
		panelCardDeletePatient.add(lblPatientID2_DeletePatientPanel);
		/*End Of Patient ID 2 Label DeletePatientPanel*/

		
		/*Phone NO textField DeletePatientPanel*/
		textField_PhoneNO_DeletePatientPanel = new JTextField();
		textField_PhoneNO_DeletePatientPanel.setEnabled(false);
		textField_PhoneNO_DeletePatientPanel.setToolTipText("Phone NO.");
		textField_PhoneNO_DeletePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textField_PhoneNO_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textField_PhoneNO_DeletePatientPanel.setColumns(10);
		textField_PhoneNO_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textField_PhoneNO_DeletePatientPanel.setBounds(203, 182, 171, 36);
		panelCardDeletePatient.add(textField_PhoneNO_DeletePatientPanel);
		/*End Of Phone NO textField DeletePatientPanel*/

		
		/*Address textField DeletePatientPanel*/
		textFieldAddress_DeletePatientPanel = new JTextField();
		textFieldAddress_DeletePatientPanel.setEnabled(false);
		textFieldAddress_DeletePatientPanel.setToolTipText("Address");
		textFieldAddress_DeletePatientPanel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAddress_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldAddress_DeletePatientPanel.setColumns(10);
		textFieldAddress_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldAddress_DeletePatientPanel.setBounds(203, 233, 171, 36);
		panelCardDeletePatient.add(textFieldAddress_DeletePatientPanel);
		/*End Of Address textField DeletePatientPanel*/

		
		/*Gender comboBox DeletePatientPanel*/
		comboBoxGender_DeletePatientPanel = new JComboBox();
		comboBoxGender_DeletePatientPanel.setEnabled(false);
		comboBoxGender_DeletePatientPanel.setModel(new DefaultComboBoxModel(new String[] {"Choose Gender", "Male", "Female"}));
		comboBoxGender_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_DeletePatientPanel.setToolTipText("Gender");
		comboBoxGender_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_DeletePatientPanel.setFocusable(false);
		comboBoxGender_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_DeletePatientPanel.setBackground(Color.WHITE);
		comboBoxGender_DeletePatientPanel.setBounds(203, 280, 171, 36);
		panelCardDeletePatient.add(comboBoxGender_DeletePatientPanel);
		/*End Of Gender comboBox DeletePatientPanel*/

		
		/*Patient Date of birth JDateChooser DeletePatientPanel*/
		PatientDateOfBirth_DeletePatientPanel = new JDateChooser();
		PatientDateOfBirth_DeletePatientPanel.setEnabled(false);
		PatientDateOfBirth_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatientDateOfBirth_DeletePatientPanel.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatientDateOfBirth_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		PatientDateOfBirth_DeletePatientPanel.setBounds(203, 327, 171, 36);
		panelCardDeletePatient.add(PatientDateOfBirth_DeletePatientPanel);
		/*End Of Patient Date of birth JDateChooser DeletePatientPanel*/

		
		/*Delete Button DeletePatientPanel*/
		BtnDeletePatient_DeletePatientPanel = new JButton();
		BtnDeletePatient_DeletePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					/*
					 *     Delete Patient
					 */
					
					//check if enter patient ID field is empty
					if(textFieldEnterPatientID_DeletePatientPanel.getText().isEmpty())
						
					{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
					
					//else continue after "check if enter patient ID field is empty"
					else    				
					{
						// Set data to "PatientsDTO" object
						PatientsDTO patientDTO = new PatientsDTO();
						patientDTO.setPatientID(textFieldEnterPatientID_DeletePatientPanel.getText());
						// End of Set data to "PatientsDTO" object

						
						// Send data to "deletePatientDAO" method
						new PatientsDAO().deletePatientDAO(patientDTO);
						// End of Send data to "deletePatientDAO" method

					}
					
			}
		});
		BtnDeletePatient_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnDeletePatient_DeletePatientPanel.setText("Delete");
		BtnDeletePatient_DeletePatientPanel.setForeground(Color.WHITE);
		BtnDeletePatient_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnDeletePatient_DeletePatientPanel.setFocusable(false);
		BtnDeletePatient_DeletePatientPanel.setBackground(new Color(102, 51, 153));
		BtnDeletePatient_DeletePatientPanel.setBounds(376, 406, 105, 35);
		panelCardDeletePatient.add(BtnDeletePatient_DeletePatientPanel);
		/*End Of Delete Button DeletePatientPanel*/

		
		/*Empty Field Button DeletePatientPanel*/
		BtnEmptyField_DeletePatientPanel = new JButton();
		BtnEmptyField_DeletePatientPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear Fields
				clearButtonDeletePatientPanel();
			}
		});
		BtnEmptyField_DeletePatientPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnEmptyField_DeletePatientPanel.setText("Clear");
		BtnEmptyField_DeletePatientPanel.setForeground(Color.WHITE);
		BtnEmptyField_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnEmptyField_DeletePatientPanel.setFocusable(false);
		BtnEmptyField_DeletePatientPanel.setBackground(new Color(46, 139, 87));
		BtnEmptyField_DeletePatientPanel.setBounds(261, 406, 105, 35);
		panelCardDeletePatient.add(BtnEmptyField_DeletePatientPanel);
		/*End Of Empty Field Button DeletePatientPanel*/

		
		/*Delete Patient Title Label DeletePatientPanel*/
		lblDeletePatientTitle_DeletePatientPanel = new JLabel("Delete Patient Page");
		lblDeletePatientTitle_DeletePatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletePatientTitle_DeletePatientPanel.setForeground(Color.BLACK);
		lblDeletePatientTitle_DeletePatientPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeletePatientTitle_DeletePatientPanel.setFocusable(false);
		lblDeletePatientTitle_DeletePatientPanel.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDeletePatientTitle_DeletePatientPanel.setBounds(168, 0, 317, 36);
		panelCardDeletePatient.add(lblDeletePatientTitle_DeletePatientPanel);
		/*End Of Delete Patient Title Label DeletePatientPanel*/


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
	 *   Random number for patient ID Method
	 * ***************************************
	 */
	public static void RandomPatientID()
	{
		Random random = new Random();
		lblPatientID2_AddPatientPanel.setText("P"+ random.nextInt(100000+1));
		
	}
	 /*
     * **********************************************
     *   End of Random number for patient ID Method
     * **********************************************
     */
	
	
	
	
	/*
     * *****************************************
     * Show data from data base on table Method
     * *****************************************
     */
	public static void ShowDatatBaseDataToTable()
	{

		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statment   = connection.createStatement();
			ResultSet resaultset = statment.executeQuery("SELECT * FROM `Patients`");

			table.setModel(DbUtils.resultSetToTableModel(resaultset));
			
			statment.close();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	/*
     * ************************************************
     * End of Show data from data base on table Method
     * ************************************************
     */
	
	
	
	
	/*
	 * ***********************************************
	 *   Clear All Fields in Add Patient Panel method 
	 * ***********************************************
	 */
	private void clearButtonAddPatientPanel()
	{
		textFieldPatientName_AddPatientPanel.setText(null);
		textFieldContactNO_AddPatientPanel.setText(null);
		textFieldAddress_AddPatientPanel.setText(null);
		lblPatientID2_AddPatientPanel.setText(null);
		comboBoxGender_AddPatientPanel.setSelectedIndex(0);
		PatientDateOfBirth_AddPatientPanel.setDate(null);
	}
	/*
	 * *****************************************************
	 *  End of Clear All Fields in Add Patient Panel Method
	 * *****************************************************
	 */
	
	
	
	
	/*
	 * **************************************************
	 *   Clear All Fields in Update Patient Panel method 
	 * **************************************************
	 */
	private void clearButtonUpdatePatientPanel()
	{
		textFieldName_UpdatePatientPanel.setText(null);
		textFieldPhoneNO_UpdatePatientPanel.setText(null);
		textFieldAddress_UpdatePatientPanel.setText(null);
		textFieldEnterPatientID_UpdatePatientPanel.setText(null);
		lblPatientID2_UpdatePatientPanel.setText(null);
		comboBoxGender_UpdatePatientPanel.setSelectedIndex(0);
		PatientDateOfBirth_UpdatePatientPanel.setDate(null);
	}
	/*
	 * ********************************************************
	 *  End of Clear All Fields in Update Patient Panel Method
	 * ********************************************************
	 */
	
	
	
	
	/*
	 * **************************************************
	 *   Clear All Fields in Delete Patient Panel method 
	 * **************************************************
	 */
	private void clearButtonDeletePatientPanel()
	{
		textFieldName_DeletePatientPanel.setText(null);
		textField_PhoneNO_DeletePatientPanel.setText(null);
		textFieldAddress_DeletePatientPanel.setText(null);
		textFieldEnterPatientID_DeletePatientPanel.setText(null);
		lblPatientID2_DeletePatientPanel.setText(null);
		comboBoxGender_DeletePatientPanel.setSelectedIndex(0);
		PatientDateOfBirth_DeletePatientPanel.setDate(null);
	}
}
