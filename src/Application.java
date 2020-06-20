import com.applications.world.hello.WeatherDisplay;
import com.applications.world.hello.WeatherStation;

public class Application {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        ws.setTemperature(75f);
        ws.add(new WeatherDisplay(ws, "Display 1"));
        ws.add(new WeatherDisplay(ws, "Display 2"));
        ws.add(new WeatherDisplay(ws, "Display 3"));

        ws.setTemperature(76f);

    }
}
