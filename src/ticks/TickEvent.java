package ticks;
import simulation.Event;
import simulation.Simulation;

public class TickEvent implements Event<Ticks>{
	private double time;
	
	public TickEvent(double time) {
		this.time = time;
	}
	
	public double getEventTime() {
		return time;
	}

	@Override
	public void invoke(Ticks s) {

		System.out.println("Tick at: " + time);
		TickEvent tickEvent = new TickEvent(s.getCurrentTime() + 1); 
		s.schedule(tickEvent, 1.0);
	}
}
