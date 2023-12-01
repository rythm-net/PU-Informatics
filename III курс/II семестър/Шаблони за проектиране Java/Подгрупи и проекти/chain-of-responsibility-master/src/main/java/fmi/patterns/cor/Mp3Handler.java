package fmi.patterns.cor;

public class Mp3Handler extends Handler {

  public Mp3Handler(Handler successor){
    this.setSuccessor(successor);
  }
  
  @Override
  public void parse(String fileName) {
    System.out.printf("Опит за обработка на %s с %s ... %n", fileName, this.getClass().getName());

    if ( canHandleFile(fileName, ".mp3")){
      System.out.printf("  # Файлът %s се обработва от Mp3 обработчик %n", fileName);
    }
    else{
      super.parse(fileName);
    }
  }
}