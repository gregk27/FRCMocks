# FRCMocks
This is a library containing classes that can be used to mock behaviour of various FRC components.

Additionally, classes are included that allow for manually pumping the scheduler when testing. These are derived from https://github.com/robototes/2020_Template.

# Mocked Hardware
Full descriptions of the mocked hardware can be found in the wiki. The shortlist is as follows
 - WPILib
   - DoubleSolenoid
   - DigitalInput
   - DigitalOutput
 - CTRE
   - TalonSRX
   - VictorSPX
   - TalonFX (somewhat)
 - Rev
   - CANSparkMax
   - CANEncoder
   - CANPIDController

# Usage
The library can be used by adding it to your `build.gradle` file.

### Step 1
Add the following lines to the `repositories` block
```groovy
maven {
    url "http://gregk.ca/FRCMocks/"
}
```

### Step 2
Add the following line to the `dependencies` block
```groovy
implementation 'ca.gregk:frcmocks:+'
```
