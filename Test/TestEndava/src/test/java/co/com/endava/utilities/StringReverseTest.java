package co.com.endava.utilities;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class StringReverseTest {
	
	private static final String filename = "src/test/resources/Strings.csv";
	
	@Parameters
	public static List<String[]> getData() {
		return Data.csv(filename);
	}
	
	@Parameter // first data value (0) is default
	public /* NOT private */ String fInput;

	@Parameter(1)
	public /* NOT private */ String fExpected;

	@Test
	public void testReverseCadena() throws Exception {
		
		System.out.println("Input Data: " +fInput);
		
		assertEquals(fExpected, StringReverse.reverseCadena(fInput));
		
	}

}
