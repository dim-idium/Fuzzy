package ProcessingClases;


class membFunTriangle {  //Класс "фукция принадлежности - Треугольник"
    public float a, b, c, fuzzyOut, fuzzyInp;

    membFunTriangle(float a, float b,float c,float fuzzyInp) { //Метод - кусочно линейная функция принадлежности
        this.a = a;
        this.b = b;
        this.c = c;
        this.fuzzyInp = fuzzyInp;

        if (fuzzyInp >= b && fuzzyInp <= c) { //Ф-ия принадлежности
            fuzzyOut = 1 - ((fuzzyInp - b) / (c - b));
        }
        else if (fuzzyInp >= a && fuzzyInp < b) {
            fuzzyOut = ((fuzzyInp - a) / (b - a));
        } else {
            fuzzyOut = 0;
        }
        fuzzyOut = fuzzyOut;
    }
}