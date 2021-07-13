package ProcessingClases;

public class IntegrationStep {
    public int n;
    float  minOutputParam, maxOutputParam, h;
    public IntegrationStep(float minOutputParam,float maxOutputParam,float h) {
        this.minOutputParam = minOutputParam; //конструктор класса
        this.maxOutputParam = maxOutputParam;
        this.h = h;
        n = (int) ((maxOutputParam - minOutputParam) / h); //расчет шага интегрирования
    }
}
