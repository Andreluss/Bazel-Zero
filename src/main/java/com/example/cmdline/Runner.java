package com.example.cmdline;

import com.example.Greeting;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Runner {
    public static void main(String args[]) {
        Options options = new Options()
            .addOption("h", "help", false, "Displays this help info.");
        
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("h")) {
                new HelpFormatter().printHelp("runner", options);
            } else {
                Greeting.sayHi();
            }
        }
        catch (ParseException exp) {
            System.err.println("CLI parser failed: " + exp.getMessage());
        }
    }
}
