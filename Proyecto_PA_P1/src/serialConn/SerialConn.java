package serialConn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.OutputDeviceAssigned;

import com.fazecast.jSerialComm.SerialPort;

import controller.Administrar_info;
import controller.Logica_View_sell_product;
import model.Producto;

import com.fazecast.jSerialComm.*;

public class SerialConn extends Thread{
	
	private SerialPort port;
	private SerialPort [] ports;
	private char dato = '0';
	private Logica_View_sell_product lvsp;
//	private double peso = 0;
	private String precio = "";
	
	public SerialConn(Logica_View_sell_product lvsp)
	{
		this.lvsp=lvsp;
	}
	
	/**
	 * Permite obtener los nombres
	 * de los puertos identificados
	 * mediante el método getCommPorts()
 	 * @return String[]
	 */
	public String[] names_ports() {
		this.ports = port.getCommPorts();
		System.out.println(ports[0].getSystemPortName());
		String [] names = new String[ports.length];
		for(int i = 0; i < ports.length; i++) {
			names[i] = ports[i].getSystemPortName();
		}
		return names;
	}
	/**
	 * Permite identificar el puerto asignado
	 * par la comunicacion serial y ejecuta
	 * el método openPort() para iniciar la comunicación
	 * @param namePort
	 */
	public void openSerialConn(String namePort) {
		this.ports = port.getCommPorts();
		for(SerialPort sp : ports) {
			if(namePort.equals("COM3")) {
				this.port = sp;
			}
		}
		if(port.openPort()) {
			System.out.println("Conexion Serial Establecida");
		} else {
			System.out.println("Puerto Ocupado");
		}
		port.setComPortParameters(9600, 8, 1, 0);
	}
	
	public boolean closeSConn() {
		return port.closePort();
	}
	
	public synchronized void setDato(char dato) {
		this.dato = dato;
	}
	
	public synchronized void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public void run() {
		openSerialConn("COM3");
		port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
		while(true) {
			if(Logica_View_sell_product.peso != 0) {
            	break;
            }
			PrintWriter output = new PrintWriter(port.getOutputStream());
			output.print(dato);
			output.flush();
			try {
				sleep(7100);
				System.out.println("Dato enviado: " + dato);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//-------------------
			byte[] readBuffer = new byte[100];
            int numRead = port.readBytes(readBuffer, readBuffer.length);
            String receivedData = new String(readBuffer, 0, numRead);
            
            // Procesa los datos recibidos
            if (!receivedData.isEmpty()) {
                float receivedValue = Float.parseFloat(receivedData.trim());
                Logica_View_sell_product.peso = receivedValue;
            }
            System.out.println("Dato recibido desde Arduino: " + Logica_View_sell_product.peso);
            //--------------------
            try {
				sleep(4100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            for(Producto p: Administrar_info.productos) 
            {
            	if(p.getCodigo().equals(this.lvsp.vsp.cmb_codigo.getSelectedItem().toString()))
            	{
            		float aux = Logica_View_sell_product.peso*Float.parseFloat(p.getPrecio());
            		precio= String.valueOf(aux);
            	}
            }
            //String dataToSend = String.valueOf(Logica_View_sell_product.peso);
            String dataToSend = precio;
			this.lvsp.vsp.txt_peso.setText(Float.toString(Logica_View_sell_product.peso));
			this.lvsp.vsp.btn_agregar.setEnabled(true);
            try {
				port.getOutputStream().write(dataToSend.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
