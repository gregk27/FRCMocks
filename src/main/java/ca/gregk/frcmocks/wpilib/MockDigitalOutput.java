package ca.gregk.frcmocks.wpilib;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doAnswer;

import ca.gregk.frcmocks.MockBase;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * Wrapper used to mock {@link DigitalOutput}s and track changes.
 */
public class MockDigitalOutput extends MockBase<DigitalOutput> {
    
    public boolean state;

    /**
     * Create a wrapper for a mock {@link DigitalOutput}.
     */
    public MockDigitalOutput(){
      super();    
    }

    @Override
    protected void mapWrapper() {
      // Update when position set
      doAnswer(invocation -> {
        Object[] args = invocation.getArguments();
        state = (boolean) args[0];
        return null; // void method in a block-style lambda, so return null
      }).when(mock).set(anyBoolean());

      // Return state upon request (in lambda, as simpler function was faster than
      // above lambda)
      doAnswer(invocation -> {
        return state;
      }).when(mock).get();
    }

    @Override
    public Class<DigitalOutput> getType() {
      return DigitalOutput.class;
    }
}