package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> wrong = new BuggyAList<>();
        AListNoResizing<Integer> right = new AListNoResizing<>();
        int[] args = {1, 2, 3};
        for (int i = 0; i < 3; i++) {
            right.addLast(args[i]);
            wrong.addLast(args[i]);
        }
        for (int i = 0; i < 3; i++) {
            Object a = right.removeLast();
            Object b = wrong.removeLast();
            assertEquals(a, b);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> wrong = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                wrong.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
            } else if (operationNumber == 2) {
                if (correct.size() != 0) {
                    correct.getLast();
                    wrong.getLast();
                }
            } else {
                if (correct.size() != 0) {
                    correct.removeLast();
                    wrong.removeLast();
                }
            }
        }
    }
}
