package tesis.sistema.de.control;

import java.awt.image.BufferedImage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tesis.sistema.de.control.WebcamDevice;
import tesis.sistema.de.control.WebcamDriver;
import tesis.sistema.de.control.WebcamTask;


public class WebcamGetImageTask extends WebcamTask {

	private static final Logger LOG = LoggerFactory.getLogger(WebcamGetImageTask.class);

	private volatile BufferedImage image = null;

	public WebcamGetImageTask(WebcamDriver driver, WebcamDevice device) {
		super(driver, device);
	}

	public BufferedImage getImage() {

		try {
			process();
		} catch (InterruptedException e) {
			LOG.debug("Interrupted exception", e);
			return null;
		}

		return image;
	}

	@Override
	protected void handle() {

		WebcamDevice device = getDevice();
		if (!device.isOpen()) {
			return;
		}

		image = device.getImage();
	}
}
