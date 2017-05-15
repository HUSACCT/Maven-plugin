package main.java.game31.userinterface;

import java.awt.Component;
import java.util.*;

import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.gamecontrol.Deelname;
import main.java.game31.domain.gamecontrol.Spel;
import main.java.game31.domain.gamecontrol.SpelRonde;
import main.java.game31.domain.gamecontrol.Tafel;
import main.java.game31.domain.players.PlayersService;
import main.java.game31.domain.players.SpelerDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class TheMainPanel extends javax.swing.JPanel {
	private JPanel scrollPanels;
	private JButton allesWisselenButton;
	private JButton wisselenButton;
	private JButton overslaanButton;
	private JButton passenButton;
	private JPanel knoppenPanel;
	private JPanel deTafelPanel;
	private JPanel mijnHandPanel;
	private JTable spelersTable;
	private JPopupMenu wisselenMenu;
	private JTable eventsTable;
	private JScrollPane playerPanel, eventsPanel;
	private Spel hetSpel;
	private Tafel deTafel;
	private boolean eersteRonde = true;
	private JButton tafelKaart1Button;
	private JButton tafelKaart2Button;
	private JButton tafelKaart3Button;
	private JButton handKaart1Button;
	private JButton handKaart2Button;
	private JButton handKaart3Button;
	private boolean tk1Selected;
	private boolean tk2Selected;
	private boolean tk3Selected;
	private boolean hk1Selected;
	private boolean hk2Selected;
	private boolean hk3Selected;

	public TheMainPanel() {
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
	
			mijnHandPanel = new JPanel();
			deTafelPanel = new JPanel();
			knoppenPanel = new JPanel();
			passenButton = new JButton();
			overslaanButton = new JButton();
			wisselenButton = new JButton();
			allesWisselenButton = new JButton();
			scrollPanels = new JPanel();
	
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(700,525));
			this.setOpaque(false);
	
			FlowLayout mijnHandPanelLayout = new FlowLayout();
			mijnHandPanel.setLayout(mijnHandPanelLayout);
			mijnHandPanelLayout.setAlignment(FlowLayout.CENTER);
			mijnHandPanelLayout.setHgap(5);
			mijnHandPanelLayout.setVgap(5);
			mijnHandPanel.setPreferredSize(new java.awt.Dimension(421,195));
			mijnHandPanel.setOpaque(false);
			mijnHandPanel.setBounds(new java.awt.Rectangle(233,20,421,195));
			this.add(mijnHandPanel);
	
			FlowLayout deTafelPanelLayout = new FlowLayout();
			deTafelPanel.setLayout(deTafelPanelLayout);
			deTafelPanelLayout.setAlignment(FlowLayout.CENTER);
			deTafelPanelLayout.setHgap(5);
			deTafelPanelLayout.setVgap(5);
			deTafelPanel.setPreferredSize(new java.awt.Dimension(421,195));
			deTafelPanel.setOpaque(false);
			deTafelPanel.setBounds(new java.awt.Rectangle(239,296,421,195));
			this.add(deTafelPanel);
	
			knoppenPanel.setVisible(true);
			knoppenPanel.setPreferredSize(new java.awt.Dimension(500,50));
			knoppenPanel.setOpaque(false);
			knoppenPanel.setBounds(new java.awt.Rectangle(200,229,500,50));
			this.add(knoppenPanel);
	
			passenButton.setEnabled(false);
			passenButton.setText("Passen");
			passenButton.setPreferredSize(new java.awt.Dimension(79,26));
			passenButton.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			passenButton.setOpaque(false);
			knoppenPanel.add(passenButton);
			passenButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					passenButtonActionPerformed(evt);
				}
			});
	
			overslaanButton.setEnabled(false);
			overslaanButton.setText("Overslaan");
			overslaanButton.setPreferredSize(new java.awt.Dimension(81,26));
			overslaanButton.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			overslaanButton.setOpaque(false);
			knoppenPanel.add(overslaanButton);
			overslaanButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					overslaanButtonActionPerformed(evt);
				}
			});
	
			wisselenButton.setEnabled(false);
			wisselenButton.setText("Wisselen");
			wisselenButton.setPreferredSize(new java.awt.Dimension(88,26));
			wisselenButton.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			wisselenButton.setOpaque(false);
			knoppenPanel.add(wisselenButton);
			wisselenButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					wisselenButtonActionPerformed(evt);
				}
			});
	
			allesWisselenButton.setEnabled(false);
			allesWisselenButton.setText("Alles Wisselen");
			allesWisselenButton.setPreferredSize(new java.awt.Dimension(94,26));
			allesWisselenButton.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			allesWisselenButton.setOpaque(false);
			knoppenPanel.add(allesWisselenButton);
			allesWisselenButton.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					allesWisselenButtonActionPerformed(evt);
				}
			});
	
			scrollPanels.setLayout(null);
			scrollPanels.setVisible(true);
			scrollPanels.setPreferredSize(new java.awt.Dimension(200,528));
			scrollPanels.setOpaque(false);
			scrollPanels.setBounds(new java.awt.Rectangle(-1,0,200,528));
			this.add(scrollPanels);
	
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
		buildSpelersTable();
	}
	
	private void buildSpelersTable() {
		scrollPanels.removeAll();		
		//Build tableHeader
		Vector<String> spelersTableHeader = new Vector<>();
		spelersTableHeader.addElement("Naam");
		spelersTableHeader.addElement("Fices");
		
		//Build tablecontents
		Vector<Vector<String>> spelersTableData = new Vector<>();
		if (hetSpel != null) {
			SpelRonde huidigeRonde = hetSpel.getHuidigeSpelRonde();
			Vector<Deelname> deelnemers = huidigeRonde.geefDeelnames();
			for(Deelname d1 : deelnemers) {
				Vector<String> tabelRij = new Vector<>();
				SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(d1.getSpeler());
				tabelRij.addElement(speler.geefNaam());
				tabelRij.addElement("" + speler.geefFiches());
				System.out.println(speler.geefFiches());
				spelersTableData.addElement(tabelRij); 
			}
		}
		
		spelersTable = new JTable(spelersTableData, spelersTableHeader){ 
			public Component prepareRenderer (TableCellRenderer renderer, int row, int column) { 
				Component c = super.prepareRenderer( renderer, row, column); 
				// 	We want renderer component to be 
				// 	transparent so background image is visible 
				if( c instanceof JComponent ) 
				((JComponent)c).setOpaque(false); 
				return c; 
			}
		};
		spelersTable.setOpaque(false);
		TableColumn kolom1 = spelersTable.getColumnModel().getColumn(1);
		kolom1.setPreferredWidth(20);
		
		playerPanel = null;
		playerPanel = new JScrollPane(spelersTable);
		playerPanel.getViewport().setOpaque(false);
		playerPanel.setBounds(new java.awt.Rectangle(0,0,200,529));
		scrollPanels.add(playerPanel);
		playerPanel.setOpaque(false);
	}
	
	public void startSpel(Spel hetSpel) {
		allesWisselenButton.setEnabled(true);
		wisselenButton.setEnabled(true);
		overslaanButton.setEnabled(true);
		passenButton.setEnabled(true);
		this.hetSpel = hetSpel;
		this.deTafel = hetSpel.getTafel();
		eersteBeurt();
	}
	
	public void eersteBeurt() {
		eersteRonde = true;
		deTafelPanel.removeAll();
		deTafelPanel.setVisible(false);
		mijnHandPanel.removeAll();
		mijnHandPanel.setVisible(false);
		buildSpelersTable();
		bouwDeTafel();
		deTafelPanel.add(tafelKaart1Button);
		deTafelPanel.add(tafelKaart2Button);
		deTafelPanel.add(tafelKaart3Button);
		bouwHand();
		mijnHandPanel.add(handKaart1Button);
		mijnHandPanel.add(handKaart2Button);
		mijnHandPanel.add(handKaart3Button);
		deTafelPanel.repaint();
		mijnHandPanel.repaint();
		deTafelPanel.setVisible(true);
		mijnHandPanel.setVisible(true);
		eersteRonde = false;
		SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(hetSpel.getHuidigeSpelRonde().getActiveDeelname().getSpeler());
		if(speler.isHumanSpeler()) {
			int sure = JOptionPane.showConfirmDialog(this, "Wilt u alle kaarten wisselen met die van de tafel?", "?", JOptionPane.OK_CANCEL_OPTION);
			if(sure == 0) {
				hetSpel.ruil3Kaart();
			}
			else {
				allesWisselenButton.setEnabled(false);
				deTafelPanel.removeAll();
				deTafelPanel.setVisible(false);
				bouwDeTafel();
				deTafelPanel.add(tafelKaart1Button);
				deTafelPanel.add(tafelKaart2Button);
				deTafelPanel.add(tafelKaart3Button);
				deTafelPanel.repaint();
				deTafelPanel.setVisible(true);
			}
		}
	}
	
	public void updateScherm() {
		allesWisselenButton.setEnabled(true);
		SpelRonde huidigeRonde = hetSpel.getHuidigeSpelRonde();
		deTafelPanel.removeAll();
		deTafelPanel.setVisible(false);
		mijnHandPanel.removeAll();
		mijnHandPanel.setVisible(false);
		buildSpelersTable();
		bouwDeTafel();
		deTafelPanel.add(tafelKaart1Button);
		deTafelPanel.add(tafelKaart2Button);
		deTafelPanel.add(tafelKaart3Button);
		bouwHand();
		mijnHandPanel.add(handKaart1Button);
		mijnHandPanel.add(handKaart2Button);
		mijnHandPanel.add(handKaart3Button);
		deTafelPanel.repaint();
		mijnHandPanel.repaint();
		deTafelPanel.setVisible(true);
		mijnHandPanel.setVisible(true);
		SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(hetSpel.getHuidigeSpelRonde().getActiveDeelname().getSpeler());
		if(speler.isHumanSpeler()) {
			JOptionPane.showMessageDialog(this, "Het is de beurt van " + speler.geefNaam() + ".", "Volgende speler", JOptionPane.WARNING_MESSAGE );
		}
	}
	
	public void bouwDeTafel() {
		if(!eersteRonde) {
			Vector deKaarten = deTafel.getKaarten();
			Kaart kaart1 = (Kaart) deKaarten.get(0);
			Kaart kaart2 = (Kaart) deKaarten.get(1);
			Kaart kaart3 = (Kaart) deKaarten.get(2);
			
			tafelKaart1Button = new JButton();
			tafelKaart2Button = new JButton();
			tafelKaart3Button = new JButton();
			tafelKaart1Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK1ActionPerformed(evt);
				}
			});
			tafelKaart2Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK2ActionPerformed(evt);
				}
			});
			tafelKaart3Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK3ActionPerformed(evt);
				}
			});
			tafelKaart1Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart1.geefGifAdr()))));
			tafelKaart2Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart2.geefGifAdr()))));
			tafelKaart3Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart3.geefGifAdr()))));
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		else {
			tafelKaart1Button = new JButton();
			tafelKaart2Button = new JButton();
			tafelKaart3Button = new JButton();
			tafelKaart1Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK1ActionPerformed(evt);
				}
			});
			tafelKaart2Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK2ActionPerformed(evt);
				}
			});
			tafelKaart3Button.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					tK3ActionPerformed(evt);
				}
			});
			tafelKaart1Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("main/resources/kaarten/blank.jpg"))));
			tafelKaart2Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("main/resources/kaarten/blank.jpg"))));
			tafelKaart3Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("main/resources/kaarten/blank.jpg"))));
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
	}
	
	public void bouwHand() {
		handKaart1Button = new JButton();
		handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		handKaart1Button.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				hK1ActionPerformed(evt);
			}
		});
		handKaart2Button = new JButton();
		handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		handKaart2Button.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				hK2ActionPerformed(evt);
			}
		});
		handKaart3Button = new JButton();
		handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		handKaart3Button.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				hK3ActionPerformed(evt);
			}
		});
		//Haal de huidige deelnemer zijn kaarten op.
		SpelRonde huidigeRonde = hetSpel.getHuidigeSpelRonde();
		Deelname huidigeDeelname = huidigeRonde.getActiveDeelname();
		Vector deKaarten = huidigeDeelname.getKaarten();
		Kaart kaart1 = (Kaart) deKaarten.get(0);
		Kaart kaart2 = (Kaart) deKaarten.get(1);
		Kaart kaart3 = (Kaart) deKaarten.get(2);
		handKaart1Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart1.geefGifAdr()))));
		handKaart2Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart2.geefGifAdr()))));
		handKaart3Button.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(kaart3.geefGifAdr()))));
	}


	/** Auto-generated event handler method */
	protected void passenButtonActionPerformed(ActionEvent evt){
		int sure = JOptionPane.showConfirmDialog(this, "Weet u zeker dat u wilt passen?", "Check", JOptionPane.OK_CANCEL_OPTION);
		if(sure == 0) {
			System.out.println("Passen");
			hetSpel.pas();
		}
	}

	/** Auto-generated event handler method */
	protected void overslaanButtonActionPerformed(ActionEvent evt){
		hetSpel.doorSchuiven();
	}

	/** Auto-generated event handler method */
	protected void wisselenButtonActionPerformed(ActionEvent evt){
		if((hk1Selected || hk2Selected || hk3Selected) && (tk1Selected || tk2Selected || tk3Selected)) {
			int handKaart = 0;
			if(hk1Selected) {
				handKaart = 1;
			}
			else if(hk2Selected) {
				handKaart = 2;
			}
			else if(hk3Selected) {
				handKaart = 3;
			}
			handKaart--;
			
			SpelRonde huidigeRonde = hetSpel.getHuidigeSpelRonde();
			Deelname huidigeDeelname = huidigeRonde.getActiveDeelname();
			Vector deKaarten = huidigeDeelname.getKaarten();
			Kaart deHandKaart = (Kaart) deKaarten.get(handKaart);
			
			int tafelKaart = 0;
			if(tk1Selected) {
				tafelKaart = 1;
			}
			else if(tk2Selected) {
				tafelKaart = 2;
			}
			else if(tk3Selected) {
				tafelKaart = 3;
			}
			tafelKaart--;
			
			Vector deTafelKaarten = deTafel.getKaarten();
			Kaart deTafelKaart = (Kaart) deTafelKaarten.get(tafelKaart);
			hetSpel.ruil1Kaart(deHandKaart, deTafelKaart);
			
		}
		else {
			JOptionPane.showMessageDialog(this,"U moet 1 kaart van uw hand en 1 kaart van de tafel hiervoor selecteren.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/** Auto-generated event handler method */
	protected void allesWisselenButtonActionPerformed(ActionEvent evt){
		int sure = JOptionPane.showConfirmDialog(this, "Weet u zeker dat u alle kaarten wil wisselen?", "Check", JOptionPane.OK_CANCEL_OPTION);
		if(sure == 0) {
			hetSpel.ruil3Kaart();
		}
	}
	
	protected void hK1ActionPerformed(ActionEvent evt){
		mijnHandPanel.setVisible(false);
		if(hk1Selected) {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			hk1Selected = false;
			hk2Selected = false;
			hk3Selected = false;
		}
		else {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			hk1Selected = true;
			hk2Selected = false;
			hk3Selected = false;
		}
		mijnHandPanel.repaint();
		mijnHandPanel.setVisible(true);
	}
		
	protected void hK2ActionPerformed(ActionEvent evt){
		mijnHandPanel.setVisible(false);
		if(hk2Selected) {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			hk1Selected = false;
			hk2Selected = false;
			hk3Selected = false;
		}
		else {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			hk1Selected = false;
			hk2Selected = true;
			hk3Selected = false;
		}
		mijnHandPanel.repaint();
		mijnHandPanel.setVisible(true);
	}
		
	protected void hK3ActionPerformed(ActionEvent evt){
		mijnHandPanel.setVisible(false);
		if(hk3Selected) {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			hk1Selected = false;
			hk2Selected = false;
			hk3Selected = false;
		}
		else {
			handKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			handKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			hk1Selected = false;
			hk2Selected = false;
			hk3Selected = true;
		}
		mijnHandPanel.repaint();
		mijnHandPanel.setVisible(true);
	}
		
	protected void tK1ActionPerformed(ActionEvent evt){
		deTafelPanel.setVisible(false);
		if(tk1Selected) {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tk1Selected = false;
			tk2Selected = false;
			tk3Selected = false;
		}
		else {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tk1Selected = true;
			tk2Selected = false;
			tk3Selected = false;
		}
		deTafelPanel.repaint();
		deTafelPanel.setVisible(true);
	}
		
	protected void tK2ActionPerformed(ActionEvent evt){
		deTafelPanel.setVisible(false);
		if(tk2Selected) {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tk1Selected = false;
			tk2Selected = false;
			tk3Selected = false;
		}
		else {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tk1Selected = false;
			tk2Selected = true;
			tk3Selected = false;
		}
		deTafelPanel.repaint();
		deTafelPanel.setVisible(true);
	}
		
	protected void tK3ActionPerformed(ActionEvent evt){
		deTafelPanel.setVisible(false);
		if(tk3Selected) {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tk1Selected = false;
			tk2Selected = false;
			tk3Selected = false;
		}
		else {
			tafelKaart1Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart2Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			tafelKaart3Button.setBorder(new LineBorder(new java.awt.Color(0,0,0), 3, false));
			tk1Selected = false;
			tk2Selected = false;
			tk3Selected = true;
		}
		deTafelPanel.repaint();
		deTafelPanel.setVisible(true);
	}
	
	
}
