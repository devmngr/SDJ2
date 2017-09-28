package storage;

public interface IIterator<T> {

	public boolean hasNext();

	public T next();

}
