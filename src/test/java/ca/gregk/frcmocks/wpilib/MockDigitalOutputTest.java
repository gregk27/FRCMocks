package ca.gregk.frcmocks.wpilib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;
import edu.wpi.first.wpilibj.DigitalOutput;

public class MockDigitalOutputTest extends TestBase<MockDigitalOutput>{

    @Override
    protected Class<MockDigitalOutput> getType() {
        return MockDigitalOutput.class;
    }

    /**
     * Test that the mock's {@link DigitalOutput#get()} method works
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

    /**
     * Test that the mock's {@link DigitalOutput#set(boolean)} method works
     */
    @Test
    public void testSet(){
        // Arrange
        wrapper.getMock().set(true);
        // Assert
        assertTrue("Input is not set to true state", wrapper.state);

        // Arrange
        wrapper.getMock().set(false);
        // Assert
        assertFalse("Input not set to false state", wrapper.state);
    }

    
}