package tesis.sistema.de.control;

import tesis.sistema.de.control.WebcamDevice;
import tesis.sistema.de.control.WebcamDriver;
import tesis.sistema.de.control.WebcamTask;


/**
 * Dispose webcam device.
 * 
 * @author Bartosz Firyn (sarxos)
 */
public class WebcamDisposeTask extends WebcamTask {

	public WebcamDisposeTask(WebcamDriver driver, WebcamDevice device) {
		super(driver, device);
	}

	public void dispose() throws InterruptedException {
		process();
	}

	@Override
	protected void handle() {
		getDevice().dispose();
	}
}
