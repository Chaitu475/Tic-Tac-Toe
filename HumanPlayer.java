import java.util.Scanner;

public class HumanPlayer extends Player {
    private String name;
    private String email;
    private String profileImage;

    public HumanPlayer(Symbol symbol, String name, String email, String profileImage) {
        super(symbol);
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }

    @Override
    public int[] makeMove(Board board) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c= sc.nextInt();
        return new int[]{r,c};
    }
}
