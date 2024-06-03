package mydentisten.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import com.toedter.calendar.JDateChooser;

import mydentisten.dao.DoctorsDAO;
import mydentisten.dao.PatientsDAO;
import mydentisten.dao.ReceptionistsDAO;
import mydentisten.dao.SupervisorsDAO;
import mydentisten.database.ConnectionFactory;
import mydentisten.dto.DoctorsDTO;
import mydentisten.dto.PatientsDTO;
import mydentisten.dto.UsersDTO;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
*
* @author amjad azim
*/

public class Supervisors_StaffPage extends JInternalFrame {

	
	
	/*Variables*/
	
	//JLabel
	private JLabel labelSupervisors_StaffMainPage;
	private JLabel labelReceptionists_StaffMainPage;
	private JLabel labelDoctors_StaffMainPage;
	private JLabel labelAddSupervisor_SupervisorsMainPage;
	private JLabel labelAddSupervisor2_SupervisorsMainPage;
	private JLabel labelUpdateSupervisor_SupervisorsMainPage;
	private JLabel labelUpdateSupervisor2_SupervisorsMainPage;
	private JLabel labelSupervisorsRecord_SupervisorsMainPage;
	private JLabel labelSupervisorsRecord2_SupervisorsMainPage;
	private JLabel labelDeleteSupervisor_SupervisorsMainPage;
	private JLabel labelDeleteSupervisor2_SupervisorsMainPage;
	private JLabel labelAddReceptionist_ReceptionistsMainPage;
	private JLabel labelAddReceptinist2_ReceptionistsMainPage;
	private JLabel labelUpdateReceptionist_ReceptionistsMainPage;
	private JLabel labelUpdateReceptionist2_ReceptionistsMainPage;
	private JLabel labelDeleteReceptionist_ReceptionistsMainPage;
	private JLabel labelDeleteReceptionist2_ReceptionistsMainPage;
	private JLabel labelReceptionistsRecord_ReceptionistsMainPage;
	private JLabel labelReceptionistsRecord2_ReceptionistsMainPage;
	private JLabel labelAddDoctor_DoctorsMainPage;
	private JLabel labelAddDoctor2_DoctorsMainPage;
	private JLabel labelUpdateDoctor_DoctorsMainPage;
	private JLabel labelUpdateDoctor2_DoctorsMainPage;
	private JLabel labelDeleteDoctor_DoctorsMainPage;
	private JLabel labelDeleteDoctor2_DoctorsMainPage;
	private JLabel labelDoctorsRecord_DoctorsMainPage;
	private JLabel labelDoctorsRecord2_DoctorsMainPage;
	private JLabel lblSupervisorUsername_AddSupervisorPage;
	private JLabel lblSupervisorPassword_AddSupervisorPage;
	private JLabel lblSupervisorRePassword_AddSupervisorPage;
	private JLabel lblSupervisorID_AddSupervisorPage;
	private static JLabel lblSupervisorID2_AddSupervisorPage;
	private JLabel lblSupervisorName_AddSupervisorPage;
	private JLabel lblSupervisorPhoneNO_AddSupervisorPage ;
	private JLabel lblSupervisorAddress_AddSupervisorPage;
	private JLabel lblSupervisorGender_AddSupervisorPage;
	private JLabel lblSupervisorDateOfBirth_AddSupervisorPage;
	private JLabel lblSupervisorLastName_AddSupervisorPage;
	private JLabel lblAddSupervisorTitle_AddSupervisorPage;
	private JLabel lblSupervisorsMainPageTitle_SupervisorsMainrPage;
	private JLabel lblSupervisorID_UpdateSupervisorPage;
	private JLabel lblSupervisorID2_UpdateSupervisorPage;
	private JLabel lblSupervisorName_UpdateSupervisorPage;
	private JLabel lblSupervisorPhoneNO_UpdateSupervisorPage;
	private JLabel lblSupervisorAddress_UpdateSupervisorPage;
	private JLabel lblSupervisorGender_UpdateSupervisorPage;
	private JLabel lblSupervisorDateOfBirth_UpdateSupervisorPage;
	private JLabel lblSupervisorLastName_UpdateSupervisorPage;
	private JLabel lblSupervisorUsername_UpdateSupervisorPage;
	private JLabel lblSupervisorPassword_UpdateSupervisorPage;
	private JLabel lblSupervisorRePassword_UpdateSupervisorPage;
	private JLabel lblUpdateSupervisorTitle_UpdateSupervisorPage;
	private JLabel lblSupervisorSearch_UpdateSupervisorPage;
	private JLabel lblSupervisorSearchEnterID_UpdateSupervisorPage;
	private JLabel lblUserType_UpdateSupervisorPage;
	private JLabel lblSupervisorID_DeleteSupervisorPage;
	private JLabel lblSupervisorID2_DeleteSupervisorPage;
	private JLabel lblSupervisorName_DeleteSupervisorPage;
	private JLabel lblSupervisorPhoneNO_DeleteSupervisorPage;
	private JLabel lblSupervisorAddress_DeleteSupervisorPage;
	private JLabel lblSupervisorGender_DeleteSupervisorPage;
	private JLabel lblSupervisorDateOfBirth_DeleteSupervisorPage;
	private JLabel lblSupervisorLastName_DeleteSupervisorPage;
	private JLabel lblSupervisorUsername_DeleteSupervisorPage;
	private JLabel lblSupervisorPassword_DeleteSupervisorPage;
	private JLabel lblDeleteSupervisorTitle_DeleteSupervisorPage;
	private JLabel lblSupervisorSearch_DeleteSupervisorPage;
	private JLabel lblSupervisorSearchEnterID_DeleteSupervisorPage;
	private JLabel lblUserType_DeleteSupervisorPage;
	private JLabel lblSupervisorID_SupervisorsRecordPage;
	private JLabel lblSupervisorsRecordPage_SupervisorsRecordPage;
	private JLabel lblSupervisorName_SupervisorsRecordPage;
	private JLabel lblReceptionistID_AddReceptionistPage;
	private static JLabel lblReceptionistID2_AddReceptionistPage;
	private JLabel lblReceptionistName_AddReceptionistPage;
	private JLabel lblReceptionistPhoneNO_AddReceptionistPage;
	private JLabel lblReceptionistAddress_AddReceptionistPage;
	private JLabel lblReceptionistGender_AddReceptionistPage;
	private JLabel lblReceptionistDateOfBirth_AddReceptionistPage;
	private JLabel lblReceptionistLastName_AddReceptionistPage;
	private JLabel lblReceptionistUsername_AddReceptionistPage;
	private JLabel lblReceptionistPassword_AddReceptionistPage;
	private JLabel lblReceptionistRePassword_AddReceptionistPage;
	private JLabel lblAddReceptionistTitle_AddReceptionistPage;
	private JLabel lblReceptionistsMainPageTitle_ReceptionistsMainPage;
	private JLabel lblReceptionistID_UpdateReceptionistPage;
	private JLabel lblReceptionistID2_UpdateReceptionistPage;
	private JLabel lblReceptionistName_UpdateReceptionistPage;
	private JLabel lblReceptionistPhoneNO_UpdateReceptionistPage;
	private JLabel lblReceptionistAddress_UpdateReceptionistPage;
	private JLabel lblReceptionistGender_UpdateReceptionistPage;
	private JLabel lblReceptionistDateOfBirth_UpdateReceptionistPage;
	private JLabel lblReceptionistLastName_UpdateReceptionistPage;
	private JLabel lblReceptionistUsername_UpdateReceptionistPage;
	private JLabel lblReceptionistPassword_UpdateReceptionistPage;
	private JLabel lblReceptionistRePassword_UpdateReceptionistPage;
	private JLabel lblUpdateReceptionistTitle_UpdateReceptionistPage;
	private JLabel lblReceptionistSearch_UpdateReceptionistPage;
	private JLabel lblReceptionistSearchEnterID_UpdateReceptionistPage;
	private JLabel lblUserType_UpdateReceptionistPage;
	private JLabel lblReceptionistID_DeleteReceptionistPage;
	private JLabel lblReceptionistID2_DeleteReceptionistPage;
	private JLabel lblReceptionistName_DeleteReceptionistPage;
	private JLabel lblReceptionistPhoneNO_DeleteReceptionistPage;
	private JLabel lblReceptionistAddress_DeleteReceptionistPage;
	private JLabel lblReceptionistGender_DeleteReceptionistPage;
	private JLabel lblReceptionistDateOfBirth_DeleteReceptionistPage;
	private JLabel lblReceptionistLastName_DeleteReceptionistPage;
	private JLabel lblReceptionistUsername_DeleteReceptionistPage;
	private JLabel lblReceptionistPassword_DeleteReceptionistPage;
	private JLabel lblDeleteReceptionistTitle_DeleteReceptionistPage;
	private JLabel lblReceptionistSearch_DeleteReceptionistPage;
	private JLabel lblReceptionistSearchEnterID_DeleteReceptionistPage;
	private JLabel lblUserType_DeleteReceptionistPage;
	private JLabel lblReceptionistID_ReceptionistsRecordPage;
	private JLabel lblReceptionistsRecordPage_ReceptionistsRecordPage;
	private JLabel lblSupervisorName_ReceptionistsRecordPage;
	private JLabel lblDoctorsMainPageTitle_DoctorsMainrPage;
	private JLabel lblDoctorID_AddDoctorPage;
	private static JLabel lblDoctorID2_AddDoctorPage;
	private JLabel lblDoctorName_AddDoctorPage;
	private JLabel lblDoctorPhoneNO_AddDoctorPage;
	private JLabel lblDoctorGender_AddDoctorPage;
	private JLabel lblDoctorAddress_AddDoctorPage;
	private JLabel lblDoctorDateOfBirth_AddDoctorPage;
	private JLabel lblDoctorLastName_AddDoctorPage;
	private JLabel lblDoctorSpecialist_AddDoctorPage;
	private JLabel lblAddDoctorTitle_AddDoctororPage;
	private JLabel lblDoctorID_UpdateDoctorPage;
	private JLabel lblDoctorID2_UpdateDoctorPage;
	private JLabel lblDoctorName_UpdateDoctorPage;
	private JLabel lblDoctorPhoneNO_UpdateDoctorPage;
	private JLabel lblDoctorAddress_UpdateDoctorPage;
	private JLabel lblDoctorGender_UpdateDoctorPage;
	private JLabel lblDoctorDateOfBirth_UpdateDoctorPage;
	private JLabel lblDoctorLastName_UpdateDoctorPage;
	private JLabel lblUpdateDoctorTitle_UpdateDoctorPage;
	private JLabel lblDoctorSearch_UpdateDoctorPage;
	private JLabel lblDoctorSearchEnterID_UpdateDoctorPage;
	private JLabel lblDoctorSpecialist_UpdateDoctorPage;
	private JLabel lblDoctorID_DeleteDoctorPage;
	private JLabel lblDoctorID2_DeleteDoctorPage;
	private JLabel lblDoctorName_DeleteDoctorPage;
	private JLabel lblDoctorPhoneNO_DeleteDoctorPage;
	private JLabel lblDoctorAddress_DeleteDoctorPage;
	private JLabel lblDoctorGender_DeleteDoctorPage;
	private JLabel lblDoctorDateOfBirth_DeleteDoctorPage;
	private JLabel lblDoctorLastName_DeleteDoctorPage;
	private JLabel lblDeleteDoctorTitle_DeleteDoctorPage;
	private JLabel lblDoctorSearch_DeleteDoctorPage;
	private JLabel lblDoctorSearchEnterID_DeleteDoctorPage;
	private JLabel lblDoctorSpecialist_DeleteDoctorPage;
	private JLabel lblDoctorSpecialist_DoctorsRecordPage;
	private JLabel lblDoctorID_DoctorsRecordPage;
	private JLabel lblDoctorsRecordPage_DoctorsRecordPage;
	private JLabel lblSupervisorName_DoctorsRecordPage;

	//JButton
	private JButton backBtn_SupervisorsMainPage;
	private JButton backBtn_ReceptionistsMainPage;
	private JButton backBtn_DoctorsMainPage;
	private JButton BtnNewSupervisorID_AddSupervisorPage;
	private JButton backBtn_AddSupervisorPage;
	private JButton BtnClearFields_AddSupervisorPage;
	private JButton BtnAddSupervisor_AddSupervisorPage;
	private JButton BtnShowPassword_AddSupervisorPage;
	private JButton backBtn_UpdateSupervisorPage;
	private JButton BtnClearFields_UpdateSupervisorPage;
	private JButton BtnUpdateSupervisor_UpdateSupervisorPage;
	private JButton BtnShowPassword_UpdateSupervisorPage;
	private JButton btnSearch_UpdateSupervisorPage;
	private JButton backBtn_DeleteSupervisorPage;
	private JButton BtnClearFields_DeleteSupervisorPage;
	private JButton BtnDeleteSupervisor_DeleteSupervisorPage;
	private JButton btnSearch_DeleteSupervisorPage;
	private JButton BtnBack_SupervisorsRecordPage;
	private JButton BtnClearcField_SupervisorsRecordPage;
	private JButton btnSearchSupervisorID_SupervisorsRecordPage;
	private JButton btnShowAllAddedSupervisors_SupervisorsRecordPage;
	private JButton btnShowAllUpdatedSupervisor_SupervisorsRecordPage;
	private JButton BtnNewReceptionistID_AddReceptionistPage;
	private JButton backBtn_AddReceptionistPage;
	private JButton BtnClearFields_AddReceptionistPage;
	private JButton BtnAddReceptionist_AddReceptionistPage;
	private JButton BtnShowPassword_AddReceptionistPage;
	private JButton backBtn_UpdateReceptionistPage;
	private JButton BtnClearFields_UpdateReceptionistPage;
	private JButton BtnUpdateReceptionist_UpdateReceptionistPage;
	private JButton BtnShowPassword_UpdateReceptionistPage;
	private JButton btnSearch_UpdateReceptionistPage;
	private JButton backBtn_DeleteReceptionistPage;
	private JButton BtnClearFields_DeleteReceptionistPage;
	private JButton BtnDeleteReceptionist_DeleteReceptionistPage;
	private JButton btnSearch_DeleteReceptionistPage;
	private JButton BtnBack_ReceptionistsRecordPage;
	private JButton BtnClearcField_ReceptionistsRecordPage;
	private JButton btnSearchReceptionistID_ReceptionistsRecordPage;
	private JButton btnShowAllAddedReceptionists_ReceptionistsRecordPage;
	private JButton btnShowAllUpdatedReceptionists_ReceptionistsRecordPage;
	private JButton BtnNewDoctorID_AddDoctorPage;
	private JButton backBtn_AddDoctorPage;
	private JButton BtnClearFields_AddDoctorPage;
	private JButton BtnAddDoctor_AddDoctorPage;
	private JButton backBtn_UpdateDoctorPage;
	private JButton BtnClearFields_UpdateDoctorPage;
	private JButton BtnUpdateDoctor_UpdateDoctorPage;
	private JButton btnSearch_UpdateDoctorPage;
	private JButton backBtn_DeleteDoctorPage;
	private JButton BtnClearFields_DeleteDoctorPage;
	private JButton BtnDeleteDoctor_DeleteDoctorPage;
	private JButton btnSearch_DeleteDoctorPage;
	private JButton btnSearchSpecialist_DoctorsRecordPage;
	private JButton BtnBack_DoctorsRecordPage;
	private JButton BtnClearcField_DoctorsRecordPage;
	private JButton btnSearchDoctorID_DoctorsRecordPage;
	private JButton btnShowAllAddedDoctors_DoctorsRecordPage;
	private JButton btnShowAllUpdatedDoctors_DoctorsRecordPage;
	
	//JTextField
	private JTextField textFieldSupervisorName_AddSupervisorPage;
	private JTextField textFieldSupervisorPhoneNO_AddSupervisorPage;
	private JTextField textFieldSupervisorAddress_AddSupervisorPage;
	private JTextField textFieldSupervisorLastName_AddSupervisorPage;
	private JTextField textFieldSupervisorUsername_AddSupervisorPage;
    private JTextField textFieldSupervisorName_UpdateSupervisorPage;	
	private JTextField textFieldSupervisorPhoneNO_UpdateSupervisorPage;
	private JTextField textFieldSupervisorAddress_UpdateSupervisorPage;
	private JTextField textFieldSupervisorLastName_UpdateSupervisorPage;
	private JTextField textFieldSupervisorUsername_UpdateSupervisorPage;
	private JTextField textFieldEnterSupervisorID_UpdateSupervisorPage;
	private JTextField textFieldSupervisorName_DeleteSupervisorPage;
	private JTextField textFieldSupervisorPhoneNO_DeleteSupervisorPage;
	private JTextField textFieldSupervisorAddress_DeleteSupervisorPage;
	private JTextField textFieldSupervisorLastName_DeleteSupervisorPage;
	private JTextField textFieldSupervisorUsername_DeleteSupervisorPage;
	private JTextField textFieldEnterSupervisorID_DeleteSupervisorPage;
	private JTextField textFieldSupervisorID_SupervisorsRecordPage;
	private JTextField textFieldSupervisorName_SupervisorsRecordPage;
	private JTextField textFieldReceptionistName_AddReceptionistPage;
	private JTextField textFieldReceptionistPhoneNO_AddReceptionistPage;
	private JTextField textFieldReceptionistAddress_AddReceptionistPage;
	private JTextField textFieldReceptionistLastName_AddReceptionistPage;
	private JTextField textFieldReceptionistUsername_AddReceptionistPage;
	private JTextField textFieldReceptionistName_UpdateReceptionistPage;
	private JTextField textFieldReceptionistPhoneNO_UpdateReceptionistPage;
	private JTextField textFieldReceptionistAddress_UpdateReceptionistPage;
	private JTextField textFieldReceptionistLastName_UpdateReceptionistPage;
	private JTextField textFieldReceptionistUsername_UpdateReceptionistPage;
	private JTextField textFieldEnterReceptionistID_UpdateReceptionistPage;
	private JTextField textFieldReceptionistName_DeleteReceptionistPage;
	private JTextField textFieldReceptionistPhoneNO_DeleteReceptionistPage;
	private JTextField textFieldReceptionistAddress_DeleteReceptionistPage;
	private JTextField textFieldReceptionistLastName_DeleteReceptionistPage;
	private JTextField textFieldReceptionistUsername_DeleteReceptionistPage;
	private JTextField textFieldEnterReceptionistID_DeleteReceptionistPage;
	private JTextField textFieldReceptionistID_ReceptionistsRecordPage;
	private JTextField textFieldSupervisorName_ReceptionistsRecordPage;
	private JTextField textFieldDoctorName_AddDoctorPage;
	private JTextField textFieldDoctorPhoneNO_AddDoctorPage;
	private JTextField textFieldDoctorAddress_AddDoctorPage;	
	private JTextField textFieldDoctorLastName_AddDoctorPage;
	private JTextField textFieldDoctorName_UpdateDoctorPage;
	private JTextField textFieldDoctorPhoneNO_UpdateDoctorPage;
	private JTextField textFieldDoctorAddress_UpdateDoctorPage;
	private JTextField textFieldDoctorLastName_UpdateDoctorPage;
	private JTextField textFieldDoctorSearchEnterID_UpdateDoctorPage;
	private JTextField textFieldDoctorName_DeleteDoctorPage;
	private JTextField textFieldDoctorPhoneNO_DeleteDoctorPage;
	private JTextField textFieldDoctorAddress_DeleteDoctorPage;
	private JTextField textFieldDoctorLastName_DeleteDoctorPage;
	private JTextField textFieldEnterDoctorID_DeleteDoctorPage;
	private JTextField textFieldDoctorID_DoctorsRecordPage;
	private JTextField textFieldSupervisorName_DoctorsRecordPage;
	
	//JPasswordField
	private JPasswordField passwordFieldPassword_AddSupervisorPage;
	private JPasswordField passwordFieldRePassword_AddSupervisorPage;
	private JPasswordField passwordFieldSupervisorPassword_UpdateSupervisorPage;
	private JPasswordField passwordFieldSupervisorRePassword_UpdateSupervisorPage;
	private JPasswordField passwordFieldSupervisorPassword_DeleteSupervisorPage;
	private JPasswordField passwordFieldReceptionistPassword_AddReceptionistPage;
	private JPasswordField passwordFieldReceptionistRePassword_AddReceptionistPage;
	private JPasswordField passwordFieldReceptionistPassword_UpdateReceptionistPage;
	private JPasswordField passwordFieldReceptionistRePassword_UpdateReceptionistPage;
	private JPasswordField passwordFieldReceptionistPassword_DeleteReceptionistPage;
	
	//String
	final static String  StaffMainPagePanel = "Staff Main Page";
	final static String  SupervisorsMainPagePanel = "Supervisors Main Page";
	final static String  ReceptionistsMainPagePanel = "Receptionists Main Page";
	final static String  DoctorsMainPagePanel = "Doctors Main Page";
	final static String  AddSupervisorPagePanel = "Add Supervisor Page";
	final static String  UpdateSupervisorPagePanel = "Update Supervisor Page";
	final static String  DeleteSupervisorPagePanel = "Delete Supervisor Page";
	final static String  SupervisorsRecordPagePanel = "Supervisors Record Page";
	final static String  AddReceptionistPagePanel = "Add Receptionist Page";
	final static String  UpdateReceptionistPagePanel = "Update Receptionist Page";
	final static String  DeleteReceptionistPagePanel = "Delete Receptionist Page";
	final static String  ReceptionistsRecordPagePanel = "Receptionists Record Page";
	final static String  AddDoctorPagePanel = "Add Doctor Page";
	final static String  UpdateDoctorPagePanel = "Update Doctor Page";
	final static String  DeleteDoctorPagePanel = "Delete Doctor Page";
	final static String  DoctorsRecordPagePanel = "Doctors Record Page";
	public String supervisorName;
	
	//JSeparator
	private JSeparator separatorHorizontal_SupervisorsMainPage;
	private JSeparator separatorVertical_SupervisorsMainPage;
	private JSeparator separatorHorizontal_ReceptionistsMainPage;
	private JSeparator separatorVertical_ReceptionistsMainPage;
	private JSeparator separatorHorizontal_DoctorsMainPage;
	private JSeparator separatorVertical_DoctorsMainPage;
	private JSeparator separatorVertical_AddDoctorPage;
	
	//JComboBox
	private JComboBox comboBoxGender_AddSupervisorPage;
	private JComboBox comboBoxGender_UpdateSupervisorPage;
	private JComboBox comboBoxUserType_UpdateSupervisorPage;
	private JComboBox comboBoxGender_DeleteSupervisorPage;
	private JComboBox comboBoxUserType_DeleteSupervisorPage;
	private JComboBox comboBoxGender_AddReceptionistPage;
	private JComboBox comboBoxUserType_UpdateReceptionistPage;
	private JComboBox comboBoxGender_UpdateReceptionistPage;
	private JComboBox comboBoxGender_DeleteReceptionistPage;
	private JComboBox comboBoxUserType_DeleteReceptionistPage;
	private JComboBox comboBoxSpecialist_AddDoctorPage;
	private JComboBox comboBoxGender_AddDoctorPage;
	private JComboBox comboBoxGender_UpdateDoctorPage;
	private JComboBox comboBoxSpecialist_UpdateDoctorPage;
	private JComboBox comboBoxGender_DeleteDoctorPage;
	private JComboBox comboBoxSpecialist_DeleteDoctorPage;
	private JComboBox comboBoxSpecialist_DoctorsRecordPage;

	//JDateChooser
	private JDateChooser SupervisorDateOfBirth_AddSupervisorPage;
	private JDateChooser SupervisorDateOfBirth_UpdateSupervisorPage;
	private JDateChooser SupervisorDateOfBirth_DeleteSupervisorPage;
	private JDateChooser ReceptionistDateOfBirth_AddReceptionistPage;
	private JDateChooser ReceptionistDateOfBirth_UpdateReceptionistPage;
	private JDateChooser ReceptionistDateOfBirth_DeleteReceptionistPage;
	private JDateChooser DoctorDateOfBirth_AddDoctorPage;
	private JDateChooser DoctorDateOfBirth_UpdateDoctorPage;
	private JDateChooser DoctorDateOfBirth_DeleteDoctorPage;

	//JSparator
	private JSeparator separatorVertical_AddSupervisorPage;
	private JSeparator separatorVertical_UpdateSupervisorPage;
	private JSeparator separatorVertical_DeleteSupervisorPage;
	private JSeparator separatorVertical_AddReceptionistPage;
	private JSeparator separatorVertical_UpdateReceptionistPage;
	private JSeparator separatorVertical_DeleteReceptionistPage;
	private JSeparator separatorVertical_UpdateDoctorPage;
	private JSeparator separatorVertical_DeleteDoctorPage;

	//JScrollPane
	private JScrollPane scrollPane_SupervisorsRecordPage;
	private JScrollPane scrollPane_ReceptionistsRecordPage;
	private JScrollPane scrollPane_DoctorsRecordPage;

	//JTable
	private static JTable table_SupervisorsRecordPage;
	private static JTable table_ReceptionistsRecordPage;
	private static JTable table_DoctorsRecordPage;

	//Connection
    private static Connection connection; 

	/*End of Variables*/
	
	
	
