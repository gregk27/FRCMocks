package ca.gregk.frcmocks.ctre;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class BaseCTREController extends MockCTREController<TalonSRX> {

    public BaseCTREController(){
        super();
    }

    @Override
    public Class<TalonSRX> getType() {
        return TalonSRX.class;
    }


}