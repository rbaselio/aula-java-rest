import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TypeConverterDate implements TypeConverter<Date> {

	public Date convert(Object obj) {
		String str = (String) obj;
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
		}
		return null;
	}

}
