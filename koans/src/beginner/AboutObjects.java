package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.sandwich.koan.Koan;

public class AboutObjects {

	@Koan
	public void newObjectInstancesCanBeCreatedDirectly() {
		assertEquals(new Object() instanceof Object, true);
        Object o = new Object();
        assertEquals(o instanceof Object, true); //instanceof is a keyword then aha! but why in this example
        // Why am I learnign instanceof here? why do I even need it? arghhh!
	}

	@Koan
	public void allClassesInheritFromObject() {
		class Foo {}

		Class<?>[] ancestors = getAncestors(new Foo());  //what the hell is this notation? array of classes?
		assertEquals(ancestors[0], Foo.class);
		assertEquals(ancestors[1], Object.class);
	}

	@Koan
	public void objectToString() {
		Object object = new Object();
		// TODO: Why is it best practice to ALWAYS override toString?
		String expectedToString = MessageFormat.format("{0}@{1}", Object.class.getName(), Integer.toHexString(object.hashCode()));
		assertEquals(expectedToString, object.toString()); // hint: object.toString()
        //ClassName@hash. visit the Object.toString comments in source code
	}

	@Koan
	public void toStringConcatenates(){
		final String string = "ha";

		Object object = new Object(){
			@Override public String toString(){
				return string;
			}
		};
		assertEquals(string + object, "haha"); // I don't get it.
        // we override toString method of an Object which should return the String object and teh actual string is 'ha'
	}

	@Koan
	public void toStringIsTestedForNullWhenInvokedImplicitly(){
		String string = "string";
		assertEquals(string+null, "stringnull"); // is it because toString for null is "null"

        // why is it "stringnull"?
    }

	private Class<?>[] getAncestors(Object object) {
		List<Class<?>> ancestors = new ArrayList<Class<?>>(); // I am noob at this.
		Class<?> clazz = object.getClass();
		while(clazz != null) {
			ancestors.add(clazz);
			clazz = clazz.getSuperclass();	
		}
		return ancestors.toArray(new Class[]{});	
	}
	
}
