package stack;

public class QueueSimulation {

	public static void main(String[] args) {

		ArrayStack<Integer> ints = new ArrayStack<Integer>();
		int a = 2;
		int b = 2;
		int c = 3;
		int d = 8;

		ints.push(a);
		ints.push(b);
		ints.push(c);
		ints.push(d);
		int[] strINT = new int[ints.size()];
		String revercedINT = "";
		for(int i = ints.size()-1;i>=0;i--)
		{
			strINT[i] = ints.pop();

		}
		for (int i = 0;i<strINT.length;i++)
		{
			revercedINT += strINT[i];
			if(i<strINT.length-1)
			{
				revercedINT+= ", ";
			}
		}
		
	
		ArrayStack<String> strings = new ArrayStack<String>();
		String z = "Z";
		String y = "Y";
		String x = "X";
		String w = "W";
		
		strings.push(z);
		strings.push(y);
		strings.push(x);
		strings.push(w);
		
		String[] strSTR = new String[strings.size()];
		String revercedSTR = "";
		for(int i = strings.size()-1;i>=0;i--)
		{
			strSTR[i] = strings.pop();

		}
		for (int i = 0;i<strSTR.length;i++)
		{
			revercedSTR += strSTR[i];
			if(i<strSTR.length-1)
			{
				revercedSTR+= ", ";
			}
		}
		System.out.println(revercedINT+", " + revercedSTR);
	}
	

}
