package Common;

public class PointImpl implements I2DPoint {

	@Override
	public String toString() {
		return "X: "+getX()+" Y: "+getY();
	}
	
	public PointImpl(double x, double y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	private double x;
	private double y;
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
