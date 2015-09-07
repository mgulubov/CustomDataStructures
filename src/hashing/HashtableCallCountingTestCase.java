package hashing;

import junit.framework.*;

public class HashtableCallCountingTestCase extends TestCase {
	private final static int TEST_SIZE = 1000;
	private final static int INITIAL_CAPACITY = 17;
	private int _counter;
	private Hashtable _hashtable;
	
	private final class Value {
		private final String _value;
		
		public Value() {
			this._value = String.valueOf(Math.abs(Math.random() * TEST_SIZE));
		}
		
		public int hashCode() {
			return this._value.hashCode();
		}
		
		public boolean equals(Object object) {
			++_counter;
			
			return object != null && this._value.equals(((Value)object)._value);
		}
	}
	
	private void reportCalls(String method) {
		System.out.println(getName() + "(" + method + "): " + this._counter + " calls");
	}
	
	private void runAdd() {
		this._counter = 0;
		
		for (int i = 0; i < TEST_SIZE; ++i) {
			this._hashtable.add(new Value());
		}
		
		reportCalls("add");
	}
	
	private void runContains() {
		this._counter = 0;
		
		for (int i = 0; i < TEST_SIZE; ++i) {
			this._hashtable.contains(new Value());
		}
		
		reportCalls("contains");
		System.out.println(getName() + "(size): " + this._hashtable.size() + " elements");
	}
	
	private void runAll() {
		runAdd();
		runContains();
	}
	
	public void testBucketsLoadFactor100Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 1.0f);
		runAll();
	}
	
	public void testBucketsLoadFactor75Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.75f);
		runAll();
	}
	
	public void testBucketsLoadFactor50Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.5f);
		runAll();
	}
	
	public void testBucketsLoadFactor25Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.25f);
		runAll();
	}
	
	public void testBucketsLoadFactor150Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 1.5f);
		runAll();
	}
	
	public void testBucketsLoadFactor200Percent() {
		this._hashtable = new BucketingHashtable(INITIAL_CAPACITY, 2.0f);
		runAll();
	}
}
