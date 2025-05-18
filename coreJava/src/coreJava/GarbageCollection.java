package coreJava;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class GarbageCollection {

	public static void main(String[] args) throws InterruptedException {
		
		// ---------------------------------------------------------------------------------------------
		System.out.println("------------------------- Soft Reference ----------------------------");
		
		Weak weakObject = new Weak();
		Weak weakObjectForSoftRef = new Weak();
		
        weakObject.method(); // prints "From Weak Class"

        WeakReference<Weak> weakRefObj = new WeakReference<>(weakObject);
        SoftReference<Weak> softReference = new SoftReference<>(weakObjectForSoftRef);
        
        weakObject = null;
        weakObjectForSoftRef = null;
        
        for(int i=0; i<5; i++) {
			System.gc();
			Thread.sleep(1000);
        }
        
        if(weakRefObj.get() != null) {
        	System.out.print("WeakReference is not removed by GC: ");
        	weakRefObj.get().method();
        }
        else {
        	System.out.println("WeakReference is removed by GC.");
        }
        
        System.out.print("softReference still references weak object, after passing several GC cycles: ");
        softReference.get().method();

        // ---------------------------------------------------------------------------------------------
//        weakObject = new Weak();
//        ReferenceQueue<Weak> referenceQueue = new ReferenceQueue<>();
//        PhantomReference<Weak> phantomReference = new PhantomReference<>(weakObject,referenceQueue);
//        weakObject = null;
//        weakObject = phantomReference.get();
//        weakObject.method();
		
        // ---------------------------------------------------------------------------------------------
		WeakHashMap<WeakReference<Integer>, String> weakMap = new WeakHashMap<>();
		weakMap.put(new WeakReference<>(Integer.valueOf(1)), new String("hello"));
		weakMap.put(new WeakReference<>(Integer.valueOf(2)), new String("hi"));
		weakMap.put(new WeakReference<>(Integer.valueOf(3)), new String("how"));
		weakMap.put(new WeakReference<>(Integer.valueOf(4)), new String("are"));
		weakMap.put(new WeakReference<>(Integer.valueOf(5)), new String("you"));
		weakMap.put(new WeakReference<>(Integer.valueOf(6)), new String("?"));
		
		System.out.println("\n------------------------- Weak HashMap ----------------------------");
		int initialSize = weakMap.size();
		System.out.println("Initial size: " + initialSize);
		
		for(int i=1; i<=5; i++) {
			System.gc();
			Thread.sleep(1000);
			if(initialSize != weakMap.size()) {
				initialSize = weakMap.size();
				System.out.println("After " + i + " cycle, System.gc() size: " + initialSize);
			}
		}

	}
	
	// ===============================================================================================================
	/*
	 * => Soft References:
	 * 		- A soft reference tells the garbage collector that a referenced object can be collected at the collector’s discretion. 
	 * 			The object can stay in the memory for some time until the collector decides that he needs to collect it. That’ll happen, 
	 * 			especially when JVM is at risk of running out of memory. All soft references to objects reachable only by soft reference 
	 * 			should be cleared out before the OutOfMemoryError exception is thrown.
	 * 		- Use Case:
	 * 			Soft references can be used to make our code more resilient to errors connected to insufficient memory. 
	 * 			For example, we could create a memory-sensitive cache that automatically evicts objects when memory is scarce. 
	 * 			We wouldn’t need to manage the memory manually, as the garbage collector would do it for us.
	 * 		- SoftReference is like a customer that say: I’ll leave my table only when there are no other tables available. 
	 * 
	 * => Weak References:
	 * 		- Objects referenced only by weak references aren’t prevented from being collected. From the perspective of garbage collection, 
	 * 			they could not exist at all. If a weakly referenced object should be protected from being cleared, 
	 * 			it should also be referenced by some hard reference.
	 * 		- Use Case: 
	 * 			A great example is WeakHashMap, which works like normal HashMap, but its keys are weakly referenced, and they are automatically 
	 * 			removed when the referent is cleared.
	 * 			Using WeakHashMap, we can create a short-living cache that clears objects that are no longer used by other parts of the code. 
	 * 			If we used a normal HashMap, the mere existence of the key in the map would prohibit it from being cleared by the garbage collector.
	 * 		- A WeakReference is like someone ready to leave as soon as a new customer arrives.
	 * 
	 * => Phantom References: 
	 * 		- Similarly to weak references, phantom references don’t prohibit the garbage collector from enqueueing objects for being cleared. 
	 * 			The difference is phantom references must be manually polled from the reference queue before they can be finalized. 
	 * 			That means we can decide what we want to do before they are cleared.
	 * 		- Use Case:
	 * 			Phantom references are great if we need to implement some finalization logic, and they’re considerably more reliable and 
	 * 			flexible than the finalize method.
	 */

}

class Weak{
    public void method(){
        System.out.println("From Weak Class");
    }
}
