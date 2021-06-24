
package ProyectoPACK;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class GeneradorDeInformes {
    public static Connection conexion = null;
        String baseDatos = "jdbc:mysql://localhost/bascula";
        String usuario = "root";
        String clave = "";
        
    public GeneradorDeInformes()
    {
        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(baseDatos,usuario,clave);
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        }
        catch (SQLException sqle){
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        }
        catch (java.lang.InstantiationException | IllegalAccessException sqlex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
    }


    
    public void ejecutar(int desde,int hasta)
    {
        
        String archivojasper="Informes\\informeVehiculos.jasper";

        try
        {
            

            Map parametros = new HashMap();
            parametros.put("desde",desde);
            parametros.put("hasta",hasta);

            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);            
            JasperExportManager.exportReportToPdfFile(print, "Informe.pdf");

            File path = new File ("Informe.pdf");
            Desktop.getDesktop().open(path);

        }
        catch(IOException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);    
        }

    }    
}
