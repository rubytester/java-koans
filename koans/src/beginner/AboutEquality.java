package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.*;

public class AboutEquality {

	@Koan
	public void doubleEqualsTestsIfTwoObjectsAreTheSame(){
		Object object = new Object();
		Object sameObject = object;
        boolean compare = object == sameObject;
		assertEquals(compare,true);
        boolean compare_again = object == new Object();
		assertEquals(compare_again, false);
	}

	@Koan
	public void equalsMethodByDefaultTestsIfTwoObjectsAreTheSame(){
		Object object = new Object();
		assertEquals(object.equals(object), true);
		assertEquals(object.equals(new Object()), false);
    }

	@Koan
	public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqual(){
		Object object = new Integer(1);
		assertEquals(object.equals(object), true);
        Object o = new Integer(1); //let's play
        assertEquals(object.equals(o), true); //ok so it's true but was false in previous example above

		assertEquals(object.equals(new Integer(1)), true); // I thought it should be false
		// Note: This means that for the class 'Object' there is no difference between 'equal' and 'same'
	}

	@Koan
	public void objectsNeverEqualNull(){
		assertEquals(new Object().equals(null), false);
	}

	@Koan
	public void objectsEqualThemselves(){
		Object obj = new Object();
		assertEquals(obj.equals(obj), true); // duh. we did this example above
	}
}
