package Common;

import SharedMemory.ICalculatedObject;
import SharedMemory.IVisibleObject;

public class CalculatedObjectImpl implements ICalculatedObject {

	IVectorDefinition posvect;
	IVisibleObject object;
	
	public CalculatedObjectImpl(IVectorDefinition posvect, IVisibleObject object)
	{
		this.posvect = posvect;
		this.object = object;
	}
	
	@Override
	public IRotationMatrix getRotation() {
		return this.object.getRotation();
	}

	@Override
	public I2DPoint getPosition() {
		return this.object.getPosition();
	}

	@Override
	public double getDistance() {
		
		double x1 = posvect.getPointStart().getX();
		double y1 = posvect.getPointStart().getY();
		
		double x2 = this.object.getPosition().getX();
		double y2 = this.object.getPosition().getY();
		
		return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
	}

	@Override
	public boolean isRoadSign() {
		// TODO Auto-generated method stub
		return true;
	}

}
