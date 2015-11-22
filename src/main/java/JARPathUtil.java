import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by akash on 22/11/15.
 */
public final class JARPathUtil {

    public  static String getJARPathString(final Class clazz) {
        return getJARPath(clazz).toString();

    }

    public  static String getJARFileName(final Class clazz) {
        return getJARPath(clazz).getFileName().toString();

    }

    private static Path getJARPath(final Class clazz) {
        return Paths.get(clazz.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1));
    }
}
