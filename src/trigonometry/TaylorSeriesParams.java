package trigonometry;

public class TaylorSeriesParams {
    double factorial;
    double partialResult;
    double pow;
    double radians;

    public TaylorSeriesParams(double radians, double partialResult, double pow) {
        this.factorial = 1;
        this.partialResult = partialResult;
        this.pow = pow;
        this.radians = radians;
    }
}