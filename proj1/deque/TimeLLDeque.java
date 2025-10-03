package deque;



import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeLLDeque {
    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
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
        timeAddLast();
    }

    public static void timeAddLast() {
        // TODO: YOUR CODE HERE
        ArrayDeque<Integer> Ns=new ArrayDeque<>();
        ArrayDeque<Double> times=new ArrayDeque<>();
        ArrayDeque<Integer> opCounts=new ArrayDeque<>();

        for (int N=1000;N<=128000;N*=2){
            LinkedListDeque<Integer> slisttest= new LinkedListDeque<>();
            opCounts.addLast(10000);
            Stopwatch sw = new Stopwatch();
            for (int i=0;i<N;i++){
                slisttest.addLast(1);
            }
            Ns.addLast(N);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);

    }

}
