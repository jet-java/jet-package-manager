package org.jetjava.commands;

import org.jetjava.commands.set.SetCmd;
import picocli.CommandLine;

@CommandLine.Command(name = "jpm", subcommands = {SetCmd.class}, mixinStandardHelpOptions = true, helpCommand = true)
public class JPMParam {
}

