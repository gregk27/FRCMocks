package ca.gregk.frcmocks.wpilib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class MockDoubleSolenoidTest extends TestBase<MockDoubleSolenoid> {

    @Override
    protected Class<MockDoubleSolenoid> getType() {
        return MockDoubleSolenoid.class;
    }

    /**
     * Test that the mock's {@link DoubleSolenoid#get()} method works
     */
    @Test
    public void testGet(){
        // Assign
        wrapper.state = Value.kOff;
        // Assert
        assertEquals(Value.kOff, wrapper.getMock().get());

        // Assign
        wrapper.state = Value.kForward;
        // Assert
        assertEquals(Value.kForward, wrapper.getMock().get());

        // Assign
        wrapper.state = Value.kReverse;
        // Assert
        assertEquals(Value.kReverse, wrapper.getMock().get());
    }

    /**
     * Test that the mock's {@link DoubleSolenoid#set(Value)} method works
     */
    @Test
    public void testSet(){
        // Assign
        wrapper.getMock().set(Value.kOff);
        // Assert
        assertEquals(Value.kOff, wrapper.state);

        // Assign
        wrapper.getMock().set(Value.kForward);
        // Assert
        assertEquals(Value.kForward, wrapper.state);

        // Assign
        wrapper.getMock().set(Value.kReverse);
        // Assert
        assertEquals(Value.kReverse, wrapper.state);
    }
}