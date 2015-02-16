package simulation;

import java.lang.Comparable;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent<S>>{
	
	private Event<S> event;
	private Double time;
	
	ScheduledEvent(Event<S> event, double time) {
		this.time = time;
		this.event = event;
	}
	

	Double getTime() {
		return time;
	}
	
	public Event<S> getEvent() {
		return event;
	}

	@Override
	public int compareTo(ScheduledEvent<S> o) {
		return time.compareTo(o.getTime());
	}

	
}
