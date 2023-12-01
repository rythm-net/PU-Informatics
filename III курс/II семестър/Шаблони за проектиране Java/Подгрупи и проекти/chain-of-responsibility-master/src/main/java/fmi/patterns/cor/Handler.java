package fmi.patterns.cor;

public abstract class Handler {
  
  private Handler successor;
  
  public void parse(String fileName){
    if ( getSuccessor() != null ){
      System.out.printf("   * Препращане към %s ...%n", getSuccessor().getClass().getName());
      getSuccessor().parse(fileName);
    }
    else{
      System.out.printf("  @ Не може да бъде намерен правилен обработчик за %s %n", fileName);
    }
  }
  
  protected boolean canHandleFile(String fileName, String format){
    return (fileName != null) && (fileName.endsWith(format));
  }

  Handler getSuccessor() {
    return successor;
  }

  void setSuccessor(Handler successor) {
    this.successor = successor;
  }
}