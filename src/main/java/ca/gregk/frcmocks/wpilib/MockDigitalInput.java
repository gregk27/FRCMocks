package ca.gregk.frcmocks.wpilib;

import static org.mockito.Mockito.doAnswer;

import ca.gregk.frcmocks.MockBase;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Wrapper used to mock {@link DigitalInput}s and track changes.
 */
public class MockDigitalInput extends MockBase<DigitalInput>{
    
    /**
     * The `true/false` state of the input
     * <p> This value defaults to false, but should be set for reliability
     */
    public boolean state = false;

    /**
     * Create a wrapper for a mock {@link DigitalInput}.
     * 
     */
    public MockDigitalInput(){
        super();
    }
    
    @Override
    protected void mapWrapper() {
        doAnswer(invocation -> {
			return this.state;
		}).when(mock).get();
    }

    @Override
    public Class<DigitalInput> getType() {
        return DigitalInput.class;
    }
}