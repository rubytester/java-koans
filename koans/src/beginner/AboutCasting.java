package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.*;

import com.sandwich.koan.Koan;

@SuppressWarnings("unused")
public class AboutCasting {

	@Koan
	public void longPlusInt() {
		int a = 6;
		long b = 10;
		Object c = a + b;
		assertEquals(c, 16L);
		assertEquals(c instanceof Integer, false); // setting false here is not nice. code smell
        assertEquals(c instanceof Long, true);
        assertEquals(c.getClass().getName(), "java.lang.Long" ); // this tell me the full name of class
        assertEquals(c.getClass(), Long.class);  // this compares to Long.class

    }

	@Koan
	public void forceIntTypecast() {
		long a = 2147483648L;
		// What happens if we force a long value into an int?
		int b = (int) a;
		assertEquals(b, Integer.MIN_VALUE); // we overflow it?

        assertTrue(a > Integer.MAX_VALUE); // well, if Float is greater than Integer we should not cast it
        assertFalse(a < Integer.MIN_VALUE && a > Integer.MAX_VALUE); // not safe to (int) a
	}

	@Koan
	public void implicitTypecast() {
		int a = 1;
		int b = Integer.MAX_VALUE;
		long c = a + b; // still overflows int... which is the Integer.MIN_VALUE, the operation occurs prior to assignment to long
		assertEquals(c, (long) Integer.MIN_VALUE);

        // we could show overflow on int first
        int ab = a + b;
        assertEquals(ab, Integer.MIN_VALUE);

        // and then
        long abl = (long) a + (long) b;
        assertTrue(abl > Integer.MAX_VALUE); // compare what is greater

	}

	interface Sleepable {
		String sleep();
	}

	class Grandparent implements Sleepable {
		public String sleep() {
			return "zzzz";
		}
	}

	class Parent extends Grandparent {
		public String complain() {
			return "TPS reports don't even have a cover letter!";
		}
	}

	class Child extends Parent {
		public String complain() {
			return "Are we there yet!!";
		}
	}

	@Koan
	public void downCastWithInheritance() {
		Child child = new Child();
		Parent parentReference = child; // Why isn't there an explicit cast?
                                        // cause it a super type yes?
		assertEquals(child instanceof Child, true);
        assertEquals(child.getClass(), Child.class);

        assertEquals(parentReference instanceof Child, true);
        assertEquals(parentReference.getClass(), Child.class);


        assertEquals(parentReference instanceof Parent, true); // cause it's an ancestor
		assertEquals(parentReference instanceof Grandparent, true); // kind_of? in ruby
	}

	@Koan
	public void downCastAndPolymorphism() {
		Child child = new Child();
		Parent parentReference = child;
		// If the result is unexpected, consider the difference between an instance and its reference
		assertEquals(parentReference.complain(), child.complain());
	}

	@Koan
	public void upCastWithInheritance() {
		Grandparent child = new Child();
		Parent parentReference = (Parent) child; // Why do we need an explicit cast here?
                                                 //  I don't know. Why do we need it?
		Child childReference = (Child) parentReference; // Or here?
		assertEquals(childReference instanceof Child, true);
		assertEquals(childReference instanceof Parent, true);
		assertEquals(childReference instanceof Grandparent, true);
	}

	@Koan
	public void upCastAndPolymorphism() {
		Grandparent child = new Child();
		Parent parent = (Child) child;
		// Think about the result. Did you expect that? Why?
		// How is that different from above?
		assertEquals(parent.complain(), ((Child) child).complain()); // o my this is so confusing
	}

	@Koan
	public void classCasting() {
		try {
			Object o = new Object();
			((Sleepable) o).sleep(); // would this even compile without the cast?
		} catch (ClassCastException x) {
            // we do in fact get ClassCastException
			//fail("Object does not implement Sleepable, maybe one of the people classes do?");
		}
	}

	@Koan
	public void complicatedCast() {
		Grandparent parent = new Parent();
		// How can we access the parent's ability to "complain" - if the reference is held as a superclass?
		assertEquals("TPS reports don't even have a cover letter!", ((Parent) parent).complain()); // this is just silly I think
	}

}
