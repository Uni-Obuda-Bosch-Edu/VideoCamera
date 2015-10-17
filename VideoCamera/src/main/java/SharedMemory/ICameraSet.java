package SharedMemory;

import Common.IVectorDefinition;

public interface ICameraSet {
	void setCameraPosition(IVectorDefinition position);

	void setMaxViewDistance(double value);

	void setFieldOfView(double value);
}
