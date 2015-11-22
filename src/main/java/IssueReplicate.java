import org.apache.maven.cli.MavenCli;
import org.jacoco.agent.rt.IAgent;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        System.out.println("JAR File Path :   " + JARPathUtil.getJARPathString(IAgent.class));
        System.out.println("JAR File Name :   " + JARPathUtil.getJARFileName(IAgent.class));
        mavenCli.doMain(new String[] {"install"}, projectPath, out, out);
        out.close();
        System.out.print(baos.toString());
    }
}
