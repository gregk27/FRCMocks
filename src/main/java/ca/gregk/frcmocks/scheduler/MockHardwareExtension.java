package ca.gregk.frcmocks.scheduler;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.sim.DriverStationSim;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * JUnit 5 testing extension which ensures all WPILib foundational bits are
 * initialized to be able to run the scheduler.
 */
public final class MockHardwareExtension {

	/** The timeout passeed to the HAL on init. */
	private static final int HAL_TIMEOUT = 500;

	/**
	 * Call before running tests with scheduler.
	 */
	public static void beforeAll() {
		initializeHardware();
	}

	/** 
	 * Call after running tests with scheduler.
	 */
	public static void afterAll() {
		DriverStation.getInstance().release();
		HAL.releaseDSMutex();
	}

	/**
	 * Initialise HAL hardware.
	 */
	private static void initializeHardware() {
		HAL.initialize(HAL_TIMEOUT, 0);
		DriverStationSim dsSim = new DriverStationSim();
		dsSim.setDsAttached(true);
		dsSim.setAutonomous(false);
		dsSim.setEnabled(true);
		dsSim.setTest(true);
	}
}