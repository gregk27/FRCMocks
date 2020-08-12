package ca.gregk.frcmocks.wpilib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class MockDigitalInputTest extends TestBase<MockDigitalInput>{
    
    @Override
    protected Class<MockDigitalInput> getType() {
        return MockDigitalInput.class;
    }

    /**
     * Test that the mock's {@link DigitalInput#get()} method works
     */
    @Test
    public void testGet(){
        // Arrange
        wrapper.state = true;
        // Assert
        assertTrue("Input is not returning true state", wrapper.getMock().get());

        // Arrange
        wrapper.state = false;
        // Assert
        assertFalse("Input not returning false state", wrapper.getMock().get());
    }





}