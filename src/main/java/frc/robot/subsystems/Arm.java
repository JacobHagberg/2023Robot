package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private final int CURRENT_LIMIT = 30; 
    private final CANSparkMax mMotorArm = new CANSparkMax(Constants.ARM, CANSparkMax.MotorType.kBrushless);
    private final CANSparkMax mMotorElevator = new CANSparkMax(Constants.ELEVATOR, CANSparkMax.MotorType.kBrushless);

    RelativeEncoder encoderArm = mMotorArm.getEncoder();
    SparkMaxPIDController pidArm = mMotorArm.getPIDController();
    RelativeEncoder encoderElevator = mMotorElevator.getEncoder();
    SparkMaxPIDController pidElevator = mMotorElevator.getPIDController();

    double Angle, Length;

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

    public void SetLengthAndAngle(double angle, double length){

        if (angle < Constants.MinAngle){
            angle = Constants.MinAngle
        }
        if (angle > Constants.MaxAngle){
            angle = Constants.MaxAngle
        }
        if (length < Constants.MinLength){
            length = Constants.MinLength
        }
        if (length > Constants.MaxLength){
            lenght = Constants.MaxLength
        }

        Max_Length = (46 / MATH.abs(MATH.cos(angle)))//make shure that this is degrees and not radians
        Max_Length2 = (66/ MATH.abs(MATH.sin(angle)))

        if length > Max_Length || length > Max_Length2{
        
        if Max_Length >= Max_Length2{
            HardSetPosition(angle, Max_Length2)
        }else{
            HardSetPosition(angle, Max_Length)
        }
        }
    }

    private void HardSetPosition(double angle, double length){
        this.Angle = angle
        this.Length = lenght

        pidArm.setReference(Angle, CANSparkMax.ControlType.kPosition);
        pidElevator.setReference(Length, CANSparkMax.ControlType.kPosition);
    }

    public void setPercentOutput(double output) {
        if (output > 1.0) {
            output = 1.0;
        } else if (output < -1.0) {
            output = -1.0;
        }

        mMotorArm.set(output);
    }

    public double GetAngle(){
        return Angle
    }
    public double GetLength(){
        return Length
    }
}
