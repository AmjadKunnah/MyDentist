package mydentisten.ui;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
*
* @author amjad azim
*/

public class DeveloperPage extends JInternalFrame {
	
	
	/*Variables*/
	
	//JLabel
	private JLabel lblTwitter;
	private JLabel lblTwitter2;
	private JLabel lblFacebook;
	private JLabel lblFacebook2;
	private JLabel lblEmail;
	private JLabel lblEmail2;
	private JLabel lblDeveloperName;
	private JLabel lbDeveloperName2;
	private JLabel lblPhoneNO;
	private JLabel lblPhoneNO2;
	private JLabel lblDeveloperPhoto;
	private JLabel lblGitHub;
	private JLabel lblGitHub2;
	/*End of Variables*/

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeveloperPage frame = new DeveloperPage();
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
	public DeveloperPage() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		setBackground(Color.WHITE);
		setFocusable(false);
		setFrameIcon(null);
		setBounds(0, 0, 650, 522);
	    
	    
		getContentPane().setLayout(null);
		
		/*Twitter Label*/
		lblTwitter = new JLabel("X:");
		lblTwitter.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitter.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTwitter.setForeground(Color.BLACK);
		lblTwitter.setFont(new Font("Kartika", Font.BOLD, 20));
		lblTwitter.setBounds(95, 372, 141, 34);
		getContentPane().add(lblTwitter);
		/*End of Twitter Label*/
		
		
		/*Twitter 2 Label*/
		lblTwitter2 = new JLabel("@AmjadAbdulAzim");
		lblTwitter2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblTwitter2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitter2.setForeground(Color.BLACK);
		lblTwitter2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lblTwitter2.setBounds(277, 372, 279, 34);
		getContentPane().add(lblTwitter2);
		/*End of Twitter 2 Label*/
		
		
		/*Facebook 2 Label*/
		lblFacebook2 = new JLabel("Amgd Azim");
		lblFacebook2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblFacebook2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacebook2.setForeground(Color.BLACK);
		lblFacebook2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lblFacebook2.setBounds(277, 327, 279, 34);
		getContentPane().add(lblFacebook2);
		/*End of Facebook 2 Label*/

		
		/*Facebook Label*/
		lblFacebook = new JLabel("Facebook:");
		lblFacebook.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacebook.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblFacebook.setForeground(Color.BLACK);
		lblFacebook.setFont(new Font("Kartika", Font.BOLD, 20));
		lblFacebook.setBounds(95, 327, 141, 34);
		getContentPane().add(lblFacebook);
		/*End of Facebook Label*/

		
		/*Phone NO Label*/
		lblPhoneNO = new JLabel("Phone NO:");
		lblPhoneNO.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNO.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPhoneNO.setForeground(Color.BLACK);
		lblPhoneNO.setFont(new Font("Kartika", Font.BOLD, 20));
		lblPhoneNO.setBounds(95, 282, 141, 34);
		getContentPane().add(lblPhoneNO);
		/*End of Phone NO Label*/

		
		/*Email 2 Label*/
		lblEmail2 = new JLabel("Amjad.Azim.AA@gmail.com");
		lblEmail2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblEmail2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail2.setForeground(Color.BLACK);
		lblEmail2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lblEmail2.setBounds(277, 237, 279, 34);
		getContentPane().add(lblEmail2);
		/*End of Email 2 Label*/

		
		/*Email Label*/
		lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Kartika", Font.BOLD, 20));
		lblEmail.setBounds(95, 237, 141, 34);
		getContentPane().add(lblEmail);
		/*End of Email Label*/

		
		/*Developer Name Label*/
		lblDeveloperName = new JLabel("Name:");
		lblDeveloperName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeveloperName.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblDeveloperName.setForeground(Color.BLACK);
		lblDeveloperName.setFont(new Font("Kartika", Font.BOLD, 20));
		lblDeveloperName.setBounds(95, 192, 141, 34);
		getContentPane().add(lblDeveloperName);
		/*End of Developer Name Label*/

		
		/*Developer Name 2 Label*/
		lbDeveloperName2 = new JLabel("Amjad Abdulazim Ahmed");
		lbDeveloperName2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lbDeveloperName2.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeveloperName2.setForeground(Color.BLACK);
		lbDeveloperName2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lbDeveloperName2.setBounds(277, 192, 279, 34);
		getContentPane().add(lbDeveloperName2);
		/*End of Developer Name 2 Label*/
		
		
		/*Phone NO 2 Label*/
		lblPhoneNO2 = new JLabel("00249128597073");
		lblPhoneNO2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblPhoneNO2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNO2.setForeground(Color.BLACK);
		lblPhoneNO2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lblPhoneNO2.setBounds(277, 282, 279, 34);
		getContentPane().add(lblPhoneNO2);
		/*End of Phone NO 2 Label*/

		
		/*Developer Photo Label*/
		lblDeveloperPhoto = new JLabel();
		lblDeveloperPhoto.setBounds(271, 11, 124, 124);
		
		// Add Photo To Developer Photo Label 
		try
		{
			Image image = ImageIO.read(getClass().getResource("/mydentisten/ui/icons/"+"DSC_4816-2_(Croped).jpg"));
			Image image2 = image.getScaledInstance(lblDeveloperPhoto.getWidth(), lblDeveloperPhoto.getHeight(), Image.SCALE_SMOOTH);
			lblDeveloperPhoto.setIcon(new ImageIcon(image2));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		getContentPane().add(lblDeveloperPhoto);
		/*End of Developer Photo Label*/

		
		/*GitHub Label*/
		lblGitHub = new JLabel("GitHub:");
		lblGitHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitHub.setForeground(Color.BLACK);
		lblGitHub.setFont(new Font("Kartika", Font.BOLD, 20));
		lblGitHub.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblGitHub.setBounds(95, 414, 141, 34);
		getContentPane().add(lblGitHub);
		/*End of GitHub Label*/
		
		
		/*GitHub2 Label*/
		lblGitHub2 = new JLabel("@AmjadKunnah");
		lblGitHub2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitHub2.setForeground(Color.BLACK);
		lblGitHub2.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 20));
		lblGitHub2.setBorder(new LineBorder(new Color(102, 51, 153), 2, true));
		lblGitHub2.setBounds(277, 414, 279, 34);
		getContentPane().add(lblGitHub2);
		/*End of GitHub2 Label*/


	}
}
