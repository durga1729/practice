package practice.dp;

public class IntegerToRoman {
    private Numeral[] numerals = {new Numeral("M",1000),
            new Numeral("CM",900),
            new Numeral("D",500),
            new Numeral("CD",400),
            new Numeral("C",100),
            new Numeral("XC",90),
            new Numeral("L",50),
            new Numeral("XL",40),
            new Numeral("X",10),
            new Numeral("IX",9),
            new Numeral("V",5),
            new Numeral("IV",4),
            new Numeral("I",1)
    };
    public static void main(String[] args) {
        int i = 2944;
        String r = intToRoman(i);
        System.out.println(r);
    }

    public static String intToRoman(int num) {
        String result = "";
        IntegerToRoman integerToRoman = new IntegerToRoman();
       for (Numeral numeral:integerToRoman.numerals) {
        int numOfSymbols = num / numeral.value;
        if (numOfSymbols != 0) {
            result += numeral.symbol.repeat(numOfSymbols);
            num %= numeral.value;
        }
       }
       return result;
    }

    class Numeral {
        String symbol;
        int value;

        public Numeral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }
}
