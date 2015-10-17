package Bosch.VideoCamera;

import Common.IVectorDefinition;
import SharedMemory.ICamera;
import SharedMemory.ICameraRet;

public class VideoCamera implements ICameraRet{
	public VideoCamera(ICamera camera){
		this.camera = camera;
	}

	IVectorDefinition position;
	ICamera camera;
	
	private void Iteration(){
		
	}
	
	
	private void TranslateMatrixIntoDirectionVector()
	{
		//Extreme math here
	}
	
	private double CalculateDistanceFromObject(double ObjXPos, double ObjYPos)
	{
		double returnDistance = 0.0;
		//elv: Pitagorasz-tétel.
		returnDistance = Math.sqrt(Math.pow((ObjXPos - position.getPointStart().getX()), 2) + Math.pow((ObjYPos - position.getPointStart().getY()), 2));
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
