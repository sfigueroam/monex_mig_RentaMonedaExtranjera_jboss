package cl.tesoreria.finanzas.properties; 

import java.io.FileInputStream;
import java.util.Properties;

public class CargarArchivo 
{ 
    public static String VIGENCIA_F50 = "";
    public static final String FILE_NAME = "RentaMonedaExtranjera.properties";

  
    public CargarArchivo() {
    }



    public static void cargarVigencia(String c8707) throws Exception{
        FileInputStream fileInputStream = null;
        String valorVigencia = "vigencia.50.8707." + c8707;
        try{
            fileInputStream = new FileInputStream(FILE_NAME);
            Properties prop = new Properties();
            prop.load(fileInputStream);

            VIGENCIA_F50 = prop.getProperty(valorVigencia);

     
        } finally {
            fileInputStream.close();
        }
    }
    
} 
