package org.usfirst.frc.team5816.robot;

//Imports required classes.
import edu.wpi.first.wpilibj.Joystick;

//Beginning of class file.
public class OI {
	
	//Defines the joysticks as Joysticks.
	static Joystick leftJoystick, rightJoystick, XboxController;
	//Creates variables for buttons, used later.
	static boolean lowGearButton, highGearButton;
	//Creates variables for the ports the Joysticks plug in to.
	static int leftJoystickPort = 0;
	static int rightJoystickPort = 1;
	static int XboxControllerPort = 2;
	
	//Creates the function joystickInit().
	public void joystickInit() {
		
		//Initializes the Joysticks to their ports.
		leftJoystick = new Joystick(leftJoystickPort);
		rightJoystick = new Joystick(rightJoystickPort);
		XboxController = new Joystick(XboxControllerPort);
		
	}
	
	//Creates the function joystickButtons().
	public void joystickButtons() {
		
		//Sets the variables created above to actual buttons on the joysticks.
		//lowSpeedButton = leftJoystick.getRawButton(1);
		//mediumSpeedButton = leftJoystick.getRawButton(2);
		//highSpeedButton = leftJoystick.getRawButton(3);
		
		lowGearButton = leftJoystick.getRawButton(1);
		highGearButton = rightJoystick.getRawButton(1);
		
	}

}
