public class PlayerFactory {
    public static Player createHumanPlayer(Symbol symbol, String name, String email, String image) {
        return new HumanPlayer(symbol, name, email, image);
    }

    public static Player createBotPlayer(Symbol symbol, Difficultylevel level) {
        BotStrategy strategy;
        switch (level) {
            case MEDIUM:
                strategy = new MediumStrategy(); break;
            case HARD:
                strategy = new HardStrategy(); break;
            default:
                strategy = new EasyStrategy();
        }
        return new BotPlayer(symbol, strategy);
    }
}
