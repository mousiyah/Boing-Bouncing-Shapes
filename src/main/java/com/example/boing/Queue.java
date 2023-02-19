package com.example.boing;
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author musslimaz
 *
 */


import java.util.NoSuchElementException;

public class Queue<E> {

	private int count;
	private QueueElement<E> front;
	private QueueElement<E> rear;
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		front = rear = null;
		count = 0;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		return front == null;
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public E peek () throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}

		return front.getElement();
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException();
		}

		E value = front.getElement();
		front = front.getNext();
		count--;

		if (front == null) {
			rear = null;
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (E element) {
		if (rear != null) {
			rear.setNext(new QueueElement<E>(element, null));
			rear = rear.getNext();
		} else {
			rear = new QueueElement<E>(element, null);
			front = rear;
		}
		count++;
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		if(!isEmpty()) {
			QueueElement<E> temp = front;
			System.out.println(temp.getElement());
			while (temp.getNext() != null) {
				System.out.println(temp.getNext().getElement());
				temp = temp.getNext();
			}
		}
	}
}
