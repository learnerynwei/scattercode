package Implement;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

public abstract class AFirst {
  String id;
  public String getId(){
    return id;
  }
  
  public abstract void setId(String id);
}
