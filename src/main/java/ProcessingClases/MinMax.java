package ProcessingClases;

public class MinMax {

    private float Mlu, Mau, Mhu;
    private float  integral = 0, integralOutParam = 0;
    private float OutputParamVar = 0,h, Mh,Ma,Ml;
    public float OutParam;
    private int n;
    public MinMax(float h,int n,float Mh,float Ma,float Ml) {
        this.h = h;
        this.n = n;
        this.Mh = Mh;
        this.Ma = Ma;
        this.Ml = Ml;
        for (int i = 0; i < n; i++) {
            membFunTriangle voltageLow = new membFunTriangle(0f, 0f, 80f, OutputParamVar);//Экземпляр класса - voltageLow - терм "Напряжение низкое"
            Mlu = voltageLow.fuzzyOut;
            membFunTriangle voltageAverage = new membFunTriangle(20f, 140f, 260f, OutputParamVar);
            Mau = voltageAverage.fuzzyOut;
            membFunTriangle voltageHigh = new membFunTriangle(140f, 280f, 280f, OutputParamVar);
            Mhu = voltageHigh.fuzzyOut;
            // Нечеткие логические правила
            float Mak1 = Math.min(Mlu, Ml); //если Mh, то  Mlu
            float Mak2 = Math.min(Mau, Ma); //если Ma, то Mau
            float Mak3 = Math.min(Mhu, Mh); // если Ml, то Mhu
            float Makk = Mak1;
            if (Mak1 < Mak2) {
                if (Mak2 > Mak3) {
                    Makk = Mak2;
                } else {
                    Makk = Mak3;
                }
            }
            integral = integral + Makk;
            float MakkOutParam = OutputParamVar * Makk;
            integralOutParam = integralOutParam + MakkOutParam;
            OutputParamVar = OutputParamVar + h;
        }
        OutParam  = integralOutParam /integral;
    }
}
