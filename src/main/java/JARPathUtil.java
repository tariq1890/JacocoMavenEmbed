import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by akash on 22/11/15.
 */
public final class JARPathUtil {

    private static final boolean IS_WINDOWS = System.getProperty("os.name").startsWith("Windows");

    public static String getJARPathString(final Class clazz) {
        return getJARPath(clazz).toString();

    }

    public static String getJARFileName(final Class clazz) {
        return getJARPath(clazz).getFileName().toString();

    }

    private static Path getJARPath(final Class clazz) {
        final String pathString = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
        final String osAppropriatePath = IS_WINDOWS ? pathString.substring(1) : pathString;
        return Paths.get(osAppropriatePath);
    }
}
