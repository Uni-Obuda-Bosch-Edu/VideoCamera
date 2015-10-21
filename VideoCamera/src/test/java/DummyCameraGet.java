import java.util.List;

import Common.IVectorDefinition;
import SharedMemory.ICameraGet;
import SharedMemory.IVisibleObject;

public class DummyCameraGet implements ICameraGet {

	private IVectorDefinition posvector;
	private List<IVisibleObject> visibleObjects;
	
	
	@Override
	public IVectorDefinition getPositionUnitVector() {
		return getPosvector();
	}

	@Override
	public List<IVisibleObject> getVisibleObjects() {
		return visibleObjects;
	}

	IVectorDefinition getPosvector() {
		return posvector;
	}

	public void setPosvector(IVectorDefinition posvector) {
		this.posvector = posvector;
	}

	public void setVisibleObjects(List<IVisibleObject> visibleObjects) {
		this.visibleObjects = visibleObjects;
	}

}
