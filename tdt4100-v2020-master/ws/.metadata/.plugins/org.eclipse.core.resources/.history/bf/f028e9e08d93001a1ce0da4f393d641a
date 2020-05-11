package stuff;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringBooleanMetaIterator implements Iterator<String> {

	// TODO: necessary field declarations

	public StringBooleanMetaIterator(final Iterator<String> strings, final Iterator<Boolean> booleans) {
		// TODO: necessary initialisation
	}

	// TODO: necessary methods

	public static void main(final String[] args) {
		final Collection<String> strings = Arrays.asList("meta-iteratorer", "er", "ikke", "kult");
		final Collection<Boolean> booleans = Arrays.asList(true, true, false, true);

		// skal skrive ut
		// meta-iteratorer er kult
		final StringBooleanMetaIterator metaIterator = new StringBooleanMetaIterator(strings.iterator(), booleans.iterator());
		while (metaIterator.hasNext()) {
			System.out.print(metaIterator.next());
			System.out.print(" ");
		}
	}
}
