import java.lang.reflect.Field;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

public class ConverterUtils {

	public static <T> T convert(Class<T> klass, HttpServletRequest request)
		throws InstantiationException, IllegalAccessException, ParseException
	{
		// É uma instância do objeto que será preenchido com os valores que são publicados na request
		T entity = klass.newInstance();

		// Pega todos os atributos declarados na classe
		for(Field field : klass.getDeclaredFields()) {
			// Captura o conteúdo da request
			String parameter = request.getParameter(field.getName());
			if(parameter != null) {
				// Muda a acessibilidade do atributo para public durante o uso desse método
				field.setAccessible(true);

				// Verifica a presença da anotação Type,
				// caso o atributo a tenha, usará o TypeEnum para capturar o conversor
				if(field.isAnnotationPresent(Type.class)) {
					// Captura o enum que contém o conversor a partir do tipo de objeto esperado.
					TypeConverterEnum typeConverterEnum = TypeConverterEnum.findByType(field.getAnnotation(Type.class).value());
					// Captura o conversor do enum que foi encontrado.
					TypeConverter<?> typeConverter = typeConverterEnum.getConverter();
					// Atribui o valor convertido
					field.set(entity, typeConverter.convert(parameter));
				} else {
					// Atribui o valor da capturado na request
					field.set(entity, parameter);
				}
			}
		} 
		
		return entity;
	} 
	
}
