package SharedMemory;

import java.util.*;

import Common.IVectorDefinition;

public interface ICameraGet {

	IVectorDefinition getPositionUnitVector();
	
	List<IVisibleObject> getVisibleObjects();

}
