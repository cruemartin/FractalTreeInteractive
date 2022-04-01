import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;



public class Slider extends JSlider implements ChangeListener {
	
	TreePanel treePanel;
	public final int INITVALUE = -90;
	public final int MIN = -180;
	public final int MAX = 0;
	
	Slider(TreePanel treePanel){
		this.treePanel = treePanel;
		this.setOrientation(JSlider.VERTICAL);
		this.setMinimum(MIN);
		this.setMaximum(MAX);
		this.setValue(INITVALUE);
		
		Hashtable<Integer, JLabel> lableTable = new Hashtable<Integer, JLabel>();
		
		lableTable.put(-180, new JLabel("-180"));
		lableTable.put(-90, new JLabel("-90") );
		lableTable.put(0,new JLabel("0"));
		
		this.setLabelTable(lableTable);
		this.setPaintLabels(true);
	
		this.addChangeListener(this);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("CHANGE");
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
//		if(!source.getValueIsAdjusting()) {
			this.treePanel.setAngle((double)(source.getValue()));
			this.treePanel.paintFromOutSide();
		//}
		
	}
	
}
