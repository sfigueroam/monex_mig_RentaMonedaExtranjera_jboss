package cl.teso.reca.pkgcutservicesmonex.ejb; 
import javax.ejb.Stateless; 
import javax.ejb.TransactionAttribute; 
import javax.ejb.TransactionAttributeType; 
import javax.annotation.Resource; 
import javax.sql.DataSource; 
import java.io.Serializable; 
import cl.teso.reca.pkgcutservicesmonex.dao.*; 
import cl.teso.reca.pkgcutservicesmonex.vo.*; 

/** 
* Session Bean implementation class PkgCutServicesMonex 
*/ 
@Stateless(name="PkgCutServicesMonex", mappedName="cl.teso.reca.pkgcutservicesmonex.PkgCutServicesMonex") 

@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class PkgCutServicesMonex implements PkgCutServicesMonexRemote,PkgCutServicesMonexLocal { 

  @Resource(lookup = "java:/jdbc/recaDS") DataSource dataSource; 

  /** 
  * Default constructor. 
  */ 
  public PkgCutServicesMonex() { 
    // TODO Auto-generated constructor stub 
  } 


  @Override 
  public TrxFormOutVO trxForm(TrxFormInVO entrada) throws Exception{ 
    try{ 
       TrxFormDAO dao = new TrxFormDAO(); 
       dao.setEntrada(entrada); 
       Serializable salida = dao.executeProcedure(dataSource); 
       return (TrxFormOutVO) salida; 
    }catch (java.sql.SQLException ex){ 
      throw new Exception(ex); 
    } 
  } 



} 
