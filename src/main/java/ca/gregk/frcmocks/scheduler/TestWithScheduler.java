package ca.gregk.frcmocks.scheduler;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * Extend this class when your test requires commands or command groups to be
 * exercised with the full WPI scheduler. Use
 * {@link SchedulerPumpHelper#runForDuration(long, int...)} to pump the
 * scheduler.
 */
public class TestWithScheduler {

	/**
	 * Start the scheduler.
	 * Should be called before testing
	 */
	public static void schedulerStart() {
		CommandScheduler.getInstance().enable();
	}

	/**
	 * Clear scheduled commands/subsystems.
	 */
	public static void schedulerClear() {
		CommandScheduler.getInstance().cancelAll();
		CommandScheduler.getInstance().clearButtons();
	}

	/**
	 * Destroy the scheduler.
	 * Should be callled after testing
	 */
	public static void schedulerDestroy() {
		CommandScheduler.getInstance().disable();
	}
}