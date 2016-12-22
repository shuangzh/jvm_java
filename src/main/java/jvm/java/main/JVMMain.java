package jvm.java.main;

import org.apache.commons.cli.*;

/**
 * Created by admin on 2016/12/22.
 */
public class JVMMain {
    public static void main(String[] args) throws Exception {
        CommandLineParser commandLineParser=new DefaultParser();
        Options options=new Options();
        options.addOption("h", false, "print helop message");
        options.addOption("p",true,"classpath");
        CommandLine commandLine=commandLineParser.parse(options, args);

        HelpFormatter helpFormatter=new HelpFormatter();
        if (commandLine.hasOption("h")) {
            helpFormatter.printHelp("jvm_java", options, true);
            System.exit(0);
        }
    }
}
