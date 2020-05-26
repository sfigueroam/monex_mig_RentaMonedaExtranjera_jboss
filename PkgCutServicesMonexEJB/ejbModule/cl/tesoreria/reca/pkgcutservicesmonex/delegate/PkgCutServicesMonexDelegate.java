package cl.tesoreria.reca.pkgcutservicesmonex.delegate; 
import cl.tesoreria.reca.pkgcutservicesmonex.locator.PkgCutServicesMonexLocator; 
import cl.tesoreria.reca.pkgcutservicesmonex.vo.*; 

public class PkgCutServicesMonexDelegate { 

  private PkgCutServicesMonexLocator locator; 

  public PkgCutServicesMonexDelegate() { 
    locator = new PkgCutServicesMonexLocator(); 
  } 


  public TrxFormOutVO trxForm(TrxFormInVO entrada) throws Exception{ 
    return  locator.getPkgCutServicesMonex().trxForm(entrada); 
  } 


} 
