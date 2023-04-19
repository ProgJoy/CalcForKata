
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner inputFirstNumber = new Scanner(System.in);
        Scanner inputSecondNumber = new Scanner(System.in);

        //Определяет тип введенных чисел
        boolean isArabic;

        System.out.print("Введите число: ");
        System.out.println("boobs " + inputSecondNumber.hasNextInt());

        //Определяем тип первой цифры (арабский или римский)
        if (inputFirstNumber.hasNextInt()){
            isArabic = true;
            System.out.println("Это цифра");
        } else {
            isArabic = false;
            System.out.println("Это буква");
        }

        //Проверяем совпадают ли типы первой и второй переменной
        // И повторяем процесс пока пользователь не введет одинаковые типы данных

        //Как это работает: Если inputFirstNumber арабское число, то и isArabic будет true,
        //соответственно если inputSecondNumber.hasNextInt() выдаст false, а isArabic = true - типы данных разные
        while (inputSecondNumber.hasNextInt() != isArabic){
            System.out.println("Извините, вы ввели разные типы данных, попробуйте снова");
            inputSecondNumber.hasNext();
        }

        System.out.println(inputFirstNumber + " " + inputSecondNumber);


        //Если введенные данные
        //String romanNumeral = convert(number);

        // Output the Roman numeral
        //System.out.println("Roman numeral: " + romanNumeral);
    }

    public static String convert(int number)
    {
        // Create arrays to hold the Roman numerals and their respective values
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Create a StringBuilder object to build the Roman numeral string
        StringBuilder romanNumeral = new StringBuilder();

        // Loop through the values array and build the Roman numeral string
        for (int i = 0; i < values.length; i++)
        {
            while (number >= values[i])
            {
                number -= values[i];
                romanNumeral.append(romanNumerals[i]);
            }
        }

        // Return the Roman numeral string
        return romanNumeral.toString();
    }
}
