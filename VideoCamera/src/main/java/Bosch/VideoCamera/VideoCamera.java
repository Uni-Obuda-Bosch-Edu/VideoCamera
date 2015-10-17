package Bosch.VideoCamera;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Common.CalculatedObjectImpl;
import Common.IRotationMatrix;
import Common.IVectorDefinition;
import SharedMemory.ICalculatedObject;
import SharedMemory.ICameraGet;
import SharedMemory.ICameraSet;
import SharedMemory.IVisibleObject;

public class VideoCamera {
	public VideoCamera(ICameraGet cameraGet, 
					   ICameraSet cameraSet) {
		this.cameraGet = cameraGet;
		this.cameraSet = cameraSet;
	}

	IVectorDefinition position;
	ICameraGet cameraGet;
	ICameraSet cameraSet;

	private boolean isObjectFacesRightDirection(IVisibleObject obj, IVectorDefinition vect)
	{
		double alpha = calcDegree(vect);
		double gamma = calcDegree(obj.getRotation());
		
		return Math.abs(gamma-alpha) < 90;
	}
	
	class Comparator implements java.util.Comparator<ICalculatedObject>
	{
		@Override
		public int compare(ICalculatedObject o1, ICalculatedObject o2) {
			
			if(o1.getDistance() < o2.getDistance())
			{
				return -1;
			}
			
			if(o1.getDistance() > o2.getDistance())
			{
				return 1;
			}
			
			return 0;
		}
	}
	
	private void Iteration() {

		IVectorDefinition vectorPos = cameraGet.getPositionUnitVector();
		List<IVisibleObject> visibleObjects = cameraGet.getVisibleObjects();
		
		List<ICalculatedObject> calcualtedObjects = new ArrayList<ICalculatedObject>();
		
		
		for(IVisibleObject obj : visibleObjects)
		{
			if(isObjectFacesRightDirection(obj, vectorPos) && obj.isRoadSign())
			{
				calcualtedObjects.add(new CalculatedObjectImpl(vectorPos, obj));
			}
		}
		
		calcualtedObjects.sort(new Comparator());
		
		List<ICalculatedObject> returnObjects = new ArrayList<ICalculatedObject>();
		
		if(returnObjects.size() >= 1)
		{
			cameraSet.setClosestObject(returnObjects.get(0));
		}
		else
		{
			cameraSet.setClosestObject(null);
		}
	}

	private double calcDegree(IVectorDefinition vect)
	{
		return Math.atan(vect.getPointEnd().getY()/vect.getPointEnd().getX());
	}
	
	private double calcDegree(IRotationMatrix matrix )
	{
		return Math.atan(matrix.getMatrixMember(2, 1)/matrix.getMatrixMember(2, 2));
	}

}
