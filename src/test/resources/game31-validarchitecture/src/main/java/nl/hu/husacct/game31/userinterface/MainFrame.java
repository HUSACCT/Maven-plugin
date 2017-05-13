package nl.hu.husacct.game31.userinterface;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import nl.hu.husacct.game31.domein.Spel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class MainFrame extends javax.swing.JFrame {
	private JMenuItem exitItem;
	private JMenuItem nieuwspelItem;
	private TheMainPanel theMainPanel;
	private JLabel transparantVlak5_1;
	private JLabel transparantVlak5;
	private JLabel transparantVlak4_1;
	private JLabel transparantVlak4;
	private JLabel transparantVlak3;
	private JLabel transparantVlak2;
	private JLabel transparantVlak1;
	private JMenu spelMenu;
	private JMenuBar theMenuBar;
	private JLabel bgPictureLabel;
	private boolean gameStarted = false; 
	private int aantalFices;
	
	public MainFrame(int i) {
		initGUI();
		this.setVisible(true);
		SetupFrame sf = new SetupFrame(this);
	}
	
	public MainFrame() {
		initGUI();
		this.setVisible(true);
		SetupFrame sf = new SetupFrame(this);
	}
	
	public void updateUI() {
		theMainPanel.updateScherm();
	}
	
	public void newRound() {
		theMainPanel.eersteBeurt();
	}
	
	public void nieuwSpel() {
		SetupFrame sf = new SetupFrame(this);
	}
	
	public void loadSpelerSetup(int aantalSpelers, int aantalFices, boolean opEzeltje, boolean metStok) {
		setupSpelers ss = new setupSpelers(aantalSpelers, this);
		this.aantalFices = aantalFices;
	}
	
	public void startHetSpel(Vector computerSpelers, Vector menselijkeSpelers) {
		Spel hetSpel = new Spel(computerSpelers, menselijkeSpelers, aantalFices, this);
		theMainPanel.startSpel(hetSpel);
		//Geef TheMainpanel het spel.	
	}
	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			theMainPanel = new TheMainPanel();
			bgPictureLabel = new JLabel();
			transparantVlak1 = new JLabel();
			transparantVlak2 = new JLabel();
			transparantVlak3 = new JLabel();
			transparantVlak4 = new JLabel();
			transparantVlak4_1 = new JLabel();
			transparantVlak5 = new JLabel();
			transparantVlak5_1 = new JLabel();
	
			this.getContentPane().setLayout(null);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.setTitle("31-en The Game");
			this.setSize(new java.awt.Dimension(707,577));
	
			theMainPanel.setVisible(true);
			theMainPanel.setPreferredSize(new java.awt.Dimension(700,527));
			theMainPanel.setBounds(new java.awt.Rectangle(0,0,700,527));
			this.getContentPane().add(theMainPanel);
	
			bgPictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
			bgPictureLabel.setHorizontalTextPosition(SwingConstants.LEFT);
			bgPictureLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/mainFrameBackground.jpg")));
			bgPictureLabel.setIconTextGap(0);
			bgPictureLabel.setVerticalAlignment(SwingConstants.TOP);
			bgPictureLabel.setVerticalTextPosition(SwingConstants.TOP);
			bgPictureLabel.setVisible(true);
			bgPictureLabel.setPreferredSize(new java.awt.Dimension(700,529));
			bgPictureLabel.setOpaque(true);
			bgPictureLabel.setRequestFocusEnabled(false);
			bgPictureLabel.setVerifyInputWhenFocusTarget(true);
			bgPictureLabel.setBounds(new java.awt.Rectangle(0,0,700,529));
			bgPictureLabel.setFocusTraversalKeysEnabled(false);
			bgPictureLabel.setFocusable(false);
			bgPictureLabel.setIgnoreRepaint(true);
			this.getContentPane().add(bgPictureLabel);
	
			transparantVlak1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak1.setPreferredSize(new java.awt.Dimension(197,229));
			transparantVlak1.setBounds(new java.awt.Rectangle(0,0,197,229));
			bgPictureLabel.add(transparantVlak1);
	
			transparantVlak2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak2.setPreferredSize(new java.awt.Dimension(197,299));
			transparantVlak2.setBounds(new java.awt.Rectangle(0,229,197,299));
			bgPictureLabel.add(transparantVlak2);
	
			transparantVlak3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak3.setPreferredSize(new java.awt.Dimension(464,32));
			transparantVlak3.setBounds(new java.awt.Rectangle(216,231,464,32));
			bgPictureLabel.add(transparantVlak3);
	
			transparantVlak4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak4.setPreferredSize(new java.awt.Dimension(421,195));
			transparantVlak4.setBounds(new java.awt.Rectangle(233,20,421,195));
			bgPictureLabel.add(transparantVlak4);
	
			transparantVlak4_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak4_1.setPreferredSize(new java.awt.Dimension(421,195));
			transparantVlak4_1.setBounds(new java.awt.Rectangle(233,20,421,195));
			bgPictureLabel.add(transparantVlak4_1);
	
			transparantVlak5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak5.setPreferredSize(new java.awt.Dimension(421,195));
			transparantVlak5.setBounds(new java.awt.Rectangle(239,296,421,195));
			bgPictureLabel.add(transparantVlak5);
	
			transparantVlak5_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak5_1.setPreferredSize(new java.awt.Dimension(421,195));
			transparantVlak5_1.setBounds(new java.awt.Rectangle(239,296,421,195));
			bgPictureLabel.add(transparantVlak5_1);
			theMenuBar = new JMenuBar();
			spelMenu = new JMenu();
			nieuwspelItem = new JMenuItem();
			exitItem = new JMenuItem();
	
			setJMenuBar(theMenuBar);
	
			spelMenu.setText("Spel");
			theMenuBar.add(spelMenu);
	
			nieuwspelItem.setText("Nieuw Spel");
			spelMenu.add(nieuwspelItem);
			nieuwspelItem.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					nieuwspelItemActionPerformed(evt);
				}
			});
	
			exitItem.setText("Afsluiten");
			spelMenu.add(exitItem);
			exitItem.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					exitItemActionPerformed(evt);
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}
	
	public static void main(String[] args){
			showGUI();
	}
	
	/**
	* This static method creates a new instance of this class and shows
	* it inside a new JFrame, (unless it is already a JFrame).
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/	
	public static void showGUI(){
		try {
			MainFrame inst = new MainFrame();
			inst.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* This is an auto-generated method which you can alter,
	* e.g. to point to a different property file, to modify the key by
	* by prefixing the name of this class, etc.
	*
	* By default, it expects a file called "messages.properties" to exist in the
	* current package, and returns the value of the property defined
	* in that file for the given key
	*/
	public String getExternalizedString(String key){
		try {
			return java.util.ResourceBundle.getBundle("game31/userInterface.MainFrameMessages").getString(key);
		} catch (java.util.MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/** Auto-generated event handler method */
	protected void exitItemActionPerformed(ActionEvent evt){
		int sure = JOptionPane.showConfirmDialog(this, "Weet u zeker dat u wilt stoppen?", "Afsluiten?", JOptionPane.OK_CANCEL_OPTION);
		if(sure == 0) {
			System.exit(0); 
		}
	}

	/** Auto-generated event handler method */
	protected void nieuwspelItemActionPerformed(ActionEvent evt){
		new MainFrame(1);
		this.dispose();
	}
}
