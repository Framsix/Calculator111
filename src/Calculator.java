import java.util.Scanner;

public  class Calculator{
    public static void main(String[] args) {
        //Метод сканнер a.k.a ввод от пользователя
        Scanner s = new Scanner(System.in);
        System.out.print("Введите математический пример '5 + 5 or IV * V':");
        String s1 = s.nextLine();
        Main result = new Main();
        String answer = result.Calc(s1);
        System.out.println(answer);

    }
}


class Main {



    public static String Calc(String input){
        //Объявление переменных
        int sum = 0;            //Переменная для нахождения суммы
        int check = 0;          //Переменная служащая временным хранилищем для проверки выражений
        int proverka = 0;       //Переменная счетчик в числовом формате, для хранение информации о том какое выражение Арабское, Римское или ошибочное
        String sumString;       //Переменная хранящая результат выражения с Римскими цифрами
        int checker1 = 0;       //Переменная служащая временным хранилищем для проверки правильности выражения, то есть по ограничениям цифр до десяти
        int index = 0;          //Переменная хранящая информацию о том в какой ячейки массива будут производиться какие-либо действия
        int firstOperand = 0;   //Переменная с первым операндом
        int secondOperand = 0;  //Переменная со вторым операндом
        String minus = "";          //Переменная для проверки отрицательных Римских

        String[] inputSplit = input.split(" ");
        if (inputSplit.length != 3){
            return "throws Exception";
        }
        String operand1 = inputSplit[0];
        String operand2 = inputSplit[2];
        String operation = inputSplit[1];
//Первое число проверка
        ConvertToRomanNumerals convert = new ConvertToRomanNumerals();
        convert.romanNumber = operand1;
        check = convert.convertToRN();                                      //Делаем проверку на Арабские числа
        if (check == 1000){
            Checker checker = new Checker();
            checker.numbercheck = operand1;
            checker1 = checker.numcheck();
            if (checker1 == 10000){                                         //Условие для ограничения ввода символов
                System.out.println("Формат ввода чисел неверен!");
                return "throws Exception";
            }
            proverka++;
            firstOperand = Integer.parseInt(operand1);                     // Преобразует текстовый операнд в числовой операнд для дальнейших вычислений
        }
        else firstOperand = check;
//Второе число проверка
        ConvertToRomanNumerals convert2 = new ConvertToRomanNumerals();
        convert2.romanNumber = operand2;
        check = convert2.convertToRN();                                      //Делаем проверку на Арабские числа
        if (check == 1000){
            Checker checker = new Checker();
            checker.numbercheck = operand2;
            checker1 = checker.numcheck();
            if (checker1 == 10000){                                         //Условие для ограничения ввода символов
                System.out.println("Формат ввода чисел неверен!");
                return "throws Exception";
            }
            proverka++;
            secondOperand = Integer.parseInt(operand2);                     // Преобразует текстовый операнд в числовой операнд для дальнейших вычислений
        }
        else secondOperand = check;


        switch (operation){                                                         // Узнаем знак для операции
            case "*" : sum = firstOperand * secondOperand; break;
            case "+" : sum = firstOperand + secondOperand; break;
            case "-" : sum = firstOperand - secondOperand; break;
            case "/" : sum = firstOperand / secondOperand; break;
            default: System.out.println("Ошибка! Математический пример не распознан.");
            return "throws Exception";

            }
        if(proverka == 0){                                                              // Преобразуем результат в римские цифры
            sumString = Integer.toString(sum);
            minus = sumString;
            ConvertToArabicNumerals sum1 = new ConvertToArabicNumerals();
            sum1.arabicNumber = sumString;
            sumString = sum1.convertToAN();
            if (minus == sumString){                                                    // Проверка на отрацательный результат в римских
                System.out.println("Отрицательный результат отсутсвует в Римской системе счисления.");
                return "throws Exception";
            }
            else {
                return String.valueOf(sumString);
            }
        }
        else if (proverka == 1){
            System.out.println("Ошибка! Одна из цифр имеет другой формат.");
            return "throws Exception";
        }
        else {
            return String.valueOf(sum);
        }

    }
}
class ConvertToRomanNumerals{   //Для перевода чисел с Римской в Арабскую
    String romanNumber;
    int convertToRN(){
        int arabicNum;
        switch(romanNumber){
            case "I": arabicNum = 1; return arabicNum;
            case "II": arabicNum = 2; return arabicNum;
            case "III": arabicNum = 3; return arabicNum;
            case "IV": arabicNum = 4; return arabicNum;
            case "V": arabicNum = 5; return arabicNum;
            case "VI": arabicNum = 6; return arabicNum;
            case "VII": arabicNum = 7; return arabicNum;
            case "VIII": arabicNum = 8; return arabicNum;
            case "IX": arabicNum = 9; return arabicNum;
            case "X": arabicNum = 10; return arabicNum;
            default:  return 1000;
        }
    }
}

class Checker{          //Проверка на правильнный ввод чисел
    String numbercheck;
    int numcheck(){
        int arabicNum;
        switch(numbercheck){
            case "1": arabicNum = 1; return arabicNum;
            case "2": arabicNum = 2; return arabicNum;
            case "3": arabicNum = 3; return arabicNum;
            case "4": arabicNum = 4; return arabicNum;
            case "5": arabicNum = 5; return arabicNum;
            case "6": arabicNum = 6; return arabicNum;
            case "7": arabicNum = 7; return arabicNum;
            case "8": arabicNum = 8; return arabicNum;
            case "9": arabicNum = 9; return arabicNum;
            case "10": arabicNum = 10; return arabicNum;
            default:  return 10000;
        }
    }
}

