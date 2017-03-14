package paquete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;           // |
import org.jdom.Element;            // |\ Librerias
import org.jdom.JDOMException;      // |/ JDOM
import org.jdom.input.SAXBuilder;   // |
import org.jdom.output.XMLOutputter;
/**
 * Servlet implementation class Servlet1
 */
public class SEntrar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            String usuario = request.getParameter("user");
            String pass = request.getParameter("password");
            System.out.println(usuario);
            System.out.println(pass);
            try{
                //Se crea un SAXBuilder para poder parsear el archivo
                SAXBuilder builder = new SAXBuilder();
                String ruta=session.getServletContext().getRealPath("../../web");//obtiene el directorio
                File xmlFile = new File(ruta+"\\Base.xml");
                try{
                    Document document = (Document) builder.build( xmlFile );//Se crea el documento a traves del archivo
                    Element nodoRaiz = document.getRootElement();//Se obtiene la raiz 'tables'
                    List lista = nodoRaiz.getChildren( ); //Se obtiene la lista de hijos del nodo raiz 'tables'
                    LeeXML leer= new LeeXML();
                    //String usuario=leer.buscaUsuario(id, pass, lista, nodoRaiz);
                    Element u=leer.buscaUsuario(usuario, pass, lista, nodoRaiz);
                    if(u!=null ){//Encontró usuario y no hay sesion
                       if( session.getAttribute("usuario") == null){
                           session.setAttribute("usuario", usuario);
                            response.sendRedirect("Admin.jsp");
                            enviaDatos(lista, nodoRaiz, session);
                       }
                       else if(session.getAttribute("usuario") != null){
                           response.sendRedirect("Admin.jsp");
                       }
                    }   
                    else{
                        response.sendRedirect("ErrorLog.jsp");
                    } 
                }
                catch ( IOException io ) {
                    System.out.println( io.getMessage() );
                }
                catch ( JDOMException jdomex ) {
                    System.out.println( jdomex.getMessage() );
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
	}
       
    public static void enviaDatos(List lista,Element nodoRaiz,HttpSession session){
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreNodo = hijo.getName();  // Obtenemos el nombre del nodo hijo y   
            String texto = hijo.getValue();  // su contenido de tipo texto
            String tipoU = hijo.getName();//Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nombreU = hijo.getAttributeValue("nombre"); 
            String nUser = hijo.getAttributeValue("user");
            String passU = hijo.getAttributeValue("password");
            String nEmail = hijo.getAttributeValue("email");
            String describeU = hijo.getValue(); 
            
            session.setAttribute("user"+i,nUser);
            session.setAttribute("nombre"+i,nombreU);
            session.setAttribute("pass"+i,passU);
            session.setAttribute("email"+i,nEmail);
        }
        session.setAttribute("tam",""+lista.size());
    }
}