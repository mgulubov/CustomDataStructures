package hashing;

import junit.framework.*;

public class BucketingHashtableTestCase extends AbstractHashtableTestCase {
	protected Hashtable createHashtable(int capacity) {
		return new BucketingHashtable(capacity, 0.75f);
	}
}
