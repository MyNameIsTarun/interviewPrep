package desing_pattern;

import java.io.Serializable;

/*
 * Creational design pattern
 * Ensures a class has only one instance per JVM and provides a global point of access to it.
 */
public class Singleton implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Singleton() {
		// prevents from reflection attack
		// attacker can break this by setting SingletonHelper.INSTANCE = null
		if(Singleton.getInstance() != null) {
			throw new IllegalStateException("An attemt is made to create second instance of the Singleton class.");
		}
	};
	
	/*
	 * A class is only loaded once per class loader
	 * that means the helper class will only get one chance for initializing the Singleton class
	 * as from the second time it will not be loaded (saving from multi threading) and the existing object will be used.
	 * 
	 * As this class is declared as static, it is safe from serializing as static data members are not serialized
	 * 
	 * it is loaded the same way other classes are loaded (i.e. at the time it's needed, in this case when getInstance() is called).
	 * 
	 * Initialization-on-demand holder idiom
	 */
	private static class SingletonHelper{
		public static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Singleton [name=" + name + "]";
	}
	
	@Override
	protected Singleton clone() {
		return getInstance();
	}
	
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	
	// saves from serialization
	protected Object readResolve() {
		return Singleton.getInstance();
	}
	
//	private static Class getClass(String classname) throws ClassNotFoundException {
//	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//	    if(classLoader == null) 
//	        classLoader = Singleton.class.getClassLoader();
//	    return (classLoader.loadClass(classname));
//	}
	
	
	/*
	 * used in java?
	 * => Logger object, db session object so that only one connection is made with the db, in spring default bean scope is singleton
	 * => Runnable is Singleton
	 *
	 */

}
