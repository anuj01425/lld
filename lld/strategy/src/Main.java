import context.Context;
import strategy.FedralTax;


/**
 *strategy pattern is behaviour pattern which means it deals with algorithm and responsibility of object
 * Client can pass the strategy at the run time. Other places it can be used is
 *  1. Type of covid treatment receive by patient
 *  2. Sorting to be done decided by client
 *  3. Cache eviction strategy
 *
 */
public class Main {



    public static void main(String[] args) {

        Context context = new Context(new FedralTax());
        System.out.println(context.calculateTax(100));

    }
}