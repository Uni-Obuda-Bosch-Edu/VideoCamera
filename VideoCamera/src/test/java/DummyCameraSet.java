import SharedMemory.ICalculatedObject;
import SharedMemory.ICameraSet;

public class DummyCameraSet implements ICameraSet {

	private ICalculatedObject closest;
	
	@Override
	public void setClosestObject(ICalculatedObject closest) {
		this.setClosest(closest);
	}
	
	private double maxViewDistance;
	private double fieldOfView;

	@Override
	public void setMaxViewDistance(double value) {
		this.setMaxViewDistance(value);
	}

	@Override
	public void setFieldOfView(double value) {
		setFieldOfView(value);
	}

	double getMaxViewDistance() {
		return maxViewDistance;
	}

	private double getFieldOfView() {
		return fieldOfView;
	}

	ICalculatedObject getClosest() {
		return closest;
	}

	void setClosest(ICalculatedObject closest) {
		this.closest = closest;
	}

}
