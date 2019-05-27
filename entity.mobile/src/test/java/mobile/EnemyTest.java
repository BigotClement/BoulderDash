/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnemyTest {
    private Enemy enemy = null;

    @Before
    public void setUp() throws Exception {
        this.enemy = new Enemy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEnemy() {
        assertEquals(Enemy.class, this.enemy.getClass());
    }

}