	/*Panels*/
	private JPanel panelCards;
	private JPanel panelCard_StaffMainPage;
	private JPanel panelSupervisors_StaffMainPage;
	private JPanel panelReceptionists_StaffMainPage;
	private JPanel panelDoctors_StaffMainPage;
	private JPanel panelCard_SupervisorsMainPage;
	private JPanel panelAddSupervisor_SupervisorsMainPage;
	private JPanel panelUpdateSupervisor_SupervisorsMainPage;
	private JPanel panelDeleteSupervisor_SupervisorsMainPage;
	private JPanel panelSupervisorsRecord_SupervisorsMainPage;
	private JPanel panelCard_ReceptionistsMainPage;
	private JPanel panelAddReceptionist_ReceptionistsMainPage;
	private JPanel panelUpdateReceptionist_ReceptionistsMainPage;
	private JPanel panelDeleteReceptionist_ReceptionistsMainPage;
	private JPanel panelReceptionistsRecord_ReceptionistsMainPage;
	private JPanel panelCard_DoctorsMainPage;
	private JPanel panelAddDoctor_DoctorsMainPage;
	private JPanel panelUpdateDoctor_DoctorsMainPage;
	private JPanel panelDeleteDoctor_DoctorsMainPage;
	private JPanel panelDoctorsRecord_DoctorsMainPage;
	private JPanel panelCard_AddSupervisorPage;
	private JPanel panelCard_UpdateSupervisorPage;
	private JPanel panelSupervisorSearch_UpdateSupervisorPage;
	private JPanel panelCard_DeleteSupervisorPage;
	private JPanel panelSupervisorSearch_DeleteSupervisorPage;
	private JPanel panelCard_SupervisorsRecordPage;
	private JPanel panelCard_AddReceptionistPage;
	private JPanel panelCard_UpdateReceptionistPage;
	private JPanel panelReceptionistSearch_UpdateReceptionistPage;
	private JPanel panelCard_DeleteReceptionistPage;
	private JPanel panelReceptionistSearch_DeleteReceptionistPage;
	private JPanel panelCard_ReceptionistsRecordPage;
	private JPanel panelCard_AddDoctororPage;
	private JPanel panelCard_UpdateDoctorPage;
	private JPanel panelDoctorSearch_UpdateDoctorPage;
	private JPanel panelCard_DeleteDoctorPage;
	private JPanel panelDoctorSearch_DeleteDoctorPage;
	private JPanel panelCard_DoctorsRecordPage;
	/*End of Panels*/


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisors_StaffPage frame = new Supervisors_StaffPage();
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
	public Supervisors_StaffPage() {
		getContentPane().setBackground(Color.WHITE);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(null);
		setFrameIcon(null);
		setBounds(0, 0, 650, 522);
		getContentPane().setLayout(null);
		
		
		/*Cards Panel*/
		panelCards = new JPanel();
		panelCards.setBounds(0, 0, 650, 496);
		panelCards.setBackground(Color.WHITE);
		getContentPane().add(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		/*End of Cards Panel*/


		/*Card Staff Main Page Panel*/
		panelCard_StaffMainPage = new JPanel();
		panelCard_StaffMainPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_StaffMainPage, StaffMainPagePanel);
		panelCard_StaffMainPage.setLayout(null);
		/*End of Card Staff Main Page Panel*/

		
		/*Supervisors Panel StaffMainPage*/
		panelSupervisors_StaffMainPage = new JPanel();
		panelSupervisors_StaffMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Supervisors Main Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsMainPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSupervisors_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSupervisors_StaffMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSupervisors_StaffMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSupervisors_StaffMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelSupervisors_StaffMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSupervisors_StaffMainPage.setLayout(null);
		panelSupervisors_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSupervisors_StaffMainPage.setBackground(Color.WHITE);
		panelSupervisors_StaffMainPage.setBounds(37, 121, 249, 118);
		panelCard_StaffMainPage.add(panelSupervisors_StaffMainPage);
		/*End of Supervisors Panel StaffMainPage*/

		
		/*Supervisors Label StaffMainPage*/
		labelSupervisors_StaffMainPage = new JLabel("Supervisors");
		labelSupervisors_StaffMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupervisors_StaffMainPage.setForeground(Color.BLACK);
		labelSupervisors_StaffMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSupervisors_StaffMainPage.setBounds(10, 42, 223, 38);
		panelSupervisors_StaffMainPage.add(labelSupervisors_StaffMainPage);
		/*End of Supervisors Label StaffMainPage*/
		
		
		/*Receptionists Panel StaffMainPage*/
		panelReceptionists_StaffMainPage = new JPanel();
		panelReceptionists_StaffMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Receptionists Main Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsMainPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelReceptionists_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelReceptionists_StaffMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelReceptionists_StaffMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelReceptionists_StaffMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelReceptionists_StaffMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelReceptionists_StaffMainPage.setLayout(null);
		panelReceptionists_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelReceptionists_StaffMainPage.setBackground(Color.WHITE);
		panelReceptionists_StaffMainPage.setBounds(367, 121, 249, 118);
		panelCard_StaffMainPage.add(panelReceptionists_StaffMainPage);
		/*End of Receptionists Panel StaffMainPage*/

		
		/*Receptionists Label StaffMainPage*/
		labelReceptionists_StaffMainPage = new JLabel("Receptionists");
		labelReceptionists_StaffMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelReceptionists_StaffMainPage.setForeground(Color.BLACK);
		labelReceptionists_StaffMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelReceptionists_StaffMainPage.setBounds(10, 42, 223, 38);
		panelReceptionists_StaffMainPage.add(labelReceptionists_StaffMainPage);
		/*End of Receptionists Label StaffMainPage*/

		
		/*Doctors Panel StaffMainPage*/
		panelDoctors_StaffMainPage = new JPanel();
		panelDoctors_StaffMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Doctors Main Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsMainPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDoctors_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDoctors_StaffMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDoctors_StaffMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDoctors_StaffMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelDoctors_StaffMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDoctors_StaffMainPage.setLayout(null);
		panelDoctors_StaffMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDoctors_StaffMainPage.setBackground(Color.WHITE);
		panelDoctors_StaffMainPage.setBounds(212, 250, 249, 118);
		panelCard_StaffMainPage.add(panelDoctors_StaffMainPage);
		/*End of Doctors Panel StaffMainPage*/

		
		/*Doctors Label StaffMainPage*/
		labelDoctors_StaffMainPage = new JLabel("Doctors");
		labelDoctors_StaffMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDoctors_StaffMainPage.setForeground(Color.BLACK);
		labelDoctors_StaffMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDoctors_StaffMainPage.setBounds(10, 42, 223, 38);
		panelDoctors_StaffMainPage.add(labelDoctors_StaffMainPage);
		/*End of Doctors Label StaffMainPage*/


		/*Supervisors Main page Panel*/
		panelCard_SupervisorsMainPage = new JPanel();
		panelCard_SupervisorsMainPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_SupervisorsMainPage, SupervisorsMainPagePanel);
		panelCard_SupervisorsMainPage.setLayout(null);
		/*End of Supervisors Main page Panel*/

		
		/*Add Supervisor Panel SupervisorsMainPage*/
		panelAddSupervisor_SupervisorsMainPage = new JPanel();
		panelAddSupervisor_SupervisorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Add Supervisor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AddSupervisorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAddSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAddSupervisor_SupervisorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelAddSupervisor_SupervisorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAddSupervisor_SupervisorsMainPage.setLayout(null);
		panelAddSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAddSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
		panelAddSupervisor_SupervisorsMainPage.setBounds(77, 44, 180, 167);
		panelCard_SupervisorsMainPage.add(panelAddSupervisor_SupervisorsMainPage);
		/*End of Add Supervisor Panel SupervisorsMainPage*/

		
		/*Add Supervisor Label SupervisorsMainPage*/
		labelAddSupervisor_SupervisorsMainPage = new JLabel("Add");
		labelAddSupervisor_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddSupervisor_SupervisorsMainPage.setForeground(Color.BLACK);
		labelAddSupervisor_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddSupervisor_SupervisorsMainPage.setBounds(10, 58, 160, 35);
		panelAddSupervisor_SupervisorsMainPage.add(labelAddSupervisor_SupervisorsMainPage);
		/*End of Add Supervisor Label SupervisorsMainPage*/

		
		/*Add Supervisor 2 Label SupervisorsMainPage*/
		labelAddSupervisor2_SupervisorsMainPage = new JLabel("Supervisor");
		labelAddSupervisor2_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddSupervisor2_SupervisorsMainPage.setForeground(Color.BLACK);
		labelAddSupervisor2_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddSupervisor2_SupervisorsMainPage.setBounds(10, 91, 160, 35);
		panelAddSupervisor_SupervisorsMainPage.add(labelAddSupervisor2_SupervisorsMainPage);
		/*End of Add Supervisor 2 Label SupervisorsMainPage*/
		
		
		/*Update Supervisor Panel SupervisorsMainPage*/
		panelUpdateSupervisor_SupervisorsMainPage = new JPanel();
		panelUpdateSupervisor_SupervisorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Update Supervisor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, UpdateSupervisorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdateSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelUpdateSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdateSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelUpdateSupervisor_SupervisorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelUpdateSupervisor_SupervisorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUpdateSupervisor_SupervisorsMainPage.setLayout(null);
		panelUpdateSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelUpdateSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
		panelUpdateSupervisor_SupervisorsMainPage.setBounds(386, 44, 180, 167);
		panelCard_SupervisorsMainPage.add(panelUpdateSupervisor_SupervisorsMainPage);
		/*End of Update Supervisor Panel SupervisorsMainPage*/

		
		/*Update Supervisor Label SupervisorsMainPage*/
		labelUpdateSupervisor_SupervisorsMainPage = new JLabel("Update");
		labelUpdateSupervisor_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateSupervisor_SupervisorsMainPage.setForeground(Color.BLACK);
		labelUpdateSupervisor_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateSupervisor_SupervisorsMainPage.setBounds(10, 58, 160, 35);
		panelUpdateSupervisor_SupervisorsMainPage.add(labelUpdateSupervisor_SupervisorsMainPage);
		/*End of Update Supervisor Label SupervisorsMainPage*/
		
		
		/*Update Supervisor 2 Label SupervisorsMainPage*/
		labelUpdateSupervisor2_SupervisorsMainPage = new JLabel("Supervisor");
		labelUpdateSupervisor2_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateSupervisor2_SupervisorsMainPage.setForeground(Color.BLACK);
		labelUpdateSupervisor2_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateSupervisor2_SupervisorsMainPage.setBounds(10, 89, 160, 35);
		panelUpdateSupervisor_SupervisorsMainPage.add(labelUpdateSupervisor2_SupervisorsMainPage);
		/*End of Update Supervisor 2 Label SupervisorsMainPage*/

		
		/*Horizontal Separator SupervisorsMainPage*/
		separatorHorizontal_SupervisorsMainPage = new JSeparator();
		separatorHorizontal_SupervisorsMainPage.setForeground(new Color(216, 191, 216));
		separatorHorizontal_SupervisorsMainPage.setBorder(null);
		separatorHorizontal_SupervisorsMainPage.setBackground(new Color(102, 51, 153));
		separatorHorizontal_SupervisorsMainPage.setBounds(153, 240, 343, 2);
		panelCard_SupervisorsMainPage.add(separatorHorizontal_SupervisorsMainPage);
		/*End of Horizontal Separator SupervisorsMainPage*/

		
		/*Vertical Separator SupervisorsMainPage*/
		separatorVertical_SupervisorsMainPage = new JSeparator();
		separatorVertical_SupervisorsMainPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_SupervisorsMainPage.setForeground(new Color(216, 191, 216));
		separatorVertical_SupervisorsMainPage.setBorder(null);
		separatorVertical_SupervisorsMainPage.setBackground(new Color(102, 51, 153));
		separatorVertical_SupervisorsMainPage.setBounds(321, 77, 2, 343);
		panelCard_SupervisorsMainPage.add(separatorVertical_SupervisorsMainPage);
		/*End of Vertical Separator SupervisorsMainPage*/
		
		
		/*Delete Supervisor Panel SupervisorsMainPage*/
		panelDeleteSupervisor_SupervisorsMainPage = new JPanel();
		panelDeleteSupervisor_SupervisorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Delete Supervisor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DeleteSupervisorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeleteSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDeleteSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeleteSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDeleteSupervisor_SupervisorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelDeleteSupervisor_SupervisorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDeleteSupervisor_SupervisorsMainPage.setLayout(null);
		panelDeleteSupervisor_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDeleteSupervisor_SupervisorsMainPage.setBackground(Color.WHITE);
		panelDeleteSupervisor_SupervisorsMainPage.setBounds(77, 275, 180, 167);
		panelCard_SupervisorsMainPage.add(panelDeleteSupervisor_SupervisorsMainPage);
		/*End of Delete Supervisor Panel SupervisorsMainPage*/

		
		/*Delete Supervisor  Label SupervisorsMainPage*/
		labelDeleteSupervisor_SupervisorsMainPage = new JLabel("Delete");
		labelDeleteSupervisor_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteSupervisor_SupervisorsMainPage.setForeground(Color.BLACK);
		labelDeleteSupervisor_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteSupervisor_SupervisorsMainPage.setBounds(10, 58, 160, 35);
		panelDeleteSupervisor_SupervisorsMainPage.add(labelDeleteSupervisor_SupervisorsMainPage);
		/*End of Delete Supervisor  Label SupervisorsMainPage*/
		
		
		/*Delete Supervisor 2 Label SupervisorsMainPage*/
		labelDeleteSupervisor2_SupervisorsMainPage = new JLabel("Supervisor");
		labelDeleteSupervisor2_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteSupervisor2_SupervisorsMainPage.setForeground(Color.BLACK);
		labelDeleteSupervisor2_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteSupervisor2_SupervisorsMainPage.setBounds(10, 88, 160, 35);
		panelDeleteSupervisor_SupervisorsMainPage.add(labelDeleteSupervisor2_SupervisorsMainPage);
		/*End of Delete Supervisor 2 Label SupervisorsMainPage*/
		
		
		/*Supervisors Record Panel SupervisorsMainPage*/
		panelSupervisorsRecord_SupervisorsMainPage = new JPanel();
		panelSupervisorsRecord_SupervisorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Supervisors Record Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsRecordPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelSupervisorsRecord_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelSupervisorsRecord_SupervisorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSupervisorsRecord_SupervisorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelSupervisorsRecord_SupervisorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelSupervisorsRecord_SupervisorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSupervisorsRecord_SupervisorsMainPage.setLayout(null);
		panelSupervisorsRecord_SupervisorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelSupervisorsRecord_SupervisorsMainPage.setBackground(Color.WHITE);
		panelSupervisorsRecord_SupervisorsMainPage.setBounds(386, 275, 180, 167);
		panelCard_SupervisorsMainPage.add(panelSupervisorsRecord_SupervisorsMainPage);
		/*End of Supervisors Record Panel SupervisorsMainPage*/

		
		/*End of Supervisors Record  Label SupervisorsMainPage*/
		labelSupervisorsRecord_SupervisorsMainPage = new JLabel("Supervisors");
		labelSupervisorsRecord_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupervisorsRecord_SupervisorsMainPage.setForeground(Color.BLACK);
		labelSupervisorsRecord_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSupervisorsRecord_SupervisorsMainPage.setBounds(10, 58, 160, 35);
		panelSupervisorsRecord_SupervisorsMainPage.add(labelSupervisorsRecord_SupervisorsMainPage);
		/*End of Supervisors Record  Label SupervisorsMainPage*/
		
		
		/*Supervisors Record 2 Label SupervisorsMainPage*/
		labelSupervisorsRecord2_SupervisorsMainPage = new JLabel("Record");
		labelSupervisorsRecord2_SupervisorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupervisorsRecord2_SupervisorsMainPage.setForeground(Color.BLACK);
		labelSupervisorsRecord2_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelSupervisorsRecord2_SupervisorsMainPage.setBounds(10, 90, 160, 35);
		panelSupervisorsRecord_SupervisorsMainPage.add(labelSupervisorsRecord2_SupervisorsMainPage);
		/*End of Supervisors Record 2 Label SupervisorsMainPage*/

		
		/*Back Button SupervisorsMainPage*/
		backBtn_SupervisorsMainPage = new JButton();
		backBtn_SupervisorsMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Staff Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, StaffMainPagePanel);
				
			}
		});
		backBtn_SupervisorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_SupervisorsMainPage.setText("Back");
		backBtn_SupervisorsMainPage.setForeground(Color.WHITE);
		backBtn_SupervisorsMainPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_SupervisorsMainPage.setFocusable(false);
		backBtn_SupervisorsMainPage.setBackground(new Color(204, 0, 0));
		backBtn_SupervisorsMainPage.setBounds(268, 461, 105, 35);
		panelCard_SupervisorsMainPage.add(backBtn_SupervisorsMainPage);
		/*End of Back Button SupervisorsMainPage*/

		
		/*Supervisors Main Page Title Label SupervisorsMainPage*/
		lblSupervisorsMainPageTitle_SupervisorsMainrPage = new JLabel("Supervisors Main Page");
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setForeground(Color.BLACK);
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setFocusable(false);
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSupervisorsMainPageTitle_SupervisorsMainrPage.setBounds(167, 0, 317, 36);
		panelCard_SupervisorsMainPage.add(lblSupervisorsMainPageTitle_SupervisorsMainrPage);
		/*End of Supervisors Main Page Title Label SupervisorsMainPage*/

		
		/*Receptionists Main page Panel*/
		panelCard_ReceptionistsMainPage = new JPanel();
		panelCard_ReceptionistsMainPage.setLayout(null);
		panelCard_ReceptionistsMainPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_ReceptionistsMainPage, ReceptionistsMainPagePanel);
		/*End of Receptionists Main page Panel*/

		
		/*Add Receptionist Panel ReceptionistsMainPagee*/
		panelAddReceptionist_ReceptionistsMainPage = new JPanel();
		panelAddReceptionist_ReceptionistsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Add Receptionist Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AddReceptionistPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAddReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAddReceptionist_ReceptionistsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelAddReceptionist_ReceptionistsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAddReceptionist_ReceptionistsMainPage.setLayout(null);
		panelAddReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAddReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
		panelAddReceptionist_ReceptionistsMainPage.setBounds(76, 44, 180, 167);
		panelCard_ReceptionistsMainPage.add(panelAddReceptionist_ReceptionistsMainPage);
		/*End of Add Receptionist Panel ReceptionistsMainPagee*/

		
		/*Add Receptionist Label ReceptionistsMainPagee*/
		labelAddReceptionist_ReceptionistsMainPage = new JLabel("Add");
		labelAddReceptionist_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddReceptionist_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelAddReceptionist_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddReceptionist_ReceptionistsMainPage.setBounds(10, 58, 160, 35);
		panelAddReceptionist_ReceptionistsMainPage.add(labelAddReceptionist_ReceptionistsMainPage);
		/*End of Add Receptionist Label ReceptionistsMainPagee*/
		
		
		/*Add Receptionist 2 Label ReceptionistsMainPagee*/
		labelAddReceptinist2_ReceptionistsMainPage = new JLabel("Receptionist");
		labelAddReceptinist2_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddReceptinist2_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelAddReceptinist2_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddReceptinist2_ReceptionistsMainPage.setBounds(10, 91, 160, 35);
		panelAddReceptionist_ReceptionistsMainPage.add(labelAddReceptinist2_ReceptionistsMainPage);
		/*End of Add Receptionist 2 Label ReceptionistsMainPagee*/
		
		
		/*Update Receptionist Panel ReceptionistsMainPagee*/
		panelUpdateReceptionist_ReceptionistsMainPage = new JPanel();
		panelUpdateReceptionist_ReceptionistsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Update Receptionist Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, UpdateReceptionistPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdateReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelUpdateReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdateReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelUpdateReceptionist_ReceptionistsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelUpdateReceptionist_ReceptionistsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUpdateReceptionist_ReceptionistsMainPage.setLayout(null);
		panelUpdateReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelUpdateReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
		panelUpdateReceptionist_ReceptionistsMainPage.setBounds(385, 44, 180, 167);
		panelCard_ReceptionistsMainPage.add(panelUpdateReceptionist_ReceptionistsMainPage);
		/*End of Update Receptionist Panel ReceptionistsMainPagee*/

		
		/*Update Receptionist Label ReceptionistsMainPagee*/
		labelUpdateReceptionist_ReceptionistsMainPage = new JLabel("Update");
		labelUpdateReceptionist_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateReceptionist_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelUpdateReceptionist_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateReceptionist_ReceptionistsMainPage.setBounds(10, 58, 160, 35);
		panelUpdateReceptionist_ReceptionistsMainPage.add(labelUpdateReceptionist_ReceptionistsMainPage);
		/*End of Update Receptionist Label ReceptionistsMainPagee*/
		
		
		/*Update Receptionist 2 Label ReceptionistsMainPagee*/
		labelUpdateReceptionist2_ReceptionistsMainPage = new JLabel("Receptionist");
		labelUpdateReceptionist2_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateReceptionist2_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelUpdateReceptionist2_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateReceptionist2_ReceptionistsMainPage.setBounds(10, 89, 160, 35);
		panelUpdateReceptionist_ReceptionistsMainPage.add(labelUpdateReceptionist2_ReceptionistsMainPage);
		/*End of Update Receptionist 2 Label ReceptionistsMainPagee*/

		
		/*Horizontal Separator ReceptionistsMainPage*/
		separatorHorizontal_ReceptionistsMainPage = new JSeparator();
		separatorHorizontal_ReceptionistsMainPage.setForeground(new Color(216, 191, 216));
		separatorHorizontal_ReceptionistsMainPage.setBorder(null);
		separatorHorizontal_ReceptionistsMainPage.setBackground(new Color(102, 51, 153));
		separatorHorizontal_ReceptionistsMainPage.setBounds(152, 240, 343, 2);
		panelCard_ReceptionistsMainPage.add(separatorHorizontal_ReceptionistsMainPage);
		/*End of Horizontal Separator ReceptionistsMainPage*/
		
		
		/*Vertical Separator ReceptionistsMainPage*/
		separatorVertical_ReceptionistsMainPage = new JSeparator();
		separatorVertical_ReceptionistsMainPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_ReceptionistsMainPage.setForeground(new Color(216, 191, 216));
		separatorVertical_ReceptionistsMainPage.setBorder(null);
		separatorVertical_ReceptionistsMainPage.setBackground(new Color(102, 51, 153));
		separatorVertical_ReceptionistsMainPage.setBounds(320, 77, 2, 343);
		panelCard_ReceptionistsMainPage.add(separatorVertical_ReceptionistsMainPage);
		/*End of Vertical Separator ReceptionistsMainPage*/
		
		
		/*Delete Receptionist Panel ReceptionistsMainPagee*/
		panelDeleteReceptionist_ReceptionistsMainPage = new JPanel();
		panelDeleteReceptionist_ReceptionistsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Delete Receptionist Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DeleteReceptionistPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeleteReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDeleteReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeleteReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDeleteReceptionist_ReceptionistsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelDeleteReceptionist_ReceptionistsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDeleteReceptionist_ReceptionistsMainPage.setLayout(null);
		panelDeleteReceptionist_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDeleteReceptionist_ReceptionistsMainPage.setBackground(Color.WHITE);
		panelDeleteReceptionist_ReceptionistsMainPage.setBounds(76, 275, 180, 167);
		panelCard_ReceptionistsMainPage.add(panelDeleteReceptionist_ReceptionistsMainPage);
		/*End of Delete Receptionist Panel ReceptionistsMainPagee*/

		
		/*Delete Receptionist Label ReceptionistsMainPagee*/
		labelDeleteReceptionist_ReceptionistsMainPage = new JLabel("Delete");
		labelDeleteReceptionist_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteReceptionist_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelDeleteReceptionist_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteReceptionist_ReceptionistsMainPage.setBounds(10, 58, 160, 35);
		panelDeleteReceptionist_ReceptionistsMainPage.add(labelDeleteReceptionist_ReceptionistsMainPage);
		/*End of Delete Receptionist Label ReceptionistsMainPagee*/
		
		
		/*Delete Receptionist 2 Label ReceptionistsMainPagee*/
		labelDeleteReceptionist2_ReceptionistsMainPage = new JLabel("Receptionist");
		labelDeleteReceptionist2_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteReceptionist2_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelDeleteReceptionist2_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteReceptionist2_ReceptionistsMainPage.setBounds(10, 88, 160, 35);
		panelDeleteReceptionist_ReceptionistsMainPage.add(labelDeleteReceptionist2_ReceptionistsMainPage);
		/*End of Delete Receptionist 2 Label ReceptionistsMainPagee*/
		
		
		/*Receptionists Record Panel ReceptionistsMainPagee*/
		panelReceptionistsRecord_ReceptionistsMainPage = new JPanel();
		panelReceptionistsRecord_ReceptionistsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Receptionists Record Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsRecordPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelReceptionistsRecord_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelReceptionistsRecord_ReceptionistsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelReceptionistsRecord_ReceptionistsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelReceptionistsRecord_ReceptionistsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelReceptionistsRecord_ReceptionistsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelReceptionistsRecord_ReceptionistsMainPage.setLayout(null);
		panelReceptionistsRecord_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelReceptionistsRecord_ReceptionistsMainPage.setBackground(Color.WHITE);
		panelReceptionistsRecord_ReceptionistsMainPage.setBounds(385, 275, 180, 167);
		panelCard_ReceptionistsMainPage.add(panelReceptionistsRecord_ReceptionistsMainPage);
		/*End of Receptionists Record Panel ReceptionistsMainPagee*/

		
		/*Receptionists Record Label ReceptionistsMainPagee*/
		labelReceptionistsRecord_ReceptionistsMainPage = new JLabel("Receptionists");
		labelReceptionistsRecord_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelReceptionistsRecord_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelReceptionistsRecord_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelReceptionistsRecord_ReceptionistsMainPage.setBounds(10, 58, 160, 35);
		panelReceptionistsRecord_ReceptionistsMainPage.add(labelReceptionistsRecord_ReceptionistsMainPage);
		/*End of Receptionists Record Label ReceptionistsMainPagee*/
		
		
		/*Receptionists Record 2 Label ReceptionistsMainPagee*/
		labelReceptionistsRecord2_ReceptionistsMainPage = new JLabel("Record");
		labelReceptionistsRecord2_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelReceptionistsRecord2_ReceptionistsMainPage.setForeground(Color.BLACK);
		labelReceptionistsRecord2_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelReceptionistsRecord2_ReceptionistsMainPage.setBounds(10, 90, 160, 35);
		panelReceptionistsRecord_ReceptionistsMainPage.add(labelReceptionistsRecord2_ReceptionistsMainPage);
		/*End of Receptionists Record 2 Label ReceptionistsMainPagee*/

		
		
		/*Back Button ReceptionistsMainPage*/
		backBtn_ReceptionistsMainPage = new JButton();
		backBtn_ReceptionistsMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Staff Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, StaffMainPagePanel);
			}
		});
		backBtn_ReceptionistsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_ReceptionistsMainPage.setText("Back");
		backBtn_ReceptionistsMainPage.setForeground(Color.WHITE);
		backBtn_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_ReceptionistsMainPage.setFocusable(false);
		backBtn_ReceptionistsMainPage.setBackground(new Color(204, 0, 0));
		backBtn_ReceptionistsMainPage.setBounds(267, 461, 105, 35);
		panelCard_ReceptionistsMainPage.add(backBtn_ReceptionistsMainPage);
		/*End of Back Button ReceptionistsMainPage*/

		
		/*Receptionists Main Page Title Label ReceptionistsMainPage*/
		lblReceptionistsMainPageTitle_ReceptionistsMainPage = new JLabel("Receptionists Main Page");
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setForeground(Color.BLACK);
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setFocusable(false);
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblReceptionistsMainPageTitle_ReceptionistsMainPage.setBounds(167, 0, 317, 36);
		panelCard_ReceptionistsMainPage.add(lblReceptionistsMainPageTitle_ReceptionistsMainPage);
		/*End of Receptionists Main Page Title Label ReceptionistsMainPage*/
		
		
		/*Doctors Main Page Panel*/
		panelCard_DoctorsMainPage = new JPanel();
		panelCard_DoctorsMainPage.setLayout(null);
		panelCard_DoctorsMainPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_DoctorsMainPage, DoctorsMainPagePanel);
		/*End of Doctors Main Page Panel*/
		
		
		/*Add Doctor Panel DoctorsMainPage*/
		panelAddDoctor_DoctorsMainPage = new JPanel();
		panelAddDoctor_DoctorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Add Doctor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, AddDoctorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelAddDoctor_DoctorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelAddDoctor_DoctorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelAddDoctor_DoctorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAddDoctor_DoctorsMainPage.setLayout(null);
		panelAddDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelAddDoctor_DoctorsMainPage.setBackground(Color.WHITE);
		panelAddDoctor_DoctorsMainPage.setBounds(77, 44, 180, 167);
		panelCard_DoctorsMainPage.add(panelAddDoctor_DoctorsMainPage);
		/*End of Add Doctor Panel DoctorsMainPage*/
		
		
		/*Add Doctor Label DoctorsMainPage*/
		labelAddDoctor_DoctorsMainPage = new JLabel("Add");
		labelAddDoctor_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddDoctor_DoctorsMainPage.setForeground(Color.BLACK);
		labelAddDoctor_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddDoctor_DoctorsMainPage.setBounds(10, 58, 160, 35);
		panelAddDoctor_DoctorsMainPage.add(labelAddDoctor_DoctorsMainPage);
		/*End of Add Doctor Label DoctorsMainPage*/

		
		/*Add Doctor 2 Label DoctorsMainPage*/
		labelAddDoctor2_DoctorsMainPage = new JLabel("Doctor");
		labelAddDoctor2_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddDoctor2_DoctorsMainPage.setForeground(Color.BLACK);
		labelAddDoctor2_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelAddDoctor2_DoctorsMainPage.setBounds(10, 91, 160, 35);
		panelAddDoctor_DoctorsMainPage.add(labelAddDoctor2_DoctorsMainPage);
		/*End of Add Doctor 2 Label DoctorsMainPage*/
		
		
		/*Update Doctor Panel DoctorsMainPage*/
		panelUpdateDoctor_DoctorsMainPage = new JPanel();
		panelUpdateDoctor_DoctorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Update Doctor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, UpdateDoctorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdateDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelUpdateDoctor_DoctorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdateDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelUpdateDoctor_DoctorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelUpdateDoctor_DoctorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUpdateDoctor_DoctorsMainPage.setLayout(null);
		panelUpdateDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelUpdateDoctor_DoctorsMainPage.setBackground(Color.WHITE);
		panelUpdateDoctor_DoctorsMainPage.setBounds(386, 44, 180, 167);
		panelCard_DoctorsMainPage.add(panelUpdateDoctor_DoctorsMainPage);
		/*End of Update Doctor Panel DoctorsMainPage*/
		
		
		/*Update Doctor Label DoctorsMainPage*/
		labelUpdateDoctor_DoctorsMainPage = new JLabel("Update");
		labelUpdateDoctor_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateDoctor_DoctorsMainPage.setForeground(Color.BLACK);
		labelUpdateDoctor_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateDoctor_DoctorsMainPage.setBounds(10, 58, 160, 35);
		panelUpdateDoctor_DoctorsMainPage.add(labelUpdateDoctor_DoctorsMainPage);
		/*End of Update Doctor Label DoctorsMainPage*/
		
		
		/*Update Doctor 2 Label DoctorsMainPage*/
		labelUpdateDoctor2_DoctorsMainPage = new JLabel("Doctor");
		labelUpdateDoctor2_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelUpdateDoctor2_DoctorsMainPage.setForeground(Color.BLACK);
		labelUpdateDoctor2_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelUpdateDoctor2_DoctorsMainPage.setBounds(10, 89, 160, 35);
		panelUpdateDoctor_DoctorsMainPage.add(labelUpdateDoctor2_DoctorsMainPage);
		/*End of Update Doctor 2 Label DoctorsMainPage*/

		
		/*Horizontal Separator DoctorsMainPage*/
		separatorHorizontal_DoctorsMainPage = new JSeparator();
		separatorHorizontal_DoctorsMainPage.setForeground(new Color(216, 191, 216));
		separatorHorizontal_DoctorsMainPage.setBorder(null);
		separatorHorizontal_DoctorsMainPage.setBackground(new Color(102, 51, 153));
		separatorHorizontal_DoctorsMainPage.setBounds(153, 240, 343, 2);
		panelCard_DoctorsMainPage.add(separatorHorizontal_DoctorsMainPage);
		/*End of Horizontal Separator DoctorsMainPage*/

		
		/*Vertical Separator DoctorsMainPage*/
		separatorVertical_DoctorsMainPage = new JSeparator();
		separatorVertical_DoctorsMainPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_DoctorsMainPage.setForeground(new Color(216, 191, 216));
		separatorVertical_DoctorsMainPage.setBorder(null);
		separatorVertical_DoctorsMainPage.setBackground(new Color(102, 51, 153));
		separatorVertical_DoctorsMainPage.setBounds(321, 77, 2, 343);
		panelCard_DoctorsMainPage.add(separatorVertical_DoctorsMainPage);
		/*End of Vertical Separator DoctorsMainPage*/
		
		
		/*Delete Doctor Panel DoctorsMainPage*/
		panelDeleteDoctor_DoctorsMainPage = new JPanel();
		panelDeleteDoctor_DoctorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Delete Doctor Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DeleteDoctorPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeleteDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDeleteDoctor_DoctorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeleteDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDeleteDoctor_DoctorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelDeleteDoctor_DoctorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDeleteDoctor_DoctorsMainPage.setLayout(null);
		panelDeleteDoctor_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDeleteDoctor_DoctorsMainPage.setBackground(Color.WHITE);
		panelDeleteDoctor_DoctorsMainPage.setBounds(77, 275, 180, 167);
		panelCard_DoctorsMainPage.add(panelDeleteDoctor_DoctorsMainPage);
		/*End of Delete Doctor Panel DoctorsMainPage*/

		
		/*Delete Doctor Label DoctorsMainPage*/
		labelDeleteDoctor_DoctorsMainPage = new JLabel("Delete");
		labelDeleteDoctor_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteDoctor_DoctorsMainPage.setForeground(Color.BLACK);
		labelDeleteDoctor_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteDoctor_DoctorsMainPage.setBounds(10, 58, 160, 35);
		panelDeleteDoctor_DoctorsMainPage.add(labelDeleteDoctor_DoctorsMainPage);
		/*End of Delete Doctor Label DoctorsMainPage*/
		
		
		/*Delete Doctor 2 Label DoctorsMainPage*/
		labelDeleteDoctor2_DoctorsMainPage = new JLabel("Doctor");
		labelDeleteDoctor2_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteDoctor2_DoctorsMainPage.setForeground(Color.BLACK);
		labelDeleteDoctor2_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDeleteDoctor2_DoctorsMainPage.setBounds(10, 88, 160, 35);
		panelDeleteDoctor_DoctorsMainPage.add(labelDeleteDoctor2_DoctorsMainPage);
		/*End of Delete Doctor 2 Label DoctorsMainPage*/
		
		
		/*Doctors Record Panel DoctorsMainPage*/
		panelDoctorsRecord_DoctorsMainPage = new JPanel();
		panelDoctorsRecord_DoctorsMainPage.addMouseListener(new MouseAdapter() {
			
			/*
			 * Show Doctors Record Page Panel card when mouse clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsRecordPagePanel);
			}
			
			/*
			 * Change Panel Color When Mouse Exited Panel
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				panelDoctorsRecord_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
				panelDoctorsRecord_DoctorsMainPage.setBackground(Color.WHITE);
			}
			
			/*
			 * Change Panel Color When Mouse Entered Panel
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDoctorsRecord_DoctorsMainPage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panelDoctorsRecord_DoctorsMainPage.setBackground(new Color(216, 191, 216));
			}
		});
		panelDoctorsRecord_DoctorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDoctorsRecord_DoctorsMainPage.setLayout(null);
		panelDoctorsRecord_DoctorsMainPage.setBorder(new LineBorder(new Color(102, 51, 153), 1, true));
		panelDoctorsRecord_DoctorsMainPage.setBackground(Color.WHITE);
		panelDoctorsRecord_DoctorsMainPage.setBounds(386, 275, 180, 167);
		panelCard_DoctorsMainPage.add(panelDoctorsRecord_DoctorsMainPage);
		/*End of Doctors Record Panel DoctorsMainPage*/

		
		/*Doctors Record Label DoctorsMainPage*/
		labelDoctorsRecord_DoctorsMainPage = new JLabel("Doctors");
		labelDoctorsRecord_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDoctorsRecord_DoctorsMainPage.setForeground(Color.BLACK);
		labelDoctorsRecord_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDoctorsRecord_DoctorsMainPage.setBounds(10, 58, 160, 35);
		panelDoctorsRecord_DoctorsMainPage.add(labelDoctorsRecord_DoctorsMainPage);
		/*End of Doctors Record Label DoctorsMainPage*/
		
		
		/*Doctors Record 2 Label DoctorsMainPage*/
		labelDoctorsRecord2_DoctorsMainPage = new JLabel("Record");
		labelDoctorsRecord2_DoctorsMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDoctorsRecord2_DoctorsMainPage.setForeground(Color.BLACK);
		labelDoctorsRecord2_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 20));
		labelDoctorsRecord2_DoctorsMainPage.setBounds(10, 90, 160, 35);
		panelDoctorsRecord_DoctorsMainPage.add(labelDoctorsRecord2_DoctorsMainPage);
		/*End of Doctors Record 2 Label DoctorsMainPage*/

		
		/*Back Button DoctorsMainPage*/
		backBtn_DoctorsMainPage = new JButton();
		backBtn_DoctorsMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_DoctorsMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Staff Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, StaffMainPagePanel);
			}
		});
		backBtn_DoctorsMainPage.setText("Back");
		backBtn_DoctorsMainPage.setForeground(Color.WHITE);
		backBtn_DoctorsMainPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_DoctorsMainPage.setFocusable(false);
		backBtn_DoctorsMainPage.setBackground(new Color(204, 0, 0));
		backBtn_DoctorsMainPage.setBounds(268, 461, 105, 35);
		panelCard_DoctorsMainPage.add(backBtn_DoctorsMainPage);
		/*End of Back Button DoctorsMainPage*/

		
		/*Doctors Main Page Title Label DoctorsMainPage*/
		lblDoctorsMainPageTitle_DoctorsMainrPage = new JLabel("Doctors Main Page");
		lblDoctorsMainPageTitle_DoctorsMainrPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorsMainPageTitle_DoctorsMainrPage.setForeground(Color.BLACK);
		lblDoctorsMainPageTitle_DoctorsMainrPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorsMainPageTitle_DoctorsMainrPage.setFocusable(false);
		lblDoctorsMainPageTitle_DoctorsMainrPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDoctorsMainPageTitle_DoctorsMainrPage.setBounds(167, 0, 317, 36);
		panelCard_DoctorsMainPage.add(lblDoctorsMainPageTitle_DoctorsMainrPage);
		/*End of Doctors Main Page Title Label DoctorsMainPage*/

		
		/*Add Supervisor Page Panel*/
		panelCard_AddSupervisorPage = new JPanel();
		panelCard_AddSupervisorPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				//New Supervisor ID
				RandomSupervisorID();
			}
		});
		panelCard_AddSupervisorPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_AddSupervisorPage, AddSupervisorPagePanel);
		panelCard_AddSupervisorPage.setLayout(null);
		/*End of Add Supervisor Page Panel*/

		
		/*Supervisor ID Label AddSupervisorPage*/
		lblSupervisorID_AddSupervisorPage = new JLabel("Supervisor ID");
		lblSupervisorID_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorID_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorID_AddSupervisorPage.setFocusable(false);
		lblSupervisorID_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID_AddSupervisorPage.setBounds(10, 61, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorID_AddSupervisorPage);
		/*End of Supervisor ID Label AddSupervisorPage*/
		
		
		/*Supervisor ID 2 Label AddSupervisorPage*/
		lblSupervisorID2_AddSupervisorPage = new JLabel("");
		lblSupervisorID2_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblSupervisorID2_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID2_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblSupervisorID2_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID2_AddSupervisorPage.setBackground(new Color(102, 51, 153));
		lblSupervisorID2_AddSupervisorPage.setBounds(168, 61, 91, 37);
		panelCard_AddSupervisorPage.add(lblSupervisorID2_AddSupervisorPage);
		/*End of Supervisor ID 2 Label AddSupervisorPage*/

		
		/*New Supervisor ID Button AddSupervisorPage*/
		BtnNewSupervisorID_AddSupervisorPage = new JButton();
		BtnNewSupervisorID_AddSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//New Supervisor ID
				RandomSupervisorID();
			}
		});
		BtnNewSupervisorID_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewSupervisorID_AddSupervisorPage.setText("New ID");
		BtnNewSupervisorID_AddSupervisorPage.setForeground(Color.WHITE);
		BtnNewSupervisorID_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewSupervisorID_AddSupervisorPage.setFocusable(false);
		BtnNewSupervisorID_AddSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnNewSupervisorID_AddSupervisorPage.setBounds(261, 61, 78, 35);
		panelCard_AddSupervisorPage.add(BtnNewSupervisorID_AddSupervisorPage);
		/*End of New Supervisor ID Button AddSupervisorPage*/
		
		
		/*Supervisor Name Label AddSupervisorPage*/
		lblSupervisorName_AddSupervisorPage = new JLabel("Name");
		lblSupervisorName_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorName_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_AddSupervisorPage.setFocusable(false);
		lblSupervisorName_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_AddSupervisorPage.setBounds(10, 108, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorName_AddSupervisorPage);
		/*End of Supervisor Name Label AddSupervisorPage*/

		
		/*Supervisor Name textFiled AddSupervisorPage*/
		textFieldSupervisorName_AddSupervisorPage = new JTextField();
		textFieldSupervisorName_AddSupervisorPage.setToolTipText("Name");
		textFieldSupervisorName_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorName_AddSupervisorPage.setColumns(10);
		textFieldSupervisorName_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_AddSupervisorPage.setBounds(168, 109, 148, 36);
		panelCard_AddSupervisorPage.add(textFieldSupervisorName_AddSupervisorPage);
		/*End of Supervisor Name textFiled AddSupervisorPage*/
		
		
		/*Supervisor Phone NO Label AddSupervisorPage*/
		lblSupervisorPhoneNO_AddSupervisorPage = new JLabel("Phone NO.");
		lblSupervisorPhoneNO_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPhoneNO_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPhoneNO_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPhoneNO_AddSupervisorPage.setFocusable(false);
		lblSupervisorPhoneNO_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPhoneNO_AddSupervisorPage.setBounds(10, 202, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorPhoneNO_AddSupervisorPage);
		/*End of Supervisor Phone NO Label AddSupervisorPage*/

		
		/*Supervisor Phone NO textFiled AddSupervisorPage*/
		textFieldSupervisorPhoneNO_AddSupervisorPage = new JTextField();
		textFieldSupervisorPhoneNO_AddSupervisorPage.setToolTipText("Phone NO.");
		textFieldSupervisorPhoneNO_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorPhoneNO_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorPhoneNO_AddSupervisorPage.setColumns(10);
		textFieldSupervisorPhoneNO_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorPhoneNO_AddSupervisorPage.setBounds(168, 202, 148, 36);
		panelCard_AddSupervisorPage.add(textFieldSupervisorPhoneNO_AddSupervisorPage);
		/*End of Supervisor Phone NO textFiled AddSupervisorPage*/
		
		
		/*Supervisor Address Label AddSupervisorPage*/
		lblSupervisorAddress_AddSupervisorPage = new JLabel("Address");
		lblSupervisorAddress_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorAddress_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorAddress_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorAddress_AddSupervisorPage.setFocusable(false);
		lblSupervisorAddress_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorAddress_AddSupervisorPage.setBounds(10, 253, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorAddress_AddSupervisorPage);
		/*End of Supervisor Address Label AddSupervisorPage*/

		
		/*Supervisor Address textFiled AddSupervisorPage*/
		textFieldSupervisorAddress_AddSupervisorPage = new JTextField();
		textFieldSupervisorAddress_AddSupervisorPage.setToolTipText("Address");
		textFieldSupervisorAddress_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorAddress_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorAddress_AddSupervisorPage.setColumns(10);
		textFieldSupervisorAddress_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorAddress_AddSupervisorPage.setBounds(168, 253, 148, 36);
		panelCard_AddSupervisorPage.add(textFieldSupervisorAddress_AddSupervisorPage);
		/*End of Supervisor Address textFiled AddSupervisorPage*/
		
		
		/*Supervisor Gender Label AddSupervisorPage*/
		lblSupervisorGender_AddSupervisorPage = new JLabel("Gender");
		lblSupervisorGender_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorGender_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorGender_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorGender_AddSupervisorPage.setFocusable(false);
		lblSupervisorGender_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorGender_AddSupervisorPage.setBounds(10, 300, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorGender_AddSupervisorPage);
		/*End of Supervisor Gender Label AddSupervisorPage*/

		
		/*Supervisor Gender comboBox AddSupervisorPage*/
		comboBoxGender_AddSupervisorPage = new JComboBox();
		comboBoxGender_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_AddSupervisorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_AddSupervisorPage.setToolTipText("Gender");
		comboBoxGender_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_AddSupervisorPage.setFocusable(false);
		comboBoxGender_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_AddSupervisorPage.setBackground(Color.WHITE);
		comboBoxGender_AddSupervisorPage.setBounds(168, 300, 148, 36);
		panelCard_AddSupervisorPage.add(comboBoxGender_AddSupervisorPage);
		/*End of Supervisor Gender comboBox AddSupervisorPage*/
		
		
		/*Supervisor Date Of Birth Label AddSupervisorPage*/
		lblSupervisorDateOfBirth_AddSupervisorPage = new JLabel("Date Of Birth");
		lblSupervisorDateOfBirth_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorDateOfBirth_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorDateOfBirth_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorDateOfBirth_AddSupervisorPage.setFocusable(false);
		lblSupervisorDateOfBirth_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorDateOfBirth_AddSupervisorPage.setBounds(10, 347, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorDateOfBirth_AddSupervisorPage);
		/*End of Supervisor Date Of Birth Label AddSupervisorPage*/

		
		/*Supervisor Date Of Birth JDateChooser AddSupervisorPage*/
		SupervisorDateOfBirth_AddSupervisorPage = new JDateChooser();
		SupervisorDateOfBirth_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SupervisorDateOfBirth_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		SupervisorDateOfBirth_AddSupervisorPage.setBounds(168, 347, 148, 36);
		panelCard_AddSupervisorPage.add(SupervisorDateOfBirth_AddSupervisorPage);
		/*End of Supervisor Date Of Birth JDateChooser AddSupervisorPage*/

		
		/*Back Button AddSupervisorPage*/
		backBtn_AddSupervisorPage = new JButton();
		backBtn_AddSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Supervisor Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsMainPagePanel);
				
				//Clear Fields
				clearButtonAddSupervisorPage();
				
				//Set Show Password Button to Show
				BtnShowPassword_AddSupervisorPage.setText("Show");
			}
		});
		backBtn_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_AddSupervisorPage.setText("Back");
		backBtn_AddSupervisorPage.setForeground(Color.WHITE);
		backBtn_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_AddSupervisorPage.setFocusable(false);
		backBtn_AddSupervisorPage.setBackground(new Color(204, 0, 0));
		backBtn_AddSupervisorPage.setBounds(150, 450, 105, 35);
		panelCard_AddSupervisorPage.add(backBtn_AddSupervisorPage);
		/*End of Back Button AddSupervisorPage*/

		
		/*Clear Fields Button AddSupervisorPage*/
		BtnClearFields_AddSupervisorPage = new JButton();
		BtnClearFields_AddSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonAddSupervisorPage();
				//New Supervisor ID
				RandomSupervisorID();
			}
		});
		BtnClearFields_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_AddSupervisorPage.setText("Clear");
		BtnClearFields_AddSupervisorPage.setForeground(Color.WHITE);
		BtnClearFields_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_AddSupervisorPage.setFocusable(false);
		BtnClearFields_AddSupervisorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_AddSupervisorPage.setBounds(265, 450, 105, 35);
		panelCard_AddSupervisorPage.add(BtnClearFields_AddSupervisorPage);
		/*End of Clear Fields Button AddSupervisorPage*/

		
		/*Add Supervisor Button AddSupervisorPage*/
		BtnAddSupervisor_AddSupervisorPage = new JButton();
		BtnAddSupervisor_AddSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Add New Supervisor
				 */
				
				
				//check if there any empty spaces
				if(lblSupervisorID2_AddSupervisorPage.getText().isEmpty() || textFieldSupervisorName_AddSupervisorPage.getText().isEmpty() ||
				   textFieldSupervisorLastName_AddSupervisorPage.getText().isEmpty() || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().isEmpty() ||		
				   textFieldSupervisorUsername_AddSupervisorPage.getText().isEmpty() || textFieldSupervisorAddress_AddSupervisorPage.getText().isEmpty() ||
				   comboBoxGender_AddSupervisorPage.getSelectedIndex()==0 || SupervisorDateOfBirth_AddSupervisorPage.getDate()==null ||
				   passwordFieldPassword_AddSupervisorPage.getText().isEmpty() || passwordFieldRePassword_AddSupervisorPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no numbers Entered in Name and Last Name Fields
					if(textFieldSupervisorName_AddSupervisorPage.getText().contains("0") || textFieldSupervisorName_AddSupervisorPage.getText().contains("1") ||
					   textFieldSupervisorName_AddSupervisorPage.getText().contains("2") || textFieldSupervisorName_AddSupervisorPage.getText().contains("3") ||
					   textFieldSupervisorName_AddSupervisorPage.getText().contains("4") || textFieldSupervisorName_AddSupervisorPage.getText().contains("5") ||
					   textFieldSupervisorName_AddSupervisorPage.getText().contains("6") || textFieldSupervisorName_AddSupervisorPage.getText().contains("7") ||
					   textFieldSupervisorName_AddSupervisorPage.getText().contains("8") || textFieldSupervisorName_AddSupervisorPage.getText().contains("9") ||
					   textFieldSupervisorLastName_AddSupervisorPage.getText().contains("0") || textFieldSupervisorLastName_AddSupervisorPage.getText().contains("1") ||
					   textFieldSupervisorLastName_AddSupervisorPage.getText().contains("2") || textFieldSupervisorLastName_AddSupervisorPage.getText().contains("3") ||
					   textFieldSupervisorLastName_AddSupervisorPage.getText().contains("4") || textFieldSupervisorLastName_AddSupervisorPage.getText().contains("5") ||
					   textFieldSupervisorLastName_AddSupervisorPage.getText().contains("6") || textFieldSupervisorLastName_AddSupervisorPage.getText().contains("7") ||
					   textFieldSupervisorLastName_AddSupervisorPage.getText().contains("8") || textFieldSupervisorLastName_AddSupervisorPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name fields"); }
					
					//else continue after "check no numbers Entered in Name and Last Name  Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("a") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("b") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("c") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("d") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("e") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("f") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("g") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("h") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("i") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("j") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("k") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("l") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("m") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("n") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("o") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("p") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("q") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("r") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("s") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("t") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("u") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("v") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("w") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("x") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("y") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("z") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("A") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("B") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("C") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("D") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("E") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("F") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("G") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("H") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("I") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("J") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("K") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("L") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("M") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("N") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("O") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("P") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("Q") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("R") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("S") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("T") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("U") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("V") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("W") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("X") ||
								   textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("Y") || textFieldSupervisorPhoneNO_AddSupervisorPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
							// check passwords match
							if(!passwordFieldPassword_AddSupervisorPage.getText().equals(passwordFieldRePassword_AddSupervisorPage.getText()))
							{
								JOptionPane.showMessageDialog(null, "Passwords Dont Match!!");
							}
							
							//else continue after "check passwords match"
							else
							{	
								
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
							String DofB              = dFormat.format(SupervisorDateOfBirth_AddSupervisorPage.getDate());
							// End date to string

							// text to integer
							int PhoneNO = Integer.parseInt(textFieldSupervisorPhoneNO_AddSupervisorPage.getText()); 
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "UsersDTO" object
							UsersDTO usersDTO = new UsersDTO(); 
							usersDTO.setUserID(lblSupervisorID2_AddSupervisorPage.getText());
							usersDTO.setName(textFieldSupervisorName_AddSupervisorPage.getText());
							usersDTO.setLast_Name(textFieldSupervisorLastName_AddSupervisorPage.getText());
							usersDTO.setPhone_Number(PhoneNO);
							usersDTO.setAddress(textFieldSupervisorAddress_AddSupervisorPage.getText());
							usersDTO.setGender((String) comboBoxGender_AddSupervisorPage.getSelectedItem());
							usersDTO.setDate_Of_Birth(DofB);
							usersDTO.setUsername(textFieldSupervisorUsername_AddSupervisorPage.getText());
							usersDTO.setPassword(passwordFieldPassword_AddSupervisorPage.getText());
							usersDTO.setUser_Type("Supervisor");
							usersDTO.setAdded_By_Supervisor(supervisorName);
							usersDTO.setAdded_Date(tDate.format(timer.getTime()));
							usersDTO.setAdded_Time(tTime.format(timer.getTime()));
							// End of Set data to "UsersDTO" object

							// Send data to "addSupervisorDAO" method
							new SupervisorsDAO().addSupervisorDAO(usersDTO);
							// End of Send data to "addSupervisorDAO" method

							}
						}  
					}		
				}
			
			}
		});
		BtnAddSupervisor_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnAddSupervisor_AddSupervisorPage.setText("Add");
		BtnAddSupervisor_AddSupervisorPage.setForeground(Color.WHITE);
		BtnAddSupervisor_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnAddSupervisor_AddSupervisorPage.setFocusable(false);
		BtnAddSupervisor_AddSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnAddSupervisor_AddSupervisorPage.setBounds(380, 450, 105, 35);
		panelCard_AddSupervisorPage.add(BtnAddSupervisor_AddSupervisorPage);
		/*End of Add Supervisor Button AddSupervisorPage*/
		
		
		/*Supervisor Last Name Label AddSupervisorPage*/
		lblSupervisorLastName_AddSupervisorPage = new JLabel("Last Name");
		lblSupervisorLastName_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorLastName_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorLastName_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorLastName_AddSupervisorPage.setFocusable(false);
		lblSupervisorLastName_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorLastName_AddSupervisorPage.setBounds(10, 155, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorLastName_AddSupervisorPage);
		/*End of Supervisor Last Name Label AddSupervisorPage*/

		
		/*Supervisor Last Name textFiled AddSupervisorPage*/
		textFieldSupervisorLastName_AddSupervisorPage = new JTextField();
		textFieldSupervisorLastName_AddSupervisorPage.setToolTipText("Last Name");
		textFieldSupervisorLastName_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorLastName_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorLastName_AddSupervisorPage.setColumns(10);
		textFieldSupervisorLastName_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorLastName_AddSupervisorPage.setBounds(168, 156, 148, 36);
		panelCard_AddSupervisorPage.add(textFieldSupervisorLastName_AddSupervisorPage);
		/*End of Supervisor Last Name textFiled AddSupervisorPage*/
		
		
		/*Supervisor Username Label AddSupervisorPage*/
		lblSupervisorUsername_AddSupervisorPage = new JLabel("Username");
		lblSupervisorUsername_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorUsername_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorUsername_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorUsername_AddSupervisorPage.setFocusable(false);
		lblSupervisorUsername_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorUsername_AddSupervisorPage.setBounds(334, 107, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorUsername_AddSupervisorPage);
		/*End of Supervisor Username Label AddSupervisorPage*/

		
		/*Supervisor Username textFiled AddSupervisorPage*/
		textFieldSupervisorUsername_AddSupervisorPage = new JTextField();
		textFieldSupervisorUsername_AddSupervisorPage.setToolTipText("Username");
		textFieldSupervisorUsername_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorUsername_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorUsername_AddSupervisorPage.setColumns(10);
		textFieldSupervisorUsername_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorUsername_AddSupervisorPage.setBounds(492, 108, 148, 36);
		panelCard_AddSupervisorPage.add(textFieldSupervisorUsername_AddSupervisorPage);
		/*End of Supervisor Username textFiled AddSupervisorPage*/
		
		
		/*Supervisor Password Label AddSupervisorPage*/
		lblSupervisorPassword_AddSupervisorPage = new JLabel("Password");
		lblSupervisorPassword_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPassword_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPassword_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPassword_AddSupervisorPage.setFocusable(false);
		lblSupervisorPassword_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPassword_AddSupervisorPage.setBounds(334, 154, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorPassword_AddSupervisorPage);
		/*End of Supervisor Password Label AddSupervisorPage*/

		
		/*Supervisor Re-Password Label AddSupervisorPage*/
		lblSupervisorRePassword_AddSupervisorPage = new JLabel("Re-Password");
		lblSupervisorRePassword_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorRePassword_AddSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorRePassword_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorRePassword_AddSupervisorPage.setFocusable(false);
		lblSupervisorRePassword_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorRePassword_AddSupervisorPage.setBounds(334, 205, 148, 36);
		panelCard_AddSupervisorPage.add(lblSupervisorRePassword_AddSupervisorPage);
		/*End of Supervisor Re-Password Label AddSupervisorPage*/

		
		/*Vertical JSeparator AddSupervisorPage*/
		separatorVertical_AddSupervisorPage = new JSeparator();
		separatorVertical_AddSupervisorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_AddSupervisorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_AddSupervisorPage.setBorder(null);
		separatorVertical_AddSupervisorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_AddSupervisorPage.setBounds(324, 100, 2, 300);
		panelCard_AddSupervisorPage.add(separatorVertical_AddSupervisorPage);
		/*End of Vertical JSeparator AddSupervisorPage*/
	
		
		/*Show Password Button AddSupervisorPage*/
		BtnShowPassword_AddSupervisorPage = new JButton();
		BtnShowPassword_AddSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnShowPassword_AddSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Show and hide password
				ShowAndHidePasswordButton_AddSupervisorPage();
			}
		});
		BtnShowPassword_AddSupervisorPage.setText("Show");
		BtnShowPassword_AddSupervisorPage.setForeground(Color.WHITE);
		BtnShowPassword_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnShowPassword_AddSupervisorPage.setFocusable(false);
		BtnShowPassword_AddSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnShowPassword_AddSupervisorPage.setBounds(562, 252, 78, 35);
		panelCard_AddSupervisorPage.add(BtnShowPassword_AddSupervisorPage);
		/*End of Show Password Button AddSupervisorPage*/
		
		
		/*Supervisor Password JPasswordField AddSupervisorPage*/
		passwordFieldPassword_AddSupervisorPage = new JPasswordField();
		passwordFieldPassword_AddSupervisorPage.setToolTipText("Password");
		passwordFieldPassword_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldPassword_AddSupervisorPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldPassword_AddSupervisorPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldPassword_AddSupervisorPage.setBounds(492, 154, 148, 36);
		panelCard_AddSupervisorPage.add(passwordFieldPassword_AddSupervisorPage);
		/*End of Supervisor Password JPasswordField AddSupervisorPage*/

		
		/*Supervisor RePassword JPasswordField AddSupervisorPage*/
		passwordFieldRePassword_AddSupervisorPage = new JPasswordField();
		passwordFieldRePassword_AddSupervisorPage.setToolTipText("Password");
		passwordFieldRePassword_AddSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldRePassword_AddSupervisorPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldRePassword_AddSupervisorPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldRePassword_AddSupervisorPage.setBounds(492, 205, 148, 36);
		panelCard_AddSupervisorPage.add(passwordFieldRePassword_AddSupervisorPage);
		/*End of Supervisor RePassword JPasswordField AddSupervisorPage*/

		
		/*Add Supervisor Title Label AddSupervisorPage*/
		lblAddSupervisorTitle_AddSupervisorPage = new JLabel("Add Supervisor Page");
		lblAddSupervisorTitle_AddSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSupervisorTitle_AddSupervisorPage.setForeground(Color.BLACK);
		lblAddSupervisorTitle_AddSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAddSupervisorTitle_AddSupervisorPage.setFocusable(false);
		lblAddSupervisorTitle_AddSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAddSupervisorTitle_AddSupervisorPage.setBounds(168, 0, 317, 36);
		panelCard_AddSupervisorPage.add(lblAddSupervisorTitle_AddSupervisorPage);
		/*End of Add Supervisor Title Label AddSupervisorPage*/
		
		
		/*Update Supervisor Page Panel*/
		panelCard_UpdateSupervisorPage = new JPanel();
		panelCard_UpdateSupervisorPage.setLayout(null);
		panelCard_UpdateSupervisorPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_UpdateSupervisorPage, UpdateSupervisorPagePanel);
		/*End of Update Supervisor Page Panel*/

		
		/*Supervisor ID Label UpdateSupervisorPage*/
		lblSupervisorID_UpdateSupervisorPage = new JLabel("Supervisor ID");
		lblSupervisorID_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorID_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorID_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorID_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID_UpdateSupervisorPage.setBounds(10, 61, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorID_UpdateSupervisorPage);
		/*End of Supervisor ID Label UpdateSupervisorPage*/

		
		/*Supervisor ID 2 Label UpdateSupervisorPage*/
		lblSupervisorID2_UpdateSupervisorPage = new JLabel("");
		lblSupervisorID2_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblSupervisorID2_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID2_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblSupervisorID2_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID2_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		lblSupervisorID2_UpdateSupervisorPage.setBounds(168, 61, 148, 37);
		panelCard_UpdateSupervisorPage.add(lblSupervisorID2_UpdateSupervisorPage);
		/*End of Supervisor ID 2 Label UpdateSupervisorPage*/

		
		/*Supervisor Name Label UpdateSupervisorPage*/
		lblSupervisorName_UpdateSupervisorPage = new JLabel("Name");
		lblSupervisorName_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorName_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorName_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_UpdateSupervisorPage.setBounds(10, 108, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorName_UpdateSupervisorPage);
		/*End of Supervisor Name Label UpdateSupervisorPage*/

		
		/*Supervisor Name textField UpdateSupervisorPage*/
		textFieldSupervisorName_UpdateSupervisorPage = new JTextField();
		textFieldSupervisorName_UpdateSupervisorPage.setToolTipText("Name");
		textFieldSupervisorName_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorName_UpdateSupervisorPage.setColumns(10);
		textFieldSupervisorName_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_UpdateSupervisorPage.setBounds(168, 109, 148, 36);
		panelCard_UpdateSupervisorPage.add(textFieldSupervisorName_UpdateSupervisorPage);
		/*End of Supervisor Name textField UpdateSupervisorPage*/
		
		
		/*Supervisor Phone NO Label UpdateSupervisorPage*/
		lblSupervisorPhoneNO_UpdateSupervisorPage = new JLabel("Phone NO.");
		lblSupervisorPhoneNO_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPhoneNO_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPhoneNO_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPhoneNO_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorPhoneNO_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPhoneNO_UpdateSupervisorPage.setBounds(10, 202, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorPhoneNO_UpdateSupervisorPage);
		/*End of Supervisor Phone NO Label UpdateSupervisorPage*/

		
		/*Supervisor Phone NO textField UpdateSupervisorPage*/
		textFieldSupervisorPhoneNO_UpdateSupervisorPage = new JTextField();
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setToolTipText("Phone NO.");
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setColumns(10);
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setBounds(168, 202, 148, 36);
		panelCard_UpdateSupervisorPage.add(textFieldSupervisorPhoneNO_UpdateSupervisorPage);
		/*End of Supervisor Phone NO textField UpdateSupervisorPage*/
		
		
		/*Supervisor Address Label UpdateSupervisorPage*/
		lblSupervisorAddress_UpdateSupervisorPage = new JLabel("Address");
		lblSupervisorAddress_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorAddress_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorAddress_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorAddress_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorAddress_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorAddress_UpdateSupervisorPage.setBounds(10, 253, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorAddress_UpdateSupervisorPage);
		/*End of Supervisor Address Label UpdateSupervisorPage*/

		
		/*Supervisor Address textField UpdateSupervisorPage*/
		textFieldSupervisorAddress_UpdateSupervisorPage = new JTextField();
		textFieldSupervisorAddress_UpdateSupervisorPage.setToolTipText("Address");
		textFieldSupervisorAddress_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorAddress_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorAddress_UpdateSupervisorPage.setColumns(10);
		textFieldSupervisorAddress_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorAddress_UpdateSupervisorPage.setBounds(168, 253, 148, 36);
		panelCard_UpdateSupervisorPage.add(textFieldSupervisorAddress_UpdateSupervisorPage);
		/*End of Supervisor Address textField UpdateSupervisorPage*/
		
		
		/*Supervisor Gender Label UpdateSupervisorPage*/
		lblSupervisorGender_UpdateSupervisorPage = new JLabel("Gender");
		lblSupervisorGender_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorGender_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorGender_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorGender_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorGender_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorGender_UpdateSupervisorPage.setBounds(10, 300, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorGender_UpdateSupervisorPage);
		/*End of Supervisor Gender Label UpdateSupervisorPage*/

		
		/*Gender comboBox UpdateSupervisorPage*/
		comboBoxGender_UpdateSupervisorPage = new JComboBox();
		comboBoxGender_UpdateSupervisorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_UpdateSupervisorPage.setToolTipText("Gender");
		comboBoxGender_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_UpdateSupervisorPage.setFocusable(false);
		comboBoxGender_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_UpdateSupervisorPage.setBackground(Color.WHITE);
		comboBoxGender_UpdateSupervisorPage.setBounds(168, 300, 148, 36);
		panelCard_UpdateSupervisorPage.add(comboBoxGender_UpdateSupervisorPage);
		/*End of Gender comboBox UpdateSupervisorPage*/
		
		
		/*Supervisor Date Of Birth Label UpdateSupervisorPage*/
		lblSupervisorDateOfBirth_UpdateSupervisorPage = new JLabel("Date Of Birth");
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorDateOfBirth_UpdateSupervisorPage.setBounds(10, 347, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorDateOfBirth_UpdateSupervisorPage);
		/*End of Supervisor Date Of Birth Label UpdateSupervisorPage*/

		
		/*Supervisor Date Of Birth JDateChooser UpdateSupervisorPage*/
		SupervisorDateOfBirth_UpdateSupervisorPage = new JDateChooser();
		SupervisorDateOfBirth_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SupervisorDateOfBirth_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		SupervisorDateOfBirth_UpdateSupervisorPage.setBounds(168, 347, 148, 36);
		panelCard_UpdateSupervisorPage.add(SupervisorDateOfBirth_UpdateSupervisorPage);
		/*End of Supervisor Date Of Birth JDateChooser UpdateSupervisorPage*/

		
		/*Back Button UpdateSupervisorPage*/
		backBtn_UpdateSupervisorPage = new JButton();
		backBtn_UpdateSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Supervisor Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsMainPagePanel);
				
				//Clear Fields
				clearButtonUpdateSupervisorPage();
				
				//Set Show Password Button to Show
				BtnShowPassword_UpdateSupervisorPage.setText("Show");
			}
		});
		backBtn_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_UpdateSupervisorPage.setText("Back");
		backBtn_UpdateSupervisorPage.setForeground(Color.WHITE);
		backBtn_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_UpdateSupervisorPage.setFocusable(false);
		backBtn_UpdateSupervisorPage.setBackground(new Color(204, 0, 0));
		backBtn_UpdateSupervisorPage.setBounds(150, 450, 105, 35);
		panelCard_UpdateSupervisorPage.add(backBtn_UpdateSupervisorPage);
		/*End of Back Button UpdateSupervisorPage*/

		
		/*Clear Fields Button UpdateSupervisorPage*/
		BtnClearFields_UpdateSupervisorPage = new JButton();
		BtnClearFields_UpdateSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonUpdateSupervisorPage();
			}
		});
		BtnClearFields_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_UpdateSupervisorPage.setText("Clear");
		BtnClearFields_UpdateSupervisorPage.setForeground(Color.WHITE);
		BtnClearFields_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_UpdateSupervisorPage.setFocusable(false);
		BtnClearFields_UpdateSupervisorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_UpdateSupervisorPage.setBounds(265, 450, 105, 35);
		panelCard_UpdateSupervisorPage.add(BtnClearFields_UpdateSupervisorPage);
		/*End of Clear Fields Button UpdateSupervisorPage*/

		
		/*Update Supervisor Button UpdateSupervisorPage*/
		BtnUpdateSupervisor_UpdateSupervisorPage = new JButton();
		BtnUpdateSupervisor_UpdateSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Update Supervisor
				 */
				
				
				//check if there any empty spaces
				if(lblSupervisorID2_UpdateSupervisorPage.getText().isEmpty() || textFieldSupervisorName_UpdateSupervisorPage.getText().isEmpty() || 
				   textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().isEmpty() || textFieldSupervisorAddress_UpdateSupervisorPage.getText().isEmpty() ||
				   comboBoxGender_UpdateSupervisorPage.getSelectedIndex()==0 || SupervisorDateOfBirth_UpdateSupervisorPage.getDate()==null ||
				   textFieldSupervisorLastName_UpdateSupervisorPage.getText().isEmpty() || comboBoxUserType_UpdateSupervisorPage.getSelectedIndex()==0 ||
				   textFieldSupervisorUsername_UpdateSupervisorPage.getText().isEmpty() || passwordFieldSupervisorPassword_UpdateSupervisorPage.getText().isEmpty() ||
				   passwordFieldSupervisorRePassword_UpdateSupervisorPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no number Entered in Name and Last Name Fields
					if(textFieldSupervisorName_UpdateSupervisorPage.getText().contains("0") || textFieldSupervisorName_UpdateSupervisorPage.getText().contains("1") ||
					   textFieldSupervisorName_UpdateSupervisorPage.getText().contains("2") || textFieldSupervisorName_UpdateSupervisorPage.getText().contains("3") ||
					   textFieldSupervisorName_UpdateSupervisorPage.getText().contains("4") || textFieldSupervisorName_UpdateSupervisorPage.getText().contains("5") ||
					   textFieldSupervisorName_UpdateSupervisorPage.getText().contains("6") || textFieldSupervisorName_UpdateSupervisorPage.getText().contains("7") ||
					   textFieldSupervisorName_UpdateSupervisorPage.getText().contains("8") || textFieldSupervisorName_UpdateSupervisorPage.getText().contains("9") ||
					   textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("0") || textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("1") ||
					   textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("2") || textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("3") ||
					   textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("4") || textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("5") ||
					   textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("6") || textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("7") ||
					   textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("8") || textFieldSupervisorLastName_UpdateSupervisorPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name field"); }
					
					//else continue after "check no number Entered in Name and Last Name Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("a") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("b") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("c") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("d") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("e") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("f") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("g") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("h") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("i") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("j") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("k") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("l") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("m") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("n") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("o") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("p") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("q") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("r") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("s") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("t") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("u") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("v") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("w") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("x") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("y") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("z") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("A") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("B") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("C") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("D") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("E") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("F") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("G") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("H") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("I") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("J") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("K") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("L") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("M") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("N") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("O") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("P") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("Q") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("R") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("S") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("T") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("U") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("V") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("W") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("X") ||
								textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("Y") || textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
						
							// check passwords match
							if(!passwordFieldSupervisorPassword_UpdateSupervisorPage.getText().equals(passwordFieldSupervisorRePassword_UpdateSupervisorPage.getText()))
							{
								JOptionPane.showMessageDialog(null, "Passwords Dont Match!!");
							}
							
							//else continue after "check passwords match"
						    else
						    {
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
							String DofB              = dFormat.format(SupervisorDateOfBirth_UpdateSupervisorPage.getDate());
							// End date to string
							
							// text to integer
							int PhoneNO = Integer.parseInt(textFieldSupervisorPhoneNO_UpdateSupervisorPage.getText());   
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "UsersDTO" object
							UsersDTO usersDTO = new UsersDTO(); 
							usersDTO.setUserID(lblSupervisorID2_UpdateSupervisorPage.getText());
							usersDTO.setName(textFieldSupervisorName_UpdateSupervisorPage.getText());
							usersDTO.setLast_Name(textFieldSupervisorLastName_UpdateSupervisorPage.getText());
							usersDTO.setPhone_Number(PhoneNO);
							usersDTO.setAddress(textFieldSupervisorAddress_UpdateSupervisorPage.getText());
							usersDTO.setGender((String) comboBoxGender_UpdateSupervisorPage.getSelectedItem());
							usersDTO.setDate_Of_Birth(DofB);
							usersDTO.setUsername(textFieldSupervisorUsername_UpdateSupervisorPage.getText());
							usersDTO.setPassword(passwordFieldSupervisorPassword_UpdateSupervisorPage.getText());
							usersDTO.setUser_Type((String) comboBoxUserType_UpdateSupervisorPage.getSelectedItem());
							usersDTO.setUpdated_By_Supervisor(supervisorName);
							usersDTO.setLast_Update_Date(tDate.format(timer.getTime()));
							usersDTO.setLast_Update_Time(tTime.format(timer.getTime()));
							// End of Set data to "UsersDTO" object

							// Send data to "updateSupervisorDAO" method
							new SupervisorsDAO().updateSupervisorDAO(usersDTO);
							// End of Send data to "updateSupervisorDAO" method
							
						    }

						} 
					}	
				}
			
			
			}
		});
		BtnUpdateSupervisor_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUpdateSupervisor_UpdateSupervisorPage.setText("Update");
		BtnUpdateSupervisor_UpdateSupervisorPage.setForeground(Color.WHITE);
		BtnUpdateSupervisor_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnUpdateSupervisor_UpdateSupervisorPage.setFocusable(false);
		BtnUpdateSupervisor_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnUpdateSupervisor_UpdateSupervisorPage.setBounds(380, 450, 105, 35);
		panelCard_UpdateSupervisorPage.add(BtnUpdateSupervisor_UpdateSupervisorPage);
		/*End of Update Supervisor Button UpdateSupervisorPage*/
		
		
		/*Supervisor Last Name Label UpdateSupervisorPage*/
		lblSupervisorLastName_UpdateSupervisorPage = new JLabel("Last Name");
		lblSupervisorLastName_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorLastName_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorLastName_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorLastName_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorLastName_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorLastName_UpdateSupervisorPage.setBounds(10, 155, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorLastName_UpdateSupervisorPage);
		/*End of Supervisor Last Name Label UpdateSupervisorPage*/

		
		/*Supervisor Last Name textField UpdateSupervisorPage*/
		textFieldSupervisorLastName_UpdateSupervisorPage = new JTextField();
		textFieldSupervisorLastName_UpdateSupervisorPage.setToolTipText("Last Name");
		textFieldSupervisorLastName_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorLastName_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorLastName_UpdateSupervisorPage.setColumns(10);
		textFieldSupervisorLastName_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorLastName_UpdateSupervisorPage.setBounds(168, 156, 148, 36);
		panelCard_UpdateSupervisorPage.add(textFieldSupervisorLastName_UpdateSupervisorPage);
		/*End of Supervisor Last Name textField UpdateSupervisorPage*/
		
		
		/*Supervisor Username Label UpdateSupervisorPage*/
		lblSupervisorUsername_UpdateSupervisorPage = new JLabel("Username");
		lblSupervisorUsername_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorUsername_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorUsername_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorUsername_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorUsername_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorUsername_UpdateSupervisorPage.setBounds(334, 203, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorUsername_UpdateSupervisorPage);
		/*End of Supervisor Username Label UpdateSupervisorPage*/

		
		/*Supervisor Username textField UpdateSupervisorPage*/
		textFieldSupervisorUsername_UpdateSupervisorPage = new JTextField();
		textFieldSupervisorUsername_UpdateSupervisorPage.setToolTipText("Username");
		textFieldSupervisorUsername_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorUsername_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorUsername_UpdateSupervisorPage.setColumns(10);
		textFieldSupervisorUsername_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorUsername_UpdateSupervisorPage.setBounds(492, 204, 148, 36);
		panelCard_UpdateSupervisorPage.add(textFieldSupervisorUsername_UpdateSupervisorPage);
		/*End of Supervisor Username textField UpdateSupervisorPage*/
		
		
		/*Supervisor Password Label UpdateSupervisorPage*/
		lblSupervisorPassword_UpdateSupervisorPage = new JLabel("Password");
		lblSupervisorPassword_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPassword_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPassword_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPassword_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorPassword_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPassword_UpdateSupervisorPage.setBounds(334, 250, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorPassword_UpdateSupervisorPage);
		/*End of Supervisor Password Label UpdateSupervisorPage*/

		
		/*Supervisor RePassword Label UpdateSupervisorPage*/
		lblSupervisorRePassword_UpdateSupervisorPage = new JLabel("Re-Password");
		lblSupervisorRePassword_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorRePassword_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorRePassword_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorRePassword_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorRePassword_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorRePassword_UpdateSupervisorPage.setBounds(334, 301, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblSupervisorRePassword_UpdateSupervisorPage);
		/*End of Supervisor RePassword Label UpdateSupervisorPage*/

		
		/*separatorVertical JSeparator UpdateSupervisorPage*/
		separatorVertical_UpdateSupervisorPage = new JSeparator();
		separatorVertical_UpdateSupervisorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_UpdateSupervisorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_UpdateSupervisorPage.setBorder(null);
		separatorVertical_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_UpdateSupervisorPage.setBounds(324, 59, 2, 330);
		panelCard_UpdateSupervisorPage.add(separatorVertical_UpdateSupervisorPage);
		/*End of separatorVertical JSeparator UpdateSupervisorPage*/
		
		
		/*Show Password Button UpdateSupervisorPage*/
		BtnShowPassword_UpdateSupervisorPage = new JButton();
		BtnShowPassword_UpdateSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Show and hide password
				ShowAndHidePasswordButton_UpdateSupervisorPage();
			}
		});
		BtnShowPassword_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnShowPassword_UpdateSupervisorPage.setText("Show");
		BtnShowPassword_UpdateSupervisorPage.setForeground(Color.WHITE);
		BtnShowPassword_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnShowPassword_UpdateSupervisorPage.setFocusable(false);
		BtnShowPassword_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnShowPassword_UpdateSupervisorPage.setBounds(562, 348, 78, 35);
		panelCard_UpdateSupervisorPage.add(BtnShowPassword_UpdateSupervisorPage);
		/*End of Show Password Button UpdateSupervisorPage*/
		
		
		/*Supervisor Password JPasswordField UpdateSupervisorPage*/
		passwordFieldSupervisorPassword_UpdateSupervisorPage = new JPasswordField();
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setToolTipText("Password");
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setBounds(492, 250, 148, 36);
		panelCard_UpdateSupervisorPage.add(passwordFieldSupervisorPassword_UpdateSupervisorPage);
		/*End of Supervisor Password JPasswordField UpdateSupervisorPage*/
		
		
		/*Supervisor RePassword JPasswordField UpdateSupervisorPage*/
		passwordFieldSupervisorRePassword_UpdateSupervisorPage = new JPasswordField();
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setToolTipText("Password");
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setBounds(492, 301, 148, 36);
		panelCard_UpdateSupervisorPage.add(passwordFieldSupervisorRePassword_UpdateSupervisorPage);
		/*End of Supervisor RePassword JPasswordField UpdateSupervisorPage*/
		
		
		/*Update Supervisor Title Label UpdateSupervisorPage*/
		lblUpdateSupervisorTitle_UpdateSupervisorPage = new JLabel("Update Supervisor Page");
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setFocusable(false);
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblUpdateSupervisorTitle_UpdateSupervisorPage.setBounds(168, 0, 317, 36);
		panelCard_UpdateSupervisorPage.add(lblUpdateSupervisorTitle_UpdateSupervisorPage);
		/*End of Update Supervisor Title Label UpdateSupervisorPage*/
		
		
		/*Supervisor Search Panel UpdateSupervisorPage*/
		panelSupervisorSearch_UpdateSupervisorPage = new JPanel();
		panelSupervisorSearch_UpdateSupervisorPage.setLayout(null);
		panelSupervisorSearch_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		panelSupervisorSearch_UpdateSupervisorPage.setBounds(333, 61, 307, 127);
		panelCard_UpdateSupervisorPage.add(panelSupervisorSearch_UpdateSupervisorPage);
		/*End of Supervisor Search Panel UpdateSupervisorPage*/

		
		/*Supervisor Search Label UpdateSupervisorPage*/
		lblSupervisorSearch_UpdateSupervisorPage = new JLabel("Search Supervisor");
		lblSupervisorSearch_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorSearch_UpdateSupervisorPage.setForeground(Color.WHITE);
		lblSupervisorSearch_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorSearch_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorSearch_UpdateSupervisorPage.setBorder(null);
		lblSupervisorSearch_UpdateSupervisorPage.setBounds(10, 0, 287, 36);
		panelSupervisorSearch_UpdateSupervisorPage.add(lblSupervisorSearch_UpdateSupervisorPage);
		/*End of Supervisor Search Label UpdateSupervisorPage*/
		
		
		/*Search Button UpdateSupervisorPage*/
		btnSearch_UpdateSupervisorPage = new JButton();
		btnSearch_UpdateSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				/*
				 *     Search Supervisor
				 */
				
								
				//check if enter Supervisor ID field is empty 
				if(textFieldEnterSupervisorID_UpdateSupervisorPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Supervisor ID"); }
				
				// else continue after "check if enter Supervisor ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
			    		preparedstatement.setString(1, textFieldEnterSupervisorID_UpdateSupervisorPage.getText());
			    		preparedstatement.setString(2, "Supervisor");
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Supervisor ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								SupervisorDateOfBirth_UpdateSupervisorPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblSupervisorID2_UpdateSupervisorPage.setText(resultset.getString(2));
							textFieldSupervisorName_UpdateSupervisorPage.setText(resultset.getString(3));
							textFieldSupervisorLastName_UpdateSupervisorPage.setText(resultset.getString(4));
							textFieldSupervisorPhoneNO_UpdateSupervisorPage.setText(phoneNO);
							textFieldSupervisorAddress_UpdateSupervisorPage.setText(resultset.getString(8));
							comboBoxGender_UpdateSupervisorPage.setSelectedItem(resultset.getString(5));
							textFieldSupervisorUsername_UpdateSupervisorPage.setText(resultset.getString(9));
							passwordFieldSupervisorPassword_UpdateSupervisorPage.setText(resultset.getString(10));
							passwordFieldSupervisorRePassword_UpdateSupervisorPage.setText(resultset.getString(10));
							comboBoxUserType_UpdateSupervisorPage.setSelectedItem(resultset.getString(11));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Supervisor ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Supervisor ID not exist, please enter the right Supervisor ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			
			
			}
		});
		btnSearch_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_UpdateSupervisorPage.setText("Search");
		btnSearch_UpdateSupervisorPage.setForeground(Color.WHITE);
		btnSearch_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_UpdateSupervisorPage.setFocusable(false);
		btnSearch_UpdateSupervisorPage.setBackground(new Color(102, 51, 153));
		btnSearch_UpdateSupervisorPage.setBounds(66, 84, 180, 35);
		panelSupervisorSearch_UpdateSupervisorPage.add(btnSearch_UpdateSupervisorPage);
		/*End of Search Button UpdateSupervisorPage*/
		
		
		/*Supervisor Search Enter ID Label UpdateSupervisorPage*/
		lblSupervisorSearchEnterID_UpdateSupervisorPage = new JLabel("Enter Supervisor ID");
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setForeground(Color.WHITE);
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setFocusable(false);
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblSupervisorSearchEnterID_UpdateSupervisorPage.setBounds(10, 37, 164, 36);
		panelSupervisorSearch_UpdateSupervisorPage.add(lblSupervisorSearchEnterID_UpdateSupervisorPage);
		/*End of Supervisor Search Enter ID Label UpdateSupervisorPage*/

		
		/*Enter Supervisor ID textField UpdateSupervisorPage*/
		textFieldEnterSupervisorID_UpdateSupervisorPage = new JTextField();
		textFieldEnterSupervisorID_UpdateSupervisorPage.setToolTipText("Supervisor ID");
		textFieldEnterSupervisorID_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterSupervisorID_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterSupervisorID_UpdateSupervisorPage.setColumns(10);
		textFieldEnterSupervisorID_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterSupervisorID_UpdateSupervisorPage.setBounds(186, 37, 111, 36);
		panelSupervisorSearch_UpdateSupervisorPage.add(textFieldEnterSupervisorID_UpdateSupervisorPage);
		/*End of Enter Supervisor ID textField UpdateSupervisorPage*/

		
		/*User Type Label  UpdateSupervisorPage*/
		lblUserType_UpdateSupervisorPage = new JLabel("User Type");
		lblUserType_UpdateSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserType_UpdateSupervisorPage.setForeground(Color.BLACK);
		lblUserType_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUserType_UpdateSupervisorPage.setFocusable(false);
		lblUserType_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUserType_UpdateSupervisorPage.setBounds(10, 394, 148, 36);
		panelCard_UpdateSupervisorPage.add(lblUserType_UpdateSupervisorPage);
		/*End of User Type Label  UpdateSupervisorPage*/
		
		
		/*User Type comboBox  UpdateSupervisorPage*/
		comboBoxUserType_UpdateSupervisorPage = new JComboBox();
		comboBoxUserType_UpdateSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxUserType_UpdateSupervisorPage.setModel(new DefaultComboBoxModel(new String[] {"User Type", "Supervisor", "Receptionist"}));
		comboBoxUserType_UpdateSupervisorPage.setToolTipText("User Type");
		comboBoxUserType_UpdateSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxUserType_UpdateSupervisorPage.setFocusable(false);
		comboBoxUserType_UpdateSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxUserType_UpdateSupervisorPage.setBackground(Color.WHITE);
		comboBoxUserType_UpdateSupervisorPage.setBounds(168, 394, 148, 36);
		panelCard_UpdateSupervisorPage.add(comboBoxUserType_UpdateSupervisorPage);
		/*End of User Type comboBox  UpdateSupervisorPage*/

		
		/*Delete Supervisor Page Panel*/
		panelCard_DeleteSupervisorPage = new JPanel();
		panelCard_DeleteSupervisorPage.setLayout(null);
		panelCard_DeleteSupervisorPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_DeleteSupervisorPage, DeleteSupervisorPagePanel);
		/*End of Delete Supervisor Page Panel*/

		
		/*Supervisor ID Label DeleteSupervisorPage*/
		lblSupervisorID_DeleteSupervisorPage = new JLabel("Supervisor ID");
		lblSupervisorID_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorID_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorID_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorID_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID_DeleteSupervisorPage.setBounds(10, 61, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorID_DeleteSupervisorPage);
		/*End of Supervisor ID Label DeleteSupervisorPage*/

		
		/*Supervisor ID 2 Label DeleteSupervisorPage*/
		lblSupervisorID2_DeleteSupervisorPage = new JLabel("");
		lblSupervisorID2_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblSupervisorID2_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorID2_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblSupervisorID2_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID2_DeleteSupervisorPage.setBackground(new Color(102, 51, 153));
		lblSupervisorID2_DeleteSupervisorPage.setBounds(168, 61, 148, 37);
		panelCard_DeleteSupervisorPage.add(lblSupervisorID2_DeleteSupervisorPage);
		/*End of Supervisor ID 2 Label DeleteSupervisorPage*/

		
		/*Supervisor Name Label DeleteSupervisorPage*/
		lblSupervisorName_DeleteSupervisorPage = new JLabel("Name");
		lblSupervisorName_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorName_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorName_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_DeleteSupervisorPage.setBounds(10, 108, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorName_DeleteSupervisorPage);
		/*End of Supervisor Name Label DeleteSupervisorPage*/

		
		/*Supervisor Name textField DeleteSupervisorPage*/
		textFieldSupervisorName_DeleteSupervisorPage = new JTextField();
		textFieldSupervisorName_DeleteSupervisorPage.setEditable(false);
		textFieldSupervisorName_DeleteSupervisorPage.setToolTipText("Name");
		textFieldSupervisorName_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorName_DeleteSupervisorPage.setColumns(10);
		textFieldSupervisorName_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_DeleteSupervisorPage.setBounds(168, 109, 148, 36);
		panelCard_DeleteSupervisorPage.add(textFieldSupervisorName_DeleteSupervisorPage);
		/*End of Supervisor Name textField DeleteSupervisorPage*/
		
		
		/*Supervisor Phone NO Label DeleteSupervisorPage*/
		lblSupervisorPhoneNO_DeleteSupervisorPage = new JLabel("Phone NO.");
		lblSupervisorPhoneNO_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPhoneNO_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPhoneNO_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPhoneNO_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorPhoneNO_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPhoneNO_DeleteSupervisorPage.setBounds(10, 202, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorPhoneNO_DeleteSupervisorPage);
		/*End of Supervisor Phone NO Label DeleteSupervisorPage*/

		
		/*Supervisor Phone NO textField DeleteSupervisorPage*/
		textFieldSupervisorPhoneNO_DeleteSupervisorPage = new JTextField();
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setEditable(false);
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setToolTipText("Phone NO.");
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setColumns(10);
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setBounds(168, 202, 148, 36);
		panelCard_DeleteSupervisorPage.add(textFieldSupervisorPhoneNO_DeleteSupervisorPage);
		/*End of Supervisor Phone NO textField DeleteSupervisorPage*/
		
		
		/*Supervisor Address Label DeleteSupervisorPage*/
		lblSupervisorAddress_DeleteSupervisorPage = new JLabel("Address");
		lblSupervisorAddress_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorAddress_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorAddress_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorAddress_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorAddress_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorAddress_DeleteSupervisorPage.setBounds(10, 253, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorAddress_DeleteSupervisorPage);
		/*End of Supervisor Address Label DeleteSupervisorPage*/

		
		/*Supervisor Address textField DeleteSupervisorPage*/
		textFieldSupervisorAddress_DeleteSupervisorPage = new JTextField();
		textFieldSupervisorAddress_DeleteSupervisorPage.setEditable(false);
		textFieldSupervisorAddress_DeleteSupervisorPage.setToolTipText("Address");
		textFieldSupervisorAddress_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorAddress_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorAddress_DeleteSupervisorPage.setColumns(10);
		textFieldSupervisorAddress_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorAddress_DeleteSupervisorPage.setBounds(168, 253, 148, 36);
		panelCard_DeleteSupervisorPage.add(textFieldSupervisorAddress_DeleteSupervisorPage);
		/*End of Supervisor Address textField DeleteSupervisorPage*/
		
		
		/*Supervisor Gender Label DeleteSupervisorPage*/
		lblSupervisorGender_DeleteSupervisorPage = new JLabel("Gender");
		lblSupervisorGender_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorGender_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorGender_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorGender_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorGender_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorGender_DeleteSupervisorPage.setBounds(10, 300, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorGender_DeleteSupervisorPage);
		/*End of Supervisor Gender Label DeleteSupervisorPage*/

		
		/*Gender comboBox DeleteSupervisorPage*/
		comboBoxGender_DeleteSupervisorPage = new JComboBox();
		comboBoxGender_DeleteSupervisorPage.setEnabled(false);
		comboBoxGender_DeleteSupervisorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_DeleteSupervisorPage.setToolTipText("Gender");
		comboBoxGender_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_DeleteSupervisorPage.setFocusable(false);
		comboBoxGender_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_DeleteSupervisorPage.setBackground(Color.WHITE);
		comboBoxGender_DeleteSupervisorPage.setBounds(168, 300, 148, 36);
		panelCard_DeleteSupervisorPage.add(comboBoxGender_DeleteSupervisorPage);
		/*End of Gender comboBox DeleteSupervisorPage*/
		
		
		/*Supervisor Date Of Birth Label DeleteSupervisorPage*/
		lblSupervisorDateOfBirth_DeleteSupervisorPage = new JLabel("Date Of Birth");
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorDateOfBirth_DeleteSupervisorPage.setBounds(10, 347, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorDateOfBirth_DeleteSupervisorPage);
		/*End of Supervisor Date Of Birth Label DeleteSupervisorPage*/

		
		/*Supervisor Date Of Birth JDateChooser DeleteSupervisorPage*/
		SupervisorDateOfBirth_DeleteSupervisorPage = new JDateChooser();
		SupervisorDateOfBirth_DeleteSupervisorPage.setEnabled(false);
		SupervisorDateOfBirth_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		SupervisorDateOfBirth_DeleteSupervisorPage.setBounds(168, 347, 148, 36);
		panelCard_DeleteSupervisorPage.add(SupervisorDateOfBirth_DeleteSupervisorPage);
		/*End of Supervisor Date Of Birth JDateChooser DeleteSupervisorPage*/

		
		/*Back Button DeleteSupervisorPage*/
		backBtn_DeleteSupervisorPage = new JButton();
		backBtn_DeleteSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_DeleteSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Supervisor Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsMainPagePanel);
				
				//Clear Fields
				clearButtonDeleteSupervisorPage();
			}
		});
		backBtn_DeleteSupervisorPage.setText("Back");
		backBtn_DeleteSupervisorPage.setForeground(Color.WHITE);
		backBtn_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_DeleteSupervisorPage.setFocusable(false);
		backBtn_DeleteSupervisorPage.setBackground(new Color(204, 0, 0));
		backBtn_DeleteSupervisorPage.setBounds(150, 450, 105, 35);
		panelCard_DeleteSupervisorPage.add(backBtn_DeleteSupervisorPage);
		/*End of Back Button DeleteSupervisorPage*/
		
		
		/*Clear Fields Button DeleteSupervisorPage*/
		BtnClearFields_DeleteSupervisorPage = new JButton();
		BtnClearFields_DeleteSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_DeleteSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonDeleteSupervisorPage();
			}
		});
		BtnClearFields_DeleteSupervisorPage.setText("Clear");
		BtnClearFields_DeleteSupervisorPage.setForeground(Color.WHITE);
		BtnClearFields_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_DeleteSupervisorPage.setFocusable(false);
		BtnClearFields_DeleteSupervisorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_DeleteSupervisorPage.setBounds(265, 450, 105, 35);
		panelCard_DeleteSupervisorPage.add(BtnClearFields_DeleteSupervisorPage);
		/*End of Clear Fields Button DeleteSupervisorPage*/
		
		
		/*Delete Supervisor Button DeleteSupervisorPage*/
		BtnDeleteSupervisor_DeleteSupervisorPage = new JButton();
		BtnDeleteSupervisor_DeleteSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Delete Supervisor
				 */
				
				//check if enter Supervisor ID field is empty
				if(textFieldEnterSupervisorID_DeleteSupervisorPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter Supervisor ID"); }
				
				//else continue after "check if enter Supervisor ID field is empty"
				else    				
				{
					// Set data to "UsersDTO" object
					UsersDTO usersDTO = new UsersDTO();
					usersDTO.setUserID(textFieldEnterSupervisorID_DeleteSupervisorPage.getText());
					// End of Set data to "UsersDTO" object

					
					// Send data to "deleteSupervisorDAO" method
					new SupervisorsDAO().deleteSupervisorDAO(usersDTO);
					// End of Send data to "deleteSupervisorDAO" method

				}
				
		
			}
		});
		BtnDeleteSupervisor_DeleteSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnDeleteSupervisor_DeleteSupervisorPage.setText("Delete");
		BtnDeleteSupervisor_DeleteSupervisorPage.setForeground(Color.WHITE);
		BtnDeleteSupervisor_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnDeleteSupervisor_DeleteSupervisorPage.setFocusable(false);
		BtnDeleteSupervisor_DeleteSupervisorPage.setBackground(new Color(102, 51, 153));
		BtnDeleteSupervisor_DeleteSupervisorPage.setBounds(380, 450, 105, 35);
		panelCard_DeleteSupervisorPage.add(BtnDeleteSupervisor_DeleteSupervisorPage);
		/*End of Delete Supervisor Button DeleteSupervisorPage*/
		
		
		/*Supervisor Last Name Label DeleteSupervisorPage*/
		lblSupervisorLastName_DeleteSupervisorPage = new JLabel("Last Name");
		lblSupervisorLastName_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorLastName_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorLastName_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorLastName_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorLastName_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorLastName_DeleteSupervisorPage.setBounds(10, 155, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorLastName_DeleteSupervisorPage);
		/*End of Supervisor Last Name Label DeleteSupervisorPage*/

		
		/*Supervisor Last Name textField DeleteSupervisorPage*/
		textFieldSupervisorLastName_DeleteSupervisorPage = new JTextField();
		textFieldSupervisorLastName_DeleteSupervisorPage.setEditable(false);
		textFieldSupervisorLastName_DeleteSupervisorPage.setToolTipText("Last Name");
		textFieldSupervisorLastName_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorLastName_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorLastName_DeleteSupervisorPage.setColumns(10);
		textFieldSupervisorLastName_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorLastName_DeleteSupervisorPage.setBounds(168, 156, 148, 36);
		panelCard_DeleteSupervisorPage.add(textFieldSupervisorLastName_DeleteSupervisorPage);
		/*End of Supervisor Last Name textField DeleteSupervisorPage*/
		
		
		/*Supervisor Username Label DeleteSupervisorPage*/
		lblSupervisorUsername_DeleteSupervisorPage = new JLabel("Username");
		lblSupervisorUsername_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorUsername_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorUsername_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorUsername_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorUsername_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorUsername_DeleteSupervisorPage.setBounds(334, 203, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorUsername_DeleteSupervisorPage);
		/*End of Supervisor Username Label DeleteSupervisorPage*/

		
		/*Supervisor Username textField DeleteSupervisorPage*/
		textFieldSupervisorUsername_DeleteSupervisorPage = new JTextField();
		textFieldSupervisorUsername_DeleteSupervisorPage.setEditable(false);
		textFieldSupervisorUsername_DeleteSupervisorPage.setToolTipText("Username");
		textFieldSupervisorUsername_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorUsername_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldSupervisorUsername_DeleteSupervisorPage.setColumns(10);
		textFieldSupervisorUsername_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorUsername_DeleteSupervisorPage.setBounds(492, 204, 148, 36);
		panelCard_DeleteSupervisorPage.add(textFieldSupervisorUsername_DeleteSupervisorPage);
		/*End of Supervisor Username textField DeleteSupervisorPage*/
		
		
		/*Supervisor Password Label DeleteSupervisorPage*/
		lblSupervisorPassword_DeleteSupervisorPage = new JLabel("Password");
		lblSupervisorPassword_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorPassword_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblSupervisorPassword_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorPassword_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorPassword_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorPassword_DeleteSupervisorPage.setBounds(334, 250, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblSupervisorPassword_DeleteSupervisorPage);
		/*End of Supervisor Password Label DeleteSupervisorPage*/

		
		/*Separator Vertical JSeparator DeleteSupervisorPage*/
		separatorVertical_DeleteSupervisorPage = new JSeparator();
		separatorVertical_DeleteSupervisorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_DeleteSupervisorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_DeleteSupervisorPage.setBorder(null);
		separatorVertical_DeleteSupervisorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_DeleteSupervisorPage.setBounds(324, 59, 2, 330);
		panelCard_DeleteSupervisorPage.add(separatorVertical_DeleteSupervisorPage);
		/*End of Separator Vertical JSeparator DeleteSupervisorPage*/
		
		
		/*Supervisor Password JPasswordField DeleteSupervisorPage*/
		passwordFieldSupervisorPassword_DeleteSupervisorPage = new JPasswordField();
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setEditable(false);
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setToolTipText("Password");
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setBounds(492, 250, 148, 36);
		panelCard_DeleteSupervisorPage.add(passwordFieldSupervisorPassword_DeleteSupervisorPage);
		/*End of Supervisor Password JPasswordField DeleteSupervisorPage*/
		
		
		/*Delete Supervisor Title Label DeleteSupervisorPage*/
		lblDeleteSupervisorTitle_DeleteSupervisorPage = new JLabel("Delete Supervisor Page");
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setFocusable(false);
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDeleteSupervisorTitle_DeleteSupervisorPage.setBounds(168, 0, 317, 36);
		panelCard_DeleteSupervisorPage.add(lblDeleteSupervisorTitle_DeleteSupervisorPage);
		/*End of Delete Supervisor Title Label DeleteSupervisorPage*/
		
		
		/*Supervisor Search Panel DeleteSupervisorPage*/
		panelSupervisorSearch_DeleteSupervisorPage = new JPanel();
		panelSupervisorSearch_DeleteSupervisorPage.setLayout(null);
		panelSupervisorSearch_DeleteSupervisorPage.setBackground(new Color(102, 51, 153));
		panelSupervisorSearch_DeleteSupervisorPage.setBounds(333, 61, 307, 127);
		panelCard_DeleteSupervisorPage.add(panelSupervisorSearch_DeleteSupervisorPage);
		/*End of Supervisor Search Panel DeleteSupervisorPage*/
		
		
		/*Supervisor Search Label DeleteSupervisorPage*/
		lblSupervisorSearch_DeleteSupervisorPage = new JLabel("Search Supervisor");
		lblSupervisorSearch_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorSearch_DeleteSupervisorPage.setForeground(Color.WHITE);
		lblSupervisorSearch_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorSearch_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorSearch_DeleteSupervisorPage.setBorder(null);
		lblSupervisorSearch_DeleteSupervisorPage.setBounds(10, 0, 287, 36);
		panelSupervisorSearch_DeleteSupervisorPage.add(lblSupervisorSearch_DeleteSupervisorPage);
		/*End of Supervisor Search Label DeleteSupervisorPage*/

		
		/*Search Button DeleteSupervisorPage*/
		btnSearch_DeleteSupervisorPage = new JButton();
		btnSearch_DeleteSupervisorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_DeleteSupervisorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Search Supervisor
				 */
				
								
				//check if enter Supervisor ID field is empty 
				if(textFieldEnterSupervisorID_DeleteSupervisorPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Supervisor ID"); }
				
				// else continue after "check if enter Supervisor ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
			    		preparedstatement.setString(1, textFieldEnterSupervisorID_DeleteSupervisorPage.getText());
			    		preparedstatement.setString(2, "Supervisor");
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Supervisor ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								SupervisorDateOfBirth_DeleteSupervisorPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblSupervisorID2_DeleteSupervisorPage.setText(resultset.getString(2));
							textFieldSupervisorName_DeleteSupervisorPage.setText(resultset.getString(3));
							textFieldSupervisorLastName_DeleteSupervisorPage.setText(resultset.getString(4));
							textFieldSupervisorPhoneNO_DeleteSupervisorPage.setText(phoneNO);
							textFieldSupervisorAddress_DeleteSupervisorPage.setText(resultset.getString(8));
							comboBoxGender_DeleteSupervisorPage.setSelectedItem(resultset.getString(5));
							textFieldSupervisorUsername_DeleteSupervisorPage.setText(resultset.getString(9));
							passwordFieldSupervisorPassword_DeleteSupervisorPage.setText(resultset.getString(10));
							comboBoxUserType_DeleteSupervisorPage.setSelectedItem(resultset.getString(11));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Supervisor ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Supervisor ID not exist, please enter the right Supervisor ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			
			
			
			}
		});
		btnSearch_DeleteSupervisorPage.setText("Search");
		btnSearch_DeleteSupervisorPage.setForeground(Color.WHITE);
		btnSearch_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_DeleteSupervisorPage.setFocusable(false);
		btnSearch_DeleteSupervisorPage.setBackground(new Color(102, 51, 153));
		btnSearch_DeleteSupervisorPage.setBounds(66, 84, 180, 35);
		panelSupervisorSearch_DeleteSupervisorPage.add(btnSearch_DeleteSupervisorPage);
		/*End of Search Button DeleteSupervisorPage*/
		
		
		/*Supervisor Search Enter ID Label DeleteSupervisorPage*/
		lblSupervisorSearchEnterID_DeleteSupervisorPage = new JLabel("Enter Supervisor ID");
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setForeground(Color.WHITE);
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setFocusable(false);
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblSupervisorSearchEnterID_DeleteSupervisorPage.setBounds(10, 37, 164, 36);
		panelSupervisorSearch_DeleteSupervisorPage.add(lblSupervisorSearchEnterID_DeleteSupervisorPage);
		/*End of Supervisor Search Enter ID Label DeleteSupervisorPage*/

		
		/*Enter Supervisor ID textField DeleteSupervisorPage*/
		textFieldEnterSupervisorID_DeleteSupervisorPage = new JTextField();
		textFieldEnterSupervisorID_DeleteSupervisorPage.setToolTipText("Supervisor ID");
		textFieldEnterSupervisorID_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterSupervisorID_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterSupervisorID_DeleteSupervisorPage.setColumns(10);
		textFieldEnterSupervisorID_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterSupervisorID_DeleteSupervisorPage.setBounds(186, 37, 111, 36);
		panelSupervisorSearch_DeleteSupervisorPage.add(textFieldEnterSupervisorID_DeleteSupervisorPage);
		/*End of Enter Supervisor ID textField DeleteSupervisorPage*/
		
		
		/*User Type Label DeleteSupervisorPage*/
		lblUserType_DeleteSupervisorPage = new JLabel("User Type");
		lblUserType_DeleteSupervisorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserType_DeleteSupervisorPage.setForeground(Color.BLACK);
		lblUserType_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUserType_DeleteSupervisorPage.setFocusable(false);
		lblUserType_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUserType_DeleteSupervisorPage.setBounds(10, 394, 148, 36);
		panelCard_DeleteSupervisorPage.add(lblUserType_DeleteSupervisorPage);
		/*End of User Type Label DeleteSupervisorPage*/

		
		/*User Type comboBox DeleteSupervisorPage*/
		comboBoxUserType_DeleteSupervisorPage = new JComboBox();
		comboBoxUserType_DeleteSupervisorPage.setEnabled(false);
		comboBoxUserType_DeleteSupervisorPage.setModel(new DefaultComboBoxModel(new String[] {"User Type", "Supervisor", "Receptionists"}));
		comboBoxUserType_DeleteSupervisorPage.setToolTipText("User Type");
		comboBoxUserType_DeleteSupervisorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxUserType_DeleteSupervisorPage.setFocusable(false);
		comboBoxUserType_DeleteSupervisorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxUserType_DeleteSupervisorPage.setBackground(Color.WHITE);
		comboBoxUserType_DeleteSupervisorPage.setBounds(168, 394, 148, 36);
		panelCard_DeleteSupervisorPage.add(comboBoxUserType_DeleteSupervisorPage);
		/*End of User Type comboBox DeleteSupervisorPage*/

		
		/*Supervisors Record Page Panel*/
		panelCard_SupervisorsRecordPage = new JPanel();
		panelCard_SupervisorsRecordPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_SupervisorsRecordPage();
			}
		});
		panelCard_SupervisorsRecordPage.setLayout(null);
		panelCard_SupervisorsRecordPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_SupervisorsRecordPage, SupervisorsRecordPagePanel);
		/*End of Supervisors Record Page Panel*/

		
		/*Back Button SupervisorsRecordPage*/
		BtnBack_SupervisorsRecordPage = new JButton();
		BtnBack_SupervisorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Supervisor Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, SupervisorsMainPagePanel);
				
				//Clear Filed and Refresh Table
				clearButtonSupervisorsRecordPage();
			}
		});
		BtnBack_SupervisorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_SupervisorsRecordPage.setText("Back");
		BtnBack_SupervisorsRecordPage.setForeground(Color.WHITE);
		BtnBack_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_SupervisorsRecordPage.setFocusable(false);
		BtnBack_SupervisorsRecordPage.setBackground(new Color(204, 0, 0));
		BtnBack_SupervisorsRecordPage.setBounds(221, 437, 105, 35);
		panelCard_SupervisorsRecordPage.add(BtnBack_SupervisorsRecordPage);
		/*End of Back Button SupervisorsRecordPage*/
		
		
		/*Clear Field Button SupervisorsRecordPage*/
		BtnClearcField_SupervisorsRecordPage = new JButton();
		BtnClearcField_SupervisorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Filed and Refresh Table
				clearButtonSupervisorsRecordPage();
			}
		});
		BtnClearcField_SupervisorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_SupervisorsRecordPage.setText("Clear");
		BtnClearcField_SupervisorsRecordPage.setForeground(Color.WHITE);
		BtnClearcField_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_SupervisorsRecordPage.setFocusable(false);
		BtnClearcField_SupervisorsRecordPage.setBackground(new Color(46, 139, 87));
		BtnClearcField_SupervisorsRecordPage.setBounds(336, 437, 105, 35);
		panelCard_SupervisorsRecordPage.add(BtnClearcField_SupervisorsRecordPage);
		/*End of Clear Field Button SupervisorsRecordPage*/
		
		
		/*Supervisor ID Label SupervisorsRecordPage*/
		lblSupervisorID_SupervisorsRecordPage = new JLabel("Supervisor ID");
		lblSupervisorID_SupervisorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorID_SupervisorsRecordPage.setForeground(Color.BLACK);
		lblSupervisorID_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorID_SupervisorsRecordPage.setFocusable(false);
		lblSupervisorID_SupervisorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorID_SupervisorsRecordPage.setBounds(10, 289, 191, 36);
		panelCard_SupervisorsRecordPage.add(lblSupervisorID_SupervisorsRecordPage);
		/*End of Supervisor ID Label SupervisorsRecordPage*/
		
		
		/*Search Supervisor ID Button SupervisorsRecordPage*/
		btnSearchSupervisorID_SupervisorsRecordPage = new JButton("Search Supervisor");
		btnSearchSupervisorID_SupervisorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Search Supervisor By Supervisor ID
				 */
				
								
				//check if Supervisor ID field is empty 
				if(textFieldSupervisorID_SupervisorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor ID"); }
				
				// else continue after "check if Supervisor ID field is empty "
				else          
				{
					
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
						preparedatatement.setString(1, textFieldSupervisorID_SupervisorsRecordPage.getText());
						preparedatatement.setString(2, "Supervisor");
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Supervisor ID correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_SupervisorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Supervisor ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Supervisor ID not exist");
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
		btnSearchSupervisorID_SupervisorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchSupervisorID_SupervisorsRecordPage.setForeground(Color.WHITE);
		btnSearchSupervisorID_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearchSupervisorID_SupervisorsRecordPage.setFocusable(false);
		btnSearchSupervisorID_SupervisorsRecordPage.setBackground(new Color(102, 51, 153));
		btnSearchSupervisorID_SupervisorsRecordPage.setBounds(393, 289, 247, 36);
		panelCard_SupervisorsRecordPage.add(btnSearchSupervisorID_SupervisorsRecordPage);
		/*End of Search Supervisor ID Button SupervisorsRecordPage*/
		
		
		/*scrollPane JScrollPane SupervisorsRecordPage*/
		scrollPane_SupervisorsRecordPage = new JScrollPane();
		scrollPane_SupervisorsRecordPage.setBounds(10, 53, 630, 191);
		panelCard_SupervisorsRecordPage.add(scrollPane_SupervisorsRecordPage);
		/*End of scrollPane JScrollPane SupervisorsRecordPage*/
		
		
		/*table SupervisorsRecordPage*/
		table_SupervisorsRecordPage = new JTable();
		table_SupervisorsRecordPage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_SupervisorsRecordPage.setViewportView(table_SupervisorsRecordPage);
		/*End of table SupervisorsRecordPage*/
		
		
		/*Supervisor ID textField SupervisorsRecordPage*/
		textFieldSupervisorID_SupervisorsRecordPage = new JTextField();
		textFieldSupervisorID_SupervisorsRecordPage.setToolTipText("Supervisor ID");
		textFieldSupervisorID_SupervisorsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorID_SupervisorsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSupervisorID_SupervisorsRecordPage.setColumns(10);
		textFieldSupervisorID_SupervisorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorID_SupervisorsRecordPage.setBounds(211, 289, 171, 36);
		panelCard_SupervisorsRecordPage.add(textFieldSupervisorID_SupervisorsRecordPage);
		/*End of Supervisor ID textField SupervisorsRecordPage*/
		
		
		/*Show All Added Supervisors Button SupervisorsRecordPage*/
		btnShowAllAddedSupervisors_SupervisorsRecordPage = new JButton("Show All Added By This Supervisor");
		btnShowAllAddedSupervisors_SupervisorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Show All Added Supervisors By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_SupervisorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_SupervisorsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Supervisors added by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Added_By_Supervisor`=? ");
						preparedatatement.setString(1, "Supervisor");
						preparedatatement.setString(2, textFieldSupervisorName_SupervisorsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Supervisors added by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_SupervisorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Supervisors added by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor Added By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	

			
			}
		});
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setForeground(Color.WHITE);
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setFocusable(false);
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllAddedSupervisors_SupervisorsRecordPage.setBounds(393, 336, 247, 36);
		panelCard_SupervisorsRecordPage.add(btnShowAllAddedSupervisors_SupervisorsRecordPage);
		/*End of Show All Added Supervisors Button SupervisorsRecordPage*/

		
		/*Show All Updated Supervisors Button SupervisorsRecordPage*/
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage = new JButton("Show All Updated By This Supervisor");
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show All Updated Supervisors By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_SupervisorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_SupervisorsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Supervisors Updated by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Updated_By_Supervisor`=? ");
						preparedatatement.setString(1, "Supervisor");
						preparedatatement.setString(2, textFieldSupervisorName_SupervisorsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Supervisors Updated by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_SupervisorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Supervisors Updated by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor Updated By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	

			
			
			}
		});
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setForeground(Color.WHITE);
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setFocusable(false);
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllUpdatedSupervisor_SupervisorsRecordPage.setBounds(393, 383, 247, 36);
		panelCard_SupervisorsRecordPage.add(btnShowAllUpdatedSupervisor_SupervisorsRecordPage);
		/*End of Show All Updated Supervisors Button SupervisorsRecordPage*/

		
		/*Supervisors Record Page Label SupervisorsRecordPage*/
		lblSupervisorsRecordPage_SupervisorsRecordPage = new JLabel("Supervisors Record Page");
		lblSupervisorsRecordPage_SupervisorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorsRecordPage_SupervisorsRecordPage.setForeground(Color.BLACK);
		lblSupervisorsRecordPage_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorsRecordPage_SupervisorsRecordPage.setFocusable(false);
		lblSupervisorsRecordPage_SupervisorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblSupervisorsRecordPage_SupervisorsRecordPage.setBounds(168, 0, 317, 36);
		panelCard_SupervisorsRecordPage.add(lblSupervisorsRecordPage_SupervisorsRecordPage);
		/*End of Supervisors Record Page Label SupervisorsRecordPage*/

		
		/*Supervisors Name Label SupervisorsRecordPage*/
		lblSupervisorName_SupervisorsRecordPage = new JLabel("Supervisor Name");
		lblSupervisorName_SupervisorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_SupervisorsRecordPage.setForeground(Color.BLACK);
		lblSupervisorName_SupervisorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_SupervisorsRecordPage.setFocusable(false);
		lblSupervisorName_SupervisorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_SupervisorsRecordPage.setBounds(10, 336, 191, 36);
		panelCard_SupervisorsRecordPage.add(lblSupervisorName_SupervisorsRecordPage);
		/*End of Supervisors Name Label SupervisorsRecordPage*/

		
		/*Supervisors Name textField SupervisorsRecordPage*/
		textFieldSupervisorName_SupervisorsRecordPage = new JTextField();
		textFieldSupervisorName_SupervisorsRecordPage.setToolTipText("Supervisor Name");
		textFieldSupervisorName_SupervisorsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_SupervisorsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSupervisorName_SupervisorsRecordPage.setColumns(10);
		textFieldSupervisorName_SupervisorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_SupervisorsRecordPage.setBounds(211, 336, 171, 36);
		panelCard_SupervisorsRecordPage.add(textFieldSupervisorName_SupervisorsRecordPage);
		/*End of Supervisors Name textField SupervisorsRecordPage*/
		
		
		/*Add Receptionists  page Panel*/
		panelCard_AddReceptionistPage = new JPanel();
		panelCard_AddReceptionistPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				//New Recptionist ID
				RandomReceptionistID();
			}
		});
		panelCard_AddReceptionistPage.setLayout(null);
		panelCard_AddReceptionistPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_AddReceptionistPage, AddReceptionistPagePanel);
		/*End of Add Receptionists  page Panel*/

		
		/*Receptionist ID Label AddReceptionistPage*/
		lblReceptionistID_AddReceptionistPage = new JLabel("Receptionist ID");
		lblReceptionistID_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistID_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 19));
		lblReceptionistID_AddReceptionistPage.setFocusable(false);
		lblReceptionistID_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID_AddReceptionistPage.setBounds(10, 61, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistID_AddReceptionistPage);
		/*End of Receptionist ID Label AddReceptionistPage*/
		
		
		/*Receptionist ID 2 Label AddReceptionistPage*/
		lblReceptionistID2_AddReceptionistPage = new JLabel("");
		lblReceptionistID2_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblReceptionistID2_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID2_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblReceptionistID2_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID2_AddReceptionistPage.setBackground(new Color(102, 51, 153));
		lblReceptionistID2_AddReceptionistPage.setBounds(168, 61, 91, 37);
		panelCard_AddReceptionistPage.add(lblReceptionistID2_AddReceptionistPage);
		/*End of Receptionist ID 2 Label AddReceptionistPage*/
		
		
		/*New Receptionsit ID Button AddReceptionistPage*/
		BtnNewReceptionistID_AddReceptionistPage = new JButton();
		BtnNewReceptionistID_AddReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//New Recptionist ID
				RandomReceptionistID();
			}
		});
		BtnNewReceptionistID_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewReceptionistID_AddReceptionistPage.setText("New ID");
		BtnNewReceptionistID_AddReceptionistPage.setForeground(Color.WHITE);
		BtnNewReceptionistID_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewReceptionistID_AddReceptionistPage.setFocusable(false);
		BtnNewReceptionistID_AddReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnNewReceptionistID_AddReceptionistPage.setBounds(261, 61, 78, 35);
		panelCard_AddReceptionistPage.add(BtnNewReceptionistID_AddReceptionistPage);
		/*End of New Receptionsit ID Button AddReceptionistPage*/
		
		
		/*Receptionist Name Label AddReceptionistPage*/
		lblReceptionistName_AddReceptionistPage = new JLabel("Name");
		lblReceptionistName_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistName_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistName_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistName_AddReceptionistPage.setFocusable(false);
		lblReceptionistName_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistName_AddReceptionistPage.setBounds(10, 108, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistName_AddReceptionistPage);
		/*End of Receptionist Name Label AddReceptionistPage*/

		
		/*Receptionist Name textField AddReceptionistPage*/
		textFieldReceptionistName_AddReceptionistPage = new JTextField();
		textFieldReceptionistName_AddReceptionistPage.setToolTipText("Name");
		textFieldReceptionistName_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistName_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistName_AddReceptionistPage.setColumns(10);
		textFieldReceptionistName_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistName_AddReceptionistPage.setBounds(168, 109, 148, 36);
		panelCard_AddReceptionistPage.add(textFieldReceptionistName_AddReceptionistPage);
		/*End of Receptionist Name textField AddReceptionistPage*/
		
		
		/*Receptionist Phone NO Label AddReceptionistPage*/
		lblReceptionistPhoneNO_AddReceptionistPage = new JLabel("Phone NO.");
		lblReceptionistPhoneNO_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPhoneNO_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPhoneNO_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPhoneNO_AddReceptionistPage.setFocusable(false);
		lblReceptionistPhoneNO_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPhoneNO_AddReceptionistPage.setBounds(10, 202, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistPhoneNO_AddReceptionistPage);
		/*End of Receptionist Phone NO Label AddReceptionistPage*/

		
		/*Receptionist Phone NO textField AddReceptionistPage*/
		textFieldReceptionistPhoneNO_AddReceptionistPage = new JTextField();
		textFieldReceptionistPhoneNO_AddReceptionistPage.setToolTipText("Phone NO.");
		textFieldReceptionistPhoneNO_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistPhoneNO_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistPhoneNO_AddReceptionistPage.setColumns(10);
		textFieldReceptionistPhoneNO_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistPhoneNO_AddReceptionistPage.setBounds(168, 202, 148, 36);
		panelCard_AddReceptionistPage.add(textFieldReceptionistPhoneNO_AddReceptionistPage);
		/*End of Receptionist Phone NO textField AddReceptionistPage*/
		
		
		/*Receptionist Address Label AddReceptionistPage*/
		lblReceptionistAddress_AddReceptionistPage = new JLabel("Address");
		lblReceptionistAddress_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistAddress_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistAddress_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistAddress_AddReceptionistPage.setFocusable(false);
		lblReceptionistAddress_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistAddress_AddReceptionistPage.setBounds(10, 253, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistAddress_AddReceptionistPage);
		/*End of Receptionist Address Label AddReceptionistPage*/

		
		/*Receptionist Address textField AddReceptionistPage*/
		textFieldReceptionistAddress_AddReceptionistPage = new JTextField();
		textFieldReceptionistAddress_AddReceptionistPage.setToolTipText("Address");
		textFieldReceptionistAddress_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistAddress_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistAddress_AddReceptionistPage.setColumns(10);
		textFieldReceptionistAddress_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistAddress_AddReceptionistPage.setBounds(168, 253, 148, 36);
		panelCard_AddReceptionistPage.add(textFieldReceptionistAddress_AddReceptionistPage);
		/*End of Receptionist Address textField AddReceptionistPage*/
		
		
		/*Receptionist Gender Label AddReceptionistPage*/
		lblReceptionistGender_AddReceptionistPage = new JLabel("Gender");
		lblReceptionistGender_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistGender_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistGender_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistGender_AddReceptionistPage.setFocusable(false);
		lblReceptionistGender_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistGender_AddReceptionistPage.setBounds(10, 300, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistGender_AddReceptionistPage);
		/*End of Receptionist Gender Label AddReceptionistPage*/

		
		/*Gender comboBox AddReceptionistPage*/
		comboBoxGender_AddReceptionistPage = new JComboBox();
		comboBoxGender_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_AddReceptionistPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_AddReceptionistPage.setToolTipText("Gender");
		comboBoxGender_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_AddReceptionistPage.setFocusable(false);
		comboBoxGender_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_AddReceptionistPage.setBackground(Color.WHITE);
		comboBoxGender_AddReceptionistPage.setBounds(168, 300, 148, 36);
		panelCard_AddReceptionistPage.add(comboBoxGender_AddReceptionistPage);
		/*End of Gender comboBox AddReceptionistPage*/
		
		
		/*Receptionist Date Of Birth Label AddReceptionistPage*/
		lblReceptionistDateOfBirth_AddReceptionistPage = new JLabel("Date Of Birth");
		lblReceptionistDateOfBirth_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistDateOfBirth_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistDateOfBirth_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistDateOfBirth_AddReceptionistPage.setFocusable(false);
		lblReceptionistDateOfBirth_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistDateOfBirth_AddReceptionistPage.setBounds(10, 347, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistDateOfBirth_AddReceptionistPage);
		/*End of Receptionist Date Of Birth Label AddReceptionistPage*/

		
		/*Receptionsit Date Of Birth JDateChooser AddReceptionistPage*/
		ReceptionistDateOfBirth_AddReceptionistPage = new JDateChooser();
		ReceptionistDateOfBirth_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ReceptionistDateOfBirth_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		ReceptionistDateOfBirth_AddReceptionistPage.setBounds(168, 347, 148, 36);
		panelCard_AddReceptionistPage.add(ReceptionistDateOfBirth_AddReceptionistPage);
		/*End of Receptionsit Date Of Birth JDateChooser AddReceptionistPage*/

		
		/*Back Button AddReceptionistPage*/
		backBtn_AddReceptionistPage = new JButton();
		backBtn_AddReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Receptionists Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsMainPagePanel);
				
				//Clear Fields
				clearButtonAddReceptionistPage();
				
				//Set Show Password Button to Show
				BtnShowPassword_AddReceptionistPage.setText("Show");
			}
		});
		backBtn_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_AddReceptionistPage.setText("Back");
		backBtn_AddReceptionistPage.setForeground(Color.WHITE);
		backBtn_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_AddReceptionistPage.setFocusable(false);
		backBtn_AddReceptionistPage.setBackground(new Color(204, 0, 0));
		backBtn_AddReceptionistPage.setBounds(150, 450, 105, 35);
		panelCard_AddReceptionistPage.add(backBtn_AddReceptionistPage);
		/*End of Back Button AddReceptionistPage*/

		
		/*Clear Fields Button AddReceptionistPage*/
		BtnClearFields_AddReceptionistPage = new JButton();
		BtnClearFields_AddReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//New Recptionist ID
				RandomReceptionistID();
				
				//Clear Fields
				clearButtonAddReceptionistPage();
			}
		});
		BtnClearFields_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_AddReceptionistPage.setText("Clear");
		BtnClearFields_AddReceptionistPage.setForeground(Color.WHITE);
		BtnClearFields_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_AddReceptionistPage.setFocusable(false);
		BtnClearFields_AddReceptionistPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_AddReceptionistPage.setBounds(265, 450, 105, 35);
		panelCard_AddReceptionistPage.add(BtnClearFields_AddReceptionistPage);
		/*End of Clear Fields Button AddReceptionistPage*/

		
		/*Add Receptionist Button AddReceptionistPage*/
		BtnAddReceptionist_AddReceptionistPage = new JButton();
		BtnAddReceptionist_AddReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Add New Receptionist
				 */
				
				
				//check if there any empty spaces
				if(lblReceptionistID2_AddReceptionistPage.getText().isEmpty() || textFieldReceptionistName_AddReceptionistPage.getText().isEmpty() ||
				   textFieldReceptionistLastName_AddReceptionistPage.getText().isEmpty() || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().isEmpty() ||		
				   textFieldReceptionistUsername_AddReceptionistPage.getText().isEmpty() || textFieldReceptionistAddress_AddReceptionistPage.getText().isEmpty() ||
				   comboBoxGender_AddReceptionistPage.getSelectedIndex()==0 || ReceptionistDateOfBirth_AddReceptionistPage.getDate()==null ||
				   passwordFieldReceptionistPassword_AddReceptionistPage.getText().isEmpty() || passwordFieldReceptionistRePassword_AddReceptionistPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no numbers Entered in Name and Last Name Fields
					if(textFieldReceptionistName_AddReceptionistPage.getText().contains("0") || textFieldReceptionistName_AddReceptionistPage.getText().contains("1") ||
					   textFieldReceptionistName_AddReceptionistPage.getText().contains("2") || textFieldReceptionistName_AddReceptionistPage.getText().contains("3") ||
					   textFieldReceptionistName_AddReceptionistPage.getText().contains("4") || textFieldReceptionistName_AddReceptionistPage.getText().contains("5") ||
					   textFieldReceptionistName_AddReceptionistPage.getText().contains("6") || textFieldReceptionistName_AddReceptionistPage.getText().contains("7") ||
					   textFieldReceptionistName_AddReceptionistPage.getText().contains("8") || textFieldReceptionistName_AddReceptionistPage.getText().contains("9") ||
					   textFieldReceptionistLastName_AddReceptionistPage.getText().contains("0") || textFieldReceptionistLastName_AddReceptionistPage.getText().contains("1") ||
					   textFieldReceptionistLastName_AddReceptionistPage.getText().contains("2") || textFieldReceptionistLastName_AddReceptionistPage.getText().contains("3") ||
					   textFieldReceptionistLastName_AddReceptionistPage.getText().contains("4") || textFieldReceptionistLastName_AddReceptionistPage.getText().contains("5") ||
					   textFieldReceptionistLastName_AddReceptionistPage.getText().contains("6") || textFieldReceptionistLastName_AddReceptionistPage.getText().contains("7") ||
					   textFieldReceptionistLastName_AddReceptionistPage.getText().contains("8") || textFieldReceptionistLastName_AddReceptionistPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name fields"); }
					
					//else continue after "check no numbers Entered in Name and Last Name  Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("a") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("b") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("c") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("d") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("e") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("f") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("g") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("h") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("i") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("j") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("k") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("l") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("m") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("n") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("o") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("p") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("q") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("r") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("s") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("t") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("u") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("v") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("w") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("x") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("y") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("z") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("A") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("B") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("C") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("D") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("E") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("F") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("G") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("H") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("I") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("J") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("K") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("L") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("M") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("N") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("O") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("P") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("Q") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("R") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("S") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("T") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("U") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("V") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("W") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("X") ||
								   textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("Y") || textFieldReceptionistPhoneNO_AddReceptionistPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
							// check passwords match
							if(!passwordFieldReceptionistPassword_AddReceptionistPage.getText().equals(passwordFieldReceptionistRePassword_AddReceptionistPage.getText()))
							{
								JOptionPane.showMessageDialog(null, "Passwords Dont Match!!");
							}
							
							//else continue after "check passwords match"
							else
							{	
								
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
							String DofB              = dFormat.format(ReceptionistDateOfBirth_AddReceptionistPage.getDate());
							// End date to string

							// text to integer
							int PhoneNO = Integer.parseInt(textFieldReceptionistPhoneNO_AddReceptionistPage.getText()); 
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "UsersDTO" object
							UsersDTO usersDTO = new UsersDTO(); 
							usersDTO.setUserID(lblReceptionistID2_AddReceptionistPage.getText());
							usersDTO.setName(textFieldReceptionistName_AddReceptionistPage.getText());
							usersDTO.setLast_Name(textFieldReceptionistLastName_AddReceptionistPage.getText());
							usersDTO.setPhone_Number(PhoneNO);
							usersDTO.setAddress(textFieldReceptionistAddress_AddReceptionistPage.getText());
							usersDTO.setGender((String) comboBoxGender_AddReceptionistPage.getSelectedItem());
							usersDTO.setDate_Of_Birth(DofB);
							usersDTO.setUsername(textFieldReceptionistUsername_AddReceptionistPage.getText());
							usersDTO.setPassword(passwordFieldReceptionistPassword_AddReceptionistPage.getText());
							usersDTO.setUser_Type("Receptionist");
							usersDTO.setAdded_By_Supervisor(supervisorName);
							usersDTO.setAdded_Date(tDate.format(timer.getTime()));
							usersDTO.setAdded_Time(tTime.format(timer.getTime()));
							// End of Set data to "UsersDTO" object

							// Send data to "addReceptionistDAO" method
							new ReceptionistsDAO().addReceptionistDAO(usersDTO);
							// End of Send data to "addReceptionistDAO" method

							}
						}  
					}		
				}
			
			
			}
		});
		BtnAddReceptionist_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnAddReceptionist_AddReceptionistPage.setText("Add");
		BtnAddReceptionist_AddReceptionistPage.setForeground(Color.WHITE);
		BtnAddReceptionist_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnAddReceptionist_AddReceptionistPage.setFocusable(false);
		BtnAddReceptionist_AddReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnAddReceptionist_AddReceptionistPage.setBounds(380, 450, 105, 35);
		panelCard_AddReceptionistPage.add(BtnAddReceptionist_AddReceptionistPage);
		/*End of Add Receptionist Button AddReceptionistPage*/
		
		
		/*Receptionist Last Name Label AddReceptionistPage*/
		lblReceptionistLastName_AddReceptionistPage = new JLabel("Last Name");
		lblReceptionistLastName_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistLastName_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistLastName_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistLastName_AddReceptionistPage.setFocusable(false);
		lblReceptionistLastName_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistLastName_AddReceptionistPage.setBounds(10, 155, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistLastName_AddReceptionistPage);
		/*End of Receptionist Last Name Label AddReceptionistPage*/

		
		/*Receptionist Last Name textField AddReceptionistPage*/
		textFieldReceptionistLastName_AddReceptionistPage = new JTextField();
		textFieldReceptionistLastName_AddReceptionistPage.setToolTipText("Last Name");
		textFieldReceptionistLastName_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistLastName_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistLastName_AddReceptionistPage.setColumns(10);
		textFieldReceptionistLastName_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistLastName_AddReceptionistPage.setBounds(168, 156, 148, 36);
		panelCard_AddReceptionistPage.add(textFieldReceptionistLastName_AddReceptionistPage);
		/*End of Receptionist Last Name textField AddReceptionistPage*/
		
		
		/*Receptionist Username Label AddReceptionistPage*/
		lblReceptionistUsername_AddReceptionistPage = new JLabel("Username");
		lblReceptionistUsername_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistUsername_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistUsername_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistUsername_AddReceptionistPage.setFocusable(false);
		lblReceptionistUsername_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistUsername_AddReceptionistPage.setBounds(334, 107, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistUsername_AddReceptionistPage);
		/*End of Receptionist Username Label AddReceptionistPage*/

		
		/*Receptionist Username textField AddReceptionistPage*/
		textFieldReceptionistUsername_AddReceptionistPage = new JTextField();
		textFieldReceptionistUsername_AddReceptionistPage.setToolTipText("Username");
		textFieldReceptionistUsername_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistUsername_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistUsername_AddReceptionistPage.setColumns(10);
		textFieldReceptionistUsername_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistUsername_AddReceptionistPage.setBounds(492, 108, 148, 36);
		panelCard_AddReceptionistPage.add(textFieldReceptionistUsername_AddReceptionistPage);
		/*End of Receptionist Username textField AddReceptionistPage*/
		
		
		/*Receptionist Password Label AddReceptionistPage*/
		lblReceptionistPassword_AddReceptionistPage = new JLabel("Password");
		lblReceptionistPassword_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPassword_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPassword_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPassword_AddReceptionistPage.setFocusable(false);
		lblReceptionistPassword_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPassword_AddReceptionistPage.setBounds(334, 154, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistPassword_AddReceptionistPage);
		/*End of Receptionist Password Label AddReceptionistPage*/

		
		/*Receptionist RePassword Label AddReceptionistPage*/
		lblReceptionistRePassword_AddReceptionistPage = new JLabel("Re-Password");
		lblReceptionistRePassword_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistRePassword_AddReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistRePassword_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistRePassword_AddReceptionistPage.setFocusable(false);
		lblReceptionistRePassword_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistRePassword_AddReceptionistPage.setBounds(334, 205, 148, 36);
		panelCard_AddReceptionistPage.add(lblReceptionistRePassword_AddReceptionistPage);
		/*End of Receptionist RePassword Label AddReceptionistPage*/

		
		/*separatorVertical JSeparator AddReceptionistPage*/
		separatorVertical_AddReceptionistPage = new JSeparator();
		separatorVertical_AddReceptionistPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_AddReceptionistPage.setForeground(new Color(216, 191, 216));
		separatorVertical_AddReceptionistPage.setBorder(null);
		separatorVertical_AddReceptionistPage.setBackground(new Color(102, 51, 153));
		separatorVertical_AddReceptionistPage.setBounds(324, 100, 2, 300);
		panelCard_AddReceptionistPage.add(separatorVertical_AddReceptionistPage);
		/*End of separatorVertical JSeparator AddReceptionistPage*/
		
		
		/*Show Password Button AddReceptionistPage*/
		BtnShowPassword_AddReceptionistPage = new JButton();
		BtnShowPassword_AddReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Show and hide password
				ShowAndHidePasswordButton_AddReceptionistPage();
			}
		});
		BtnShowPassword_AddReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnShowPassword_AddReceptionistPage.setText("Show");
		BtnShowPassword_AddReceptionistPage.setForeground(Color.WHITE);
		BtnShowPassword_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnShowPassword_AddReceptionistPage.setFocusable(false);
		BtnShowPassword_AddReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnShowPassword_AddReceptionistPage.setBounds(562, 252, 78, 35);
		panelCard_AddReceptionistPage.add(BtnShowPassword_AddReceptionistPage);
		/*End of Show Password Button AddReceptionistPage*/
		
		
		/*Receptionist Password JPasswordField AddReceptionistPage*/
		passwordFieldReceptionistPassword_AddReceptionistPage = new JPasswordField();
		passwordFieldReceptionistPassword_AddReceptionistPage.setToolTipText("Password");
		passwordFieldReceptionistPassword_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldReceptionistPassword_AddReceptionistPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldReceptionistPassword_AddReceptionistPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldReceptionistPassword_AddReceptionistPage.setBounds(492, 154, 148, 36);
		panelCard_AddReceptionistPage.add(passwordFieldReceptionistPassword_AddReceptionistPage);
		/*End of Receptionist Password JPasswordField AddReceptionistPage*/
		
		
		/*Receptionist RePassword JPasswordField AddReceptionistPage*/
		passwordFieldReceptionistRePassword_AddReceptionistPage = new JPasswordField();
		passwordFieldReceptionistRePassword_AddReceptionistPage.setToolTipText("Password");
		passwordFieldReceptionistRePassword_AddReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldReceptionistRePassword_AddReceptionistPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldReceptionistRePassword_AddReceptionistPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldReceptionistRePassword_AddReceptionistPage.setBounds(492, 205, 148, 36);
		panelCard_AddReceptionistPage.add(passwordFieldReceptionistRePassword_AddReceptionistPage);
		/*End of Receptionist RePassword JPasswordField AddReceptionistPage*/
		
		
		/*Add Receptionist Title Label AddReceptionistPage*/
		lblAddReceptionistTitle_AddReceptionistPage = new JLabel("Add Receptionist Page");
		lblAddReceptionistTitle_AddReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddReceptionistTitle_AddReceptionistPage.setForeground(Color.BLACK);
		lblAddReceptionistTitle_AddReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAddReceptionistTitle_AddReceptionistPage.setFocusable(false);
		lblAddReceptionistTitle_AddReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAddReceptionistTitle_AddReceptionistPage.setBounds(168, 0, 317, 36);
		panelCard_AddReceptionistPage.add(lblAddReceptionistTitle_AddReceptionistPage);
		/*End of Add Receptionist Title Label AddReceptionistPage*/
		
		
		/*Update Receptionists  page Panel*/
		panelCard_UpdateReceptionistPage = new JPanel();
		panelCard_UpdateReceptionistPage.setLayout(null);
		panelCard_UpdateReceptionistPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_UpdateReceptionistPage, UpdateReceptionistPagePanel);
		/*End of Update Receptionists  page Panel*/

		
		/*Receptionist ID Label UpdateReceptionistPage*/
		lblReceptionistID_UpdateReceptionistPage = new JLabel("Receptionist ID");
		lblReceptionistID_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistID_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 19));
		lblReceptionistID_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistID_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID_UpdateReceptionistPage.setBounds(10, 61, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistID_UpdateReceptionistPage);
		/*End of Receptionist ID Label UpdateReceptionistPage*/

		
		/*Receptionist ID 2 Label UpdateReceptionistPage*/
		lblReceptionistID2_UpdateReceptionistPage = new JLabel("");
		lblReceptionistID2_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblReceptionistID2_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID2_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblReceptionistID2_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID2_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		lblReceptionistID2_UpdateReceptionistPage.setBounds(168, 61, 148, 37);
		panelCard_UpdateReceptionistPage.add(lblReceptionistID2_UpdateReceptionistPage);
		/*End of Receptionist ID 2 Label UpdateReceptionistPage*/

		
		/*Receptionist Name Label UpdateReceptionistPage*/
		lblReceptionistName_UpdateReceptionistPage = new JLabel("Name");
		lblReceptionistName_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistName_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistName_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistName_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistName_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistName_UpdateReceptionistPage.setBounds(10, 108, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistName_UpdateReceptionistPage);
		/*End of Receptionist Name Label UpdateReceptionistPage*/

		
		/*Receptionist Name textField UpdateReceptionistPage*/
		textFieldReceptionistName_UpdateReceptionistPage = new JTextField();
		textFieldReceptionistName_UpdateReceptionistPage.setToolTipText("Name");
		textFieldReceptionistName_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistName_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistName_UpdateReceptionistPage.setColumns(10);
		textFieldReceptionistName_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistName_UpdateReceptionistPage.setBounds(168, 109, 148, 36);
		panelCard_UpdateReceptionistPage.add(textFieldReceptionistName_UpdateReceptionistPage);
		/*End of Receptionist Name textField UpdateReceptionistPage*/
		
		
		/*Receptionist Phone NO Label UpdateReceptionistPage*/
		lblReceptionistPhoneNO_UpdateReceptionistPage = new JLabel("Phone NO.");
		lblReceptionistPhoneNO_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPhoneNO_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPhoneNO_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPhoneNO_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistPhoneNO_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPhoneNO_UpdateReceptionistPage.setBounds(10, 202, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistPhoneNO_UpdateReceptionistPage);
		/*End of Receptionist Phone NO Label UpdateReceptionistPage*/

		
		/*Receptionist Phone NO textField UpdateReceptionistPage*/
		textFieldReceptionistPhoneNO_UpdateReceptionistPage = new JTextField();
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setToolTipText("Phone NO.");
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setColumns(10);
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setBounds(168, 202, 148, 36);
		panelCard_UpdateReceptionistPage.add(textFieldReceptionistPhoneNO_UpdateReceptionistPage);
		/*End of Receptionist Phone NO textField UpdateReceptionistPage*/
		
		
		/*Receptionist Address Label UpdateReceptionistPage*/
		lblReceptionistAddress_UpdateReceptionistPage = new JLabel("Address");
		lblReceptionistAddress_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistAddress_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistAddress_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistAddress_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistAddress_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistAddress_UpdateReceptionistPage.setBounds(10, 253, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistAddress_UpdateReceptionistPage);
		/*End of Receptionist Address Label UpdateReceptionistPage*/

		
		/*Receptionist Address textField UpdateReceptionistPage*/
		textFieldReceptionistAddress_UpdateReceptionistPage = new JTextField();
		textFieldReceptionistAddress_UpdateReceptionistPage.setToolTipText("Address");
		textFieldReceptionistAddress_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistAddress_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistAddress_UpdateReceptionistPage.setColumns(10);
		textFieldReceptionistAddress_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistAddress_UpdateReceptionistPage.setBounds(168, 253, 148, 36);
		panelCard_UpdateReceptionistPage.add(textFieldReceptionistAddress_UpdateReceptionistPage);
		/*End of Receptionist Address textField UpdateReceptionistPage*/
		
		
		/*Receptionist Gender Label UpdateReceptionistPage*/
		lblReceptionistGender_UpdateReceptionistPage = new JLabel("Gender");
		lblReceptionistGender_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistGender_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistGender_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistGender_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistGender_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistGender_UpdateReceptionistPage.setBounds(10, 300, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistGender_UpdateReceptionistPage);
		/*End of Receptionist Gender Label UpdateReceptionistPage*/

		
		/*Gender comboBox UpdateReceptionistPage*/
		comboBoxGender_UpdateReceptionistPage = new JComboBox();
		comboBoxGender_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_UpdateReceptionistPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_UpdateReceptionistPage.setToolTipText("Gender");
		comboBoxGender_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_UpdateReceptionistPage.setFocusable(false);
		comboBoxGender_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_UpdateReceptionistPage.setBackground(Color.WHITE);
		comboBoxGender_UpdateReceptionistPage.setBounds(168, 300, 148, 36);
		panelCard_UpdateReceptionistPage.add(comboBoxGender_UpdateReceptionistPage);
		/*End of Gender comboBox UpdateReceptionistPage*/
		
		
		/*Receptionist Date Of Birth Label UpdateReceptionistPage*/
		lblReceptionistDateOfBirth_UpdateReceptionistPage = new JLabel("Date Of Birth");
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistDateOfBirth_UpdateReceptionistPage.setBounds(10, 347, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistDateOfBirth_UpdateReceptionistPage);
		/*End of Receptionist Date Of Birth Label UpdateReceptionistPage*/

		
		/*Receptionist Date Of Birth JDateChooser UpdateReceptionistPage*/
		ReceptionistDateOfBirth_UpdateReceptionistPage = new JDateChooser();
		ReceptionistDateOfBirth_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ReceptionistDateOfBirth_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		ReceptionistDateOfBirth_UpdateReceptionistPage.setBounds(168, 347, 148, 36);
		panelCard_UpdateReceptionistPage.add(ReceptionistDateOfBirth_UpdateReceptionistPage);
		/*End of Receptionist Date Of Birth JDateChooser UpdateReceptionistPage*/

		
		/*Back Button UpdateReceptionistPage*/
		backBtn_UpdateReceptionistPage = new JButton();
		backBtn_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_UpdateReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Receptionists Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsMainPagePanel);
				
				//Clear Fields
				clearButtonUpdateReceptionistPage();
				
				//Set Show Password Button to Show
				BtnShowPassword_UpdateReceptionistPage.setText("Show");
			}
		});
		backBtn_UpdateReceptionistPage.setText("Back");
		backBtn_UpdateReceptionistPage.setForeground(Color.WHITE);
		backBtn_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_UpdateReceptionistPage.setFocusable(false);
		backBtn_UpdateReceptionistPage.setBackground(new Color(204, 0, 0));
		backBtn_UpdateReceptionistPage.setBounds(150, 450, 105, 35);
		panelCard_UpdateReceptionistPage.add(backBtn_UpdateReceptionistPage);
		/*End of Back Button UpdateReceptionistPage*/
		
		
		/*Clear Fields Button UpdateReceptionistPage*/
		BtnClearFields_UpdateReceptionistPage = new JButton();
		BtnClearFields_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_UpdateReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonUpdateReceptionistPage();
			}
		});
		BtnClearFields_UpdateReceptionistPage.setText("Clear");
		BtnClearFields_UpdateReceptionistPage.setForeground(Color.WHITE);
		BtnClearFields_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_UpdateReceptionistPage.setFocusable(false);
		BtnClearFields_UpdateReceptionistPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_UpdateReceptionistPage.setBounds(265, 450, 105, 35);
		panelCard_UpdateReceptionistPage.add(BtnClearFields_UpdateReceptionistPage);
		/*End of Clear Fields Button UpdateReceptionistPage*/
		
		
		/*Update Receptionist Button UpdateReceptionistPage*/
		BtnUpdateReceptionist_UpdateReceptionistPage = new JButton();
		BtnUpdateReceptionist_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUpdateReceptionist_UpdateReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Update Receptionist
				 */
				
				
				//check if there any empty spaces
				if(lblReceptionistID2_UpdateReceptionistPage.getText().isEmpty() || textFieldReceptionistName_UpdateReceptionistPage.getText().isEmpty() || 
				   textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().isEmpty() || textFieldReceptionistAddress_UpdateReceptionistPage.getText().isEmpty() ||
				   comboBoxGender_UpdateReceptionistPage.getSelectedIndex()==0 || ReceptionistDateOfBirth_UpdateReceptionistPage.getDate()==null ||
				   textFieldReceptionistLastName_UpdateReceptionistPage.getText().isEmpty() || comboBoxUserType_UpdateReceptionistPage.getSelectedIndex()==0 ||
				   textFieldReceptionistUsername_UpdateReceptionistPage.getText().isEmpty() || passwordFieldReceptionistPassword_UpdateReceptionistPage.getText().isEmpty() ||
				   passwordFieldReceptionistRePassword_UpdateReceptionistPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no number Entered in Name and Last Name Fields
					if(textFieldReceptionistName_UpdateReceptionistPage.getText().contains("0") || textFieldReceptionistName_UpdateReceptionistPage.getText().contains("1") ||
					   textFieldReceptionistName_UpdateReceptionistPage.getText().contains("2") || textFieldReceptionistName_UpdateReceptionistPage.getText().contains("3") ||
					   textFieldReceptionistName_UpdateReceptionistPage.getText().contains("4") || textFieldReceptionistName_UpdateReceptionistPage.getText().contains("5") ||
					   textFieldReceptionistName_UpdateReceptionistPage.getText().contains("6") || textFieldReceptionistName_UpdateReceptionistPage.getText().contains("7") ||
					   textFieldReceptionistName_UpdateReceptionistPage.getText().contains("8") || textFieldReceptionistName_UpdateReceptionistPage.getText().contains("9") ||
					   textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("0") || textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("1") ||
					   textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("2") || textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("3") ||
					   textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("4") || textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("5") ||
					   textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("6") || textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("7") ||
					   textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("8") || textFieldReceptionistLastName_UpdateReceptionistPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name field"); }
					
					//else continue after "check no number Entered in Name and Last Name Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("a") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("b") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("c") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("d") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("e") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("f") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("g") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("h") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("i") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("j") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("k") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("l") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("m") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("n") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("o") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("p") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("q") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("r") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("s") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("t") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("u") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("v") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("w") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("x") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("y") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("z") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("A") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("B") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("C") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("D") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("E") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("F") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("G") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("H") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("I") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("J") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("K") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("L") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("M") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("N") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("O") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("P") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("Q") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("R") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("S") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("T") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("U") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("V") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("W") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("X") ||
								textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("Y") || textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
						
							// check passwords match
							if(!passwordFieldReceptionistPassword_UpdateReceptionistPage.getText().equals(passwordFieldReceptionistRePassword_UpdateReceptionistPage.getText()))
							{
								JOptionPane.showMessageDialog(null, "Passwords Dont Match!!");
							}
							
							//else continue after "check passwords match"
						    else
						    {
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
							String DofB              = dFormat.format(ReceptionistDateOfBirth_UpdateReceptionistPage.getDate());
							// End date to string
							
							// text to integer
							int PhoneNO = Integer.parseInt(textFieldReceptionistPhoneNO_UpdateReceptionistPage.getText());   
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "UsersDTO" object
							UsersDTO usersDTO = new UsersDTO(); 
							usersDTO.setUserID(lblReceptionistID2_UpdateReceptionistPage.getText());
							usersDTO.setName(textFieldReceptionistName_UpdateReceptionistPage.getText());
							usersDTO.setLast_Name(textFieldReceptionistLastName_UpdateReceptionistPage.getText());
							usersDTO.setPhone_Number(PhoneNO);
							usersDTO.setAddress(textFieldReceptionistAddress_UpdateReceptionistPage.getText());
							usersDTO.setGender((String) comboBoxGender_UpdateReceptionistPage.getSelectedItem());
							usersDTO.setDate_Of_Birth(DofB);
							usersDTO.setUsername(textFieldReceptionistUsername_UpdateReceptionistPage.getText());
							usersDTO.setPassword(passwordFieldReceptionistPassword_UpdateReceptionistPage.getText());
							usersDTO.setUser_Type((String) comboBoxUserType_UpdateReceptionistPage.getSelectedItem());
							usersDTO.setUpdated_By_Supervisor(supervisorName);
							usersDTO.setLast_Update_Date(tDate.format(timer.getTime()));
							usersDTO.setLast_Update_Time(tTime.format(timer.getTime()));
							// End of Set data to "UsersDTO" object

							// Send data to "updateReceptionistDAO" method
							new ReceptionistsDAO().updateReceptionistDAO(usersDTO);
							// End of Send data to "updateReceptionistDAO" method
							
						    }

						} 
					}	
				}
			
			}
		});
		BtnUpdateReceptionist_UpdateReceptionistPage.setText("Update");
		BtnUpdateReceptionist_UpdateReceptionistPage.setForeground(Color.WHITE);
		BtnUpdateReceptionist_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnUpdateReceptionist_UpdateReceptionistPage.setFocusable(false);
		BtnUpdateReceptionist_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnUpdateReceptionist_UpdateReceptionistPage.setBounds(380, 450, 105, 35);
		panelCard_UpdateReceptionistPage.add(BtnUpdateReceptionist_UpdateReceptionistPage);
		/*End of Update Receptionist Button UpdateReceptionistPage*/
		
		
		/*Receptionist Last Name Label UpdateReceptionistPage*/
		lblReceptionistLastName_UpdateReceptionistPage = new JLabel("Last Name");
		lblReceptionistLastName_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistLastName_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistLastName_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistLastName_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistLastName_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistLastName_UpdateReceptionistPage.setBounds(10, 155, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistLastName_UpdateReceptionistPage);
		/*End of Receptionist Last Name Label UpdateReceptionistPage*/

		
		/*Receptionist Last Name textField UpdateReceptionistPage*/
		textFieldReceptionistLastName_UpdateReceptionistPage = new JTextField();
		textFieldReceptionistLastName_UpdateReceptionistPage.setToolTipText("Last Name");
		textFieldReceptionistLastName_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistLastName_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistLastName_UpdateReceptionistPage.setColumns(10);
		textFieldReceptionistLastName_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistLastName_UpdateReceptionistPage.setBounds(168, 156, 148, 36);
		panelCard_UpdateReceptionistPage.add(textFieldReceptionistLastName_UpdateReceptionistPage);
		/*End of Receptionist Last Name textField UpdateReceptionistPage*/
		
		
		/*Receptionist Username Label UpdateReceptionistPage*/
		lblReceptionistUsername_UpdateReceptionistPage = new JLabel("Username");
		lblReceptionistUsername_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistUsername_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistUsername_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistUsername_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistUsername_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistUsername_UpdateReceptionistPage.setBounds(334, 203, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistUsername_UpdateReceptionistPage);
		/*End of Receptionist Username Label UpdateReceptionistPage*/

		
		/*Receptionist Username textField UpdateReceptionistPage*/
		textFieldReceptionistUsername_UpdateReceptionistPage = new JTextField();
		textFieldReceptionistUsername_UpdateReceptionistPage.setToolTipText("Username");
		textFieldReceptionistUsername_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistUsername_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistUsername_UpdateReceptionistPage.setColumns(10);
		textFieldReceptionistUsername_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistUsername_UpdateReceptionistPage.setBounds(492, 204, 148, 36);
		panelCard_UpdateReceptionistPage.add(textFieldReceptionistUsername_UpdateReceptionistPage);
		/*End of Receptionist Username textField UpdateReceptionistPage*/
		
		
		/*Receptionist Password Label UpdateReceptionistPage*/
		lblReceptionistPassword_UpdateReceptionistPage = new JLabel("Password");
		lblReceptionistPassword_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPassword_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPassword_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPassword_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistPassword_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPassword_UpdateReceptionistPage.setBounds(334, 250, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistPassword_UpdateReceptionistPage);
		/*End of Receptionist Password Label UpdateReceptionistPage*/

		
		/*Receptionist RePassword Label UpdateReceptionistPage*/
		lblReceptionistRePassword_UpdateReceptionistPage = new JLabel("Re-Password");
		lblReceptionistRePassword_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistRePassword_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistRePassword_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistRePassword_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistRePassword_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistRePassword_UpdateReceptionistPage.setBounds(334, 301, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblReceptionistRePassword_UpdateReceptionistPage);
		/*End of Receptionist RePassword Label UpdateReceptionistPage*/
		
		
		/*separatorVertical JSeparator UpdateReceptionistPage*/
		separatorVertical_UpdateReceptionistPage = new JSeparator();
		separatorVertical_UpdateReceptionistPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_UpdateReceptionistPage.setForeground(new Color(216, 191, 216));
		separatorVertical_UpdateReceptionistPage.setBorder(null);
		separatorVertical_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		separatorVertical_UpdateReceptionistPage.setBounds(324, 59, 2, 330);
		panelCard_UpdateReceptionistPage.add(separatorVertical_UpdateReceptionistPage);
		/*End of separatorVertical JSeparator UpdateReceptionistPage*/
		
		
		/*Show Password Button UpdateReceptionistPage*/
		BtnShowPassword_UpdateReceptionistPage = new JButton();
		BtnShowPassword_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnShowPassword_UpdateReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Show and hide password
				ShowAndHidePasswordButton_UpdateReceptionistPage();
			}
		});
		BtnShowPassword_UpdateReceptionistPage.setText("Show");
		BtnShowPassword_UpdateReceptionistPage.setForeground(Color.WHITE);
		BtnShowPassword_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnShowPassword_UpdateReceptionistPage.setFocusable(false);
		BtnShowPassword_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnShowPassword_UpdateReceptionistPage.setBounds(562, 348, 78, 35);
		panelCard_UpdateReceptionistPage.add(BtnShowPassword_UpdateReceptionistPage);
		/*End of Show Password Button UpdateReceptionistPage*/
		
		
		/*Receptionist Password JPasswordField UpdateReceptionistPage*/
		passwordFieldReceptionistPassword_UpdateReceptionistPage = new JPasswordField();
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setToolTipText("Password");
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setBounds(492, 250, 148, 36);
		panelCard_UpdateReceptionistPage.add(passwordFieldReceptionistPassword_UpdateReceptionistPage);
		/*End of Receptionist Password JPasswordField UpdateReceptionistPage*/
		
		
		/*Receptionist RePassword JPasswordField UpdateReceptionistPage*/
		passwordFieldReceptionistRePassword_UpdateReceptionistPage = new JPasswordField();
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setToolTipText("Password");
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setBounds(492, 301, 148, 36);
		panelCard_UpdateReceptionistPage.add(passwordFieldReceptionistRePassword_UpdateReceptionistPage);
		/*End of Receptionist RePassword JPasswordField UpdateReceptionistPage*/
		
		
		/*Update Receptionist Title Label UpdateReceptionistPage*/
		lblUpdateReceptionistTitle_UpdateReceptionistPage = new JLabel("Update Receptionist Page");
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setFocusable(false);
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblUpdateReceptionistTitle_UpdateReceptionistPage.setBounds(168, 0, 317, 36);
		panelCard_UpdateReceptionistPage.add(lblUpdateReceptionistTitle_UpdateReceptionistPage);
		/*End of Update Receptionist Title Label UpdateReceptionistPage*/
		
		
		/*Receptionist Search Panel UpdateReceptionistPage*/
		panelReceptionistSearch_UpdateReceptionistPage = new JPanel();
		panelReceptionistSearch_UpdateReceptionistPage.setLayout(null);
		panelReceptionistSearch_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		panelReceptionistSearch_UpdateReceptionistPage.setBounds(333, 61, 307, 127);
		panelCard_UpdateReceptionistPage.add(panelReceptionistSearch_UpdateReceptionistPage);
		/*End of Receptionist Search Panel UpdateReceptionistPage*/

		
		/*Receptionist Search Label UpdateReceptionistPage*/
		lblReceptionistSearch_UpdateReceptionistPage = new JLabel("Search Receptionist");
		lblReceptionistSearch_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistSearch_UpdateReceptionistPage.setForeground(Color.WHITE);
		lblReceptionistSearch_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistSearch_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistSearch_UpdateReceptionistPage.setBorder(null);
		lblReceptionistSearch_UpdateReceptionistPage.setBounds(10, 0, 287, 36);
		panelReceptionistSearch_UpdateReceptionistPage.add(lblReceptionistSearch_UpdateReceptionistPage);
		/*End of Receptionist Search Label UpdateReceptionistPage*/

		
		/*Search Button UpdateReceptionistPage*/
		btnSearch_UpdateReceptionistPage = new JButton();
		btnSearch_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_UpdateReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Search Receptionist
				 */
				
								
				//check if enter Receptionist ID field is empty 
				if(textFieldEnterReceptionistID_UpdateReceptionistPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Receptionist ID"); }
				
				// else continue after "check if enter Receptionist ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
			    		preparedstatement.setString(1, textFieldEnterReceptionistID_UpdateReceptionistPage.getText());
			    		preparedstatement.setString(2, "Receptionist");
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Receptionist ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								ReceptionistDateOfBirth_UpdateReceptionistPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblReceptionistID2_UpdateReceptionistPage.setText(resultset.getString(2));
							textFieldReceptionistName_UpdateReceptionistPage.setText(resultset.getString(3));
							textFieldReceptionistLastName_UpdateReceptionistPage.setText(resultset.getString(4));
							textFieldReceptionistPhoneNO_UpdateReceptionistPage.setText(phoneNO);
							textFieldReceptionistAddress_UpdateReceptionistPage.setText(resultset.getString(8));
							comboBoxGender_UpdateReceptionistPage.setSelectedItem(resultset.getString(5));
							textFieldReceptionistUsername_UpdateReceptionistPage.setText(resultset.getString(9));
							passwordFieldReceptionistPassword_UpdateReceptionistPage.setText(resultset.getString(10));
							passwordFieldReceptionistRePassword_UpdateReceptionistPage.setText(resultset.getString(10));
							comboBoxUserType_UpdateReceptionistPage.setSelectedItem(resultset.getString(11));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Receptionist ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Receptionist ID not exist, please enter the right Receptionist ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSearch_UpdateReceptionistPage.setText("Search");
		btnSearch_UpdateReceptionistPage.setForeground(Color.WHITE);
		btnSearch_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_UpdateReceptionistPage.setFocusable(false);
		btnSearch_UpdateReceptionistPage.setBackground(new Color(102, 51, 153));
		btnSearch_UpdateReceptionistPage.setBounds(66, 84, 180, 35);
		panelReceptionistSearch_UpdateReceptionistPage.add(btnSearch_UpdateReceptionistPage);
		/*End of Search Button UpdateReceptionistPage*/
		
		
		/*Receptionist Search Enter ID Label UpdateReceptionistPage*/
		lblReceptionistSearchEnterID_UpdateReceptionistPage = new JLabel("Enter Receptionist ID");
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setForeground(Color.WHITE);
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setFocusable(false);
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblReceptionistSearchEnterID_UpdateReceptionistPage.setBounds(10, 37, 164, 36);
		panelReceptionistSearch_UpdateReceptionistPage.add(lblReceptionistSearchEnterID_UpdateReceptionistPage);
		/*End of Receptionist Search Enter ID Label UpdateReceptionistPage*/

		
		/*Enter Receptionist ID textField UpdateReceptionistPage*/
		textFieldEnterReceptionistID_UpdateReceptionistPage = new JTextField();
		textFieldEnterReceptionistID_UpdateReceptionistPage.setToolTipText("Receptionist ID");
		textFieldEnterReceptionistID_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterReceptionistID_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterReceptionistID_UpdateReceptionistPage.setColumns(10);
		textFieldEnterReceptionistID_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterReceptionistID_UpdateReceptionistPage.setBounds(186, 37, 111, 36);
		panelReceptionistSearch_UpdateReceptionistPage.add(textFieldEnterReceptionistID_UpdateReceptionistPage);
		/*End of Enter Receptionist ID textField UpdateReceptionistPage*/
		
		
		/*User Type Label UpdateReceptionistPage*/
		lblUserType_UpdateReceptionistPage = new JLabel("User Type");
		lblUserType_UpdateReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserType_UpdateReceptionistPage.setForeground(Color.BLACK);
		lblUserType_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUserType_UpdateReceptionistPage.setFocusable(false);
		lblUserType_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUserType_UpdateReceptionistPage.setBounds(10, 394, 148, 36);
		panelCard_UpdateReceptionistPage.add(lblUserType_UpdateReceptionistPage);
		/*End of User Type Label UpdateReceptionistPage*/

		
		/*User Type comboBox UpdateReceptionistPage*/
		comboBoxUserType_UpdateReceptionistPage = new JComboBox();
		comboBoxUserType_UpdateReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxUserType_UpdateReceptionistPage.setModel(new DefaultComboBoxModel(new String[] {"User Type", "Supervisor", "Receptionist"}));
		comboBoxUserType_UpdateReceptionistPage.setToolTipText("User Type");
		comboBoxUserType_UpdateReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxUserType_UpdateReceptionistPage.setFocusable(false);
		comboBoxUserType_UpdateReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxUserType_UpdateReceptionistPage.setBackground(Color.WHITE);
		comboBoxUserType_UpdateReceptionistPage.setBounds(168, 394, 148, 36);
		panelCard_UpdateReceptionistPage.add(comboBoxUserType_UpdateReceptionistPage);
		/*End of User Type comboBox UpdateReceptionistPage*/
		
		
		/*Delete Receptionist  page Panel*/
		panelCard_DeleteReceptionistPage = new JPanel();
		panelCard_DeleteReceptionistPage.setLayout(null);
		panelCard_DeleteReceptionistPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_DeleteReceptionistPage, DeleteReceptionistPagePanel);
		/*End of Delete Receptionist  page Panel*/

		
		/*Receptionist ID Label DeleteReceptionistPage*/
		lblReceptionistID_DeleteReceptionistPage = new JLabel("Receptionist ID");
		lblReceptionistID_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistID_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 19));
		lblReceptionistID_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistID_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID_DeleteReceptionistPage.setBounds(10, 61, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistID_DeleteReceptionistPage);
		/*End of Receptionist ID Label DeleteReceptionistPage*/

		
		/*Receptionist ID 2 Label DeleteReceptionistPage*/
		lblReceptionistID2_DeleteReceptionistPage = new JLabel("");
		lblReceptionistID2_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblReceptionistID2_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistID2_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblReceptionistID2_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID2_DeleteReceptionistPage.setBackground(new Color(102, 51, 153));
		lblReceptionistID2_DeleteReceptionistPage.setBounds(168, 61, 148, 37);
		panelCard_DeleteReceptionistPage.add(lblReceptionistID2_DeleteReceptionistPage);
		/*End of Receptionist ID 2 Label DeleteReceptionistPage*/

		
		/*Receptionist Name Label DeleteReceptionistPage*/
		lblReceptionistName_DeleteReceptionistPage = new JLabel("Name");
		lblReceptionistName_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistName_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistName_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistName_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistName_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistName_DeleteReceptionistPage.setBounds(10, 108, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistName_DeleteReceptionistPage);
		/*End of Receptionist Name Label DeleteReceptionistPage*/

		
		/*Receptionist Name textField DeleteReceptionistPage*/
		textFieldReceptionistName_DeleteReceptionistPage = new JTextField();
		textFieldReceptionistName_DeleteReceptionistPage.setToolTipText("Name");
		textFieldReceptionistName_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistName_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistName_DeleteReceptionistPage.setEditable(false);
		textFieldReceptionistName_DeleteReceptionistPage.setColumns(10);
		textFieldReceptionistName_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistName_DeleteReceptionistPage.setBounds(168, 109, 148, 36);
		panelCard_DeleteReceptionistPage.add(textFieldReceptionistName_DeleteReceptionistPage);
		/*End of Receptionist Name textField DeleteReceptionistPage*/
		
		
		/*Receptionist Phone NO Label DeleteReceptionistPage*/
		lblReceptionistPhoneNO_DeleteReceptionistPage = new JLabel("Phone NO.");
		lblReceptionistPhoneNO_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPhoneNO_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPhoneNO_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPhoneNO_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistPhoneNO_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPhoneNO_DeleteReceptionistPage.setBounds(10, 202, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistPhoneNO_DeleteReceptionistPage);
		/*End of Receptionist Phone NO Label DeleteReceptionistPage*/

		
		/*Receptionist Phone NO textField DeleteReceptionistPage*/
		textFieldReceptionistPhoneNO_DeleteReceptionistPage = new JTextField();
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setToolTipText("Phone NO.");
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setEditable(false);
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setColumns(10);
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setBounds(168, 202, 148, 36);
		panelCard_DeleteReceptionistPage.add(textFieldReceptionistPhoneNO_DeleteReceptionistPage);
		/*End of Receptionist Phone NO textField DeleteReceptionistPage*/
		
		
		/*Receptionist Address Label DeleteReceptionistPage*/
		lblReceptionistAddress_DeleteReceptionistPage = new JLabel("Address");
		lblReceptionistAddress_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistAddress_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistAddress_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistAddress_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistAddress_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistAddress_DeleteReceptionistPage.setBounds(10, 253, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistAddress_DeleteReceptionistPage);
		/*End of Receptionist Address Label DeleteReceptionistPage*/

		
		/*Receptionist Address textField DeleteReceptionistPage*/
		textFieldReceptionistAddress_DeleteReceptionistPage = new JTextField();
		textFieldReceptionistAddress_DeleteReceptionistPage.setToolTipText("Address");
		textFieldReceptionistAddress_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistAddress_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistAddress_DeleteReceptionistPage.setEditable(false);
		textFieldReceptionistAddress_DeleteReceptionistPage.setColumns(10);
		textFieldReceptionistAddress_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistAddress_DeleteReceptionistPage.setBounds(168, 253, 148, 36);
		panelCard_DeleteReceptionistPage.add(textFieldReceptionistAddress_DeleteReceptionistPage);
		/*End of Receptionist Address textField DeleteReceptionistPage*/
		
		
		/*Receptionist Gender Label DeleteReceptionistPage*/
		lblReceptionistGender_DeleteReceptionistPage = new JLabel("Gender");
		lblReceptionistGender_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistGender_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistGender_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistGender_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistGender_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistGender_DeleteReceptionistPage.setBounds(10, 300, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistGender_DeleteReceptionistPage);
		/*End of Receptionist Gender Label DeleteReceptionistPage*/

		
		/*Gender comboBox DeleteReceptionistPage*/
		comboBoxGender_DeleteReceptionistPage = new JComboBox();
		comboBoxGender_DeleteReceptionistPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_DeleteReceptionistPage.setToolTipText("Gender");
		comboBoxGender_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_DeleteReceptionistPage.setFocusable(false);
		comboBoxGender_DeleteReceptionistPage.setEnabled(false);
		comboBoxGender_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_DeleteReceptionistPage.setBackground(Color.WHITE);
		comboBoxGender_DeleteReceptionistPage.setBounds(168, 300, 148, 36);
		panelCard_DeleteReceptionistPage.add(comboBoxGender_DeleteReceptionistPage);
		/*End of Gender comboBox DeleteReceptionistPage*/
		
		
		/*Receptionist Date Of Birth Label DeleteReceptionistPage*/
		lblReceptionistDateOfBirth_DeleteReceptionistPage = new JLabel("Date Of Birth");
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistDateOfBirth_DeleteReceptionistPage.setBounds(10, 347, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistDateOfBirth_DeleteReceptionistPage);
		/*End of Receptionist Date Of Birth Label DeleteReceptionistPage*/

		
		/*Receptionist Date Of Birth JDateChooser DeleteReceptionistPage*/
		ReceptionistDateOfBirth_DeleteReceptionistPage = new JDateChooser();
		ReceptionistDateOfBirth_DeleteReceptionistPage.setEnabled(false);
		ReceptionistDateOfBirth_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		ReceptionistDateOfBirth_DeleteReceptionistPage.setBounds(168, 347, 148, 36);
		panelCard_DeleteReceptionistPage.add(ReceptionistDateOfBirth_DeleteReceptionistPage);
		/*End of Receptionist Date Of Birth JDateChooser DeleteReceptionistPage*/

		
		/*Back Button DeleteReceptionistPage*/
		backBtn_DeleteReceptionistPage = new JButton();
		backBtn_DeleteReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Receptionists Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsMainPagePanel);
				
				//Clear Fields
				clearButtonDeleteReceptionistPage();
			}
		});
		backBtn_DeleteReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_DeleteReceptionistPage.setText("Back");
		backBtn_DeleteReceptionistPage.setForeground(Color.WHITE);
		backBtn_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_DeleteReceptionistPage.setFocusable(false);
		backBtn_DeleteReceptionistPage.setBackground(new Color(204, 0, 0));
		backBtn_DeleteReceptionistPage.setBounds(150, 450, 105, 35);
		panelCard_DeleteReceptionistPage.add(backBtn_DeleteReceptionistPage);
		/*End of Back Button DeleteReceptionistPage*/
		
		
		/*Clear Fields Button DeleteReceptionistPage*/
		BtnClearFields_DeleteReceptionistPage = new JButton();
		BtnClearFields_DeleteReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonDeleteReceptionistPage();
			}
		});
		BtnClearFields_DeleteReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_DeleteReceptionistPage.setText("Clear");
		BtnClearFields_DeleteReceptionistPage.setForeground(Color.WHITE);
		BtnClearFields_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_DeleteReceptionistPage.setFocusable(false);
		BtnClearFields_DeleteReceptionistPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_DeleteReceptionistPage.setBounds(265, 450, 105, 35);
		panelCard_DeleteReceptionistPage.add(BtnClearFields_DeleteReceptionistPage);
		/*End of Clear Fields Button DeleteReceptionistPage*/
		
		
		/*Delete Receptionist Button DeleteReceptionistPage*/
		BtnDeleteReceptionist_DeleteReceptionistPage = new JButton();
		BtnDeleteReceptionist_DeleteReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Delete Receptionist
				 */
				
				//check if enter Receptionist ID field is empty
				if(textFieldEnterReceptionistID_DeleteReceptionistPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter Receptionist ID"); }
				
				//else continue after "check if enter Receptionist ID field is empty"
				else    				
				{
					// Set data to "UsersDTO" object
					UsersDTO usersDTO = new UsersDTO();
					usersDTO.setUserID(textFieldEnterReceptionistID_DeleteReceptionistPage.getText());
					// End of Set data to "UsersDTO" object

					
					// Send data to "deleteReceptionistDAO" method
					new ReceptionistsDAO().deleteReceptionistDAO(usersDTO);
					// End of Send data to "deleteReceptionistDAO" method

				}
				
		
			
			}
		});
		BtnDeleteReceptionist_DeleteReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnDeleteReceptionist_DeleteReceptionistPage.setText("Delete");
		BtnDeleteReceptionist_DeleteReceptionistPage.setForeground(Color.WHITE);
		BtnDeleteReceptionist_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnDeleteReceptionist_DeleteReceptionistPage.setFocusable(false);
		BtnDeleteReceptionist_DeleteReceptionistPage.setBackground(new Color(102, 51, 153));
		BtnDeleteReceptionist_DeleteReceptionistPage.setBounds(380, 450, 105, 35);
		panelCard_DeleteReceptionistPage.add(BtnDeleteReceptionist_DeleteReceptionistPage);
		/*End of Delete Receptionist Button DeleteReceptionistPage*/
		
		
		/*Receptionist Last Name Label DeleteReceptionistPage*/
		lblReceptionistLastName_DeleteReceptionistPage = new JLabel("Last Name");
		lblReceptionistLastName_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistLastName_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistLastName_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistLastName_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistLastName_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistLastName_DeleteReceptionistPage.setBounds(10, 155, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistLastName_DeleteReceptionistPage);
		/*End of Receptionist Last Name Label DeleteReceptionistPage*/

		
		/*Receptionist Last Name textField DeleteReceptionistPage*/
		textFieldReceptionistLastName_DeleteReceptionistPage = new JTextField();
		textFieldReceptionistLastName_DeleteReceptionistPage.setToolTipText("Last Name");
		textFieldReceptionistLastName_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistLastName_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistLastName_DeleteReceptionistPage.setEditable(false);
		textFieldReceptionistLastName_DeleteReceptionistPage.setColumns(10);
		textFieldReceptionistLastName_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistLastName_DeleteReceptionistPage.setBounds(168, 156, 148, 36);
		panelCard_DeleteReceptionistPage.add(textFieldReceptionistLastName_DeleteReceptionistPage);
		/*End of Receptionist Last Name textField DeleteReceptionistPage*/
		
		
		/*Receptionist Username Label DeleteReceptionistPage*/
		lblReceptionistUsername_DeleteReceptionistPage = new JLabel("Username");
		lblReceptionistUsername_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistUsername_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistUsername_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistUsername_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistUsername_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistUsername_DeleteReceptionistPage.setBounds(334, 203, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistUsername_DeleteReceptionistPage);
		/*End of Receptionist Username Label DeleteReceptionistPage*/

		
		/*Receptionist Username textField DeleteReceptionistPage*/
		textFieldReceptionistUsername_DeleteReceptionistPage = new JTextField();
		textFieldReceptionistUsername_DeleteReceptionistPage.setToolTipText("Username");
		textFieldReceptionistUsername_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistUsername_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldReceptionistUsername_DeleteReceptionistPage.setEditable(false);
		textFieldReceptionistUsername_DeleteReceptionistPage.setColumns(10);
		textFieldReceptionistUsername_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistUsername_DeleteReceptionistPage.setBounds(492, 204, 148, 36);
		panelCard_DeleteReceptionistPage.add(textFieldReceptionistUsername_DeleteReceptionistPage);
		/*End of Receptionist Username textField DeleteReceptionistPage*/
		
		
		/*Receptionist Password Label DeleteReceptionistPage*/
		lblReceptionistPassword_DeleteReceptionistPage = new JLabel("Password");
		lblReceptionistPassword_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistPassword_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblReceptionistPassword_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistPassword_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistPassword_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistPassword_DeleteReceptionistPage.setBounds(334, 250, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblReceptionistPassword_DeleteReceptionistPage);
		/*End of Receptionist Password Label DeleteReceptionistPage*/

		
		/*separatorVertical JSeparator DeleteReceptionistPage*/
		separatorVertical_DeleteReceptionistPage = new JSeparator();
		separatorVertical_DeleteReceptionistPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_DeleteReceptionistPage.setForeground(new Color(216, 191, 216));
		separatorVertical_DeleteReceptionistPage.setBorder(null);
		separatorVertical_DeleteReceptionistPage.setBackground(new Color(102, 51, 153));
		separatorVertical_DeleteReceptionistPage.setBounds(324, 59, 2, 330);
		panelCard_DeleteReceptionistPage.add(separatorVertical_DeleteReceptionistPage);
		/*End of separatorVertical JSeparator DeleteReceptionistPage*/
		
		
		/*Receptionist Password JPasswordField DeleteReceptionistPage*/
		passwordFieldReceptionistPassword_DeleteReceptionistPage = new JPasswordField();
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setToolTipText("Password");
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setFont(new Font("Kartika", Font.PLAIN, 19));
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setEditable(false);
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setBorder(new LineBorder((new Color(102, 51, 153)), 2, true));
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setBounds(492, 250, 148, 36);
		panelCard_DeleteReceptionistPage.add(passwordFieldReceptionistPassword_DeleteReceptionistPage);
		/*End of Receptionist Password JPasswordField DeleteReceptionistPage*/
		
		
		/*Delete Receptionist Title Label DeleteReceptionistPage*/
		lblDeleteReceptionistTitle_DeleteReceptionistPage = new JLabel("Delete Receptionist Page");
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setFocusable(false);
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDeleteReceptionistTitle_DeleteReceptionistPage.setBounds(168, 0, 317, 36);
		panelCard_DeleteReceptionistPage.add(lblDeleteReceptionistTitle_DeleteReceptionistPage);
		/*End of Delete Receptionist Title Label DeleteReceptionistPage*/

		
		/*Receptionist Search Panel DeleteReceptionistPage*/
		panelReceptionistSearch_DeleteReceptionistPage = new JPanel();
		panelReceptionistSearch_DeleteReceptionistPage.setLayout(null);
		panelReceptionistSearch_DeleteReceptionistPage.setBackground(new Color(102, 51, 153));
		panelReceptionistSearch_DeleteReceptionistPage.setBounds(333, 61, 307, 127);
		panelCard_DeleteReceptionistPage.add(panelReceptionistSearch_DeleteReceptionistPage);
		/*End of Receptionist Search Panel DeleteReceptionistPage*/

		
		/*Receptionist Search Label DeleteReceptionistPage*/
		lblReceptionistSearch_DeleteReceptionistPage = new JLabel("Search Receptionist");
		lblReceptionistSearch_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistSearch_DeleteReceptionistPage.setForeground(Color.WHITE);
		lblReceptionistSearch_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistSearch_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistSearch_DeleteReceptionistPage.setBorder(null);
		lblReceptionistSearch_DeleteReceptionistPage.setBounds(10, 0, 287, 36);
		panelReceptionistSearch_DeleteReceptionistPage.add(lblReceptionistSearch_DeleteReceptionistPage);
		/*End of Receptionist Search Label DeleteReceptionistPage*/

		
		/*Search Button DeleteReceptionistPage*/
		btnSearch_DeleteReceptionistPage = new JButton();
		btnSearch_DeleteReceptionistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/*
				 *     Search Receptionist
				 */
				
								
				//check if enter Receptionist ID field is empty 
				if(textFieldEnterReceptionistID_DeleteReceptionistPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Receptionist ID"); }
				
				// else continue after "check if enter Receptionist ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
			    		preparedstatement.setString(1, textFieldEnterReceptionistID_DeleteReceptionistPage.getText());
			    		preparedstatement.setString(2, "Receptionist");
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Receptionist ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								ReceptionistDateOfBirth_DeleteReceptionistPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblReceptionistID2_DeleteReceptionistPage.setText(resultset.getString(2));
							textFieldReceptionistName_DeleteReceptionistPage.setText(resultset.getString(3));
							textFieldReceptionistLastName_DeleteReceptionistPage.setText(resultset.getString(4));
							textFieldReceptionistPhoneNO_DeleteReceptionistPage.setText(phoneNO);
							textFieldReceptionistAddress_DeleteReceptionistPage.setText(resultset.getString(8));
							comboBoxGender_DeleteReceptionistPage.setSelectedItem(resultset.getString(5));
							textFieldReceptionistUsername_DeleteReceptionistPage.setText(resultset.getString(9));
							passwordFieldReceptionistPassword_DeleteReceptionistPage.setText(resultset.getString(10));
							comboBoxUserType_DeleteReceptionistPage.setSelectedItem(resultset.getString(11));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Receptionist ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Receptionist ID not exist, please enter the right Receptionist ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
			}
		});
		btnSearch_DeleteReceptionistPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_DeleteReceptionistPage.setText("Search");
		btnSearch_DeleteReceptionistPage.setForeground(Color.WHITE);
		btnSearch_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_DeleteReceptionistPage.setFocusable(false);
		btnSearch_DeleteReceptionistPage.setBackground(new Color(102, 51, 153));
		btnSearch_DeleteReceptionistPage.setBounds(66, 84, 180, 35);
		panelReceptionistSearch_DeleteReceptionistPage.add(btnSearch_DeleteReceptionistPage);
		/*End of Search Button DeleteReceptionistPage*/
		
		
		/*Receptionist Search Enter ID Label DeleteReceptionistPage*/
		lblReceptionistSearchEnterID_DeleteReceptionistPage = new JLabel("Enter Receptionist ID");
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setForeground(Color.WHITE);
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setFocusable(false);
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblReceptionistSearchEnterID_DeleteReceptionistPage.setBounds(10, 37, 164, 36);
		panelReceptionistSearch_DeleteReceptionistPage.add(lblReceptionistSearchEnterID_DeleteReceptionistPage);
		/*End of Receptionist Search Enter ID Label DeleteReceptionistPage*/

		
		/*Enter Receptionist ID textField DeleteReceptionistPage*/
		textFieldEnterReceptionistID_DeleteReceptionistPage = new JTextField();
		textFieldEnterReceptionistID_DeleteReceptionistPage.setToolTipText("Receptionist ID");
		textFieldEnterReceptionistID_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterReceptionistID_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterReceptionistID_DeleteReceptionistPage.setColumns(10);
		textFieldEnterReceptionistID_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterReceptionistID_DeleteReceptionistPage.setBounds(186, 37, 111, 36);
		panelReceptionistSearch_DeleteReceptionistPage.add(textFieldEnterReceptionistID_DeleteReceptionistPage);
		/*End of Enter Receptionist ID textField DeleteReceptionistPage*/

		
		
		/*User Type Label DeleteReceptionistPage*/
		lblUserType_DeleteReceptionistPage = new JLabel("User Type");
		lblUserType_DeleteReceptionistPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserType_DeleteReceptionistPage.setForeground(Color.BLACK);
		lblUserType_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUserType_DeleteReceptionistPage.setFocusable(false);
		lblUserType_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUserType_DeleteReceptionistPage.setBounds(10, 394, 148, 36);
		panelCard_DeleteReceptionistPage.add(lblUserType_DeleteReceptionistPage);
		/*End of User Type Label DeleteReceptionistPage*/

		
		/*User Type comboBox DeleteReceptionistPage*/
		comboBoxUserType_DeleteReceptionistPage = new JComboBox();
		comboBoxUserType_DeleteReceptionistPage.setModel(new DefaultComboBoxModel(new String[] {"User Type", "Supervisor", "Receptionist"}));
		comboBoxUserType_DeleteReceptionistPage.setToolTipText("User Type");
		comboBoxUserType_DeleteReceptionistPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxUserType_DeleteReceptionistPage.setFocusable(false);
		comboBoxUserType_DeleteReceptionistPage.setEnabled(false);
		comboBoxUserType_DeleteReceptionistPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxUserType_DeleteReceptionistPage.setBackground(Color.WHITE);
		comboBoxUserType_DeleteReceptionistPage.setBounds(168, 394, 148, 36);
		panelCard_DeleteReceptionistPage.add(comboBoxUserType_DeleteReceptionistPage);
		/*End of User Type comboBox DeleteReceptionistPage*/
		
		
		/*Receptionists Record page Panel*/
		panelCard_ReceptionistsRecordPage = new JPanel();
		panelCard_ReceptionistsRecordPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_ReceptionistsRecordPage();
			}
		});
		panelCard_ReceptionistsRecordPage.setLayout(null);
		panelCard_ReceptionistsRecordPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_ReceptionistsRecordPage, ReceptionistsRecordPagePanel);
		/*End of Receptionists Record page Panel*/

		
		/*Back Button ReceptionistsRecordPage*/
		BtnBack_ReceptionistsRecordPage = new JButton();
		BtnBack_ReceptionistsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Receptionists Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, ReceptionistsMainPagePanel);
				
				//Clear Fields and Refresh Table
				clearButtonReceptionistsRecordPage();
			}
		});
		BtnBack_ReceptionistsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_ReceptionistsRecordPage.setText("Back");
		BtnBack_ReceptionistsRecordPage.setForeground(Color.WHITE);
		BtnBack_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_ReceptionistsRecordPage.setFocusable(false);
		BtnBack_ReceptionistsRecordPage.setBackground(new Color(204, 0, 0));
		BtnBack_ReceptionistsRecordPage.setBounds(221, 437, 105, 35);
		panelCard_ReceptionistsRecordPage.add(BtnBack_ReceptionistsRecordPage);
		/*End of Back Button ReceptionistsRecordPage*/
		
		
		/*Clear Fields Button ReceptionistsRecordPage*/
		BtnClearcField_ReceptionistsRecordPage = new JButton();
		BtnClearcField_ReceptionistsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fileds and Refresh Table
				clearButtonReceptionistsRecordPage();
			}
		});
		BtnClearcField_ReceptionistsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_ReceptionistsRecordPage.setText("Clear");
		BtnClearcField_ReceptionistsRecordPage.setForeground(Color.WHITE);
		BtnClearcField_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_ReceptionistsRecordPage.setFocusable(false);
		BtnClearcField_ReceptionistsRecordPage.setBackground(new Color(46, 139, 87));
		BtnClearcField_ReceptionistsRecordPage.setBounds(336, 437, 105, 35);
		panelCard_ReceptionistsRecordPage.add(BtnClearcField_ReceptionistsRecordPage);
		/*End of Clear Fields Button ReceptionistsRecordPage*/

		
		/*Receptionist ID Label ReceptionistsRecordPage*/
		lblReceptionistID_ReceptionistsRecordPage = new JLabel("Receptionist ID");
		lblReceptionistID_ReceptionistsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistID_ReceptionistsRecordPage.setForeground(Color.BLACK);
		lblReceptionistID_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistID_ReceptionistsRecordPage.setFocusable(false);
		lblReceptionistID_ReceptionistsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblReceptionistID_ReceptionistsRecordPage.setBounds(10, 289, 191, 36);
		panelCard_ReceptionistsRecordPage.add(lblReceptionistID_ReceptionistsRecordPage);
		/*End of Receptionist ID Label ReceptionistsRecordPage*/
		
		
		/*Search Receptionist ID Button ReceptionistsRecordPage*/
		btnSearchReceptionistID_ReceptionistsRecordPage = new JButton("Search Receptionist");
		btnSearchReceptionistID_ReceptionistsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Receptionist By Receptionist ID
				 */
				
								
				//check if Receptionist ID field is empty 
				if(textFieldReceptionistID_ReceptionistsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Receptionist ID"); }
				
				// else continue after "check if Receptionist ID field is empty "
				else          
				{
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=? AND `User_Type`=?");
						preparedatatement.setString(1, textFieldReceptionistID_ReceptionistsRecordPage.getText());
						preparedatatement.setString(2, "Receptionist");
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Receptionist ID correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_ReceptionistsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Receptionist ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Receptionist ID not exist");
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
		btnSearchReceptionistID_ReceptionistsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchReceptionistID_ReceptionistsRecordPage.setForeground(Color.WHITE);
		btnSearchReceptionistID_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearchReceptionistID_ReceptionistsRecordPage.setFocusable(false);
		btnSearchReceptionistID_ReceptionistsRecordPage.setBackground(new Color(102, 51, 153));
		btnSearchReceptionistID_ReceptionistsRecordPage.setBounds(393, 289, 247, 36);
		panelCard_ReceptionistsRecordPage.add(btnSearchReceptionistID_ReceptionistsRecordPage);
		/*End of Search Receptionist ID Button ReceptionistsRecordPage*/

		
		/*scrollPane JScrollPane ReceptionistsRecordPage*/
		scrollPane_ReceptionistsRecordPage = new JScrollPane();
		scrollPane_ReceptionistsRecordPage.setBounds(10, 53, 630, 191);
		panelCard_ReceptionistsRecordPage.add(scrollPane_ReceptionistsRecordPage);
		/*End of scrollPane JScrollPane ReceptionistsRecordPage*/
		
		
		/*table JTable ReceptionistsRecordPage*/
		table_ReceptionistsRecordPage = new JTable();
		table_ReceptionistsRecordPage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_ReceptionistsRecordPage.setViewportView(table_ReceptionistsRecordPage);
		/*End of table JTable ReceptionistsRecordPage*/

		
		/*Receptionist ID textField ReceptionistsRecordPage*/
		textFieldReceptionistID_ReceptionistsRecordPage = new JTextField();
		textFieldReceptionistID_ReceptionistsRecordPage.setToolTipText("Receptionist ID");
		textFieldReceptionistID_ReceptionistsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldReceptionistID_ReceptionistsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldReceptionistID_ReceptionistsRecordPage.setColumns(10);
		textFieldReceptionistID_ReceptionistsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldReceptionistID_ReceptionistsRecordPage.setBounds(211, 289, 171, 36);
		panelCard_ReceptionistsRecordPage.add(textFieldReceptionistID_ReceptionistsRecordPage);
		/*End of Receptionist ID textField ReceptionistsRecordPage*/
		
		
		/*Show All Added Receptionists Button ReceptionistsRecordPage*/
		btnShowAllAddedReceptionists_ReceptionistsRecordPage = new JButton("Show All Added By This Supervisor");
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show All Added Receptionists By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_ReceptionistsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_ReceptionistsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Receptionists added by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Added_By_Supervisor`=? ");
						preparedatatement.setString(1, "Receptionist");
						preparedatatement.setString(2, textFieldSupervisorName_ReceptionistsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Receptionists added by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_ReceptionistsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Receptionists added by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Receptionist Added By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	
				
			}
		});
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setForeground(Color.WHITE);
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setFocusable(false);
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllAddedReceptionists_ReceptionistsRecordPage.setBounds(393, 336, 247, 36);
		panelCard_ReceptionistsRecordPage.add(btnShowAllAddedReceptionists_ReceptionistsRecordPage);
		/*End of Show All Added Receptionists Button ReceptionistsRecordPage*/
		
		
		/*Show All Updated Receptionists Button ReceptionistsRecordPage*/
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage = new JButton("Show All Updated By This Supervisor");
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				/*
				 *     Show All Updated Receptionists By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_ReceptionistsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_ReceptionistsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Receptionists Updated by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Updated_By_Supervisor`=? ");
						preparedatatement.setString(1, "Receptionist");
						preparedatatement.setString(2, textFieldSupervisorName_ReceptionistsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Receptionists Updated by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_ReceptionistsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Receptionists Updated by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Receptionist Updated By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	

			}
		});
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setForeground(Color.WHITE);
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setFocusable(false);
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllUpdatedReceptionists_ReceptionistsRecordPage.setBounds(393, 383, 247, 36);
		panelCard_ReceptionistsRecordPage.add(btnShowAllUpdatedReceptionists_ReceptionistsRecordPage);
		/*End of Show All Updated Receptionists Button ReceptionistsRecordPage*/

		
		/*Receptionists Record Page Label ReceptionistsRecordPage*/
		lblReceptionistsRecordPage_ReceptionistsRecordPage = new JLabel("Receptionists Record Page");
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setForeground(Color.BLACK);
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setFocusable(false);
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblReceptionistsRecordPage_ReceptionistsRecordPage.setBounds(168, 0, 317, 36);
		panelCard_ReceptionistsRecordPage.add(lblReceptionistsRecordPage_ReceptionistsRecordPage);
		/*End of Receptionists Record Page Label ReceptionistsRecordPage*/

		
		/*Supervisor Name Label ReceptionistsRecordPage*/
		lblSupervisorName_ReceptionistsRecordPage = new JLabel("Supervisor Name");
		lblSupervisorName_ReceptionistsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_ReceptionistsRecordPage.setForeground(Color.BLACK);
		lblSupervisorName_ReceptionistsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_ReceptionistsRecordPage.setFocusable(false);
		lblSupervisorName_ReceptionistsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_ReceptionistsRecordPage.setBounds(10, 336, 191, 36);
		panelCard_ReceptionistsRecordPage.add(lblSupervisorName_ReceptionistsRecordPage);
		/*End of Supervisor Name Label ReceptionistsRecordPage*/

		
		/*Supervisor Name textField ReceptionistsRecordPage*/
		textFieldSupervisorName_ReceptionistsRecordPage = new JTextField();
		textFieldSupervisorName_ReceptionistsRecordPage.setToolTipText("Supervisor Name");
		textFieldSupervisorName_ReceptionistsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_ReceptionistsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSupervisorName_ReceptionistsRecordPage.setColumns(10);
		textFieldSupervisorName_ReceptionistsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_ReceptionistsRecordPage.setBounds(211, 336, 171, 36);
		panelCard_ReceptionistsRecordPage.add(textFieldSupervisorName_ReceptionistsRecordPage);
		/*End of Supervisor Name textField ReceptionistsRecordPage*/
		
		
		/*Add Doctor page Panel*/
		panelCard_AddDoctororPage = new JPanel();
		panelCard_AddDoctororPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				//New Doctor ID
				RandomDoctorID();
			}
		});
		panelCard_AddDoctororPage.setLayout(null);
		panelCard_AddDoctororPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_AddDoctororPage, AddDoctorPagePanel);
		/*End of Add Doctor page Panel*/

		
		/*Doctor ID Label AddDoctorPage*/
		lblDoctorID_AddDoctorPage = new JLabel("Doctor ID");
		lblDoctorID_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorID_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorID_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorID_AddDoctorPage.setFocusable(false);
		lblDoctorID_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID_AddDoctorPage.setBounds(10, 61, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorID_AddDoctorPage);
		/*End of Doctor ID Label AddDoctorPage*/

		
		/*Doctor ID 2 Label AddDoctorPage*/
		lblDoctorID2_AddDoctorPage = new JLabel("");
		lblDoctorID2_AddDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorID2_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorID2_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblDoctorID2_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID2_AddDoctorPage.setBackground(new Color(102, 51, 153));
		lblDoctorID2_AddDoctorPage.setBounds(168, 61, 91, 37);
		panelCard_AddDoctororPage.add(lblDoctorID2_AddDoctorPage);
		/*End of Doctor ID 2 Label AddDoctorPage*/

		
		/*New Doctor ID Button AddDoctorPage*/
		BtnNewDoctorID_AddDoctorPage = new JButton();
		BtnNewDoctorID_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnNewDoctorID_AddDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//New Doctor ID
				RandomDoctorID();
			}
		});
		BtnNewDoctorID_AddDoctorPage.setText("New ID");
		BtnNewDoctorID_AddDoctorPage.setForeground(Color.WHITE);
		BtnNewDoctorID_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 13));
		BtnNewDoctorID_AddDoctorPage.setFocusable(false);
		BtnNewDoctorID_AddDoctorPage.setBackground(new Color(102, 51, 153));
		BtnNewDoctorID_AddDoctorPage.setBounds(261, 61, 78, 35);
		panelCard_AddDoctororPage.add(BtnNewDoctorID_AddDoctorPage);
		/*End of New Doctor ID Button AddDoctorPage*/
		
		
		/*Doctor Name Label AddDoctorPage*/
		lblDoctorName_AddDoctorPage = new JLabel("Name");
		lblDoctorName_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorName_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_AddDoctorPage.setFocusable(false);
		lblDoctorName_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_AddDoctorPage.setBounds(10, 108, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorName_AddDoctorPage);
		/*End of Doctor Name Label AddDoctorPage*/

		
		/*Doctor Name textField AddDoctorPage*/
		textFieldDoctorName_AddDoctorPage = new JTextField();
		textFieldDoctorName_AddDoctorPage.setToolTipText("Name");
		textFieldDoctorName_AddDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorName_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorName_AddDoctorPage.setColumns(10);
		textFieldDoctorName_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorName_AddDoctorPage.setBounds(168, 109, 148, 36);
		panelCard_AddDoctororPage.add(textFieldDoctorName_AddDoctorPage);
		/*End of Doctor Name textField AddDoctorPage*/
		
		
		/*Doctor Phone NO Label AddDoctorPage*/
		lblDoctorPhoneNO_AddDoctorPage = new JLabel("Phone NO.");
		lblDoctorPhoneNO_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPhoneNO_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorPhoneNO_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorPhoneNO_AddDoctorPage.setFocusable(false);
		lblDoctorPhoneNO_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorPhoneNO_AddDoctorPage.setBounds(10, 202, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorPhoneNO_AddDoctorPage);
		/*End of Doctor Phone NO Label AddDoctorPage*/

		
		/*Doctor Phone NO textField AddDoctorPage*/
		textFieldDoctorPhoneNO_AddDoctorPage = new JTextField();
		textFieldDoctorPhoneNO_AddDoctorPage.setToolTipText("Phone NO.");
		textFieldDoctorPhoneNO_AddDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorPhoneNO_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorPhoneNO_AddDoctorPage.setColumns(10);
		textFieldDoctorPhoneNO_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorPhoneNO_AddDoctorPage.setBounds(168, 202, 148, 36);
		panelCard_AddDoctororPage.add(textFieldDoctorPhoneNO_AddDoctorPage);
		/*End of Doctor Phone NO textField AddDoctorPage*/
		
		
		/*Doctor Address Label AddDoctorPage*/
		lblDoctorAddress_AddDoctorPage = new JLabel("Address");
		lblDoctorAddress_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorAddress_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorAddress_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorAddress_AddDoctorPage.setFocusable(false);
		lblDoctorAddress_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorAddress_AddDoctorPage.setBounds(10, 253, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorAddress_AddDoctorPage);
		/*End of Doctor Address Label AddDoctorPage*/

		
		/*Doctor Address textField AddDoctorPage*/
		textFieldDoctorAddress_AddDoctorPage = new JTextField();
		textFieldDoctorAddress_AddDoctorPage.setToolTipText("Address");
		textFieldDoctorAddress_AddDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorAddress_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorAddress_AddDoctorPage.setColumns(10);
		textFieldDoctorAddress_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorAddress_AddDoctorPage.setBounds(168, 253, 148, 36);
		panelCard_AddDoctororPage.add(textFieldDoctorAddress_AddDoctorPage);
		/*End of Doctor Address textField AddDoctorPage*/
		
		
		/*Doctor Gender Label AddDoctorPage*/
		lblDoctorGender_AddDoctorPage = new JLabel("Gender");
		lblDoctorGender_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorGender_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorGender_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorGender_AddDoctorPage.setFocusable(false);
		lblDoctorGender_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorGender_AddDoctorPage.setBounds(10, 300, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorGender_AddDoctorPage);
		/*End of Doctor Gender Label AddDoctorPage*/

		
		/*Gender comboBox AddDoctorPage*/
		comboBoxGender_AddDoctorPage = new JComboBox();
		comboBoxGender_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_AddDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_AddDoctorPage.setToolTipText("Gender");
		comboBoxGender_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_AddDoctorPage.setFocusable(false);
		comboBoxGender_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_AddDoctorPage.setBackground(Color.WHITE);
		comboBoxGender_AddDoctorPage.setBounds(168, 300, 148, 36);
		panelCard_AddDoctororPage.add(comboBoxGender_AddDoctorPage);
		/*End of Gender comboBox AddDoctorPage*/
		
		
		/*Doctor Date Of Birth Label AddDoctorPage*/
		lblDoctorDateOfBirth_AddDoctorPage = new JLabel("Date Of Birth");
		lblDoctorDateOfBirth_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorDateOfBirth_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorDateOfBirth_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorDateOfBirth_AddDoctorPage.setFocusable(false);
		lblDoctorDateOfBirth_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorDateOfBirth_AddDoctorPage.setBounds(10, 347, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorDateOfBirth_AddDoctorPage);
		/*End of Doctor Date Of Birth Label AddDoctorPage*/

		
		/*Doctor Date Of Birth JDateChooser AddDoctorPage*/
		DoctorDateOfBirth_AddDoctorPage = new JDateChooser();
		DoctorDateOfBirth_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DoctorDateOfBirth_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		DoctorDateOfBirth_AddDoctorPage.setBounds(168, 347, 148, 36);
		panelCard_AddDoctororPage.add(DoctorDateOfBirth_AddDoctorPage);
		/*End of Doctor Date Of Birth JDateChooser AddDoctorPage*/

		
		/*Back Button AddDoctorPage*/
		backBtn_AddDoctorPage = new JButton();
		backBtn_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_AddDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Doctors Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsMainPagePanel);
				
				//Clear Fields
				clearButtonAddDoctorPage();
			}
		});
		backBtn_AddDoctorPage.setText("Back");
		backBtn_AddDoctorPage.setForeground(Color.WHITE);
		backBtn_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_AddDoctorPage.setFocusable(false);
		backBtn_AddDoctorPage.setBackground(new Color(204, 0, 0));
		backBtn_AddDoctorPage.setBounds(150, 450, 105, 35);
		panelCard_AddDoctororPage.add(backBtn_AddDoctorPage);
		/*End of Back Button AddDoctorPage*/
		
		
		/*Clear Fields Button AddDoctorPage*/
		BtnClearFields_AddDoctorPage = new JButton();
		BtnClearFields_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_AddDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonAddDoctorPage();
				
				//New Doctor ID
				RandomDoctorID();
			}
		});
		BtnClearFields_AddDoctorPage.setText("Clear");
		BtnClearFields_AddDoctorPage.setForeground(Color.WHITE);
		BtnClearFields_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_AddDoctorPage.setFocusable(false);
		BtnClearFields_AddDoctorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_AddDoctorPage.setBounds(265, 450, 105, 35);
		panelCard_AddDoctororPage.add(BtnClearFields_AddDoctorPage);
		/*End of Clear Fields Button AddDoctorPage*/
		
		
		/*Add Doctor Button AddDoctorPage*/
		BtnAddDoctor_AddDoctorPage = new JButton();
		BtnAddDoctor_AddDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				/*
				 *     Add New Doctor
				 */
				
				
				//check if there any empty spaces
				if(lblDoctorID2_AddDoctorPage.getText().isEmpty() || textFieldDoctorName_AddDoctorPage.getText().isEmpty() ||
				   textFieldDoctorLastName_AddDoctorPage.getText().isEmpty() || textFieldDoctorPhoneNO_AddDoctorPage.getText().isEmpty() ||		
				   comboBoxSpecialist_AddDoctorPage.getSelectedIndex()==0 || textFieldDoctorAddress_AddDoctorPage.getText().isEmpty() ||
				   comboBoxGender_AddDoctorPage.getSelectedIndex()==0 || DoctorDateOfBirth_AddDoctorPage.getDate()==null )
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no numbers Entered in Name and Last Name Fields
					if(textFieldDoctorName_AddDoctorPage.getText().contains("0") || textFieldDoctorName_AddDoctorPage.getText().contains("1") ||
					   textFieldDoctorName_AddDoctorPage.getText().contains("2") || textFieldDoctorName_AddDoctorPage.getText().contains("3") ||
					   textFieldDoctorName_AddDoctorPage.getText().contains("4") || textFieldDoctorName_AddDoctorPage.getText().contains("5") ||
					   textFieldDoctorName_AddDoctorPage.getText().contains("6") || textFieldDoctorName_AddDoctorPage.getText().contains("7") ||
					   textFieldDoctorName_AddDoctorPage.getText().contains("8") || textFieldDoctorName_AddDoctorPage.getText().contains("9") ||
					   textFieldDoctorLastName_AddDoctorPage.getText().contains("0") || textFieldDoctorLastName_AddDoctorPage.getText().contains("1") ||
					   textFieldDoctorLastName_AddDoctorPage.getText().contains("2") || textFieldDoctorLastName_AddDoctorPage.getText().contains("3") ||
					   textFieldDoctorLastName_AddDoctorPage.getText().contains("4") || textFieldDoctorLastName_AddDoctorPage.getText().contains("5") ||
					   textFieldDoctorLastName_AddDoctorPage.getText().contains("6") || textFieldDoctorLastName_AddDoctorPage.getText().contains("7") ||
					   textFieldDoctorLastName_AddDoctorPage.getText().contains("8") || textFieldDoctorLastName_AddDoctorPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name fields"); }
					
					//else continue after "check no numbers Entered in Name and Last Name  Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("a") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("b") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("c") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("d") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("e") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("f") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("g") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("h") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("i") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("j") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("k") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("l") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("m") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("n") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("o") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("p") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("q") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("r") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("s") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("t") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("u") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("v") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("w") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("x") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("y") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("z") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("A") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("B") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("C") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("D") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("E") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("F") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("G") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("H") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("I") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("J") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("K") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("L") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("M") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("N") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("O") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("P") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("Q") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("R") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("S") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("T") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("U") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("V") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("W") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("X") ||
								textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("Y") || textFieldDoctorPhoneNO_AddDoctorPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
								
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
							String DofB              = dFormat.format(DoctorDateOfBirth_AddDoctorPage.getDate());
							// End date to string

							// text to integer
							int PhoneNO = Integer.parseInt(textFieldDoctorPhoneNO_AddDoctorPage.getText()); 
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "doctorsDTO" object
							DoctorsDTO doctorsDTO = new DoctorsDTO(); 
							doctorsDTO.setDoctorID(lblDoctorID2_AddDoctorPage.getText());
							doctorsDTO.setName(textFieldDoctorName_AddDoctorPage.getText());
							doctorsDTO.setLast_Name(textFieldDoctorLastName_AddDoctorPage.getText());
							doctorsDTO.setPhone_Number(PhoneNO);
							doctorsDTO.setAddress(textFieldDoctorAddress_AddDoctorPage.getText());
							doctorsDTO.setGender((String) comboBoxGender_AddDoctorPage.getSelectedItem());
							doctorsDTO.setDate_Of_Birth(DofB);
							doctorsDTO.setDoctor_Specialist((String) comboBoxSpecialist_AddDoctorPage.getSelectedItem());
							doctorsDTO.setAdded_By_Supervisor(supervisorName);
							doctorsDTO.setAdded_Date(tDate.format(timer.getTime()));
							doctorsDTO.setAdded_Time(tTime.format(timer.getTime()));
							// End of Set data to "doctorsDTO" object

							// Send data to "addDoctorDAO" method
							new DoctorsDAO().addDoctorDAO(doctorsDTO);
							// End of Send data to "addDoctorDAO" method

							
						}  
					}		
				}
			
			}
		});
		BtnAddDoctor_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnAddDoctor_AddDoctorPage.setText("Add");
		BtnAddDoctor_AddDoctorPage.setForeground(Color.WHITE);
		BtnAddDoctor_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnAddDoctor_AddDoctorPage.setFocusable(false);
		BtnAddDoctor_AddDoctorPage.setBackground(new Color(102, 51, 153));
		BtnAddDoctor_AddDoctorPage.setBounds(380, 450, 105, 35);
		panelCard_AddDoctororPage.add(BtnAddDoctor_AddDoctorPage);
		/*End of Add Doctor Button AddDoctorPage*/
		
		
		/*Doctor Last Name Label AddDoctorPage*/
		lblDoctorLastName_AddDoctorPage = new JLabel("Last Name");
		lblDoctorLastName_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorLastName_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorLastName_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorLastName_AddDoctorPage.setFocusable(false);
		lblDoctorLastName_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorLastName_AddDoctorPage.setBounds(10, 155, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorLastName_AddDoctorPage);
		/*End of Doctor Last Name Label AddDoctorPage*/

		
		/*Doctor Last Name textField AddDoctorPage*/
		textFieldDoctorLastName_AddDoctorPage = new JTextField();
		textFieldDoctorLastName_AddDoctorPage.setToolTipText("Last Name");
		textFieldDoctorLastName_AddDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorLastName_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorLastName_AddDoctorPage.setColumns(10);
		textFieldDoctorLastName_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorLastName_AddDoctorPage.setBounds(168, 156, 148, 36);
		panelCard_AddDoctororPage.add(textFieldDoctorLastName_AddDoctorPage);
		/*End of Doctor Last Name textField AddDoctorPage*/
		
		
		/*Doctor Specialist Label AddDoctorPage*/
		lblDoctorSpecialist_AddDoctorPage = new JLabel("Specialist");
		lblDoctorSpecialist_AddDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSpecialist_AddDoctorPage.setForeground(Color.BLACK);
		lblDoctorSpecialist_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSpecialist_AddDoctorPage.setFocusable(false);
		lblDoctorSpecialist_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorSpecialist_AddDoctorPage.setBounds(334, 107, 148, 36);
		panelCard_AddDoctororPage.add(lblDoctorSpecialist_AddDoctorPage);
		/*End of Doctor Specialist Label AddDoctorPage*/
		
		
		/*separatorVertical JSeparator AddDoctorPage*/
		separatorVertical_AddDoctorPage = new JSeparator();
		separatorVertical_AddDoctorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_AddDoctorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_AddDoctorPage.setBorder(null);
		separatorVertical_AddDoctorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_AddDoctorPage.setBounds(324, 100, 2, 300);
		panelCard_AddDoctororPage.add(separatorVertical_AddDoctorPage);
		/*End of separatorVertical JSeparator AddDoctorPage*/
		
		
		/*Add Doctor Title Label AddDoctorPage*/
		lblAddDoctorTitle_AddDoctororPage = new JLabel("Add Doctor Page");
		lblAddDoctorTitle_AddDoctororPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDoctorTitle_AddDoctororPage.setForeground(Color.BLACK);
		lblAddDoctorTitle_AddDoctororPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblAddDoctorTitle_AddDoctororPage.setFocusable(false);
		lblAddDoctorTitle_AddDoctororPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblAddDoctorTitle_AddDoctororPage.setBounds(168, 0, 317, 36);
		panelCard_AddDoctororPage.add(lblAddDoctorTitle_AddDoctororPage);
		/*End of Add Doctor Title Label AddDoctorPage*/
		
		
		/*Specialist comboBox AddDoctorPage*/
		comboBoxSpecialist_AddDoctorPage = new JComboBox();
		comboBoxSpecialist_AddDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSpecialist_AddDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Specialist", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxSpecialist_AddDoctorPage.setToolTipText("Doctor Specialist");
		comboBoxSpecialist_AddDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxSpecialist_AddDoctorPage.setFocusable(false);
		comboBoxSpecialist_AddDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxSpecialist_AddDoctorPage.setBackground(Color.WHITE);
		comboBoxSpecialist_AddDoctorPage.setBounds(492, 107, 148, 36);
		panelCard_AddDoctororPage.add(comboBoxSpecialist_AddDoctorPage);
		/*End of Specialist comboBox AddDoctorPage*/
		
		
		/*Update Doctor page Panel*/
		panelCard_UpdateDoctorPage = new JPanel();
		panelCard_UpdateDoctorPage.setLayout(null);
		panelCard_UpdateDoctorPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_UpdateDoctorPage, UpdateDoctorPagePanel);
		/*End of Update Doctor page Panel*/

		
		/*Doctor ID Label UpdateDoctorPage*/
		lblDoctorID_UpdateDoctorPage = new JLabel("Doctor ID");
		lblDoctorID_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorID_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorID_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorID_UpdateDoctorPage.setFocusable(false);
		lblDoctorID_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID_UpdateDoctorPage.setBounds(10, 61, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorID_UpdateDoctorPage);
		/*End of Doctor ID Label UpdateDoctorPage*/
		
		
		/*Doctor ID 2 Label UpdateDoctorPage*/
		lblDoctorID2_UpdateDoctorPage = new JLabel("");
		lblDoctorID2_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorID2_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorID2_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblDoctorID2_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID2_UpdateDoctorPage.setBackground(new Color(102, 51, 153));
		lblDoctorID2_UpdateDoctorPage.setBounds(168, 61, 148, 37);
		panelCard_UpdateDoctorPage.add(lblDoctorID2_UpdateDoctorPage);
		/*End of Doctor ID 2 Label UpdateDoctorPage*/
		
		
		/*Doctor Name Label UpdateDoctorPage*/
		lblDoctorName_UpdateDoctorPage = new JLabel("Name");
		lblDoctorName_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorName_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_UpdateDoctorPage.setFocusable(false);
		lblDoctorName_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_UpdateDoctorPage.setBounds(10, 108, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorName_UpdateDoctorPage);
		/*End of Doctor Name Label UpdateDoctorPage*/

		
		/*Doctor Name textField UpdateDoctorPage*/
		textFieldDoctorName_UpdateDoctorPage = new JTextField();
		textFieldDoctorName_UpdateDoctorPage.setToolTipText("Name");
		textFieldDoctorName_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorName_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorName_UpdateDoctorPage.setColumns(10);
		textFieldDoctorName_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorName_UpdateDoctorPage.setBounds(168, 109, 148, 36);
		panelCard_UpdateDoctorPage.add(textFieldDoctorName_UpdateDoctorPage);
		/*End of Doctor Name textField UpdateDoctorPage*/
		
		
		/*Doctor Phone NO Label UpdateDoctorPage*/
		lblDoctorPhoneNO_UpdateDoctorPage = new JLabel("Phone NO.");
		lblDoctorPhoneNO_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPhoneNO_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorPhoneNO_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorPhoneNO_UpdateDoctorPage.setFocusable(false);
		lblDoctorPhoneNO_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorPhoneNO_UpdateDoctorPage.setBounds(10, 202, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorPhoneNO_UpdateDoctorPage);
		/*End of Doctor Phone NO Label UpdateDoctorPage*/

		
		/*Doctor Phone NO textField UpdateDoctorPage*/
		textFieldDoctorPhoneNO_UpdateDoctorPage = new JTextField();
		textFieldDoctorPhoneNO_UpdateDoctorPage.setToolTipText("Phone NO.");
		textFieldDoctorPhoneNO_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorPhoneNO_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorPhoneNO_UpdateDoctorPage.setColumns(10);
		textFieldDoctorPhoneNO_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorPhoneNO_UpdateDoctorPage.setBounds(168, 202, 148, 36);
		panelCard_UpdateDoctorPage.add(textFieldDoctorPhoneNO_UpdateDoctorPage);
		/*End of Doctor Phone NO textField UpdateDoctorPage*/
		
		
		/*Doctor Address Label UpdateDoctorPage*/
		lblDoctorAddress_UpdateDoctorPage = new JLabel("Address");
		lblDoctorAddress_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorAddress_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorAddress_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorAddress_UpdateDoctorPage.setFocusable(false);
		lblDoctorAddress_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorAddress_UpdateDoctorPage.setBounds(10, 253, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorAddress_UpdateDoctorPage);
		/*End of Doctor Address Label UpdateDoctorPage*/

		
		/*Doctor Address textField UpdateDoctorPage*/
		textFieldDoctorAddress_UpdateDoctorPage = new JTextField();
		textFieldDoctorAddress_UpdateDoctorPage.setToolTipText("Address");
		textFieldDoctorAddress_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorAddress_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorAddress_UpdateDoctorPage.setColumns(10);
		textFieldDoctorAddress_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorAddress_UpdateDoctorPage.setBounds(168, 253, 148, 36);
		panelCard_UpdateDoctorPage.add(textFieldDoctorAddress_UpdateDoctorPage);
		/*End of Doctor Address textField UpdateDoctorPage*/
		
		
		/*Doctor Gender Label UpdateDoctorPage*/
		lblDoctorGender_UpdateDoctorPage = new JLabel("Gender");
		lblDoctorGender_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorGender_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorGender_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorGender_UpdateDoctorPage.setFocusable(false);
		lblDoctorGender_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorGender_UpdateDoctorPage.setBounds(10, 300, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorGender_UpdateDoctorPage);
		/*End of Doctor Gender Label UpdateDoctorPage*/
		
		
		/*Gender comboBox UpdateDoctorPage*/
		comboBoxGender_UpdateDoctorPage = new JComboBox();
		comboBoxGender_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxGender_UpdateDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_UpdateDoctorPage.setToolTipText("Gender");
		comboBoxGender_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_UpdateDoctorPage.setFocusable(false);
		comboBoxGender_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_UpdateDoctorPage.setBackground(Color.WHITE);
		comboBoxGender_UpdateDoctorPage.setBounds(168, 300, 148, 36);
		panelCard_UpdateDoctorPage.add(comboBoxGender_UpdateDoctorPage);
		/*End of Gender comboBox UpdateDoctorPage*/
		
		
		/*Doctor Date Of Birth Label UpdateDoctorPage*/
		lblDoctorDateOfBirth_UpdateDoctorPage = new JLabel("Date Of Birth");
		lblDoctorDateOfBirth_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorDateOfBirth_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorDateOfBirth_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorDateOfBirth_UpdateDoctorPage.setFocusable(false);
		lblDoctorDateOfBirth_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorDateOfBirth_UpdateDoctorPage.setBounds(10, 347, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorDateOfBirth_UpdateDoctorPage);
		/*End of Doctor Date Of Birth Label UpdateDoctorPage*/

		
		/*Doctor Date Of Birth JDateChooser UpdateDoctorPage*/
		DoctorDateOfBirth_UpdateDoctorPage = new JDateChooser();
		DoctorDateOfBirth_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DoctorDateOfBirth_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		DoctorDateOfBirth_UpdateDoctorPage.setBounds(168, 347, 148, 36);
		panelCard_UpdateDoctorPage.add(DoctorDateOfBirth_UpdateDoctorPage);
		/*End of Doctor Date Of Birth JDateChooser UpdateDoctorPage*/

		
		/*Back Button UpdateDoctorPage*/
		backBtn_UpdateDoctorPage = new JButton();
		backBtn_UpdateDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Doctors Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsMainPagePanel);
				
				//Clear Fields
				clearButtonUpdateDoctorPage();
			}
		});
		backBtn_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_UpdateDoctorPage.setText("Back");
		backBtn_UpdateDoctorPage.setForeground(Color.WHITE);
		backBtn_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_UpdateDoctorPage.setFocusable(false);
		backBtn_UpdateDoctorPage.setBackground(new Color(204, 0, 0));
		backBtn_UpdateDoctorPage.setBounds(150, 450, 105, 35);
		panelCard_UpdateDoctorPage.add(backBtn_UpdateDoctorPage);
		/*End of Back Button UpdateDoctorPage*/
		
		
		/*Clear Fields Button UpdateDoctorPage*/
		BtnClearFields_UpdateDoctorPage = new JButton();
		BtnClearFields_UpdateDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonUpdateDoctorPage();
			}
		});
		BtnClearFields_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_UpdateDoctorPage.setText("Clear");
		BtnClearFields_UpdateDoctorPage.setForeground(Color.WHITE);
		BtnClearFields_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_UpdateDoctorPage.setFocusable(false);
		BtnClearFields_UpdateDoctorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_UpdateDoctorPage.setBounds(265, 450, 105, 35);
		panelCard_UpdateDoctorPage.add(BtnClearFields_UpdateDoctorPage);
		/*End of Clear Fields Button UpdateDoctorPage*/
		
		
		/*Update Doctor Button UpdateDoctorPage*/
		BtnUpdateDoctor_UpdateDoctorPage = new JButton();
		BtnUpdateDoctor_UpdateDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Update Doctor
				 */
				
				
				//check if there any empty spaces
				if(lblDoctorID2_UpdateDoctorPage.getText().isEmpty() || textFieldDoctorName_UpdateDoctorPage.getText().isEmpty() || 
				   textFieldDoctorPhoneNO_UpdateDoctorPage.getText().isEmpty() || textFieldDoctorAddress_UpdateDoctorPage.getText().isEmpty() ||
				   comboBoxGender_UpdateDoctorPage.getSelectedIndex()==0 || DoctorDateOfBirth_UpdateDoctorPage.getDate()==null ||
				   textFieldDoctorLastName_UpdateDoctorPage.getText().isEmpty() || comboBoxSpecialist_UpdateDoctorPage.getSelectedIndex()==0 )
					
				{ JOptionPane.showMessageDialog(null, "Please fill all fields"); }
				
				//else continue after "check if there any empty spaces"
				else    				
				{
					//check no number Entered in Name and Last Name Fields
					if(textFieldDoctorName_UpdateDoctorPage.getText().contains("0") || textFieldDoctorName_UpdateDoctorPage.getText().contains("1") ||
					   textFieldDoctorName_UpdateDoctorPage.getText().contains("2") || textFieldDoctorName_UpdateDoctorPage.getText().contains("3") ||
					   textFieldDoctorName_UpdateDoctorPage.getText().contains("4") || textFieldDoctorName_UpdateDoctorPage.getText().contains("5") ||
					   textFieldDoctorName_UpdateDoctorPage.getText().contains("6") || textFieldDoctorName_UpdateDoctorPage.getText().contains("7") ||
					   textFieldDoctorName_UpdateDoctorPage.getText().contains("8") || textFieldDoctorName_UpdateDoctorPage.getText().contains("9") ||
					   textFieldDoctorLastName_UpdateDoctorPage.getText().contains("0") || textFieldDoctorLastName_UpdateDoctorPage.getText().contains("1") ||
					   textFieldDoctorLastName_UpdateDoctorPage.getText().contains("2") || textFieldDoctorLastName_UpdateDoctorPage.getText().contains("3") ||
					   textFieldDoctorLastName_UpdateDoctorPage.getText().contains("4") || textFieldDoctorLastName_UpdateDoctorPage.getText().contains("5") ||
					   textFieldDoctorLastName_UpdateDoctorPage.getText().contains("6") || textFieldDoctorLastName_UpdateDoctorPage.getText().contains("7") ||
					   textFieldDoctorLastName_UpdateDoctorPage.getText().contains("8") || textFieldDoctorLastName_UpdateDoctorPage.getText().contains("9"))
					{ JOptionPane.showMessageDialog(null, "Please just enter characters in name and last name field"); }
					
					//else continue after "check no number Entered in Name and Last Name Fields"
					else               
					{
						//check no string Entered in Phone NO. Field
						if((textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("a") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("b") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("c") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("d") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("e") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("f") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("g") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("h") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("i") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("j") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("k") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("l") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("m") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("n") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("o") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("p") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("q") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("r") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("s") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("t") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("u") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("v") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("w") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("x") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("y") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("z") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("A") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("B") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("C") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("D") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("E") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("F") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("G") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("H") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("I") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("J") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("K") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("L") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("M") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("N") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("O") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("P") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("Q") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("R") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("S") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("T") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("U") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("V") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("W") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("X") ||
								textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("Y") || textFieldDoctorPhoneNO_UpdateDoctorPage.getText().contains("Z") ))
						{ JOptionPane.showMessageDialog(null, "Please just enter Numbers in Phone NO field"); }
						
						//else continue after "check no string Entered in Phone NO. Field"
						else          
						{
						
							// date to string
							SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  // date format
							String DofB              = dFormat.format(DoctorDateOfBirth_UpdateDoctorPage.getDate());
							// End date to string
							
							// text to integer
							int PhoneNO = Integer.parseInt(textFieldDoctorPhoneNO_UpdateDoctorPage.getText());   
							// End text to integer
							
							// Current Date & Time
							Calendar timer = Calendar.getInstance();
							timer.getTime();
							SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
							SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
							// end Current Date & Time
							
							// Set data to "doctorsDTO" object
							DoctorsDTO doctorsDTO = new DoctorsDTO();
							doctorsDTO.setDoctorID(lblDoctorID2_UpdateDoctorPage.getText());
							doctorsDTO.setName(textFieldDoctorName_UpdateDoctorPage.getText());
							doctorsDTO.setLast_Name(textFieldDoctorLastName_UpdateDoctorPage.getText());
							doctorsDTO.setPhone_Number(PhoneNO);
							doctorsDTO.setAddress(textFieldDoctorAddress_UpdateDoctorPage.getText());
							doctorsDTO.setGender((String) comboBoxGender_UpdateDoctorPage.getSelectedItem());
							doctorsDTO.setDate_Of_Birth(DofB);
							doctorsDTO.setDoctor_Specialist((String) comboBoxSpecialist_UpdateDoctorPage.getSelectedItem());
							doctorsDTO.setUpdated_By_Supervisor(supervisorName);
							doctorsDTO.setLast_Update_Date(tDate.format(timer.getTime()));
							doctorsDTO.setLast_Update_Time(tTime.format(timer.getTime()));
							// End of Set data to "doctorsDTO" object

							// Send data to "updateDoctorDAO" method
							new DoctorsDAO().updateDoctorDAO(doctorsDTO);
							// End of Send data to "updateDoctorDAO" method
							
						} 
					}	
				}
		
			}
		});
		BtnUpdateDoctor_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUpdateDoctor_UpdateDoctorPage.setText("Update");
		BtnUpdateDoctor_UpdateDoctorPage.setForeground(Color.WHITE);
		BtnUpdateDoctor_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnUpdateDoctor_UpdateDoctorPage.setFocusable(false);
		BtnUpdateDoctor_UpdateDoctorPage.setBackground(new Color(102, 51, 153));
		BtnUpdateDoctor_UpdateDoctorPage.setBounds(380, 450, 105, 35);
		panelCard_UpdateDoctorPage.add(BtnUpdateDoctor_UpdateDoctorPage);
		/*End of Update Doctor Button UpdateDoctorPage*/
		
		
		/*Doctor Last Name Label UpdateDoctorPage*/
		lblDoctorLastName_UpdateDoctorPage = new JLabel("Last Name");
		lblDoctorLastName_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorLastName_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorLastName_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorLastName_UpdateDoctorPage.setFocusable(false);
		lblDoctorLastName_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorLastName_UpdateDoctorPage.setBounds(10, 155, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorLastName_UpdateDoctorPage);
		/*End of Doctor Last Name Label UpdateDoctorPage*/

		
		/*Doctor Last Name textField UpdateDoctorPage*/
		textFieldDoctorLastName_UpdateDoctorPage = new JTextField();
		textFieldDoctorLastName_UpdateDoctorPage.setToolTipText("Last Name");
		textFieldDoctorLastName_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorLastName_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorLastName_UpdateDoctorPage.setColumns(10);
		textFieldDoctorLastName_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorLastName_UpdateDoctorPage.setBounds(168, 156, 148, 36);
		panelCard_UpdateDoctorPage.add(textFieldDoctorLastName_UpdateDoctorPage);
		/*End of Doctor Last Name textField UpdateDoctorPage*/
		
		
		/*separatorVertical JSeparator UpdateDoctorPage*/
		separatorVertical_UpdateDoctorPage = new JSeparator();
		separatorVertical_UpdateDoctorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_UpdateDoctorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_UpdateDoctorPage.setBorder(null);
		separatorVertical_UpdateDoctorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_UpdateDoctorPage.setBounds(324, 59, 2, 330);
		panelCard_UpdateDoctorPage.add(separatorVertical_UpdateDoctorPage);
		/*End of separatorVertical JSeparator UpdateDoctorPage*/
		
		
		/*Update Doctor Title Label UpdateDoctorPage*/
		lblUpdateDoctorTitle_UpdateDoctorPage = new JLabel("Update Doctor Page");
		lblUpdateDoctorTitle_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateDoctorTitle_UpdateDoctorPage.setForeground(Color.BLACK);
		lblUpdateDoctorTitle_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUpdateDoctorTitle_UpdateDoctorPage.setFocusable(false);
		lblUpdateDoctorTitle_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblUpdateDoctorTitle_UpdateDoctorPage.setBounds(168, 0, 317, 36);
		panelCard_UpdateDoctorPage.add(lblUpdateDoctorTitle_UpdateDoctorPage);
		/*End of Update Doctor Title Label UpdateDoctorPage*/

		
		/*Doctor Search Panel UpdateDoctorPage*/
		panelDoctorSearch_UpdateDoctorPage = new JPanel();
		panelDoctorSearch_UpdateDoctorPage.setLayout(null);
		panelDoctorSearch_UpdateDoctorPage.setBackground(new Color(102, 51, 153));
		panelDoctorSearch_UpdateDoctorPage.setBounds(333, 61, 307, 127);
		panelCard_UpdateDoctorPage.add(panelDoctorSearch_UpdateDoctorPage);
		/*End of Doctor Search Panel UpdateDoctorPage*/
		
		
		/*Doctor Search Label UpdateDoctorPage*/
		lblDoctorSearch_UpdateDoctorPage = new JLabel("Search Doctor");
		lblDoctorSearch_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSearch_UpdateDoctorPage.setForeground(Color.WHITE);
		lblDoctorSearch_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSearch_UpdateDoctorPage.setFocusable(false);
		lblDoctorSearch_UpdateDoctorPage.setBorder(null);
		lblDoctorSearch_UpdateDoctorPage.setBounds(10, 0, 287, 36);
		panelDoctorSearch_UpdateDoctorPage.add(lblDoctorSearch_UpdateDoctorPage);
		/*End of Doctor Search Label UpdateDoctorPage*/

		
		/*Search Button UpdateDoctorPage*/
		btnSearch_UpdateDoctorPage = new JButton();
		btnSearch_UpdateDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 *     Search Doctor
				 */
				
								
				//check if enter Doctor ID field is empty 
				if(textFieldDoctorSearchEnterID_UpdateDoctorPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Doctor ID"); }
				
				// else continue after "check if enter Doctor ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
			    		preparedstatement.setString(1, textFieldDoctorSearchEnterID_UpdateDoctorPage.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Doctor ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								DoctorDateOfBirth_UpdateDoctorPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblDoctorID2_UpdateDoctorPage.setText(resultset.getString(2));
							textFieldDoctorName_UpdateDoctorPage.setText(resultset.getString(3));
							textFieldDoctorLastName_UpdateDoctorPage.setText(resultset.getString(4));
							textFieldDoctorPhoneNO_UpdateDoctorPage.setText(phoneNO);
							textFieldDoctorAddress_UpdateDoctorPage.setText(resultset.getString(8));
							comboBoxGender_UpdateDoctorPage.setSelectedItem(resultset.getString(5));
							comboBoxSpecialist_UpdateDoctorPage.setSelectedItem(resultset.getString(9));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Receptionist ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Doctor ID not exist, please enter the right Doctor ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSearch_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_UpdateDoctorPage.setText("Search");
		btnSearch_UpdateDoctorPage.setForeground(Color.WHITE);
		btnSearch_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_UpdateDoctorPage.setFocusable(false);
		btnSearch_UpdateDoctorPage.setBackground(new Color(102, 51, 153));
		btnSearch_UpdateDoctorPage.setBounds(66, 84, 180, 35);
		panelDoctorSearch_UpdateDoctorPage.add(btnSearch_UpdateDoctorPage);
		/*End of Search Button UpdateDoctorPage*/
		
		
		/*Doctor Search Enter ID Label UpdateDoctorPage*/
		lblDoctorSearchEnterID_UpdateDoctorPage = new JLabel("Enter Doctor ID");
		lblDoctorSearchEnterID_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSearchEnterID_UpdateDoctorPage.setForeground(Color.WHITE);
		lblDoctorSearchEnterID_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblDoctorSearchEnterID_UpdateDoctorPage.setFocusable(false);
		lblDoctorSearchEnterID_UpdateDoctorPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblDoctorSearchEnterID_UpdateDoctorPage.setBounds(10, 37, 164, 36);
		panelDoctorSearch_UpdateDoctorPage.add(lblDoctorSearchEnterID_UpdateDoctorPage);
		/*End of Doctor Search Enter ID Label UpdateDoctorPage*/

		
		/*Doctor Search Enter ID textField UpdateDoctorPage*/
		textFieldDoctorSearchEnterID_UpdateDoctorPage = new JTextField();
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setToolTipText("Doctor ID");
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setColumns(10);
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setBounds(186, 37, 111, 36);
		panelDoctorSearch_UpdateDoctorPage.add(textFieldDoctorSearchEnterID_UpdateDoctorPage);
		/*End of Doctor Search Enter ID textField UpdateDoctorPage*/
		
		
		/*Doctor Specialist Label UpdateDoctorPage*/
		lblDoctorSpecialist_UpdateDoctorPage = new JLabel("Specialist");
		lblDoctorSpecialist_UpdateDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSpecialist_UpdateDoctorPage.setForeground(Color.BLACK);
		lblDoctorSpecialist_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSpecialist_UpdateDoctorPage.setFocusable(false);
		lblDoctorSpecialist_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorSpecialist_UpdateDoctorPage.setBounds(10, 394, 148, 36);
		panelCard_UpdateDoctorPage.add(lblDoctorSpecialist_UpdateDoctorPage);
		/*End of Doctor Specialist Label UpdateDoctorPage*/

		
		/*Specialist comboBox UpdateDoctorPage*/
		comboBoxSpecialist_UpdateDoctorPage = new JComboBox();
		comboBoxSpecialist_UpdateDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSpecialist_UpdateDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Specialist", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxSpecialist_UpdateDoctorPage.setToolTipText("Doctor Specialist");
		comboBoxSpecialist_UpdateDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxSpecialist_UpdateDoctorPage.setFocusable(false);
		comboBoxSpecialist_UpdateDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxSpecialist_UpdateDoctorPage.setBackground(Color.WHITE);
		comboBoxSpecialist_UpdateDoctorPage.setBounds(168, 394, 148, 36);
		panelCard_UpdateDoctorPage.add(comboBoxSpecialist_UpdateDoctorPage);
		/*End of Specialist comboBox UpdateDoctorPage*/

		
		/*Delete Doctor page Panel*/
		panelCard_DeleteDoctorPage = new JPanel();
		panelCard_DeleteDoctorPage.setLayout(null);
		panelCard_DeleteDoctorPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_DeleteDoctorPage, DeleteDoctorPagePanel);
		/*End of Delete Doctor page Panel*/

		
		/*Doctor ID Label DeleteDoctorPage*/
		lblDoctorID_DeleteDoctorPage = new JLabel("Doctor ID");
		lblDoctorID_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorID_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorID_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorID_DeleteDoctorPage.setFocusable(false);
		lblDoctorID_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID_DeleteDoctorPage.setBounds(10, 61, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorID_DeleteDoctorPage);
		/*End of Doctor ID Label DeleteDoctorPage*/
		
		
		/*Doctor ID 2 Label DeleteDoctorPage*/
		lblDoctorID2_DeleteDoctorPage = new JLabel("");
		lblDoctorID2_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorID2_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorID2_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		lblDoctorID2_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID2_DeleteDoctorPage.setBackground(new Color(102, 51, 153));
		lblDoctorID2_DeleteDoctorPage.setBounds(168, 61, 148, 37);
		panelCard_DeleteDoctorPage.add(lblDoctorID2_DeleteDoctorPage);
		/*End of Doctor ID 2 Label DeleteDoctorPage*/

		
		/*Doctor Name Label DeleteDoctorPage*/
		lblDoctorName_DeleteDoctorPage = new JLabel("Name");
		lblDoctorName_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorName_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorName_DeleteDoctorPage.setFocusable(false);
		lblDoctorName_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorName_DeleteDoctorPage.setBounds(10, 108, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorName_DeleteDoctorPage);
		/*End of Doctor Name Label DeleteDoctorPage*/

		
		/*Doctor Name textField DeleteDoctotPage*/
		textFieldDoctorName_DeleteDoctorPage = new JTextField();
		textFieldDoctorName_DeleteDoctorPage.setToolTipText("Name");
		textFieldDoctorName_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorName_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorName_DeleteDoctorPage.setEditable(false);
		textFieldDoctorName_DeleteDoctorPage.setColumns(10);
		textFieldDoctorName_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorName_DeleteDoctorPage.setBounds(168, 109, 148, 36);
		panelCard_DeleteDoctorPage.add(textFieldDoctorName_DeleteDoctorPage);
		/*End of Doctor Name textField DeleteDoctotPage*/
		
		
		/*Doctor Phone NO Label DeleteDoctorPage*/
		lblDoctorPhoneNO_DeleteDoctorPage = new JLabel("Phone NO.");
		lblDoctorPhoneNO_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPhoneNO_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorPhoneNO_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorPhoneNO_DeleteDoctorPage.setFocusable(false);
		lblDoctorPhoneNO_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorPhoneNO_DeleteDoctorPage.setBounds(10, 202, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorPhoneNO_DeleteDoctorPage);
		/*End of Doctor Phone NO Label DeleteDoctorPage*/
		
		
		/*Doctor Phone NO textField DeleteDoctotPage*/
		textFieldDoctorPhoneNO_DeleteDoctorPage = new JTextField();
		textFieldDoctorPhoneNO_DeleteDoctorPage.setToolTipText("Phone NO.");
		textFieldDoctorPhoneNO_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorPhoneNO_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorPhoneNO_DeleteDoctorPage.setEditable(false);
		textFieldDoctorPhoneNO_DeleteDoctorPage.setColumns(10);
		textFieldDoctorPhoneNO_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorPhoneNO_DeleteDoctorPage.setBounds(168, 202, 148, 36);
		panelCard_DeleteDoctorPage.add(textFieldDoctorPhoneNO_DeleteDoctorPage);
		/*End of Doctor Phone NO textField DeleteDoctotPage*/
		
		
		/*Doctor Address Label DeleteDoctorPage*/
		lblDoctorAddress_DeleteDoctorPage = new JLabel("Address");
		lblDoctorAddress_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorAddress_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorAddress_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorAddress_DeleteDoctorPage.setFocusable(false);
		lblDoctorAddress_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorAddress_DeleteDoctorPage.setBounds(10, 253, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorAddress_DeleteDoctorPage);
		/*End of Doctor Address Label DeleteDoctorPage*/

		
		/*Doctor Address textField DeleteDoctotPage*/
		textFieldDoctorAddress_DeleteDoctorPage = new JTextField();
		textFieldDoctorAddress_DeleteDoctorPage.setToolTipText("Address");
		textFieldDoctorAddress_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorAddress_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorAddress_DeleteDoctorPage.setEditable(false);
		textFieldDoctorAddress_DeleteDoctorPage.setColumns(10);
		textFieldDoctorAddress_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorAddress_DeleteDoctorPage.setBounds(168, 253, 148, 36);
		panelCard_DeleteDoctorPage.add(textFieldDoctorAddress_DeleteDoctorPage);
		/*End of Doctor Address textField DeleteDoctotPage*/
		
		
		/*Doctor Gender Label DeleteDoctorPage*/
		lblDoctorGender_DeleteDoctorPage = new JLabel("Gender");
		lblDoctorGender_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorGender_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorGender_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorGender_DeleteDoctorPage.setFocusable(false);
		lblDoctorGender_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorGender_DeleteDoctorPage.setBounds(10, 300, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorGender_DeleteDoctorPage);
		/*End of Doctor Gender Label DeleteDoctorPage*/

		
		/*Gender comboBox DeleteDoctotPage*/
		comboBoxGender_DeleteDoctorPage = new JComboBox();
		comboBoxGender_DeleteDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Male", "Female"}));
		comboBoxGender_DeleteDoctorPage.setToolTipText("Gender");
		comboBoxGender_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxGender_DeleteDoctorPage.setFocusable(false);
		comboBoxGender_DeleteDoctorPage.setEnabled(false);
		comboBoxGender_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxGender_DeleteDoctorPage.setBackground(Color.WHITE);
		comboBoxGender_DeleteDoctorPage.setBounds(168, 300, 148, 36);
		panelCard_DeleteDoctorPage.add(comboBoxGender_DeleteDoctorPage);
		/*End of Gender comboBox DeleteDoctotPage*/
		
		
		/*Doctor Date Of Birth Label DeleteDoctorPage*/
		lblDoctorDateOfBirth_DeleteDoctorPage = new JLabel("Date Of Birth");
		lblDoctorDateOfBirth_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorDateOfBirth_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorDateOfBirth_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorDateOfBirth_DeleteDoctorPage.setFocusable(false);
		lblDoctorDateOfBirth_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorDateOfBirth_DeleteDoctorPage.setBounds(10, 347, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorDateOfBirth_DeleteDoctorPage);
		/*End of Doctor Date Of Birth Label DeleteDoctorPage*/

		
		/*Doctor Date Of Birth JDateChooser DeleteDoctorPage*/
		DoctorDateOfBirth_DeleteDoctorPage = new JDateChooser();
		DoctorDateOfBirth_DeleteDoctorPage.setEnabled(false);
		DoctorDateOfBirth_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		DoctorDateOfBirth_DeleteDoctorPage.setBounds(168, 347, 148, 36);
		panelCard_DeleteDoctorPage.add(DoctorDateOfBirth_DeleteDoctorPage);
		/*End of Doctor Date Of Birth JDateChooser DeleteDoctorPage*/

		
		/*Back Button DeleteDoctotPage*/
		backBtn_DeleteDoctorPage = new JButton();
		backBtn_DeleteDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Doctors Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsMainPagePanel);
				
				//Clear Fields
				clearButtonDeleteDoctorPage();
			}
		});
		backBtn_DeleteDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn_DeleteDoctorPage.setText("Back");
		backBtn_DeleteDoctorPage.setForeground(Color.WHITE);
		backBtn_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		backBtn_DeleteDoctorPage.setFocusable(false);
		backBtn_DeleteDoctorPage.setBackground(new Color(204, 0, 0));
		backBtn_DeleteDoctorPage.setBounds(150, 450, 105, 35);
		panelCard_DeleteDoctorPage.add(backBtn_DeleteDoctorPage);
		/*End of Back Button DeleteDoctotPage*/
		
		
		/*Clear Fields Button DeleteDoctotPage*/
		BtnClearFields_DeleteDoctorPage = new JButton();
		BtnClearFields_DeleteDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields
				clearButtonDeleteDoctorPage();
			}
		});
		BtnClearFields_DeleteDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearFields_DeleteDoctorPage.setText("Clear");
		BtnClearFields_DeleteDoctorPage.setForeground(Color.WHITE);
		BtnClearFields_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnClearFields_DeleteDoctorPage.setFocusable(false);
		BtnClearFields_DeleteDoctorPage.setBackground(new Color(46, 139, 87));
		BtnClearFields_DeleteDoctorPage.setBounds(265, 450, 105, 35);
		panelCard_DeleteDoctorPage.add(BtnClearFields_DeleteDoctorPage);
		/*End of Clear Fields Button DeleteDoctotPage*/
		
		
		/*Delete Doctor Button DeleteDoctotPage*/
		BtnDeleteDoctor_DeleteDoctorPage = new JButton();
		BtnDeleteDoctor_DeleteDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Delete Doctor
				 */
				
				//check if enter Doctor ID field is empty
				if(textFieldEnterDoctorID_DeleteDoctorPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter Doctor ID"); }
				
				//else continue after "check if enter Doctor ID field is empty"
				else    				
				{
					// Set data to "doctorsDTO" object
					DoctorsDTO doctorsDTO = new DoctorsDTO();
					doctorsDTO.setDoctorID(textFieldEnterDoctorID_DeleteDoctorPage.getText());
					// End of Set data to "doctorsDTO" object

					
					// Send data to "deleteReceptionistDAO" method
					new DoctorsDAO().deleteDoctorDAO(doctorsDTO);
					// End of Send data to "deleteReceptionistDAO" method

				}
				
			}
		});
		BtnDeleteDoctor_DeleteDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnDeleteDoctor_DeleteDoctorPage.setText("Delete");
		BtnDeleteDoctor_DeleteDoctorPage.setForeground(Color.WHITE);
		BtnDeleteDoctor_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnDeleteDoctor_DeleteDoctorPage.setFocusable(false);
		BtnDeleteDoctor_DeleteDoctorPage.setBackground(new Color(102, 51, 153));
		BtnDeleteDoctor_DeleteDoctorPage.setBounds(380, 450, 105, 35);
		panelCard_DeleteDoctorPage.add(BtnDeleteDoctor_DeleteDoctorPage);
		/*End of Delete Doctor Button DeleteDoctotPage*/
		
		
		/*Doctor Last Name Label DeleteDoctorPage*/
		lblDoctorLastName_DeleteDoctorPage = new JLabel("Last Name");
		lblDoctorLastName_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorLastName_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorLastName_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorLastName_DeleteDoctorPage.setFocusable(false);
		lblDoctorLastName_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorLastName_DeleteDoctorPage.setBounds(10, 155, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorLastName_DeleteDoctorPage);
		/*End of Doctor Last Name Label DeleteDoctorPage*/

		
		/*Doctor Last Name textField DeleteDoctotPage*/
		textFieldDoctorLastName_DeleteDoctorPage = new JTextField();
		textFieldDoctorLastName_DeleteDoctorPage.setToolTipText("Last Name");
		textFieldDoctorLastName_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorLastName_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldDoctorLastName_DeleteDoctorPage.setEditable(false);
		textFieldDoctorLastName_DeleteDoctorPage.setColumns(10);
		textFieldDoctorLastName_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorLastName_DeleteDoctorPage.setBounds(168, 156, 148, 36);
		panelCard_DeleteDoctorPage.add(textFieldDoctorLastName_DeleteDoctorPage);
		/*End of Doctor Last Name textField DeleteDoctotPage*/
		
		
		/*separatorVertical JSeparator DeleteDoctotPage*/
		separatorVertical_DeleteDoctorPage = new JSeparator();
		separatorVertical_DeleteDoctorPage.setOrientation(SwingConstants.VERTICAL);
		separatorVertical_DeleteDoctorPage.setForeground(new Color(216, 191, 216));
		separatorVertical_DeleteDoctorPage.setBorder(null);
		separatorVertical_DeleteDoctorPage.setBackground(new Color(102, 51, 153));
		separatorVertical_DeleteDoctorPage.setBounds(324, 59, 2, 330);
		panelCard_DeleteDoctorPage.add(separatorVertical_DeleteDoctorPage);
		/*End of separatorVertical JSeparator DeleteDoctotPage*/
		
		
		/*Delete Doctor Title Label DeleteDoctorPage*/
		lblDeleteDoctorTitle_DeleteDoctorPage = new JLabel("Delete Doctor Page");
		lblDeleteDoctorTitle_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteDoctorTitle_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDeleteDoctorTitle_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeleteDoctorTitle_DeleteDoctorPage.setFocusable(false);
		lblDeleteDoctorTitle_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDeleteDoctorTitle_DeleteDoctorPage.setBounds(168, 0, 317, 36);
		panelCard_DeleteDoctorPage.add(lblDeleteDoctorTitle_DeleteDoctorPage);
		/*End of Delete Doctor Title Label DeleteDoctorPage*/

		
		/*Doctor Search Panel DeleteDoctotPage*/
		panelDoctorSearch_DeleteDoctorPage = new JPanel();
		panelDoctorSearch_DeleteDoctorPage.setLayout(null);
		panelDoctorSearch_DeleteDoctorPage.setBackground(new Color(102, 51, 153));
		panelDoctorSearch_DeleteDoctorPage.setBounds(333, 61, 307, 127);
		panelCard_DeleteDoctorPage.add(panelDoctorSearch_DeleteDoctorPage);
		/*End of Doctor Search Panel DeleteDoctotPage*/
		
		
		/*Doctor Search Label DeleteDoctorPage*/
		lblDoctorSearch_DeleteDoctorPage = new JLabel("Search Doctor");
		lblDoctorSearch_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSearch_DeleteDoctorPage.setForeground(Color.WHITE);
		lblDoctorSearch_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSearch_DeleteDoctorPage.setFocusable(false);
		lblDoctorSearch_DeleteDoctorPage.setBorder(null);
		lblDoctorSearch_DeleteDoctorPage.setBounds(10, 0, 287, 36);
		panelDoctorSearch_DeleteDoctorPage.add(lblDoctorSearch_DeleteDoctorPage);
		/*End of Doctor Search Label DeleteDoctorPage*/

		
		/*Search Button DeleteDoctotPage*/
		btnSearch_DeleteDoctorPage = new JButton();
		btnSearch_DeleteDoctorPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/*
				 *     Search Doctor
				 */
				
								
				//check if enter Doctor ID field is empty 
				if(textFieldEnterDoctorID_DeleteDoctorPage.getText().isEmpty())	
				{ JOptionPane.showMessageDialog(null, "Please enter Doctor ID"); }
				
				// else continue after "check if enter Doctor ID field is empty "
				else          
				{
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement preparedstatement;
					try
			    	{
			    		preparedstatement = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
			    		preparedstatement.setString(1, textFieldEnterDoctorID_DeleteDoctorPage.getText());
						ResultSet resultset = preparedstatement.executeQuery();
						
						// if Doctor ID correct
						if(resultset.next())
						{
							// Integer to String
							String phoneNO = Integer.toString(resultset.getInt(7));
							// End Integer to String

							
							// get Date 'String' from database and set date to JDatechooser
							String dateofbirth = resultset.getString(6);
							try {
								java.util.Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateofbirth);
								DoctorDateOfBirth_DeleteDoctorPage.setDate(date);

							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
							// End get Date 'String' from database and set date to JDatechooser


							// Set text fields
							lblDoctorID2_DeleteDoctorPage.setText(resultset.getString(2));
							textFieldDoctorName_DeleteDoctorPage.setText(resultset.getString(3));
							textFieldDoctorLastName_DeleteDoctorPage.setText(resultset.getString(4));
							textFieldDoctorPhoneNO_DeleteDoctorPage.setText(phoneNO);
							textFieldDoctorAddress_DeleteDoctorPage.setText(resultset.getString(8));
							comboBoxGender_DeleteDoctorPage.setSelectedItem(resultset.getString(5));
							comboBoxSpecialist_DeleteDoctorPage.setSelectedItem(resultset.getString(9));
							// End of Set text fields

							// Close database
							preparedstatement.close();
						}
						
						// if Receptionist ID incorrect
						else
						{JOptionPane.showMessageDialog(null, "Wrong! Doctor ID not exist, please enter the right Doctor ID");}
						
			    	} 
			    	catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSearch_DeleteDoctorPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch_DeleteDoctorPage.setText("Search");
		btnSearch_DeleteDoctorPage.setForeground(Color.WHITE);
		btnSearch_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch_DeleteDoctorPage.setFocusable(false);
		btnSearch_DeleteDoctorPage.setBackground(new Color(102, 51, 153));
		btnSearch_DeleteDoctorPage.setBounds(66, 84, 180, 35);
		panelDoctorSearch_DeleteDoctorPage.add(btnSearch_DeleteDoctorPage);
		/*End of Search Button DeleteDoctotPage*/
		
		
		/*Doctor Search Enter ID Label DeleteDoctorPage*/
		lblDoctorSearchEnterID_DeleteDoctorPage = new JLabel("Enter Doctor ID");
		lblDoctorSearchEnterID_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSearchEnterID_DeleteDoctorPage.setForeground(Color.WHITE);
		lblDoctorSearchEnterID_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 15));
		lblDoctorSearchEnterID_DeleteDoctorPage.setFocusable(false);
		lblDoctorSearchEnterID_DeleteDoctorPage.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblDoctorSearchEnterID_DeleteDoctorPage.setBounds(10, 37, 164, 36);
		panelDoctorSearch_DeleteDoctorPage.add(lblDoctorSearchEnterID_DeleteDoctorPage);
		/*End of Doctor Search Enter ID Label DeleteDoctorPage*/

		
		/*Enter Doctor ID textField DeleteDoctotPage*/
		textFieldEnterDoctorID_DeleteDoctorPage = new JTextField();
		textFieldEnterDoctorID_DeleteDoctorPage.setToolTipText("Doctor ID");
		textFieldEnterDoctorID_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEnterDoctorID_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldEnterDoctorID_DeleteDoctorPage.setColumns(10);
		textFieldEnterDoctorID_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldEnterDoctorID_DeleteDoctorPage.setBounds(186, 37, 111, 36);
		panelDoctorSearch_DeleteDoctorPage.add(textFieldEnterDoctorID_DeleteDoctorPage);
		/*End of Enter Doctor ID textField DeleteDoctotPage*/
		
		
		/*Doctor Specialist Label DeleteDoctorPage*/
		lblDoctorSpecialist_DeleteDoctorPage = new JLabel("Specialist");
		lblDoctorSpecialist_DeleteDoctorPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSpecialist_DeleteDoctorPage.setForeground(Color.BLACK);
		lblDoctorSpecialist_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSpecialist_DeleteDoctorPage.setFocusable(false);
		lblDoctorSpecialist_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorSpecialist_DeleteDoctorPage.setBounds(10, 394, 148, 36);
		panelCard_DeleteDoctorPage.add(lblDoctorSpecialist_DeleteDoctorPage);
		/*End of Doctor Specialist Label DeleteDoctorPage*/

		
		/*Specialist comboBox DeleteDoctotPage*/
		comboBoxSpecialist_DeleteDoctorPage = new JComboBox();
		comboBoxSpecialist_DeleteDoctorPage.setModel(new DefaultComboBoxModel(new String[] {"Specialist", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxSpecialist_DeleteDoctorPage.setToolTipText("Doctot Specialist");
		comboBoxSpecialist_DeleteDoctorPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxSpecialist_DeleteDoctorPage.setFocusable(false);
		comboBoxSpecialist_DeleteDoctorPage.setEnabled(false);
		comboBoxSpecialist_DeleteDoctorPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxSpecialist_DeleteDoctorPage.setBackground(Color.WHITE);
		comboBoxSpecialist_DeleteDoctorPage.setBounds(168, 394, 148, 36);
		panelCard_DeleteDoctorPage.add(comboBoxSpecialist_DeleteDoctorPage);
		/*End of Specialist comboBox DeleteDoctotPage*/
		
		
		/*Doctors Record page Panel*/
		panelCard_DoctorsRecordPage = new JPanel();
		panelCard_DoctorsRecordPage.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show data from database to table
				ShowDatabaseDataToTable_DoctorsRecordPage();
			}
		});
		panelCard_DoctorsRecordPage.setLayout(null);
		panelCard_DoctorsRecordPage.setBackground(Color.WHITE);
		panelCards.add(panelCard_DoctorsRecordPage, DoctorsRecordPagePanel);
		/*End of Doctors Record page Panel*/
		
		/*Back Button DoctorsRecordPage*/
		BtnBack_DoctorsRecordPage = new JButton();
		BtnBack_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Show Doctors Main Page Panel card when click
				 */
				CardLayout cl = (CardLayout) (panelCards.getLayout());
				cl.show(panelCards, DoctorsMainPagePanel);
				
				//Clear Fields and refresh Table
				clearButtonDoctorsRecordPage();
			}
		});
		BtnBack_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBack_DoctorsRecordPage.setText("Back");
		BtnBack_DoctorsRecordPage.setForeground(Color.WHITE);
		BtnBack_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnBack_DoctorsRecordPage.setFocusable(false);
		BtnBack_DoctorsRecordPage.setBackground(new Color(204, 0, 0));
		BtnBack_DoctorsRecordPage.setBounds(211, 450, 105, 35);
		panelCard_DoctorsRecordPage.add(BtnBack_DoctorsRecordPage);
		/*End of Back Button DoctorsRecordPage*/

		
		/*Clear Field Button DoctorsRecordPage*/
		BtnClearcField_DoctorsRecordPage = new JButton();
		BtnClearcField_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clear Fields and refresh Table
				clearButtonDoctorsRecordPage();
			}
		});
		BtnClearcField_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClearcField_DoctorsRecordPage.setText("Clear");
		BtnClearcField_DoctorsRecordPage.setForeground(Color.WHITE);
		BtnClearcField_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		BtnClearcField_DoctorsRecordPage.setFocusable(false);
		BtnClearcField_DoctorsRecordPage.setBackground(new Color(46, 139, 87));
		BtnClearcField_DoctorsRecordPage.setBounds(326, 450, 105, 35);
		panelCard_DoctorsRecordPage.add(BtnClearcField_DoctorsRecordPage);
		/*End of Clear Field Button DoctorsRecordPage*/

		
		/*Doctor ID Label DoctorsRecordPage*/
		lblDoctorID_DoctorsRecordPage = new JLabel("Doctor ID");
		lblDoctorID_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorID_DoctorsRecordPage.setForeground(Color.BLACK);
		lblDoctorID_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorID_DoctorsRecordPage.setFocusable(false);
		lblDoctorID_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorID_DoctorsRecordPage.setBounds(10, 255, 191, 36);
		panelCard_DoctorsRecordPage.add(lblDoctorID_DoctorsRecordPage);
		/*End of Doctor ID Label DoctorsRecordPage*/
		
		
		/*Search Doctor ID Button DoctorsRecordPage*/
		btnSearchDoctorID_DoctorsRecordPage = new JButton("Search Doctor");
		btnSearchDoctorID_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 *     Search Doctor By Doctor ID
				 */
				
								
				//check if Doctor ID field is empty 
				if(textFieldDoctorID_DoctorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Doctor ID"); }
				
				// else continue after "check if Doctor ID field is empty "
				else          
				{
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
						preparedatatement.setString(1, textFieldDoctorID_DoctorsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if Doctor ID correct
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_DoctorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// if Doctor ID incorrect
						else
						{
							JOptionPane.showMessageDialog(null, "Doctor ID not exist");
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
		btnSearchDoctorID_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchDoctorID_DoctorsRecordPage.setForeground(Color.WHITE);
		btnSearchDoctorID_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearchDoctorID_DoctorsRecordPage.setFocusable(false);
		btnSearchDoctorID_DoctorsRecordPage.setBackground(new Color(102, 51, 153));
		btnSearchDoctorID_DoctorsRecordPage.setBounds(393, 255, 247, 36);
		panelCard_DoctorsRecordPage.add(btnSearchDoctorID_DoctorsRecordPage);
		/*End of Search Doctor ID Button DoctorsRecordPage*/

		
		/*scrollPane JScrollPane DoctorsRecordPage*/
		scrollPane_DoctorsRecordPage = new JScrollPane();
		scrollPane_DoctorsRecordPage.setBounds(10, 53, 630, 191);
		panelCard_DoctorsRecordPage.add(scrollPane_DoctorsRecordPage);
		/*End of scrollPane JScrollPane DoctorsRecordPage*/
		
		
		/*table JTable DoctorsRecordPage*/
		table_DoctorsRecordPage = new JTable();
		table_DoctorsRecordPage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_DoctorsRecordPage.setViewportView(table_DoctorsRecordPage);
		/*End of table JTable DoctorsRecordPage*/
		
		
		/*Doctor ID textField DoctorsRecordPage*/
		textFieldDoctorID_DoctorsRecordPage = new JTextField();
		textFieldDoctorID_DoctorsRecordPage.setToolTipText("Doctor ID");
		textFieldDoctorID_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDoctorID_DoctorsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldDoctorID_DoctorsRecordPage.setColumns(10);
		textFieldDoctorID_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldDoctorID_DoctorsRecordPage.setBounds(211, 255, 171, 36);
		panelCard_DoctorsRecordPage.add(textFieldDoctorID_DoctorsRecordPage);
		/*End of Doctor ID textField DoctorsRecordPage*/
		
		
		/*Show All Added Doctors Button DoctorsRecordPage*/
		btnShowAllAddedDoctors_DoctorsRecordPage = new JButton("Show All Added By This Supervisor");
		btnShowAllAddedDoctors_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show All Added Doctors By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_DoctorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_DoctorsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Doctors added by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Doctors` WHERE `Added_By_Supervisor`=? ");
						preparedatatement.setString(1, textFieldSupervisorName_DoctorsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Doctors added by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_DoctorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Doctors added by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Doctor Added By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	
			
			}
		});
		btnShowAllAddedDoctors_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllAddedDoctors_DoctorsRecordPage.setForeground(Color.WHITE);
		btnShowAllAddedDoctors_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllAddedDoctors_DoctorsRecordPage.setFocusable(false);
		btnShowAllAddedDoctors_DoctorsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllAddedDoctors_DoctorsRecordPage.setBounds(393, 302, 247, 36);
		panelCard_DoctorsRecordPage.add(btnShowAllAddedDoctors_DoctorsRecordPage);
		/*End of Show All Added Doctors Button DoctorsRecordPage*/
		
		
		/*Show All Updated Doctors Button DoctorsRecordPage*/
		btnShowAllUpdatedDoctors_DoctorsRecordPage = new JButton("Show All Updated By This Supervisor");
		btnShowAllUpdatedDoctors_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Show All Updated Doctors By This Supervisor
				 */
				
				//check if Supervisor Name field is empty 
				if(textFieldSupervisorName_DoctorsRecordPage.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Supervisor Name"); }
				
				// else continue after "check if Supervisor Name field is empty "
				else          
				{
					PreparedStatement preparedatatementSupervisorName;
					PreparedStatement preparedatatement;
					try {
						
						//Check if Supervisor Name Exist in Database
						preparedatatementSupervisorName = connection.prepareStatement("SELECT * FROM `Users` WHERE `User_Type`=? AND `Name`=? ");
						preparedatatementSupervisorName.setString(1, "Supervisor");
						preparedatatementSupervisorName.setString(2, textFieldSupervisorName_DoctorsRecordPage.getText());
						ResultSet resultsetSupervisorName = preparedatatementSupervisorName.executeQuery();
						
						//If Supervisor Name Exist in Database
						if(resultsetSupervisorName.next()) 
						{	
						//close database
						preparedatatementSupervisorName.close();
						
						//Check if there are Doctors updated by this supervisor name
						preparedatatement = connection.prepareStatement("SELECT * FROM `Doctors` WHERE `Updated_By_Supervisor`=? ");
						preparedatatement.setString(1, textFieldSupervisorName_DoctorsRecordPage.getText());
						ResultSet resultset = preparedatatement.executeQuery();
					
						//If there are Doctors updated by this supervisor name
						if(resultset.next())
						{	
						ResultSet resaultset1 = preparedatatement.executeQuery();
						table_DoctorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
						//close database
						preparedatatement.close();
						}
						
						//Else if there are No Doctors updated by this supervisor name
						else
						{
							JOptionPane.showMessageDialog(null, "No Doctor Updated By This Supervisor");
							//close database
							preparedatatement.close();
						} 

						}
						
						//Else if Supervisor Name Not Exist in Database
						else
						{
							JOptionPane.showMessageDialog(null, "No Supervisor have this name, Please check Supervisor Name ");
							//close database
							preparedatatementSupervisorName.close();
						}
						
					   } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					   }
				}	
			
			}
		});
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setForeground(Color.WHITE);
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 12));
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setFocusable(false);
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setBackground(new Color(102, 51, 153));
		btnShowAllUpdatedDoctors_DoctorsRecordPage.setBounds(393, 349, 247, 36);
		panelCard_DoctorsRecordPage.add(btnShowAllUpdatedDoctors_DoctorsRecordPage);
		/*End of Show All Updated Doctors Button DoctorsRecordPage*/

		
		/*Doctors Record Page Label DoctorsRecordPage*/
		lblDoctorsRecordPage_DoctorsRecordPage = new JLabel("Doctors Record Page");
		lblDoctorsRecordPage_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorsRecordPage_DoctorsRecordPage.setForeground(Color.BLACK);
		lblDoctorsRecordPage_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorsRecordPage_DoctorsRecordPage.setFocusable(false);
		lblDoctorsRecordPage_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 4, true));
		lblDoctorsRecordPage_DoctorsRecordPage.setBounds(168, 0, 317, 36);
		panelCard_DoctorsRecordPage.add(lblDoctorsRecordPage_DoctorsRecordPage);
		/*End of Doctors Record Page Label DoctorsRecordPage*/

		
		/*Supervisor Name Label DoctorsRecordPage*/
		lblSupervisorName_DoctorsRecordPage = new JLabel("Supervisor Name");
		lblSupervisorName_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName_DoctorsRecordPage.setForeground(Color.BLACK);
		lblSupervisorName_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblSupervisorName_DoctorsRecordPage.setFocusable(false);
		lblSupervisorName_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblSupervisorName_DoctorsRecordPage.setBounds(10, 302, 191, 36);
		panelCard_DoctorsRecordPage.add(lblSupervisorName_DoctorsRecordPage);
		/*End of Supervisor Name Label DoctorsRecordPage*/

		
		/*Supervisor Name textField DoctorsRecordPage*/
		textFieldSupervisorName_DoctorsRecordPage = new JTextField();
		textFieldSupervisorName_DoctorsRecordPage.setToolTipText("Supervisor Name");
		textFieldSupervisorName_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSupervisorName_DoctorsRecordPage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSupervisorName_DoctorsRecordPage.setColumns(10);
		textFieldSupervisorName_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldSupervisorName_DoctorsRecordPage.setBounds(211, 302, 171, 36);
		panelCard_DoctorsRecordPage.add(textFieldSupervisorName_DoctorsRecordPage);
		/*End of Supervisor Name textField DoctorsRecordPage*/
		
		
		/*Search Specialist Button DoctorsRecordPage*/
		btnSearchSpecialist_DoctorsRecordPage = new JButton("Search Specialist");
		btnSearchSpecialist_DoctorsRecordPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				/*
				 *     Search Doctor By Doctor Specialist
				 */
				
								
				//check if Doctor Specialist field is empty 
				if(comboBoxSpecialist_DoctorsRecordPage.getSelectedIndex()==0)
					
				{ JOptionPane.showMessageDialog(null, "Pleae enter Doctor Specialist"); }
				
				// else continue after "check if Doctor Specialist field is empty "
				else          
				{
					
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Doctors` WHERE `Doctor_Specialist`=?");
						preparedatatement.setString(1, (String) comboBoxSpecialist_DoctorsRecordPage.getSelectedItem());
						ResultSet resultset = preparedatatement.executeQuery();
						
						// if there is doctor have this specialist 
						if(resultset.next())
						{
							ResultSet resaultset1 = preparedatatement.executeQuery();
							table_DoctorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset1));	
							// close database
							preparedatatement.close();
							
						}
						
						// else if no doctor have this specialist 
						else
						{
							JOptionPane.showMessageDialog(null, "No Doctor have this specialist");
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
		btnSearchSpecialist_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchSpecialist_DoctorsRecordPage.setForeground(Color.WHITE);
		btnSearchSpecialist_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		btnSearchSpecialist_DoctorsRecordPage.setFocusable(false);
		btnSearchSpecialist_DoctorsRecordPage.setBackground(new Color(102, 51, 153));
		btnSearchSpecialist_DoctorsRecordPage.setBounds(393, 396, 247, 36);
		panelCard_DoctorsRecordPage.add(btnSearchSpecialist_DoctorsRecordPage);
		/*End of Search Specialist Button DoctorsRecordPage*/
		
		
		/*Doctor Specialist Label DoctorsRecordPage*/
		lblDoctorSpecialist_DoctorsRecordPage = new JLabel("Specialist");
		lblDoctorSpecialist_DoctorsRecordPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorSpecialist_DoctorsRecordPage.setForeground(Color.BLACK);
		lblDoctorSpecialist_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDoctorSpecialist_DoctorsRecordPage.setFocusable(false);
		lblDoctorSpecialist_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDoctorSpecialist_DoctorsRecordPage.setBounds(10, 349, 191, 36);
		panelCard_DoctorsRecordPage.add(lblDoctorSpecialist_DoctorsRecordPage);
		/*End of Doctor Specialist Label DoctorsRecordPage*/
		
		
		/*Specialist comboBox DoctorsRecordPage*/
		comboBoxSpecialist_DoctorsRecordPage = new JComboBox();
		comboBoxSpecialist_DoctorsRecordPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSpecialist_DoctorsRecordPage.setModel(new DefaultComboBoxModel(new String[] {"Specialist", "X-Ray", "Dental Cleanings", "Fillings", "Root Canals", "Extractions", "Whitening", "Placement ", "Restoration", "Crowns", "Bridges"}));
		comboBoxSpecialist_DoctorsRecordPage.setToolTipText("Doctor Specialist");
		comboBoxSpecialist_DoctorsRecordPage.setFont(new Font("Kartika", Font.BOLD, 16));
		comboBoxSpecialist_DoctorsRecordPage.setFocusable(false);
		comboBoxSpecialist_DoctorsRecordPage.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		comboBoxSpecialist_DoctorsRecordPage.setBackground(Color.WHITE);
		comboBoxSpecialist_DoctorsRecordPage.setBounds(210, 349, 171, 36);
		panelCard_DoctorsRecordPage.add(comboBoxSpecialist_DoctorsRecordPage);
		/*End of Specialist comboBox DoctorsRecordPage*/


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
	 * *****************************************
	 *   Random number for Supervisor ID Method
	 * *****************************************
	 */
	public static void RandomSupervisorID()
	{
		Random random = new Random();
		lblSupervisorID2_AddSupervisorPage.setText("SID"+ random.nextInt(100000+1));
		
	}
	 /*
     * ************************************************
     *   End of Random number for Supervisor ID Method
     * ************************************************
     */
	
	
	
	 /*
      * *******************************************
   	  *   Random number for Receptionist ID Method
	  * *******************************************
	  */
		public static void RandomReceptionistID()
		{
			Random random = new Random();
			lblReceptionistID2_AddReceptionistPage.setText("RID"+ random.nextInt(100000+1));
			
		}
	 /*
	  * **************************************************
	  *   End of Random number for Receptionist ID Method
	  * **************************************************
	  */	
	
	
	
	 /*
	  * **************************************
	  *   Random number for Doctor ID Method
	  * **************************************
	  */
	 public static void RandomDoctorID()
	 {
		Random random = new Random();
		lblDoctorID2_AddDoctorPage.setText("DID"+ random.nextInt(100000+1));
				
	 }
	/*
	 * *********************************************
	 *   End of Random number for Doctor ID Method
	 * *********************************************
	 */	
		

			
	/*
	 * ***********************************************
	 *   Clear All Fields in AddSupervisorPage method 
	 * ***********************************************
	 */
	private void clearButtonAddSupervisorPage()
	{
		textFieldSupervisorName_AddSupervisorPage.setText(null);
		textFieldSupervisorLastName_AddSupervisorPage.setText(null);
		textFieldSupervisorAddress_AddSupervisorPage.setText(null);
		textFieldSupervisorPhoneNO_AddSupervisorPage.setText(null);
		textFieldSupervisorUsername_AddSupervisorPage.setText(null);
		passwordFieldPassword_AddSupervisorPage.setText(null);
		passwordFieldPassword_AddSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		passwordFieldRePassword_AddSupervisorPage.setText(null);
		passwordFieldRePassword_AddSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_AddSupervisorPage.setSelectedIndex(0);
		SupervisorDateOfBirth_AddSupervisorPage.setDate(null);
		BtnShowPassword_AddSupervisorPage.setText("Show");
	}
	/*
	 * *****************************************************
	 *  End of Clear All Fields in AddSupervisorPage Method
	 * *****************************************************
	 */
	
	
	
	/*
	 * *************************************************
	 *   Clear All Fields in UpdateSupervisorPage method 
	 * **************************************************
	 */
	private void clearButtonUpdateSupervisorPage()
	{
		lblSupervisorID2_UpdateSupervisorPage.setText(null);
		textFieldSupervisorName_UpdateSupervisorPage.setText(null);
		textFieldSupervisorLastName_UpdateSupervisorPage.setText(null);
		textFieldSupervisorAddress_UpdateSupervisorPage.setText(null);
		textFieldSupervisorPhoneNO_UpdateSupervisorPage.setText(null);
		textFieldSupervisorUsername_UpdateSupervisorPage.setText(null);
		textFieldEnterSupervisorID_UpdateSupervisorPage.setText(null);
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setText(null);
		passwordFieldSupervisorPassword_UpdateSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setText(null);
		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_UpdateSupervisorPage.setSelectedIndex(0);
		comboBoxUserType_UpdateSupervisorPage.setSelectedIndex(0);
		SupervisorDateOfBirth_UpdateSupervisorPage.setDate(null);
		BtnShowPassword_UpdateSupervisorPage.setText("Show");
	}
	/*
	 * ********************************************************
	 *  End of Clear All Fields in UpdateSupervisorPage Method
	 * ********************************************************
	 */
	
	
	
	/*
	 * *************************************************
	 *   Clear All Fields in DeleteSupervisorPage method 
	 * **************************************************
	 */
	private void clearButtonDeleteSupervisorPage()
	{
		lblSupervisorID2_DeleteSupervisorPage.setText(null);
		textFieldSupervisorName_DeleteSupervisorPage.setText(null);
		textFieldSupervisorLastName_DeleteSupervisorPage.setText(null);
		textFieldSupervisorAddress_DeleteSupervisorPage.setText(null);
		textFieldSupervisorPhoneNO_DeleteSupervisorPage.setText(null);
		textFieldSupervisorUsername_DeleteSupervisorPage.setText(null);
		textFieldEnterSupervisorID_DeleteSupervisorPage.setText(null);
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setText(null);
		passwordFieldSupervisorPassword_DeleteSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_DeleteSupervisorPage.setSelectedIndex(0);
		comboBoxUserType_DeleteSupervisorPage.setSelectedIndex(0);
		SupervisorDateOfBirth_DeleteSupervisorPage.setDate(null);
	}
	/*
	 * ********************************************************
	 *  End of Clear All Fields in DeleteSupervisorPage Method
	 * ********************************************************
	 */
	
	
	
	/*
	 * *************************************************
	 *   Clear All Fields in SupervisorsRecordPage method 
	 * **************************************************
	 */
	private void clearButtonSupervisorsRecordPage()
	{
		textFieldSupervisorID_SupervisorsRecordPage.setText(null);
		textFieldSupervisorName_SupervisorsRecordPage.setText(null);
		ShowDatabaseDataToTable_SupervisorsRecordPage();
	}
	/*
	 * ********************************************************
	 *  End of Clear All Fields in SupervisorsRecordPage Method
	 * ********************************************************
	 */
	
	
	
	/*
	 * *************************************************
	 *   Clear All Fields in AddReceptionistPage method 
	 * *************************************************
	 */
	private void clearButtonAddReceptionistPage()
	{
		textFieldReceptionistName_AddReceptionistPage.setText(null);
		textFieldReceptionistLastName_AddReceptionistPage.setText(null);
		textFieldReceptionistAddress_AddReceptionistPage.setText(null);
		textFieldReceptionistPhoneNO_AddReceptionistPage.setText(null);
		textFieldReceptionistUsername_AddReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_AddReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_AddReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		passwordFieldReceptionistRePassword_AddReceptionistPage.setText(null);
		passwordFieldReceptionistRePassword_AddReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_AddReceptionistPage.setSelectedIndex(0);
		ReceptionistDateOfBirth_AddReceptionistPage.setDate(null);
		BtnShowPassword_AddReceptionistPage.setText("Show");
	}
	/*
	 * *******************************************************
	 *  End of Clear All Fields in AddReceptionistPage Method
	 * *******************************************************
	 */
	
	
	
	/*
	 * ****************************************************
	 *   Clear All Fields in UpdateReceptionistPage method 
	 * ****************************************************
	 */
	private void clearButtonUpdateReceptionistPage()
	{
		lblReceptionistID2_UpdateReceptionistPage.setText(null);
		textFieldReceptionistName_UpdateReceptionistPage.setText(null);
		textFieldReceptionistLastName_UpdateReceptionistPage.setText(null);
		textFieldReceptionistAddress_UpdateReceptionistPage.setText(null);
		textFieldReceptionistPhoneNO_UpdateReceptionistPage.setText(null);
		textFieldReceptionistUsername_UpdateReceptionistPage.setText(null);
		textFieldEnterReceptionistID_UpdateReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_UpdateReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setText(null);
		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_UpdateReceptionistPage.setSelectedIndex(0);
		comboBoxUserType_UpdateReceptionistPage.setSelectedIndex(0);
		ReceptionistDateOfBirth_UpdateReceptionistPage.setDate(null);
		BtnShowPassword_UpdateReceptionistPage.setText("Show");
	}
	/*
	 * **********************************************************
	 *  End of Clear All Fields in UpdateReceptionistPage Method
	 * **********************************************************
	 */
	
	
	
	/*
	 * ****************************************************
	 *   Clear All Fields in DeleteReceptionistPage method 
	 * ****************************************************
	 */
	private void clearButtonDeleteReceptionistPage()
	{
		lblReceptionistID2_DeleteReceptionistPage.setText(null);
		textFieldReceptionistName_DeleteReceptionistPage.setText(null);
		textFieldReceptionistLastName_DeleteReceptionistPage.setText(null);
		textFieldReceptionistAddress_DeleteReceptionistPage.setText(null);
		textFieldReceptionistPhoneNO_DeleteReceptionistPage.setText(null);
		textFieldReceptionistUsername_DeleteReceptionistPage.setText(null);
		textFieldEnterReceptionistID_DeleteReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setText(null);
		passwordFieldReceptionistPassword_DeleteReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
		comboBoxGender_DeleteReceptionistPage.setSelectedIndex(0);
		comboBoxUserType_DeleteReceptionistPage.setSelectedIndex(0);
		ReceptionistDateOfBirth_DeleteReceptionistPage.setDate(null);
	}
	/*
	 * **********************************************************
	 *  End of Clear All Fields in DeleteReceptionistPage Method
	 * **********************************************************
	 */
	
	
	
	/*
	 * *****************************************************
	 *   Clear All Fields in ReceptionistsRecordPage method 
	 * *****************************************************
	 */
	private void clearButtonReceptionistsRecordPage()
	{
		textFieldReceptionistID_ReceptionistsRecordPage.setText(null);
		textFieldSupervisorName_ReceptionistsRecordPage.setText(null);
		ShowDatabaseDataToTable_ReceptionistsRecordPage();
	}
	/*
	 * ***********************************************************
	 *  End of Clear All Fields in ReceptionistsRecordPage Method
	 * ***********************************************************
	 */
	
	
	
	/*
	 * *********************************************
	 *   Clear All Fields in AddDoctorPage method 
	 * *********************************************
	 */
	private void clearButtonAddDoctorPage()
	{
		textFieldDoctorName_AddDoctorPage.setText(null);
		textFieldDoctorLastName_AddDoctorPage.setText(null);
		textFieldDoctorAddress_AddDoctorPage.setText(null);
		textFieldDoctorPhoneNO_AddDoctorPage.setText(null);
		comboBoxGender_AddDoctorPage.setSelectedIndex(0);
		comboBoxSpecialist_AddDoctorPage.setSelectedIndex(0);
		DoctorDateOfBirth_AddDoctorPage.setDate(null);
	}
	/*
	 * ***************************************************
	 *  End of Clear All Fields in UpdateDoctorPage Method
	 * ***************************************************
	 */
	
	
	
	/*
	 * *********************************************
	 *   Clear All Fields in UpdateDoctorPage method 
	 * *********************************************
	 */
	private void clearButtonUpdateDoctorPage()
	{
		textFieldDoctorName_UpdateDoctorPage.setText(null);
		textFieldDoctorLastName_UpdateDoctorPage.setText(null);
		textFieldDoctorAddress_UpdateDoctorPage.setText(null);
		textFieldDoctorPhoneNO_UpdateDoctorPage.setText(null);
		textFieldDoctorSearchEnterID_UpdateDoctorPage.setText(null);
		lblDoctorID2_UpdateDoctorPage.setText(null);
		comboBoxGender_UpdateDoctorPage.setSelectedIndex(0);
		comboBoxSpecialist_UpdateDoctorPage.setSelectedIndex(0);
		DoctorDateOfBirth_UpdateDoctorPage.setDate(null);
	}
	/*
	 * ***************************************************
	 *  End of Clear All Fields in UpdateDoctorPage Method
	 * ***************************************************
	 */
	
	
	
	/*
	 * *********************************************
	 *   Clear All Fields in DeleteDoctorPage method 
	 * *********************************************
	 */
	private void clearButtonDeleteDoctorPage()
	{
		textFieldDoctorName_DeleteDoctorPage.setText(null);
		textFieldDoctorLastName_DeleteDoctorPage.setText(null);
		textFieldDoctorAddress_DeleteDoctorPage.setText(null);
		textFieldDoctorPhoneNO_DeleteDoctorPage.setText(null);
		textFieldEnterDoctorID_DeleteDoctorPage.setText(null);
		lblDoctorID2_DeleteDoctorPage.setText(null);
		comboBoxGender_DeleteDoctorPage.setSelectedIndex(0);
		comboBoxSpecialist_DeleteDoctorPage.setSelectedIndex(0);
		DoctorDateOfBirth_DeleteDoctorPage.setDate(null);
	}
	/*
	 * ***************************************************
	 *  End of Clear All Fields in DeleteDoctorPage Method
	 * ***************************************************
	 */
	
	
	
	/*
	 * *****************************************************
	 *   Clear All Fields in DoctorsRecordPage method 
	 * *****************************************************
	 */
	private void clearButtonDoctorsRecordPage()
	{
		textFieldDoctorID_DoctorsRecordPage.setText(null);
		textFieldSupervisorName_DoctorsRecordPage.setText(null);
		comboBoxSpecialist_DoctorsRecordPage.setSelectedIndex(0);
		ShowDatabaseDataToTable_DoctorsRecordPage();
	}
	/*
	 * ***********************************************************
	 *  End of Clear All Fields in DoctorsRecordPage Method
	 * ***********************************************************
	 */
	
	
	
	/*
	 * *********************************************************
	 *   Show and Hide Password Button AddSupervisorPage Method
	 * *********************************************************
	 */
	private void ShowAndHidePasswordButton_AddSupervisorPage()
	{
    	if(BtnShowPassword_AddSupervisorPage.getText().equals("Show"))
    	{
    		passwordFieldPassword_AddSupervisorPage.setEchoChar('\u0000');
    		passwordFieldRePassword_AddSupervisorPage.setEchoChar('\u0000');
    		BtnShowPassword_AddSupervisorPage.setText("Hide");
    	}
    	else
    	{
    		passwordFieldPassword_AddSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		passwordFieldRePassword_AddSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		BtnShowPassword_AddSupervisorPage.setText("Show");
    	}
	}
	/*
	 * ***************************************************************
	 *  End of Show and Hide Password Button AddSupervisorPage Method
	 * ***************************************************************
	 */
	
	
	
	/*
	 * ************************************************************
	 *   Show and Hide Password Button UpdateSupervisorPage Method
	 * ************************************************************
	 */
	private void ShowAndHidePasswordButton_UpdateSupervisorPage()
	{
    	if(BtnShowPassword_UpdateSupervisorPage.getText().equals("Show"))
    	{
    		passwordFieldSupervisorPassword_UpdateSupervisorPage.setEchoChar('\u0000');
    		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setEchoChar('\u0000');
    		BtnShowPassword_UpdateSupervisorPage.setText("Hide");
    	}
    	else
    	{
    		passwordFieldSupervisorPassword_UpdateSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		passwordFieldSupervisorRePassword_UpdateSupervisorPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		BtnShowPassword_UpdateSupervisorPage.setText("Show");
    	}
	}
	/*
	 * *****************************************************************
	 * End of Show and Hide Password Button UpdateSupervisorPage Method
	 * *****************************************************************
	 */
	
	
	
	/*
	 * ***********************************************************
	 *   Show and Hide Password Button AddReceptionistPage Method
	 * ***********************************************************
	 */
	private void ShowAndHidePasswordButton_AddReceptionistPage()
	{
    	if(BtnShowPassword_AddReceptionistPage.getText().equals("Show"))
    	{
    		passwordFieldReceptionistPassword_AddReceptionistPage.setEchoChar('\u0000');
    		passwordFieldReceptionistRePassword_AddReceptionistPage.setEchoChar('\u0000');
    		BtnShowPassword_AddReceptionistPage.setText("Hide");
    	}
    	else
    	{
    		passwordFieldReceptionistPassword_AddReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		passwordFieldReceptionistRePassword_AddReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		BtnShowPassword_AddReceptionistPage.setText("Show");
    	}
	}
	/*
	 * *****************************************************************
	 *  End of Show and Hide Password Button AddReceptionistPage Method
	 * *****************************************************************
	 */
	
	
	
	/*
	 * **************************************************************
	 *   Show and Hide Password Button UpdateReceptionistPage Method
	 * **************************************************************
	 */
	private void ShowAndHidePasswordButton_UpdateReceptionistPage()
	{
    	if(BtnShowPassword_UpdateReceptionistPage.getText().equals("Show"))
    	{
    		passwordFieldReceptionistPassword_UpdateReceptionistPage.setEchoChar('\u0000');
    		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setEchoChar('\u0000');
    		BtnShowPassword_UpdateReceptionistPage.setText("Hide");
    	}
    	else
    	{
    		passwordFieldReceptionistPassword_UpdateReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		passwordFieldReceptionistRePassword_UpdateReceptionistPage.setEchoChar((Character)UIManager.get("PasswordField.echoChar"));
    		BtnShowPassword_UpdateReceptionistPage.setText("Show");
    	}
	}
	/*
	 * *******************************************************************
	 * End of Show and Hide Password Button UpdateReceptionistPage Method
	 * *******************************************************************
	 */
	
	
	
	/*
	 * *************************************************************
	 *     Show data from database on table _ SupervisorsRecordPage
	 * *************************************************************
	 */
		
		public static void ShowDatabaseDataToTable_SupervisorsRecordPage()
		{
			 
			try {
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Users` WHERE User_Type = ?");
				preparedStatement.setString(1, "Supervisor");
				ResultSet resaultset = preparedStatement.executeQuery();

				table_SupervisorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset));
				table_SupervisorsRecordPage.getColumnModel().getColumn(0).setPreferredWidth(20);
				table_SupervisorsRecordPage.getColumnModel().getColumn(1).setPreferredWidth(130);
				table_SupervisorsRecordPage.getColumnModel().getColumn(2).setPreferredWidth(80);
				table_SupervisorsRecordPage.getColumnModel().getColumn(3).setPreferredWidth(100);
				table_SupervisorsRecordPage.getColumnModel().getColumn(4).setPreferredWidth(80);
				table_SupervisorsRecordPage.getColumnModel().getColumn(5).setPreferredWidth(100);
				table_SupervisorsRecordPage.getColumnModel().getColumn(6).setPreferredWidth(120);
				table_SupervisorsRecordPage.getColumnModel().getColumn(7).setPreferredWidth(80);
				table_SupervisorsRecordPage.getColumnModel().getColumn(8).setPreferredWidth(130);
				
				// close database
				preparedStatement.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		/*
		 * ****************************************************************
		 * End of Show data from database on table _ SupervisorsRecordPage
		 * ****************************************************************
		 */
		
		
		
		/*
		 * ***************************************************************
		 *     Show data from database on table _ ReceptionistsRecordPage
		 * ***************************************************************
		 */
			
			public static void ShowDatabaseDataToTable_ReceptionistsRecordPage()
			{
				 
				try {
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Users` WHERE User_Type = ?");
					preparedStatement.setString(1, "Receptionist");
					ResultSet resaultset = preparedStatement.executeQuery();

					table_ReceptionistsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset));
					table_ReceptionistsRecordPage.getColumnModel().getColumn(0).setPreferredWidth(20);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(1).setPreferredWidth(130);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(2).setPreferredWidth(80);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(3).setPreferredWidth(100);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(4).setPreferredWidth(80);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(5).setPreferredWidth(100);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(6).setPreferredWidth(120);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(7).setPreferredWidth(80);
					table_ReceptionistsRecordPage.getColumnModel().getColumn(8).setPreferredWidth(130);
					
					// close database
					preparedStatement.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			/*
			 * *****************************************************************
			 * End of Show data from database on table _ ReceptionistsRecordPage
			 * *****************************************************************
			 */
		
			
			
			/*
			 * ***************************************************************
			 *     Show data from database on table _ DoctorsRecordPage
			 * ***************************************************************
			 */
				
				public static void ShowDatabaseDataToTable_DoctorsRecordPage()
				{
					 
					try {
						
						connection = ConnectionFactory.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Doctors`");
						ResultSet resaultset = preparedStatement.executeQuery();

						table_DoctorsRecordPage.setModel(DbUtils.resultSetToTableModel(resaultset));
						table_DoctorsRecordPage.getColumnModel().getColumn(0).setPreferredWidth(20);
						table_DoctorsRecordPage.getColumnModel().getColumn(1).setPreferredWidth(130);
						table_DoctorsRecordPage.getColumnModel().getColumn(2).setPreferredWidth(80);
						table_DoctorsRecordPage.getColumnModel().getColumn(3).setPreferredWidth(100);
						table_DoctorsRecordPage.getColumnModel().getColumn(4).setPreferredWidth(80);
						table_DoctorsRecordPage.getColumnModel().getColumn(5).setPreferredWidth(100);
						table_DoctorsRecordPage.getColumnModel().getColumn(6).setPreferredWidth(120);
						table_DoctorsRecordPage.getColumnModel().getColumn(7).setPreferredWidth(80);
						table_DoctorsRecordPage.getColumnModel().getColumn(8).setPreferredWidth(130);
						
						// close database
						preparedStatement.close();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				/*
				 * *****************************************************************
				 * End of Show data from database on table _ DoctorsRecordPage
				 * *****************************************************************
				 */
}
