public class BotPing extends BotEvent {

    public BotPing() {
        super("nit ping");
    }

    @Override
    String getOutputMessage() {
        return "Pong! I'm working fine";
    }
}
