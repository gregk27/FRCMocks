package ca.gregk.frcmocks.wpilib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.gregk.frcmocks.TestBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class MockDigitalInputTest extends TestBase<MockDigitalInput>{
    
    @Override
    public void setup() {
        wrapper = new MockDigitalInput();
        System.out.println(wrapper);
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