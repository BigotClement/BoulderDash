package mobile;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CharacterTest.class, DiamondTest.class, EnemyTest.class, MobileEntityFactoryTest.class,
        MobileEntityTest.class, RockTest.class })
public class AllTests {

}
