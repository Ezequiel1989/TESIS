package tesis.sistema.de.control;

import java.nio.ByteBuffer;

import tesis.sistema.de.control.WebcamDevice;
import tesis.sistema.de.control.WebcamDevice.BufferAccess;
import tesis.sistema.de.control.WebcamDriver;
import tesis.sistema.de.control.WebcamTask;


public class WebcamReadBufferTask extends WebcamTask {

	private volatile ByteBuffer target = null;

	public WebcamReadBufferTask(WebcamDriver driver, WebcamDevice device, ByteBuffer target) {
		super(driver, device);
		this.target = target;
	}

	public ByteBuffer readBuffer() {
		try {
			process();
		} catch (InterruptedException e) {
			return null;
		}
		return target;
	}

	@Override
	protected void handle() {

		WebcamDevice device = getDevice();
		if (!device.isOpen()) {
			return;
		}

		if (!(device instanceof BufferAccess)) {
			return;
		}

		((BufferAccess) device).getImageBytes(target);
	}
}
