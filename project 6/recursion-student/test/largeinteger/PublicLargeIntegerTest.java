package largeinteger;

import static org.junit.Assert.*;

import org.junit.Test;

public class PublicLargeIntegerTest {

	private LargeInteger number;

	@Test
	public void testConstructor0() {
		number = new LargeInteger("0");
		assertTrue(number.size()==1);
		assertTrue(number.getList().data==0);
		assertTrue(number.getList().link==null);
	}

	@Test
	public void testConstructor1() {
		number = new LargeInteger("123");
		assertTrue(number.size()==3);
		LLNode<Integer> node = number.getList();
		assertTrue(node.data==3);
		node = node.link;
		assertTrue(node.data==2);
		node = node.link;
		assertTrue(node.data==1);
		node = node.link;
		assertTrue(node==null);
	}
	
	@Test
	public void testToString0() {
		number = new LargeInteger("123");
		assertTrue(number.toString().equals("123"));
	}

	@Test
	public void testToString1() {
		number = new LargeInteger("111222333444555666777888999000");
		assertTrue(number.toString().equals("111222333444555666777888999000"));
	}
	
	@Test
	public void testDivide10() {
		number = new LargeInteger("15");
		LargeInteger result = number.divide10();
		assertTrue(number==result);	// returns the same LargeInteger object
		assertTrue(number.getList().data==1);
		assertTrue(number.getList().link==null);
		assertTrue(number.size()==1);
		assertTrue(number.toString().equals("1"));
	}
	
	@Test
	public void testDivide10More() {
		number = new LargeInteger("9");
		LargeInteger result = number.divide10();
		assertTrue(number==result);	// returns the same LargeInteger object
		assertTrue(number.getList().data==0);
		assertTrue(number.getList().link==null);
		assertTrue(number.size()==1);
		assertTrue(number.toString().equals("0"));
		
		number = new LargeInteger("123456789");
		assertTrue(number.divide10().toString().equals("12345678"));
		assertTrue(number.size()==8);
		assertTrue(number.getList().data==8);
	}
	
	@Test
	public void testMultiply10() {
		number = new LargeInteger("15");
		LargeInteger result = number.multiply10();
		assertTrue(number==result);
		assertTrue(number.toString().equals("150"));
		assertTrue(number.size()==3);
		assertTrue(number.getList().data==0);
	}
	
	@Test
	public void testMultiply10More() {
		number = new LargeInteger("0");
		assertTrue(number.multiply10().toString().equals("0"));
		assertTrue(number.multiply10().size()==1);
		assertTrue(number.multiply10().getList().data==0);
	}
	
	@Test
	public void testAdd0() {
		LargeInteger i1 = new LargeInteger("123");
		LargeInteger i2 = new LargeInteger("456");
		number = i1.add(i2);
		assertTrue(number.toString().equals("579"));
		assertTrue(number.size()==3);
		assertTrue(number!=i1);	// check return is a new object
		assertTrue(number!=i2); // check return is a new object
	}

	@Test
	public void testAdd1() {
		LargeInteger i1 = new LargeInteger("987");
		LargeInteger i2 = new LargeInteger("876");
		number = i1.add(i2);
		assertTrue(number.toString().equals("1863"));
		assertTrue(number.size()==4);
		assertTrue(number!=i1);
		assertTrue(number!=i2);
	}
	
	@Test
	public void testAdd2() {
		LargeInteger i1 = new LargeInteger("999");
		LargeInteger i2 = new LargeInteger("1");
		number = i1.add(i2);
		assertTrue(number.toString().equals("1000"));
		assertTrue(number.size()==4);
		
		number = i2.add(i1);
		assertTrue(number.toString().equals("1000"));
		assertTrue(number.size()==4);
		assertTrue(number!=i1);
		assertTrue(number!=i2);
	}
	
	@Test
	public void testMultiply0() {
		number = new LargeInteger("123");
		assertTrue(number.multiply(1)!=number); // check return is a new object
		assertTrue(number.multiply(1).toString().equals("123"));
		assertTrue(number.multiply(2).toString().equals("246"));
		assertTrue(number.multiply(2).size()==3);
	}

	@Test
	public void testMultiply1() {
		number = new LargeInteger("123");
		assertTrue(number.multiply(12).toString().equals("1476"));
		assertTrue(number.multiply(12).size()==4);
		assertTrue(number.multiply(0).toString().equals("0"));
		assertTrue(number.multiply(0).size()==1);
		assertTrue(number.multiply(123).toString().equals("15129"));
	}
	
	@Test
	public void testFactorial0() {
		number = LargeInteger.factorial(5);
		assertTrue(number.toString().equals("120"));
	}
	
	@Test
	public void testFactorial1() {
		number = LargeInteger.factorial(20);
		assertTrue(number.toString().equals("2432902008176640000"));
		assertTrue(number.size()==19);  // make sure size is also correct
	}
	
	@Test
	public void testPow0() {
		number = LargeInteger.pow(2, 10);
		assertTrue(number.toString().equals("1024"));
	}
	
	@Test
	public void testPow1() {
		number = LargeInteger.pow(5, 20);
		assertTrue(number.toString().equals("95367431640625"));
		assertTrue(number.size()==14);  // make sure size is also correct
	}
}
