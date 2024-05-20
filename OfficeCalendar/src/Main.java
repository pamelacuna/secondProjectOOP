import calendar.Calendar;
import calendar.CalendarClass;
import calendar.exceptions.ExistentAccountException;
import calendar.exceptions.UnknownAccountTypeException;

import java.util.Scanner;

public class Main {
    private static final String EXIT_MSG = "Bye!";
    private static final String UNKNOWN_COMMAND = "Unknown command %s. Type help to see available commands.";
    private static final String NEW_ACCOUNT_REGISTERED = "%s was registered.\n";
    private static final String EXISTENT_ACCOUNT = "Account %s already exists.\n";
    private static final String UNKNOWN_ACC_TYPE = "Unknown account type.";

    private enum Command {
        REGISTER("REGISTER"), ACCOUNTS("ACCOUNTS"), CREATE("CREATE"), EVENTS("EVENTS"),
        INVITE("INVITE"), RESPONSE("RESPONSE"), EVENT("EVENT"), TOPICS("TOPICS"),
        HELP("HELP"), EXIT("EXIT"), UNKNOWN_COMMAND("");

        private final String commandInputName;

        private Command(String commandInputName) {
            this.commandInputName = commandInputName;
        }

        public String getCommandInputName() {
            return commandInputName;
        }
    }

    private enum Help {
        REGISTER("register - registers a new account"),
        ACCOUNTS("accounts - lists all registered accounts"),
        CREATE("create - creates a new event"),
        EVENTS("events - lists all events of an account"),
        INVITE("invite - invites an user to an event"),
        RESPONSE("response - response to an invitation"),
        EVENT("event - shows detailed information of an event"),
        TOPICS("topics - shows all events that cover a list of topics"),
        HELP("help - shows the available commands"),
        EXIT("exit - terminates the execution of the program");

        private final String commandHelp;

        private Help(String commandHelp) {
            this.commandHelp = commandHelp;
        }

        public String getCommandHelp() {
            return commandHelp;
        }
    }

    public static void main(String[] args) {
        executeCommands();
    }

    private static void executeCommands() {
        Scanner in = new Scanner(System.in);
        Calendar c = new CalendarClass();
        Command cmd = readCommand(in);

        while (!cmd.equals(Command.EXIT)) {
            switch (cmd) {
                case REGISTER -> executeRegister(in, c);
                case ACCOUNTS -> executeAccounts();
                case CREATE -> executeCreate();
                case EVENTS -> executeEvents();
                case INVITE -> executeInvite();
                case RESPONSE -> executeResponse();
                case EVENT -> executeEvent();
                case TOPICS -> executeTopics();
                case HELP -> executeHelp();
                default -> System.out.printf(UNKNOWN_COMMAND, cmd.getCommandInputName()); // fazer metodo
            }
            System.out.println();
            cmd = readCommand(in);
        }
        executeExit();
        in.close();
    }

    private static void executeExit() {
        System.out.println(EXIT_MSG);
    }

    private static void executeHelp() {
        for (Help help : Help.values()) {
            System.out.println(help.getCommandHelp());
        }
    }

    private static void executeTopics() {

    }

    private static void executeEvent() {

    }

    private static void executeResponse() {

    }

    private static void executeInvite() {

    }

    private static void executeEvents() {

    }

    private static void executeCreate() {

    }

    private static void executeAccounts() {

    }

    private static void executeRegister(Scanner in, Calendar c) {
        try {
            String accountName = in.next();
            String accountType = in.nextLine().trim();

            if (c.isValidType(accountType)) {
                c.register(accountName, accountType);
                System.out.println("Lipy");
                System.out.printf(NEW_ACCOUNT_REGISTERED, accountName);

            }
        }
        catch (UnknownAccountTypeException e) {
            System.out.print(UNKNOWN_ACC_TYPE);
        }
        catch (ExistentAccountException e) {
            System.out.printf(EXISTENT_ACCOUNT, e.getAccountName());
        }

    }

    // refazer aqui
    private static Command readCommand(Scanner in) {
        String input = in.next().toUpperCase().trim();

        for (Command c : Command.values()) {
            if (c.getCommandInputName().equals(input))
                return c;
        }
        return Command.UNKNOWN_COMMAND;
    }
}