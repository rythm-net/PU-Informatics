import java.io.File;

public class FileTraversal {

    public static void traverse(String filePath) {

        // взимам си папка или файл с който да работя
        File fileElement = new File(filePath);
        File[] fileCollection = fileElement.listFiles();

        // класически FOR цикъл
//        for(int i = 0; i < fileCollection.length; i++) {
//        File element = fileCollection[i];
//
//            if(!fileCollection[i].isDirectory()) {
//                System.out.println(fileCollection[i].getAbsoluteFile());
//            }
//        }

        // модифициран FOR цикъл
        // когато не ни интересува позицията на елемента в колекцията
        for(File element : fileCollection) {

            if(element.isDirectory()) {
                traverse(element.getAbsolutePath());
            }

            else {
                System.out.println(element.getAbsoluteFile());
            }
        }
    }
}