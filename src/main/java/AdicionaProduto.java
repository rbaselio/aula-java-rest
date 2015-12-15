import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adiciona")
public class AdicionaProduto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AdicionaProduto() {
    }

    protected void service(HttpServletRequest request,
            			   HttpServletResponse response)
            throws IOException, ServletException 
    {
        PrintWriter out = response.getWriter();
       
        Produto p = null;
		try {
			p = Converter.convert(Produto.class, request);
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
        
        out.println("<html>");
        out.println("<body>");
        if(p != null) {
        	out.println("Produto " + p.getNome() + " adicionado com sucesso");
        }
        out.println("Data " + p.getData().toString() + " parseado com sucesso"); 
        out.println("</body>");
        out.println("</html>");
    }

}
