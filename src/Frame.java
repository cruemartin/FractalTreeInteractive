import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Frame extends JFrame {
	
	TreePanel treePanel;
	InputPanel inputPanel;
	JPanel mainPan;
	
	
	Frame(){
		treePanel = new TreePanel();
		inputPanel = new InputPanel(treePanel);
		
//		mainPan = new JPanel();
//		mainPan.setPreferredSize(new Dimension(800,600));
//		
//		mainPan.setLayout(new GridLayout(1,1,10,10));
//		
//		mainPan.add(treePanel);
//		mainPan.add(inputPanel);
//		mainPan.setBorder(new LineBorder(Color.red,2));
		
		
//		this.setLayout(new GridLayout(1,1, 10, 10));
		
//		this.add(treePanel, BorderLayout.LINE_START);
//		this.add(inputPanel, BorderLayout.LINE_END);
//		this.add(treePanel);
//		this.add(inputPanel);
//		
//		FlowLayout layout = new FlowLayout(2);
//		layout.setHgap(10);
//		layout.setVgap(10);
		
////		this.setLayout(layout);
//		this.add(treePanel);
//		this.add(inputPanel);
//		
//		this.setLayout(new FlowLayout());
//		this.add(mainPan);
//		
		
		this.setLayout(new BorderLayout());
		
		this.add(treePanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.EAST);
		
		
		this.setResizable(false);
		this.setTitle("Interactive Fractal Tree");
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
}
