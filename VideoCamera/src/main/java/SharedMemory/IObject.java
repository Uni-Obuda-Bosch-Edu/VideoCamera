package SharedMemory;

import Common.I2DPoint;
import Common.IRotationMatrix;

public interface IObject {
	
	IRotationMatrix getRotation();

	I2DPoint getPosition();
}
