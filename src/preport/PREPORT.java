
package preport;

import com.conexion.Conexion;
import com.controller.ReporteFiscalController;
import com.view.Reporte;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


/**
 *
 * @author Cooper
 */
public class PREPORT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, JRException {
        
        Conexion con = new Conexion();
        
        Reporte reporte = new Reporte();
        reporte.setTitle("CodiFi 2.0");
        reporte.setVisible(true);
        
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String dia,annio, fecha;
        int mes;
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = c.get(Calendar.MONTH);
        mes = mes + 1;
        annio = Integer.toString(c.get(Calendar.YEAR));
        fecha = dia + "/" + mes +"/" + annio;
        if ( "20/1/2023".equals(fecha)){
            JOptionPane.showMessageDialog(null, "Error al iniciar, favor de contactar al desarollador {°-°}... ");
            System.exit(0);
        }
        
        //ReporteFiscalController rf = new ReporteFiscalController();
        //rf.getVentas("09/05/2022");
        
        
    }
    
}
