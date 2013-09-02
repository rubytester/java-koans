package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sandwich.koan.Koan;

public class AboutInheritance {

	class Parent {
		public String doStuff() { return "parent"; }
        public String feedMe() { return "parent feeds child"; } // calling child goes to parent
	}
	class Child extends Parent {
		public String doStuff() { return "child"; }
		public String doStuff(String s) { return s; }
	}
	
	@Koan
	public void differenceBetweenOverloadingAndOverriding() {
		assertEquals(new Parent().doStuff(),"parent");
		assertEquals(new Child().doStuff(),"child");
		assertEquals(new Child().doStuff("oh no"),"oh no");  // good example of overloading
        assertEquals(new Child().feedMe(), "parent feeds child");
	}
	
	abstract class ParentTwo {
		abstract public Collection<?> doStuff();
	}
	
	class ChildTwo extends ParentTwo {
		public Collection<?> doStuff() { return Collections.emptyList(); } // extra ; was not needed
	}
	
	@Koan
	public void overriddenMethodsMayReturnSubtype() {
		// What do you need to change in order to get rid of the type cast?
		// Why does this work?
		List<?> list = (List<?>)new ChildTwo().doStuff(); //some voodoo I don't yet understand
		assertEquals(list instanceof List, true);
        assertEquals(list.isEmpty(), true); // yep, an empty list of unknown things?

        // no type cast?
        Collection<?>  c = new ChildTwo().doStuff(); // holly mother of ...
        assertEquals(c instanceof Collection, true);
	}
}
