package problemSet_1;

public interface StackInterface<T> {
	
/*	We can not declare top as variable.
	Interface in java, do not allow to create any variable in Inerface.
	Only static Final and or constant variables are allowd in Interface.
	https://stackoverflow.com/questions/2430756/why-are-interface-variables-static-and-final-by-default
	
	*/

	public void push(T t);
	public T pop() throws Exception;
	public T top();
	public boolean isEmpty();
	public void deleteStack();
}
