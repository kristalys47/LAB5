import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class BouncingCircle extends BouncingFigure {
	private double diameter;

	
	BouncingCircle(int xLeft, int yTop, double diameter, double trajectory, int speed) {
		setXLeft(xLeft);
		setYTop(yTop);
		setTrajectory(trajectory);
		setSpeed(speed);
		this.diameter=diameter;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(getXLeft(), getYTop(), this.diameter, this.diameter);
		g2.setColor(Color.CYAN);
		g2.fill(circle);
		g2.draw(circle);
	}

	@Override
	public boolean rightBorderCollision(int screenLimit) {
		// TODO Auto-generated method stub
		return (getXLeft()+this.diameter > screenLimit);
	}

	@Override
	public boolean leftBorderCollision() {
		// TODO Auto-generated method stub
		return (getXLeft()<0);
	}

	@Override
	public boolean upperBorderCollision() {
		// TODO Auto-generated method stub
		return(getYTop()<0);
	}

	@Override
	public boolean lowerBorderCollision(int screenLimit) {
		
		return (getYTop()+this.diameter > screenLimit);
			
	}

}