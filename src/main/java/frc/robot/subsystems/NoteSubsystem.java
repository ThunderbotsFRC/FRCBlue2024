package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import static frc.robot.Constants.*;

public class NoteSubsystem extends SubsystemBase {
  private DigitalInput switch1  = new DigitalInput(touchSwitch1);
  private Spark IntakeMotor1    = new Spark(IntakeMotor1Port);
  private Spark IntakeMotor2    = new Spark(IntakeMotor2Port);
  private Spark FireMotor1      = new Spark(FireMotor1Port);
  private Spark FireMotor2      = new Spark(FireMotor2Port);
  public boolean rTriggerDown   = false;
  public long rTriggerTime      = 0; 

  public NoteSubsystem() {
		IntakeMotor1.addFollower(IntakeMotor2);
    IntakeMotor2.setInverted(true);
    FireMotor1.addFollower(FireMotor2);
    FireMotor2.setInverted(true);
	}

  public void setIntakeSpeed(double speed) {
    if ((!switch1.get() && !rTriggerDown) || (System.currentTimeMillis() - rTriggerTime < 3*1000))
      this.IntakeMotor1.set(speed);
  }
  
  public void setFireMotor(double speed) {
    this.FireMotor1.set(speed);
  }

  @Override
  public void periodic() {
	  // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
	// This method will be called once per scheduler run during simulation
  }
}