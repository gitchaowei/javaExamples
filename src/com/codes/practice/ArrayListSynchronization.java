package com.codes.practice;

import java.util.*;
import java.util.concurrent.*;
// 1.Synchronized Collections
// 1.1 Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList());
//    syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
// 1.2 List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());  // similar to 2. above
// 1.3 Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
// 1.4 Map<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
// 1.5 Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
// 1.6 SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());
//
// 2. Concurrent Collections
// 2.1 ConcurrentHashMap, implement ConcurrentMap interface, a concurrent alternative to Hashtable or Synchronized Map classes
//     Iterator of ConcurrentHashMap are fail-safe iterators that don't throw ConcurrencModificationException
//     thus eliminates another requirement of locking during iteration which results in further scalability and performance
//
// 2.2 ConcurrentSkipListMap and ConcurrentSkipListSet
//     Just like ConcurrentHashMap provides a concurrent alternative of synchronized HashMap.
//     ConcurrentSkipListMap and ConcurrentSkipListSet provide concurrent alternative for synchronized version of SortedMap and SortedSet.
//
//     ConcurrentSkipListMap, implement ConcurrentNavigableMap (subinterface of ConcurrentMap)
//
// 2.3 CopyOnWriteArrayList and CopyOnWriteArraySet  (Classes)
//     Since CopyOnWriteArrayList Iterator also doesn't throw ConcurrencModificationException,
//     it eliminates the need to lock the collection during iteration.
//     * CopyOnWriteArrayList is a concurrent alternative of synchronized List.
//     * CopyOnWriteArrayList provides better concurrency than synchronized List by allowing multiple concurrent readers and
//       replacing the whole list on write operation
//     * CopyOnWriteArraySet is a concurrent replacement to Synchronized Set
//
//  Remember both ConcurrentHashMap and CopyOnWriteArrayList doesn't provide the same level of locking as Synchronized Collection and
//  achieves thread-safety by their locking and mutability strategy. So they perform better if requirements suit their nature
//
// 2.4 BlockingQueue (interface, thread-safe)
//     public interface BlockingQueue<E> extends Queue<E>
//
//     Several BlockingQueue implementations such as LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, SynchronousQueue, etc.
//     Java BlockingQueue interface implementations are thread-safe.
//     All methods of BlockingQueue are atomic in nature and use internal locks or other forms of concurrency control.
//     Java 5 comes with BlockingQueue implementations in the java.util.concurrent package.
//
// 2.5 BlockingDeque (interface, thread-safe)
//     public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E>
//     * Deque (interface, not thread-safe)
//     * Deque implementation like ArrayDeque class (not thread-safe) and LinkedBlockingDeque class (thread-safe)
//     * Like any BlockingQueue, BlockingDeque is thread-safe, does not permit null elements, and may (or may not) be capacity-constrained.
//

public class ArrayListSynchronization {
    public static void main(String[] args) throws InterruptedException{
        SynchronizedList();
        CopyOnWriteArrayList();
        LinkedBlockingQueueExample();
        ArrayBlockingQueueExample();
    }

    public static void SynchronizedList(){
        List<String> syncal = Collections.synchronizedList(new ArrayList<String>());

        //Adding elements to synchronized ArrayList
        syncal.add("Pen");
        syncal.add("NoteBook");
        syncal.add("Ink");

        System.out.println("Iterating synchronizedList:");
        synchronized(syncal) {
            Iterator<String> iterator = syncal.iterator();
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }
    }

    public static void CopyOnWriteArrayList(){
        CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();

        //Adding elements to synchronized ArrayList
        al.add("Pen");
        al.add("NoteBook");
        al.add("Ink");

        System.out.println("Displaying CopyOnWriteArrayList Elements:");
        //Synchronized block is not required in this method
        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }


    // 1. unbounded queues:
    // The most important thing when designing a producer-consumer program using unbounded BlockingQueue is that
    // consumers should be able to consume messages as quickly as producers are adding messages to the queue.
    // Otherwise, the memory could fill up and we would get an OutOfMemory exception.
    //
    //BlockingQueue<String> blockingQueueUnbounded = new LinkedBlockingDeque<>();
    // 2. bounded queue
    // BlockingQueue<String> blockingQueueBounded = new LinkedBlockingDeque<>(10);
    //
    // Multithreaded Producer-Consumer Example:
    // Use 4 producer threads and a number of consumers threads will be equal to the number of available processors.
    // poisonPill message to be an Integer.MAX_VALUE because such value will never be sent by our producer under normal working conditions
    public static void LinkedBlockingQueueExample() {
        int BOUND = 10;
        int N_PRODUCERS = 4;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();

    }

    public static void ArrayBlockingQueueExample() throws InterruptedException
    {
        // example 1:
        // define capacity of ArrayBlockingQueue
        int capacity = 5;

        // create object of ArrayBlockingQueue
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(capacity);

        // Add elements to ArrayBlockingQueue using put method
        queue.put("StarWars");
        queue.put("SuperMan");
        queue.put("Flash");
        queue.put("BatMan");
        queue.put("Avengers");

        // print Queue
        System.out.println("queue contains " + queue);

        // remove some elements
        queue.remove();
        queue.remove();

        // Add elements to ArrayBlockingQueue using put method
        queue.put("CaptainAmerica");
        queue.put("Thor");

        System.out.println("queue contains " + queue);
        // example 2:
        // Instantiate an object of LinkedBlockingDeque
        // named lbdq
        BlockingQueue<Integer> lbdq
                = new LinkedBlockingDeque<Integer>();

        // Add elements using add()
        lbdq.add(75);
        lbdq.add(86);
        lbdq.add(13);
        lbdq.add(44);
        lbdq.add(10);

        // Print the elements of lbdq on the console
        System.out.println(
                "The LinkedBlockingDeque, lbdq contains:");
        System.out.println(lbdq);

        // Remove elements using remove();
        lbdq.remove(86);
        lbdq.remove(44);

        // Trying to remove an element
        // that doesn't exist
        // in the LinkedBlockingDeque
        lbdq.remove(1);

        // Print the elements of lbdq on the console
        System.out.println(
                "\nThe LinkedBlockingDeque, lbdq contains:");
        System.out.println(lbdq);
        // Create an iterator to traverse lbdq
        Iterator<Integer> lbdqIter = lbdq.iterator();

        // Print the elements of lbdq on to the console
        System.out.println("The LinkedBlockingDeque, lbdq contains:");

        for(int i = 0; i<lbdq.size(); i++)
        {
            System.out.print(lbdqIter.next() + " ");
        }
    }

