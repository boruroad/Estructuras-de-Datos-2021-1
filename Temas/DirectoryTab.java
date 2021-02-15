import java.io.File;

public class DirectoryTab {

    public static void fileTab(int tab, File root) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(root.getName());
        if (root.isDirectory()) {
            for (String childname : root.list()) {
                fileTab(tab + 1, new File(root, childname));
            }
        }
    }

    public static void main(String args[]) {
        String path = "root_dir";
        File f = new File(path);
        fileTab(0, f);
    }
}
