package model;

import java.util.ArrayList;

public class Observable {
	ArrayList<Observer> observers = new ArrayList<>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers(Observable theObservable) {
		for(Observer obs : observers) {
			obs.update(theObservable);
		}
	}
}
