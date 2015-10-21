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
		double gamma = obj.getRotationAngle();
		
		//System.out.println( "alpha: "+alpha +" gamma: "+gamma + " "+ (Math.abs(gamma-alpha) < 90));
		
		
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
	
	public void Iteration() {

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
		
		if(calcualtedObjects.size() >= 1)
		{
			cameraSet.setClosestObject(calcualtedObjects.get(0));
		}
		else
		{
			cameraSet.setClosestObject(null);
		}
	}

	private double calcDegree(IVectorDefinition vect)
	{
		return Math.toDegrees(Math.atan(vect.getPointEnd().getY()/vect.getPointEnd().getX()));
	}
	
	

}
