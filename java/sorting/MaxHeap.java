package algorithms.sort;

public class MaxHeap {

	 int[] heap;
	 int size;
	 int maxSize;
	 
	 public MaxHeap(int maxSize) {
		 this.maxSize=maxSize;
		 size=0;
		 heap=new int[maxSize+1];
		 heap[0]=Integer.MAX_VALUE;
}
	 
	 private int parent(int pos) {
		 return pos/2;
	 }
	 
	 private int leftChild(int pos) {
		 return (2*pos);
	 }
	 
	 private int rightChild(int pos) {
		 return (2*pos)+1;
	 }
	 
	 private boolean isLeaf(int pos) {
		 if(pos>=(size/2) && pos<size) {
			 return true;
		 }
		 return false;
	 }
	 
	 private void swaps(int ipos,int fpos) {
		 int temp=heap[ipos];
		 heap[ipos]=heap[fpos];
		 heap[fpos]=temp;
	 }
	 
	 private  void maxHeapify(int pos) {
		 if(isLeaf(pos)) {
			 return ;
		 }
		 if(heap[pos]<heap[leftChild(pos)] || heap[pos]<rightChild(pos)) {
			 if(heap[pos]<heap[leftChild(pos)] ) {
				 swaps(pos,leftChild(pos));
				 maxHeapify(leftChild(pos));
			 }

			 else {
				 swaps(pos,rightChild(pos));
				 maxHeapify(rightChild(pos));
			 }
		 }
	 }
	 
	 public void insert (int element) {
		 heap[++size]=element;
		 int current =size;
		 while(heap[current]>heap[parent(current)]) {
			 swaps(current,parent(current));
			 current=parent(current);
		 }
	 }
	 
	 public int extractMax() {
		 int popped=heap[1];
		 heap[1]=heap[size--];
		 maxHeapify(1);
		 return popped;
	 }
	 
	 public void print() {
		 for(int i=1;i<=size/2;i++) {
			 System.out.print("Parent:"+heap[i]+"left child:"+heap[2*i]+"right child:"+heap[(2*i)+1]);
			 System.out.println();
		 }
	 }
	//In java their is no direct library for heap.We use priority queue to use min heap and for max heap
	 //we uses constructor with collection.reverseOrder()
	public static void main(String[] args) {
		System.out.println("Max heap is");
		MaxHeap maxheap=new MaxHeap(15);
		maxheap.insert(5);
		maxheap.insert(2);
		maxheap.insert(6);
		maxheap.insert(14);
		maxheap.insert(3);
		maxheap.insert(7);
		maxheap.insert(9);
		maxheap.insert(34);
		maxheap.insert(23);
		maxheap.insert(5);
		maxheap.insert(35);
		maxheap.insert(16);
		maxheap.insert(13);
		maxheap.insert(18);
		maxheap.insert(20);

		maxheap.print();
		System.out.println("Max value of heap is:"+maxheap.extractMax());
	}

}
