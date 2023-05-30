package tools;

import java.io.File;

public class FolderFinder {
    public static String findAbsolutePath(String origin, String target) {
        File start = new File(origin);
        return recursiveFinder(start, target).getAbsolutePath();
    }

    public static String findAbsolutePath(File origin, String target) {
        return recursiveFinder(origin, target).getAbsolutePath();
    }

    private static File recursiveFinder(File origin, String target) {
        if (!origin.isDirectory())
            return null;

        if (origin.getName().equals(target))
            return origin;

        File[] subFolders = origin.listFiles();
        if (subFolders != null) {
            for (File folder : subFolders) {
                File targetFolder = recursiveFinder(folder, target);
                if (targetFolder != null) {
                    return targetFolder;
                }
            }
        }
        return null;
    }
}