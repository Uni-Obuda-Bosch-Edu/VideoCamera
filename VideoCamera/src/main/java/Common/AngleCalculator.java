package Common;

public class AngleCalculator {

	
	public static double getRotationAngle(IRotationMatrix matrix) {
		
		double sin = matrix.getMatrixMember(1, 0);
		double cos = matrix.getMatrixMember(1, 1);
		
		if(sin > 0 && cos > 0)
		{
			return Math.toDegrees(Math.atan(sin/cos));
		}
		
		return Math.toDegrees(Math.atan(sin/cos));
		
	}
}
