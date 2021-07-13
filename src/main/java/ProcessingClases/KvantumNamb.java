package ProcessingClases;

public class KvantumNamb {
    public int kn;
    public  KvantumNamb(float minIntputParam, float maxIntputParam, float k) {
        kn = (int) ((maxIntputParam - minIntputParam) / k); //расчет количества итераций квантования
    }
}
