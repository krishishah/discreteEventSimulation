package ticks;
import simulation.Simulation;

public class Ticks extends Simulation{
	
	private double endTime;
	private TickEvent tickEvent;
	private static final int FIRST_TICK = 1;
	
	public Ticks(double endTime){
		this.endTime = endTime;
		this.tickEvent = new TickEvent(FIRST_TICK);
		schedule(tickEvent, tickEvent.getEventTime());
		
	}
	
	protected double getEndTime() {
		return endTime;
	}
	
	protected TickEvent getTickEvent() {
		return tickEvent;
	}

	@Override
	protected boolean stop() {
		return !(getCurrentTime() < endTime);
	}
	
	public static void main(String[] args) {
		double tickTime = Double.parseDouble(args[0]);
		Ticks t = new Ticks(tickTime);
		t.simulate();
	}

}
