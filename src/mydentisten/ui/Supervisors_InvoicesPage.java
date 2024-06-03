package mydentisten.ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.github.lgooddatepicker.components.TimePicker;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import mydentisten.dao.AppointmentsDAO;
import mydentisten.dao.InvoiceDAO;
import mydentisten.database.ConnectionFactory;
import mydentisten.dto.AppointmentsDTO;
import mydentisten.dto.InvoicesDTO;
import net.proteanit.sql.DbUtils;
import timeselector.TimeSelectionField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JSeparator;

/**
*
* @author amjad azim
*/

public class Supervisors_InvoicesPage extends JInternalFrame {
	
	/*Variables*/
	
	//JLabel
	private JLabel labelSearchByInvoiceID_panelCardInvoicesRecord;
	private JLabel labelSearchByDoctorName_panelCardInvoicesRecord;
	private JLabel labelSearchByDoctorName2_panelCardInvoicesRecord;
	private JLabel labelSearchByPatientID_panelCardInvoicesRecord;
	private JLabel labelSearchByPatientID2_panelCardInvoicesRecord;
	private JLabel labelSearchByDate_panelCardInvoicesRecord;
    private JLabel labelSearchByDate2_panelCardInvoicesRecord;
    private JLabel lblSearchDoctorName_panelCardSearchByDoctorName;
    private JLabel lblDate_panelCardSearchByDoctorName;
    private JLabel lblTime_panelCardSearchByDoctorName;
    private JLabel lblInvoiceID_panelCardSearchByInvoiceID;
    private JLabel lblDoctorName_panelCardSearchByPatientID;
    private JLabel lblDate_panelCardSearchByPatientID;
    private JLabel labelSearchByInvoiceID1_panelCardInvoicesRecord;
    private JLabel lblPatientID_panelCardSearchByPatientID;
    private JLabel lblDate_panelCardSearchByDateAndService;
    private JLabel lblTime_panelCardSearchByDateAndService;
    private JLabel lblService_panelCardSearchByDateAndService;
    private JLabel labelAndByStatus_panelCardInvoicesRecord;
    private JLabel labelSearchByReceptionistsName_panelCardInvoicesRecord;
    private JLabel labelSearchByReceptionistsName2_panelCardInvoicesRecord;
    private JLabel lblReceptionistName_panelCardSearchByReceptionistName;
    private JLabel lblSearchByDoctorNameTitle_panelCardSearchByDoctorName;
    private JLabel lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID;
    private JLabel lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService;
    private JLabel lblSearchByPatientIDTitle_panelCardSearchByPatientID;
    private JLabel lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName;

    //String
	final static String  InvoicesRecordPanel = "Invoices Record";
	final static String  InvoicesSearchByDoctorNamePanel = "Search By Doctor Name";
	final static String  InvoicesSearchByInvoiceIDPanel = "Search By Invoice ID";
	final static String  InvoicesSearchByPatientIDPanel = "Search By Patient ID";
	final static String  InvoicesSearchByDateAndServicePanel = "Search By Date And Service";
	final static String  InvoicesSearchByReceptionistNamePanel = "Search By Receptionist Name";
	public String receptionists_Name;
	
	//JButton
	private JButton btnSearchAll_panelCardSearchByPatientID;
	private JButton backBtn_panelCardSearchByDoctorName;
    private JButton BtnClearFields_panelCardSearchByDoctorName;
    private JButton btnSearchByDate_panelCardSearchByDoctorName;
    private JButton btnSearchByTime_panelCardSearchByDoctorName;
    private JButton btnByDateAndTime_panelCardSearchByDoctorName;
    private JButton BtnBack_panelCardSearchByInvoiceID;
    private JButton BtnClearcField_panelCardSearchByInvoiceID;
    private JButton btnSearch_panelCardSearchByInvoiceID;
    private JButton BtnBack_panelCardSearchByPatientID;
    private JButton BtnClearFields_panelCardSearchByPatientID;
    private JButton btnSearchByDate_panelCardSearchByPatientID;
    private JButton btnSearchByDoctorName_panelCardSearchByPatientID;
    private JButton btnSearchByDateAndDoctorName_panelCardSearchByPatientID;
    private JButton BtnBack_panelCardSearchByDateAndService;
    private JButton BtnClearFields_panelCardSearchByDateAndService;
    private JButton btnSearchAllThisDateInvoices_panelCardSearchByDateAndService;
    private JButton btnSearchByService_panelCardSearchByDateAndService;
    private JButton btnSearchByDateAndTime_panelCardSearchByDateAndService;
    private JButton btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService;
    private JButton btnShowAllcancelledInvoices_panelCardSearchByInvoiceID;
    private JButton btnShowAllCurrentInvoices_panelCardSearchByInvoiceID;
    private JButton BtnBack_panelCardSearchByReceptionistName;
    private JButton BtnClearcField_panelCardSearchByReceptionistName;
    private JButton btnShowAddedBy_panelCardSearchByReceptionistName;
    private JButton btnShowUpdatedBy_panelCardSearchByReceptionistName;
    private JButton btnShowCancelledBy_panelCardSearchByReceptionistName;
    
    //JTextField
    private JTextField textFieldInvoiceID_panelCardSearchByInvoiceID;
    private JTextField textFieldPatientID_panelCardSearchByPatientID;
    private JTextField textFieldReceptionistName_panelCardSearchByReceptionistName;
    
    //JComboBox
    private JComboBox comboBoxSearchDoctorName_panelCardSearchByDoctorName;
    private JComboBox comboBoxDoctorName_panelCardSearchByPatientID;
    private JComboBox comboBoxService_panelCardSearchByDateAndService;
    
    //JDateChooser
    private JDateChooser Date_panelCardSearchByDoctorName;
    private JDateChooser Date_panelCardSearchByPatientID;
    private JDateChooser Date_panelCardSearchByDateAndService;
    
    //TimePicker
	private static TimePicker Time_panelCardSearchByDoctorName;
    private TimePicker Time_panelCardSearchByDateAndService;

    // connect to database with class ConnectDatabase 
    private static Connection connection;   
    
    //JScrollPane
    private JScrollPane scrollPane_panelCardSearchByDoctorName;
    private JScrollPane scrollPane_panelCardSearchByInvoiceID;
    private JScrollPane scrollPane_panelCardSearchByPatientID;
    private JScrollPane scrollPane_panelCardSearchByDateAndService;
    private JScrollPane scrollPane_panelCardSearchByReceptionistName; 

    //JTable
    private static JTable table_panelCardSearchByDoctorName;
    private static JTable table_panelCardSearchByInvoiceID;
    private static JTable table_panelCardSearchByPatientID;
    private static JTable table_panelCardSearchByDateAndService;
    private static JTable table_panelCardSearchByReceptionistName;
    
