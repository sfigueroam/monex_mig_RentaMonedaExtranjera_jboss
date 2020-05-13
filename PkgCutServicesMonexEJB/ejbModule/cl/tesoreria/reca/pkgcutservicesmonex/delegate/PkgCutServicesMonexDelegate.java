package cl.teso.reca.pkgcutservicesmonex.delegate; 
import cl.teso.reca.pkgcutservicesmonex.locator.PkgCutServicesMonexLocator; 
import cl.teso.reca.pkgcutservicesmonex.vo.*; 

public class PkgCutServicesMonexDelegate { 

  private PkgCutServicesMonexLocator locator; 

  public PkgCutServicesMonexDelegate() { 
    locator = new PkgCutServicesMonexLocator(); 
  } 


  public TrxFormOutVO trxForm(TrxFormInVO entrada) throws Exception{ 
    return  locator.getPkgCutServicesMonex().trxForm(entrada); 
  } 


} 
