import java.util.function.Function;

public class AlternatingAddSubtract {

    // Method to start the curried chain
    public static Function<Integer, FunctionChain> add_subtract(int first) {
        return new FunctionChain(first, true)::next;
    }

    // Inner class to maintain state across chained calls
    static class FunctionChain {
        private int total;      // Running total
        private boolean addNext; // Flag for next operation (+/-)

        public FunctionChain(int first, boolean addNext) {
            this.total = first;
            this.addNext = addNext;
        }

        // Method to handle the next number in the chain
        public Function<Integer, FunctionChain> next(int num) {
            if (addNext) {
                total += num; // Add if flag is true
            } else {
                total -= num; // Subtract if flag is false
            }
            addNext = !addNext; // Flip the flag
            return this::next;  // Return itself for further chaining
        }

        // Method to get the final result
        public int getResult() {
            return total;
        }
    }

    
