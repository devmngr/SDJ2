package adaptor;

import java.util.Iterator;

import storage.*;

public class Adaptor<T> implements IAdaptor<T> {

	private SetADT<T> storage;

	public Adaptor() {
		storage = new LinkedSet<T>();
	}

	@Override
	public void add(T element) {
		storage.add(element);

	}

	@Override
	public T remove(T element) {

		return storage.remove(element);
	}

	@Override
	public boolean contains(T element) {

		return storage.contains(element);
	}

	@Override
	public IIterator<T> getIterator() {
		return storage.getIterator();
	}

	@Override
	public int size() {
		return storage.size();
	}

	public String toString() {
		String str = "";
		for (IIterator<String> it = (IIterator<String>) storage.getIterator(); it.hasNext(); it.next()) {
			str += it.toString();
		}
		return str;
	}

}
