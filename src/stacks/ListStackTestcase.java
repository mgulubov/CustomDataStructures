package stacks;

import junit.framework.*;

public class ListStackTestcase extends AbstractStackTestCase {
	protected Stack createStack() {
		return new ListStack();
	}
}
