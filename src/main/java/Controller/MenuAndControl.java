package Controller;

import ProcessingClases.*;

import java.util.Scanner;

class MenuAndControl {

    static Scanner scanner;

    static void Task1 (){

        //Задача 1. По значению входного управляемого значения, нечеткий алгритм возвращяет управляемое значение.

        System.out.print("Введите управляемое значение от 0 до 30 градусов = ");
        float InputParamVar = scanner.nextFloat(); // считываем входное управляемое значение
        System.out.print("Введите шаг интегрировния выходной фигуры при деффазификации, например, 1 или 0,1 = ");

        float h = scanner.nextFloat(); // считываем значение шага интегрирования

        IntegrationStep IntegrationStep01 = new IntegrationStep(0,280,h);
        float n = IntegrationStep01.n; //забераем шаг интегрирования из класса IntegrationStep

        Fuzzification fuzzyTempVolt = new Fuzzification(InputParamVar);
        float Ml = fuzzyTempVolt.Ml;//забераем результаты фазификации
        float Ma = fuzzyTempVolt.Ma;
        float Mh = fuzzyTempVolt.Mh;

        MinMax algorithmTempVolt = new MinMax(h, (int) n,Mh,Ma,Ml);
        float OutParam = algorithmTempVolt.OutParam; //Отправляем значение в алгоритм Минимакса вывода и получаем управляемое значение

        System.out.println("Значение управляющего параметра = " + OutParam +" Вотльт на тен");
        System.out.println("Задача выполнена выберете другой пункт меню");
    }

    static void Task2 (){
        //Задача 2. Метод выводит поверхность логического вывода. Некоторю фукцию
        // управления, при этом ф-ия не формализованна алгебраически, и ее профиль
        // определяется логическими правилами.
        System.out.print("Введите шаг интегрировния выходной фигуры при деффазификации, например, 1 или 0,1 = ");
        float h = scanner.nextFloat(); // считываем значение шага интегрирования

        IntegrationStep IntegrationStep01 = new IntegrationStep(0,280,h);
        float n = IntegrationStep01.n; //забераем шаг интегрирования из класса IntegrationStep

        System.out.print("Введите значение шага квантования диапазона входного параметра, например, 1 или 0,1 = ");
        float k = scanner.nextFloat();

        KvantumNamb KvantumNamb01 = new KvantumNamb(0,30,k);
        float kn = KvantumNamb01.kn;//забераем количество значений исходя их шага и диапозона


        Surface surface = new Surface((int) kn, h);
        System.out.print("Массив данных для построения поверхности нечеткого вывода");
        float [] ArrayOutParam = surface.ArrayOutParam;
        for (int i = 0; i < kn; i++) {
            System.out.println(ArrayOutParam[i]);

        }
        System.out.println("Задача выполнена выберете другой пункт меню");
    }

    public static void main (String [] args) { //Информация о приложении
        scanner = new Scanner(System.in);
        while (true) {//Меню приложения
            System.out.println("===============================================================================================");
            System.out.println("Меню");
            System.out.println("Введите 1 для фазификации входной переменной");
            System.out.println("Введите 2 для получения массива фазифицированных данных");
            System.out.println("Введите 0 для выхода из приложения ");
            System.out.println("");
            System.out.print("Введите номер пункта меню :");

            if (scanner.hasNextInt()) {

                int no = scanner.nextInt();

                switch (no) {

                    case 0:
                        System.out.println("Работа приложения завершена");
                        return;
                    case 1:
                        Task1();
                        break;
                    case 2:
                        Task2();
                        break;
                    default:
                        System.out.println("Такого номера для задания не предусмотрено. Пожалуйста повторите попытку");
                }
            } else {
                System.out.println("Вы ввели не корректные данные. Попробуйте еще");
                scanner.next();
            }
        }
    }
}
