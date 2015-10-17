package SharedMemory;
import java.util.*;

import Common.IVectorDefinition;

public interface ICamera {
	
	IVectorDefinition getMovementVector();
	IVectorDefinition getPositionUnitVector();	
	List<IObject> getVisibleObjects();
	
}
