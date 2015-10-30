import org.apache.maven.cli.MavenCli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by tariq.ibrahim on 29-10-2015.
 */
public class IssueReplicate {

    public static void main(String args[]) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("maven.multiModuleProjectDirectory", projectPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        MavenCli mavenCli = new MavenCli();
        mavenCli.doMain(new String[] {"install"}, projectPath, out, out);
        out.close();
        System.out.print(baos.toString());
    }
}