    // Deque interface is implemented by LinkedList and ArrayDeque classes
    public static void DequeExamples () {
            Deque<String> deque = new LinkedList<String>();

            // Add at the last
            deque.add("Element 1 (Tail)");

            // Add at the first
            deque.addFirst("Element 2 (Head)");

            // Add at the last
            deque.addLast("Element 3 (Tail)");

            // Add at the first
            deque.push("Element 4 (Head)");

            // Add at the last
            deque.offer("Element 5 (Tail)");

            // Add at the first
            deque.offerFirst("Element 6 (Head)");

            System.out.println(deque + "\n");

            // We can remove the first element
            // or the last element.
            deque.removeFirst();
            deque.removeLast();
            System.out.println("Deque after removing "
                    + "first and last: "
                    + deque);
        // The ArrayDeque class implements these two interfaces:
        //
        //a) Queue Interface: It is an Interface that is a FirstIn – FirstOut Data Structure where the elements are added from the back.
        //b) Deque Interface: It is a Doubly Ended Queue in which you can insert the elements from both sides.
        //                 It is an interface that implements the Queue.
        // ArrayDeque is not thread-safe
        //
        // ArrayDeque class is a resizable-array for adding or removing an element from both sides of the queue.
        // ArrayDeque has no capacity restrictions and they grow as necessary to support usage.
        // ArrayDeque does not support concurrent access by multiple threads.
        // ArrayDeque class is likely to be faster than Stack when used as a stack.
        // ArrayDeque class is likely to be faster than LinkedList when used as a queue.
        // ArrayDeque example 1:
        // Creating and initializing deque
        // Declaring object of integer type
        Deque<Integer> de_que = new ArrayDeque<Integer>(10);

        // Operations 1
        // add() method

        // Adding custom elements
        // using add() method to insert
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);

        // Iterating using for each loop
        for (Integer element : de_que) {
            // Print the corresponding element
            System.out.println("Element : " + element);
        }

        // Operation 2
        // clear() method
        System.out.println("Using clear() ");

        // Clearing all elements using clear() method
        de_que.clear();

        // Operations 3
        // addFirst() method

        // Inserting at the start
        de_que.addFirst(564);
        de_que.addFirst(291);

        // Operation 4
        // addLast() method
        // Inserting at end
        de_que.addLast(24);
        de_que.addLast(14);

        // Display message
        System.out.println(
                "Above elements are removed now");

        // Iterators

        // Display message
        System.out.println(
                "Elements of deque using Iterator :");

        for (Iterator itr = de_que.iterator();
             itr.hasNext();) {
            System.out.println(itr.next());
        }

        // descendingIterator()
        // To reverse the deque order
        System.out.println(
                "Elements of deque in reverse order :");

        for (Iterator dItr = de_que.descendingIterator();
             dItr.hasNext();) {
            System.out.println(dItr.next());
        }

        // Operation 5
        // element() method : to get Head element
        System.out.println(
                "\nHead Element using element(): "
                        + de_que.element());

        // Operation 6
        // getFirst() method : to get Head element
        System.out.println("Head Element using getFirst(): "
                + de_que.getFirst());

        // Operation 7
        // getLast() method : to get last element
        System.out.println("Last Element using getLast(): "
                + de_que.getLast());

        // Operation 8
        // toArray() method :
        Object[] arr = de_que.toArray();
        System.out.println("\nArray Size : " + arr.length);

        System.out.print("Array elements : ");

        for (int i = 0; i < arr.length; i++)
            System.out.print(" " + arr[i]);

        // Operation 9
        // peek() method : to get head
        System.out.println("\nHead element : "
                + de_que.peek());

        // Operation 10
        // poll() method : to get head
        System.out.println("Head element poll : "
                + de_que.poll());

        // Operation 11
        // push() method
        de_que.push(265);
        de_que.push(984);
        de_que.push(2365);

        // Operation 12
        // remove() method : to get head
        System.out.println("Head element remove : "
                + de_que.remove());

        System.out.println("The final array is: " + de_que);
    }


}


//
// add() – returns true if insertion was successful, otherwise throws an IllegalStateException
//put() – inserts the specified element into a queue, waiting for a free slot if necessary
//offer() – returns true if insertion was successful, otherwise false
//offer(E e, long timeout, TimeUnit unit) – tries to insert element into a queue and waits for an available slot within a specified timeout
//take() – waits for a head element of a queue and removes it. If the queue is empty, it blocks and waits for an element to become available
//poll(long timeout, TimeUnit unit) – retrieves and removes the head of the queue, waiting up to the specified wait time if necessary for an element to become available. Returns null after a timeout
class NumbersProducer implements Runnable {
    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {
            numbersQueue.put(poisonPill);
        }
    }
}
class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " result: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
