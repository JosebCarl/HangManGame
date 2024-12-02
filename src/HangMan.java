public class HangMan {

    private String answer;
    private String empty = "";
    private String temp;

    public HangMan() {}

    public void insert(String secretWord) {
        answer = secretWord;
        for (int i = answer.length(); i > 0; i-- ) {
            empty = empty + "_";
        }
    }

    public void check(String letter) {
        temp = empty;
        for (int i = answer.length() - 1; i >= 0; i--) {
            if (answer.substring(i,i + 1).equalsIgnoreCase(letter)) {
                empty = empty.substring(0,i) + letter + empty.substring(i + 1);
            }
        }
    }

    public Boolean incorrect() {
        return temp.equals(empty);
    }

    public String humanoid(int tries) {
        String humanoid = "";
        if (tries == 6) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "           |\n" +
                    "           |\n" +
                    "           |\n" +
                    "           |\n" +
                    "           |\n" +
                    "   ________|________\n";
        }
        if (tries == 5) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "  (_)      |\n" +
                    "           |\n" +
                    "           |\n" +
                    "           |\n" +
                    "           |\n" +
                    "   ________|________\n";
        }
        if (tries == 4) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "  (_)      |\n" +
                    "   |       |\n" +
                    "   |       |\n" +
                    "           |\n" +
                    "           |\n" +
                    "   ________|________\n";
        }
        if (tries == 3) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "  (_)      |\n" +
                    "   |\\      |\n" +
                    "   | \\     |\n" +
                    "           |\n" +
                    "           |\n" +
                    "   ________|________\n";
        }
        if (tries == 2) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "  (_)      |\n" +
                    "  /|\\      |\n" +
                    " / | \\     |\n" +
                    "           |\n" +
                    "           |\n" +
                    "   ________|________\n";
        }
        if (tries == 1) {
            humanoid = "    _______\n" +
                    "   |       |\n" +
                    "  _|_      |\n" +
                    "  (_)      |\n" +
                    "  /|\\      |\n" +
                    " / | \\     |\n" +
                    "    \\      |\n" +
                    "     \\     |\n" +
                    "   ________|________\n";
        }
        if (tries == 0) {
            humanoid = "    _______\n   |       |\n  _|_      |\n  (_)      |\n  /|\\      |\n / | \\     |\n  / \\      |\n /   \\     |\n   ________|________";
        }
        return humanoid;
    }

    public Boolean win() {
        return answer.equalsIgnoreCase(empty);
    }

    public void empty() {
        System.out.println(empty);
    }

    public String answer() {
        return answer;
    }
}