	/*End of Variables*/


    
	/*Panels*/
    private JPanel panelCards;
	private JPanel panelCardInvoicesRecord;
    private JPanel panelCardSearchByDoctorName;
    private JPanel panelSearchByDoctorName_panelCardInvoicesRecord;
    private JPanel panelSearchByPatientID_panelCardInvoicesRecord;
    private JPanel panelSearchByDate_panelCardInvoicesRecord;
    private JPanel panelCardSearchByInvoiceID;
    private JPanel panelCardSearchByPatientID;
    private JPanel panelCardSearchByDateAndService;
    private JPanel panelSearchByInvoiceID_panelCardInvoicesRecord;
    private JPanel panelSearchByReceptionistsName_panelCardInvoicesRecord;
    private JPanel panelCardSearchByReceptionistName;   
	/*End Of Panels*/

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisors_InvoicesPage frame = new Supervisors_InvoicesPage();
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
	public Supervisors_InvoicesPage() {
		getContentPane().setBackground(Color.WHITE);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(null);
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

		
		/*Card Invoices Record Panel*/
		panelCardInvoicesRecord = new JPanel();
		panelCardInvoicesRecord.setBorder(new LineBorder(Color.WHITE, 8, true));
		panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelCards.add(panelCardInvoicesRecord, InvoicesRecordPanel);
		panelCardInvoicesRecord.setLayout(null);
		panelCards.add(panelCardInvoicesRecord, InvoicesRecordPanel);
		/*End of Card Invoices Record Panel*/
		
		
		/*Search By Invoice ID Panel panelCardInvoicesRecord*/
		panelSearchByInvoiceID_panelCardInvoicesRecord = new JPanel();
		panelSearchByInvoiceID_panelCardInvoicesRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search By Appointment ID Panel card when mouse  clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesSearchByInvoiceIDPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByInvoiceID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByInvoiceID_panelCardInvoicesRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByInvoiceID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByInvoiceID_panelCardInvoicesRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByInvoiceID_panelCardInvoicesRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByInvoiceID_panelCardInvoicesRecord.setLayout(null);
		panelSearchByInvoiceID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByInvoiceID_panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelSearchByInvoiceID_panelCardInvoicesRecord.setBounds(367, 75, 249, 118);
		panelCardInvoicesRecord.add(panelSearchByInvoiceID_panelCardInvoicesRecord);
		/*End of Search By Invoice ID Panel panelCardInvoicesRecord*/

		
		/*Search By Invoice ID Label panelCardInvoicesRecord*/
		labelSearchByInvoiceID_panelCardInvoicesRecord = new JLabel("Search Invoice By :");
		labelSearchByInvoiceID_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByInvoiceID_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByInvoiceID_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByInvoiceID_panelCardInvoicesRecord.setBounds(10, 11, 223, 38);
		panelSearchByInvoiceID_panelCardInvoicesRecord.add(labelSearchByInvoiceID_panelCardInvoicesRecord);
		/*End of Search By Invoice ID Label panelCardInvoicesRecord*/
		
		
		/*Search By Invoice ID 1 Label panelCardInvoicesRecord*/
		labelSearchByInvoiceID1_panelCardInvoicesRecord = new JLabel("Invoice ID");
		labelSearchByInvoiceID1_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByInvoiceID1_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByInvoiceID1_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByInvoiceID1_panelCardInvoicesRecord.setBounds(10, 39, 223, 38);
		panelSearchByInvoiceID_panelCardInvoicesRecord.add(labelSearchByInvoiceID1_panelCardInvoicesRecord);
		/*End of Search By Invoice ID 1 Label panelCardInvoicesRecord*/
		
		
		/*And By Status Label panelCardInvoicesRecord*/
		labelAndByStatus_panelCardInvoicesRecord = new JLabel("And By Status");
		labelAndByStatus_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelAndByStatus_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelAndByStatus_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAndByStatus_panelCardInvoicesRecord.setBounds(10, 69, 223, 38);
		panelSearchByInvoiceID_panelCardInvoicesRecord.add(labelAndByStatus_panelCardInvoicesRecord);
		/*End of And By Status Label panelCardInvoicesRecord*/

		
		/*Search By Doctor Name Panel panelCardInvoicesRecord*/
		panelSearchByDoctorName_panelCardInvoicesRecord = new JPanel();
		panelSearchByDoctorName_panelCardInvoicesRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search By Doctor Name Panel card when mouse  clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesSearchByDoctorNamePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByDoctorName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByDoctorName_panelCardInvoicesRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByDoctorName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByDoctorName_panelCardInvoicesRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByDoctorName_panelCardInvoicesRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByDoctorName_panelCardInvoicesRecord.setLayout(null);
		panelSearchByDoctorName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByDoctorName_panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelSearchByDoctorName_panelCardInvoicesRecord.setBounds(37, 75, 249, 118);
		panelCardInvoicesRecord.add(panelSearchByDoctorName_panelCardInvoicesRecord);
		/*End of Search By Doctor Name Panel panelCardInvoicesRecord*/

		
		
		/*Search By Doctor Name Label panelCardInvoicesRecord*/
		labelSearchByDoctorName_panelCardInvoicesRecord = new JLabel("Search Invoice By:");
		labelSearchByDoctorName_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDoctorName_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByDoctorName_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDoctorName_panelCardInvoicesRecord.setBounds(10, 11, 223, 38);
		panelSearchByDoctorName_panelCardInvoicesRecord.add(labelSearchByDoctorName_panelCardInvoicesRecord);
		/*End of Search By Doctor Name Label panelCardInvoicesRecord*/

		
		/*Search By Doctor Name 2 Label panelCardInvoicesRecord*/
		labelSearchByDoctorName2_panelCardInvoicesRecord = new JLabel("Doctor Name");
		labelSearchByDoctorName2_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDoctorName2_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByDoctorName2_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDoctorName2_panelCardInvoicesRecord.setBounds(10, 60, 223, 38);
		panelSearchByDoctorName_panelCardInvoicesRecord.add(labelSearchByDoctorName2_panelCardInvoicesRecord);
		/*End of Search By Doctor Name 2 Label panelCardInvoicesRecord*/

		
		/*Search By Patient ID Panel panelCardInvoicesRecord*/
		panelSearchByPatientID_panelCardInvoicesRecord = new JPanel();
		panelSearchByPatientID_panelCardInvoicesRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search By Patient ID Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesSearchByPatientIDPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByPatientID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByPatientID_panelCardInvoicesRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByPatientID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByPatientID_panelCardInvoicesRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByPatientID_panelCardInvoicesRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByPatientID_panelCardInvoicesRecord.setLayout(null);
		panelSearchByPatientID_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByPatientID_panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelSearchByPatientID_panelCardInvoicesRecord.setBounds(367, 204, 249, 118);
		panelCardInvoicesRecord.add(panelSearchByPatientID_panelCardInvoicesRecord);
		/*End of Search By Patient ID Panel panelCardInvoicesRecord*/
		
		
		/*Search By Patient ID Label panelCardInvoicesRecord*/
		labelSearchByPatientID_panelCardInvoicesRecord = new JLabel("Search Invoice By :");
		labelSearchByPatientID_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByPatientID_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByPatientID_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByPatientID_panelCardInvoicesRecord.setBounds(10, 11, 223, 38);
		panelSearchByPatientID_panelCardInvoicesRecord.add(labelSearchByPatientID_panelCardInvoicesRecord);
		/*End of Search By Patient ID Label panelCardInvoicesRecord*/

		
		/*Search By Patient ID 2 Label panelCardInvoicesRecord*/
		labelSearchByPatientID2_panelCardInvoicesRecord = new JLabel("Patient ID");
		labelSearchByPatientID2_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByPatientID2_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByPatientID2_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByPatientID2_panelCardInvoicesRecord.setBounds(10, 60, 223, 38);
		panelSearchByPatientID_panelCardInvoicesRecord.add(labelSearchByPatientID2_panelCardInvoicesRecord);
		/*End of Search By Patient ID 2 Label panelCardInvoicesRecord*/

		
		/*Search By Date Panel panelCardInvoicesRecord*/
		panelSearchByDate_panelCardInvoicesRecord = new JPanel();
		panelSearchByDate_panelCardInvoicesRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search By Date And Service Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesSearchByDateAndServicePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByDate_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByDate_panelCardInvoicesRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByDate_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByDate_panelCardInvoicesRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByDate_panelCardInvoicesRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByDate_panelCardInvoicesRecord.setLayout(null);
		panelSearchByDate_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByDate_panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelSearchByDate_panelCardInvoicesRecord.setBounds(37, 204, 249, 118);
		panelCardInvoicesRecord.add(panelSearchByDate_panelCardInvoicesRecord);
		/*End of Search By Date Panel panelCardInvoicesRecord*/
		
		
		/*Search By Date Label panelCardInvoicesRecord*/
		labelSearchByDate_panelCardInvoicesRecord = new JLabel("Search Invoice By :");
		labelSearchByDate_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDate_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByDate_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDate_panelCardInvoicesRecord.setBounds(10, 11, 223, 38);
		panelSearchByDate_panelCardInvoicesRecord.add(labelSearchByDate_panelCardInvoicesRecord);
		/*End of Search By Date Label panelCardInvoicesRecord*/

		
		/*Search By Date 2 Label panelCardInvoicesRecord*/
		labelSearchByDate2_panelCardInvoicesRecord = new JLabel("Date and Service");
		labelSearchByDate2_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDate2_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByDate2_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDate2_panelCardInvoicesRecord.setBounds(10, 60, 223, 38);
		panelSearchByDate_panelCardInvoicesRecord.add(labelSearchByDate2_panelCardInvoicesRecord);
		/*End of Search By Date 2 Label panelCardInvoicesRecord*/

		
		/*Search By Receptionists Name Panel panelCardInvoicesRecord*/
		panelSearchByReceptionistsName_panelCardInvoicesRecord = new JPanel();
		panelSearchByReceptionistsName_panelCardInvoicesRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByReceptionistsName_panelCardInvoicesRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Search By Receptionist Name Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesSearchByReceptionistNamePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByReceptionistsName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByReceptionistsName_panelCardInvoicesRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByReceptionistsName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByReceptionistsName_panelCardInvoicesRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByReceptionistsName_panelCardInvoicesRecord.setLayout(null);
		panelSearchByReceptionistsName_panelCardInvoicesRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByReceptionistsName_panelCardInvoicesRecord.setBackground(Color.WHITE);
		panelSearchByReceptionistsName_panelCardInvoicesRecord.setBounds(212, 333, 249, 118);
		panelCardInvoicesRecord.add(panelSearchByReceptionistsName_panelCardInvoicesRecord);
		/*End of Search By Receptionists Name Panel panelCardInvoicesRecord*/

		
		/*Search By Receptionists Name  Label panelCardInvoicesRecord*/
		labelSearchByReceptionistsName_panelCardInvoicesRecord = new JLabel("Search Invoice By:");
		labelSearchByReceptionistsName_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByReceptionistsName_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByReceptionistsName_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByReceptionistsName_panelCardInvoicesRecord.setBounds(10, 11, 223, 38);
		panelSearchByReceptionistsName_panelCardInvoicesRecord.add(labelSearchByReceptionistsName_panelCardInvoicesRecord);
		/*End of Search By Receptionists Name  Label panelCardInvoicesRecord*/

		
		/*Search By Receptionists Name 2 Label panelCardInvoicesRecord*/
		labelSearchByReceptionistsName2_panelCardInvoicesRecord = new JLabel("Receptionists Name");
		labelSearchByReceptionistsName2_panelCardInvoicesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByReceptionistsName2_panelCardInvoicesRecord.setForeground(Color.BLACK);
		labelSearchByReceptionistsName2_panelCardInvoicesRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByReceptionistsName2_panelCardInvoicesRecord.setBounds(10, 60, 223, 38);
		panelSearchByReceptionistsName_panelCardInvoicesRecord.add(labelSearchByReceptionistsName2_panelCardInvoicesRecord);
		/*End of Search By Receptionists Name 2 Label panelCardInvoicesRecord*/
		
		
		/*Card Search By Doctor Name Panel*/
		panelCardSearchByDoctorName = new JPanel();
		panelCardSearchByDoctorName.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTablepanelCardSearchByDoctorName();
				
				// Clear ComBox
				comboBoxSearchDoctorName_panelCardSearchByDoctorName.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
				
				// Get Doctors Names From Database and set them into comboBox
				GetDoctorsNames_panelCardSearchByDoctorName();
			}
		});
		panelCardSearchByDoctorName.setLayout(null);
		panelCardSearchByDoctorName.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByDoctorName, InvoicesSearchByDoctorNamePanel);
		/*End of Card Search By Doctor Name Panel*/

		
		/*Back Button panelCardSearchByDoctorName*/
		backBtn_panelCardSearchByDoctorName = new JButton();
		backBtn_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesRecordPanel);
				
				// clear comboBox
				comboBoxSearchDoctorName_panelCardSearchByDoctorName.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
				// clear fields
				Date_panelCardSearchByDoctorName.setDate(null);
				Time_panelCardSearchByDoctorName.setText(null);
				
				// refresh table
				ShowDatabaseDataToTablepanelCardSearchByDoctorName();

				

			}
		});
		backBtn_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardSearchByDoctorName.setText("Back");
		backBtn_panelCardSearchByDoctorName.setForeground(Color.WHITE);
		backBtn_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardSearchByDoctorName.setFocusable(false);
		backBtn_panelCardSearchByDoctorName.setBackground(new Color(204, 0, 0));
		backBtn_panelCardSearchByDoctorName.setBounds(221, 412, 105, 35);
		panelCardSearchByDoctorName.add(backBtn_panelCardSearchByDoctorName);
		/*End of Back Button panelCardSearchByDoctorName*/
		
		
		/*Clear Fields Button panelCardSearchByDoctorName*/
		BtnClearFields_panelCardSearchByDoctorName = new JButton();
		BtnClearFields_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxSearchDoctorName_panelCardSearchByDoctorName.setSelectedIndex(0);
				Date_panelCardSearchByDoctorName.setDate(null);
				Time_panelCardSearchByDoctorName.setText(null);
				
				ShowDatabaseDataToTablepanelCardSearchByDoctorName();
			}
		});
		BtnClearFields_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardSearchByDoctorName.setText("Clear");
		BtnClearFields_panelCardSearchByDoctorName.setForeground(Color.WHITE);
		BtnClearFields_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_panelCardSearchByDoctorName.setFocusable(false);
		BtnClearFields_panelCardSearchByDoctorName.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardSearchByDoctorName.setBounds(336, 412, 105, 35);
		panelCardSearchByDoctorName.add(BtnClearFields_panelCardSearchByDoctorName);
		/*End of Clear Fields Button panelCardSearchByDoctorName*/

		
		
		/*comboBox Search Doctor Name panelCardSearchByDoctorName*/
		comboBoxSearchDoctorName_panelCardSearchByDoctorName = new JComboBox();
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setToolTipText("Choose Doctor");
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setFocusable(false);
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setBackground(Color.WHITE);
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setBounds(211, 231, 171, 36);
		panelCardSearchByDoctorName.add(comboBoxSearchDoctorName_panelCardSearchByDoctorName);
		/*End of comboBox Search Doctor Name panelCardSearchByDoctorName*/
		
		
		/*Search Doctor Name Label panelCardSearchByDoctorName*/
		lblSearchDoctorName_panelCardSearchByDoctorName = new JLabel("Doctor Name");
		lblSearchDoctorName_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDoctorName_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblSearchDoctorName_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchDoctorName_panelCardSearchByDoctorName.setFocusable(false);
		lblSearchDoctorName_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSearchDoctorName_panelCardSearchByDoctorName.setBounds(10, 231, 191, 36);
		panelCardSearchByDoctorName.add(lblSearchDoctorName_panelCardSearchByDoctorName);
		/*End of Search Doctor Name Label panelCardSearchByDoctorName*/

		
		/*Date Label panelCardSearchByDoctorName*/
		lblDate_panelCardSearchByDoctorName = new JLabel("Date");
		lblDate_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblDate_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardSearchByDoctorName.setFocusable(false);
		lblDate_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardSearchByDoctorName.setBounds(10, 282, 191, 36);
		panelCardSearchByDoctorName.add(lblDate_panelCardSearchByDoctorName);
		/*End of Date Label panelCardSearchByDoctorName*/

		
		/*Date panelCardSearchByDoctorName*/
		Date_panelCardSearchByDoctorName = new JDateChooser();
		Date_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardSearchByDoctorName.setToolTipText("Date");
		Date_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardSearchByDoctorName.setBounds(211, 282, 171, 36);
		panelCardSearchByDoctorName.add(Date_panelCardSearchByDoctorName);
		/*End of Date panelCardSearchByDoctorName*/
		
		
		/*Time Label panelCardSearchByDoctorName*/
		lblTime_panelCardSearchByDoctorName = new JLabel("Time");
		lblTime_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblTime_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardSearchByDoctorName.setFocusable(false);
		lblTime_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardSearchByDoctorName.setBounds(10, 329, 191, 36);
		panelCardSearchByDoctorName.add(lblTime_panelCardSearchByDoctorName);
		/*End of Time Label panelCardSearchByDoctorName*/

		
		/*Time panelCardSearchByDoctorName*/
		Time_panelCardSearchByDoctorName = new TimePicker();
		Time_panelCardSearchByDoctorName.getComponentToggleTimeMenuButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setToolTipText("Time");
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setFont(new Font("Kartika", Font.BOLD, 16));
		Time_panelCardSearchByDoctorName.setBounds(211, 328, 171, 36);
		Time_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		panelCardSearchByDoctorName.add(Time_panelCardSearchByDoctorName);
		/*End of Time panelCardSearchByDoctorName*/

		
		/*Search By Date Button panelCardSearchByDoctorName*/
		btnSearchByDate_panelCardSearchByDoctorName = new JButton("Search By Date");
		btnSearchByDate_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Search Invoice By Doctor Name and Date
				 */
				
								
				//check if Doctor Name or date field is empty 
				if(comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedIndex()==0 || Date_panelCardSearchByDoctorName.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please enter doctor name and date"); }
				
				// else continue after "check if Doctor Name or date field is empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByDoctorName.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Doctor_Name`=? AND `Date`=?");
						preparedatatement.setString(1, (String) comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedItem());
						preparedatatement.setString(2, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if date correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDoctorName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if date incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							// close database
							preparedatatement.close();

						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			}
		});
		btnSearchByDate_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByDate_panelCardSearchByDoctorName.setForeground(Color.WHITE);
		btnSearchByDate_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchByDate_panelCardSearchByDoctorName.setFocusable(false);
		btnSearchByDate_panelCardSearchByDoctorName.setBackground(new Color(102, 51, 153));
		btnSearchByDate_panelCardSearchByDoctorName.setBounds(393, 231, 247, 36);
		panelCardSearchByDoctorName.add(btnSearchByDate_panelCardSearchByDoctorName);
		/*End of Search By Date Button panelCardSearchByDoctorName*/

		
		/*Search By Time Button panelCardSearchByDoctorName*/
		btnSearchByTime_panelCardSearchByDoctorName = new JButton("Search By Time");
		btnSearchByTime_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Invoices by Doctor Name and Time
				 */
				
								
				//check if Doctor Name or time field is empty 
				if(comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedIndex()==0 || Time_panelCardSearchByDoctorName.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter doctor name and time"); }
				
				// else continue after "check if Doctor Name or time field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Doctor_Name`=? AND `Time`=?");
						preparedatatement.setString(1, (String) comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedItem());
						preparedatatement.setString(2, Time_panelCardSearchByDoctorName.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if time correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDoctorName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
						}
						
						// if date incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this time");
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			}
		});
		btnSearchByTime_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByTime_panelCardSearchByDoctorName.setForeground(Color.WHITE);
		btnSearchByTime_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchByTime_panelCardSearchByDoctorName.setFocusable(false);
		btnSearchByTime_panelCardSearchByDoctorName.setBackground(new Color(102, 51, 153));
		btnSearchByTime_panelCardSearchByDoctorName.setBounds(393, 282, 247, 36);
		panelCardSearchByDoctorName.add(btnSearchByTime_panelCardSearchByDoctorName);
		/*End of Search By Time Button panelCardSearchByDoctorName*/

		
		/*Search By Date and Time Button panelCardSearchByDoctorName*/
		btnByDateAndTime_panelCardSearchByDoctorName = new JButton("Search By Date and Time");
		btnByDateAndTime_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Invoice By Doctor Name,  Date & Time
				 */
				
								
				//check if Doctor Name, date or time field is empty 
				if(comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedIndex()==0 || Time_panelCardSearchByDoctorName.getText().isEmpty()
				  || Date_panelCardSearchByDoctorName.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter doctor name, date and time"); }
				
				// else continue after "check if Doctor Name, date or time field is empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByDoctorName.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementTime;
					

					try {
						
						// Check if date correct
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Doctor_Name`=? AND `Date`=?");
						preparedatatement.setString(1, (String) comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedItem());
						preparedatatement.setString(2, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if date correct
						if(resultset.next())
						{
							// close database
							preparedatatement.close();
							
							// Check if time correct
							preparedatatementTime = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Doctor_Name`=? AND `Date`=? AND `Time`=?");
							preparedatatementTime.setString(1, (String) comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedItem());
							preparedatatementTime.setString(2, DofB);
							preparedatatementTime.setString(3, Time_panelCardSearchByDoctorName.getText());
							ResultSet resultsetTime = preparedatatementTime.executeQuery();
							
							// if time correct
							if(resultsetTime.next())
							{
								ResultSet resaultset1 = preparedatatementTime.executeQuery();
								table_panelCardSearchByDoctorName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
								// close database
								preparedatatementTime.close();
								
							}
							
							// if time incorrect
							else
							{
								JOptionPane.showMessageDialog(null, "No Invoices on this time");
								// close database
								preparedatatementTime.close();
							}
	
							
						}
						
						// if date incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		});
		btnByDateAndTime_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnByDateAndTime_panelCardSearchByDoctorName.setForeground(Color.WHITE);
		btnByDateAndTime_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 17));
		btnByDateAndTime_panelCardSearchByDoctorName.setFocusable(false);
		btnByDateAndTime_panelCardSearchByDoctorName.setBackground(new Color(102, 51, 153));
		btnByDateAndTime_panelCardSearchByDoctorName.setBounds(393, 329, 247, 36);
		panelCardSearchByDoctorName.add(btnByDateAndTime_panelCardSearchByDoctorName);
		/*End of Search By Date and Time Button panelCardSearchByDoctorName*/

		
		/*ScrollPane panelCardSearchByDoctorName*/
		scrollPane_panelCardSearchByDoctorName = new JScrollPane();
		scrollPane_panelCardSearchByDoctorName.setBounds(10, 50, 630, 152);
		panelCardSearchByDoctorName.add(scrollPane_panelCardSearchByDoctorName);
		/*End of ScrollPane panelCardSearchByDoctorName*/

		
		/*Table panelCardSearchByDoctorName*/
		table_panelCardSearchByDoctorName = new JTable();
		table_panelCardSearchByDoctorName.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByDoctorName.setViewportView(table_panelCardSearchByDoctorName);
		/*End of Table panelCardSearchByDoctorName*/

		
		/*Search By Doctor Name Title Label panelCardSearchByDoctorName*/
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName = new JLabel("Search By Doctor Name Page");
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setFocusable(false);
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByDoctorNameTitle_panelCardSearchByDoctorName.setBounds(168, 0, 317, 36);
		panelCardSearchByDoctorName.add(lblSearchByDoctorNameTitle_panelCardSearchByDoctorName);
		/*End of Search By Doctor Name Title Label panelCardSearchByDoctorName*/
		
		
		/*Card Search By Invoice ID Panel*/
		panelCardSearchByInvoiceID = new JPanel();
		panelCardSearchByInvoiceID.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_panelCardSearchByInvoiceID();
			}
		});
		panelCardSearchByInvoiceID.setLayout(null);
		panelCardSearchByInvoiceID.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByInvoiceID, InvoicesSearchByInvoiceIDPanel);
		/*End of Card Search By Invoice ID Panel*/

		
		/*Back Button panelCardSearchByInvoiceID*/
		BtnBack_panelCardSearchByInvoiceID = new JButton();
		BtnBack_panelCardSearchByInvoiceID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_panelCardSearchByInvoiceID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Invoices Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesRecordPanel);
				
				// clear field and refresh table
				textFieldInvoiceID_panelCardSearchByInvoiceID.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByInvoiceID();
			}
		});
		BtnBack_panelCardSearchByInvoiceID.setText("Back");
		BtnBack_panelCardSearchByInvoiceID.setForeground(Color.WHITE);
		BtnBack_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_panelCardSearchByInvoiceID.setFocusable(false);
		BtnBack_panelCardSearchByInvoiceID.setBackground(new Color(204, 0, 0));
		BtnBack_panelCardSearchByInvoiceID.setBounds(221, 437, 105, 35);
		panelCardSearchByInvoiceID.add(BtnBack_panelCardSearchByInvoiceID);
		/*End of Back Button panelCardSearchByInvoiceID*/
		
		
		/*Clear Field Button panelCardSearchByInvoiceID*/
		BtnClearcField_panelCardSearchByInvoiceID = new JButton();
		BtnClearcField_panelCardSearchByInvoiceID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_panelCardSearchByInvoiceID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear field and refresh table
				textFieldInvoiceID_panelCardSearchByInvoiceID.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByInvoiceID();
			}
		});
		BtnClearcField_panelCardSearchByInvoiceID.setText("Clear");
		BtnClearcField_panelCardSearchByInvoiceID.setForeground(Color.WHITE);
		BtnClearcField_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_panelCardSearchByInvoiceID.setFocusable(false);
		BtnClearcField_panelCardSearchByInvoiceID.setBackground(new Color(46, 139, 87));
		BtnClearcField_panelCardSearchByInvoiceID.setBounds(336, 437, 105, 35);
		panelCardSearchByInvoiceID.add(BtnClearcField_panelCardSearchByInvoiceID);
		/*End of Clear Field Button panelCardSearchByInvoiceID*/
		
		
		/*Invoice ID Label panelCardSearchByInvoiceID*/
		lblInvoiceID_panelCardSearchByInvoiceID = new JLabel("Invoice ID");
		lblInvoiceID_panelCardSearchByInvoiceID.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID_panelCardSearchByInvoiceID.setForeground(Color.BLACK);
		lblInvoiceID_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblInvoiceID_panelCardSearchByInvoiceID.setFocusable(false);
		lblInvoiceID_panelCardSearchByInvoiceID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID_panelCardSearchByInvoiceID.setBounds(10, 289, 191, 36);
		panelCardSearchByInvoiceID.add(lblInvoiceID_panelCardSearchByInvoiceID);
		/*End of Invoice ID Label panelCardSearchByInvoiceID*/
		
		
		/*Search Button panelCardSearchByInvoiceID*/
		btnSearch_panelCardSearchByInvoiceID = new JButton("Search");
		btnSearch_panelCardSearchByInvoiceID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_panelCardSearchByInvoiceID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Invoice By Invoice ID
				 */
				
								
				//check if Invoice ID field is empty 
				if(textFieldInvoiceID_panelCardSearchByInvoiceID.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Invoice ID"); }
				
				// else continue after "check if Invoice ID field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `InvoiceID`=?");
						preparedatatement.setString(1, textFieldInvoiceID_panelCardSearchByInvoiceID.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice ID correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByInvoiceID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Invoice ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Invoice ID not exist");
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			}
		});
		btnSearch_panelCardSearchByInvoiceID.setForeground(Color.WHITE);
		btnSearch_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearch_panelCardSearchByInvoiceID.setFocusable(false);
		btnSearch_panelCardSearchByInvoiceID.setBackground(new Color(102, 51, 153));
		btnSearch_panelCardSearchByInvoiceID.setBounds(393, 289, 247, 36);
		panelCardSearchByInvoiceID.add(btnSearch_panelCardSearchByInvoiceID);
		/*End of Search Button panelCardSearchByInvoiceID*/

		
		
		/*ScrollPane panelCardSearchByInvoiceID*/
		scrollPane_panelCardSearchByInvoiceID = new JScrollPane();
		scrollPane_panelCardSearchByInvoiceID.setBounds(10, 75, 630, 191);
		panelCardSearchByInvoiceID.add(scrollPane_panelCardSearchByInvoiceID);
		/*End of ScrollPane panelCardSearchByInvoiceID*/

		
		/*Table panelCardSearchByInvoiceID*/
		table_panelCardSearchByInvoiceID = new JTable();
		table_panelCardSearchByInvoiceID.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByInvoiceID.setViewportView(table_panelCardSearchByInvoiceID);
		/*End of Table panelCardSearchByInvoiceID*/

		
		/*Invoice ID textField panelCardSearchByInvoiceID*/
		textFieldInvoiceID_panelCardSearchByInvoiceID = new JTextField();
		textFieldInvoiceID_panelCardSearchByInvoiceID.setToolTipText("Invoice ID");
		textFieldInvoiceID_panelCardSearchByInvoiceID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldInvoiceID_panelCardSearchByInvoiceID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldInvoiceID_panelCardSearchByInvoiceID.setColumns(10);
		textFieldInvoiceID_panelCardSearchByInvoiceID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldInvoiceID_panelCardSearchByInvoiceID.setBounds(211, 289, 171, 36);
		panelCardSearchByInvoiceID.add(textFieldInvoiceID_panelCardSearchByInvoiceID);
		/*End of Invoice ID textField panelCardSearchByInvoiceID*/

		
		/*Show All Cancelled Invoices Button panelCardSearchByInvoiceID*/
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID = new JButton("Show All Cancelled Invoices");
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Show Cancelled Invoices
				 */
				
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Status`=?");
						preparedatatement.setString(1, "Cancelled");
						ResultSet resultset = preparedatatement.executeQuery();
					
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_panelCardSearchByInvoiceID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						// close database
						preparedatatement.close();

						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }

			}
		});
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setForeground(Color.WHITE);
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 14));
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setFocusable(false);
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setBackground(new Color(102, 51, 153));
		btnShowAllcancelledInvoices_panelCardSearchByInvoiceID.setBounds(393, 336, 247, 36);
		panelCardSearchByInvoiceID.add(btnShowAllcancelledInvoices_panelCardSearchByInvoiceID);
		/*End of Show All Cancelled Invoices Button panelCardSearchByInvoiceID*/
		
		
		/*Show All Current Invoices Button panelCardSearchByInvoiceID*/
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID = new JButton("Show All Current Invoices");
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show Current Invoices
				 */
				
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Status`=?");
						preparedatatement.setString(1, "Current");
						ResultSet resultset = preparedatatement.executeQuery();
					
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_panelCardSearchByInvoiceID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						// close database
						preparedatatement.close();

						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }

			
			}
		});
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setForeground(Color.WHITE);
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 14));
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setFocusable(false);
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setBackground(new Color(102, 51, 153));
		btnShowAllCurrentInvoices_panelCardSearchByInvoiceID.setBounds(393, 383, 247, 36);
		panelCardSearchByInvoiceID.add(btnShowAllCurrentInvoices_panelCardSearchByInvoiceID);
		/*End of Show All Current Invoices Button panelCardSearchByInvoiceID*/

		
		/*Search By Invoice ID Title Label panelCardSearchByInvoiceID*/
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID = new JLabel("Search By Invoice ID Page");
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setForeground(Color.BLACK);
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setFocusable(false);
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID.setBounds(168, 0, 317, 36);
		panelCardSearchByInvoiceID.add(lblSearchByInvoiceIDTitle_panelCardSearchByInvoiceID);
		/*End of Search By Invoice ID Title Label panelCardSearchByInvoiceID*/
		
		
		/*Card Search By Patient ID Panel*/
		panelCardSearchByPatientID = new JPanel();
		panelCardSearchByPatientID.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_panelCardSearchByPatientID();
				
				// Clear ComBox
				comboBoxDoctorName_panelCardSearchByPatientID.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
				
				// Get Doctors Names From Database and set them into comboBox
				GetDoctorsNames_panelCardSearchByPatientID();
			}
		});
		panelCardSearchByPatientID.setLayout(null);
		panelCardSearchByPatientID.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByPatientID, InvoicesSearchByPatientIDPanel);
		/*End of Card Search By Patient ID Panel*/

		
		/*Back Button panelCardSearchByPatientID*/
		BtnBack_panelCardSearchByPatientID = new JButton();
		BtnBack_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesRecordPanel);
				
				// clear field and refresh table
				textFieldPatientID_panelCardSearchByPatientID.setText(null);
				Date_panelCardSearchByPatientID.setDate(null);
				ShowDatabaseDataToTable_panelCardSearchByPatientID();
				
				// clear comboBox
				comboBoxDoctorName_panelCardSearchByPatientID.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
				comboBoxDoctorName_panelCardSearchByPatientID.setSelectedIndex(0);

			}
		});
		BtnBack_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_panelCardSearchByPatientID.setText("Back");
		BtnBack_panelCardSearchByPatientID.setForeground(Color.WHITE);
		BtnBack_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnBack_panelCardSearchByPatientID.setFocusable(false);
		BtnBack_panelCardSearchByPatientID.setBackground(new Color(204, 0, 0));
		BtnBack_panelCardSearchByPatientID.setBounds(221, 450, 105, 35);
		panelCardSearchByPatientID.add(BtnBack_panelCardSearchByPatientID);
		/*End of Back Button panelCardSearchByPatientID*/

		
		/*Clear Fields Button panelCardSearchByPatientID*/
		BtnClearFields_panelCardSearchByPatientID = new JButton();
		BtnClearFields_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear field and refresh table
				textFieldPatientID_panelCardSearchByPatientID.setText(null);
				comboBoxDoctorName_panelCardSearchByPatientID.setSelectedIndex(0);
				Date_panelCardSearchByPatientID.setDate(null);
				ShowDatabaseDataToTable_panelCardSearchByPatientID();
			}
		});
		BtnClearFields_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardSearchByPatientID.setText("Clear");
		BtnClearFields_panelCardSearchByPatientID.setForeground(Color.WHITE);
		BtnClearFields_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_panelCardSearchByPatientID.setFocusable(false);
		BtnClearFields_panelCardSearchByPatientID.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardSearchByPatientID.setBounds(336, 450, 105, 35);
		panelCardSearchByPatientID.add(BtnClearFields_panelCardSearchByPatientID);
		/*End of Clear Fields Button panelCardSearchByPatientID*/
		
		
		/*comboBox Doctor Name panelCardSearchByPatientID*/
		comboBoxDoctorName_panelCardSearchByPatientID = new JComboBox();
		comboBoxDoctorName_panelCardSearchByPatientID.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
		comboBoxDoctorName_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDoctorName_panelCardSearchByPatientID.setToolTipText("Choose Doctor");
		comboBoxDoctorName_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxDoctorName_panelCardSearchByPatientID.setFocusable(false);
		comboBoxDoctorName_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxDoctorName_panelCardSearchByPatientID.setBackground(Color.WHITE);
		comboBoxDoctorName_panelCardSearchByPatientID.setBounds(211, 277, 171, 36);
		panelCardSearchByPatientID.add(comboBoxDoctorName_panelCardSearchByPatientID);
		/*End of comboBox Doctor Name panelCardSearchByPatientID*/
		
		
		/*Doctor Name Label panelCardSearchByPatientID*/
		lblDoctorName_panelCardSearchByPatientID = new JLabel("Doctor Name");
		lblDoctorName_panelCardSearchByPatientID.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_panelCardSearchByPatientID.setForeground(Color.BLACK);
		lblDoctorName_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_panelCardSearchByPatientID.setFocusable(false);
		lblDoctorName_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_panelCardSearchByPatientID.setBounds(10, 276, 191, 36);
		panelCardSearchByPatientID.add(lblDoctorName_panelCardSearchByPatientID);
		/*End of Doctor Name Label panelCardSearchByPatientID*/

		
		/*Date Label panelCardSearchByPatientID*/
		lblDate_panelCardSearchByPatientID = new JLabel("Date");
		lblDate_panelCardSearchByPatientID.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardSearchByPatientID.setForeground(Color.BLACK);
		lblDate_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardSearchByPatientID.setFocusable(false);
		lblDate_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardSearchByPatientID.setBounds(10, 328, 191, 36);
		panelCardSearchByPatientID.add(lblDate_panelCardSearchByPatientID);
		/*End of Date Label panelCardSearchByPatientID*/

		
		/*Date panelCardSearchByPatientID*/
		Date_panelCardSearchByPatientID = new JDateChooser();
		Date_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardSearchByPatientID.setToolTipText("Date");
		Date_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardSearchByPatientID.setBounds(211, 328, 171, 36);
		panelCardSearchByPatientID.add(Date_panelCardSearchByPatientID);
		/*End of Date panelCardSearchByPatientID*/
		
		
		/*Patient ID Label panelCardSearchByPatientID*/
		lblPatientID_panelCardSearchByPatientID = new JLabel("Patient ID");
		lblPatientID_panelCardSearchByPatientID.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_panelCardSearchByPatientID.setForeground(Color.BLACK);
		lblPatientID_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_panelCardSearchByPatientID.setFocusable(false);
		lblPatientID_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_panelCardSearchByPatientID.setBounds(11, 230, 191, 36);
		panelCardSearchByPatientID.add(lblPatientID_panelCardSearchByPatientID);
		/*End of Patient ID Label panelCardSearchByPatientID*/

		
		/*Search By Date Button panelCardSearchByPatientID*/
		btnSearchByDate_panelCardSearchByPatientID = new JButton("Search By Date ");
		btnSearchByDate_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Invoice By Patient ID and Date
				 */
				
								
				//check if Patient ID or date field is empty 
				if(textFieldPatientID_panelCardSearchByPatientID.getText().isEmpty() || Date_panelCardSearchByPatientID.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID and Date"); }
				
				// else continue after "check if Patient ID or date field is empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByPatientID.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementPatientID;
					try {
						
						// check if patient ID exist
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
						// close database
						preparedatatementPatientID.close();
						
						
						// check if Invoice exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? AND `Date`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Invoice not exist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							// close database
							preparedatatement.close();
						}

						
						}
						
					    //if patient ID not exist
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong!! Patient ID not exist please check patient ID");
							// close database
							preparedatatementPatientID.close();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			}
		});
		btnSearchByDate_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByDate_panelCardSearchByPatientID.setForeground(Color.WHITE);
		btnSearchByDate_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchByDate_panelCardSearchByPatientID.setFocusable(false);
		btnSearchByDate_panelCardSearchByPatientID.setBackground(new Color(102, 51, 153));
		btnSearchByDate_panelCardSearchByPatientID.setBounds(393, 230, 247, 36);
		panelCardSearchByPatientID.add(btnSearchByDate_panelCardSearchByPatientID);
		/*End of Search By Date Button panelCardSearchByPatientID*/

		
		/*Search By Doctor Name Button panelCardSearchByPatientID*/
		btnSearchByDoctorName_panelCardSearchByPatientID = new JButton("Search By Doctor Name");
		btnSearchByDoctorName_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Invoice By Patient ID and Doctor Name
				 */
				
								
				// check if Patient ID or Doctor Name field is empty 
				if(textFieldPatientID_panelCardSearchByPatientID.getText().isEmpty() || comboBoxDoctorName_panelCardSearchByPatientID.getSelectedIndex()==0)
					
				{ JOptionPane.showMessageDialog(null, "Please enter doctor name and patient ID "); }
				
				// else continue after "check if Patient ID or Doctor Name field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementPatientID;
					try {
						
						// check if patient ID exist
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
						// close database
						preparedatatementPatientID.close();
						
						
						// check if Invoice exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? AND `Doctor_Name`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, (String) comboBoxDoctorName_panelCardSearchByPatientID.getSelectedItem());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Invoice not exist
						else
						{
							JOptionPane.showMessageDialog(null, "There are no Invoices");
							// close database
							preparedatatement.close();
						}

						
						}
						
					    //if patient ID not exist
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong!! patient ID not exist please check patient ID");
							// close database
							preparedatatementPatientID.close();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		});
		btnSearchByDoctorName_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByDoctorName_panelCardSearchByPatientID.setForeground(Color.WHITE);
		btnSearchByDoctorName_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchByDoctorName_panelCardSearchByPatientID.setFocusable(false);
		btnSearchByDoctorName_panelCardSearchByPatientID.setBackground(new Color(102, 51, 153));
		btnSearchByDoctorName_panelCardSearchByPatientID.setBounds(393, 281, 247, 36);
		panelCardSearchByPatientID.add(btnSearchByDoctorName_panelCardSearchByPatientID);
		/*End of Search By Doctor Name Button panelCardSearchByPatientID*/

		
		/*Search By Date and Doctor Name Button panelCardSearchByPatientID*/
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID = new JButton("Search by Date and Doctor");
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				/*
				 *     Search Invoice By Patient ID and Doctor Name and Date
				 */
				
								
				// check if Patient ID or Doctor Name and Date fields is empty 
				if(textFieldPatientID_panelCardSearchByPatientID.getText().isEmpty() || comboBoxDoctorName_panelCardSearchByPatientID.getSelectedIndex()==0
				  || Date_panelCardSearchByPatientID.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID, doctor name and date"); }
				
				// else continue after "check if Patient ID or Doctor Name and Date fields is empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByPatientID.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementPatientID;
					PreparedStatement preparedatatementDate;

					try {
						
						// check if patient ID exist
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
							// close database
							preparedatatementPatientID.close();
							
							// check if this date exist
							preparedatatementDate = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? AND `Date`=?");
							preparedatatementDate.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
							preparedatatementDate.setString(2, DofB);
							ResultSet resultsetDate = preparedatatementDate.executeQuery();
							
						//if this date exist
						if(resultsetDate.next()) 
						{
							
						// close database
						preparedatatementDate.close();	
						
						// check if Invoice exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? AND `Doctor_Name`=? AND `Date`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, (String) comboBoxDoctorName_panelCardSearchByPatientID.getSelectedItem());
						preparedatatement.setString(3, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Invoice not exist
						else
						{
							JOptionPane.showMessageDialog(null, "There are no Invoices");
							// close database
							preparedatatement.close();
							
						}

						
						}
							
						//if this date not exist
						else 
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							// close database
							preparedatatementDate.close();
						}

							
						}
						
					    //if patient ID not exist
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong!! patient ID not exist please check patient ID");
							// close database
							preparedatatementPatientID.close();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			
			}
		});
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setForeground(Color.WHITE);
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setFocusable(false);
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setBackground(new Color(102, 51, 153));
		btnSearchByDateAndDoctorName_panelCardSearchByPatientID.setBounds(393, 328, 247, 36);
		panelCardSearchByPatientID.add(btnSearchByDateAndDoctorName_panelCardSearchByPatientID);
		/*End of Search By Date and Doctor Name Button panelCardSearchByPatientID*/
		
		
		/*ScrollPane panelCardSearchByPatientID*/
		scrollPane_panelCardSearchByPatientID = new JScrollPane();
		scrollPane_panelCardSearchByPatientID.setBounds(10, 49, 630, 152);
		panelCardSearchByPatientID.add(scrollPane_panelCardSearchByPatientID);
		/*End of ScrollPane panelCardSearchByPatientID*/

		
		/*Table panelCardSearchByPatientID*/
		table_panelCardSearchByPatientID = new JTable();
		table_panelCardSearchByPatientID.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByPatientID.setViewportView(table_panelCardSearchByPatientID);
		/*End of Table panelCardSearchByPatientID*/

		
		/*Patient ID textField panelCardSearchByPatientID*/
		textFieldPatientID_panelCardSearchByPatientID = new JTextField();
		textFieldPatientID_panelCardSearchByPatientID.setToolTipText("Patient ID");
		textFieldPatientID_panelCardSearchByPatientID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientID_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientID_panelCardSearchByPatientID.setColumns(10);
		textFieldPatientID_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientID_panelCardSearchByPatientID.setBounds(211, 230, 171, 36);
		panelCardSearchByPatientID.add(textFieldPatientID_panelCardSearchByPatientID);
		/*End of Patient ID textField panelCardSearchByPatientID*/

		
		/*Search All Button panelCardSearchByPatientID*/
		btnSearchAll_panelCardSearchByPatientID = new JButton("Search All Appointments");
		btnSearchAll_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search All Patient Invoices By Patient ID
				 */
				
								
				// check if Patient ID field is empty 
				if(textFieldPatientID_panelCardSearchByPatientID.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
				
				// else continue after "check if Patient ID field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatementPatientID;
					try {
						
						// check if patient ID exist
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							ResultSet resaultset1 = preparedatatementPatientID.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));
							//close database
							preparedatatementPatientID.close();
						}
						
						
					    //if patient ID not exist
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong!! patient ID not exist please check patient ID");
							//close database
							preparedatatementPatientID.close();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		});
		btnSearchAll_panelCardSearchByPatientID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchAll_panelCardSearchByPatientID.setForeground(Color.WHITE);
		btnSearchAll_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearchAll_panelCardSearchByPatientID.setFocusable(false);
		btnSearchAll_panelCardSearchByPatientID.setBackground(new Color(102, 51, 153));
		btnSearchAll_panelCardSearchByPatientID.setBounds(393, 375, 247, 36);
		panelCardSearchByPatientID.add(btnSearchAll_panelCardSearchByPatientID);
		/*End of Search All Button panelCardSearchByPatientID*/

		
		/*Search By Patient ID Title Label panelCardSearchByPatientID*/
		lblSearchByPatientIDTitle_panelCardSearchByPatientID = new JLabel("Search By Patient ID Page");
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setForeground(Color.BLACK);
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setFocusable(false);
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByPatientIDTitle_panelCardSearchByPatientID.setBounds(168, 0, 317, 36);
		panelCardSearchByPatientID.add(lblSearchByPatientIDTitle_panelCardSearchByPatientID);
		/*End of Search By Patient ID Title Label panelCardSearchByPatientID*/
		
		
		/*Card Search By Date and Service Panel*/
		panelCardSearchByDateAndService = new JPanel();
		panelCardSearchByDateAndService.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_panelCardSearchByDateAndService();
				
			}
		});
		panelCardSearchByDateAndService.setLayout(null);
		panelCardSearchByDateAndService.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByDateAndService, InvoicesSearchByDateAndServicePanel);
		/*End of Card Search By Date and Service Panel*/

		
		/*Back Button panelCardSearchByDateAndService*/
		BtnBack_panelCardSearchByDateAndService = new JButton();
		BtnBack_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesRecordPanel);
				
				// clear field and refresh table
				Date_panelCardSearchByDateAndService.setDate(null);
				Time_panelCardSearchByDateAndService.setText(null);
				comboBoxService_panelCardSearchByDateAndService.setSelectedIndex(0);
				ShowDatabaseDataToTable_panelCardSearchByDateAndService();
			}
		});
		BtnBack_panelCardSearchByDateAndService.setText("Back");
		BtnBack_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		BtnBack_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		BtnBack_panelCardSearchByDateAndService.setFocusable(false);
		BtnBack_panelCardSearchByDateAndService.setBackground(new Color(204, 0, 0));
		BtnBack_panelCardSearchByDateAndService.setBounds(220, 450, 105, 35);
		panelCardSearchByDateAndService.add(BtnBack_panelCardSearchByDateAndService);
		/*End of Back Button panelCardSearchByDateAndService*/
		
		
		/*Clear Fields Button panelCardSearchByDateAndService*/
		BtnClearFields_panelCardSearchByDateAndService = new JButton();
		BtnClearFields_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear field and refresh table
				Date_panelCardSearchByDateAndService.setDate(null);
				Time_panelCardSearchByDateAndService.setText(null);
				comboBoxService_panelCardSearchByDateAndService.setSelectedIndex(0);
				ShowDatabaseDataToTable_panelCardSearchByDateAndService();
				
			}
		});
		BtnClearFields_panelCardSearchByDateAndService.setText("Clear");
		BtnClearFields_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		BtnClearFields_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		BtnClearFields_panelCardSearchByDateAndService.setFocusable(false);
		BtnClearFields_panelCardSearchByDateAndService.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardSearchByDateAndService.setBounds(335, 450, 105, 35);
		panelCardSearchByDateAndService.add(BtnClearFields_panelCardSearchByDateAndService);
		/*End of Clear Fields Button panelCardSearchByDateAndService*/
		
		
		/*Date Label panelCardSearchByDateAndService*/
		lblDate_panelCardSearchByDateAndService = new JLabel("Date");
		lblDate_panelCardSearchByDateAndService.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardSearchByDateAndService.setForeground(Color.BLACK);
		lblDate_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardSearchByDateAndService.setFocusable(false);
		lblDate_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardSearchByDateAndService.setBounds(10, 241, 191, 36);
		panelCardSearchByDateAndService.add(lblDate_panelCardSearchByDateAndService);
		/*End of Date Label panelCardSearchByDateAndService*/

		
		/*Date panelCardSearchByDateAndService*/
		Date_panelCardSearchByDateAndService = new JDateChooser();
		Date_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardSearchByDateAndService.setToolTipText("التاريخ");
		Date_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardSearchByDateAndService.setBounds(212, 241, 171, 36);
		panelCardSearchByDateAndService.add(Date_panelCardSearchByDateAndService);
		/*End of Date panelCardSearchByDateAndService*/
		
		
		/*Time Label panelCardSearchByDateAndService*/
		lblTime_panelCardSearchByDateAndService = new JLabel("Time");
		lblTime_panelCardSearchByDateAndService.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardSearchByDateAndService.setForeground(Color.BLACK);
		lblTime_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardSearchByDateAndService.setFocusable(false);
		lblTime_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardSearchByDateAndService.setBounds(10, 335, 191, 36);
		panelCardSearchByDateAndService.add(lblTime_panelCardSearchByDateAndService);
		/*End of Time Label panelCardSearchByDateAndService*/

		
		/*Time panelCardSearchByDateAndService*/
		Time_panelCardSearchByDateAndService = new TimePicker();
		Time_panelCardSearchByDateAndService.getComponentTimeTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardSearchByDateAndService.getComponentTimeTextField().setToolTipText("Time");
		Time_panelCardSearchByDateAndService.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time_panelCardSearchByDateAndService.getComponentTimeTextField().setFont(new Font("Kartika", Font.BOLD, 16));
		Time_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Time_panelCardSearchByDateAndService.setBounds(212, 339, 171, 36);
		panelCardSearchByDateAndService.add(Time_panelCardSearchByDateAndService);
		/*End of Time panelCardSearchByDateAndService*/

		
		/*Search All This Date Invoices Button panelCardSearchByDateAndService*/
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService = new JButton("Search Date All Invoices");
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Invoice By Date_ All date Invoices
				 */
				
								
				// check if Date field is empty 
				if(Date_panelCardSearchByDateAndService.getDate()==null)
					
				{ JOptionPane.showMessageDialog(null, "Please enter date"); }
				
				// else continue after "check if Date field is empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByDateAndService.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice Date Exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							//close database 
							preparedatatement.close();	
						}
						
						// if Invoice Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							//close database 
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		});
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchAllThisDateInvoices_panelCardSearchByDateAndService.setBounds(393, 240, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchAllThisDateInvoices_panelCardSearchByDateAndService);
		/*End of Search All This Date Invoices Button panelCardSearchByDateAndService*/

		
		/*Search By Service Button panelCardSearchByDateAndService*/
		btnSearchByService_panelCardSearchByDateAndService = new JButton("Search By Service");
		btnSearchByService_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				/*
				 *     Search Invoice By Date_ Date & Service
				 */
				
								
				// check if Date & Service fields are empty 
				if(Date_panelCardSearchByDateAndService.getDate()==null || comboBoxService_panelCardSearchByDateAndService.getSelectedIndex()==0)
					
				{ JOptionPane.showMessageDialog(null, "Please enter date and service"); }
				
				// else continue after "check if Date & Service fields are empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByDateAndService.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementService;

					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice Date Exist
						if(resultset.next())
						{
							// close database
							preparedatatement.close();
							
							// check Invoice Service match Date
							preparedatatementService = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Service`=? AND `Date`=?");
							preparedatatementService.setString(1, (String) comboBoxService_panelCardSearchByDateAndService.getSelectedItem());
							preparedatatementService.setString(2, DofB);
							ResultSet resultsetService = preparedatatementService.executeQuery();
							
							// if Invoice Service match Date
                            if(resultsetService.next())
                            {
							ResultSet resaultset1 = preparedatatementService.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));
							// close database
							preparedatatementService.close();
                            }
                            
                            // if Invoice Service Not match Date
                            else
                            {
                            	JOptionPane.showMessageDialog(null, "No Invoice for this service");
                            	// close database
    							preparedatatementService.close();
                            }
                            
						}
						
						// if Invoice Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoice on this date");
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			}
		});
		btnSearchByService_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByService_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchByService_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		btnSearchByService_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchByService_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchByService_panelCardSearchByDateAndService.setBounds(393, 291, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchByService_panelCardSearchByDateAndService);
		/*End of Search By Service Button panelCardSearchByDateAndService*/

		
		/*Search By Date and Time Button panelCardSearchByDateAndService*/
		btnSearchByDateAndTime_panelCardSearchByDateAndService = new JButton("Search By Date and Time");
		btnSearchByDateAndTime_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Invoice By Date_ Date & Time
				 */
				
								
				// check if Date & Time fields are empty 
				if(Date_panelCardSearchByDateAndService.getDate()==null || Time_panelCardSearchByDateAndService.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter date and time"); }
				
				// else continue after "check if Date & Time fields are empty "
				else          
				{
					
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardSearchByDateAndService.getDate());
					// End date to string
					
					PreparedStatement preparedatatement;
					PreparedStatement preparedatatementTime;

					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoice Date Exist
						if(resultset.next())
						{
							// close datbase
							preparedatatement.close();
							
							// check Invoice Time match Date
							preparedatatementTime = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Time`=? AND `Date`=?");
							preparedatatementTime.setString(1, Time_panelCardSearchByDateAndService.getText());
							preparedatatementTime.setString(2, DofB);
							ResultSet resultsetTime = preparedatatementTime.executeQuery();
							
							// if Invoice Time match Date
                            if(resultsetTime.next())
                            {
							ResultSet resaultset1 = preparedatatementTime.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));
							// close database
							preparedatatementTime.close();
                            }
                            
                            // if Invoice Time Not match Date
                            else
                            {
                            	JOptionPane.showMessageDialog(null, "No Invoices on this time");
                            	// close database
    							preparedatatementTime.close();
                            }
                            
						}
						
						// if Invoice Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices on this date");
							// close datbase
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			
				
			}
		});
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchByDateAndTime_panelCardSearchByDateAndService.setBounds(393, 338, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchByDateAndTime_panelCardSearchByDateAndService);
		/*End of Search By Date and Time Button panelCardSearchByDateAndService*/
		
		
		/*ScrollPane panelCardSearchByDateAndService*/
		scrollPane_panelCardSearchByDateAndService = new JScrollPane();
		scrollPane_panelCardSearchByDateAndService.setBounds(10, 61, 630, 152);
		panelCardSearchByDateAndService.add(scrollPane_panelCardSearchByDateAndService);
		/*End of ScrollPane panelCardSearchByDateAndService*/

		
		/*Table panelCardSearchByDateAndService*/
		table_panelCardSearchByDateAndService = new JTable();
		table_panelCardSearchByDateAndService.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByDateAndService.setViewportView(table_panelCardSearchByDateAndService);
		/*End of Table panelCardSearchByDateAndService*/
		
		
		/*Service Label panelCardSearchByDateAndService*/
		lblService_panelCardSearchByDateAndService = new JLabel("Service");
		lblService_panelCardSearchByDateAndService.setHorizontalAlignment(SwingConstants.CENTER);
		lblService_panelCardSearchByDateAndService.setForeground(Color.BLACK);
		lblService_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 20));
		lblService_panelCardSearchByDateAndService.setFocusable(false);
		lblService_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblService_panelCardSearchByDateAndService.setBounds(10, 288, 191, 36);
		panelCardSearchByDateAndService.add(lblService_panelCardSearchByDateAndService);
		/*End of Service Label panelCardSearchByDateAndService*/

		
		/*comboBox Service panelCardSearchByDateAndService*/
		comboBoxService_panelCardSearchByDateAndService = new JComboBox();
		comboBoxService_panelCardSearchByDateAndService.setModel(new DefaultComboBoxModel(new String[] {"Choose Service", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxService_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxService_panelCardSearchByDateAndService.setToolTipText("Choose Service");
		comboBoxService_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxService_panelCardSearchByDateAndService.setFocusable(false);
		comboBoxService_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxService_panelCardSearchByDateAndService.setBackground(Color.WHITE);
		comboBoxService_panelCardSearchByDateAndService.setBounds(211, 288, 171, 36);
		panelCardSearchByDateAndService.add(comboBoxService_panelCardSearchByDateAndService);
		/*End of comboBox Service panelCardSearchByDateAndService*/

		
		/*Search All This Service Invoices Button panelCardSearchByDateAndService*/
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService = new JButton("Search Service All Invoices");
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Invoice By Date_ All Service Invoices
				 */
				
								
				// check if Service field is empty 
				if(comboBoxService_panelCardSearchByDateAndService.getSelectedIndex()==0)
					
				{ JOptionPane.showMessageDialog(null, "Please select service "); }
				
				// else continue after "check if Service field is empty "
				else          
				{
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Service`=?");
						preparedatatement.setString(1, (String) comboBoxService_panelCardSearchByDateAndService.getSelectedItem());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Invoices By This Service Exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							//close database
							preparedatatement.close();
						}
						
						// if Invoices By This Service Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices for this service");
							//close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			}
		});
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 13));
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService.setBounds(393, 385, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchAllThisServiceInvoices_panelCardSearchByDateAndService);
		/*End of Search All This Service Invoices Button panelCardSearchByDateAndService*/

		
		/*End of Search By Date And Service Title Label panelCardSearchByDateAndService*/
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService = new JLabel("Search By Date And Service Page");
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setForeground(Color.BLACK);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setFocusable(false);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setBounds(158, 0, 343, 36);
		panelCardSearchByDateAndService.add(lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService);
		/*End of Search By Date And Service Title Label panelCardSearchByDateAndService*/

		
		/*Card Search By Receptionist Name Panel*/
		panelCardSearchByReceptionistName = new JPanel();
		panelCardSearchByReceptionistName.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_panelCardSearchByReceptionistName();
			}
		});
		panelCardSearchByReceptionistName.setLayout(null);
		panelCardSearchByReceptionistName.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByReceptionistName, InvoicesSearchByReceptionistNamePanel);
		/*End of Card Search By Receptionist Name Panel*/
		
		
		/*Back Button panelCardSearchByReceptionistName*/
		BtnBack_panelCardSearchByReceptionistName = new JButton();
		BtnBack_panelCardSearchByReceptionistName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, InvoicesRecordPanel);
				
				// clear field and refresh table
				textFieldReceptionistName_panelCardSearchByReceptionistName.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByReceptionistName();
			}
		});
		BtnBack_panelCardSearchByReceptionistName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_panelCardSearchByReceptionistName.setText("Back");
		BtnBack_panelCardSearchByReceptionistName.setForeground(Color.WHITE);
		BtnBack_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_panelCardSearchByReceptionistName.setFocusable(false);
		BtnBack_panelCardSearchByReceptionistName.setBackground(new Color(204, 0, 0));
		BtnBack_panelCardSearchByReceptionistName.setBounds(221, 437, 105, 35);
		panelCardSearchByReceptionistName.add(BtnBack_panelCardSearchByReceptionistName);
		/*End of Back Button panelCardSearchByReceptionistName*/

		
		/*Clear Field Button panelCardSearchByReceptionistName*/
		BtnClearcField_panelCardSearchByReceptionistName = new JButton();
		BtnClearcField_panelCardSearchByReceptionistName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear field and refresh table
				textFieldReceptionistName_panelCardSearchByReceptionistName.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByReceptionistName();
			}
		});
		BtnClearcField_panelCardSearchByReceptionistName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_panelCardSearchByReceptionistName.setText("Clear");
		BtnClearcField_panelCardSearchByReceptionistName.setForeground(Color.WHITE);
		BtnClearcField_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_panelCardSearchByReceptionistName.setFocusable(false);
		BtnClearcField_panelCardSearchByReceptionistName.setBackground(new Color(46, 139, 87));
		BtnClearcField_panelCardSearchByReceptionistName.setBounds(336, 437, 105, 35);
		panelCardSearchByReceptionistName.add(BtnClearcField_panelCardSearchByReceptionistName);
		/*End of Clear Field Button panelCardSearchByReceptionistName*/

		
		/*Receptionist Name Label panelCardSearchByReceptionistName*/
		lblReceptionistName_panelCardSearchByReceptionistName = new JLabel("Receptionist Name");
		lblReceptionistName_panelCardSearchByReceptionistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistName_panelCardSearchByReceptionistName.setForeground(Color.BLACK);
		lblReceptionistName_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistName_panelCardSearchByReceptionistName.setFocusable(false);
		lblReceptionistName_panelCardSearchByReceptionistName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistName_panelCardSearchByReceptionistName.setBounds(10, 289, 191, 36);
		panelCardSearchByReceptionistName.add(lblReceptionistName_panelCardSearchByReceptionistName);
		/*End of Receptionist Name Label panelCardSearchByReceptionistName*/
		
		
		/*Show Added By Button panelCardSearchByReceptionistName*/
		btnShowAddedBy_panelCardSearchByReceptionistName = new JButton("Show Added By");
		btnShowAddedBy_panelCardSearchByReceptionistName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Show Invoices Added By Specific Receptionist
				 */
				
								
				// Invoicescheck if Receptionist Name field is empty 
				if(textFieldReceptionistName_panelCardSearchByReceptionistName.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter receptionist name"); }
				
				// else continue after "check if Receptionist Name field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Add_By_Receptionist`=?");
						preparedatatement.setString(1, textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if there are Invoices added by this receptionist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByReceptionistName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if there are no Invoices added by this receptionist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices Added By This Receptionist: "
						    +textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		});
		btnShowAddedBy_panelCardSearchByReceptionistName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAddedBy_panelCardSearchByReceptionistName.setForeground(Color.WHITE);
		btnShowAddedBy_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 16));
		btnShowAddedBy_panelCardSearchByReceptionistName.setFocusable(false);
		btnShowAddedBy_panelCardSearchByReceptionistName.setBackground(new Color(102, 51, 153));
		btnShowAddedBy_panelCardSearchByReceptionistName.setBounds(393, 289, 247, 36);
		panelCardSearchByReceptionistName.add(btnShowAddedBy_panelCardSearchByReceptionistName);
		/*End of Show Added By Button panelCardSearchByReceptionistName*/

		
		/*scrollPane panelCardSearchByReceptionistName*/
		scrollPane_panelCardSearchByReceptionistName = new JScrollPane();
		scrollPane_panelCardSearchByReceptionistName.setBounds(10, 64, 630, 191);
		panelCardSearchByReceptionistName.add(scrollPane_panelCardSearchByReceptionistName);
		/*End of scrollPane panelCardSearchByReceptionistName*/
		
		
		/*table panelCardSearchByReceptionistName*/
		table_panelCardSearchByReceptionistName = new JTable();
		table_panelCardSearchByReceptionistName.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByReceptionistName.setViewportView(table_panelCardSearchByReceptionistName);
		/*End of table panelCardSearchByReceptionistName*/
		
		
		/*Receptionist Name textField panelCardSearchByReceptionistName*/
		textFieldReceptionistName_panelCardSearchByReceptionistName = new JTextField();
		textFieldReceptionistName_panelCardSearchByReceptionistName.setToolTipText("Receptionist Name");
		textFieldReceptionistName_panelCardSearchByReceptionistName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistName_panelCardSearchByReceptionistName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldReceptionistName_panelCardSearchByReceptionistName.setColumns(10);
		textFieldReceptionistName_panelCardSearchByReceptionistName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistName_panelCardSearchByReceptionistName.setBounds(211, 289, 171, 36);
		panelCardSearchByReceptionistName.add(textFieldReceptionistName_panelCardSearchByReceptionistName);
		/*End of Receptionist Name textField panelCardSearchByReceptionistName*/
		
		
		/*Show Updated By Button panelCardSearchByReceptionistName*/
		btnShowUpdatedBy_panelCardSearchByReceptionistName = new JButton("Show Updated By");
		btnShowUpdatedBy_panelCardSearchByReceptionistName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {



				/*
				 *     Show Invoices Updated By Specific Receptionist
				 */
				
								
				// check if Receptionist Name field is empty 
				if(textFieldReceptionistName_panelCardSearchByReceptionistName.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter receptionist name"); }
				
				// else continue after "check if Receptionist Name field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Updated_By_Receptionist`=?");
						preparedatatement.setString(1, textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if there are updated Invoices by this receptionist 
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByReceptionistName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if there are no updated Invoices by this receptionist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices Updated By This Receptionist: "
						    +textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			}
		
		});
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setForeground(Color.WHITE);
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 16));
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setFocusable(false);
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setBackground(new Color(102, 51, 153));
		btnShowUpdatedBy_panelCardSearchByReceptionistName.setBounds(393, 336, 247, 36);
		panelCardSearchByReceptionistName.add(btnShowUpdatedBy_panelCardSearchByReceptionistName);
		/*End of Show Updated By Button panelCardSearchByReceptionistName*/

		
		/*Show Cancelled By Button panelCardSearchByReceptionistName*/
		btnShowCancelledBy_panelCardSearchByReceptionistName = new JButton("Show Cancelled By");
		btnShowCancelledBy_panelCardSearchByReceptionistName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				/*
				 *     Show Invoices Cancelled By Specific Receptionist
				 */
				
								
				// check if Receptionist Name field is empty 
				if(textFieldReceptionistName_panelCardSearchByReceptionistName.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter receptionist name"); }
				
				// else continue after "check if Receptionist Name field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `Cancelled_By_Receptionist`=?");
						preparedatatement.setString(1, textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if there are cancelled Invoices by this receptionist 
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByReceptionistName.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if there are no cancelled Invoices by this receptionist
						else
						{
							JOptionPane.showMessageDialog(null, "No Invoices Cancelled By This Receptionist: "
						    +textFieldReceptionistName_panelCardSearchByReceptionistName.getText());
							// close database
							preparedatatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
				
			
			
			
			}
		});
		btnShowCancelledBy_panelCardSearchByReceptionistName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowCancelledBy_panelCardSearchByReceptionistName.setForeground(Color.WHITE);
		btnShowCancelledBy_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 16));
		btnShowCancelledBy_panelCardSearchByReceptionistName.setFocusable(false);
		btnShowCancelledBy_panelCardSearchByReceptionistName.setBackground(new Color(102, 51, 153));
		btnShowCancelledBy_panelCardSearchByReceptionistName.setBounds(393, 383, 247, 36);
		panelCardSearchByReceptionistName.add(btnShowCancelledBy_panelCardSearchByReceptionistName);
		/*End of Show Cancelled By Button panelCardSearchByReceptionistName*/

		
		/*Search By Receptionis tName Title Label panelCardSearchByReceptionistName*/
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName = new JLabel("Search By Receptionist Name Page");
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setForeground(Color.BLACK);
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setFocusable(false);
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName.setBounds(143, 0, 359, 36);
		panelCardSearchByReceptionistName.add(lblSearchByReceptionistNameTitle_panelCardSearchByReceptionistName);
		/*End of Search By Receptionis tName Title Label panelCardSearchByReceptionistName*/
		
		

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
    * *************************************************************************************************
    *    Get Doctors Names From database and set them into comboBox panelCardSearchByDoctorName Method
    * *************************************************************************************************
    */
   public void GetDoctorsNames_panelCardSearchByDoctorName()
	{
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedstatment = connection.prepareStatement("SELECT * FROM `Doctors`");
			ResultSet resultset;
			resultset = preparedstatment.executeQuery();
			
			while(resultset.next())
			{
				String DoctorsNames = resultset.getString(3)+" "+resultset.getString(4);
				comboBoxSearchDoctorName_panelCardSearchByDoctorName.addItem(DoctorsNames);
			}
			
			// close database
			preparedstatment.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   /*
    * *****************************************************************************************************
    *  End of Get Doctors Names From database and set them into comboBox panelCardSearchByDoctorName Method
    * ******************************************************************************************************
    */
   
   
   
   /*
    * *******************************************************************************************************
    *    Get Doctors Names From database and set them into comboBox panelCardSearchByPatientID Method
    * *******************************************************************************************************
    */
   public void GetDoctorsNames_panelCardSearchByPatientID()
	{
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedstatment = connection.prepareStatement("SELECT * FROM `Doctors`");
			ResultSet resultset;
			resultset = preparedstatment.executeQuery();
			
			while(resultset.next())
			{
				String DoctorsNames = resultset.getString(3)+" "+resultset.getString(4);
				comboBoxDoctorName_panelCardSearchByPatientID.addItem(DoctorsNames);
			}
			
			// close database
			preparedstatment.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
   
   /*
    * *******************************************************************************************************
    *  End of  Get Doctors Names From database and set them into comboBox panelCardSearchByPatientID Method
    * *******************************************************************************************************
    */
   
   
   
   
   /*
    * *******************************************************************
    *     Show data from database on table _ panelCardSearchByDoctorName
    * *******************************************************************
    */
	
	public static void ShowDatabaseDataToTablepanelCardSearchByDoctorName()
	{
		 
		try {
			
			connection = ConnectionFactory.getConnection();
			Statement statment   = connection.createStatement();
			ResultSet resaultset = statment.executeQuery("SELECT * FROM `Invoices`");

			table_panelCardSearchByDoctorName.setModel(DbUtils.resultSetToTableModel(resaultset));
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(0).setPreferredWidth(20);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(1).setPreferredWidth(130);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(2).setPreferredWidth(80);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(3).setPreferredWidth(100);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(4).setPreferredWidth(80);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(5).setPreferredWidth(100);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(6).setPreferredWidth(120);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(7).setPreferredWidth(80);
			table_panelCardSearchByDoctorName.getColumnModel().getColumn(8).setPreferredWidth(130);
			
			// close database
			statment.close();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	  /*
	    * **********************************************************************
	    * End of Show data from database on table _ panelCardSearchByDoctorName
	    * **********************************************************************
	    */
	
	
	
	
	/*
	    * **********************************************************************
	    *     Show data from database on table _ panelCardSearchByInvoiceID
	    * **********************************************************************
	    */
		
		public static void ShowDatabaseDataToTable_panelCardSearchByInvoiceID()
		{
			 
			try {
				
				connection = ConnectionFactory.getConnection();
				Statement statment   = connection.createStatement();
				ResultSet resaultset = statment.executeQuery("SELECT * FROM `Invoices`");

				table_panelCardSearchByInvoiceID.setModel(DbUtils.resultSetToTableModel(resaultset));
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(0).setPreferredWidth(20);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(1).setPreferredWidth(130);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(2).setPreferredWidth(80);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(3).setPreferredWidth(100);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(4).setPreferredWidth(80);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(5).setPreferredWidth(100);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(6).setPreferredWidth(120);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(7).setPreferredWidth(80);
				table_panelCardSearchByInvoiceID.getColumnModel().getColumn(8).setPreferredWidth(130);
				
				// close database
				statment.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		/*
		    * **************************************************************************
		    *  End of Show data from database on table _ panelCardSearchByInvoiceID
		    * **************************************************************************
		    */
		
		
		
		
		/*
		    * ******************************************************************
		    *     Show data from database on table _ panelCardSearchByPatientID
		    * ******************************************************************
		    */
			
			public static void ShowDatabaseDataToTable_panelCardSearchByPatientID()
			{
				 
				try {
					
					connection = ConnectionFactory.getConnection();
					Statement statment   = connection.createStatement();
					ResultSet resaultset = statment.executeQuery("SELECT * FROM `Invoices`");

					table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset));
					table_panelCardSearchByPatientID.getColumnModel().getColumn(0).setPreferredWidth(20);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(1).setPreferredWidth(130);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(2).setPreferredWidth(80);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(3).setPreferredWidth(100);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(4).setPreferredWidth(80);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(5).setPreferredWidth(100);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(6).setPreferredWidth(120);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(7).setPreferredWidth(80);
					table_panelCardSearchByPatientID.getColumnModel().getColumn(8).setPreferredWidth(130);
					
					// close database
					statment.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			/*
			    * *********************************************************************
			    * End of Show data from database on table _ panelCardSearchByPatientID
			    * *********************************************************************
			    */
			
			
	
			
			/*
			    * ***********************************************************************
			    *     Show data from database on table _ panelCardSearchByDateAndService
			    * ***********************************************************************
			    */
				
				public static void ShowDatabaseDataToTable_panelCardSearchByDateAndService()
				{
					 
					try {
						
						connection = ConnectionFactory.getConnection();
						Statement statment   = connection.createStatement();
						ResultSet resaultset = statment.executeQuery("SELECT * FROM `Invoices`");

						table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset));
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(0).setPreferredWidth(20);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(1).setPreferredWidth(130);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(2).setPreferredWidth(80);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(3).setPreferredWidth(100);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(4).setPreferredWidth(80);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(5).setPreferredWidth(100);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(6).setPreferredWidth(100);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(7).setPreferredWidth(80);
						table_panelCardSearchByDateAndService.getColumnModel().getColumn(8).setPreferredWidth(130);
						
						// close database
						statment.close();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				/*
				    * ****************************************************************************
				    *   End of Show data from database on table _ panelCardSearchByDateAndService
				    * ****************************************************************************
				    */
				
				
				
				
				/*
				    * *************************************************************************
				    *     Show data from database on table _ panelCardSearchByReceptionistName
				    * *************************************************************************
				    */
					
					public static void ShowDatabaseDataToTable_panelCardSearchByReceptionistName()
					{
						 
						try {
							
							connection = ConnectionFactory.getConnection();
							Statement statment   = connection.createStatement();
							ResultSet resaultset = statment.executeQuery("SELECT * FROM `Invoices`");

							table_panelCardSearchByReceptionistName.setModel(DbUtils.resultSetToTableModel(resaultset));
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(0).setPreferredWidth(20);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(1).setPreferredWidth(130);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(2).setPreferredWidth(80);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(3).setPreferredWidth(100);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(4).setPreferredWidth(80);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(5).setPreferredWidth(100);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(6).setPreferredWidth(100);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(7).setPreferredWidth(80);
							table_panelCardSearchByReceptionistName.getColumnModel().getColumn(8).setPreferredWidth(130);
							
							// close database
							statment.close();

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					/*
					    * ******************************************************************************
					    *   End of Show data from database on table _ panelCardSearchByReceptionistName
					    * ******************************************************************************
					    */
				
				
				
				
				
}
