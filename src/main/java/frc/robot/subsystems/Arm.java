package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private final int CURRENT_LIMIT = 30; 
    private final CANSparkMax mMotorArm = new CANSparkMax(Constants.ARM, CANSparkMax.MotorType.kBrushless);
    private final CANSparkMax mMotorElevator = new CANSparkMax(Constants.ELEVATOR, CANSparkMax.MotorType.kBrushless);

    public Arm(){
        mMotorArm.restoreFactoryDefaults();
        mMotorArm.setIdleMode(IdleMode.kBrake);
        mMotorArm.setSmartCurrentLimit(CURRENT_LIMIT);
        mMotorArm.setInverted(false);
        mMotorArm.burnFlash();

        mMotorElevator.restoreFactoryDefaults();
        mMotorElevator.setIdleMode(IdleMode.kBrake);
        mMotorElevator.setSmartCurrentLimit(CURRENT_LIMIT);
        mMotorElevator.setInverted(false);
        mMotorElevator.burnFlash();
    }

    public void setPercentOutput(double output) {
        if (output > 1.0) {
            output = 1.0;
        } else if (output < -1.0) {
            output = -1.0;
        }

        mMotorArm.set(output);
    }
}

