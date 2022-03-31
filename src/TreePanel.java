import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class TreePanel extends JPanel{
	
	Image image;
	Graphics graphics;
	
	double angle;
	int startX;
	int startY;
	int depth;
	

	TreePanel(){
		
		this.setPreferredSize(new Dimension(700,600));
		this.setBorder(new LineBorder(Color.black,2));
		this.setBackground(Color.green);
		
		angle = -90.00;
		startX = 350;
		startY = 550;
		depth = 100;
		
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g) {
		
//		System.out.println("Paint Method");
		
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0,0, this);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		drawTree(g,this.startX, this.startY, this.angle, this.depth);
	}
	
	public void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
//		System.out.println("drawTree Method");
		if(depth == 0) return;
		
		int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * depth);
		int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * depth);
		g.drawLine(x1, y1, x2, y2);
		drawTree(g, x2, y2, angle + 20, depth - 10);
		drawTree(g, x2, y2, angle - 20, depth - 10);
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void paintFromOutSide() {
		repaint();
	}
	
}

