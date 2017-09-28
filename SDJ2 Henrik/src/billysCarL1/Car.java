package billysCarL1;
public class Car {

	// true for on
	// false for off
	private boolean state;
	private int buttonState; // 1-9, 0 = idle/initial state
	private int motorState; // 1 forward, 2 backwards, 3 stop
	private boolean lightState;

	public Car(int buttonstate) {
		buttonState = 0;
		motorState = 3;
		lightState = false;
	}
	public void setMotor(int motorState) {
		this.motorState = motorState;
	}

	public void setLight(boolean lightState) {
		this.lightState = lightState;
	}

	// Motors
	public void forward() {
		setMotor(1);
	}

	public void backward() {
		setMotor(2);
	}

	public void stop() {
		setMotor(3);
	}

	// Lights

	public void lightsOn() {
		setLight(true);
	}

	public void lightsOff() {
		setLight(false);
	}

	// States

	public void state(int buttonState)
	{
		if(buttonState==0)
		{
			stop();
		}
		if(buttonState==1)
		{
			state = true;
			forward();
			lightsOn();
		}
		if (buttonState == 2)
		{
			state = false;
			stop();
			lightsOff();
		}
		if(buttonState == 3)
		{
			state = true;
			lightsOn();
		}
		if (buttonState == 4)
		{
			state = false;
			lightsOff();
		}
		if(buttonState == 5)
		{
			state = true;
			backward();
			lightsOn();
		}
		if(buttonState == 6)
		{
			state = false;
			stop();
			lightsOff();
		}
		if(buttonState ==7)
		{
			state = true;
			lightsOn();
		}
		if(buttonState == 8)
		{
			state = false;
			lightsOff();
		}
	}
	public boolean Pressed()
	{
		
		if (state == true)
		{
			buttonState+=1;
			if (buttonState >9)
			{
				buttonState =1;
			}
			return  false;
			
			
		}
		if(state== false)
		{
			buttonState+=1;
			if (buttonState >9)
			{
				buttonState =1;
			}
			return true;
			
		}
		
		return false;
		
	}

	

}
