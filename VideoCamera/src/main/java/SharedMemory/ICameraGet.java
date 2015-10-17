package SharedMemory;

import java.util.*;

import Common.IVectorDefinition;

public interface ICameraGet {

	IVectorDefinition getMovementVector();

	IVectorDefinition getPositionUnitVector();

	List<IObject> getVisibleObjects();

}
