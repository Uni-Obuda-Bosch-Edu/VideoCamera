package Common;

public class RotationMatrixImpl implements IRotationMatrix {

	double[][] array = new double [2][2];
	
	@Override
	public String toString() {
		return "ROTATION: {"+array[0][0]+"," +array[0][1]+","+array[1][0]+","+array[1][1]+"}";
	}
	
	@Override
	public double getMatrixMember(int row, int col) {
		return array[row][col];
	}

	@Override
	public void setMatrixMember(int row, int col, double val) {
		array[row][col] = val;
	}
}
