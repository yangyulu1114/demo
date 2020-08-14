public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        int overlap = OverLapArea(A, B, C, D, E, F, G, H);
        return sum - overlap;
    }

    public int OverLapArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (E >= C || G <= A || F >= D || H <= B) {
            return 0;
        } else {
            return (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
    }
}
