import java.util.Locale;

public class EnumTest {
    enum Colors{
        black, red, blue, pink, white
        }
    public static void main(String args[]) {
        Colors c = Colors.blue;
        String StColor = "Black";
        System.out.println("All constants of enum type Colors are:");
        Colors cArray[] = Colors.values(); //returns an array of constants of type Colors

        cArray[1]
        
/*        for(Colors a : cArray) {
            if (StColor == a.name())
                System.out.println("Еба, они сошлись");
        }
        c = Colors.valueOf("red");
        System.out.println("I Like " + c);*/
        
    }
}
