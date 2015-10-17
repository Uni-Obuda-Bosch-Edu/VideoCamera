package SharedMemory;

import Common.IVectorDefinition;

public interface ICameraRet {
	void setCameraPosition(IVectorDefinition position);
	void setMaxViewDistance(double value);
	void setFieldOfView(double value);
}
