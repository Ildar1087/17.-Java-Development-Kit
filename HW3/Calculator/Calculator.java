package HW3.Calculator;
/*1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.
2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа
по парно.
3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары. */

public class Calculator {

    static <T extends Number, V extends Number> double sum(T a, V b){  // Сложение
        return a.doubleValue() + b.doubleValue();
    }
    static <T extends Number, V extends Number> double multiply(T a, V b){  // Умножение
        return a.doubleValue() * b.doubleValue();
    }

    static <T extends Number, V extends Number> double subtract(T a, V b){  // Вычитание
        return a.doubleValue() - b.doubleValue();
    }

    static <T extends Number, V extends Number> double divide(T a, V b){ // Деление
        return a.doubleValue() / b.doubleValue();
    }


}
