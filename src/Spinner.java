import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Spinner extends JSpinner implements ChangeListener{
	
	TreePanel treePanel;
	SpinnerModel model;
	
	final int INITVALUE = 100;
	final int MAX = 150;
	final int MIN = 10;
	final int STEP = 10;
	
	Spinner(TreePanel treePanel){
		this.treePanel = treePanel;
		
		model = new SpinnerNumberModel(INITVALUE, MIN, MAX, STEP);
		
		this.setModel(model);
		this.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		this.treePanel.setDepth((int)this.getValue());
		this.treePanel.paintFromOutSide();
	}

}
