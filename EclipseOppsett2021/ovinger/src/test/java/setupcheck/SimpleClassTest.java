package setupcheck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class SimpleClassTest {

    @Test
    public void testSimpleClassGetsValue() {
        SimpleClass c = new SimpleClass(5);

        assertEquals(c.getMyVal(), 5);
    }
}