package ProcessingClases;

public class Surface {

    public  float [] ArrayOutParam;



    public Surface(int kn,  float h) {
        {
            ArrayOutParam = new float[kn];
        }

        for (int i = 0; i < kn; i++) {
            Fuzzification fuzzyTempVolt = new Fuzzification(i);
            IntegrationStep stepNamber = new IntegrationStep(0f, 280f, h);
            MinMax algorithmTempVolt = new MinMax(h, stepNamber.n, fuzzyTempVolt.Mh, fuzzyTempVolt.Ma, fuzzyTempVolt.Ml);
            ArrayOutParam [i] = algorithmTempVolt.OutParam;

        }
    }
}
