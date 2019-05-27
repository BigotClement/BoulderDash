/*
 *
 */
package model.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBPropertiesTest {
    private DBProperties dbProperties = null;

    @Before
    public void setUp() throws Exception {
        this.dbProperties = new DBProperties();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDBProperties() {
        assertEquals(DBProperties.class, this.dbProperties.getClass());
    }

    @Test
    public void testGetUrl() {
        String URL = "jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";
        assertEquals(URL, this.dbProperties.getUrl());
    }

    @Test
    public void testGetLogin() {
        String LOGIN = "root";
        assertEquals(LOGIN, this.dbProperties.getLogin());
    }

    @Test
    public void testGetPassword() {
        String PASS = "";
        assertEquals(PASS, this.dbProperties.getPassword());
    }

}
