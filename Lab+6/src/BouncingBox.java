import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class BouncingBox extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	public void add(BouncingFigure f) {
		figures.add(f);
	}

	public void paintComponent(Graphics g) {
		for (BouncingFigure f : figures) {
			f.draw(g);
			f.move();
			if (f.rightBorderCollision(this.getWidth())) {
				if (f.getTrajectory() < 360 && f.getTrajectory() > 270) {
					f.setTrajectory(180 + (360 - f.getTrajectory()));
				}
				if (f.getTrajectory() < 90 && f.getTrajectory() > 0) {
					f.setTrajectory(180 - f.getTrajectory());
				}
				if (f.getTrajectory() == 0 || f.getTrajectory() == 360) {
					f.setTrajectory(180);
				}
			}
			if (f.leftBorderCollision()) {
				if (f.getTrajectory() > 90 && f.getTrajectory() < 180) {
					f.setTrajectory(180 - f.getTrajectory());
				}
				if (f.getTrajectory() > 180 && f.getTrajectory() < 270) {
					f.setTrajectory(360 - (f.getTrajectory() - 180));
				}
				if (f.getTrajectory() == 180) {
					f.setTrajectory(0);
				}
			}
			if (f.upperBorderCollision()) {

				if (f.getTrajectory() < 90 && f.getTrajectory() > 0) {
					f.setTrajectory(360 - f.getTrajectory());
				}
				if (f.getTrajectory() > 90 && f.getTrajectory() < 180) {
					f.setTrajectory(180 + (180 - f.getTrajectory()));
				}
				if (f.getTrajectory() == 90) {
					f.setTrajectory(270);
				}
			}
			if (f.lowerBorderCollision(this.getHeight())) {
				if (f.getTrajectory() > 180 && f.getTrajectory() < 270) {
					f.setTrajectory(180 - (f.getTrajectory() - 180));
				}
				if (f.getTrajectory() < 360 && f.getTrajectory() > 270) {
					f.setTrajectory(360 - f.getTrajectory());
				}
				if (f.getTrajectory() == 270) {
					f.setTrajectory(90);
				}
			}

		}
	}
}
