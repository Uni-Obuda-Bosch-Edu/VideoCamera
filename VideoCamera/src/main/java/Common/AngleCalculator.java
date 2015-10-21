package Common;

public class AngleCalculator {

	
	public static double getRotationAngle(IRotationMatrix matrix) {
		
		double sin = matrix.getMatrixMember(1, 0);
		double cos = matrix.getMatrixMember(1, 1);
		
		if(sin > 0 && cos > 0) //0-90
		{
			return Math.toDegrees(Math.atan(sin/cos));
		}
		
		if(sin > 0 && cos < 0) //90-180
		{
			return Math.toDegrees(Math.atan(sin/cos)) + 180;
		}
		
		if(sin < 0 && cos < 0) //180-270
		{
			return Math.toDegrees(Math.atan(sin/cos)) + 180;
		}
		
		if(sin < 0 && cos > 0) //270-360
		{
			return Math.toDegrees(Math.atan(sin/cos)) + 360;
		}
		
		return Math.toDegrees(Math.atan(sin/cos));
		
	}
}
