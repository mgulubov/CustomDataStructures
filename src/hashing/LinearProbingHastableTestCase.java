package hashing;

import junit.framework.*;

public class LinearProbingHastableTestCase extends AbstractHashtableTestCase {
	protected Hashtable createHashtable(int size) {
		return new LinearProbingHashtable(size);
	}
}
