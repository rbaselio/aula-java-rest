import java.util.Properties;


public class PropertySingleton {
	
	private static PropertySingleton singleton;
	private Properties prop = new Properties();
	
	private PropertySingleton() {
	}
	
	public static PropertySingleton singleton() {
		return singleton == null 
				? singleton = new PropertySingleton()
				: singleton;
	}
	
	public Properties getProp() {
		return prop;
	}
	
}
