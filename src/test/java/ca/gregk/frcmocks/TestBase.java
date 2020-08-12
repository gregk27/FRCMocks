package ca.gregk.frcmocks;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public abstract class TestBase<T extends MockBase<?>> {

    /**
     * The mock class to test.
     */
    protected T wrapper;

    /**
     * Function used by the TestBase setup() function to instatiate the
     * {@link TestBase#wrapper}
     * 
     * @return The type to use in instantiation
     */
    protected abstract Class<T> getType();

    /**
     * This functions should be used for pre-test setup<br>
     * The wrapper should be instantiated here
     */
    @Before
    public void setup() {
        try {
            wrapper = getType().getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Test that the mock is initialised properly
     * <p>
     * Properly is defined by <code>wrapper.getMock().getClass()</code> being equal to <code>wrapper.getType()</code> 
     */
    @Test
    public void testInit(){
        String targetClass = wrapper.getType().toString();
        String mockClass = wrapper.getMock().getClass().toString();

        // Strip mockito info from classname
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));

        assertEquals(targetClass, mockClass);
    }
}