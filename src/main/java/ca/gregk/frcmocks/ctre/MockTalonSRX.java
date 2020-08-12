package ca.gregk.frcmocks.ctre;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MockTalonSRX extends MockCTREController<TalonSRX> {

    @Override
    public Class<TalonSRX> getType() {
        return TalonSRX.class;
    }
    
}