import java.util.*;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input your text : ");
        String text = input.nextLine();
        System.out.print("Enter your key (the number of shifts for the characters): ");
        int key = input.nextInt();
        String NewText = caesarify(text.toUpperCase(), key);
        System.out.println(NewText);
    }

    public static String caesarify(String text, int key) {
        String shiftednote = shiftAlphabet(key);
        String newText = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int n =0; n < text.length(); n++){
            String textchar = "" + text.charAt(n) ;
            int pos = alphabet.indexOf(textchar);
            String newchar = "" +shiftednote.charAt(pos);
            newText = newText + textchar.replace((textchar),(newchar));

            }
        return newText;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

}
