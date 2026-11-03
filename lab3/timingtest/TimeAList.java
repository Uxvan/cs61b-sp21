package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.lang.reflect.Array;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList Ns = new AList(), times = new AList(), opCounts = new AList();
        for (int k = 0; k < 8; k++){
            int N = 1000 << k;
            AList test = new AList();
            Ns.addLast(N);
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < N; i++) {
                test.addLast(1);
            }
            double time = sw.elapsedTime();
            times.addLast(time);
            opCounts.addLast(N);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
