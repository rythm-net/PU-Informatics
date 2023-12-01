package fmi.patterns.cor;

public class DocxHandler extends Handler {

  public DocxHandler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    System.out.printf("Опит за обработка на %s с %s ... %n", fileName, this.getClass().getName());

    if ( canHandleFile(fileName, ".docx")){
      System.out.printf("  # Файлът %s се обработва от DOCX обработчик %n", fileName);
    }
    else{
      super.parse(fileName);
    }
  }
}