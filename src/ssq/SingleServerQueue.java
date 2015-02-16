package ssq;

import simulation.Simulation;
import java.util.Random;

public class SingleServerQueue extends Simulation{
	
	public static final double SERVICE_TIME = 0.25;
	private double duration;
	private int queueSize;
	Random random;
	
	
	SingleServerQueue(long seed, double duration) {
		this.duration  = duration;
		this.random    = new Random(seed);
		this.queueSize = 0;
		
	}

	@Override
	protected boolean stop() {
		return (getCurrentTime() >= duration);
	}
	
	
	public boolean isQueueEmpty() {
		return (queueSize == 0);
	}
	
	public void incrementQueue() {
		queueSize++;
	}
	
	public void decrementQueue() {
		if (queueSize > 0) {
			queueSize--;
		}
	}
	
	public static void main(String[] args) {
		long seedInput = Long.parseLong(args[0]);
		double durationInput = Double.parseDouble(args[1]);
		
		SingleServerQueue ssq = 
				new SingleServerQueue(seedInput, durationInput);
		
		ssq.schedule(new SSQArrival(), ssq.random.nextDouble());
		ssq.simulate();
	}
	
	public void incrementTimeBy(double seconds) {
		time += seconds;
	}
	
	public int getQueueSize() {
		return queueSize;
	}

}
