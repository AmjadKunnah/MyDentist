package mydentisten.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import mydentisten.database.ConnectionFactory;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

/**
*
* @author amjad azim
*/

public class Supervisors_PatientsPage extends JInternalFrame {
	
	
	/*Variables*/
	
	//JLabel
	private JLabel lblPatientSearch__PatientRecordPanel;
	private JLabel lblPatientSearchEnterID__PatientRecordPanel;
	
	//JButton
	private JButton btnSearch__PatientRecordPanel;
	private JButton BtnEmptyField_PatientRecordPanel;
	
	//JTextField
	private JTextField textFieldPatientID;
	
	//JTable
	private static JTable table;
	
	//JScrollPane
	private JScrollPane scrollPane_PatientRecordPanel;
	
	/*End of Variables*/
	
	
	
	/*Panels*/
	private JPanel panelPatientSearch_PatientRecordPanel;
	/*End Of Panels*/



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisors_PatientsPage frame = new Supervisors_PatientsPage();
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
	public Supervisors_PatientsPage() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				// show database data to table
				ShowDatatBaseDataToTable();
			}
		});
		getContentPane().setBackground(Color.WHITE);
		setFocusable(false);
		setBorder(null);
		setBackground(Color.WHITE);
		setFrameIcon(null);
		setBounds(0, 0, 650, 522);
		getContentPane().setLayout(null);
		
		
		/*ScrollPane PatientRecordPanel*/
		scrollPane_PatientRecordPanel = new JScrollPane();
		scrollPane_PatientRecordPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_PatientRecordPanel.setBounds(46, 72, 553, 138);
		getContentPane().add(scrollPane_PatientRecordPanel);
		/*End Of ScrollPane PatientRecordPanel*/


		/*Table ScrollPane PatientRecordPanel*/
		table = new JTable();
		scrollPane_PatientRecordPanel.setViewportView(table);
		/*End Of Table ScrollPane PatientRecordPanel*/

		
		/*Patient search Panel*/
		panelPatientSearch_PatientRecordPanel = new JPanel();
		panelPatientSearch_PatientRecordPanel.setLayout(null);
		panelPatientSearch_PatientRecordPanel.setBackground(new Color(102, 51, 153));
		panelPatientSearch_PatientRecordPanel.setBounds(46, 222, 553, 144);
		getContentPane().add(panelPatientSearch_PatientRecordPanel);
		/*End of Patient search Panel*/

		
		/*Patient search Label*/
		lblPatientSearch__PatientRecordPanel = new JLabel("Patient Search");
		lblPatientSearch__PatientRecordPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearch__PatientRecordPanel.setForeground(Color.WHITE);
		lblPatientSearch__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPatientSearch__PatientRecordPanel.setFocusable(false);
		lblPatientSearch__PatientRecordPanel.setBorder(null);
		lblPatientSearch__PatientRecordPanel.setBounds(185, 11, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(lblPatientSearch__PatientRecordPanel);
		/*End of Patient search Label*/

		
		/*Search Button*/
		btnSearch__PatientRecordPanel = new JButton();
		btnSearch__PatientRecordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch__PatientRecordPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				/*
				 *     Search Patient
				 */
				
								
				//check if enter patient ID field is empty 
				if(textFieldPatientID.getText().isEmpty())
					
				{ JOptionPane.showMessageDialog(null, "Please enter patient ID"); }
				
				// else continue after "check if enter patient ID field is empty "
				else          
				{
					Connection connection = ConnectionFactory.getConnection();
					PreparedStatement preparedatatement;
					try {
						preparedatatement = connection.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
						preparedatatement.setString(1, textFieldPatientID.getText());
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
		btnSearch__PatientRecordPanel.setText("Search");
		btnSearch__PatientRecordPanel.setForeground(Color.WHITE);
		btnSearch__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		btnSearch__PatientRecordPanel.setFocusable(false);
		btnSearch__PatientRecordPanel.setBackground(new Color(102, 51, 153));
		btnSearch__PatientRecordPanel.setBounds(426, 65, 117, 35);
		panelPatientSearch_PatientRecordPanel.add(btnSearch__PatientRecordPanel);
		/*End of Search Button*/

		
		/*Patient search enter ID Label*/
		lblPatientSearchEnterID__PatientRecordPanel = new JLabel("Enter Patient ID");
		lblPatientSearchEnterID__PatientRecordPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientSearchEnterID__PatientRecordPanel.setForeground(Color.WHITE);
		lblPatientSearchEnterID__PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 15));
		lblPatientSearchEnterID__PatientRecordPanel.setFocusable(false);
		lblPatientSearchEnterID__PatientRecordPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		lblPatientSearchEnterID__PatientRecordPanel.setBounds(10, 65, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(lblPatientSearchEnterID__PatientRecordPanel);
		/*End of Patient search enter ID Label*/

		
		/*Patient ID textField*/
		textFieldPatientID = new JTextField();
		textFieldPatientID.setToolTipText("Patient ID");
		textFieldPatientID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPatientID.setFont(new Font("Kartika", Font.BOLD, 16));
		textFieldPatientID.setColumns(10);
		textFieldPatientID.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldPatientID.setBounds(216, 65, 180, 36);
		panelPatientSearch_PatientRecordPanel.add(textFieldPatientID);
		/*End of Patient ID textField*/

		
		/*Empty Field Button*/
		BtnEmptyField_PatientRecordPanel = new JButton();
		BtnEmptyField_PatientRecordPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnEmptyField_PatientRecordPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear patient ID field
				clearButton();
				// refresh database 
				ShowDatatBaseDataToTable();
			}
		});
		BtnEmptyField_PatientRecordPanel.setText("Clear");
		BtnEmptyField_PatientRecordPanel.setForeground(Color.WHITE);
		BtnEmptyField_PatientRecordPanel.setFont(new Font("Kartika", Font.BOLD, 17));
		BtnEmptyField_PatientRecordPanel.setFocusable(false);
		BtnEmptyField_PatientRecordPanel.setBackground(new Color(46, 139, 87));
		BtnEmptyField_PatientRecordPanel.setBounds(267, 426, 105, 35);
		getContentPane().add(BtnEmptyField_PatientRecordPanel);
		/*End of Empty Field Button*/

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
	 * **************************************
	 *   Clear Patient ID Text Field  method 
	 * **************************************
	 */
	private void clearButton()
	{
		textFieldPatientID.setText(null);
	}
	/*
	 * ********************************************
	 *  End of Clear Patient ID Text Field  method 
	 * ********************************************
	 */
}
