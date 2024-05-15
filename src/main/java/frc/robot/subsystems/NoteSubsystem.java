package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import static frc.robot.Constants.*;

public class NoteSubsystem extends SubsystemBase {
  private Spark IntakeMotor1 = new Spark(IntakeMotor1Port);
  private Spark IntakeMotor2 = new Spark(IntakeMotor2Port);
  private Spark FireMotor1   = new Spark(FireMotor1Port);
  private Spark FireMotor2   = new Spark(FireMotor2Port);

  public NoteSubsystem() {
		IntakeMotor1.addFollower(IntakeMotor2);
    IntakeMotor2.setInverted(true);
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