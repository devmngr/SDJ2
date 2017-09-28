package billysCarL1;


public class BillyCar {

	public static void main(String[] args) {
	
		int currsState = 0;
		Car billy = new Car(0);
		boolean button = false;		
		while (true)
		{
				if (billy.Pressed() == true)
				{
					billy.state(currsState);
				}
		}
	}
}
