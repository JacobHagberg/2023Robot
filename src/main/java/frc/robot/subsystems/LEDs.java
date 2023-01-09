import com.ctre.phoenix.led.CANdle;

public class LED extends SubsystemBase {

    private final com.ctre.phoenix.led.CANdle LEDStrip = new CANdle(1)//CanID

    public void SetAll(r, g, b){
        LEDStrip.setLEDs(r,g,b)
    }

    public void RED(){
        LEDStrip.setLEDs(255,0,0)
    }

    public void GREEN(){
        LEDStrip.setLEDs(0,255,0)
    }

    public void BLUE(){
        LEDStrip.setLEDs(0,0,255)
    }

    public void PURPLE(){
        LEDStrip.setLEDs(255,0,255)
    }

    public void WHITE(){
        LEDStrip.setLEDs(255,255,255)
    }

    public void ORANGE(){
        LEDStrip.setLEDs(255,140,0)
    }

    public void YELLOW(){
        LEDStrip.setLEDs(255,255,0)
    }
}

