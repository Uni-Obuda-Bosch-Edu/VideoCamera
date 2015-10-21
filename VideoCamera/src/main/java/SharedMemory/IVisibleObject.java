package SharedMemory;

import Common.I2DPoint;
import Common.IRotationMatrix;

public interface IVisibleObject {
	
	IRotationMatrix getRotation();
	I2DPoint getPosition();
	boolean isRoadSign();
	double getRotationAngle();
}
