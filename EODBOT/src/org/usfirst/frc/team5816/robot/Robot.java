package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

    public void robotInit() {
    	RobotMap.init();
    }

    public void autonomousInit() {
    	RobotMap.drive.drive(0.05, 0);
    }

    public void autonomousPeriodic() {
    	//RobotMap.drive.drive(0.05, 0);
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
    	RobotMap.teleop();
    }

    public void testInit() {
    }

    public void testPeriodic() {
    }
}
