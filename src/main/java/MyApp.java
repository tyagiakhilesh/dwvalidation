import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class MyApp extends Application<Configuration> {
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new MyResource());
    }

    public static void main(String[] args) throws Exception {
        new MyApp().run(args);
    }
}
