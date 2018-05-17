package org.foxconn.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class ScheduleRunner {
	Logger logger = Logger.getLogger(ScheduleRunner.class);
	ScheduledExecutorService taskService = Executors.newScheduledThreadPool(10);;
	List<Runnable> oneDayRunnables = new ArrayList<Runnable>();
	public void run() {
		addRunnables();
		for(Runnable runnable : oneDayRunnables){
			taskService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		}
	}
	
	public void addRunnables(){
		addSendPcsRunnable();
		addSendCodeRunnable();
	}
	
	public void addSendPcsRunnable(){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				logger.info("send pcs task Begin");
			}
		};
		oneDayRunnables.add(runnable);
	}
	
	public void addSendCodeRunnable(){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				logger.info("send Code task Begin");
			}
		};
		oneDayRunnables.add(runnable);
	}
}
