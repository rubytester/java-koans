package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import com.sandwich.koan.Koan;

public class AboutPrimitives {

	@Koan
	public void wholeNumbersAreOfTypeInt() {
        Object t = getType(1);  // so it's just an Object then
		assertEquals(getType(1), int.class); // hint: int.class
        // I ma curious what getType returns and surprised that int is a primitive available just by calling int.
	}

	@Koan
	public void primitivesOfTypeIntHaveAnObjectTypeInteger() {
		Object number = 1;
        //number.getClass(); // java.lang.Integer
		assertEquals(getType(number),number.getClass());
        assertEquals(getType(number).getName(),"java.lang.Integer"); // so getName gives me class as String. AHA!

        // Primitives can be automatically changed into their object type via a process called auto-boxing
		// We will explore this in more detail in intermediate.AboutAutoboxing
	}

	@Koan
	public void integersHaveAFairlyLargeRange() {
		assertEquals(Integer.MIN_VALUE, -2147483648); // Integer is from MIN -2^31 to MAX is 2^31-1
		assertEquals(Integer.MAX_VALUE, 2147483647); //like a phone number in Dallas TX 214 748 3647
	}

	@Koan
	public void integerSize() {
        // SIZE returns int
		assertEquals(Integer.SIZE, 32);  // This is the amount of bits used to store an int
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeLong() {
		assertEquals(getType(1L), long.class); // as primitive you get long.class but...
	}

	@Koan
	public void primitivesOfTypeLongHaveAnObjectTypeLong() {
		Object number = 1L;
		assertEquals(getType(number), number.getClass()); //but as object you getClass???
        assertEquals(getType(number).getName(), "java.lang.Long"); //and getName for actual string then.
        Long n = 1L; // well, number does not have to be Object as above righ?
        assertEquals(n.getClass().getName(), "java.lang.Long");
    }

	@Koan
	public void longsHaveALargerRangeThanInts() {
        // Long is from -2^63 to 2^63-1 range
		assertEquals(Long.MIN_VALUE, -9223372036854775808L); //so you have to add L or l to the end of number then
		assertEquals(Long.MAX_VALUE, 9223372036854775807L);  // Capital L is better since small l looks like 1
	}

	@Koan
	public void longSize() {
        // returns int
		assertEquals(Long.SIZE, 64);  //returns int 64 bits
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeShort() {
		assertEquals(getType((short) 1), short.class); // The '(short)' is called an explicit cast - to type 'short'
	}

	@Koan
	public void primitivesOfTypeShortHaveAnObjectTypeShort() {
		Object number = (short) 1;
		assertEquals(getType(number), number.getClass());
        assertEquals(getType(number).getName(), "java.lang.Short"); //extract string representation of class

    }

	@Koan
	public void shortsHaveASmallerRangeThanInts() {
        // from -2^15 to 2^15-1 (-32768 to 32767)
        Short min = new Short(Short.MIN_VALUE); //Do I need to do this? is there an easier way?
		assertEquals(Short.MIN_VALUE, min);  // hint: You'll need an explicit cast
        Short max = new Short(Short.MAX_VALUE); //Do I need to do this? is there an easier way?
        assertEquals(Short.MAX_VALUE, max);
        // can't do that assertEquals(Short.MAX_VALUE, 32767);
	}

	@Koan
	public void shortSize() {
		assertEquals(Short.SIZE, 16);
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeByte() {
		assertEquals(getType((byte) 1), byte.class); //this is just byte
	}

	@Koan
	public void primitivesOfTypeByteHaveAnObjectTypeByte() {
		Object number = (byte) 1;
		assertEquals(getType(number), number.getClass()); // but this is java.lang.Byte class
	}

	@Koan
	public void bytesHaveASmallerRangeThanShorts() {
        // yep -128..127 (-2^7 to 2^7-1)
		assertEquals(Byte.MIN_VALUE, (byte)-128);
		assertEquals(Byte.MAX_VALUE, (byte)127);

		// Why would you use short or byte considering that you need to do explicit casts?
	}

	@Koan
	public void byteSize() {
		assertEquals(Byte.SIZE, 8); //returns int
        int x = 8;
        assertEquals(Byte.SIZE, x);
        Integer y = 8;
        assertEquals(Byte.SIZE, y);
    }

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeChar() {
		assertEquals(getType((char) 1), char.class);
	}

	@Koan
	public void singleCharactersAreOfTypeChar() {
		assertEquals(getType('a'), char.class); //yep, single quotes for literal char
	}

	@Koan
	public void primitivesOfTypeCharHaveAnObjectTypeCharacter() {
		Object number = (char) 1;
		assertEquals(getType(number), number.getClass()); // but this is no longer char.class but java.lang.Character
        assertEquals(getType(number).getName(), "java.lang.Character");
	}

	@Koan
	public void charsCanOnlyBePositive() {
		assertEquals((int) Character.MIN_VALUE, 0);  //returns '\u0000'  0
		assertEquals((int) Character.MAX_VALUE, 65535); // returns '\uFFFF'  65535

        assertEquals((int) Character.MIN_VALUE, (int) '\u0000'); //cast char to int
        assertEquals((int) Character.MAX_VALUE, (int) '\uFFFF');


        // Why did we cast MIN_VALUE and MAX_VALUE to int? Try it without the cast.
	}

	@Koan
	public void charSize() {
		assertEquals(Character.SIZE, 16);
	}

	@Koan
	public void decimalNumbersAreOfTypeDouble() {
		assertEquals(getType(1.0), double.class);
	}

	@Koan
	public void primitivesOfTypeDoubleCanBeDeclaredWithoutTheDecimalPoint() {
		assertEquals(getType(1d), double.class);
	}

	@Koan
	public void primitivesOfTypeDoubleCanBeDeclaredWithExponents() {
		assertEquals(getType(1e3), double.class);
		assertEquals(1.0e3, 1000.0);
		assertEquals(1E3, 1000.0);
	}

	@Koan
	public void primitivesOfTypeDoubleHaveAnObjectTypeDouble() {
		Object number = 1.0;
		assertEquals(getType(number), number.getClass());
        assertEquals(getType(number).getName(), "java.lang.Double");

	}

	@Koan
	public void doublesHaveALargeRange() {
		assertEquals(Double.MIN_VALUE, __);
		assertEquals(Double.MAX_VALUE, __);
	}

	@Koan
	public void doubleSize() {
		assertEquals(Double.SIZE, __);
	}

	@Koan
	public void decimalNumbersCanAlsoBeOfTypeFloat() {
		assertEquals(getType(1f), __);
	}

	@Koan
	public void primitivesOfTypeFloatCanBeDeclaredWithExponents() {
		assertEquals(getType(1e3f), __);
		assertEquals(1.0e3f, __);
		assertEquals(1E3f, __);
	}

	@Koan
	public void primitivesOfTypeFloatHaveAnObjectTypeFloat() {
		Object number = 1f;
		assertEquals(getType(number), __);
	}

	@Koan
	public void floatsHaveASmallerRangeThanDoubles() {
		assertEquals(Float.MIN_VALUE, __);
		assertEquals(Float.MAX_VALUE, __);
	}

	@Koan
	public void floatSize() {
		assertEquals(Float.SIZE, __);
	}

	private Class<?> getType(int value) {
		return int.class;
	}

	private Class<?> getType(long value) {
		return long.class;
	}

	private Class<?> getType(float value) {
		return float.class;
	}

	private Class<?> getType(double value) {
		return double.class;
	}

	private Class<?> getType(byte value) {
		return byte.class;
	}

	private Class<?> getType(char value) {
		return char.class;
	}

	private Class<?> getType(short value) {
		return short.class;
	}

	private Class<?> getType(Object value) {
		return value.getClass();
	}
	
}
