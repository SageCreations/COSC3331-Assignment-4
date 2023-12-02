// Link Class -----------------------------------------------------------------
class Link {
	public int iData;
	public Link next;

	public Link (int i) {
		iData = i;
	}

	public void displayLink() {
		System.out.print(iData + " ");
	}
}

// double-ended singly linked-list --------------------------------------------
class FirstLastList {
	private Link first;
	private Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertLast(int num) {
		Link newLink = new Link(num);
		if ( isEmpty() ) {
			first = newLink;
		} else {
			last = newLink;
		}
		
		last = newLink;
	}

	public int deleteFirst() {
		int temp = first.iData;
		
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		
		return temp;
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

// A queue based linked list using the FirstLastList class --------------------
class LinkQueue {
	// Why can I only read this in an ominous voice.	
	private FirstLastList theList;
									
	public LinkQueue() {
		theList = new FirstLastList();
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public void insert(int num) {
		theList.insertLast(num);
	}

	public int remove() { 
		return theList.deleteFirst();
	}

	public void displayQueue() {
		System.out.print("Queue (front-->rear): ");
		theList.displayList();
	}
}
