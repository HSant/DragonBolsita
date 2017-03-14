package paquete;
import java.io.*; 
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Escribe{
    private String ruta=null;
    private String titulo=null;
    private String contenido=null;
    private FileWriter fichero=null;
    private PrintWriter pw=null;

    public Escribe(){}
    
    public Escribe(String ruta,String titulo,String contenido){
        this.ruta=ruta;
        this.titulo=titulo;
        this.contenido=contenido;
    }
    
    public String getRuta() {
        return ruta;
    }
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public FileWriter getFichero() {
        return fichero;
    }
    public void setFichero(FileWriter fichero) {
        this.fichero = fichero;
    }
    public PrintWriter getPw() {
        return pw;
    }
    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
    

    
    
    public String modificaRuta(String ruta){
        String r="";
        for(int i=0;i<ruta.length();i++){
            if(ruta.charAt(i)==92){
                r+="\\\\";
            }
            else
                r+=ruta.charAt(i);
        }

        return r;
    }
    public void htmlAdmin(){
        try{
            String rutaa=modificaRuta(getRuta());//Cambia "\" por "\\"
            fichero=new FileWriter(rutaa);
            pw=new PrintWriter (fichero);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("    <head>");
            pw.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>");
              pw.print("    <title>"+getTitulo());
            pw.println("</title>");
            pw.println("    </head>");
            pw.println("    <body>");
            pw.println("\t<p style='text-align:center; font-size:300%; font-family:arial;'>Bienvenido Admistrador </p> ");
            pw.println("\t<p style='text-align:center; font-size:100%; font-family:arial;'>Esta pagina solo puede ser vista por el adminsitrador </p>");
            pw.println("\t<p style='text-align:center; font-size:100%; font-family:arial;'>Seleccione una opción</p>");    
            
            pw.println("\t<Table  align='center'>");
            pw.println("\t\t<tr>");//tr filas
            pw.println("\t\t\t<td>Tipo de Usuario</td>");//td columnas
            pw.println("\t\t\t<td>Nombre</td>");
            pw.println("\t\t\t<td>ID</td>");
            pw.println("\t\t\t<td>Password</td>");
            pw.println("\t\t\t<td>Descripción</td>");
            pw.println("\t\t\t<td>Accion</td>");
            pw.println("\t\t</tr>");//tr filas
            pw.println(getContenido());
            pw.println("\t</Table>");
            pw.println("    </body>");
            pw.println("</html>");
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(null!=fichero)
                fichero.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void escribirArchivo () throws IOException{
        Writer wrt = null;
        try {
            wrt = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(getRuta()),"UTF8"));
            //archivo con codificación utf-8\n"            

            wrt.write("<!DOCTYPE html>\n");
            wrt.write("<html>\n");
            wrt.write("    <head>\n");
            wrt.write("\t\t<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>\n");
            wrt.write("\t\t<title>"+getTitulo());
            wrt.write("</title>\n");
            wrt.write("\t\t<link rel='stylesheet' href='bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css'>\n");
            wrt.write("\t\t<script type='text/javascript' src='scripts/ActualizaTabla.js'></script>\n");
            wrt.write("    </head>\n");
            wrt.write("    <body>\n");
            //wrt.write("\t<p style='text-align:center; font-size:150%; font-family:arial;'>Usuarios Registrados</p>\n");    

            wrt.write("\t<Table class='table' id='tUsers'>\n");
            wrt.write("\t\t<tr>\n");//tr filas
            wrt.write("\t\t\t<td>Tipo de Usuario</td>\n");//td columnas
            wrt.write("\t\t\t<td>Nombre</td>\n");
            wrt.write("\t\t\t<td>ID</td>\n");
            wrt.write("\t\t\t<td>Password</td>\n");
            wrt.write("\t\t\t<td>Descripción</td>\n");
            wrt.write("\t\t</tr>\n");//tr filas
            wrt.write(getContenido());
            wrt.write("\t</Table>\n");
            //wrt.write("\t<p style='text-align:center; font-size:80%; font-family:arial;'>Nota: Esta página solo puede ser vista por el adminsitrador </p>\n");
            wrt.write("    </body>\n");
            wrt.write("</html>");
        }
        catch(Exception e){
          e.printStackTrace();
        }
        finally{
            wrt.close();
        }
    }
}