package com.applications.world.hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather station simulator.
 * Maintains a list of subscribers and a temperature. Accepts temperature updates from outside sources and
 * notifies current subscribers of that change.
 */
public class WeatherStation implements IObservable{

    private List<IObserver> observerList = new ArrayList<>();
    private float temperature;

    public WeatherStation() {
        setTemperature(75f);
    }

    /**
     * Subscribes an observe to the Weather Station.
     *
     * @param observer Reference to the Weather Display to be added.
     */
    @Override
    public void add(IObserver observer){
        observerList.add(observer);
    }

    /**
     * Unsubscribes an observer from the Weather Station.
     *
     * @param observer Reference to the Weather Display to be removed.
     */
    @Override
    public void remove(IObserver observer){
        if (observer != null) {
            observerList.remove(observer);
        }
    }

    /**
     * terates through the subscribes observers and notifies them that an update has occured.
     *
     */
    @Override
    public void notifyObservers(){
        for (IObserver observer : observerList) {
            observer.update();
        }
    }

    /**
     * Returns the current temperature at the Weather Station.
     * @return Current temperature of Weather Station.
     */
    @Override
    public float getTemperature()
    {
        return temperature;
    }

    /**
     * Sets the current temperature at the Weather Station and triggers a notify action.
     * @param temperature Temperature to be used to update the Weather Station temperature.
     */
    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        if (observerList != null && observerList.size() > 0)
            notifyObservers();
    }

}
