package nl.hu.husacct.game31.userinterface;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class NewJPanel extends javax.swing.JFrame {
	private JLabel deLabel;
	private JButton jButton1;

	public NewJPanel() {
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();

	
			this.getContentPane().setLayout(null);
			TheButton theButton1 = new TheButton("OK");
					this.getContentPane().add(theButton1);
	
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
		TheButton theButton1 = new TheButton("OK");
		this.getRootPane().add(theButton1);
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
			NewJPanel inst = new NewJPanel();
			
			inst.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
