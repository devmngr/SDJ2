package utill;


public interface SetADT<T>{

	public void add(T element);
	public  T remove(T element);
	public boolean contains(T element);
	public boolean isEmpty();
	public int size();
	public boolean isSubset(SetADT<T> set);
	public SetADT<T> intersection(SetADT<T> set);
	public SetADT<T> union(SetADT<T> set);
	public IIterator<T> getIterator();
	
	
}
