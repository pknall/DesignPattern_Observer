package com.applications.world.hello;

/**
 * Interface for objects that can be observed by objects that implement the Observable interface.
 */
public interface IObservable {
    void add(IObserver o);
    void remove(IObserver o);
    void notifyObservers();
    float getTemperature();
    void setTemperature(float temperature);
}
