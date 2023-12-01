package fmi.patterns.cor;

import java.util.List;
import java.util.ArrayList;

public class Client {

  public static void main(String[] args) {
    
    // Списък с имена на файлове за парсиране
    List<String> fileList = populateFiles();

    Handler chainHandler = buildChain();
    
    // Предава името на файла на първия обработчик във веригата
    for (String fileName: fileList){
      System.out.printf("%nProcessing file: %s ... %n", fileName);
      System.out.println("----------------------------------------------");
      chainHandler.parse(fileName);
    }
  }

  private static Handler buildChain() {
    // Този обработчик е последен във веригата
    Handler xmlHandler = new XmlHandler();

    Handler mp3Handler = new Mp3Handler(xmlHandler);
    Handler docxHandler = new DocxHandler(mp3Handler);

    // TextParser е първият обработчик във веригата.
    return new TextHandler(docxHandler);
  }
  
  private static List<String> populateFiles(){
    
    List<String> fileList = new ArrayList<>();
    fileList.add("textFile.txt");
    fileList.add("someFile.jpg");
    fileList.add("xmlFile.xml");
    fileList.add("mp3File.mp3");
    fileList.add("wordFile.docx");
    
    return fileList;
  }
}
