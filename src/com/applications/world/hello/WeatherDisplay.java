package com.applications.world.hello;

/**
 * Weather display simulator.
 * Maintains a reference to the weather display (weatherDisplay) and, when notified of a change by the Weather
 * Display, updates the currently displayed temperature.
 */
public class WeatherDisplay implements IObserver {

    /*
     * The "WeatherStation" variable is an example of coupling to the
     * WeatherStation class.  Coupling to WeatherStation here is less bad
     * than coupling to WeatherStation in the Interface.  At least there is
     * an abstract ancestor in the Interface that is not coupled to the
     * concept of WeatherStation.  When we have a concrete "weather" display
     * that suddenly is a weather display for WeatherStation.  If a
     * more generic display that can display anything is desired, we
     * need to increase our abstraction and create a generic interface
     * for the weather station display.
     */
    private WeatherStation weatherStation;

    /* An alternative approach is to use the IObservable inference as the
     * reference to the Weather Station class.  Not used here.
     */
    private IObservable station;

    private float temperature;
    private String displayName;

    public WeatherDisplay(WeatherStation weatherStation, String displayName) {
        this.weatherStation = weatherStation;
        this.displayName = displayName;
        temperature = weatherStation.getTemperature();
    }

    /**
     * Called by the IObservable notify() method.  When triggered, reads the current temperature and
     * updates the temperature value on the display.
     */
    @Override
    public void update(){
        temperature = weatherStation.getTemperature();
        System.out.println(displayName + " temperature set to " + temperature);
    }
}
