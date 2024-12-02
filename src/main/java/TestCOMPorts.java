
import com.fazecast.jSerialComm.SerialPort;

public class TestCOMPorts {
    public static void main(String[] args) {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Ports disponibles :");
        for (SerialPort port : ports) {
            System.out.println("- " + port.getSystemPortName());
            System.out.print("  Peut être ouvert : ");
            if (port.openPort()) {
                System.out.println("Oui");
                port.closePort(); // Fermer immédiatement après le test
            } else {
                System.out.println("Non");
            }
        }
    }
}
