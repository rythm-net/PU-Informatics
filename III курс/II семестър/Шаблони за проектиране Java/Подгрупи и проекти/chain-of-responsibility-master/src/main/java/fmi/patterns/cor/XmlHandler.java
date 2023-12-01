package fmi.patterns.cor;

public class XmlHandler extends Handler {

  public XmlHandler(Handler successor) {
    this.setSuccessor(successor);
  }

  public XmlHandler() {
  }

  @Override
  public void parse(String fileName) {
    System.out.printf("Опит за обработка на %s с %s ... %n", fileName, this.getClass().getName());

    if ( canHandleFile(fileName, ".xml")){
      System.out.printf("  # Файлът %s се обработва от XML обработчик %n", fileName);
    }
    else{
      super.parse(fileName);
    }
  }
}