package ssq;
import simulation.Event;

public class SSQDeparture implements Event<SingleServerQueue>{

	@Override
	public void invoke(SingleServerQueue ssq) {
		
		ssq.decrementQueue();
		
		System.out.println("Departure at " + ssq.getCurrentTime()
				+ ", new population = " + ssq.getQueueSize());
		
		if (!ssq.isQueueEmpty()) {
			
			ssq.schedule(new SSQDeparture(), SingleServerQueue.SERVICE_TIME);
		}
		
	}
}
