package nl.hu.husacct.game31.userinterface;

import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Vector;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class setupSpelers extends javax.swing.JFrame {

	private JLabel okLabel;
	private JLabel okButtonBG;
	private JButton okButton;
	private JComboBox gebJaar;
	private JComboBox gebMaand;
	private JComboBox gebDag;
	private JLabel gebDatumLabel;
	private JLabel labelNaam;
	private JTextField naamField;
	private JLabel transparantVlak3;
	private JRadioButton radioSpelerComputer;
	private JRadioButton radioSpelerMens;
	private JLabel typeSpelerLabel;
	private ButtonGroup typeSpelerGroep;
	private JLabel transparantVlak2;
	private JLabel headerTekst;
	private JPanel formVak;
	private JLabel transparantVlak1;
	private JPanel mainPanel;
	private JLabel achtergrondAfbeelding;
	private Vector computerSpelers = new Vector();
	private Vector mensSpelers = new Vector();
	private int aantalSpelers;
	private int currentSpelerType = 0;
	private MainFrame mainFrame;
	
	public setupSpelers(int aantalSpelers, MainFrame mf) {
		this.aantalSpelers = aantalSpelers;
		this.mainFrame = mf;
		this.aantalSpelers--;
		initGUI();
		this.setVisible(true);
	}
	
	public setupSpelers() {
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
			typeSpelerGroep = new ButtonGroup();
	
	
			mainPanel = new JPanel();
			formVak = new JPanel();
			headerTekst = new JLabel();
			typeSpelerLabel = new JLabel();
			radioSpelerMens = new JRadioButton();
			radioSpelerComputer = new JRadioButton();
			naamField = new JTextField();
			labelNaam = new JLabel();
			gebDatumLabel = new JLabel();
			gebDag = new JComboBox();
			gebMaand = new JComboBox();
			gebJaar = new JComboBox();
			okButton = new JButton();
			okButtonBG = new JLabel();
			okLabel = new JLabel();
			transparantVlak1 = new JLabel();
			transparantVlak2 = new JLabel();
			transparantVlak3 = new JLabel();
			achtergrondAfbeelding = new JLabel();
	
			this.getContentPane().setLayout(null);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(new java.awt.Dimension(407,327));
	
			mainPanel.setLayout(null);
			mainPanel.setVisible(true);
			mainPanel.setPreferredSize(new java.awt.Dimension(400,300));
			mainPanel.setOpaque(false);
			mainPanel.setBounds(new java.awt.Rectangle(0,0,400,300));
			this.getContentPane().add(mainPanel);
	
			formVak.setLayout(null);
			formVak.setVisible(true);
			formVak.setPreferredSize(new java.awt.Dimension(362,263));
			formVak.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			formVak.setOpaque(false);
			formVak.setBounds(new java.awt.Rectangle(16,17,362,263));
			mainPanel.add(formVak);
	
			headerTekst.setText("Nieuwe speler");
			headerTekst.setPreferredSize(new java.awt.Dimension(81,16));
			headerTekst.setBounds(new java.awt.Rectangle(9,7,81,16));
			formVak.add(headerTekst);
	
			typeSpelerLabel.setText("Type speler");
			typeSpelerLabel.setPreferredSize(new java.awt.Dimension(68,20));
			typeSpelerLabel.setBounds(new java.awt.Rectangle(143,48,68,20));
			formVak.add(typeSpelerLabel);
	
			radioSpelerMens.setText("Mens");
			radioSpelerMens.setPreferredSize(new java.awt.Dimension(60,20));
			radioSpelerMens.setOpaque(false);
			radioSpelerMens.setBounds(new java.awt.Rectangle(109,76,60,20));
			typeSpelerGroep.add(radioSpelerMens);
			formVak.add(radioSpelerMens);
			radioSpelerMens.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioSpelerMensActionPerformed(evt);
				}
			});
	
			radioSpelerComputer.setText("Computer");
			radioSpelerComputer.setPreferredSize(new java.awt.Dimension(135,20));
			radioSpelerComputer.setOpaque(false);
			radioSpelerComputer.setBounds(new java.awt.Rectangle(178,77,135,20));
			typeSpelerGroep.add(radioSpelerComputer);
			formVak.add(radioSpelerComputer);
			radioSpelerComputer.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioSpelerComputerActionPerformed(evt);
				}
			});
	
			naamField.setEnabled(false);
			naamField.setPreferredSize(new java.awt.Dimension(177,20));
			naamField.setOpaque(false);
			naamField.setBounds(new java.awt.Rectangle(119,138,177,20));
			formVak.add(naamField);
	
			labelNaam.setText("Naam:");
			labelNaam.setPreferredSize(new java.awt.Dimension(60,20));
			labelNaam.setBounds(new java.awt.Rectangle(71,138,60,20));
			formVak.add(labelNaam);
	
			gebDatumLabel.setText("Geboorte datum:");
			gebDatumLabel.setPreferredSize(new java.awt.Dimension(107,20));
			gebDatumLabel.setBounds(new java.awt.Rectangle(39,185,107,20));
			formVak.add(gebDatumLabel);
	
			gebDag.setEnabled(false);
			gebDag.setPreferredSize(new java.awt.Dimension(43,20));
			gebDag.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			gebDag.setOpaque(false);
			gebDag.setBounds(new java.awt.Rectangle(145,186,43,20));
			formVak.add(gebDag);
	
			gebMaand.setEnabled(false);
			gebMaand.setPreferredSize(new java.awt.Dimension(43,20));
			gebMaand.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			gebMaand.setOpaque(false);
			gebMaand.setBounds(new java.awt.Rectangle(196,186,43,20));
			formVak.add(gebMaand);
	
			gebJaar.setEnabled(false);
			gebJaar.setPreferredSize(new java.awt.Dimension(73,20));
			gebJaar.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			gebJaar.setOpaque(false);
			gebJaar.setBounds(new java.awt.Rectangle(246,186,73,20));
			formVak.add(gebJaar);
	
			okButton.setPreferredSize(new java.awt.Dimension(60,20));
			okButton.setBorder(new EtchedBorder(BevelBorder.LOWERED, null, null));
			okButton.setOpaque(false);
			okButton.setBounds(new java.awt.Rectangle(285,235,60,20));
			formVak.add(okButton);
			okButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					okButtonActionPerformed(evt);
				}
			});
	
			okButtonBG.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			okButtonBG.setPreferredSize(new java.awt.Dimension(41,13));
			okButton.add(okButtonBG);
	
			okLabel.setText("OK");
			okLabel.setPreferredSize(new java.awt.Dimension(17,16));
			okLabel.setBounds(new java.awt.Rectangle(20,0,17,16));
			okButtonBG.add(okLabel);
	
			transparantVlak1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak1.setPreferredSize(new java.awt.Dimension(361,31));
			transparantVlak1.setBounds(new java.awt.Rectangle(16,17,361,31));
			mainPanel.add(transparantVlak1);
	
			transparantVlak2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak2.setPreferredSize(new java.awt.Dimension(339,63));
			transparantVlak2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			transparantVlak2.setBounds(new java.awt.Rectangle(25,59,339,63));
			mainPanel.add(transparantVlak2);
	
			transparantVlak3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/transparant.png")));
			transparantVlak3.setPreferredSize(new java.awt.Dimension(337,111));
			transparantVlak3.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			transparantVlak3.setBounds(new java.awt.Rectangle(26,134,337,111));
			mainPanel.add(transparantVlak3);
	
			achtergrondAfbeelding.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main/resources/images/spelerSetupBackground.jpg")));
			achtergrondAfbeelding.setPreferredSize(new java.awt.Dimension(400,300));
			achtergrondAfbeelding.setBounds(new java.awt.Rectangle(0,0,400,300));
			this.getContentPane().add(achtergrondAfbeelding);
	
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
		//Vul de comboboxen.
		for(int a=1; a<32; a++) {
			gebDag.addItem("" + a);
		}
		for(int a=1; a<13; a++) {
			gebMaand.addItem("" + a);
		}
		for(int a=1930; a<2005; a++) {
			gebJaar.addItem("" + a);
		}
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
			setupSpelers inst = new setupSpelers();
			inst.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void okButtonActionPerformed(ActionEvent evt){
		if(currentSpelerType == 0) {
			JOptionPane.showMessageDialog(this,"Selecteer eerst een type speler", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if(currentSpelerType == 1) { //Speler is mens.
				String spelerNaam = naamField.getText();
				Calendar spelerGebDatum = Calendar.getInstance();
				spelerGebDatum.set(Calendar.DATE, Integer.parseInt((String)gebDag.getSelectedItem()));
				spelerGebDatum.set(Calendar.MONTH, Integer.parseInt((String)gebMaand.getSelectedItem()));
				spelerGebDatum.set(Calendar.YEAR, Integer.parseInt((String)gebJaar.getSelectedItem()));
				//Maak een speler Vector en voeg hem aan de Vector mensSpelers toe
				Vector speler = new Vector();
				speler.addElement(spelerNaam);
				speler.addElement(spelerGebDatum);
				mensSpelers.addElement(speler);
			}
			else {
				String spelerNaam = naamField.getText();
				computerSpelers.addElement(spelerNaam);
			}
			if(aantalSpelers-- > 0) { //Volgende speler
				mainPanel.setVisible(false);
				currentSpelerType = 0;
				gebDag.setSelectedIndex(0);
				gebMaand.setSelectedIndex(0);
				gebJaar.setSelectedIndex(0);
				formVak.remove(radioSpelerComputer);
				formVak.remove(radioSpelerMens);
				radioSpelerComputer = null;
				radioSpelerComputer = new JRadioButton();
				radioSpelerComputer.setText("Computer");
				radioSpelerComputer.setPreferredSize(new java.awt.Dimension(135,20));
				radioSpelerComputer.setOpaque(false);
				radioSpelerComputer.setBounds(new java.awt.Rectangle(178,77,135,20));
				typeSpelerGroep.add(radioSpelerComputer);
				formVak.add(radioSpelerComputer);
				radioSpelerComputer.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radioSpelerComputerActionPerformed(evt);
					}
				});
				radioSpelerMens = null;
				radioSpelerMens = new JRadioButton();
				radioSpelerMens.setText("Mens");
				radioSpelerMens.setPreferredSize(new java.awt.Dimension(60,20));
				radioSpelerMens.setOpaque(false);
				radioSpelerMens.setBounds(new java.awt.Rectangle(109,76,60,20));
				typeSpelerGroep.add(radioSpelerMens);
				formVak.add(radioSpelerMens);
				radioSpelerMens.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radioSpelerMensActionPerformed(evt);
					}
				});
				naamField.setText("");
				gebDag.setEnabled(false);
				gebMaand.setEnabled(false);
				gebJaar.setEnabled(false);
				naamField.setEnabled(false);
				mainPanel.repaint();
				mainPanel.setVisible(true);
			}
			else { //Start het spel!
				mainFrame.startHetSpel(computerSpelers, mensSpelers);
				this.dispose();
			}
		}
	}

	/** Auto-generated event handler method */
	protected void radioSpelerComputerActionPerformed(ActionEvent evt){
		currentSpelerType = 2;
		gebDag.setEnabled(false);
		gebMaand.setEnabled(false);
		gebJaar.setEnabled(false);
		naamField.setEnabled(true);
	}

	/** Auto-generated event handler method */
	protected void radioSpelerMensActionPerformed(ActionEvent evt){
		currentSpelerType = 1;
		gebDag.setEnabled(true);
		gebMaand.setEnabled(true);
		gebJaar.setEnabled(true);
		naamField.setEnabled(true);
	}
}
