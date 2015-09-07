package hashing;

import lists.List;
import lists.LinkedList;
import iteration.Iterator;

public class BucketingHashtable implements Hashtable {
	private List[] _buckets;
	private int _size;
	private final float _loadFactor;
	
	public BucketingHashtable() {
		this(1000, 0.75f);
	}
	
	public BucketingHashtable(int capacity) {
		this(capacity, 0.75f);
	}
	
	public BucketingHashtable(int capacity, float loadFactor) {
		assert capacity > 0 : "capacity can't be <= 0";
		assert loadFactor > 0 : "loadFactor can't be <= 0";
		
		this._buckets = new List[capacity];
		this._loadFactor = loadFactor;
		this._size = 0;
	}
	
	private void maintainLoad() {
		if (loadFactorExceeded()) {
			resize();
		}
	}
	
	private boolean loadFactorExceeded() {
		return size() > this._buckets.length * this._loadFactor;
	}
	
	private void resize() {
		BucketingHashtable tmp = new BucketingHashtable(this._buckets.length * 2);
		
		for (int i = 0; i < this._buckets.length; i++) {
			if (this._buckets[i] != null) {
				tmp.addAll(this._buckets[i].iterator());
			}
		}
		
		this._buckets = tmp._buckets;
	}
	
	private void addAll(Iterator iterator) {
		assert iterator != null : "iterator can't be null";
		
		for (iterator.first(); !iterator.isDone(); iterator.next()) {
			add(iterator.current());
		}
	}
	
	private int bucketIndexFor(Object value) {
		assert value != null : "value can't be null";
		
		return Math.abs(value.hashCode() % this._buckets.length);
	}
	
	private List bucketFor(Object value) {
		int bucketIndex = bucketIndexFor(value);
		List bucket = this._buckets[bucketIndex];
		
		if (bucket == null) {
			bucket = new LinkedList();
			this._buckets[bucketIndex] = bucket;
			assert this._buckets[bucketIndex] != null : "bucket can't be null";
		}
		
		return bucket;
	}
	
	public void add(Object value) {
		List bucket = bucketFor(value);
		
		if (!bucket.contains(value)) {
			bucket.add(value);
			this._size++;
			maintainLoad();
		};
	}
	
	public boolean contains(Object value) {
		List bucket = bucketFor(value);
		
		return bucket != null && bucket.contains(value);
	}
	
	public int size() {
		return this._size;
	}
}