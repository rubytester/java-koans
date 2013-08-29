package beginner;

// FYI - usually bad practice to import statically, but can make code cleaner
import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;
import static com.sandwich.util.Assert.assertFalse;
import static com.sandwich.util.Assert.assertNotNull;
import static com.sandwich.util.Assert.assertNotSame;
import static com.sandwich.util.Assert.assertNull;
import static com.sandwich.util.Assert.assertSame;
import static com.sandwich.util.Assert.assertTrue;

import com.sandwich.koan.Koan;

public class AboutAssertions {

	@Koan 
	public void assertBooleanTrue() {
        boolean x = true;
		assertTrue(x); // should be true really
	}

	@Koan
	public void assertBooleanFalse() {
        boolean x = false;
		assertFalse(x);
	}
	
	@Koan
	public void assertNullObject(){
        String s = null;
		assertNull(s);
	}
	
	@Koan
	public void assertNotNullObject(){
        String s = "I am here";
		assertNotNull(s); // anything other than null should pass here...
	}

	@Koan
	public void assertEqualsUsingExpression(){
        String s = "Hello World!";
		assertTrue("Hello World!".equals(s));
	}

	@Koan
	public void assertEqualsWithBetterFailureMessage(){
        Integer i = 1;
		assertEquals(1, i);
	}

	@Koan
	public void assertEqualsWithDescriptiveMessage() {
		// Generally, when using an assertXXX methods, expectation is on the 
		// left and it is best practice to use a String for the first arg 
		// indication what has failed
        Integer answer = 42;
		assertEquals("The answer to 'life the universe and everything' should be 42", 42, answer);
	}
	
	@Koan
	public void assertSameInstance(){
		Object same				= new Integer(1);
		Object sameReference	= same;
		assertSame(same, sameReference);
	}
	
	@Koan
	public void assertNotSameInstance(){
		Integer same           = new Integer(1);
		Integer sameReference  = new Integer(same);
		assertNotSame(same, sameReference); 
	}
}
