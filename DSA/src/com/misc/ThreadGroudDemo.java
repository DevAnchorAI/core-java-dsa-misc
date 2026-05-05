package com.misc;

public class ThreadGroudDemo {

	public static void main(String[] args) {
		
		/*
		 * System.out.println(Thread.currentThread().getThreadGroup().getName());
		 * System.out.println(Thread.currentThread().getThreadGroup().getParent().
		 * getName()); ThreadGroup pg = new ThreadGroup("Parent Group");
		 * System.out.println(pg.getParent().getName()); ThreadGroup cg = new
		 * ThreadGroup(pg, "Child Groupo");
		 * System.out.println(cg.getParent().getName());
		 */
		
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] t = new Thread[system.activeCount()];
		system.enumerate(t);//copy all the thread from system to Thread[] t
		for(Thread thread: t) {
			System.out.println(thread.getName()+"======"+thread.isDaemon());
		}
		}
	

}
