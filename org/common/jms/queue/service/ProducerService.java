package common.jms.queue.service;

import java.io.Serializable;

import javax.jms.Destination;

public interface ProducerService {

	public void sendMessage(Destination destination, String message);
	
	public void sendMessage(Destination destination, Serializable obj);
	
}
