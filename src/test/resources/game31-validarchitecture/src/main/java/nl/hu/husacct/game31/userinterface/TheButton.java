package nl.hu.husacct.game31.userinterface;

import java.awt.*;
import javax.swing.*;

/**
 * @author Root
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TheButton extends JButton {
	
	private JLabel buttonTekst;
	
	public TheButton(String label) {
		
		super();
		
		buttonTekst = new JLabel(label);
		buttonTekst.setSize(new Dimension(60,25));
		buttonTekst.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		buttonTekst.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		this.add(buttonTekst);
		
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("userInterface/images/theButtonOff.png")));
		this.setIconTextGap(0);
		this.setBorderPainted(false);
		this.setMargin(new Insets(0,0,0,0));
		this.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("userInterface/images/theButtonPress.png")));
		this.setRolloverEnabled(false);
		this.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("userInterface/images/theButtonOn.png")));
		this.setSize(new Dimension(60,25));
		this.setOpaque(false);		
		
	}
	
}
