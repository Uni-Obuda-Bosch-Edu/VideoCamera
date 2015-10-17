package Bosch.VideoCamera;

import Common.IVectorDefinition;
import SharedMemory.ICameraGet;
import SharedMemory.ICameraSet;

public class VideoCamera implements ICameraSet {
	public VideoCamera(ICameraGet camera) {
		this.camera = camera;
	}

	IVectorDefinition position;
	ICameraGet camera;

	private void Iteration() {

	}

	private void TranslateMatrixIntoDirectionVector() {
		// Extreme math here
	}

	private double CalculateDistanceFromObject(double ObjXPos, double ObjYPos) {
		double returnDistance = 0.0;
		// elv: Pitagorasz-tétel.
		returnDistance = Math.sqrt(Math.pow((ObjXPos - position.getPointStart().getX()), 2)
				+ Math.pow((ObjYPos - position.getPointStart().getY()), 2));
		return returnDistance;
	}

	@Override
	public void setCameraPosition(IVectorDefinition position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxViewDistance(double value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFieldOfView(double value) {
		// TODO Auto-generated method stub

	}

}
