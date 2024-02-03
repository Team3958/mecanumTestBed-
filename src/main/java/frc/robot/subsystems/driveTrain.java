// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
  private boolean flag = false;

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
    double[] speeds = new double[3];
    x = (x> Constants.deadband)? x:0;
    y = (y> Constants.deadband)? y:0;
    theta = (theta> Constants.deadband)? theta:0;

    speeds[0] = x+y+ theta;
    speeds[1] = x-y- theta;
    speeds[2] = x-y+ theta;
    speeds[3] = x+y- theta;
    
    double[] normalSpeeds = normalize(speeds);
    double[] finalSpeed = (flag) ? normalSpeeds:speeds;

    fl_motor.set(ControlMode.PercentOutput, finalSpeed[0]);
    fr_motor.set(ControlMode.PercentOutput, finalSpeed[1]);
    bl_motor.set(ControlMode.PercentOutput, finalSpeed[2]);
    br_motor.set(ControlMode.PercentOutput, finalSpeed[3]);
  }
  public double[] normalize(double[]nums){
    flag = false;
    double sum = 0;
    for(int i = 0; i <3; i++){
      sum+= nums[i];
      if (nums[i] > 1){
        flag = true;
      }
    }
    for(int j = 0; j< 3; j++){
      nums[j] /= sum;
    }
    return nums;
  
  }
  
}
