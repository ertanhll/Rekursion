/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static void printNumbersAscending(int start, int end, int divider) {
        if (start <= end && divider > 0) {
            if (end % divider == 0) {
                printNumbersAscending(start, end - 1, divider);
                System.out.print(end + " ");
            } else {
                printNumbersAscending(start, end - 1, divider);
            }
        }
    }

    private static void printNumbersDescending(int start, int end, int divider) {
        if (start <= end && divider > 0) {
            if (start % divider != 0) {
                printNumbersDescending(start + 1, end, divider);
                System.out.print(start + " ");
            } else {
                printNumbersDescending(start + 1, end, divider);
            }
        }
    }

    private static int calcDigitProduct(int number) {

        int helper;
        int summe = 1;

        if (number > 0) {
            helper = number % 10;
            if (helper == 0) {
                summe = 0;
                summe += helper + calcDigitProduct(number / 10);
            } else {
                summe *= helper * calcDigitProduct(number / 10);
            }
        }
        return summe;
    }


    private static String filterNumbersInString(String text) {

        String output = "";
        if (text.length() < 1)
            return text;
        else {
            if ((text.charAt(0) >= '0' && text.charAt(0) <= '9')) {
                output += filterNumbersInString(text.substring(1));
            } else {
                output += text.charAt(0);
                output += filterNumbersInString(text.substring(1));
            }
        }
        return output;
    }

    private static String reverseStringDoubleLetter(String text, char letter) {

        String output = "";

        if (text.length() < 1) {
            return text;
        } else {
            if ((text.charAt(text.length() - 1) == letter)) {
                output += "" + (text.charAt(text.length() - 1)) + (text.charAt(text.length() - 1));
                output += reverseStringDoubleLetter(text.substring(0, text.length() - 1), letter);
            } else {
                output += (text.charAt(text.length() - 1));
                output += reverseStringDoubleLetter(text.substring(0, text.length() - 1), letter);

            }
        }
        return output;

    }

    public static void main(String[] args) {
        printNumbersAscending(10, 20, 2);
        System.out.println();
        printNumbersDescending(5, 15, 3);
        System.out.println();

        System.out.println(calcDigitProduct(1));
        System.out.println(calcDigitProduct(102));
        System.out.println(calcDigitProduct(1234));
        System.out.println(calcDigitProduct(10000));
        System.out.println(calcDigitProduct(93842));
        System.out.println(calcDigitProduct(875943789));
        assert (calcDigitProduct(1) == 1);
        assert (calcDigitProduct(102) == 2);
        assert (calcDigitProduct(1234) == 24);
        assert (calcDigitProduct(10000) == 1);
        assert (calcDigitProduct(93842) == 1728);
        assert (calcDigitProduct(875943789) == 15240960);
        System.out.println();

        System.out.println(filterNumbersInString("hallo"));
        System.out.println(filterNumbersInString("Test 1 mit 45 Punkten!"));
        System.out.println(filterNumbersInString("1A1234567890B0"));
        assert (filterNumbersInString("hallo").equals("hallo"));
        assert (filterNumbersInString("Test 1 mit 45 Punkten!").equals("Test  mit  Punkten!"));
        assert (filterNumbersInString("1A1234567890B0").equals("AB"));
        assert (filterNumbersInString("a1b2c3d4e5").equals("abcde"));
        assert (filterNumbersInString("").equals(""));
        System.out.println();

        System.out.println(reverseStringDoubleLetter("X", 'X'));
        System.out.println(reverseStringDoubleLetter("Hallo", 'l'));
        System.out.println(reverseStringDoubleLetter("String umdrehen!", 'z'));
        assert (reverseStringDoubleLetter("X", 'X').equals("XX"));
        assert (reverseStringDoubleLetter("Hallo", 'l').equals("ollllaH"));
        assert (reverseStringDoubleLetter("String umdrehen!", 'z').equals("!neherdmu gnirtS"));
        assert (reverseStringDoubleLetter("ABACADAFA", 'A').equals("AAFAADAACAABAA"));
        assert (reverseStringDoubleLetter("", 'A').equals(""));
    }
}

//1.Eine rekursive Methode ist fundiert, wenn es eine erreichbare
//Abbruchbedingung gibt. Es  hängt mit dem Induktionsanfang zusammen
//2.Methodenausführung erzielt einen Fortschritt, wenn sie uns
//näher an die Abbruchbedingung bringt. Es hängt mit dem Induktionsschritt zusammen.
//3.Abbruchbedingung, die dafür sorgt, dass keine endlose Schleife entsteht.
//4.Ja. The limit is bis die größe von Stack. Zwischen 320k und 1024k

