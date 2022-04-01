import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class TreePanel extends JPanel implements MouseWheelListener{
	
	Image image;
	Graphics graphics;
	
	double angle;
	int startX;
	int startY;
	int depth;
	double translationx;
	double translationy;
	double zoomLevel;
	int offset;
	

	TreePanel(){
		
		this.setPreferredSize(new Dimension(700,600));
		this.setBorder(new LineBorder(Color.black,2));
		this.setBackground(Color.green);
		
		angle = -90.00;
		startX = 0;
		startY = 0;
		depth = 100;
		translationx = 350;
		translationy = 300;
		zoomLevel = 1;
		
		this.addMouseWheelListener(this);
		
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
		
//		x1 = adjustPoint(x1);
//		y1 = adjustPoint(y1);
//		x2 = adjustPoint(x2);
//		y2 = adjustPoint(y2);
		
//		v1 = adju
		g.drawLine(adjustPoint(x1), adjustPoint(y1), adjustPoint(x2), adjustPoint(y2));
		drawTree(g, x2, y2, angle + 20, depth - 10);
		drawTree(g, x2, y2, angle - 20, depth - 10);
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void setTranslation(double translation) {
		this.translationx = translation;
	}
	
	
	public void paintFromOutSide() {
		repaint();
	}
	
	public void adjustZoom(double rotation) {
//		if(rotation >0) {
			this.zoomLevel +=  rotation/10;
			this.zoomLevel = Math.max(this.zoomLevel, 0.5);
//		}
//		else {
//			this.zoomLevel = 1.0 - (Math.abs(rotation)/10);
//		}
	}
	
	public void move() {
		
	}
	
	public int adjustPoint(int point) {
		point =(int)((point + this.translationx) * this.zoomLevel);
		System.out.println("point " + point + " translation " + this.translationx + " zoom " + this.zoomLevel);
		return point;
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("value " + e.getWheelRotation());
		adjustZoom(e.getWheelRotation());
		System.out.println("zoom: "+ this.zoomLevel);
		repaint();
	}
	
}
