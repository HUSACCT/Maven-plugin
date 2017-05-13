package main.java.game31.userinterface;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import main.java.game31.domain.gamecontrol.Deelname;
import main.java.game31.domain.gamecontrol.SpelRonde;
import main.java.game31.domain.players.PlayersService;
import main.java.game31.domain.players.SpelerDTO;

import java.util.*;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class ScoreOverzichtFrame extends javax.swing.JFrame {

	private JTextArea jTextArea1;
	private JLabel jLabel1;	
	private static Vector spelRondes;
	
	public ScoreOverzichtFrame(Vector spelRondes) {
		ScoreOverzichtFrame.spelRondes = spelRondes;
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			jLabel1 = new JLabel();
			jTextArea1 = new JTextArea();
	
			BorderLayout thisLayout = new BorderLayout();
			this.getContentPane().setLayout(thisLayout);
			thisLayout.setHgap(0);
			thisLayout.setVgap(0);
			this.setSize(new java.awt.Dimension(621,435));
	
			jLabel1.setLayout(null);
			jLabel1.setText("Scoreoverzicht voor alle rondes");
			jLabel1.setAutoscrolls(true);
			this.getContentPane().add(jLabel1, BorderLayout.NORTH);
	
			this.getContentPane().add(jTextArea1, BorderLayout.CENTER);
	
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
		for(Iterator i=spelRondes.iterator();i.hasNext();)
		{
			SpelRonde sp =(SpelRonde) i.next();
			Vector deelnames = sp.geefDeelnames();
			for(Iterator j=deelnames.listIterator();j.hasNext();)
			{
				Deelname d = (Deelname) j.next();
				SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(d.getSpeler());
				jTextArea1.append(speler.geefNaam() + " " + d.geefEindScore() + " ; ");
			}
			jTextArea1.append("\n");
		}
	}

	/** Auto-generated main method
	public static void main(String[] args){
		showGUI();
	}

	* This static method creates a new instance of this class and shows
	* it inside a new JFrame, (unless it is already a JFrame).
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	
	public static void showGUI(){
		try {
			ScoreOverzichtFrame inst = new ScoreOverzichtFrame();
			inst.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
}
