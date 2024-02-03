// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {
  /** Creates a new driveTrain. */
  private final TalonSRX fl_motor = new TalonSRX(Constants.flMotorID);
  private final TalonSRX fr_motor = new TalonSRX(Constants.frMotorID);
  private final TalonSRX bl_motor = new TalonSRX(Constants.blMotorID);
  private final TalonSRX br_motor = new TalonSRX(Constants.brMotorID);
    

  public driveTrain() {
    fl_motor.setInverted(false);
    fr_motor.setInverted(false);
    bl_motor.setInverted(false);
    br_motor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void motor_init_(TalonSRX mot){
    mot.setNeutralMode(NeutralMode.Coast);
  }
  public void drive(double x, double y, double theta){

  }
  /*public double[] normalize(double x, double y, double theta){
    return [2];
  }*/

  
}
