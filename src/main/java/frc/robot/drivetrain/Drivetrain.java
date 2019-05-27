/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  Spark left_primary;
  Spark left_secondary;
  Spark right_primary;
  Spark right_secondary;

  public Drivetrain(){
    left_primary = new Spark(0);
    left_secondary = new Spark(1);
    right_primary = new Spark(2);
    right_secondary = new Spark(3);    
  }

  @Override
  public void initDefaultCommand() {}

  public void setLeftSpeed(double speed){
    left_primary.set(speed);
    left_secondary.set(speed);
  }

  public void setRightSpeed(double speed){
    right_primary.set(speed);
    right_secondary.set(speed);
  }

  public void setSpeed(double left, double right){
    setLeftSpeed(left);
    setRightSpeed(right);
  }

}
