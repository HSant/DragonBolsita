package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;           // |
import org.jdom.Element;            // |\ Librerias
import org.jdom.JDOMException;      // |/ JDOM
import org.jdom.input.SAXBuilder;   // |
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LeeXML{
//atributos
    public void crearCliente(Element nodoRaiz, String[] datos){
        /*----------Agregando una etiqueta----------*/
        // Creamos una nueva etiqueta  
         Element etiquetaNueva = new Element("Cliente");  
         // Añadimos los atributos
         etiquetaNueva.setAttribute("user",datos[0]);
         etiquetaNueva.setAttribute("nombre",datos[1]);
         etiquetaNueva.setAttribute("password",datos[2]);
         etiquetaNueva.setAttribute("email",datos[3]);
         // Añadimos el contenido(descripción del usuario)  
         //etiquetaNueva.setText("Este usuario es: "+datos[0]);  
         // La añadimos como hija a una etiqueta ya existente (al nodo raiz) 
         nodoRaiz.addContent(etiquetaNueva);  
        //nodoRaiz.addContent("holis");//asigna texto dentro de la etiqueta del nodo raiz
    }
    public void eliminarEtiqueta(List lista,String userToD){
        /*----------Borrando una etiqueta por id----------*/
        Iterator iter=lista.iterator();
        while(iter.hasNext()){
            Element hijo=(Element)iter.next();
            if( hijo.getAttributeValue("user").equals(userToD)){
                iter.remove();
            }
        }
    }
    
    public boolean fUser(String user,List lista,Element nodoRaiz){
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nNombre = hijo.getAttributeValue("nombre"); 
            String nUser = hijo.getAttributeValue("user");
            String passU = hijo.getAttributeValue("password");
            String describeU = hijo.getValue();
            if(user.equals(nUser)){
                return true;
            }
        }
        return false;
    }
    public void cUser(Element nodoRaiz, String[] datos){
        /*----------Agregando una etiqueta----------*/
        // Creamos una nueva etiqueta  
         Element etiquetaNueva = new Element(datos[0]);  
         // Añadimos los atributos
         etiquetaNueva.setAttribute("user",datos[1]);//nUser,nombre,pass,email
         etiquetaNueva.setAttribute("nombre",datos[2]);
         etiquetaNueva.setAttribute("password",datos[3]);
         etiquetaNueva.setAttribute("email",datos[4]);
         // Añadimos el contenido(descripción del usuario)  
         //etiquetaNueva.setText("Este usuario es: "+datos[0]);  
         // La añadimos como hija a una etiqueta ya existente (al nodo raiz) 
         nodoRaiz.addContent(etiquetaNueva);  
        //nodoRaiz.addContent("holis");//asigna texto dentro de la etiqueta del nodo raiz
    }
    
   /*public Element fUser(String user,List lista,Element nodoRaiz){
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nNombre = hijo.getAttributeValue("nombre"); 
            String nUser = hijo.getAttributeValue("user");
            String infoU = hijo.getValue();
            if(user.equals(nUser))
                return hijo;
        }
        return null;
    }*/
    
    public Element buscaUsuario(String user, String pass,List lista,Element nodoRaiz){
        
        
        Element usuario=null;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nombreU = hijo.getAttributeValue("nombre"); 
            String nUser = hijo.getAttributeValue("user");
            String passU = hijo.getAttributeValue("password");
            String describeU = hijo.getValue();
            if(user.equals(nUser) && pass.equals(passU) )
                    usuario=hijo;
        }
        return usuario;
    }
    public int buscaId(String id,List lista,Element nodoRaiz){
        int a=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nombreU = hijo.getAttributeValue("nombre"); 
            String idU = hijo.getAttributeValue("id");
            String passU = hijo.getAttributeValue("password");
            String describeU = hijo.getValue();
            if(id.equals(idU)){
                System.out.println("SE ENCONTRO usuario con un id="+id);
                a=1; 
            }
        }
        return a;
    }
    public int buscaE(String id,String nombre,List lista,Element nodoRaiz){
        int a=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz
            String nombreU = hijo.getAttributeValue("nombre"); 
            String idU = hijo.getAttributeValue("id");
            if(id.equals(idU) && nombre.equals(nombreU) ){
                System.out.println("Hay Coincidencia");
                a=1; 
            }
        }
        return a;
    }
    public int buscaM(String tipo,String id,String pass,List lista,Element nodoRaiz){
        int a=0;
        System.out.println("tipo:"+tipo+" id:"+id+" pass:"+pass+"");
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz
            String idU = hijo.getAttributeValue("id");
            String passU = hijo.getAttributeValue("password");
            
            if(tipo.equals(tipoU) && id.equals(idU) && pass.equals(passU) ){
                System.out.println("Hay coincidencia");
                a=1; 
            }
        }
        return a;
    }
    
    public void infoUsuario(String id,List lista,Element nodoRaiz){
    }
    
    public void guardarXml(Document document,String ruta){
    /*--------------Guardando el XML-----------------*/
    
        try{
            Document newdoc = new Document();
            newdoc=document;
            XMLOutputter fmt = new XMLOutputter();
            FileWriter writer = new FileWriter(ruta);
            fmt.output(newdoc, writer);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }
    public void guardarXMLD(Document documento,String ruta){
        try {
            XMLOutputter xmlOutputer = new XMLOutputter();
            // you can use this tou output the XML content to
            // the standard output for debugging purposes 
            // new XMLOutputter().output(doc, System.out);
            // write the XML File with a nice formating and alignment
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(documento, new FileWriter(ruta));
            System.out.println("XML File was created successfully!");
        } 
        catch (IOException ex) {
                                System.out.println(ex.getMessage());
        }
    }
    
    public void eliminararchivo(String archivo){
        File fichero = new File(archivo);
        if(fichero.delete()){
             System.out.println("archivo eliminado");
        }
        else{
            System.out.println("Error Al borrar");
        }
    }                    

    public String mostrarXml(List lista,Element nodoRaiz){
        String t="";
        for ( int i = 1; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreNodo = hijo.getName();  // Obtenemos el nombre del nodo hijo y   
            String texto = hijo.getValue();  // su contenido de tipo texto
            String tipoU = hijo.getName();//Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nombreU = hijo.getAttributeValue("nombre"); 
            String idU = hijo.getAttributeValue("id");
            String passU = hijo.getAttributeValue("password");
            String describeU = hijo.getValue(); 

           /* System.out.println( "Tipo de Usuario: " + tipoU );
            System.out.println( "Nombre: " + nombreU );
            System.out.println( "ID: " + idU );
            System.out.println( "Password: " + passU );
            System.out.println( "Descripcion: " + describeU +"\n");*/
            t+="\n\t\t<tr>";
            t+="\n\t\t\t<td>"+tipoU+"</td>";
            t+="\n\t\t\t<td>"+nombreU+"</td>";
            t+="\n\t\t\t<td>"+idU+"</td>";
            t+="\n\t\t\t<td>"+passU+"</td>";
            t+="\n\t\t\t<td>"+describeU+"</td>";
            t+="\n\t\t</tr>\n";
        }
        
        return t;
    }
    public void crearEtiqueta(Element nodoRaiz, String[] datos){
        /*----------Agregando una etiqueta----------*/
        // Creamos una nueva etiqueta  
         Element etiquetaNueva = new Element(datos[0]);  
         // Añadimos los atributos
         etiquetaNueva.setAttribute("nombre",datos[1]);
         etiquetaNueva.setAttribute("id",datos[2]);
         etiquetaNueva.setAttribute("password",datos[3]);
         // Añadimos el contenido(descripción del usuario)  
         etiquetaNueva.setText("Este usuario es: "+datos[0]);  
         // La añadimos como hija a una etiqueta ya existente (al nodo raiz) 
         nodoRaiz.addContent(etiquetaNueva);  
        //nodoRaiz.addContent("holis");//asigna texto dentro de la etiqueta del nodo raiz
    }
    public void eliminarEtiqueta(List lista,String nombre,String id){
        /*----------Borrando una etiqueta por id----------*/
            Iterator iter=lista.iterator();
            while(iter.hasNext()){
                Element hijo=(Element)iter.next();
                if( hijo.getAttributeValue("nombre").equals(nombre)){
                   if( hijo.getAttributeValue("id").equals(id))
                    iter.remove();
                }
            }
    }
    
    public int esProfe(String id,List lista,Element nodoRaiz){
        int x=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String tipoU = hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String nombreU = hijo.getAttributeValue("nombre"); 
            String idU = hijo.getAttributeValue("id");
            String passU = hijo.getAttributeValue("password");
            String describeU = hijo.getValue();
            if(id.equals(idU) && "Profesor".equals(tipoU) ){
                x=1;   
            }
        }
        return x;
    }
    public void crearGrupo(Element nodoRaiz,String idP,String n,String m){
        /*----------Agregando una etiqueta----------*/
        // Creamos una nueva etiqueta  
         Element etiquetaNueva = new Element(n);  
         // Añadimos los atributos
         etiquetaNueva.setAttribute("idProfesor",idP);
         etiquetaNueva.setAttribute("materia",m);
         // Añadimos el contenido(descripción del usuario)  
         etiquetaNueva.setText(n+" grupo de"+m);  
         // La añadimos como hija a una etiqueta ya existente (al nodo raiz) 
         nodoRaiz.addContent(etiquetaNueva);  
        //nodoRaiz.addContent("holis");//asigna texto dentro de la etiqueta del nodo raiz      
    }
    public void eliminarGrupo(Element nodoRaiz,String nombreG,String idProfe){
        /*----------Borrando una etiqueta por id----------*/
            //Iterator iter=lista.iterator();
            nodoRaiz.removeChildren(nombreG);

    }
    public int buscaGrupo(String nG,String mG,List lista,Element nodoRaiz){//regresa 1 si encuentra el grupo
        System.out.println("Busca Grupo----------");
        System.out.println("nombre grupo:"+nG+"materia:"+mG+" ");
        int x=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG= hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String idProfe = hijo.getAttributeValue("nombre"); 
            String materiaG = hijo.getAttributeValue("id");
            if(nG.equals(nombreG)){
                 System.out.println("ENTRO AL IF de BUSCA GRUPO----------");
                x=1; 
            }
        }
        return x;
    }
    public int buscaGrupo2(String idProfesor,String nomG,List lista,Element nodoRaiz){//regresa 1 si encuentra el grupo
        System.out.println("Busca Grupo2----------");
        
        int x=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG= hijo.getName();//nombre del nodo hijo <---tipo de usuario
            //Se obtienen los atributo del hijo del nodo raiz 'Hoja'
            String idProfe = hijo.getAttributeValue("idProfesor"); 
            String nomb = hijo.getAttributeValue("materia"); 
            if(idProfesor.equals(idProfe)&& nomG.equals(nombreG)){
                x=1; 
            }
        }
        return x;
    }
    public ArrayList<String[]> arrayGrupos(String idProfe,List lista,Element nodoRaiz){
        System.out.println("Entro a array");
        ArrayList<String[]> grupos = new ArrayList<String[]>();
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG = hijo.getName();//----->nombre del grupo
            //Se obtienen los atributo del grupo
            String idProfesor = hijo.getAttributeValue("idProfesor"); 
            String materiaG = hijo.getAttributeValue("materia");
            String describeG = hijo.getValue();
            if(idProfe.equals(idProfesor)){
                List<Element> hijosRaiz = hijo.getChildren();  
                String alumnos="";
                for(Element hr: hijosRaiz){  
                    // Obtenemos el nombre y su contenido de tipo texto  
                    String nombreA = hr.getAttributeValue("nombre");
                    String idA = hr.getAttributeValue("id");
                    System.out.println("Alumno:"+nombreA+" id:"+idA+" dentro del grupo:"+nombreG);
                     //String nombreAlum=hijosRaiz.getChild("Alumno").getAttributeValue("nombre")
                    alumnos+=nombreA+" "+idA+"\n";
                }
                //System.out.println("Entro al if");
                String [] gp={nombreG,materiaG,alumnos};
                grupos.add(gp);
            }
        }
        return grupos;
    }
    
    public void buscaAlumnos(String nombreGrupo,List lista,Element nodoRaiz){//regresa 1 si encuentra el grupo
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG = hijo.getName();//----->nombre del grupo
            //Se obtienen los atributo del grupo
            String idProfesor = hijo.getAttributeValue("idProfesor"); 
            String materiaG = hijo.getAttributeValue("materia");
            String describeG = hijo.getValue();
            
            List<Element> hijosRaiz = hijo.getChildren();  
            for(Element hr: hijosRaiz){  
                // Obtenemos el nombre y su contenido de tipo texto  
                String nombreA = hr.getAttributeValue("nombre");
                String idA = hr.getAttributeValue("id");
                System.out.println("Alumno:"+nombreA+" id"+idA);
                 //String nombreAlum=hijosRaiz.getChild("Alumno").getAttributeValue("nombre")
            }
           

        }
    }
    public int buscaGrupoProfe(String idProfesor, String nG,String mG,List lista,Element nodoRaiz){
        //regresa 1 si concuerda el grupo con el profesor
        int x=0;
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG = hijo.getName();//----->nombre del grupo
            //Se obtienen los atributo del grupo
            String idProfe = hijo.getAttributeValue("idProfesor"); 
            String materiaG = hijo.getAttributeValue("materia");
            if(nG.equals(nombreG) && idProfesor.equals(idProfe) )
                    x=1;
        }
        return x;
    }
    public void crearAlumno(Element nodoRaiz,List lista,String nG,String nombreA,String idA){
        /*----------Agregando un Alumno----------*/
        for ( int i = 0; i < lista.size(); i++ ){   //Se recorre la lista de hijos del nodo raiz
            Element hijo = (Element) lista.get(i);  //Se obtiene el nodo hijo
            String nombreG = hijo.getName();//----->nombre del grupo
            //Se obtienen los atributo del grupo
            String idProfe = hijo.getAttributeValue("idProfesor"); 
            String materiaG = hijo.getAttributeValue("materia");
            String describeG = hijo.getValue();
            if(nG.equals(nombreG) ){
                // Creamos una nueva etiqueta  
                Element etiquetaNueva = new Element("Alumno"); 
                // Añadimos los atributos
                etiquetaNueva.setAttribute("nombre",nombreA);
                etiquetaNueva.setAttribute("id",idA);
                // La añadimos como hija a una etiqueta ya existente (al nodo raiz) 
                hijo.addContent(etiquetaNueva);  
                //nodoRaiz.addContent("holis");//asigna texto dentro de la etiqueta del nodo raiz    
            }
        }

    }

}