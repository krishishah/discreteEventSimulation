package ssq;

import simulation.Event;
import ssq.*;
import simulation.Simulation;

public class SSQArrival implements Event<SingleServerQueue>{

	@Override
	public void invoke(SingleServerQueue ssq) {
		
		if (ssq.isQueueEmpty()) {
			
			ssq.schedule(new SSQDeparture(), SingleServerQueue.SERVICE_TIME);
		}
		
		ssq.incrementQueue();
		
		ssq.schedule(new SSQArrival(), ssq.random.nextDouble());
		
		System.out.println("Arrival at " + ssq.getCurrentTime()
				+ ", new population = " + ssq.getQueueSize());
	}

}