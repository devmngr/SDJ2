package gui;

public class DataCheck {
		
	
	/** Check data integrity in the GUI
	 * @author Alexandru
	 * 
	 * @param ssn
	 * @param gui
	 * @return
	 */
	public static boolean CheckSSN(String ssn, MainGUI gui){
		long temp=0;
		System.out.println(ssn);
		try {
			
			if(ssn.length()==10){
			System.out.println(temp);
			temp=Long.parseLong(ssn);
			System.out.println(temp);
			return true;
			}
			else throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			gui.popUp("Employee or manager SSN incorect");
		}
		return false;
	}
	
	public static boolean CheckLongData(String data, MainGUI gui) {
		try {
			Long temp = Long.parseLong(data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			gui.popUp("Invalid data entered");
		}
		return false;
		
	}
	
}
