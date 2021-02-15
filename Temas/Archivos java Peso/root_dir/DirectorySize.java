import java.io.File;

public class DirectorySize {

    public static long diskUsage(File root) {
        long parcial;
        long total = 0;
        if (root.isDirectory()) {
            for (String childname : root.list()) {
                File child = new File(root, childname);
                total += diskUsage(child);
            }
            parcial = total;
        } else {
            parcial = root.length();
            total += parcial;
        }
        System.out.println(parcial + "\t" + root);
        return total;
    }

    public static void main(String args[]) {
        String path = "root_dir";
        File f = new File(path);
        System.out.println(f);
        System.out.println(diskUsage(f));
    }
}
