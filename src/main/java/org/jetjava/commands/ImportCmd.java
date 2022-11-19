package org.jetjava.commands;

import picocli.CommandLine;

/**
 * jpm set registry https://registry.jetjarva.org
 * jpm set registry https://registry.jetjarva.org
 */
@CommandLine.Command(name = "import", mixinStandardHelpOptions = true, helpCommand = true)
public class ImportCmd {
    @CommandLine.Option(names = {"-r", "--jdbc-url"}, required = true, description = "数据库地址")
    public String jdbcUrl;

    @CommandLine.Option(names = {"-u", "--username"}, required = true, description = "用户名")
    public String username;

    @CommandLine.Option(names = {"-p", "--secret-key"}, required = true, description = "秘钥")
    public String secretKey;

    @CommandLine.Option(names = {"-f", "--from"}, required = true, description = "来源")
    public String from;

    @CommandLine.Option(names = {"-t", "--to"}, required = true, description = "目标")
    public String to;
}
