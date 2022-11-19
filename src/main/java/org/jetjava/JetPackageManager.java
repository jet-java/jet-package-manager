package org.jetjava;

import lombok.extern.slf4j.Slf4j;
import org.jetjava.commands.JPMParam;
import picocli.CommandLine;

@Slf4j
public class JetPackageManager {

    public static void main(String[] args) {
        // 解析参数
        final JPMParam cmdParam = new JPMParam();
        final CommandLine commandLine = new CommandLine(cmdParam);
        try {
            log.error(args.toString());
            final CommandLine.ParseResult parseResult = commandLine.parseArgs(args);
            checkParamHelp(args.length == 0, commandLine, parseResult);


            if (parseResult.hasSubcommand()) {
                log.info("Has SubCommand: true");
                for (CommandLine.ParseResult subCommand : parseResult.subcommands()) {
                    log.info("SubCommand: {}", subCommand.commandSpec().commandLine().getCommandName());

                    final CommandLine c = subCommand.commandSpec().commandLine();
                    checkParamHelp(args.length == 1, c, subCommand);
                }
            }
        } catch (CommandLine.ParameterException e) {
            commandLine.usage(System.out);
            for (CommandLine c : commandLine.getSubcommands().values()) {
                c.usage(System.out);
            }
            System.exit(1);
        }
//        log.info("cmd params:{}", cmdParam.);
    }

    private static void checkParamHelp(boolean empty, CommandLine commandLine, CommandLine.ParseResult parseResult) {
        if (empty || parseResult.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            System.exit(0);
        }
        if (parseResult.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            System.exit(0);
        }
    }

}
