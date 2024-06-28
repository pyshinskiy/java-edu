/*
    Вариант программы для уровня, на котором ученик знаком со следующими темами:
    1 - переменные и типы данных
    2 - массивы
    3 - работа с консолью
    4 - if-else
    5 - switch
    6 - циклы
    7 - конкатенация строк
    8 - сравнение строк через equals
    9 - методы (объявление и вызов, тип возвращаемого значения, сигнатура метода)
    10 - классы
    11 - объекты
    12 - геттеры, сеттеры
    13 - this
    14 - конструктор
 */

public class Main {

    public static void main(String[] args) {
        FighterRegisterService fighterRegisterService = new FighterRegisterService();
        Fighter fighter1 = fighterRegisterService.registerFighter();
        Fighter fighter2 = fighterRegisterService.registerFighter();
        Arena arena = new Arena(fighter1, fighter2);
        arena.startFight();
    }
}
