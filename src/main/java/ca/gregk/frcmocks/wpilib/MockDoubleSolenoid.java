package ca.gregk.frcmocks.wpilib;

import static org.mockito.Mockito.doAnswer;

import org.mockito.Mockito;

import ca.gregk.frcmocks.MockBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Wrapper used to mock {@link DoubleSolenoid}s and track changes.
 */
public class MockDoubleSolenoid extends MockBase<DoubleSolenoid> {

    /**
     * The solenoid's state, as set by {@link DoubleSolenoid#set(Value)}.
     * <p> Can be:
     * <ul>
     * <li> {@link Value#kOff}
     * <li> {@link Value#kForward}
     * <li> {@link Value#kReverse}
     * </ul>
     */
    public Value state = Value.kOff;

    /**
     * Create a wrapper for a mock {@link DoubleSolenoid}.
     */
    public MockDoubleSolenoid() {
		super();
    }

	@Override
    protected void mapWrapper() {
      //Update when position set
		doAnswer(invocation -> {
			Object[] args = invocation.getArguments();
			state = (Value) args[0];
			return null; // void method in a block-style lambda, so return null
		}).when(mock).set(Mockito.any(Value.class));

		// Return state upon request (in lambda, as simpler function was faster than
		// above lambda)
		doAnswer(invocation -> {
			return state;
		}).when(mock).get();
    }

    @Override
    public Class<DoubleSolenoid> getType() {
      return DoubleSolenoid.class;
    }

}