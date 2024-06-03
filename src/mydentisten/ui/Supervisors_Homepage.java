package mydentisten.ui;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
*
* @author amjad azim
*/

public class Supervisors_Homepage extends JInternalFrame {

	/*Variables*/
	
	//JLabel
	private JLabel lblMydentistlogo;
	private JLabel lblName;
	private JLabel lblLast_Name;
	private JLabel lblUsename;
	private JLabel lblUser_Type;
	
	//JTextField
	public JTextField textFieldName;
	public JTextField textFieldLastName;
	public JTextField textFieldUsername;
	public JTextField textFieldUserType;
	
	/*End of Variables*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisors_Homepage frame = new Supervisors_Homepage();
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
	public Supervisors_Homepage() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		setBackground(Color.WHITE);
		setFocusable(false);
		setBounds(0, 0, 650, 522);
		setFrameIcon(null);	    
		getContentPane().setLayout(null);
		
		
		/*Logo Label*/
		lblMydentistlogo = new JLabel("");
		lblMydentistlogo.setBounds(237, 11, 200, 150);
		// add icon to label
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
		getContentPane().add(lblMydentistlogo);
		/*End of Logo Label*/

		/*Name Label*/
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblName.setFocusable(false);
		lblName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblName.setBounds(103, 209, 171, 36);
		getContentPane().add(lblName);
		/*End of Name Label*/

		/*Last Name Label*/
		lblLast_Name = new JLabel("Last Name");
		lblLast_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblLast_Name.setForeground(Color.BLACK);
		lblLast_Name.setFont(new Font("Kartika", Font.BOLD, 20));
		lblLast_Name.setFocusable(false);
		lblLast_Name.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblLast_Name.setBounds(103, 257, 171, 36);
		getContentPane().add(lblLast_Name);
		/*End of Last Name Label*/

		
		/*Username Label*/
		lblUsename = new JLabel("Username");
		lblUsename.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsename.setForeground(Color.BLACK);
		lblUsename.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUsename.setFocusable(false);
		lblUsename.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUsename.setBounds(103, 304, 171, 36);
		getContentPane().add(lblUsename);
		/*End of Username Label*/

		
		/*User Type Label*/
		lblUser_Type = new JLabel("User Type");
		lblUser_Type.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_Type.setForeground(Color.BLACK);
		lblUser_Type.setFont(new Font("Kartika", Font.BOLD, 20));
		lblUser_Type.setFocusable(false);
		lblUser_Type.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblUser_Type.setBounds(103, 351, 171, 36);
		getContentPane().add(lblUser_Type);
		/*End of User Type 1 Label*/

		
		/*Name Textfield*/
		textFieldName = new JTextField();
		textFieldName.setFocusable(false);
		textFieldName.setToolTipText("Name");
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Kartika", Font.PLAIN, 19));
		textFieldName.setColumns(10);
		textFieldName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldName.setBounds(284, 210, 200, 36);
		getContentPane().add(textFieldName);
		/*End of Name Textfield*/

		
		/*Last Name Textfield*/
		textFieldLastName = new JTextField();
		textFieldLastName.setToolTipText("Last Name");
		textFieldLastName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLastName.setFont(new Font("Kartika", Font.PLAIN, 19));
		textFieldLastName.setFocusable(false);
		textFieldLastName.setColumns(10);
		textFieldLastName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldLastName.setBounds(284, 257, 200, 36);
		getContentPane().add(textFieldLastName);
		/*End of Last Name Textfield*/

		
		/*Username Textfield*/
		textFieldUsername = new JTextField();
		textFieldUsername.setToolTipText("Username");
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setFont(new Font("Kartika", Font.PLAIN, 19));
		textFieldUsername.setFocusable(false);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldUsername.setBounds(284, 304, 200, 36);
		getContentPane().add(textFieldUsername);
		/*End of Userame Textfield*/

		
		/*User Type Textfield*/
		textFieldUserType = new JTextField();
		textFieldUserType.setToolTipText("User Type");
		textFieldUserType.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUserType.setFont(new Font("Kartika", Font.PLAIN, 19));
		textFieldUserType.setFocusable(false);
		textFieldUserType.setColumns(10);
		textFieldUserType.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		textFieldUserType.setBounds(284, 351, 200, 36);
		getContentPane().add(textFieldUserType);
		/*End of User Type Textfield*/


	}
}
