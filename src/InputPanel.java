import java.awt.*;


import javax.swing.*;
import javax.swing.border.LineBorder;



public class InputPanel extends JPanel{
	
	TreePanel treePanel;
	Slider slider;
	Spinner spinner;

	InputPanel(TreePanel treePanel){
		this.setPreferredSize(new Dimension(100,50));
		this.setBorder(new LineBorder(Color.black, 2));
		this.treePanel = treePanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// slider for angle
		slider = new Slider(this.treePanel);
		spinner = new Spinner(this.treePanel);
		this.add(slider);
		this.add(spinner);
		
		//spinner for depth
		
		
	}

	
}
