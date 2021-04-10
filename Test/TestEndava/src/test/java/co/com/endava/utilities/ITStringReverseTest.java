package co.com.endava.utilities;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.endava.data.StringRepository;
import co.com.endava.model.StringTest;


@RunWith(MockitoJUnitRunner.class)
public class ITStringReverseTest {
	
	@Mock
	private StringRepository stringRepository;
	

	@Test
	public void testReverseCadena1() throws Exception {
		
		when(stringRepository.getText(1)).thenReturn(new StringTest("foo(bar)baz(blim)","foorabbazmilb"));
		
		StringTest aux = stringRepository.getText(1);
		
		assertEquals(aux.getExpect(), StringReverse.reverseCadena(aux.getInput()));
	}
	
	@Test
	public void testReverseCadena2() throws Exception {
		
		when(stringRepository.getText(2)).thenReturn(new StringTest("foo(bar(baz))blim","foobazrabblim"));
		
		StringTest aux = stringRepository.getText(2);
		
		assertEquals(aux.getExpect(), StringReverse.reverseCadena(aux.getInput()));
	}
	
	@Test
	public void testReverseCadena3() throws Exception {
		
		when(stringRepository.getText(3)).thenReturn(new StringTest("foo(bar(baz(abc(max))))blim","foobazmaxcbarabblim"));
		
		StringTest aux = stringRepository.getText(3);
		
		assertEquals(aux.getExpect(), StringReverse.reverseCadena(aux.getInput()));
	}

}
