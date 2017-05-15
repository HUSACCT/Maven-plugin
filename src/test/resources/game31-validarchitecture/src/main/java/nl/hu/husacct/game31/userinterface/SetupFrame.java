package nl.hu.husacct.game31.userinterface;

import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.DebugGraphics;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class SetupFrame extends javax.swing.JFrame {

	private JComboBox aantalFicesCombo;
	private JComboBox aantalSpelersCombo;
	private JLabel okLabel;
	private JLabel okBG;
	private JButton okButton;
	private JCheckBox metAflegstokcheck;
	private JCheckBox opHetEzeltjeCheck;
	private JLabel metAflegStokLabel;
	private JLabel opHetEzeltjeSpelenLabel;
	private JPanel extraInstellingenPanel;
	private JLabel aantalFicesPerSpeler;
	private JLabel aantalSpelersLabel;
	private JPanel algemeneSettings;
	private JLabel instellingenLabel;
	private JLabel titelPicture;
	private JLabel transparantBG;
	private JPanel instellingen;
	private JLabel backgroundPicture;
	private JPanel items;
	private MainFrame mainFrame;
	
	public SetupFrame(MainFrame mf) {
		mainFrame = mf;
		initGUI();
		this.setVisible(true);
	}
	
	public SetupFrame() {
		initGUI();
		this.setVisible(true);
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			items = new JPanel();
			instellingen = new JPanel();
			instellingenLabel = new JLabel();
			titelPicture = new JLabel();
			algemeneSettings = new JPanel();
			aantalSpelersLabel = new JLabel();
			aantalFicesPerSpeler = new JLabel();
			aantalSpelersCombo = new JComboBox();
			aantalFicesCombo = new JComboBox();
			extraInstellingenPanel = new JPanel();
			opHetEzeltjeSpelenLabel = new JLabel();
			metAflegStokLabel = new JLabel();
			opHetEzeltjeCheck = new JCheckBox();
			metAflegstokcheck = new JCheckBox();
			transparantBG = new JLabel();
			okButton = new JButton();
			okBG = new JLabel();
			okLabel = new JLabel();
			backgroundPicture = new JLabel();
	
			this.getContentPane().setLayout(null);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setTitle("Nieuw Spel");
			this.setUndecorated(false);
			this.setSize(new java.awt.Dimension(407,327));
			this.setEnabled(true);
	
			items.setLayout(null);
			items.setToolTipText("Stel de game eigenschappen in");
			items.setPreferredSize(new java.awt.Dimension(400,300));
			items.setOpaque(false);
			items.setBounds(new java.awt.Rectangle(0,0,400,300));
			this.getContentPane().add(items);
	
			instellingen.setLayout(null);
			instellingen.setVisible(true);
			instellingen.setMinimumSize(new java.awt.Dimension(355,225));
			instellingen.setPreferredSize(new java.awt.Dimension(355,225));
			instellingen.setAlignmentX(0.0f);
			instellingen.setAlignmentY(0.0f);
			instellingen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			instellingen.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
			instellingen.setDoubleBuffered(false);
			instellingen.setMaximumSize(new java.awt.Dimension(355,225));
			instellingen.setOpaque(false);
			instellingen.setBounds(new java.awt.Rectangle(10,29,355,225));
			items.add(instellingen);
	
			instellingenLabel.setText("Instellingen");
			instellingenLabel.setHorizontalAlignment(SwingConstants.LEFT);
			instellingenLabel.setHorizontalTextPosition(SwingConstants.LEFT);
			instellingenLabel.setVerticalAlignment(SwingConstants.CENTER);
			instellingenLabel.setVerticalTextPosition(SwingConstants.CENTER);
			instellingenLabel.setVisible(true);
			instellingenLabel.setFont(new java.awt.Font("Verdana",1,12));
			instellingenLabel.setPreferredSize(new java.awt.Dimension(337,20));
			instellingenLabel.setBounds(new java.awt.Rectangle(8,8,337,20));
			instellingen.add(instellingenLabel);
	
			titelPicture.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/setupInstellingenTitelPic.png")));
			titelPicture.setIconTextGap(0);
			titelPicture.setPreferredSize(new java.awt.Dimension(354,35));
			titelPicture.setAlignmentY(0.0f);
			titelPicture.setBounds(new java.awt.Rectangle(1,1,354,35));
			instellingen.add(titelPicture);
	
			algemeneSettings.setLayout(null);
			algemeneSettings.setPreferredSize(new java.awt.Dimension(336,72));
			algemeneSettings.setBorder(new TitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Algemeen", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Dialog",1,12), new java.awt.Color(0,0,0)));
			algemeneSettings.setOpaque(false);
			algemeneSettings.setBounds(new java.awt.Rectangle(8,44,336,72));
			instellingen.add(algemeneSettings);
	
			aantalSpelersLabel.setText("Aantal Spelers:");
			aantalSpelersLabel.setPreferredSize(new java.awt.Dimension(165,20));
			aantalSpelersLabel.setBounds(new java.awt.Rectangle(10,21,165,20));
			algemeneSettings.add(aantalSpelersLabel);
	
			aantalFicesPerSpeler.setText("Aantal fices per speler:");
			aantalFicesPerSpeler.setPreferredSize(new java.awt.Dimension(148,20));
			aantalFicesPerSpeler.setBounds(new java.awt.Rectangle(10,44,148,20));
			algemeneSettings.add(aantalFicesPerSpeler);
	
			aantalSpelersCombo.setPreferredSize(new java.awt.Dimension(58,20));
			aantalSpelersCombo.setBounds(new java.awt.Rectangle(259,19,58,20));
			algemeneSettings.add(aantalSpelersCombo);
	
			aantalFicesCombo.setPreferredSize(new java.awt.Dimension(58,20));
			aantalFicesCombo.setBounds(new java.awt.Rectangle(259,44,58,20));
			algemeneSettings.add(aantalFicesCombo);
	
			extraInstellingenPanel.setLayout(null);
			extraInstellingenPanel.setPreferredSize(new java.awt.Dimension(336,72));
			extraInstellingenPanel.setBorder(new TitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Extra's", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Dialog",1,12), new java.awt.Color(0,0,0)));
			extraInstellingenPanel.setOpaque(false);
			extraInstellingenPanel.setSize(new java.awt.Dimension(336,72));
			extraInstellingenPanel.setBounds(new java.awt.Rectangle(8,124,336,72));
			instellingen.add(extraInstellingenPanel);
	
			opHetEzeltjeSpelenLabel.setText("Op het ezeltje spelen:");
			opHetEzeltjeSpelenLabel.setPreferredSize(new java.awt.Dimension(162,20));
			opHetEzeltjeSpelenLabel.setBounds(new java.awt.Rectangle(10,19,162,20));
			extraInstellingenPanel.add(opHetEzeltjeSpelenLabel);
	
			metAflegStokLabel.setText("Met aflegstok spelen:");
			metAflegStokLabel.setPreferredSize(new java.awt.Dimension(134,20));
			metAflegStokLabel.setBounds(new java.awt.Rectangle(10,40,134,20));
			extraInstellingenPanel.add(metAflegStokLabel);
	
			opHetEzeltjeCheck.setEnabled(false);
			opHetEzeltjeCheck.setPreferredSize(new java.awt.Dimension(20,20));
			opHetEzeltjeCheck.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			opHetEzeltjeCheck.setOpaque(false);
			opHetEzeltjeCheck.setBounds(new java.awt.Rectangle(306,19,20,20));
			extraInstellingenPanel.add(opHetEzeltjeCheck);
	
			metAflegstokcheck.setEnabled(false);
			metAflegstokcheck.setPreferredSize(new java.awt.Dimension(20,20));
			metAflegstokcheck.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			metAflegstokcheck.setOpaque(false);
			metAflegstokcheck.setBounds(new java.awt.Rectangle(306,40,20,20));
			extraInstellingenPanel.add(metAflegstokcheck);
	
			transparantBG.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantBG.setPreferredSize(new java.awt.Dimension(355,225));
			transparantBG.setAlignmentY(0.0f);
			transparantBG.setBounds(new java.awt.Rectangle(10,29,355,225));
			items.add(transparantBG);
	
			okButton.setPreferredSize(new java.awt.Dimension(60,20));
			okButton.setBorder(new EtchedBorder(BevelBorder.LOWERED, null, null));
			okButton.setOpaque(false);
			okButton.setBounds(new java.awt.Rectangle(264,266,60,20));
			items.add(okButton);
			okButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					okButtonActionPerformed(evt);
				}
			});
	
			okBG.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			okButton.add(okBG);
	
			okLabel.setText("OK");
			okLabel.setPreferredSize(new java.awt.Dimension(22,18));
			okLabel.setBounds(new java.awt.Rectangle(19,-1,22,18));
			okBG.add(okLabel);
	
			backgroundPicture.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/setupBackground.jpg")));
			backgroundPicture.setPreferredSize(new java.awt.Dimension(400,300));
			backgroundPicture.setBounds(new java.awt.Rectangle(0,0,400,300));
			this.getContentPane().add(backgroundPicture);
	
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
		aantalSpelersCombo.addItem("2");
		aantalSpelersCombo.addItem("3");
		aantalSpelersCombo.addItem("4");
		aantalSpelersCombo.addItem("5");
		aantalSpelersCombo.addItem("6");
		
		aantalFicesCombo.addItem("1");
		aantalFicesCombo.addItem("2");
		aantalFicesCombo.addItem("3");
		aantalFicesCombo.addItem("4");
		aantalFicesCombo.addItem("5");
		aantalFicesCombo.addItem("6");
		aantalFicesCombo.addItem("7");
		aantalFicesCombo.addItem("8");
		aantalFicesCombo.addItem("9");
		aantalFicesCombo.addItem("10");
	}

	/** Auto-generated main method */
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
			SetupFrame inst = new SetupFrame();
			inst.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void okButtonActionPerformed(ActionEvent evt){
		int aantalSpelers = Integer.parseInt((String)aantalSpelersCombo.getSelectedItem());
		int aantalFices = Integer.parseInt((String)aantalFicesCombo.getSelectedItem());
		mainFrame.loadSpelerSetup(aantalSpelers, aantalFices, false, false);
		this.dispose();
	}

}
