package ProcessingClases;

public class Fuzzification {

    public float InputParamVar ,Ml,Ma,Mh, fuzzyOut;
    public Fuzzification(float IntputParamVar) {
        this.InputParamVar = IntputParamVar;
        membFunTriangle temperLow = new membFunTriangle(0f, 0f, 15f, InputParamVar);//Экземпляр класса membFunTriangle - temperLow - терм "Температура низкая"
        Ml = temperLow.fuzzyOut;
        membFunTriangle temperSpecified = new membFunTriangle(0f, 15f, 30f, InputParamVar);//Экземпляр класса membFunTriangle - temperSpecified - терм "Температура заданная"
        Ma = temperSpecified.fuzzyOut;
        membFunTriangle temperHigh = new membFunTriangle(15f, 30f, 30f, InputParamVar);//Экземпляр класса membFunTriangle - temperSpecified - терм "Температура заданная"
        Mh = temperHigh.fuzzyOut;
    }

}
