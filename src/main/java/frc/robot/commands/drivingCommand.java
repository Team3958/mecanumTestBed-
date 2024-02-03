// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveTrain;

public class drivingCommand extends Command {
  /** Creates a new drivingCommand. */
  private XboxController xc;
  private driveTrain m_DriveTrain;
  public drivingCommand(driveTrain m_DriveTrain,XboxController xc) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xc = xc;
    this.m_DriveTrain = m_DriveTrain;
    addRequirements(m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DriveTrain.drive(xc.getLeftY(), xc.getLeftX(), xc.getRightX());
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
