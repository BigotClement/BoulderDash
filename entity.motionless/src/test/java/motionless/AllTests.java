package motionless;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ BorderTest.class, DestructibleBlockTest.class, DirtTest.class, ExitTest.class,
        MotionlessEntityFactoryTest.class, MotionlessEntityTest.class, StarTest.class })
public class AllTests {

}
