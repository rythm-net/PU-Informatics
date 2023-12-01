package fmi.patterns.cor;

public class TextHandler extends Handler{

  public TextHandler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    System.out.printf("Опит за обработка на %s с %s ... %n", fileName, this.getClass().getName());

    if ( canHandleFile(fileName, ".txt")){
      System.out.printf("  # Файлът %s се обработва от обработчик на текст %n", fileName);
    }
    else{
      super.parse(fileName);
    }
  }
}