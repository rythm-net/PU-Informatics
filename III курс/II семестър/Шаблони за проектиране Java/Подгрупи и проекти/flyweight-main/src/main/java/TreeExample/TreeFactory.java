package TreeExample;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, Tree> treeMap = new HashMap<>();
    public static Tree getTree(String shape){
        Tree tree = treeMap.get(shape);
        if (tree == null){
            tree = new TreeImplement(shape);
            treeMap.put(shape, tree);
            System.out.println("Creating a " + shape + " tree.");
        }
        return tree;
    }
}
