package ler.mocks.scheduler;

import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * Class to mock WPILib button for unit testing.
 */
public class MockButton extends Button {

	private boolean pushed = false;

	@Override
	public boolean get() {
		return pushed;
	}

	/**
	 * Simulating pushing (and holding) the button.
	 */
	public void push() {
		pushed = true;
	}

	/**
	 * Release the simulated push from {@link MockButton#push()}.
	 */
	public void release() {
		pushed = false;
	}
}
