import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ICSParser icsParser = new ICSParser(args[0]);
        for(EvenementEcole evenementEcole : icsParser.getEvenementEcole())
            System.out.println(evenementEcole);
    }
}