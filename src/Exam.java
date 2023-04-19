import java.lang.reflect.Type;
import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {
        Scanner Example = new Scanner(System.in);

        System.out.println("Введите нужный пример, используя пробелы между символами");
        System.out.println("например: 3 + 4 или VI * III");

        //Вызываем метод калк и передаем туда введенный пример
        Exam.calc(Example.nextLine());
        Example.close();
    }

    public static void calc(String input){
        //хранение примера, введенного с консоли
        String ExampleString = input;
        //разделение примера по переменным массива, используя разделитель
        String[] SplitExampleString = ExampleString.split(" ");

        for (int i = 0; i < SplitExampleString.length; i++){
            SplitExampleString[i].trim();
        }

        int FirstNumberArabic = 0;
        int SecondNumberArabic = 0;

        String FirstNumberRome = null;
        String SecondNumberRome = null;

        boolean isArabicFirstNumber;
        boolean isArabicSecondNumber;

        //Если введено больше или меньше 3 значений, то вызывается ошибка
        if (SplitExampleString.length == 3) {
            //Определяем язык
            //Если значение из SplitExampleString не впихивается в инт, значит впихнется в стринг
            //соотвественно, это римские цифры
            try {
                FirstNumberArabic = Integer.parseInt(SplitExampleString[0]);
                //System.out.println("Первое число на арабском");
                isArabicFirstNumber = true;
            } catch (Exception exception) {
                FirstNumberRome = SplitExampleString[0];
                //System.out.println("Первое число на римском");
                isArabicFirstNumber = false;
            }

            //налогично со второй переменной
            try {
                SecondNumberArabic = Integer.parseInt(SplitExampleString[2]);
                //System.out.println("Второе число на арабском");
                isArabicSecondNumber = true;
            } catch (Exception exception) {
                SecondNumberRome = SplitExampleString[2];
               // System.out.println("Второе число на римском");
                isArabicSecondNumber = false;
            }

            //Если у обоих цифр в примере совпадают типы цифр (хз как это назвать), то продолжаем работу
            if (isArabicFirstNumber == isArabicSecondNumber) {
                //Если пример из римских цифр, то переводим их в арабские
                if (!isArabicFirstNumber) {
                    FirstNumberArabic = ConvertRomanToArabic(FirstNumberRome);
                    SecondNumberArabic = ConvertRomanToArabic(SecondNumberRome);
                }
                //Проверка на размерность чисел (0<=x<=10)
                if (FirstNumberArabic >= 0 && FirstNumberArabic <= 10 &&
                        SecondNumberArabic >= 0 && SecondNumberArabic <= 10) {
                    int FinalResult = MathCount(FirstNumberArabic, SplitExampleString[1], SecondNumberArabic);
                    //вывод результата в консоль
                    if (!isArabicFirstNumber) {
                        //Если результат меньше нуля, то выходит ошибка
                        if (FinalResult >= 0){
                            System.out.println("Результат " + ConvertArabicToRoman(FinalResult));
                        } else System.out.println("Ошибка: результат меньше нуля");
                    } else System.out.println("Результат " + FinalResult);

                } else {
                    System.out.println("Ошибка. \nВведите число от 1 до 10");
                }
            } else {
                System.out.println("Извините, вы ввели разные типы цифр.\nПрограмма не может быть выполнена");
            }
        }
    }

    //Поступает римское число, выходит арабское
    public static int ConvertRomanToArabic(String N){
        //Число, которое пуступило
        String NumberRoman = N;
        //Число, которое выйдет
        int NumberArabic = -1;

        //В NumberArabic вставляем порядковый номер найденного римского числа из енама.
        try{
            NumberArabic = RomeNumber.valueOf(NumberRoman.toUpperCase()).ordinal();
            return NumberArabic;
        } catch (Exception e){
            System.out.println("Блять, введи нормальное число, долбоеб");
            return 0;
        }
    }

    public static String ConvertArabicToRoman(int N){
        int NumberArabic = N;
        String NumberRoman = null;
        RomeNumber[] ArrayRomanNumber = RomeNumber.values();
        NumberRoman = ArrayRomanNumber[NumberArabic].name();

        return NumberRoman;
    }

    //Получает 2 цифры и оператор примера (+, -, *, /)
    //Возвращает готовый результат примера
    public static int MathCount (int FirstNumber, String Operator, int SecondNumber){
        int Result;

        switch (Operator){
            case "+": Result = FirstNumber + SecondNumber; break;
            case "-": Result = FirstNumber - SecondNumber; break;
            case "*": Result = FirstNumber * SecondNumber; break;
            case "/": Result = FirstNumber / SecondNumber; break;
            default: Result = -1;
                System.out.println("Ошибка. Неправильный оператор. \n " +
                        "Попробуйте использовать +, -, *, /");
        }
        return Result;
    }

    enum RomeNumber{
        O, I, II, III, IV, V, VI, VII, VIII, IX,
        X,XI, XII, XIII, XIV, XV, XVI, XVII, XVIII,XIX,
        XX, XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX,
        XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX,
        XL, XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX,
        L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX,
        LX, LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX,
        LXX, LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX,
        LXXX, LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX,
        XC, XCI, XCII, XCIII,XCIV, XCV, XCVI, XCVII, XCVIII, XCIX,
        C
    }
}
