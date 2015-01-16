package tesis.sistema.de.control;

public interface WebcamDiscoveryListener {

	void webcamFound(WebcamDiscoveryEvent event);

	void webcamGone(WebcamDiscoveryEvent event);

}
