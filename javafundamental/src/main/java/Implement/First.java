package Implement;

public class First extends AFirst implements IFirst {


  public First(String id){
    this.id = id;
  }
  
  @Override
  public void setId(String id) {
    // TODO Auto-generated method stub
    this.id  = id;
  }

  public static void main(String argv[]){
    IFirst first = new First("shazi");
    System.out.println( first.getId());
  }
}
