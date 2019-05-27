/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.drivetrain.ArcadeDrive;

/**
 * Add your docs here.
 */
public class OI {
    public static XboxController driver; 
    public static XboxController panel;   
    public static void init(){
        driver = new XboxController(0);
        // panel = new XboxController(0);

        Robot.drivetrain.setDefaultCommand(new ArcadeDrive());
    }
}
