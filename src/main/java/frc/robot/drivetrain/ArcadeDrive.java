/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.helpers.Helper;

public class ArcadeDrive extends Command {

  public ArcadeDrive() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //normal joystick arcade drive    
    double y = Helper.deadband(-OI.driver.getRawAxis(1),0.1); //TODO: do we want to use Launchpad + buttons?
    double x = Helper.deadband(-OI.driver.getRawAxis(4),0.1); //TODO: check these numbers

    Robot.drivetrain.setSpeed(0.75*(y-x), 0.75*(y+x));
    //=============================================================================
    //Launchpad stuff if we have time:
    /*
    if(OI.panel.getYButton()){
      Robot.drivetrain.setSpeed(0.4,0.4);
    }
    else if(OI.panel.getAButton()){
      Robot.drivetrain.setSpeed(-0.4,-0.4);
    }
    else if(OI.panel.getXButton()){
      Robot.drivetrain.setSpeed(-0.4,0.4);
    }
    else if(OI.panel.getBButton()){
      Robot.drivetrain.setSpeed(0.4,-0.4);
    }
    else{
      Robot.drivetrain.setSpeed(0,0);
    }
    */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
