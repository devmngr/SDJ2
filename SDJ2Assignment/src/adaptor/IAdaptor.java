package adaptor;

import storage.IIterator;




public interface IAdaptor <T> {
	public void add(T element)throws IllegalArgumentException;
	public T remove(T element)throws IllegalArgumentException;
	public boolean contains(T element);
	
	//following 2 methods should be implemented for every tipe of data
	public int size();
	public IIterator<T> getIterator();
}
