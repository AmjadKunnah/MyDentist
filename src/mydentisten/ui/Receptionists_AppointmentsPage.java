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

public class Receptionists_AppointmentsPage extends JInternalFrame {

	/*Variables*/
	
	//JLabel
	private JLabel labelAppointmentsRecord_panelCardMain;
	private JLabel labelAddAppointment_panelCardMain;
	private JLabel labelSearchByAppointmentID_panelCardAppointmentsRecord;
	private JLabel lblServicePrice_panelCardAddAppointment;
	private JLabel lblAppointmentsID_panelCardAddAppointment;
	private JLabel lblDoctorName_panelCardAddAppointment;
	private JLabel lblDate_panelCardAddAppointment;
	private JLabel lblTime_panelCardAddAppointment;
	private JLabel lblService_panelCardAddAppointment;
	private JLabel lblPatientID_panelCardAddAppointment;
	private JLabel labelSearchByDoctorName_panelCardAppointmentsRecord;
	private JLabel labelSearchByDoctorName2_panelCardAppointmentsRecord;
	private JLabel labelSearchByPatientID_panelCardAppointmentsRecord;
	private JLabel labelSearchByPatientID2_panelCardAppointmentsRecord;
	private JLabel labelSearchByDate_panelCardAppointmentsRecord;
    private JLabel labelSearchByDate2_panelCardAppointmentsRecord;
    private JLabel lblSearchDoctorName_panelCardSearchByDoctorName;
    private JLabel lblDate_panelCardSearchByDoctorName;
    private JLabel lblTime_panelCardSearchByDoctorName;
    private JLabel lblAppointmentID_panelCardSearchByAppointmentID;
    private JLabel lblDoctorName_panelCardSearchByPatientID;
    private JLabel lblDate_panelCardSearchByPatientID;
    private JLabel labelSearchByAppointmentID1_panelCardAppointmentsRecord;
    private JLabel lblPatientID_panelCardSearchByPatientID;
    private JLabel lblDate_panelCardSearchByDateAndService;
    private JLabel lblTime_panelCardSearchByDateAndService;
    private JLabel lblService_panelCardSearchByDateAndService;
    private JLabel lblInvoiceID_panelCardAddAppointment;
    private JLabel labelUpdateAppointment_panelCardMain;
    private JLabel labelUpdateAppointment2_panelCardMain;
    private JLabel labelCancelAppointment_panelCardMain;
    private JLabel labelCancelAppointment2_panelCardMain;
    private JLabel labelAppointmentsRecord2_panelCardMain;
    private JLabel labelAddAppointment2_panelCardMain;
    private JLabel lblAppointmentsID_panelCardUpdateAppointment;
    private static JLabel lblAppointmentsID2_panelCardUpdateAppointment;
    private JLabel lblPatientID_panelCardUpdateAppointment;
    private JLabel lblDoctorName_panelCardUpdateAppointment;
    private JLabel lblDate_panelCardUpdateAppointment;
    private JLabel lblTime_panelCardUpdateAppointment;
    private JLabel lblService_panelCardUpdateAppointment;
    private JLabel lblServicePrice_panelCardUpdateAppointment;
    private JLabel lblInvoiceID_panelCardUpdateAppointment;
    private static JLabel lblInvoiceID2_panelCardUpdateAppointment;
    private JLabel lblAppointmentSearch_panelCardUpdateAppointment;
    private JLabel lblAppointmentsSearchEnterID_panelCardUpdateAppointment;
    private JLabel lblAppointmentsID_panelCardCancelAppointment;
    private static JLabel lblAppointmentsID2_panelCardCancelAppointment;
    private JLabel lblPatientID_panelCardCancelAppointment;
    private JLabel lblDoctorName_panelCardCancelAppointment;
    private JLabel lblTime_panelCardCancelAppointment;
    private JLabel lblService_panelCardCancelAppointment;
    private JLabel lblDate_panelCardCancelAppointment;
    private JLabel lblServicePrice_panelCardCancelAppointment;
    private JLabel lblInvoiceID_panelCardCancelAppointment;
    private static JLabel lblInvoiceID2_panelCardCancelAppointment;
    private JLabel lblAppointmentSearch_panelCardCancelAppointment;
    private JLabel lblAppointmentsSearchEnterID_panelCardCancelAppointment;
	private static JLabel lblAppointmentsID2_panelCardAddAppointment;
    private static JLabel lblInvoiceID2_panelCardAddAppointment;
    private JLabel labelAndByStatus_panelCardAppointmentsRecord;
    private JLabel lblAddAppointmentTitle_panelCardAddAppointment;
    private JLabel lblUpdateAppointmentTitle_panelCardUpdateAppointment;
    private JLabel lblCancelAppointmentTitle_panelCardCancelAppointment;
    private JLabel lblAppointmentsRecordTitle_panelCardAppointmentsRecord;
    private JLabel lblSearchByDoctorNameTitle_panelCardSearchByDoctorName;
    private JLabel lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID;
    private JLabel lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService;
    private JLabel lblSearchByPatientIDTitle_panelCardSearchByPatientID;

    //String
	final static String  AppointmentsRecordPanel = "Appointments Record";
	final static String  AddAppointmentPanel = "Add Appointment";
	final static String  UpdateAppointmentPanel = "Update Appointment";
	final static String  CancelAppointmentPanel = "Cancel Appointment";
	final static String  AppointmentsMainPanel = "Appointments Main";
	final static String  AppointmentsSearchByDoctorNamePanel = "Search By Doctor Name";
	final static String  AppointmentsSearchByAppointmentIDPanel = "Search By Appointment ID";
	final static String  AppointmentsSearchByPatientIDPanel = "Search By Patient ID";
	final static String  AppointmentsSearchByDateAndServicePanel = "Search By Date And Service";
	public String receptionists_Name;
	private JButton BtnNewAppointmentID_panelCardAddAppointment;
	private JButton BtnBookAppointment_panelCardAddAppointment;
	private JButton BtnClearFields_panelCardAddAppointment;
	private JButton backBtn_panelCardAddAppointment;
	private JButton btnSearchAll_panelCardSearchByPatientID;
	private JButton backBtn_panelCardAppointmentsRecord;
	private JButton backBtn_panelCardSearchByDoctorName;
    private JButton BtnClearFields_panelCardSearchByDoctorName;
    private JButton btnSearchByDate_panelCardSearchByDoctorName;
    private JButton btnSearchByTime_panelCardSearchByDoctorName;
    private JButton btnByDateAndTime_panelCardSearchByDoctorName;
    private JButton BtnBack_panelCardSearchByAppointmentID;
    private JButton BtnClearcField_panelCardSearchByAppointmentID;
    private JButton btnSearch_panelCardSearchByAppointmentID;
    private JButton BtnBack_panelCardSearchByPatientID;
    private JButton BtnClearFields_panelCardSearchByPatientID;
    private JButton btnSearchByDate_panelCardSearchByPatientID;
    private JButton btnSearchByDoctorName_panelCardSearchByPatientID;
    private JButton btnSearchByDateAndDoctorName_panelCardSearchByPatientID;
    private JButton BtnBack_panelCardSearchByDateAndService;
    private JButton BtnClearFields_panelCardSearchByDateAndService;
    private JButton btnSearchAllThisDateAppointments_panelCardSearchByDateAndService;
    private JButton btnSearchByService_panelCardSearchByDateAndService;
    private JButton btnSearchByDateAndTime_panelCardSearchByDateAndService;
    private JButton btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService;
    private JButton BtnNewInvoiceID_panelCardAddAppointment;
    private JButton btnAppointmentSearch_panelCardUpdateAppointment;
    private JButton BtnUpdateAppointment_panelCardUpdateAppointment;
    private JButton BtnClearFields_panelCardUpdateAppointment;
    private JButton backBtn_panelCardUpdateAppointment;
    private JButton btnAppointmentSearch_panelCardCancelAppointment;
    private JButton BtnCancelAppointment_panelCardCancelAppointment;
    private JButton BtnClearFields_panelCardCancelAppointment;
    private JButton backBtn_panelCardCancelAppointment;
    private JButton btnShowAllcancelledAppointments_panelCardSearchByAppointmentID;
    private JButton btnShowAllCurrentAppointments_panelCardSearchByAppointmentID;

    //JTextField
    private static JTextField textFieldPatientID_panelCardAddAppointment;
    private static JTextField textFieldServicePrice_panelCardAddAppointment;
    private JTextField textFieldAppointmentID_panelCardSearchByAppointmentID;
    private JTextField textFieldPatientID_panelCardSearchByPatientID;
    private static JTextField textFieldPatientID_panelCardUpdateAppointment;
    private static JTextField textFieldServicePrice_panelCardUpdateAppointment;
    private static JTextField textFieldEnterAppointmentID_panelCardUpdateAppointment;
    private static JTextField textFieldPatientID_panelCardCancelAppointment;
    private static JTextField textFieldServicePrice_panelCardCancelAppointment;
    private static JTextField textFieldEnterAppointmentID_panelCardCancelAppointment;

    //JComboBox
	private static JComboBox comboBoxService_panelCardAddAppointment;
	private static JComboBox comboBoxDoctorName_panelCardAddAppointment;
    private JComboBox comboBoxSearchDoctorName_panelCardSearchByDoctorName;
    private JComboBox comboBoxDoctorName_panelCardSearchByPatientID;
    private JComboBox comboBoxService_panelCardSearchByDateAndService;
    private static JComboBox comboBoxDoctorName_panelCardUpdateAppointment;
    private static JComboBox comboBoxService_panelCardUpdateAppointment;
    private static JComboBox comboBoxDoctorName_panelCardCancelAppointment;
    private static JComboBox comboBoxService_panelCardCancelAppointment;

    //JDateChooser
	private static JDateChooser Date_panelCardAddAppointment;
    private JDateChooser Date_panelCardSearchByDoctorName;
    private JDateChooser Date_panelCardSearchByPatientID;
    private JDateChooser Date_panelCardSearchByDateAndService;
    private static JDateChooser Date_panelCardUpdateAppointment;
    private static JDateChooser Date_panelCardCancelAppointment;

    //TimePicker
	private static TimePicker Time__panelCardAddAppointment;
	private static TimePicker Time_panelCardSearchByDoctorName;
    private TimePicker Time_panelCardSearchByDateAndService;
    private static TimePicker Time_panelCardUpdateAppointment;
    private static TimePicker Time_panelCardCancelAppointment;

    //Connection
    private static Connection connection;   
    
    //JScrollPane
    private JScrollPane scrollPane_panelCardSearchByDoctorName;
    private JScrollPane scrollPane_panelCardSearchByAppointmentID;
    private JScrollPane scrollPane_panelCardSearchByPatientID;
    private JScrollPane scrollPane_panelCardSearchByDateAndService;

    //JTable
    private static JTable table_panelCardSearchByDoctorName;
    private static JTable table_panelCardSearchByAppointmentID;
    private static JTable table_panelCardSearchByPatientID;
    private static JTable table_panelCardSearchByDateAndService;
    
