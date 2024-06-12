// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem subsystem;
  private final XboxController cont;

  public ArcadeDrive(DriveSubsystem subsystem, XboxController cont) {
    this.subsystem = subsystem;
    this.cont = cont;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = -cont.getLeftY();
    double turn = -cont.getRightX();
    if (turn < 0.2 && turn > -0.2){
      turn = 0;
    }
    if (speed > 0.1) {
      turn += (0.2 * (speed*2));
    } else if (speed < -0.1) {
      turn -= (0.2 * (speed*2));
    }
    turn *= 0.7;
    subsystem.arcadeDrive(speed, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
