package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PublicListInterfaceTest {

	private ListInterface<String> list;

	@Before
	public void setup(){
          list = new RecursiveList<String>();
	}

	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());

	}
	
	@Test (timeout = 500)
	public void testInsertLast(){
		assertTrue(list.isEmpty());
		list.insertLast("tami");
		list.insertLast("michelle");
		assertEquals(2, list.size());
		assertEquals("michelle", list.getLast());
	}
	
	@Test (timeout = 500)
	public void testInsertAt(){
		assertTrue(list.isEmpty());
		list.insertFirst("tami");
		list.insertLast("michelle");
		list.insertLast("ana");
		assertEquals(3, list.size());
		
		list.insertAt(1, "ruth");
		list.insertAt(2, "martina");
		assertEquals(5, list.size());
		assertEquals("tami", list.get(0));
		assertEquals("ruth", list.get(1));
		assertEquals("martina", list.get(2));
		assertEquals("michelle", list.get(3));
		assertEquals("ana", list.get(4));
		
	}
	
	@Test (timeout = 500)
	public void testRemoveFirst(){
		assertTrue(list.isEmpty());
		list.insertFirst("tami");
		list.insertFirst("michelle");
		list.insertFirst("julia");
		assertEquals(3, list.size());
		
		assertEquals("julia", list.getFirst());
	}
	
	@Test (timeout = 500)
	public void testRemoveLast(){
		assertTrue(list.isEmpty());
		list.insertFirst("tami");
		list.insertFirst("michelle");
		list.insertFirst("julia");
		assertEquals(3, list.size());
		list.removeLast();
	}
	
	@Test (timeout = 500)
	public void testRemoveAt(){
		list.insertFirst("tami");
		list.insertFirst("michelle");
		list.insertFirst("julia");
		assertEquals(3, list.size());
		list.removeAt(1);
		assertEquals("tami", list.get(1));
	}
	
	@Test (timeout = 500)
	public void testGetLast(){
		list.insertFirst("tami");
		list.insertFirst("michelle");
		list.insertFirst("julia");
		assertEquals(3, list.size());
		
		assertEquals("tami", list.getLast());
	}
	
	@Test (timeout = 500)
	public void testGet(){
		assertTrue(list.isEmpty());
		list.insertFirst("tami");
		list.insertFirst("michelle");
		assertEquals(2, list.size());
		assertEquals("tami", list.get(1));
		
	}
	
	@Test (timeout = 500)
	public void testRemove(){
		assertTrue(list.isEmpty());
		list.insertAt(0, "janja");
		list.insertLast("julia");
		list.insertFirst("anna");
		assertEquals(3, list.size());
		list.removeFirst();
		assertTrue(list.remove("janja"));
		list.removeLast();
		assertFalse(list.remove("julia"));
		assertFalse(list.remove("janja"));
	}
	
	@Test (timeout = 500)
	public void testIndexOf(){
		assertTrue(list.isEmpty());
		list.insertFirst("tami");
		list.insertFirst("michelle");
		list.insertFirst("ana");
		list.insertFirst("ruth");
		list.insertFirst("laura");
		assertEquals(5, list.size());
		assertEquals(2, list.indexOf("ana"));
	}
	
	@Test (timeout = 500)
	public void testInsertLastRemoveLastSizeAndIsEmpty(){
		assertTrue(list.isEmpty());
		list.insertLast("julia");
		list.removeLast();
		list.insertLast("anna");
		list.removeAt(0);
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test (timeout = 500)
	public void testInsertsRemoveAndIndexOf(){
		assertTrue(list.isEmpty());
		list.insertLast("anna");
		list.insertAt(0,"julia");
		list.insertFirst("brit");
		list.insertAt(1, "laura");
		list.insertAt(1, "ash");
		list.insertAt(5, "ruth");
		assertEquals(6, list.size());
		list.removeFirst();
		list.removeLast();
		list.removeAt(1);
		assertTrue(list.remove("ash"));
		assertEquals(2, list.size());
	}
	
	@Test (timeout = 500)
	public void testInsertAtIsEmptySizeAndGetAt() { 
		list.insertFirst("brit");
		list.insertAt(0, "ana");
		list.insertAt(1, "laura");
		assertEquals(3, list.size());
		list.get(2);
		assertEquals("brit", list.get(2));	
	}
	
	@Test (timeout = 500)
	public void testInsertsGetsRemovesSize(){  
		list.insertFirst("brit");
		list.insertAt(0, "ana");
		list.insertAt(1, "laura");
		assertEquals(3, list.size());
		list.get(2);
		list.getFirst();
		list.getLast();
		assertEquals(3, list.size());
		list.removeAt(0);
		list.removeFirst();
		assertEquals(1, list.size());
		list.removeLast();
		assertTrue(list.isEmpty());
	}
	
	@Test (timeout = 500)
	public void dyingOverHere(){
		assertTrue(list.isEmpty());
		list.insertAt(0,"ana"); //1
		list.insertAt(1,"laura"); //3 /gone
		list.insertAt(1,"martina"); //2
		list.insertAt(0,"ash"); //0 /gone
		list.insertAt(4,"brit"); //4 /gone
		assertEquals("ash", list.removeFirst());  //ash
		assertEquals("laura", list.removeAt(2));  //laura
		list.get(0);     
		list.get(1);    
		list.indexOf("brit"); 
		list.indexOf("ana");
		assertEquals("brit", list.removeLast()); //brit
		list.indexOf("martina");
		assertEquals("martina", list.removeAt(1)); //martina
		assertEquals("ana", list.removeAt(0)); //ana
		assertEquals(0, list.size());
	}
	
	@Test //(timeout = 500)
	public void idkWhatToDo(){
		assertTrue(list.isEmpty());
		list.insertFirst("anna");
		list.insertLast("ana");
		list.insertAt(1, "laura");
		assertEquals(3, list.size());
		
		assertTrue(list.remove("laura"));
		assertEquals(list.indexOf("janja"), -1);

		assertFalse(list.remove("janja"));
		assertEquals(list.indexOf("ana"), 1);
		assertEquals(list.size(), 2);
		assertTrue(list.remove("ana"));
		assertEquals(list.indexOf("anna"), 0);
		assertFalse(list.remove("ana"));
		assertTrue(list.remove("anna"));
		assertEquals(list.indexOf("anna"), -1);

		assertTrue(list.isEmpty());
	}
}
