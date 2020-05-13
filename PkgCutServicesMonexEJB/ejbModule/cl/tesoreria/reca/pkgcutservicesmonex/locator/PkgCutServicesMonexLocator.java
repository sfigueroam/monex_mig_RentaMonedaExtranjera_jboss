package cl.teso.reca.pkgcutservicesmonex.locator; 

import javax.naming.Context; 
import javax.naming.InitialContext; 
import cl.teso.reca.pkgcutservicesmonex.ejb.*; 

public class PkgCutServicesMonexLocator { 

  private PkgCutServicesMonexRemote pkgCutServicesMonexRemote;

  public PkgCutServicesMonexRemote getPkgCutServicesMonex() throws Exception{ 
  
    if (pkgCutServicesMonexRemote==null){ 
      Context context = new InitialContext();
      pkgCutServicesMonexRemote = (PkgCutServicesMonexRemote) context.lookup("cl.teso.reca.pkgcutservicesmonex.PkgCutServicesMonex#cl.teso.reca.pkgcutservicesmonex.ejb.PkgCutServicesMonexRemote"); 
    }
    return pkgCutServicesMonexRemote; 
  }
}
