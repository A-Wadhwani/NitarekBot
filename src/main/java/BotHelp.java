public class BotHelp extends BotEvent {
    public BotHelp() {
        super("nit help");
    }

    @Override
    String getOutputMessage() {
        return "Hi! I'm Nitarek, a dumb bot.\n" +
                "I have the following commands so far: \n" +
                "`nit help`: Shows this menu.\n" +
                "`nit ping`: I say pong!, if I'm connected at least.\n" +
                "`nit cat`  : I will show you images of cats.\n";
    }
}
