package cl.teso.reca.pkgcutservicesmonex.ejb; 

import javax.ejb.Remote; 
import cl.teso.reca.pkgcutservicesmonex.vo.*; 

@Remote 
public interface PkgCutServicesMonexRemote  { 


  public TrxFormOutVO trxForm(TrxFormInVO entrada) throws Exception; 


} 
