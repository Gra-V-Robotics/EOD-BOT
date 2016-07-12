package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

    public void robotInit() {
    }

    public void autonomousInit() {    	
    }

    public void autonomousPeriodic() {
    }

    public void teleopInit() {
    	RobotMap.init();
    }

    public void teleopPeriodic() {
    	RobotMap.teleop();
    }

    public void testInit() {
    }

    public void testPeriodic() {
    }
}
