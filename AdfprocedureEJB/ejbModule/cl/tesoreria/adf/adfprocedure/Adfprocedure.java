package cl.tesoreria.adf.adfprocedure; 

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

@Stateless(name = "Adfprocedure", mappedName = "cl.tesoreria.adf.adfprocedure.Adfprocedure")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class Adfprocedure implements AdfprocedureRemote, AdfprocedureLocal {
	
	@Resource(lookup = "java:/jdbc/ecusqlDS")
	private DataSource dataSource;
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.RentaMonedaExtranjera.Adfprocedure");

	@Override
	public ProcessResult process(String touplestgf, String contexttgfin)
			throws AdfprocedureException {
		try {
			return ProcessCaller.execute(dataSource, touplestgf, contexttgfin);
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();
			logger.error("Error en el metodo Adfprocedure.process() : " + ex);
			throw new AdfprocedureException(ex.getMessage(), ex);
		}
	}

}