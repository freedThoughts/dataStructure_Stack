/*
package problemSet_1;

import singleLinkedList.ListNode;

public class StackLinkedListImpl<T> implements StackInterface<T>{
	
	ListNode<T> top = null;

	public void push(T t){
		ListNode<T> node = new ListNode<T>(t, null);
		if(top != null)
			top.setNext(node);
		top = node;
	}
	
	public T pop() throws Exception{
		if(top == null)
			throw new Exception("Stack is empty");
		ListNode<T> result = top;
		top = top.getNext();
		return result.getData();
	}
	
	public T top(){
		return top == null ? null : top.getData();
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void deleteStack(){
		top = null;
	}
	
	public static void main(String arg[]){
		
	}

}
*/