    // JSeparator
    private JSeparator separatorHorizontal;
    private JSeparator separatorVertical;
	/*End of Variables*/


    
	/*Panels*/
    private JPanel panelCards;
	private JPanel panelCardMain;
	private JPanel panelAppointmentsRecord_panelCardMain;
	private JPanel panelCardAppointmentsRecord;
	private JPanel panelAddAppointment_panelCardMain;
	private JPanel panelCardAddAppointment;
    private JPanel panelCardSearchByDoctorName;
    private JPanel panelSearchByDoctorName_panelCardAppointmentsRecord;
    private JPanel panelSearchByPatientID_panelCardAppointmentsRecord;
    private JPanel panelSearchByDate_panelCardAppointmentsRecord;
    private JPanel panelCardSearchByAppointmentID;
    private JPanel panelCardSearchByPatientID;
    private JPanel panelCardSearchByDateAndService;
    private JPanel panelSearchByAppointmentID_panelCardAppointmentsRecord;
    private JPanel panelUpdateAppointment_panelCardMain;
    private JPanel panelCancelAppointment_panelCardMain;
    private JPanel panelCardUpdateAppointment;
    private JPanel panelAppointmentSearch_panelCardUpdateAppointment;
    private JPanel panelCardCancelAppointment;
    private JPanel panelAppointmentSearch_panelCardCancelAppointment;
	/*End Of Panels*/

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionists_AppointmentsPage frame = new Receptionists_AppointmentsPage();
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
	public Receptionists_AppointmentsPage() {
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

		
		/*Card Main Panel*/
		panelCardMain = new JPanel();
		panelCardMain.setBackground(Color.WHITE);
		panelCards.add(panelCardMain, AppointmentsMainPanel);
		panelCardMain.setLayout(null);
		/*End of Card Main Panel*/

		
		/*Appointments Record Panel panelCardMain*/
		panelAppointmentsRecord_panelCardMain = new JPanel();
		panelAppointmentsRecord_panelCardMain.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Appointments Record Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsRecordPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAppointmentsRecord_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAppointmentsRecord_panelCardMain.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAppointmentsRecord_panelCardMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAppointmentsRecord_panelCardMain.setBackground(new Color(216, 191, 216));
			}
		});
		panelAppointmentsRecord_panelCardMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAppointmentsRecord_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAppointmentsRecord_panelCardMain.setBackground(Color.WHITE);
		panelAppointmentsRecord_panelCardMain.setBounds(387, 278, 180, 167);
		panelCardMain.add(panelAppointmentsRecord_panelCardMain);
		panelAppointmentsRecord_panelCardMain.setLayout(null);
		/*End of Appointments Record Panel panelCardMain*/

		
		/*Appointments Record Label panelCardMain*/
		labelAppointmentsRecord_panelCardMain = new JLabel("Appointments");
		labelAppointmentsRecord_panelCardMain.setForeground(Color.BLACK);
		labelAppointmentsRecord_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelAppointmentsRecord_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAppointmentsRecord_panelCardMain.setBounds(10, 58, 160, 35);
		panelAppointmentsRecord_panelCardMain.add(labelAppointmentsRecord_panelCardMain);
		/*End of Appointments Record Label panelCardMain*/

		
		/*Appointments Record2 Label panelCardMain*/
		labelAppointmentsRecord2_panelCardMain = new JLabel("Record");
		labelAppointmentsRecord2_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelAppointmentsRecord2_panelCardMain.setForeground(Color.BLACK);
		labelAppointmentsRecord2_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAppointmentsRecord2_panelCardMain.setBounds(10, 90, 160, 35);
		panelAppointmentsRecord_panelCardMain.add(labelAppointmentsRecord2_panelCardMain);
		/*End of Appointments Record2 Label panelCardMain*/

		
		/*Add Appointment Panel panelCardMain*/
		panelAddAppointment_panelCardMain = new JPanel();
		panelAddAppointment_panelCardMain.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Add Appointment Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AddAppointmentPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAddAppointment_panelCardMain.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddAppointment_panelCardMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAddAppointment_panelCardMain.setBackground(new Color(216, 191, 216));
			}
		});
		panelAddAppointment_panelCardMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAddAppointment_panelCardMain.setLayout(null);
		panelAddAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAddAppointment_panelCardMain.setBackground(Color.WHITE);
		panelAddAppointment_panelCardMain.setBounds(78, 47, 180, 167);
		panelCardMain.add(panelAddAppointment_panelCardMain);
		/*End of Add Appointment Panel panelCardMain*/

		
		/*Add Appointment Label panelCardMain*/
		labelAddAppointment_panelCardMain = new JLabel("Add");
		labelAddAppointment_panelCardMain.setForeground(Color.BLACK);
		labelAddAppointment_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddAppointment_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddAppointment_panelCardMain.setBounds(10, 58, 160, 35);
		panelAddAppointment_panelCardMain.add(labelAddAppointment_panelCardMain);
		/*End of Add Appointment Label panelCardMain*/

		
		/*Add Appointment2 Label panelCardMain*/
		labelAddAppointment2_panelCardMain = new JLabel("Appointment");
		labelAddAppointment2_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddAppointment2_panelCardMain.setForeground(Color.BLACK);
		labelAddAppointment2_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddAppointment2_panelCardMain.setBounds(10, 91, 160, 35);
		panelAddAppointment_panelCardMain.add(labelAddAppointment2_panelCardMain);
		/*End of Add Appointment2 Label panelCardMain*/

		
		/*Card Appointments Record Panel*/
		panelCardAppointmentsRecord = new JPanel();
		panelCardAppointmentsRecord.setBorder(new LineBorder(Color.WHITE, 8, true));
		panelCardAppointmentsRecord.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show database when window open
				//ShowDatabaseDataToTableSearchStaff();
			}
		});
		panelCardAppointmentsRecord.setBackground(Color.WHITE);
		panelCards.add(panelCardAppointmentsRecord, AppointmentsRecordPanel);
		panelCardAppointmentsRecord.setLayout(null);
		/*End of Card Appointments Record Panel*/

		
		/*Card Add Appointment Panel*/
		panelCardAddAppointment = new JPanel();
		panelCardAddAppointment.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// New Appointment ID
				RandomAppointmentID();
				
				// New Invoice ID
				RandomInvoiceID();
				
				// Clear ComBox
				comboBoxDoctorName_panelCardAddAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

				// Get Doctors Names From Database and set them into comboBox
				GetDoctorsNames();
			}
		});
		panelCardAddAppointment.setLayout(null);
		panelCardAddAppointment.setBackground(Color.WHITE);
		panelCards.add(panelCardAddAppointment, AddAppointmentPanel);
		/*End of Card Add Appointment Panel*/

		
		
	    /*
		 *  Add cards to panel card
		 */
		panelCards.add(panelCardMain, AppointmentsMainPanel);
		panelCards.add(panelCardAppointmentsRecord, AppointmentsRecordPanel);

		
		
		/*Update Appointment Panel panelCardMain*/
		panelUpdateAppointment_panelCardMain = new JPanel();
		panelUpdateAppointment_panelCardMain.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Update Appointment Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, UpdateAppointmentPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdateAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelUpdateAppointment_panelCardMain.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdateAppointment_panelCardMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelUpdateAppointment_panelCardMain.setBackground(new Color(216, 191, 216));
			}
		});
		panelUpdateAppointment_panelCardMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUpdateAppointment_panelCardMain.setLayout(null);
		panelUpdateAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelUpdateAppointment_panelCardMain.setBackground(Color.WHITE);
		panelUpdateAppointment_panelCardMain.setBounds(387, 47, 180, 167);
		panelCardMain.add(panelUpdateAppointment_panelCardMain);
		/*End of Update Appointment Panel panelCardMain*/
		
		
		/*Update Appointment Label panelCardMain*/
		labelUpdateAppointment_panelCardMain = new JLabel("Update");
		labelUpdateAppointment_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateAppointment_panelCardMain.setForeground(Color.BLACK);
		labelUpdateAppointment_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateAppointment_panelCardMain.setBounds(10, 58, 160, 35);
		panelUpdateAppointment_panelCardMain.add(labelUpdateAppointment_panelCardMain);
		/*End of Update Appointment Label panelCardMain*/
		
		
		/*Update Appointment2 Label panelCardMain*/
		labelUpdateAppointment2_panelCardMain = new JLabel("Appointment");
		labelUpdateAppointment2_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateAppointment2_panelCardMain.setForeground(Color.BLACK);
		labelUpdateAppointment2_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateAppointment2_panelCardMain.setBounds(10, 89, 160, 35);
		panelUpdateAppointment_panelCardMain.add(labelUpdateAppointment2_panelCardMain);
		/*End of Update Appointment2 Label panelCardMain*/
		
		
		/*Cancel Appointment Panel panelCardMain*/
		panelCancelAppointment_panelCardMain = new JPanel();
		panelCancelAppointment_panelCardMain.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Cancel Appointment Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, CancelAppointmentPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelCancelAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelCancelAppointment_panelCardMain.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCancelAppointment_panelCardMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelCancelAppointment_panelCardMain.setBackground(new Color(216, 191, 216));
			}
		});
		panelCancelAppointment_panelCardMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelCancelAppointment_panelCardMain.setLayout(null);
		panelCancelAppointment_panelCardMain.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelCancelAppointment_panelCardMain.setBackground(Color.WHITE);
		panelCancelAppointment_panelCardMain.setBounds(78, 278, 180, 167);
		panelCardMain.add(panelCancelAppointment_panelCardMain);
		/*End of Cancel Appointment Panel panelCardMain*/

		
		/*Cancel Appointment Label panelCardMain*/
		labelCancelAppointment_panelCardMain = new JLabel("Cancel");
		labelCancelAppointment_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelCancelAppointment_panelCardMain.setForeground(Color.BLACK);
		labelCancelAppointment_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelCancelAppointment_panelCardMain.setBounds(10, 58, 160, 35);
		panelCancelAppointment_panelCardMain.add(labelCancelAppointment_panelCardMain);
		/*End of Cancel Appointment Label panelCardMain*/

		
		/*Cancel Appointment2 Label panelCardMain*/
		labelCancelAppointment2_panelCardMain = new JLabel("Appointment");
		labelCancelAppointment2_panelCardMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelCancelAppointment2_panelCardMain.setForeground(Color.BLACK);
		labelCancelAppointment2_panelCardMain.setFont(new Font("Kartika", Font.BOLD, 20));
		labelCancelAppointment2_panelCardMain.setBounds(10, 88, 160, 35);
		panelCancelAppointment_panelCardMain.add(labelCancelAppointment2_panelCardMain);
		/*End of Cancel Appointment2 Label panelCardMain*/

		
		/*Separator Horizontal panelCardMain*/
		separatorHorizontal = new JSeparator();
		separatorHorizontal.setForeground(new Color(216, 191, 216));
		separatorHorizontal.setBorder(null);
		separatorHorizontal.setBackground(new Color(102, 51, 153));
		separatorHorizontal.setBounds(154, 243, 343, 2);
		panelCardMain.add(separatorHorizontal);
		/*End of Separator Horizontal panelCardMain*/
		
		
		/*Separator Vertical panelCardMain*/
		separatorVertical = new JSeparator();
		separatorVertical.setOrientation(SwingConstants.VERTICAL);
		separatorVertical.setForeground(new Color(216, 191, 216));
		separatorVertical.setBorder(null);
		separatorVertical.setBackground(new Color(102, 51, 153));
		separatorVertical.setBounds(322, 80, 2, 343);
		panelCardMain.add(separatorVertical);
		/*End of Separator Vertical panelCardMain*/
		
		
		/*Back Button panelCardAppointmentsRecord*/
		backBtn_panelCardAppointmentsRecord = new JButton();
		backBtn_panelCardAppointmentsRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardAppointmentsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Main Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsMainPanel);
			}
		});
		backBtn_panelCardAppointmentsRecord.setText("Back");
		backBtn_panelCardAppointmentsRecord.setForeground(Color.WHITE);
		backBtn_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardAppointmentsRecord.setFocusable(false);
		backBtn_panelCardAppointmentsRecord.setBackground(new Color(204, 0, 0));
		backBtn_panelCardAppointmentsRecord.setBounds(265, 425, 105, 35);
		panelCardAppointmentsRecord.add(backBtn_panelCardAppointmentsRecord);
		/*End of Back Button panelCardAppointmentsRecord*/
		
		
		/*Search By Appointment ID Panel panelCardAppointmentsRecord*/
		panelSearchByAppointmentID_panelCardAppointmentsRecord = new JPanel();
		panelSearchByAppointmentID_panelCardAppointmentsRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Appointments Search By Appointment ID Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsSearchByAppointmentIDPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByAppointmentID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByAppointmentID_panelCardAppointmentsRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByAppointmentID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByAppointmentID_panelCardAppointmentsRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByAppointmentID_panelCardAppointmentsRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByAppointmentID_panelCardAppointmentsRecord.setLayout(null);
		panelSearchByAppointmentID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByAppointmentID_panelCardAppointmentsRecord.setBackground(Color.WHITE);
		panelSearchByAppointmentID_panelCardAppointmentsRecord.setBounds(366, 93, 249, 118);
		panelCardAppointmentsRecord.add(panelSearchByAppointmentID_panelCardAppointmentsRecord);
		/*End of Search By Appointment ID Panel panelCardAppointmentsRecord*/

		
		/*Search By Appointment ID Label panelCardAppointmentsRecord*/
		labelSearchByAppointmentID_panelCardAppointmentsRecord = new JLabel("Search By :");
		labelSearchByAppointmentID_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByAppointmentID_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByAppointmentID_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByAppointmentID_panelCardAppointmentsRecord.setBounds(10, 11, 223, 38);
		panelSearchByAppointmentID_panelCardAppointmentsRecord.add(labelSearchByAppointmentID_panelCardAppointmentsRecord);
		/*End of Search By Appointment ID Label panelCardAppointmentsRecord*/
		
		
		/*Search By Appointment ID 1 Label panelCardAppointmentsRecord*/
		labelSearchByAppointmentID1_panelCardAppointmentsRecord = new JLabel("Appointment ID");
		labelSearchByAppointmentID1_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByAppointmentID1_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByAppointmentID1_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByAppointmentID1_panelCardAppointmentsRecord.setBounds(10, 39, 223, 38);
		panelSearchByAppointmentID_panelCardAppointmentsRecord.add(labelSearchByAppointmentID1_panelCardAppointmentsRecord);
		/*End of Search By Appointment ID 1 Label panelCardAppointmentsRecord*/
		
		
		/*And By Status Label panelCardAppointmentsRecord*/
		labelAndByStatus_panelCardAppointmentsRecord = new JLabel("And By Status");
		labelAndByStatus_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelAndByStatus_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelAndByStatus_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAndByStatus_panelCardAppointmentsRecord.setBounds(10, 69, 223, 38);
		panelSearchByAppointmentID_panelCardAppointmentsRecord.add(labelAndByStatus_panelCardAppointmentsRecord);
		/*End of And By Status Label panelCardAppointmentsRecord*/

		
		/*Search By Doctor Name Panel panelCardAppointmentsRecord*/
		panelSearchByDoctorName_panelCardAppointmentsRecord = new JPanel();
		panelSearchByDoctorName_panelCardAppointmentsRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Appointments Search By Doctor Name Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsSearchByDoctorNamePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByDoctorName_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByDoctorName_panelCardAppointmentsRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByDoctorName_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByDoctorName_panelCardAppointmentsRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByDoctorName_panelCardAppointmentsRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByDoctorName_panelCardAppointmentsRecord.setLayout(null);
		panelSearchByDoctorName_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByDoctorName_panelCardAppointmentsRecord.setBackground(Color.WHITE);
		panelSearchByDoctorName_panelCardAppointmentsRecord.setBounds(36, 93, 249, 118);
		panelCardAppointmentsRecord.add(panelSearchByDoctorName_panelCardAppointmentsRecord);
		/*End of Search By Doctor Name Panel panelCardAppointmentsRecord*/

		
		
		/*Search By Doctor Name Label panelCardAppointmentsRecord*/
		labelSearchByDoctorName_panelCardAppointmentsRecord = new JLabel("Search By:");
		labelSearchByDoctorName_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDoctorName_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByDoctorName_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDoctorName_panelCardAppointmentsRecord.setBounds(10, 11, 223, 38);
		panelSearchByDoctorName_panelCardAppointmentsRecord.add(labelSearchByDoctorName_panelCardAppointmentsRecord);
		/*End of Search By Doctor Name Label panelCardAppointmentsRecord*/

		
		/*Search By Doctor Name 2 Label panelCardAppointmentsRecord*/
		labelSearchByDoctorName2_panelCardAppointmentsRecord = new JLabel("Doctor Name");
		labelSearchByDoctorName2_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDoctorName2_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByDoctorName2_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDoctorName2_panelCardAppointmentsRecord.setBounds(10, 60, 223, 38);
		panelSearchByDoctorName_panelCardAppointmentsRecord.add(labelSearchByDoctorName2_panelCardAppointmentsRecord);
		/*End of Search By Doctor Name 2 Label panelCardAppointmentsRecord*/

		
		/*Search By Patient ID Panel panelCardAppointmentsRecord*/
		panelSearchByPatientID_panelCardAppointmentsRecord = new JPanel();
		panelSearchByPatientID_panelCardAppointmentsRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Appointments Search By Patient ID Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsSearchByPatientIDPanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByPatientID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByPatientID_panelCardAppointmentsRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByPatientID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByPatientID_panelCardAppointmentsRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByPatientID_panelCardAppointmentsRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByPatientID_panelCardAppointmentsRecord.setLayout(null);
		panelSearchByPatientID_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByPatientID_panelCardAppointmentsRecord.setBackground(Color.WHITE);
		panelSearchByPatientID_panelCardAppointmentsRecord.setBounds(366, 222, 249, 118);
		panelCardAppointmentsRecord.add(panelSearchByPatientID_panelCardAppointmentsRecord);
		/*End of Search By Patient ID Panel panelCardAppointmentsRecord*/
		
		
		/*Search By Patient ID Label panelCardAppointmentsRecord*/
		labelSearchByPatientID_panelCardAppointmentsRecord = new JLabel("Search By :");
		labelSearchByPatientID_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByPatientID_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByPatientID_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByPatientID_panelCardAppointmentsRecord.setBounds(10, 11, 223, 38);
		panelSearchByPatientID_panelCardAppointmentsRecord.add(labelSearchByPatientID_panelCardAppointmentsRecord);
		/*End of Search By Patient ID Label panelCardAppointmentsRecord*/

		
		/*Search By Patient ID 2 Label panelCardAppointmentsRecord*/
		labelSearchByPatientID2_panelCardAppointmentsRecord = new JLabel("Patient ID");
		labelSearchByPatientID2_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByPatientID2_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByPatientID2_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByPatientID2_panelCardAppointmentsRecord.setBounds(10, 60, 223, 38);
		panelSearchByPatientID_panelCardAppointmentsRecord.add(labelSearchByPatientID2_panelCardAppointmentsRecord);
		/*End of Search By Patient ID 2 Label panelCardAppointmentsRecord*/

		
		/*Search By Date Panel panelCardAppointmentsRecord*/
		panelSearchByDate_panelCardAppointmentsRecord = new JPanel();
		panelSearchByDate_panelCardAppointmentsRecord.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Appointments Search By Date And Service Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsSearchByDateAndServicePanel);
			
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSearchByDate_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSearchByDate_panelCardAppointmentsRecord.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSearchByDate_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSearchByDate_panelCardAppointmentsRecord.setBackground(new Color(216, 191, 216));
			}
		});
		panelSearchByDate_panelCardAppointmentsRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearchByDate_panelCardAppointmentsRecord.setLayout(null);
		panelSearchByDate_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSearchByDate_panelCardAppointmentsRecord.setBackground(Color.WHITE);
		panelSearchByDate_panelCardAppointmentsRecord.setBounds(36, 222, 249, 118);
		panelCardAppointmentsRecord.add(panelSearchByDate_panelCardAppointmentsRecord);
		/*End of Search By Date Panel panelCardAppointmentsRecord*/
		
		
		/*Search By Date Label panelCardAppointmentsRecord*/
		labelSearchByDate_panelCardAppointmentsRecord = new JLabel("Search By :");
		labelSearchByDate_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDate_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByDate_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDate_panelCardAppointmentsRecord.setBounds(10, 11, 223, 38);
		panelSearchByDate_panelCardAppointmentsRecord.add(labelSearchByDate_panelCardAppointmentsRecord);
		/*End of Search By Date Label panelCardAppointmentsRecord*/

		
		/*Search By Date 2 Label panelCardAppointmentsRecord*/
		labelSearchByDate2_panelCardAppointmentsRecord = new JLabel("Date and Service");
		labelSearchByDate2_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearchByDate2_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		labelSearchByDate2_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSearchByDate2_panelCardAppointmentsRecord.setBounds(10, 60, 223, 38);
		panelSearchByDate_panelCardAppointmentsRecord.add(labelSearchByDate2_panelCardAppointmentsRecord);
		/*End of Search By Date 2 Label panelCardAppointmentsRecord*/

		
		/*Appointments Record Title Label panelCardAppointmentsRecord*/
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord = new JLabel("Appointments Record Page");
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setForeground(Color.BLACK);
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setFocusable(false);
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAppointmentsRecordTitle_panelCardAppointmentsRecord.setBounds(168, 0, 317, 36);
		panelCardAppointmentsRecord.add(lblAppointmentsRecordTitle_panelCardAppointmentsRecord);
		panelCards.add(panelCardAddAppointment, AddAppointmentPanel);
		/*End of Appointments Record Title Label panelCardAppointmentsRecord*/
		
		
		/*New Appointment ID Button panelCardAddAppointment*/
		BtnNewAppointmentID_panelCardAddAppointment = new JButton();
		BtnNewAppointmentID_panelCardAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// New Appointment ID
				RandomAppointmentID();
			}
		});
		BtnNewAppointmentID_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewAppointmentID_panelCardAddAppointment.setText("New ID");
		BtnNewAppointmentID_panelCardAddAppointment.setForeground(Color.WHITE);
		BtnNewAppointmentID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewAppointmentID_panelCardAddAppointment.setFocusable(false);
		BtnNewAppointmentID_panelCardAddAppointment.setBackground(new Color(102, 51, 153));
		BtnNewAppointmentID_panelCardAddAppointment.setBounds(424, 46, 78, 35);
		panelCardAddAppointment.add(BtnNewAppointmentID_panelCardAddAppointment);
		/*End of New Appointment ID Button panelCardAddAppointment*/
		
		
		/*Appointments ID 2 Label panelCardAddAppointment*/
		lblAppointmentsID2_panelCardAddAppointment = new JLabel("");
		lblAppointmentsID2_panelCardAddAppointment.setToolTipText("Appointment");
		lblAppointmentsID2_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID2_panelCardAddAppointment.setForeground(Color.BLACK);
		lblAppointmentsID2_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblAppointmentsID2_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID2_panelCardAddAppointment.setBackground(new Color(102, 51, 153));
		lblAppointmentsID2_panelCardAddAppointment.setBounds(331, 46, 91, 37);
		panelCardAddAppointment.add(lblAppointmentsID2_panelCardAddAppointment);
		/*End of Appointments ID 2 Label panelCardAddAppointment*/

		
		/*Appointments ID Label panelCardAddAppointment*/
		lblAppointmentsID_panelCardAddAppointment = new JLabel("Appointment ID");
		lblAppointmentsID_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID_panelCardAddAppointment.setForeground(Color.BLACK);
		lblAppointmentsID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAppointmentsID_panelCardAddAppointment.setFocusable(false);
		lblAppointmentsID_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID_panelCardAddAppointment.setBounds(125, 47, 191, 36);
		panelCardAddAppointment.add(lblAppointmentsID_panelCardAddAppointment);
		/*End of Appointments ID Label panelCardAddAppointment*/
		
		
		/*Doctor Name Label panelCardAddAppointment*/
		lblDoctorName_panelCardAddAppointment = new JLabel("Doctor Name");
		lblDoctorName_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_panelCardAddAppointment.setForeground(Color.BLACK);
		lblDoctorName_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_panelCardAddAppointment.setFocusable(false);
		lblDoctorName_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_panelCardAddAppointment.setBounds(125, 143, 191, 36);
		panelCardAddAppointment.add(lblDoctorName_panelCardAddAppointment);
		/*End of Doctor Name Label panelCardAddAppointment*/
		
		
		/*Date Label panelCardAddAppointment*/
		lblDate_panelCardAddAppointment = new JLabel("Date");
		lblDate_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardAddAppointment.setForeground(Color.BLACK);
		lblDate_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardAddAppointment.setFocusable(false);
		lblDate_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardAddAppointment.setBounds(125, 194, 191, 36);
		panelCardAddAppointment.add(lblDate_panelCardAddAppointment);
		/*End of Date Label panelCardAddAppointment*/
		
		
		/*comboBox Service panelCardAddAppointment*/
		comboBoxService_panelCardAddAppointment = new JComboBox();
		comboBoxService_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxService_panelCardAddAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Service", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxService_panelCardAddAppointment.setToolTipText("Choose Service");
		comboBoxService_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxService_panelCardAddAppointment.setFocusable(false);
		comboBoxService_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxService_panelCardAddAppointment.setBackground(Color.WHITE);
		comboBoxService_panelCardAddAppointment.setBounds(331, 287, 171, 36);
		panelCardAddAppointment.add(comboBoxService_panelCardAddAppointment);
		/*End of comboBox Service panelCardAddAppointment*/

		
		/*Time Label panelCardAddAppointment*/
		lblTime_panelCardAddAppointment = new JLabel("Time");
		lblTime_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardAddAppointment.setForeground(Color.BLACK);
		lblTime_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardAddAppointment.setFocusable(false);
		lblTime_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardAddAppointment.setBounds(125, 241, 191, 36);
		panelCardAddAppointment.add(lblTime_panelCardAddAppointment);
		/*End of Time Label panelCardAddAppointment*/

		
		/*Service Label panelCardAddAppointment*/
		lblService_panelCardAddAppointment = new JLabel("Service");
		lblService_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblService_panelCardAddAppointment.setForeground(Color.BLACK);
		lblService_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblService_panelCardAddAppointment.setFocusable(false);
		lblService_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblService_panelCardAddAppointment.setBounds(125, 288, 191, 36);
		panelCardAddAppointment.add(lblService_panelCardAddAppointment);
		/*End of Service Label panelCardAddAppointment*/

		
		/*Book Appointment Button panelCardAddAppointment*/
		BtnBookAppointment_panelCardAddAppointment = new JButton();
		BtnBookAppointment_panelCardAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 * 
				 *     
				 *  Add New Appointment And New Invoice
				 *     
				 *     
				 */
				
				
				//check if there any empty spaces
				if(lblAppointmentsID2_panelCardAddAppointment.getText().isEmpty() || textFieldPatientID_panelCardAddAppointment.getText().isEmpty() || 
				   comboBoxDoctorName_panelCardAddAppointment.getSelectedIndex()==0 || Date_panelCardAddAppointment.getDate()==null ||
				   Time__panelCardAddAppointment.getText().isEmpty() ||  comboBoxService_panelCardAddAppointment.getSelectedIndex()==0 
				   || textFieldServicePrice_panelCardAddAppointment.getText().isEmpty() || lblInvoiceID2_panelCardAddAppointment.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					
					//check no string Entered in Service Price Field
					if((textFieldServicePrice_panelCardAddAppointment.getText().contains("a") || textFieldServicePrice_panelCardAddAppointment.getText().contains("b") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("c") || textFieldServicePrice_panelCardAddAppointment.getText().contains("d") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("e") || textFieldServicePrice_panelCardAddAppointment.getText().contains("f") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("g") || textFieldServicePrice_panelCardAddAppointment.getText().contains("h") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("i") || textFieldServicePrice_panelCardAddAppointment.getText().contains("j") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("k") || textFieldServicePrice_panelCardAddAppointment.getText().contains("l") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("m") || textFieldServicePrice_panelCardAddAppointment.getText().contains("n") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("o") || textFieldServicePrice_panelCardAddAppointment.getText().contains("p") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("q") || textFieldServicePrice_panelCardAddAppointment.getText().contains("r") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("s") || textFieldServicePrice_panelCardAddAppointment.getText().contains("t") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("u") || textFieldServicePrice_panelCardAddAppointment.getText().contains("v") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("w") || textFieldServicePrice_panelCardAddAppointment.getText().contains("x") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("y") || textFieldServicePrice_panelCardAddAppointment.getText().contains("z") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("A") || textFieldServicePrice_panelCardAddAppointment.getText().contains("B") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("C") || textFieldServicePrice_panelCardAddAppointment.getText().contains("D") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("E") || textFieldServicePrice_panelCardAddAppointment.getText().contains("F") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("G") || textFieldServicePrice_panelCardAddAppointment.getText().contains("H") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("I") || textFieldServicePrice_panelCardAddAppointment.getText().contains("J") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("K") || textFieldServicePrice_panelCardAddAppointment.getText().contains("L") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("M") || textFieldServicePrice_panelCardAddAppointment.getText().contains("N") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("O") || textFieldServicePrice_panelCardAddAppointment.getText().contains("P") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("Q") || textFieldServicePrice_panelCardAddAppointment.getText().contains("R") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("S") || textFieldServicePrice_panelCardAddAppointment.getText().contains("T") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("U") || textFieldServicePrice_panelCardAddAppointment.getText().contains("V") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("W") || textFieldServicePrice_panelCardAddAppointment.getText().contains("X") ||
							   textFieldServicePrice_panelCardAddAppointment.getText().contains("Y") || textFieldServicePrice_panelCardAddAppointment.getText().contains("Z") ))
					{ JOptionPane.showMessageDialog(null, "Please just enter numbers in service price field"); }
					
					
				//continue after "check no string Entered in Service Price Field"
				else {
					
					try {
						
						
					// get patient name from Patients table using resultset
					PreparedStatement preparedatatementPatientID;
					preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
					preparedatatementPatientID.setString(1, textFieldPatientID_panelCardAddAppointment.getText());
					ResultSet resultset = preparedatatementPatientID.executeQuery();
					String patientName = resultset.getString(3); 
					preparedatatementPatientID.close();
					// End get patient name from Patients table using resultset
						
					// date to string
					SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
					String DofB              = dFormat.format(Date_panelCardAddAppointment.getDate());
					// End date to string
					
					// text to integer
					int ServicePrice = Integer.parseInt(textFieldServicePrice_panelCardAddAppointment.getText()); 
					// End text to integer
						
						
						
					/*
					 *   Appointment & Invoice PDF files work
					 */
					
						// Creating File Chooser To Save Appointment PDF File In Specific Location
						// parent component of the dialog
						JFrame parentFrame = new JFrame();
						 
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Save Appointment PDF");
						fileChooser.setSelectedFile(new File("Appointment ID - "+lblAppointmentsID2_panelCardAddAppointment.getText()));
						// End Creating File Chooser To Save Appointment PDF File In Specific Location

						
						// Creating File Chooser  To Save Invoice PDF File In Specific Location
						// parent component of the dialog
						JFrame parentFrameInvoice = new JFrame();
						 
						JFileChooser fileChooserInvoice = new JFileChooser();
						fileChooserInvoice.setDialogTitle("Save Invoice PDF");
						fileChooserInvoice.setSelectedFile(new File("Invoice ID - "+lblInvoiceID2_panelCardAddAppointment.getText()));
						// End Creating File Chooser To Save Invoice PDF File In Specific Location
						
						
						/*
						 * / if you save Appointment and Invoice files
						 */
						
						int userSelectionInvoice = fileChooserInvoice.showSaveDialog(parentFrameInvoice);
						int userSelection = fileChooser.showSaveDialog(parentFrame);
						
						if (userSelection == JFileChooser.APPROVE_OPTION && userSelectionInvoice == JFileChooser.APPROVE_OPTION) {
							
						
						// Print appointment to PDF
						
						// Current Date & Time
						Calendar timer = Calendar.getInstance();
						timer.getTime();
						
						SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
						tTime.format(timer.getTime());
						
						SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
						tDate.format(timer.getTime());
						// end Current Date & Time
						
						

						// generate a appointment PDF
						//created appointment PDF document instance   
						Document doc = new Document();
						
						try {
							
							//generate appointment PDF at the specified location 
							PdfWriter write = PdfWriter.getInstance(doc, new FileOutputStream(new File(fileChooser.getSelectedFile()+".pdf", "")));
							
							//opens the appointment PDF  
							doc.open();
							
							//adds paragraph to the appointment PDF file 
							doc.add(new Paragraph("                      Appointment Info\n"+
					                 "\n"+
					                 " Date                                        "+tDate.format(timer.getTime())+
							         "\n Time                                        "+tTime.format(timer.getTime())+
							         "\n Appointment ID                       "+lblAppointmentsID2_panelCardAddAppointment.getText()+
							         "\n Patient ID                                "+textFieldPatientID_panelCardAddAppointment.getText()+
							         "\n Patient Name                          "+patientName+
							         "\n Doctor Name                           "+(String) comboBoxDoctorName_panelCardAddAppointment.getSelectedItem()+
							         "\n Appointment Date                   "+DofB+
							         "\n Appointment Time                   "+Time__panelCardAddAppointment.getText()+
							         "\n Service                                    "+(String) comboBoxService_panelCardAddAppointment.getSelectedItem()
							         ));
							
							// add attributes (author, date, title, subject, etc.) to appointment PDF file.
							doc.addAuthor("Amjad");  
							doc.addCreationDate();  
							doc.addCreator("AMJAD.KUNNAH");  
							doc.addTitle("Setting Attribute");  
							doc.addSubject("Setting attributes to the PDF files.");  
							
							//close the appointment PDF file  
							doc.close();  
							
							//closes the writer  
							write.close();
						// end generate appointment PDF
							
							 
							
						} 
						catch (FileNotFoundException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					    }
						
					    // End print appointment to PDF

								
								// Print Invoice to PDF	 
								
								// Current Date & Time
								Calendar timerInvoice = Calendar.getInstance();
								timerInvoice.getTime();
								
								SimpleDateFormat tTimeInvoice = new SimpleDateFormat("HH:mm:ss");
								tTimeInvoice.format(timerInvoice.getTime());
								
								SimpleDateFormat tDateInvoice = new SimpleDateFormat("dd-MM-yyyy");
								tDateInvoice.format(timerInvoice.getTime());
								// end Current Date & Time
								
								

								// generate Invoice PDF
								//created Invoice PDF document instance   
								Document docInvoice = new Document();
								
								try {
									
									//generate Invoice PDF at the specified location 
									PdfWriter writeInvoice = PdfWriter.getInstance(docInvoice, new FileOutputStream(new File(fileChooserInvoice.getSelectedFile()+".pdf", "")));
									
									//opens Invoice PDF  
									docInvoice.open();
									
									//adds paragraph to Invoice PDF file 
									docInvoice.add(new Paragraph("                      Invoice Info\n"+
							                 "\n"+
							                 " Date                                        "+tDateInvoice.format(timer.getTime())+
									         "\n Time                                        "+tTimeInvoice.format(timer.getTime())+
									         "\n Invoice ID                                "+lblInvoiceID2_panelCardAddAppointment.getText()+
									         "\n Appointment ID                       "+lblAppointmentsID2_panelCardAddAppointment.getText()+
									         "\n Patient ID                                "+textFieldPatientID_panelCardAddAppointment.getText()+
									         "\n Patient Name                          "+patientName+
									         "\n Doctor Name                           "+(String) comboBoxDoctorName_panelCardAddAppointment.getSelectedItem()+
									         "\n Appointment Date                   "+DofB+
									         "\n Appointment Time                   "+Time__panelCardAddAppointment.getText()+
									         "\n Service                                    "+(String) comboBoxService_panelCardAddAppointment.getSelectedItem()+
									         "\n Service Price                           "+ServicePrice+" SDG"

									         ));
									
									// add attributes (author, date, title, subject, etc.) to Invoice PDF file.
									docInvoice.addAuthor("Amjad");  
									docInvoice.addCreationDate();  
									docInvoice.addCreator("AMJAD.KUNNAH");  
									docInvoice.addTitle("Setting Attribute");  
									docInvoice.addSubject("Setting attributes to the PDF files.");  
									
									//close Invoice PDF file  
									docInvoice.close();  
									
									//closes the writer  
									writeInvoice.close();
								// end generate Invoice PDF
										
								} 
								catch (FileNotFoundException | DocumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							    }
								
								// End Print Invoice to PDF

								
					    /*
			     		 * End of  Appointment & Invoice PDF files work
						 */
					

                        /*
                         * Entering data to database "Appointments Table" 
                         */
					
						// Set data to "appointmentsDTO" object
						AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
						appointmentsDTO.setAppointmentID(lblAppointmentsID2_panelCardAddAppointment.getText());
						appointmentsDTO.setPatientID(textFieldPatientID_panelCardAddAppointment.getText());
						appointmentsDTO.setDoctor_Name((String) comboBoxDoctorName_panelCardAddAppointment.getSelectedItem());
						appointmentsDTO.setDate(DofB);
						appointmentsDTO.setTime(Time__panelCardAddAppointment.getText());
						appointmentsDTO.setService((String) comboBoxService_panelCardAddAppointment.getSelectedItem());
						appointmentsDTO.setReceptionists_Name(receptionists_Name);
						appointmentsDTO.setInvoiceID(lblInvoiceID2_panelCardAddAppointment.getText());
						// End of Set data to "appointmentsDTO" object
						
						// Send data to "addAppointmentDAO" method
						new AppointmentsDAO().addAppointmentDAO(appointmentsDTO);
						// End Send data to "addAppointmentDAO" method
					
                        /*
                         *  End of Entering data to database "Appointments Table"
                         */
						
						
						/*
                         * Entering data to database "Invoices Table"
                         */
						
						// current date and time to string
						Calendar Currenttimer = Calendar.getInstance();
						Currenttimer.getTime();
						SimpleDateFormat CurrentdFormat    = new SimpleDateFormat("dd-MM-yyyy");  // date format
						CurrentdFormat.format(Currenttimer.getTime());
						SimpleDateFormat CurrentTimeFormat = new SimpleDateFormat("HH:mm:ss");    // time format
						CurrentTimeFormat.format(Currenttimer.getTime());
						String CurrentDate                 = CurrentdFormat.format(Currenttimer.getTime());
						String CurrentTime                 = CurrentTimeFormat.format(Currenttimer.getTime());
						// End current date and time to string
						
						// Set data to "invoicesDTO" object
						InvoicesDTO invoicesDTO = new InvoicesDTO();
						invoicesDTO.setInvoiceID(lblInvoiceID2_panelCardAddAppointment.getText());
						invoicesDTO.setPatientID(textFieldPatientID_panelCardAddAppointment.getText());
						invoicesDTO.setDoctor_Name((String) comboBoxDoctorName_panelCardAddAppointment.getSelectedItem());
						invoicesDTO.setAppointmentID(lblAppointmentsID2_panelCardAddAppointment.getText());
						invoicesDTO.setService((String) comboBoxService_panelCardAddAppointment.getSelectedItem());
						invoicesDTO.setService_Price(ServicePrice);
						invoicesDTO.setDate(CurrentDate);
						invoicesDTO.setTime(CurrentTime);
						invoicesDTO.setAdd_By_Receptionist(receptionists_Name);
						// End of Set data to "invoicesDTO" object
						
						// Send data to "addInvoice" method
						new InvoiceDAO().addInvoice(invoicesDTO);
						// End of Send data to "addInvoice" method

				
                        /*
                         * / End continue  Entering data to database "Invoices Table"
                         */				
					
						}
						
						
					    // else if you don't save the Appointment and Invoice files
						else              
						{JOptionPane.showMessageDialog(null, "Please save Appointment and Invoice files ");}
					
					}catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}	
				}
				}
			}
		});
		BtnBookAppointment_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBookAppointment_panelCardAddAppointment.setText("Book");
		BtnBookAppointment_panelCardAddAppointment.setForeground(Color.WHITE);
		BtnBookAppointment_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnBookAppointment_panelCardAddAppointment.setFocusable(false);
		BtnBookAppointment_panelCardAddAppointment.setBackground(new Color(102, 51, 153));
		BtnBookAppointment_panelCardAddAppointment.setBounds(376, 450, 105, 35);
		panelCardAddAppointment.add(BtnBookAppointment_panelCardAddAppointment);
		/*End of Book Appointment Button panelCardAddAppointment*/
		
		
		/*Clear Fields Button panelCardAddAppointment*/
		BtnClearFields_panelCardAddAppointment = new JButton();
		BtnClearFields_panelCardAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear all fields
				ClearAll();
				
			}
		});
		BtnClearFields_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardAddAppointment.setText("Clear");
		BtnClearFields_panelCardAddAppointment.setForeground(Color.WHITE);
		BtnClearFields_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_panelCardAddAppointment.setFocusable(false);
		BtnClearFields_panelCardAddAppointment.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardAddAppointment.setBounds(261, 450, 105, 35);
		panelCardAddAppointment.add(BtnClearFields_panelCardAddAppointment);
		/*End of Clear Fields Button panelCardAddAppointment*/

		
		/*Back Button panelCardAddAppointment*/
		backBtn_panelCardAddAppointment = new JButton();
		backBtn_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 * Show Appointments Main Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsMainPanel);
				
				// clear all fields
				ClearAll();
				
			
			}
		});
		backBtn_panelCardAddAppointment.setText("Back");
		backBtn_panelCardAddAppointment.setForeground(Color.WHITE);
		backBtn_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardAddAppointment.setFocusable(false);
		backBtn_panelCardAddAppointment.setBackground(new Color(204, 0, 0));
		backBtn_panelCardAddAppointment.setBounds(146, 450, 105, 35);
		panelCardAddAppointment.add(backBtn_panelCardAddAppointment);
		/*End of Back Button panelCardAddAppointment*/
		
		
		/*Patient ID Label panelCardAddAppointment*/
		lblPatientID_panelCardAddAppointment = new JLabel("Patient ID");
		lblPatientID_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_panelCardAddAppointment.setForeground(Color.BLACK);
		lblPatientID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_panelCardAddAppointment.setFocusable(false);
		lblPatientID_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_panelCardAddAppointment.setBounds(125, 95, 191, 36);
		panelCardAddAppointment.add(lblPatientID_panelCardAddAppointment);
		/*End of Patient ID Label panelCardAddAppointment*/

		
		/*Patient ID textField panelCardAddAppointment*/
		textFieldPatientID_panelCardAddAppointment = new JTextField();
		textFieldPatientID_panelCardAddAppointment.setToolTipText("Patient ID");
		textFieldPatientID_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientID_panelCardAddAppointment.setColumns(10);
		textFieldPatientID_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientID_panelCardAddAppointment.setBounds(331, 95, 171, 36);
		panelCardAddAppointment.add(textFieldPatientID_panelCardAddAppointment);
		/*End of Patient ID textField panelCardAddAppointment*/
		
		
		/*Date panelCardAddAppointment*/
		Date_panelCardAddAppointment = new JDateChooser();
		Date_panelCardAddAppointment.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardAddAppointment.setToolTipText("Date");
		Date_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardAddAppointment.setBounds(331, 193, 171, 36);
		panelCardAddAppointment.add(Date_panelCardAddAppointment);
		/*End of Date panelCardAddAppointment*/
		
		
		/*Time panelCardAddAppointment*/
		Time__panelCardAddAppointment = new TimePicker();
		Time__panelCardAddAppointment.getComponentToggleTimeMenuButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time__panelCardAddAppointment.getComponentTimeTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time__panelCardAddAppointment.getComponentTimeTextField().setToolTipText("Time");
		Time__panelCardAddAppointment.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time__panelCardAddAppointment.getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 17));
		Time__panelCardAddAppointment.setBounds(331, 240, 171, 36);
		Time__panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		panelCardAddAppointment.add(Time__panelCardAddAppointment);
		/*End of Time panelCardAddAppointment*/

		
		/*comboBox Doctor Name panelCardAddAppointment*/
		comboBoxDoctorName_panelCardAddAppointment = new JComboBox();
		comboBoxDoctorName_panelCardAddAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
		comboBoxDoctorName_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDoctorName_panelCardAddAppointment.setToolTipText("Choose Doctor");
		comboBoxDoctorName_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxDoctorName_panelCardAddAppointment.setFocusable(false);
		comboBoxDoctorName_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxDoctorName_panelCardAddAppointment.setBackground(Color.WHITE);
		comboBoxDoctorName_panelCardAddAppointment.setBounds(331, 142, 171, 36);
		panelCardAddAppointment.add(comboBoxDoctorName_panelCardAddAppointment);
		/*End of comboBox Doctor Name panelCardAddAppointment*/

		
		/*Service Price Label panelCardAddAppointment*/
		lblServicePrice_panelCardAddAppointment = new JLabel("Service Price");
		lblServicePrice_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicePrice_panelCardAddAppointment.setForeground(Color.BLACK);
		lblServicePrice_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblServicePrice_panelCardAddAppointment.setFocusable(false);
		lblServicePrice_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblServicePrice_panelCardAddAppointment.setBounds(125, 335, 191, 36);
		panelCardAddAppointment.add(lblServicePrice_panelCardAddAppointment);
		/*End of Service Price Label panelCardAddAppointment*/
		
		
		/*Service Price textField panelCardAddAppointment*/
		textFieldServicePrice_panelCardAddAppointment = new JTextField();
		textFieldServicePrice_panelCardAddAppointment.setToolTipText("Service Price");
		textFieldServicePrice_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldServicePrice_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldServicePrice_panelCardAddAppointment.setColumns(10);
		textFieldServicePrice_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldServicePrice_panelCardAddAppointment.setBounds(331, 335, 171, 36);
		panelCardAddAppointment.add(textFieldServicePrice_panelCardAddAppointment);
		/*End of Service Price textField panelCardAddAppointment*/
		
		
		/*Invoice ID Label panelCardAddAppointment*/
		lblInvoiceID_panelCardAddAppointment = new JLabel("Invoice ID");
		lblInvoiceID_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID_panelCardAddAppointment.setForeground(Color.BLACK);
		lblInvoiceID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblInvoiceID_panelCardAddAppointment.setFocusable(false);
		lblInvoiceID_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID_panelCardAddAppointment.setBounds(125, 382, 191, 36);
		panelCardAddAppointment.add(lblInvoiceID_panelCardAddAppointment);
		/*End of Invoice ID Label panelCardAddAppointment*/

		
		/*Invoice ID 2 Label panelCardAddAppointment*/
		lblInvoiceID2_panelCardAddAppointment = new JLabel("");
		lblInvoiceID2_panelCardAddAppointment.setToolTipText("Invoice ID");
		lblInvoiceID2_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID2_panelCardAddAppointment.setForeground(Color.BLACK);
		lblInvoiceID2_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblInvoiceID2_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID2_panelCardAddAppointment.setBackground(new Color(102, 51, 153));
		lblInvoiceID2_panelCardAddAppointment.setBounds(331, 382, 91, 37);
		panelCardAddAppointment.add(lblInvoiceID2_panelCardAddAppointment);
		/*End of Invoice ID 2 Label panelCardAddAppointment*/

		
		/*New Invoice ID Button panelCardAddAppointment*/
		BtnNewInvoiceID_panelCardAddAppointment = new JButton();
		BtnNewInvoiceID_panelCardAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// New Invoice ID
				RandomInvoiceID();
			}
		});
		BtnNewInvoiceID_panelCardAddAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewInvoiceID_panelCardAddAppointment.setText("New ID");
		BtnNewInvoiceID_panelCardAddAppointment.setForeground(Color.WHITE);
		BtnNewInvoiceID_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewInvoiceID_panelCardAddAppointment.setFocusable(false);
		BtnNewInvoiceID_panelCardAddAppointment.setBackground(new Color(102, 51, 153));
		BtnNewInvoiceID_panelCardAddAppointment.setBounds(424, 382, 78, 35);
		panelCardAddAppointment.add(BtnNewInvoiceID_panelCardAddAppointment);
		/*End of New Invoice ID Button panelCardAddAppointment*/

		
		/*Add Appointment Title Label panelCardAddAppointment*/
		lblAddAppointmentTitle_panelCardAddAppointment = new JLabel("Add Appointment Page");
		lblAddAppointmentTitle_panelCardAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAppointmentTitle_panelCardAddAppointment.setForeground(Color.BLACK);
		lblAddAppointmentTitle_panelCardAddAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAddAppointmentTitle_panelCardAddAppointment.setFocusable(false);
		lblAddAppointmentTitle_panelCardAddAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAddAppointmentTitle_panelCardAddAppointment.setBounds(168, 0, 317, 36);
		panelCardAddAppointment.add(lblAddAppointmentTitle_panelCardAddAppointment);
		/*End of Add Appointment Title Label panelCardAddAppointment*/
		
		
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
		panelCards.add(panelCardSearchByDoctorName, AppointmentsSearchByDoctorNamePanel);
		/*End of Card Search By Doctor Name Panel*/

		
		/*Back Button panelCardSearchByDoctorName*/
		backBtn_panelCardSearchByDoctorName = new JButton();
		backBtn_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsRecordPanel);
				
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
		backBtn_panelCardSearchByDoctorName.setBounds(221, 426, 105, 35);
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
		BtnClearFields_panelCardSearchByDoctorName.setBounds(336, 426, 105, 35);
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
		comboBoxSearchDoctorName_panelCardSearchByDoctorName.setBounds(211, 239, 171, 36);
		panelCardSearchByDoctorName.add(comboBoxSearchDoctorName_panelCardSearchByDoctorName);
		/*End of comboBox Search Doctor Name panelCardSearchByDoctorName*/
		
		
		/*Search Doctor Name Label panelCardSearchByDoctorName*/
		lblSearchDoctorName_panelCardSearchByDoctorName = new JLabel("Doctor Name");
		lblSearchDoctorName_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDoctorName_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblSearchDoctorName_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchDoctorName_panelCardSearchByDoctorName.setFocusable(false);
		lblSearchDoctorName_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSearchDoctorName_panelCardSearchByDoctorName.setBounds(10, 239, 191, 36);
		panelCardSearchByDoctorName.add(lblSearchDoctorName_panelCardSearchByDoctorName);
		/*End of Search Doctor Name Label panelCardSearchByDoctorName*/

		
		/*Date Label panelCardSearchByDoctorName*/
		lblDate_panelCardSearchByDoctorName = new JLabel("Date");
		lblDate_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblDate_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardSearchByDoctorName.setFocusable(false);
		lblDate_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardSearchByDoctorName.setBounds(10, 290, 191, 36);
		panelCardSearchByDoctorName.add(lblDate_panelCardSearchByDoctorName);
		/*End of Date Label panelCardSearchByDoctorName*/

		
		/*Date panelCardSearchByDoctorName*/
		Date_panelCardSearchByDoctorName = new JDateChooser();
		Date_panelCardSearchByDoctorName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardSearchByDoctorName.setToolTipText("Date");
		Date_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardSearchByDoctorName.setBounds(211, 290, 171, 36);
		panelCardSearchByDoctorName.add(Date_panelCardSearchByDoctorName);
		/*End of Date panelCardSearchByDoctorName*/
		
		
		/*Time Label panelCardSearchByDoctorName*/
		lblTime_panelCardSearchByDoctorName = new JLabel("Time");
		lblTime_panelCardSearchByDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardSearchByDoctorName.setForeground(Color.BLACK);
		lblTime_panelCardSearchByDoctorName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardSearchByDoctorName.setFocusable(false);
		lblTime_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardSearchByDoctorName.setBounds(10, 337, 191, 36);
		panelCardSearchByDoctorName.add(lblTime_panelCardSearchByDoctorName);
		/*End of Time Label panelCardSearchByDoctorName*/

		
		/*Time panelCardSearchByDoctorName*/
		Time_panelCardSearchByDoctorName = new TimePicker();
		Time_panelCardSearchByDoctorName.getComponentToggleTimeMenuButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setToolTipText("Time");
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time_panelCardSearchByDoctorName.getComponentTimeTextField().setFont(new Font("Kartika", Font.BOLD, 16));
		Time_panelCardSearchByDoctorName.setBounds(211, 336, 171, 36);
		Time_panelCardSearchByDoctorName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		panelCardSearchByDoctorName.add(Time_panelCardSearchByDoctorName);
		/*End of Time panelCardSearchByDoctorName*/

		
		/*Search By Date Button panelCardSearchByDoctorName*/
		btnSearchByDate_panelCardSearchByDoctorName = new JButton("Search By Date");
		btnSearchByDate_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Search Appointment By Doctor Name and Date
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
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Doctor_Name`=? AND `Date`=?");
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
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
		btnSearchByDate_panelCardSearchByDoctorName.setBounds(393, 239, 247, 36);
		panelCardSearchByDoctorName.add(btnSearchByDate_panelCardSearchByDoctorName);
		/*End of Search By Date Button panelCardSearchByDoctorName*/

		
		/*Search By Time Button panelCardSearchByDoctorName*/
		btnSearchByTime_panelCardSearchByDoctorName = new JButton("Search By Time");
		btnSearchByTime_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Appointment by Doctor Name and Time
				 */
				
								
				//check if Doctor Name or time field is empty 
				if(comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedIndex()==0 || Time_panelCardSearchByDoctorName.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter doctor name and time"); }
				
				// else continue after "check if Doctor Name or time field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Doctor_Name`=? AND `Time`=?");
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
							JOptionPane.showMessageDialog(null, "No appointments on this time");
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
		btnSearchByTime_panelCardSearchByDoctorName.setBounds(393, 290, 247, 36);
		panelCardSearchByDoctorName.add(btnSearchByTime_panelCardSearchByDoctorName);
		/*End of Search By Time Button panelCardSearchByDoctorName*/

		
		/*Search By Date and Time Button panelCardSearchByDoctorName*/
		btnByDateAndTime_panelCardSearchByDoctorName = new JButton("Search By Date and Time");
		btnByDateAndTime_panelCardSearchByDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Appointment By Doctor Name,  Date & Time
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
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Doctor_Name`=? AND `Date`=?");
						preparedatatement.setString(1, (String) comboBoxSearchDoctorName_panelCardSearchByDoctorName.getSelectedItem());
						preparedatatement.setString(2, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if date correct
						if(resultset.next())
						{
							// close database
							preparedatatement.close();
							
							// Check if time correct
							preparedatatementTime = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Doctor_Name`=? AND `Date`=? AND `Time`=?");
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
								JOptionPane.showMessageDialog(null, "No appointments on this time");
								// close database
								preparedatatementTime.close();
							}
	
							
						}
						
						// if date incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
		btnByDateAndTime_panelCardSearchByDoctorName.setBounds(393, 337, 247, 36);
		panelCardSearchByDoctorName.add(btnByDateAndTime_panelCardSearchByDoctorName);
		/*End of Search By Date and Time Button panelCardSearchByDoctorName*/

		
		/*ScrollPane panelCardSearchByDoctorName*/
		scrollPane_panelCardSearchByDoctorName = new JScrollPane();
		scrollPane_panelCardSearchByDoctorName.setBounds(10, 58, 630, 152);
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
		
		
		/*Card Search By Appointment ID Panel*/
		panelCardSearchByAppointmentID = new JPanel();
		panelCardSearchByAppointmentID.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_panelCardSearchByAppointmentID();
			}
		});
		panelCardSearchByAppointmentID.setLayout(null);
		panelCardSearchByAppointmentID.setBackground(Color.WHITE);
		panelCards.add(panelCardSearchByAppointmentID, "Search By Appointment ID");
		/*End of Card Search By Appointment ID Panel*/

		
		/*Back Button panelCardSearchByAppointmentID*/
		BtnBack_panelCardSearchByAppointmentID = new JButton();
		BtnBack_panelCardSearchByAppointmentID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_panelCardSearchByAppointmentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsRecordPanel);
				
				// clear field and refresh table
				textFieldAppointmentID_panelCardSearchByAppointmentID.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByAppointmentID();
			}
		});
		BtnBack_panelCardSearchByAppointmentID.setText("Back");
		BtnBack_panelCardSearchByAppointmentID.setForeground(Color.WHITE);
		BtnBack_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_panelCardSearchByAppointmentID.setFocusable(false);
		BtnBack_panelCardSearchByAppointmentID.setBackground(new Color(204, 0, 0));
		BtnBack_panelCardSearchByAppointmentID.setBounds(221, 437, 105, 35);
		panelCardSearchByAppointmentID.add(BtnBack_panelCardSearchByAppointmentID);
		/*End of Back Button panelCardSearchByAppointmentID*/
		
		
		/*Clear Field Button panelCardSearchByAppointmentID*/
		BtnClearcField_panelCardSearchByAppointmentID = new JButton();
		BtnClearcField_panelCardSearchByAppointmentID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_panelCardSearchByAppointmentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear field and refresh table
				textFieldAppointmentID_panelCardSearchByAppointmentID.setText(null);
				ShowDatabaseDataToTable_panelCardSearchByAppointmentID();
			}
		});
		BtnClearcField_panelCardSearchByAppointmentID.setText("Clear");
		BtnClearcField_panelCardSearchByAppointmentID.setForeground(Color.WHITE);
		BtnClearcField_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_panelCardSearchByAppointmentID.setFocusable(false);
		BtnClearcField_panelCardSearchByAppointmentID.setBackground(new Color(46, 139, 87));
		BtnClearcField_panelCardSearchByAppointmentID.setBounds(336, 437, 105, 35);
		panelCardSearchByAppointmentID.add(BtnClearcField_panelCardSearchByAppointmentID);
		/*End of Clear Field Button panelCardSearchByAppointmentID*/
		
		
		/*Appointment ID Label panelCardSearchByAppointmentID*/
		lblAppointmentID_panelCardSearchByAppointmentID = new JLabel("Appointment ID");
		lblAppointmentID_panelCardSearchByAppointmentID.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentID_panelCardSearchByAppointmentID.setForeground(Color.BLACK);
		lblAppointmentID_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAppointmentID_panelCardSearchByAppointmentID.setFocusable(false);
		lblAppointmentID_panelCardSearchByAppointmentID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentID_panelCardSearchByAppointmentID.setBounds(10, 289, 191, 36);
		panelCardSearchByAppointmentID.add(lblAppointmentID_panelCardSearchByAppointmentID);
		/*End of Appointment ID Label panelCardSearchByAppointmentID*/
		
		
		/*Search Button panelCardSearchByAppointmentID*/
		btnSearch_panelCardSearchByAppointmentID = new JButton("Search");
		btnSearch_panelCardSearchByAppointmentID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_panelCardSearchByAppointmentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Appointment By Appointment ID
				 */
				
								
				//check if Appointment ID field is empty 
				if(textFieldAppointmentID_panelCardSearchByAppointmentID.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter appointment ID"); }
				
				// else continue after "check if Appointment ID field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
						preparedatatement.setString(1, textFieldAppointmentID_panelCardSearchByAppointmentID.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment ID correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByAppointmentID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Appointment ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Appointment ID not exist");
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
		btnSearch_panelCardSearchByAppointmentID.setForeground(Color.WHITE);
		btnSearch_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearch_panelCardSearchByAppointmentID.setFocusable(false);
		btnSearch_panelCardSearchByAppointmentID.setBackground(new Color(102, 51, 153));
		btnSearch_panelCardSearchByAppointmentID.setBounds(393, 289, 247, 36);
		panelCardSearchByAppointmentID.add(btnSearch_panelCardSearchByAppointmentID);
		/*End of Search Button panelCardSearchByAppointmentID*/

		
		
		/*ScrollPane panelCardSearchByAppointmentID*/
		scrollPane_panelCardSearchByAppointmentID = new JScrollPane();
		scrollPane_panelCardSearchByAppointmentID.setBounds(10, 67, 630, 191);
		panelCardSearchByAppointmentID.add(scrollPane_panelCardSearchByAppointmentID);
		/*End of ScrollPane panelCardSearchByAppointmentID*/

		
		/*Table panelCardSearchByAppointmentID*/
		table_panelCardSearchByAppointmentID = new JTable();
		table_panelCardSearchByAppointmentID.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_panelCardSearchByAppointmentID.setViewportView(table_panelCardSearchByAppointmentID);
		/*End of Table panelCardSearchByAppointmentID*/

		
		/*Appointment ID textField panelCardSearchByAppointmentID*/
		textFieldAppointmentID_panelCardSearchByAppointmentID = new JTextField();
		textFieldAppointmentID_panelCardSearchByAppointmentID.setToolTipText("Appointment ID");
		textFieldAppointmentID_panelCardSearchByAppointmentID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAppointmentID_panelCardSearchByAppointmentID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldAppointmentID_panelCardSearchByAppointmentID.setColumns(10);
		textFieldAppointmentID_panelCardSearchByAppointmentID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldAppointmentID_panelCardSearchByAppointmentID.setBounds(211, 289, 171, 36);
		panelCardSearchByAppointmentID.add(textFieldAppointmentID_panelCardSearchByAppointmentID);
		/*End of Appointment ID textField panelCardSearchByAppointmentID*/

		
		/*Show All Cancelled Appointments Button panelCardSearchByAppointmentID*/
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID = new JButton("Show All Cancelled Appointments");
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Show Cancelled Appointments
				 */
				
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Status`=?");
						preparedatatement.setString(1, "Cancelled");
						ResultSet resultset = preparedatatement.executeQuery();
					
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_panelCardSearchByAppointmentID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						// close database
						preparedatatement.close();

						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }

			}
		});
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setForeground(Color.WHITE);
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setFocusable(false);
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setBackground(new Color(102, 51, 153));
		btnShowAllcancelledAppointments_panelCardSearchByAppointmentID.setBounds(393, 336, 247, 36);
		panelCardSearchByAppointmentID.add(btnShowAllcancelledAppointments_panelCardSearchByAppointmentID);
		/*End of Show All Cancelled Appointments Button panelCardSearchByAppointmentID*/
		
		
		/*Show All Current Appointments Button panelCardSearchByAppointmentID*/
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID = new JButton("Show All Current Appointments");
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show Current Appointments
				 */
				
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Status`=?");
						preparedatatement.setString(1, "Current");
						ResultSet resultset = preparedatatement.executeQuery();
					
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_panelCardSearchByAppointmentID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						// close database
						preparedatatement.close();

						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }

			
			}
		});
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setForeground(Color.WHITE);
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setFocusable(false);
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setBackground(new Color(102, 51, 153));
		btnShowAllCurrentAppointments_panelCardSearchByAppointmentID.setBounds(393, 383, 247, 36);
		panelCardSearchByAppointmentID.add(btnShowAllCurrentAppointments_panelCardSearchByAppointmentID);
		/*End of Show All Current Appointments Button panelCardSearchByAppointmentID*/

		
		/*Search By Appointment ID Title Label panelCardSearchByAppointmentID*/
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID = new JLabel("Search By Appointment ID Page");
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setForeground(Color.BLACK);
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setFocusable(false);
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID.setBounds(168, 0, 317, 36);
		panelCardSearchByAppointmentID.add(lblSearchByAppointmentIDTitle_panelCardSearchByAppointmentID);
		/*End of Search By Appointment ID Title Label panelCardSearchByAppointmentID*/
		
		
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
		panelCards.add(panelCardSearchByPatientID, "Search By Patient ID");
		/*End of Card Search By Patient ID Panel*/

		
		/*Back Button panelCardSearchByPatientID*/
		BtnBack_panelCardSearchByPatientID = new JButton();
		BtnBack_panelCardSearchByPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Record Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsRecordPanel);
				
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
				 *     Search Appointment By Patient ID and Date
				 */
				
								
				// check if Patient ID or date field is empty 
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
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
						// close database
						preparedatatementPatientID.close();
						
						
						// check if appointment exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? AND `Date`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Appointment not exist
						else
						{
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
				 *     Search Appointment By Patient ID and Doctor Name
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
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
						// close database
						preparedatatementPatientID.close();
						
						
						// check if Appointment exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? AND `Doctor_Name`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, (String) comboBoxDoctorName_panelCardSearchByPatientID.getSelectedItem());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Appointment not exist
						else
						{
							JOptionPane.showMessageDialog(null, "There are no appointments");
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
				 *     Search Appointment By Patient ID and Doctor Name and Date
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
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? ");
						preparedatatementPatientID.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						ResultSet resultsetPAtientID = preparedatatementPatientID.executeQuery();

						    //if patient ID exist
						if(resultsetPAtientID.next())
						{
							
							// close database
							preparedatatementPatientID.close();
							
							// check if this date exist
							preparedatatementDate = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? AND `Date`=?");
							preparedatatementDate.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
							preparedatatementDate.setString(2, DofB);
							ResultSet resultsetDate = preparedatatementDate.executeQuery();
							
						//if this date exist
						if(resultsetDate.next()) 
						{
							
						// close database
						preparedatatementDate.close();	
						
						// check if Appointment exist
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? AND `Doctor_Name`=? AND `Date`=?");
						preparedatatement.setString(1, textFieldPatientID_panelCardSearchByPatientID.getText());
						preparedatatement.setString(2, (String) comboBoxDoctorName_panelCardSearchByPatientID.getSelectedItem());
						preparedatatement.setString(3, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByPatientID.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Appointment not exist
						else
						{
							JOptionPane.showMessageDialog(null, "There are no appointments");
							// close database
							preparedatatement.close();
							
						}

						
						}
							
						//if this date not exist
						else 
						{
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
				 *     Search All Patient Appointments By Patient ID
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
						preparedatatementPatientID = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `PatientID`=? ");
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
		panelCards.add(panelCardSearchByDateAndService, "Search By Date And Service");
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
				cl.show(panelCards, AppointmentsRecordPanel);
				
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

		
		/*Search All This Date Appointments Button panelCardSearchByDateAndService*/
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService = new JButton("Search Date All Appointments");
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Search Appointment By Date_ All date appointments
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
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment Date Exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							//close database 
							preparedatatement.close();	
						}
						
						// if Appointment Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 14));
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchAllThisDateAppointments_panelCardSearchByDateAndService.setBounds(393, 240, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchAllThisDateAppointments_panelCardSearchByDateAndService);
		/*End of Search All This Date Appointments Button panelCardSearchByDateAndService*/

		
		/*Search By Service Button panelCardSearchByDateAndService*/
		btnSearchByService_panelCardSearchByDateAndService = new JButton("Search By Service");
		btnSearchByService_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				/*
				 *     Search Appointment By Date_ Date & Service
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
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment Date Exist
						if(resultset.next())
						{
							// close database
							preparedatatement.close();
							
							// check appointment Service match Date
							preparedatatementService = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Service`=? AND `Date`=?");
							preparedatatementService.setString(1, (String) comboBoxService_panelCardSearchByDateAndService.getSelectedItem());
							preparedatatementService.setString(2, DofB);
							ResultSet resultsetService = preparedatatementService.executeQuery();
							
							// if appointment Service match Date
                            if(resultsetService.next())
                            {
							ResultSet resaultset1 = preparedatatementService.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));
							// close database
							preparedatatementService.close();
                            }
                            
                            // if appointment Service Not match Date
                            else
                            {
                            	JOptionPane.showMessageDialog(null, "No appointment for this service");
                            	// close database
    							preparedatatementService.close();
                            }
                            
						}
						
						// if Appointment Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No appointments on this date");
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
				 *     Search Appointment By Date_ Date & Time
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
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Date`=?");
						preparedatatement.setString(1, DofB);
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointment Date Exist
						if(resultset.next())
						{
							// close datbase
							preparedatatement.close();
							
							// check appointment Time match Date
							preparedatatementTime = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Time`=? AND `Date`=?");
							preparedatatementTime.setString(1, Time_panelCardSearchByDateAndService.getText());
							preparedatatementTime.setString(2, DofB);
							ResultSet resultsetTime = preparedatatementTime.executeQuery();
							
							// if appointment Time match Date
                            if(resultsetTime.next())
                            {
							ResultSet resaultset1 = preparedatatementTime.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));
							// close database
							preparedatatementTime.close();
                            }
                            
                            // if appointment Time Not match Date
                            else
                            {
                            	JOptionPane.showMessageDialog(null, "No appointments on this time");
                            	// close database
    							preparedatatementTime.close();
                            }
                            
						}
						
						// if Appointment Date Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No appointment on this date");
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

		
		/*Search All This Service Appointments Button panelCardSearchByDateAndService*/
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService = new JButton("Search Service All Appointments");
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Appointment By Date_ All Service appointments
				 */
				
								
				// check if Service field is empty 
				if(comboBoxService_panelCardSearchByDateAndService.getSelectedIndex()==0)
					
				{ JOptionPane.showMessageDialog(null, "Please select service "); }
				
				// else continue after "check if Service field is empty "
				else          
				{
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `Service`=?");
						preparedatatement.setString(1, (String) comboBoxService_panelCardSearchByDateAndService.getSelectedItem());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Appointments By This Service Exist
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_panelCardSearchByDateAndService.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							//close database
							preparedatatement.close();
						}
						
						// if Appointments By This Service Not Exist
						else
						{
							JOptionPane.showMessageDialog(null, "No appointments for this service");
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
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setForeground(Color.WHITE);
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 13));
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setFocusable(false);
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setBackground(new Color(102, 51, 153));
		btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService.setBounds(393, 385, 247, 36);
		panelCardSearchByDateAndService.add(btnSearchAllThisServiceAppointments_panelCardSearchByDateAndService);
		/*End of Search All This Service Appointments Button panelCardSearchByDateAndService*/

		
		/*Search By Date And Service Title Label panelCardSearchByDateAndService*/
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService = new JLabel("Search By Date And Service Page");
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setForeground(Color.BLACK);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setFocusable(false);
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService.setBounds(158, 0, 343, 36);
		panelCardSearchByDateAndService.add(lblSearchByDateAndServiceTitle_panelCardSearchByDateAndService);
		/*End of Search By Date And Service Title Label panelCardSearchByDateAndService*/

		
		/*Card Update Appointment Panel*/
		panelCardUpdateAppointment = new JPanel();
		panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelCardUpdateAppointment.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// Clear ComBox
				comboBoxDoctorName_panelCardUpdateAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

				// Get Doctors Names From Database and set them into comboBox
				GetDoctorsNames_panelCardUpdateAppointmen();
			}
		});
		panelCardUpdateAppointment.setBackground(Color.WHITE);
		panelCards.add(panelCardUpdateAppointment, UpdateAppointmentPanel);
		panelCardUpdateAppointment.setLayout(null);
		/*End of Card Update Appointment Panel*/

		/*Appointments ID Label panelCardUpdateAppointment*/
		lblAppointmentsID_panelCardUpdateAppointment = new JLabel("Appointment ID");
		lblAppointmentsID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblAppointmentsID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAppointmentsID_panelCardUpdateAppointment.setFocusable(false);
		lblAppointmentsID_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID_panelCardUpdateAppointment.setBounds(10, 45, 191, 36);
		panelCardUpdateAppointment.add(lblAppointmentsID_panelCardUpdateAppointment);
		/*End of Appointments ID Label panelCardUpdateAppointment*/

		
		/*Appointments ID 2 Label panelCardUpdateAppointment*/
		lblAppointmentsID2_panelCardUpdateAppointment = new JLabel("");
		lblAppointmentsID2_panelCardUpdateAppointment.setEnabled(false);
		lblAppointmentsID2_panelCardUpdateAppointment.setToolTipText("Appointment");
		lblAppointmentsID2_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID2_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblAppointmentsID2_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblAppointmentsID2_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID2_panelCardUpdateAppointment.setBackground(new Color(102, 51, 153));
		lblAppointmentsID2_panelCardUpdateAppointment.setBounds(211, 44, 171, 37);
		panelCardUpdateAppointment.add(lblAppointmentsID2_panelCardUpdateAppointment);
		/*End of Appointments ID 2 Label panelCardUpdateAppointment*/

		
		/*Patient ID Label panelCardUpdateAppointment*/
		lblPatientID_panelCardUpdateAppointment = new JLabel("Patient ID");
		lblPatientID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblPatientID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_panelCardUpdateAppointment.setFocusable(false);
		lblPatientID_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_panelCardUpdateAppointment.setBounds(10, 93, 191, 36);
		panelCardUpdateAppointment.add(lblPatientID_panelCardUpdateAppointment);
		/*End of Patient ID Label panelCardUpdateAppointment*/

		
		/*Patient ID textField panelCardUpdateAppointment*/
		textFieldPatientID_panelCardUpdateAppointment = new JTextField();
		textFieldPatientID_panelCardUpdateAppointment.setEditable(false);
		textFieldPatientID_panelCardUpdateAppointment.setToolTipText("Patient ID");
		textFieldPatientID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientID_panelCardUpdateAppointment.setColumns(10);
		textFieldPatientID_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientID_panelCardUpdateAppointment.setBounds(211, 93, 171, 36);
		panelCardUpdateAppointment.add(textFieldPatientID_panelCardUpdateAppointment);
		/*End of Patient ID textField panelCardUpdateAppointment*/
		
		
		/*Doctor Name Label panelCardUpdateAppointment*/
		lblDoctorName_panelCardUpdateAppointment = new JLabel("Doctor Name");
		lblDoctorName_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblDoctorName_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_panelCardUpdateAppointment.setFocusable(false);
		lblDoctorName_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_panelCardUpdateAppointment.setBounds(10, 141, 191, 36);
		panelCardUpdateAppointment.add(lblDoctorName_panelCardUpdateAppointment);
		/*End of Doctor Name Label panelCardUpdateAppointment*/

		
		/*Doctor Name comboBox panelCardUpdateAppointment*/
		comboBoxDoctorName_panelCardUpdateAppointment = new JComboBox();
		comboBoxDoctorName_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDoctorName_panelCardUpdateAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
		comboBoxDoctorName_panelCardUpdateAppointment.setToolTipText("Choose Doctor");
		comboBoxDoctorName_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxDoctorName_panelCardUpdateAppointment.setFocusable(false);
		comboBoxDoctorName_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxDoctorName_panelCardUpdateAppointment.setBackground(Color.WHITE);
		comboBoxDoctorName_panelCardUpdateAppointment.setBounds(211, 140, 171, 36);
		panelCardUpdateAppointment.add(comboBoxDoctorName_panelCardUpdateAppointment);
		/*End of Doctor Name comboBox panelCardUpdateAppointment*/
		
		
		/*Date Label panelCardUpdateAppointment*/
		lblDate_panelCardUpdateAppointment = new JLabel("Date");
		lblDate_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblDate_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardUpdateAppointment.setFocusable(false);
		lblDate_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardUpdateAppointment.setBounds(10, 192, 191, 36);
		panelCardUpdateAppointment.add(lblDate_panelCardUpdateAppointment);
		/*End of Date Label panelCardUpdateAppointment*/

		
		/*Date JDateChooser panelCardUpdateAppointment*/
		Date_panelCardUpdateAppointment = new JDateChooser();
		Date_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Date_panelCardUpdateAppointment.setToolTipText("Date");
		Date_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardUpdateAppointment.setBounds(211, 191, 171, 36);
		panelCardUpdateAppointment.add(Date_panelCardUpdateAppointment);
		/*End of Date JDateChooser panelCardUpdateAppointment*/
		
		
		/*Time Label panelCardUpdateAppointment*/
		lblTime_panelCardUpdateAppointment = new JLabel("Time");
		lblTime_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblTime_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardUpdateAppointment.setFocusable(false);
		lblTime_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardUpdateAppointment.setBounds(10, 239, 191, 36);
		panelCardUpdateAppointment.add(lblTime_panelCardUpdateAppointment);
		/*End of Time Label panelCardUpdateAppointment*/

		
		/*Service Label panelCardUpdateAppointment*/
		lblService_panelCardUpdateAppointment = new JLabel("Service");
		lblService_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblService_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblService_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblService_panelCardUpdateAppointment.setFocusable(false);
		lblService_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblService_panelCardUpdateAppointment.setBounds(10, 286, 191, 36);
		panelCardUpdateAppointment.add(lblService_panelCardUpdateAppointment);
		/*End of Service Label panelCardUpdateAppointment*/

		
		/*Service comboBox panelCardUpdateAppointment*/
		comboBoxService_panelCardUpdateAppointment = new JComboBox();
		comboBoxService_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxService_panelCardUpdateAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Service", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxService_panelCardUpdateAppointment.setToolTipText("Choose Service");
		comboBoxService_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxService_panelCardUpdateAppointment.setFocusable(false);
		comboBoxService_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxService_panelCardUpdateAppointment.setBackground(Color.WHITE);
		comboBoxService_panelCardUpdateAppointment.setBounds(211, 285, 171, 36);
		panelCardUpdateAppointment.add(comboBoxService_panelCardUpdateAppointment);
		/*End of Service comboBox panelCardUpdateAppointment*/
		
		
		/*Service Price Label panelCardUpdateAppointment*/
		lblServicePrice_panelCardUpdateAppointment = new JLabel("Service Price");
		lblServicePrice_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicePrice_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblServicePrice_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblServicePrice_panelCardUpdateAppointment.setFocusable(false);
		lblServicePrice_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblServicePrice_panelCardUpdateAppointment.setBounds(10, 333, 191, 36);
		panelCardUpdateAppointment.add(lblServicePrice_panelCardUpdateAppointment);
		/*End of Service Price Label panelCardUpdateAppointment*/

		
		/*Service Price textField panelCardUpdateAppointment*/
		textFieldServicePrice_panelCardUpdateAppointment = new JTextField();
		textFieldServicePrice_panelCardUpdateAppointment.setToolTipText("Service Price");
		textFieldServicePrice_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldServicePrice_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldServicePrice_panelCardUpdateAppointment.setColumns(10);
		textFieldServicePrice_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldServicePrice_panelCardUpdateAppointment.setBounds(211, 333, 171, 36);
		panelCardUpdateAppointment.add(textFieldServicePrice_panelCardUpdateAppointment);
		/*End of Service Price textField panelCardUpdateAppointment*/
		
		
		/*Invoice ID Label panelCardUpdateAppointment*/
		lblInvoiceID_panelCardUpdateAppointment = new JLabel("Invoice ID");
		lblInvoiceID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblInvoiceID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblInvoiceID_panelCardUpdateAppointment.setFocusable(false);
		lblInvoiceID_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID_panelCardUpdateAppointment.setBounds(10, 380, 191, 36);
		panelCardUpdateAppointment.add(lblInvoiceID_panelCardUpdateAppointment);
		/*End of Invoice ID Label panelCardUpdateAppointment*/

		
		/*End of Invoice ID 2 Label panelCardUpdateAppointment*/
		lblInvoiceID2_panelCardUpdateAppointment = new JLabel("");
		lblInvoiceID2_panelCardUpdateAppointment.setEnabled(false);
		lblInvoiceID2_panelCardUpdateAppointment.setToolTipText("Invoice ID");
		lblInvoiceID2_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID2_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblInvoiceID2_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblInvoiceID2_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID2_panelCardUpdateAppointment.setBackground(new Color(102, 51, 153));
		lblInvoiceID2_panelCardUpdateAppointment.setBounds(211, 379, 171, 37);
		panelCardUpdateAppointment.add(lblInvoiceID2_panelCardUpdateAppointment);
		/*End of Invoice ID 2 Label panelCardUpdateAppointment*/

		
		/*Appointment Search Panel panelCardUpdateAppointment*/
		panelAppointmentSearch_panelCardUpdateAppointment = new JPanel();
		panelAppointmentSearch_panelCardUpdateAppointment.setLayout(null);
		panelAppointmentSearch_panelCardUpdateAppointment.setBackground(new Color(102, 51, 153));
		panelAppointmentSearch_panelCardUpdateAppointment.setBounds(440, 45, 200, 275);
		panelCardUpdateAppointment.add(panelAppointmentSearch_panelCardUpdateAppointment);
		/*End of Appointment Search Panel panelCardUpdateAppointment*/
		
		
		/*Appointment Search Label panelCardUpdateAppointment*/
		lblAppointmentSearch_panelCardUpdateAppointment = new JLabel("Search Appointment");
		lblAppointmentSearch_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentSearch_panelCardUpdateAppointment.setForeground(Color.WHITE);
		lblAppointmentSearch_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 18));
		lblAppointmentSearch_panelCardUpdateAppointment.setFocusable(false);
		lblAppointmentSearch_panelCardUpdateAppointment.setBorder(null);
		lblAppointmentSearch_panelCardUpdateAppointment.setBounds(10, 11, 180, 36);
		panelAppointmentSearch_panelCardUpdateAppointment.add(lblAppointmentSearch_panelCardUpdateAppointment);
		/*End of Appointment Search Label panelCardUpdateAppointment*/

		
		/*Appointment Search Button panelCardUpdateAppointment*/
		btnAppointmentSearch_panelCardUpdateAppointment = new JButton();
		btnAppointmentSearch_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAppointmentSearch_panelCardUpdateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Search Appointment
				 */
				
								
				//check if enter appointment ID field is empty 

				if(textFieldEnterAppointmentID_panelCardUpdateAppointment.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter appointment ID"); }
				
				// else continue after "check if enter appointment ID field is empty "
				else          
				{
					PreparedStatement preparedstatement;
					PreparedStatement preparedstatementInvoice;

					try {
						preparedstatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
						preparedstatement.setString(1, textFieldEnterAppointmentID_panelCardUpdateAppointment.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if appointment ID correct
						if(resultset.next())
						{
							
							// get Invoice ID and Service Price
							preparedstatementInvoice = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `AppointmentID`=?");
							preparedstatementInvoice.setString(1, textFieldEnterAppointmentID_panelCardUpdateAppointment.getText());
							ResultSet resultsetInvoice = preparedstatementInvoice.executeQuery();
							String invoiceID = resultsetInvoice.getString(2);
							String servicePrice = Integer.toString(resultsetInvoice.getInt(8));
							preparedstatementInvoice.close();
							// End of get Invoice ID and Service Price

							
							// get Date 'String' from database and set date to JDatechooser
							String appointmentdate = resultset.getString(7);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(appointmentdate);
								Date_panelCardUpdateAppointment.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							
							lblAppointmentsID2_panelCardUpdateAppointment.setText(resultset.getString(2));
							textFieldPatientID_panelCardUpdateAppointment.setText(resultset.getString(3));
							Time_panelCardUpdateAppointment.setText(resultset.getString(8));
							comboBoxDoctorName_panelCardUpdateAppointment.setSelectedItem(resultset.getString(6));
							comboBoxService_panelCardUpdateAppointment.setSelectedItem(resultset.getString(9));
							lblInvoiceID2_panelCardUpdateAppointment.setText(invoiceID);
							textFieldServicePrice_panelCardUpdateAppointment.setText(servicePrice);
							
							
							// Close database
							preparedstatement.close();
						}
						
						// if appointment ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong! appointment ID not exist, please enter the right appointment ID");
							// Close database
							preparedstatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
				
			}
		});
		btnAppointmentSearch_panelCardUpdateAppointment.setText("Search");
		btnAppointmentSearch_panelCardUpdateAppointment.setForeground(Color.WHITE);
		btnAppointmentSearch_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		btnAppointmentSearch_panelCardUpdateAppointment.setFocusable(false);
		btnAppointmentSearch_panelCardUpdateAppointment.setBackground(new Color(102, 51, 153));
		btnAppointmentSearch_panelCardUpdateAppointment.setBounds(10, 229, 180, 35);
		panelAppointmentSearch_panelCardUpdateAppointment.add(btnAppointmentSearch_panelCardUpdateAppointment);
		/*End of Appointment Search Button panelCardUpdateAppointment*/
		
		
		/*Appointment Search Enter ID Label panelCardUpdateAppointment*/
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment = new JLabel("Enter Appointment ID");
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setForeground(Color.WHITE);
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 13));
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setFocusable(false);
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblAppointmentsSearchEnterID_panelCardUpdateAppointment.setBounds(10, 79, 180, 36);
		panelAppointmentSearch_panelCardUpdateAppointment.add(lblAppointmentsSearchEnterID_panelCardUpdateAppointment);
		/*End of Appointment Search Enter ID Label panelCardUpdateAppointment*/

		
		/*Enter Appointment ID textField panelCardUpdateAppointment*/
		textFieldEnterAppointmentID_panelCardUpdateAppointment = new JTextField();
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setToolTipText("Appointment ID");
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setColumns(10);
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterAppointmentID_panelCardUpdateAppointment.setBounds(10, 159, 180, 36);
		panelAppointmentSearch_panelCardUpdateAppointment.add(textFieldEnterAppointmentID_panelCardUpdateAppointment);
		/*End of Enter Appointment ID textField panelCardUpdateAppointment*/

		
		/*Update Appointment Button panelCardUpdateAppointment*/
		BtnUpdateAppointment_panelCardUpdateAppointment = new JButton();
		BtnUpdateAppointment_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUpdateAppointment_panelCardUpdateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Update Appointment and Invoice
				 */
				
				
				//check if there any empty spaces

				if(lblAppointmentsID2_panelCardUpdateAppointment.getText().isEmpty() || textFieldPatientID_panelCardUpdateAppointment.getText().isEmpty() || 
				   comboBoxDoctorName_panelCardUpdateAppointment.getSelectedIndex()==0 || Date_panelCardUpdateAppointment.getDate()==null ||
				   Time_panelCardUpdateAppointment.getText().isEmpty() ||  comboBoxService_panelCardUpdateAppointment.getSelectedIndex()==0
				   || textFieldEnterAppointmentID_panelCardUpdateAppointment.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
						
						// date to string
						SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
						String DofB              = dFormat.format(Date_panelCardUpdateAppointment.getDate());
						// End date to string
						
						// Service Price text to integer 
						int servicePrice = Integer.parseInt(textFieldServicePrice_panelCardUpdateAppointment.getText());
						// End of Service Price text to integer  

			
						// Set data to "appointmentDTO" object
						AppointmentsDTO appointmentDTO = new AppointmentsDTO();
						appointmentDTO.setAppointmentID(textFieldEnterAppointmentID_panelCardUpdateAppointment.getText());
						appointmentDTO.setDoctor_Name((String) comboBoxDoctorName_panelCardUpdateAppointment.getSelectedItem());
						appointmentDTO.setDate(DofB);
						appointmentDTO.setTime(Time_panelCardUpdateAppointment.getText());
						appointmentDTO.setService((String) comboBoxService_panelCardUpdateAppointment.getSelectedItem());
						appointmentDTO.setService_Price(textFieldServicePrice_panelCardUpdateAppointment.getText());
						appointmentDTO.setInvoiceID(lblInvoiceID2_panelCardUpdateAppointment.getText());
						appointmentDTO.setUpdate_By_Receptionist(receptionists_Name);
						// End of Set data to "appointmentDTO" object
						
						// Send data to "updateAppointmentDAO" method
						new AppointmentsDAO().updateAppointmentDAO(appointmentDTO);
						// End of Send data to "updateAppointmentDAO" method
						
						
						// Set data to "InvoicesDTO" object
						InvoicesDTO invoicesDTO = new InvoicesDTO();
						invoicesDTO.setAppointmentID(textFieldEnterAppointmentID_panelCardUpdateAppointment.getText());
						invoicesDTO.setDoctor_Name((String) comboBoxDoctorName_panelCardUpdateAppointment.getSelectedItem());
						invoicesDTO.setDate(DofB);
						invoicesDTO.setTime(Time_panelCardUpdateAppointment.getText());
						invoicesDTO.setService((String) comboBoxService_panelCardUpdateAppointment.getSelectedItem());
						invoicesDTO.setService_Price(servicePrice);
						invoicesDTO.setInvoiceID(lblInvoiceID2_panelCardUpdateAppointment.getText());
						invoicesDTO.setUpdated_By_Receptionist(receptionists_Name);
						// End of Set data to "InvoicestDTO" object
						
						// Send data to "updateInvoice" method
						new InvoiceDAO().updateInvoice(invoicesDTO);
						// End of Send data to "updateInvoice" method

					
				}
			

			
			}
		});
		BtnUpdateAppointment_panelCardUpdateAppointment.setText("Update");
		BtnUpdateAppointment_panelCardUpdateAppointment.setForeground(Color.WHITE);
		BtnUpdateAppointment_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnUpdateAppointment_panelCardUpdateAppointment.setFocusable(false);
		BtnUpdateAppointment_panelCardUpdateAppointment.setBackground(new Color(102, 51, 153));
		BtnUpdateAppointment_panelCardUpdateAppointment.setBounds(381, 450, 105, 35);
		panelCardUpdateAppointment.add(BtnUpdateAppointment_panelCardUpdateAppointment);
		/*End of Update Appointment Button panelCardUpdateAppointment*/

		
		/*Clear Fields Button panelCardUpdateAppointment*/
		BtnClearFields_panelCardUpdateAppointment = new JButton();
		BtnClearFields_panelCardUpdateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear all fields
				ClearAll_panelCardUpdateAppointmen();
			}
		});
		BtnClearFields_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardUpdateAppointment.setText("Clear");
		BtnClearFields_panelCardUpdateAppointment.setForeground(Color.WHITE);
		BtnClearFields_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_panelCardUpdateAppointment.setFocusable(false);
		BtnClearFields_panelCardUpdateAppointment.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardUpdateAppointment.setBounds(266, 450, 105, 35);
		panelCardUpdateAppointment.add(BtnClearFields_panelCardUpdateAppointment);
		/*End of Clear Fields Button panelCardUpdateAppointment*/

		
		/*Back Button panelCardUpdateAppointment*/
		backBtn_panelCardUpdateAppointment = new JButton();
		backBtn_panelCardUpdateAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardUpdateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				/*
				 * Show Appointments Main Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsMainPanel);
				
				// clear all fields
				ClearAll_panelCardUpdateAppointmen();
			}
		});
		backBtn_panelCardUpdateAppointment.setText("Back");
		backBtn_panelCardUpdateAppointment.setForeground(Color.WHITE);
		backBtn_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardUpdateAppointment.setFocusable(false);
		backBtn_panelCardUpdateAppointment.setBackground(new Color(204, 0, 0));
		backBtn_panelCardUpdateAppointment.setBounds(151, 450, 105, 35);
		panelCardUpdateAppointment.add(backBtn_panelCardUpdateAppointment);
		/*End of Back Button panelCardUpdateAppointment*/
		
		
		/*Time TimePicker panelCardUpdatAppointment*/
		Time_panelCardUpdateAppointment = new TimePicker();
		Time_panelCardUpdateAppointment.getComponentToggleTimeMenuButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardUpdateAppointment.getComponentTimeTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Time_panelCardUpdateAppointment.getComponentTimeTextField().setToolTipText("Time");
		Time_panelCardUpdateAppointment.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time_panelCardUpdateAppointment.getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 17));
		Time_panelCardUpdateAppointment.setBounds(211, 238, 171, 36);
		Time_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		panelCardUpdateAppointment.add(Time_panelCardUpdateAppointment);
		/*End of Time TimePicker panelCardUpdateAppointment*/

		
		/*Update Appointment Title Label panelCardUpdateAppointment*/
		lblUpdateAppointmentTitle_panelCardUpdateAppointment = new JLabel("Update Appointment Page");
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setForeground(Color.BLACK);
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setFocusable(false);
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblUpdateAppointmentTitle_panelCardUpdateAppointment.setBounds(168, 0, 317, 36);
		panelCardUpdateAppointment.add(lblUpdateAppointmentTitle_panelCardUpdateAppointment);
		/*End of Update Appointment Title Label panelCardUpdateAppointment*/

		
		/*Card Cancel Appointment Panel*/
		panelCardCancelAppointment = new JPanel();
		panelCardCancelAppointment.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// Clear ComBox
				comboBoxDoctorName_panelCardCancelAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

				// Get Doctors Names From Database and set them into comboBox
				GetDoctorsNames_panelCardCancelAppointmen();
			}
		});
		panelCardCancelAppointment.setLayout(null);
		panelCardCancelAppointment.setBackground(Color.WHITE);
		panelCards.add(panelCardCancelAppointment, CancelAppointmentPanel);
		/*End of Card Cancel Appointment Panel*/

		
		/*Appointments ID Label panelCardCancelAppointment*/
		lblAppointmentsID_panelCardCancelAppointment = new JLabel("Appointment ID");
		lblAppointmentsID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblAppointmentsID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAppointmentsID_panelCardCancelAppointment.setFocusable(false);
		lblAppointmentsID_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID_panelCardCancelAppointment.setBounds(10, 45, 191, 36);
		panelCardCancelAppointment.add(lblAppointmentsID_panelCardCancelAppointment);
		/*End of Appointments ID Label panelCardCancelAppointment*/
		
		
		/*Appointments ID 2 Label panelCardCancelAppointment*/
		lblAppointmentsID2_panelCardCancelAppointment = new JLabel("");
		lblAppointmentsID2_panelCardCancelAppointment.setToolTipText("Appointment");
		lblAppointmentsID2_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsID2_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblAppointmentsID2_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblAppointmentsID2_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblAppointmentsID2_panelCardCancelAppointment.setBackground(new Color(102, 51, 153));
		lblAppointmentsID2_panelCardCancelAppointment.setBounds(211, 44, 171, 37);
		panelCardCancelAppointment.add(lblAppointmentsID2_panelCardCancelAppointment);
		/*End of Appointments ID 2 Label panelCardCancelAppointment*/
		
		
		/*Patient ID Label panelCardCancelAppointment*/
		lblPatientID_panelCardCancelAppointment = new JLabel("Patient ID");
		lblPatientID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientID_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblPatientID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientID_panelCardCancelAppointment.setFocusable(false);
		lblPatientID_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPatientID_panelCardCancelAppointment.setBounds(10, 93, 191, 36);
		panelCardCancelAppointment.add(lblPatientID_panelCardCancelAppointment);
		/*End of Patient ID Label panelCardCancelAppointment*/

		
		/*Patient ID textField panelCardCancelAppointment*/
		textFieldPatientID_panelCardCancelAppointment = new JTextField();
		textFieldPatientID_panelCardCancelAppointment.setEditable(false);
		textFieldPatientID_panelCardCancelAppointment.setToolTipText("Patient ID");
		textFieldPatientID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientID_panelCardCancelAppointment.setColumns(10);
		textFieldPatientID_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientID_panelCardCancelAppointment.setBounds(211, 93, 171, 36);
		panelCardCancelAppointment.add(textFieldPatientID_panelCardCancelAppointment);
		/*End of Patient ID textField panelCardCancelAppointment*/

		
		/*Doctor Name Label panelCardCancelAppointment*/
		lblDoctorName_panelCardCancelAppointment = new JLabel("Doctor Name");
		lblDoctorName_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblDoctorName_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_panelCardCancelAppointment.setFocusable(false);
		lblDoctorName_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_panelCardCancelAppointment.setBounds(10, 141, 191, 36);
		panelCardCancelAppointment.add(lblDoctorName_panelCardCancelAppointment);
		/*End of Doctor Name Label panelCardCancelAppointment*/

		
		/*Doctor Name comboBox panelCardCancelAppointment*/
		comboBoxDoctorName_panelCardCancelAppointment = new JComboBox();
		comboBoxDoctorName_panelCardCancelAppointment.setEnabled(false);
		comboBoxDoctorName_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDoctorName_panelCardCancelAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));
		comboBoxDoctorName_panelCardCancelAppointment.setToolTipText("Choose Doctor");
		comboBoxDoctorName_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxDoctorName_panelCardCancelAppointment.setFocusable(false);
		comboBoxDoctorName_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxDoctorName_panelCardCancelAppointment.setBackground(Color.WHITE);
		comboBoxDoctorName_panelCardCancelAppointment.setBounds(211, 140, 171, 36);
		panelCardCancelAppointment.add(comboBoxDoctorName_panelCardCancelAppointment);
		/*End of Doctor Name comboBox panelCardCancelAppointment*/

		
		
		/*Date Label panelCardCancelAppointment*/
		lblDate_panelCardCancelAppointment = new JLabel("Date");
		lblDate_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblDate_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDate_panelCardCancelAppointment.setFocusable(false);
		lblDate_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDate_panelCardCancelAppointment.setBounds(10, 192, 191, 36);
		panelCardCancelAppointment.add(lblDate_panelCardCancelAppointment);
		/*End of Date Label panelCardCancelAppointment*/

		
		/*Date JDateChooser panelCardCancelAppointment*/
		Date_panelCardCancelAppointment = new JDateChooser();
		Date_panelCardCancelAppointment.setEnabled(false);
		Date_panelCardCancelAppointment.setToolTipText("Date");
		Date_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Date_panelCardCancelAppointment.setBounds(211, 191, 171, 36);
		panelCardCancelAppointment.add(Date_panelCardCancelAppointment);
		/*End of Date JDateChooser panelCardCancelAppointment*/
		
		
		/*Time Label panelCardCancelAppointment*/
		lblTime_panelCardCancelAppointment = new JLabel("Time");
		lblTime_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblTime_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTime_panelCardCancelAppointment.setFocusable(false);
		lblTime_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTime_panelCardCancelAppointment.setBounds(10, 239, 191, 36);
		panelCardCancelAppointment.add(lblTime_panelCardCancelAppointment);
		/*End of Time Label panelCardCancelAppointment*/

		
		/*Service Label panelCardCancelAppointment*/
		lblService_panelCardCancelAppointment = new JLabel("Service");
		lblService_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblService_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblService_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblService_panelCardCancelAppointment.setFocusable(false);
		lblService_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblService_panelCardCancelAppointment.setBounds(10, 286, 191, 36);
		panelCardCancelAppointment.add(lblService_panelCardCancelAppointment);
		/*End of Service Label panelCardCancelAppointment*/

		
		/*Service comboBox panelCardCancelAppointment*/
		comboBoxService_panelCardCancelAppointment = new JComboBox();
		comboBoxService_panelCardCancelAppointment.setEnabled(false);
		comboBoxService_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxService_panelCardCancelAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Service", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxService_panelCardCancelAppointment.setToolTipText("Choose Service");
		comboBoxService_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxService_panelCardCancelAppointment.setFocusable(false);
		comboBoxService_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxService_panelCardCancelAppointment.setBackground(Color.WHITE);
		comboBoxService_panelCardCancelAppointment.setBounds(211, 285, 171, 36);
		panelCardCancelAppointment.add(comboBoxService_panelCardCancelAppointment);
		/*End of Service comboBox panelCardCancelAppointment*/
		
		
		/*Service Price Label panelCardCancelAppointment*/
		lblServicePrice_panelCardCancelAppointment = new JLabel("Service Price");
		lblServicePrice_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicePrice_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblServicePrice_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblServicePrice_panelCardCancelAppointment.setFocusable(false);
		lblServicePrice_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblServicePrice_panelCardCancelAppointment.setBounds(10, 333, 191, 36);
		panelCardCancelAppointment.add(lblServicePrice_panelCardCancelAppointment);
		/*End of Service Price Label panelCardCancelAppointment*/

		
		/*Service Price textField panelCardCancelAppointment*/
		textFieldServicePrice_panelCardCancelAppointment = new JTextField();
		textFieldServicePrice_panelCardCancelAppointment.setEditable(false);
		textFieldServicePrice_panelCardCancelAppointment.setToolTipText("Service Price");
		textFieldServicePrice_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldServicePrice_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldServicePrice_panelCardCancelAppointment.setColumns(10);
		textFieldServicePrice_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldServicePrice_panelCardCancelAppointment.setBounds(211, 333, 171, 36);
		panelCardCancelAppointment.add(textFieldServicePrice_panelCardCancelAppointment);
		/*End of Service Price textField panelCardCancelAppointment*/
		
		
		/*Invoice ID Label panelCardCancelAppointment*/
		lblInvoiceID_panelCardCancelAppointment = new JLabel("Invoice ID");
		lblInvoiceID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblInvoiceID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblInvoiceID_panelCardCancelAppointment.setFocusable(false);
		lblInvoiceID_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID_panelCardCancelAppointment.setBounds(10, 380, 191, 36);
		panelCardCancelAppointment.add(lblInvoiceID_panelCardCancelAppointment);
		/*End of Invoice ID Label panelCardCancelAppointment*/

		
		/*Invoice ID 2 Label panelCardCancelAppointment*/
		lblInvoiceID2_panelCardCancelAppointment = new JLabel("");
		lblInvoiceID2_panelCardCancelAppointment.setToolTipText("Invoice ID");
		lblInvoiceID2_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoiceID2_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblInvoiceID2_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		lblInvoiceID2_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblInvoiceID2_panelCardCancelAppointment.setBackground(new Color(102, 51, 153));
		lblInvoiceID2_panelCardCancelAppointment.setBounds(211, 379, 171, 37);
		panelCardCancelAppointment.add(lblInvoiceID2_panelCardCancelAppointment);
		/*End of Invoice ID 2 Label panelCardCancelAppointment*/

		
		/*Appointment Search Panel panelCardCancelAppointment*/
		panelAppointmentSearch_panelCardCancelAppointment = new JPanel();
		panelAppointmentSearch_panelCardCancelAppointment.setLayout(null);
		panelAppointmentSearch_panelCardCancelAppointment.setBackground(new Color(102, 51, 153));
		panelAppointmentSearch_panelCardCancelAppointment.setBounds(440, 45, 200, 275);
		panelCardCancelAppointment.add(panelAppointmentSearch_panelCardCancelAppointment);
		/*End of Appointment Search Panel panelCardCancelAppointment*/
		
		
		/*Appointment Search Label panelCardCancelAppointment*/
		lblAppointmentSearch_panelCardCancelAppointment = new JLabel("Search Appointment");
		lblAppointmentSearch_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentSearch_panelCardCancelAppointment.setForeground(Color.WHITE);
		lblAppointmentSearch_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 18));
		lblAppointmentSearch_panelCardCancelAppointment.setFocusable(false);
		lblAppointmentSearch_panelCardCancelAppointment.setBorder(null);
		lblAppointmentSearch_panelCardCancelAppointment.setBounds(10, 11, 180, 36);
		panelAppointmentSearch_panelCardCancelAppointment.add(lblAppointmentSearch_panelCardCancelAppointment);
		/*End of Appointment Search Label panelCardCancelAppointment*/

		
		/*Appointment Search Button panelCardCancelAppointment*/
		btnAppointmentSearch_panelCardCancelAppointment = new JButton();
		btnAppointmentSearch_panelCardCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				/*
				 *     Search Appointment
				 */
				
								
				//check if enter appointment ID field is empty 

				if(textFieldEnterAppointmentID_panelCardCancelAppointment.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter appointment ID"); }
				
				// else continue after "check if enter appointment ID field is empty "
				else          
				{
					PreparedStatement preparedstatement;
					PreparedStatement preparedstatementInvoice;

					try {
						preparedstatement = connection.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
						preparedstatement.setString(1, textFieldEnterAppointmentID_panelCardCancelAppointment.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if appointment ID correct
						if(resultset.next())
						{
							
							// get Invoice ID and Service Price
							preparedstatementInvoice = connection.prepareStatement("SELECT * FROM `Invoices` WHERE `AppointmentID`=?");
							preparedstatementInvoice.setString(1, textFieldEnterAppointmentID_panelCardCancelAppointment.getText());
							ResultSet resultsetInvoice = preparedstatementInvoice.executeQuery();
							String invoiceID = resultsetInvoice.getString(2);
							String servicePrice = Integer.toString(resultsetInvoice.getInt(8));
							preparedstatementInvoice.close();
							// End of get Invoice ID and Service Price

							
							// get Date 'String' from database and set date to JDatechooser
							String appointmentdate = resultset.getString(7);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(appointmentdate);
								Date_panelCardCancelAppointment.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							
							lblAppointmentsID2_panelCardCancelAppointment.setText(resultset.getString(2));
							textFieldPatientID_panelCardCancelAppointment.setText(resultset.getString(3));
							Time_panelCardCancelAppointment.setText(resultset.getString(8));
							comboBoxDoctorName_panelCardCancelAppointment.setSelectedItem(resultset.getString(6));
							comboBoxService_panelCardCancelAppointment.setSelectedItem(resultset.getString(9));
							lblInvoiceID2_panelCardCancelAppointment.setText(invoiceID);
							textFieldServicePrice_panelCardCancelAppointment.setText(servicePrice);
							
							
							// Close database
							preparedstatement.close();
						}
						
						// if appointment ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong! appointment ID not exist, please enter the right appointment ID");
							// Close database
							preparedstatement.close();
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
				
			
			}
		});
		btnAppointmentSearch_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAppointmentSearch_panelCardCancelAppointment.setText("Search");
		btnAppointmentSearch_panelCardCancelAppointment.setForeground(Color.WHITE);
		btnAppointmentSearch_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		btnAppointmentSearch_panelCardCancelAppointment.setFocusable(false);
		btnAppointmentSearch_panelCardCancelAppointment.setBackground(new Color(102, 51, 153));
		btnAppointmentSearch_panelCardCancelAppointment.setBounds(10, 229, 180, 35);
		panelAppointmentSearch_panelCardCancelAppointment.add(btnAppointmentSearch_panelCardCancelAppointment);
		/*End of Appointment Search Button panelCardCancelAppointment*/
		
		
		/*Appointment Search Enter ID Label panelCardCancelAppointment*/
		lblAppointmentsSearchEnterID_panelCardCancelAppointment = new JLabel("Enter Appointment ID");
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setForeground(Color.WHITE);
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 13));
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setFocusable(false);
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblAppointmentsSearchEnterID_panelCardCancelAppointment.setBounds(10, 79, 180, 36);
		panelAppointmentSearch_panelCardCancelAppointment.add(lblAppointmentsSearchEnterID_panelCardCancelAppointment);
		/*End of Appointment Search Enter ID Label panelCardCancelAppointment*/

		
		/*Enter Appointment ID textField panelCardCancelAppointment*/
		textFieldEnterAppointmentID_panelCardCancelAppointment = new JTextField();
		textFieldEnterAppointmentID_panelCardCancelAppointment.setToolTipText("Appointment ID");
		textFieldEnterAppointmentID_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterAppointmentID_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterAppointmentID_panelCardCancelAppointment.setColumns(10);
		textFieldEnterAppointmentID_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterAppointmentID_panelCardCancelAppointment.setBounds(10, 159, 180, 36);
		panelAppointmentSearch_panelCardCancelAppointment.add(textFieldEnterAppointmentID_panelCardCancelAppointment);
		/*End of Enter Appointment ID textField panelCardCancelAppointment*/

		
		/*Cancel Appointment Button panelCardCancelAppointment*/
		BtnCancelAppointment_panelCardCancelAppointment = new JButton();
		BtnCancelAppointment_panelCardCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				/*
				 *     Cancel Appointment and Invoice
				 */
				
				
				//check if enter Appointment ID field is empty

				if(textFieldEnterAppointmentID_panelCardCancelAppointment.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter appointment ID"); }
				
				//else continue after "check if Appointment ID field is empty"
				else    				
				{
					
					// Set data to "appointmentsDTO" object
					AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
					appointmentsDTO.setAppointmentID(textFieldEnterAppointmentID_panelCardCancelAppointment.getText());
					appointmentsDTO.setCanceld_By_Receptionist(receptionists_Name);
					// End of Set data to "appointmentsDTO" object

					// Send data to "cancelAppointmentDAO"
					new AppointmentsDAO().cancelAppointmentDAO(appointmentsDTO);
					// End of Send data to "cancelAppointmentDAO"
					

				}
			
			
			}
		});
		BtnCancelAppointment_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnCancelAppointment_panelCardCancelAppointment.setText("Cancel");
		BtnCancelAppointment_panelCardCancelAppointment.setForeground(Color.WHITE);
		BtnCancelAppointment_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnCancelAppointment_panelCardCancelAppointment.setFocusable(false);
		BtnCancelAppointment_panelCardCancelAppointment.setBackground(new Color(102, 51, 153));
		BtnCancelAppointment_panelCardCancelAppointment.setBounds(381, 450, 105, 35);
		panelCardCancelAppointment.add(BtnCancelAppointment_panelCardCancelAppointment);
		/*End of Cancel Appointment Button panelCardCancelAppointment*/

		
		/*Clear Fields Button panelCardCancelAppointment*/
		BtnClearFields_panelCardCancelAppointment = new JButton();
		BtnClearFields_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_panelCardCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear all fields
				ClearAll_panelCardCancelAppointment();
			}
		});
		BtnClearFields_panelCardCancelAppointment.setText("Clear");
		BtnClearFields_panelCardCancelAppointment.setForeground(Color.WHITE);
		BtnClearFields_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_panelCardCancelAppointment.setFocusable(false);
		BtnClearFields_panelCardCancelAppointment.setBackground(new Color(46, 139, 87));
		BtnClearFields_panelCardCancelAppointment.setBounds(266, 450, 105, 35);
		panelCardCancelAppointment.add(BtnClearFields_panelCardCancelAppointment);
		/*End of Clear Fields Button panelCardCancelAppointment*/

		
		/*Back Button panelCardCancelAppointment*/
		backBtn_panelCardCancelAppointment = new JButton();
		backBtn_panelCardCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_panelCardCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Show Appointments Main Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AppointmentsMainPanel);
				
				// clear all fields
				ClearAll_panelCardCancelAppointment();
			}
		});
		backBtn_panelCardCancelAppointment.setText("Back");
		backBtn_panelCardCancelAppointment.setForeground(Color.WHITE);
		backBtn_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_panelCardCancelAppointment.setFocusable(false);
		backBtn_panelCardCancelAppointment.setBackground(new Color(204, 0, 0));
		backBtn_panelCardCancelAppointment.setBounds(151, 450, 105, 35);
		panelCardCancelAppointment.add(backBtn_panelCardCancelAppointment);
		/*End of Back Button panelCardCancelAppointment*/
		
		
		/*Time TimePicker panelCardCancelAppointment*/
		Time_panelCardCancelAppointment = new TimePicker();
		Time_panelCardCancelAppointment.getComponentToggleTimeMenuButton().setEnabled(false);
		Time_panelCardCancelAppointment.getComponentTimeTextField().setEditable(false);
		Time_panelCardCancelAppointment.getComponentTimeTextField().setToolTipText("Time");
		Time_panelCardCancelAppointment.getComponentTimeTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Time_panelCardCancelAppointment.getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 17));
		Time_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		Time_panelCardCancelAppointment.setBounds(211, 238, 171, 36);
		panelCardCancelAppointment.add(Time_panelCardCancelAppointment);
		/*End of Time TimePicker panelCardCancelAppointment*/

		
		/*Cancel Appointment Title Label panelCardCancelAppointment*/
		lblCancelAppointmentTitle_panelCardCancelAppointment = new JLabel("Cancel Appointment Page");
		lblCancelAppointmentTitle_panelCardCancelAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelAppointmentTitle_panelCardCancelAppointment.setForeground(Color.BLACK);
		lblCancelAppointmentTitle_panelCardCancelAppointment.setFont(new Font("Kartika", Font.BOLD, 20));
		lblCancelAppointmentTitle_panelCardCancelAppointment.setFocusable(false);
		lblCancelAppointmentTitle_panelCardCancelAppointment.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblCancelAppointmentTitle_panelCardCancelAppointment.setBounds(168, 0, 317, 36);
		panelCardCancelAppointment.add(lblCancelAppointmentTitle_panelCardCancelAppointment);
		/*End of Cancel Appointment Title Label panelCardCancelAppointment*/
		
		

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
	     *      Random number for Appointment ID Method
	     * **************************************************
	     */
	public static void RandomAppointmentID()
	{
		Random random = new Random();
		lblAppointmentsID2_panelCardAddAppointment.setText("AP"+ random.nextInt(100000+1));
		
	}
	/*
     * **************************************************
     *  End of Random number for Appointment ID Method
     * **************************************************
     */
	
	
	
	
	   /*
     * **************************************************
     *      Random number for Invoice ID Method
     * **************************************************
     */
   public static void RandomInvoiceID()
   {
	Random random = new Random();
	lblInvoiceID2_panelCardAddAppointment.setText("IN"+ random.nextInt(100000+1));
	
   }
   /*
    * **************************************************
    *  End of Random number for Invoice ID Method
    * **************************************************
    */



	
	 /*
     * ***************************************************************************
     *            Clear All Fields For panelCardAddAppointmen Method
     * ***************************************************************************
     */
   public static void ClearAll()
   {
	   textFieldPatientID_panelCardAddAppointment.setText(null);
	   textFieldServicePrice_panelCardAddAppointment.setText(null);
	   comboBoxDoctorName_panelCardAddAppointment.setSelectedIndex(0);
	   comboBoxService_panelCardAddAppointment.setSelectedIndex(0);
	   Date_panelCardAddAppointment.setDate(null);
	   Time__panelCardAddAppointment.setText(null);
	   
	   // clear comboBox
		comboBoxDoctorName_panelCardAddAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

	   // get doctors names
		GetDoctorsNames();
	   RandomAppointmentID();
	   
	   RandomInvoiceID();
	   
   }
   /*
    * ***************************************************************************
    *         End of Clear All Fields For panelCardAddAppointmen Method
    * ***************************************************************************
    */
   
   
     
   
	 /*
    * ***************************************************************************
    *            Clear All Fields For panelCardUpdateAppointmen Method
    * ***************************************************************************
    */
  public static void ClearAll_panelCardUpdateAppointmen()
  {
	   textFieldPatientID_panelCardUpdateAppointment.setText(null);
	   textFieldEnterAppointmentID_panelCardUpdateAppointment.setText(null);
	   textFieldServicePrice_panelCardUpdateAppointment.setText(null);
	   comboBoxDoctorName_panelCardUpdateAppointment.setSelectedIndex(0);
	   comboBoxService_panelCardUpdateAppointment.setSelectedIndex(0);
	   Date_panelCardUpdateAppointment.setDate(null);
	   Time_panelCardUpdateAppointment.setText(null);
	   lblAppointmentsID2_panelCardUpdateAppointment.setText(null);
	   lblInvoiceID2_panelCardUpdateAppointment.setText(null);
	   
	   // clear comboBox
		comboBoxDoctorName_panelCardUpdateAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

	   // get doctors names
		GetDoctorsNames_panelCardUpdateAppointmen();
	  
	   
  }
  /*
   * ***************************************************************************
   *         End of Clear All Fields For panelCardUpdateAppointmen Method
   * ***************************************************************************
   */
  
  
 
  
	 /*
   * ***************************************************************************
   *            Clear All Fields For panelCardCancelAppointment Method
   * ***************************************************************************
   */
 public static void ClearAll_panelCardCancelAppointment()
 {
	   textFieldPatientID_panelCardCancelAppointment.setText(null);
	   textFieldEnterAppointmentID_panelCardCancelAppointment.setText(null);
	   textFieldServicePrice_panelCardCancelAppointment.setText(null);
	   comboBoxDoctorName_panelCardCancelAppointment.setSelectedIndex(0);
	   comboBoxService_panelCardCancelAppointment.setSelectedIndex(0);
	   Date_panelCardCancelAppointment.setDate(null);
	   Time_panelCardCancelAppointment.setText(null);
	   lblAppointmentsID2_panelCardCancelAppointment.setText(null);
	   lblInvoiceID2_panelCardCancelAppointment.setText(null);
	   
	   // clear comboBox
		comboBoxDoctorName_panelCardCancelAppointment.setModel(new DefaultComboBoxModel(new String[] {"Choose Doctor"}));

	   // get doctors names
		GetDoctorsNames_panelCardCancelAppointmen();
	  
	   
 }
 /*
  * ***************************************************************************
  *         End of Clear All Fields For panelCardCancelAppointment Method
  * ***************************************************************************
  */
 
 
   
  
   /*
    * ********************************************************************************************
    *    Get Doctors Names From database and set them into comboBox panelCardAddAppointmen Method
    * ********************************************************************************************
    */
   public static void  GetDoctorsNames()
	{
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedstatment = connection.prepareStatement("SELECT * FROM `Doctors`");
			ResultSet resultset;
			resultset = preparedstatment.executeQuery();
			
			while(resultset.next())
			{
				String DoctorsNames = resultset.getString(3)+" "+resultset.getString(4);
				comboBoxDoctorName_panelCardAddAppointment.addItem(DoctorsNames);
				
			}
			
			// close database
			preparedstatment.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   /*
    * **************************************************************************************************
    *   End of Get Doctors Names From database and set them into comboBox panelCardAddAppointmen Method
    * **************************************************************************************************
    */
   
   
   
   
   /*
    * ***********************************************************************************************
    *    Get Doctors Names From database and set them into comboBox panelCardUpdateAppointmen Method
    * ***********************************************************************************************
    */
   public static void  GetDoctorsNames_panelCardUpdateAppointmen()
	{
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedstatment = connection.prepareStatement("SELECT * FROM `Doctors`");
			ResultSet resultset;
			resultset = preparedstatment.executeQuery();
			
			while(resultset.next())
			{
				String DoctorsNames = resultset.getString(3)+" "+resultset.getString(4);
				comboBoxDoctorName_panelCardUpdateAppointment.addItem(DoctorsNames);
				
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
    *   End of Get Doctors Names From database and set them into comboBox panelCardUpdateAppointmen Method
    * *****************************************************************************************************
    */
   
   
   
   
   /*
    * ***********************************************************************************************
    *    Get Doctors Names From database and set them into comboBox panelCardCancelAppointmen Method
    * ***********************************************************************************************
    */
   public static void  GetDoctorsNames_panelCardCancelAppointmen()
	{
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedstatment = connection.prepareStatement("SELECT * FROM `Doctors`");
			ResultSet resultset;
			resultset = preparedstatment.executeQuery();
			
			while(resultset.next())
			{
				String DoctorsNames = resultset.getString(3)+" "+resultset.getString(4);
				comboBoxDoctorName_panelCardCancelAppointment.addItem(DoctorsNames);
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
    *   End of Get Doctors Names From database and set them into comboBox panelCardCancelAppointmen Method
    * *****************************************************************************************************
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
			
			Statement statment   = connection.createStatement();
			ResultSet resaultset = statment.executeQuery("SELECT * FROM `Appointments`");

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
	    *     Show data from database on table _ panelCardSearchByAppointmentID
	    * **********************************************************************
	    */
		
		public static void ShowDatabaseDataToTable_panelCardSearchByAppointmentID()
		{
			 
			try {
				
				Statement statment   = connection.createStatement();
				ResultSet resaultset = statment.executeQuery("SELECT * FROM `Appointments`");

				table_panelCardSearchByAppointmentID.setModel(DbUtils.resultSetToTableModel(resaultset));
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(0).setPreferredWidth(20);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(1).setPreferredWidth(130);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(2).setPreferredWidth(80);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(3).setPreferredWidth(100);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(4).setPreferredWidth(80);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(5).setPreferredWidth(100);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(6).setPreferredWidth(120);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(7).setPreferredWidth(80);
				table_panelCardSearchByAppointmentID.getColumnModel().getColumn(8).setPreferredWidth(130);
				
				// close database
				statment.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		/*
		    * **************************************************************************
		    *  End of Show data from database on table _ panelCardSearchByAppointmentID
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
					
					Statement statment   = connection.createStatement();
					ResultSet resaultset = statment.executeQuery("SELECT * FROM `Appointments`");

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
						
						Statement statment   = connection.createStatement();
						ResultSet resaultset = statment.executeQuery("SELECT * FROM `Appointments`");

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
}
