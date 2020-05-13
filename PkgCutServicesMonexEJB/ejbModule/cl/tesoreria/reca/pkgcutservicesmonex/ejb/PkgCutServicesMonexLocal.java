package cl.teso.reca.pkgcutservicesmonex.ejb; 

import javax.ejb.Local; 
import cl.teso.reca.pkgcutservicesmonex.vo.*; 

@Local 
public interface PkgCutServicesMonexLocal  { 


  public TrxFormOutVO trxForm(TrxFormInVO entrada) throws Exception; 


} 
