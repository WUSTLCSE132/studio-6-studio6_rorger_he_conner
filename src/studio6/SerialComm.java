package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	/**
	 * Writes one byte to the serial port
	 * @param singleByte byte to write
	 * @throws SerialPortException
	 */
	public void writeByte(byte singleByte) throws SerialPortException {
		port.writeByte(singleByte);
		if (debug) {
			System.out.print("<0x");
			System.out.print(Integer.toHexString(singleByte));
			System.out.println(">");
		}
	}
	
	// TODO: Add available() method
	public boolean available() throws SerialPortException {
		return port.getInputBufferBytesCount() > 0;
	}
	
	// TODO: Add readByte() method	
	public byte readByte() throws SerialPortException {
		byte b = port.readBytes(1)[0];
		if (debug) {
			System.out.print("[0x");
			System.out.print(Integer.toHexString(((int)b) & 0xFF));
			System.out.println("]");
		}
		return b;
	}
	
	// TODO: Add a main() method
	public static void main(String[] args) throws Exception {
		 SerialComm port = new SerialComm("/dev/cu.usbserial-DN02B2IX");
		 port.setDebug(true);
		 
		 while (true) {
			 if (port.available()) {
				 byte a = port.readByte();
				 System.out.println(a);
//				 byte a = port.readByte(); // MSB
//				 byte b = port.readByte(); // 
//				 byte c = port.readByte(); // 
//				 byte d = port.readByte(); // LSB
//				 int aa = ((int)a) & 0xFF;
//				 int bb = ((int)b) & 0xFF;
//				 int cc = ((int)c) & 0xFF;
//				 int dd = ((int)d) & 0xFF;
//				 int e = aa << 24 | bb << 16 | cc << 8 | dd;
//				 System.out.println(Float.intBitsToFloat(e)); 
			 }
		 }
	}
}
