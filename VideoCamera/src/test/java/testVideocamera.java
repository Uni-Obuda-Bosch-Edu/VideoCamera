import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Bosch.VideoCamera.VideoCamera;
import Common.PointImpl;
import Common.RotationMatrixImpl;
import Common.VectorDefinition;
import SharedMemory.ICalculatedObject;
import SharedMemory.IVisibleObject;

public class testVideocamera {

	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = null;
	    
	    rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static List<IVisibleObject> getrandomObjects()
	{
		List<IVisibleObject> objects = new ArrayList<IVisibleObject>();
		
		int num = 5000;
		
		for(int i = 0; i< num ;i++)
		{
			DummyVisibleObject dummyobject = new DummyVisibleObject();
			
			int roadSign = randInt(0,1);
			boolean isRoadSign = (roadSign != 0);
			dummyobject.setRoadSign(isRoadSign);
			
			RotationMatrixImpl rotmatrix = new RotationMatrixImpl();
			
			double degree = randInt(0,360);
			
			double sin = Math.sin(Math.toRadians(degree));
			double cos = Math.cos(Math.toRadians(degree));
			
			rotmatrix.setMatrixMember(0,0,cos);
			rotmatrix.setMatrixMember(0,1,-sin);
			rotmatrix.setMatrixMember(1,0,sin);
			rotmatrix.setMatrixMember(1,1,cos);
			
			dummyobject.setRotationMatrix(rotmatrix);
			
			dummyobject.setPosition(new PointImpl(randInt(0,300),randInt(0,300)));
			
			dummyobject.setGivenAngle(degree);
			
			objects.add(dummyobject);
		}
		
		for(IVisibleObject item : objects)
		{
			System.out.println(item.toString());
		}
		
		return objects;
	}
	
	private void Iteration()
	{
		camget.setVisibleObjects(getrandomObjects());
		camera.Iteration();
	}
	
	private void PrinStatus()
	{
		ICalculatedObject closest = camset.getClosest();
		if(closest != null)
		{
			System.out.println("Closest object:" + closest.toString());
		}
		else
		{
			System.out.println("No closest object that faces right way");
		}
	}
	
	DummyCameraGet camget = new DummyCameraGet();
	DummyCameraSet camset = new DummyCameraSet();
	VideoCamera camera;
	
	public testVideocamera()
	{
		VectorDefinition posvect = new VectorDefinition(0,0,1,1);
		camget.setPosvector(posvect);
		camera = new VideoCamera(camget, camset);
	}
	
	public static void main(String[] args) {
		
		testVideocamera camtest = new testVideocamera();
		
		char c = 's';
		
		while( c != 'q'  ) {

			  Scanner reader = new Scanner(System.in);
			     c = reader.next().charAt(0);
			     camtest.Iteration();
			     camtest.PrinStatus();
			 }
		
	}
}
