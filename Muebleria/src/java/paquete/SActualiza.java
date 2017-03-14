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
public class SActualiza extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            String uUser=request.getParameter("uUser");
            String uNombre=request.getParameter("uNombre");
            String uPassword=request.getParameter("uPassword");
            String uEmail=request.getParameter("uEmail");
            /*
            Usuario: <input type="text" name='uUser' 	id="uUser" 		class="input" value="" ></label>
            Nombre:  <input type="text" name='uNombre'	id="uNombre" 	class="input" value="" ></label><br>
            Password:<input type="password" name='uPassword' id="uPassword" 	class="input" value="" ></label>
            Email:	 <input type="text" name='uEmail' 	id="uEmail" 	class="input" value="" ></label><br>
            */
            String [] datos={uUser,uNombre,uPassword,uEmail};
            
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
                    
                    /*Eliminando etiqueta*/
                    leer.eliminarEtiqueta(lista, uUser);//Recibe todo lo nuevo
                    leer.guardarXml(document,ruta+"\\Base.xml");
                    System.out.println("ELIMINADO");
                    /*String contenido=leer.mostrarXml(lista,nodoRaiz);
                    Escribe e=new Escribe(ruta+"\\Admin.html","Administrador",contenido);//crea el archivo admin.html
                    e.escribirArchivo();*/
                    /*Agregando nuevos datos*/
                    leer.crearCliente(nodoRaiz,datos);
                    leer.guardarXml(document,ruta+"\\Base.xml");
                    
                    enviaDatos(lista, nodoRaiz, session);
                    out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Administrador</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<script type='text/javascript'>" +
                                    " alert('Información actualizada!'); window.location='Admi-n.jsp';" +
                                    "</script>");
                        out.println("</body>");
                        out.println("</html>");
                        
                    /*String contenidoo=leer.mostrarXml(lista,nodoRaiz);
                    System.out.println("LISTO AGREGADO");
                    Escribe es=new Escribe(ruta+"\\Admin.html","Administrador",contenidoo);//crea el archivo Admin.html
                    es.escribirArchivo();*/
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