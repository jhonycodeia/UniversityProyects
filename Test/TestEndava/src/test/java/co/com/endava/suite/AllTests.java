package co.com.endava.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import co.com.endava.steps.BDDAmazonTest;
import co.com.endava.steps.test.AmazonTestRunner;
import co.com.endava.utilities.ITStringReverseTest;
import co.com.endava.utilities.StringReverseTest;
import co.com.endava.web.AppTest;

@RunWith(Suite.class)
@SuiteClasses({ StringReverseTest.class, ITStringReverseTest.class, AppTest.class, AmazonTestRunner.class, })
public class AllTests {

}
