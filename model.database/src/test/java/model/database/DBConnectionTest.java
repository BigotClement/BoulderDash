/*
 *
 */
package model.database;

import static org.junit.Assert.*;

import java.awt.image.DataBufferInt;
import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        DBConnection.getInstance().getConnection().close();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(DBConnection.getInstance());
    }

    @Test
    public void testGetConnection() {
        assertNotNull(DBConnection.getInstance().getConnection());
    }

}
