import Common.AngleCalculator;
import Common.I2DPoint;
import Common.IRotationMatrix;
import SharedMemory.IVisibleObject;

public class DummyVisibleObject implements IVisibleObject {

	
	private double givenAngle;
	
	
	@Override
	public String toString() {
		return "RoadSign: "+isRoadSign() +" "+ getPosition().toString() +" Angle:" + getRotationAngle() + " GivenAngle: "+givenAngle;
	}
	
	private IRotationMatrix rotationMatrix;
	
	@Override
	public IRotationMatrix getRotation() {
		return this.getRotationMatrix();
	}

	private I2DPoint position;
	
	@Override
	public I2DPoint getPosition() {
		return this.position;
	}
	
	private boolean roadSign;
	
	@Override
	public boolean isRoadSign() {
		return roadSign;
	}

	IRotationMatrix getRotationMatrix() {
		return rotationMatrix;
	}

	void setRotationMatrix(IRotationMatrix rotationMatrix) {
		this.rotationMatrix = rotationMatrix;
	}

	void setPosition(I2DPoint position) {
		this.position = position;
	}

	void setRoadSign(boolean roadSign) {
		this.roadSign = roadSign;
	}

	@Override
	public double getRotationAngle() {
		return AngleCalculator.getRotationAngle(getRotationMatrix());
	}

	double getGivenAngle() {
		return givenAngle;
	}

	void setGivenAngle(double givenAngle) {
		this.givenAngle = givenAngle;
	}

	

}
