package simulation;
import java.util.Queue;
import java.util.PriorityQueue;

public abstract class Simulation {
	
	private Queue<ScheduledEvent> diary;
	protected double time;
	
	protected Simulation() {
		this.diary = new PriorityQueue<ScheduledEvent>();
		this.time  = 0;
	}
	
	protected abstract boolean stop();

	public void schedule(Event e, double offset) {
		ScheduledEvent event = new ScheduledEvent(e, (offset + time));
		diary.add(event);
		
	}
	
	protected void simulate() {
		while(!diary.isEmpty() && !stop()) {
			ScheduledEvent currentEvent = diary.poll();
			time = currentEvent.getTime();
			
			if (stop()) {
				break;
			}
			
			currentEvent.getEvent().invoke(this);

		}
	}

	public double getCurrentTime() {
		return time;
	}
	
	public void incrementTime() {
		time++;
	}
	

}
