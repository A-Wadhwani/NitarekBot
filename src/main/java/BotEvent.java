public abstract class BotEvent {
    private String input;

    public BotEvent(String input){
        this.input = input;
    }

    String getInput(){
        return input;
    }
    abstract String getOutputMessage();
}
