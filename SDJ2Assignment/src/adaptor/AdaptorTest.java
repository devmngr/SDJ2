package adaptor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdaptorTest {

	IAdaptor<String> setList;
	
	@Before
	public void before(){
		setList= new Adaptor();
	}
	
	@Test
	public void addtest() {
		setList.add("A ");
		setList.add("B ");
		setList.add("C ");

		assertEquals(true,setList.contains("A "));
		assertEquals(true,setList.contains("B "));
		assertEquals(true,setList.contains("C "));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNulltest() {
		setList.add("B ");
		setList.add(null);
		setList.add("C ");
		setList.add("D ");
		setList.add("E ");
		setList.add("F ");
	}
	
	@Test
	public void removetest() {
		setList.add("A");
		setList.add("B ");
		setList.add("C ");
		setList.add("D ");
		setList.add("E ");
		setList.add("F ");
		assertEquals("A", setList.remove("A"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void removeNullTest() {
		setList.add("A");
		setList.add("B ");
		setList.add("C ");
		setList.add("D ");
		setList.add("E ");
		setList.add("F ");
		setList.remove(null);
	}
	
	//contains
	//is empty
	//size()
	//is subset
	//is subset null param
	//union
	//union null
	

}
