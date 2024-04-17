package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class DriveSubsystem extends SubsystemBase {
  public DriveSubsystem() {
		LeftMotorLeader.addFollower(LeftMotor2);
		RightMotorLeader.addFollower(RightMotor2);
		RightMotorLeader.setInverted(true);
		DiffDrive = new DifferentialDrive(LeftMotorLeader, RightMotorLeader);
	}

  private Spark LeftMotorLeader = new Spark(LeftMotor1Port);
  private Spark LeftMotor2 = new Spark(LeftMotor2Port);
  private Spark RightMotorLeader = new Spark(RightMotor1Port);
  private Spark RightMotor2 = new Spark(RightMotor2Port);
	private DifferentialDrive DiffDrive;

  /**
   * Example command factory method.
   *
   * @return nothing
   */
	
  public void arcadeDrive(double xSpeed, double zRotation) {
		DiffDrive.arcadeDrive(xSpeed, zRotation);
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