class ConvertToArabicNumerals{      //Перевод результата в Римскую систему
    String arabicNumber;
    String convertToAN(){
        String rn;
        switch (arabicNumber){
            case "1" : rn = "I"; return rn;
            case "2" : rn = "II"; return rn;
            case "3" : rn = "III"; return rn;
            case "4" : rn = "IV"; return rn;
            case "5" : rn = "V"; return rn;
            case "6" : rn = "VI"; return rn;
            case "7" : rn = "VII"; return rn;
            case "8" : rn = "VIII"; return rn;
            case "9" : rn = "IX"; return rn;
            case "10" : rn = "X"; return rn;
            case "11" : rn = "XI"; return rn;
            case "12" : rn = "XII"; return rn;
            case "13" : rn = "XIII"; return rn;
            case "14" : rn = "XIV"; return rn;
            case "15" : rn = "XV"; return rn;
            case "16" : rn = "XVI"; return rn;
            case "17" : rn = "XVII"; return rn;
            case "18" : rn = "XVIII"; return rn;
            case "19" : rn = "XIV"; return rn;
            case "20" : rn = "XX"; return rn;
            case "21" : rn = "XXI"; return rn;
            case "22" : rn = "XXII"; return rn;
            case "23" : rn = "XXIII"; return rn;
            case "24" : rn = "XXIV"; return rn;
            case "25" : rn = "XXV"; return rn;
            case "26" : rn = "XXVI"; return rn;
            case "27" : rn = "XXVII"; return rn;
            case "28" : rn = "XXVIII"; return rn;
            case "29" : rn = "XXIX"; return rn;
            case "30" : rn = "XXX"; return rn;
            case "31" : rn = "XXXI"; return rn;
            case "32" : rn = "XXXII"; return rn;
            case "33" : rn = "XXXIII"; return rn;
            case "34" : rn = "XXXIV"; return rn;
            case "35" : rn = "XXXV"; return rn;
            case "36" : rn = "XXXVI"; return rn;
            case "37" : rn = "XXXVII"; return rn;
            case "38" : rn = "XXXVIII"; return rn;
            case "39" : rn = "XXXIX"; return rn;
            case "40" : rn = "XL"; return rn;
            case "41" : rn = "XLI"; return rn;
            case "42" : rn = "XLII"; return rn;
            case "43" : rn = "XLIII"; return rn;
            case "44" : rn = "XLIV"; return rn;
            case "45" : rn = "XLV"; return rn;
            case "46" : rn = "XLVI"; return rn;
            case "47" : rn = "XLVII"; return rn;
            case "48" : rn = "XLVIII"; return rn;
            case "49" : rn = "XLIX"; return rn;
            case "50" : rn = "L"; return rn;
            case "51" : rn = "LI"; return rn;
            case "52" : rn = "LII"; return rn;
            case "53" : rn = "LIII"; return rn;
            case "54" : rn = "LIV"; return rn;
            case "55" : rn = "LV"; return rn;
            case "56" : rn = "LVI"; return rn;
            case "57" : rn = "LVII"; return rn;
            case "58" : rn = "LVIII"; return rn;
            case "59" : rn = "LVIX"; return rn;
            case "60" : rn = "LX"; return rn;
            case "61" : rn = "LXI"; return rn;
            case "62" : rn = "LXII"; return rn;
            case "63" : rn = "LXIII"; return rn;
            case "64" : rn = "LXIV"; return rn;
            case "65" : rn = "LXV"; return rn;
            case "66" : rn = "LXVI"; return rn;
            case "67" : rn = "LXVII"; return rn;
            case "68" : rn = "LXVIII"; return rn;
            case "69" : rn = "LXIX"; return rn;
            case "70" : rn = "LXX"; return rn;
            case "71" : rn = "LXXI"; return rn;
            case "72" : rn = "LXXII"; return rn;
            case "73" : rn = "LXXIII"; return rn;
            case "74" : rn = "LXXIV"; return rn;
            case "75" : rn = "LXXV"; return rn;
            case "76" : rn = "LXXVI"; return rn;
            case "77" : rn = "LXXVII"; return rn;
            case "78" : rn = "LXXVIII"; return rn;
            case "79" : rn = "LXXIX"; return rn;
            case "80" : rn = "LXXX"; return rn;
            case "81" : rn = "LXXXI"; return rn;
            case "82" : rn = "LXXXII"; return rn;
            case "83" : rn = "LXXXIII"; return rn;
            case "84" : rn = "LXXXIV"; return rn;
            case "85" : rn = "LXXXV"; return rn;
            case "86" : rn = "LXXXVI"; return rn;
            case "87" : rn = "LXXXVII"; return rn;
            case "88" : rn = "LXXXVII"; return rn;
            case "89" : rn = "LXXXIX"; return rn;
            case "90" : rn = "XC"; return rn;
            case "91" : rn = "XCI"; return rn;
            case "92" : rn = "XCII"; return rn;
            case "93" : rn = "XCIII"; return rn;
            case "94" : rn = "XCIV"; return rn;
            case "95" : rn = "XCV"; return rn;
            case "96" : rn = "XCVI"; return rn;
            case "97" : rn = "XCVII"; return rn;
            case "98" : rn = "XCVIII"; return rn;
            case "99" : rn = "XCIX"; return rn;
            case "100" : rn = "C"; return rn;
            default: rn = arabicNumber; return rn;

        }
    }
}
