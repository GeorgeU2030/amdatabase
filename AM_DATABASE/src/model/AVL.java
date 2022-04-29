package model;

import java.util.ArrayList;

import control.SearchController;

public class AVL<T extends Comparable<T>> {

	public static ArrayList<String>datas=new ArrayList<>();
	private static final int difference=1;
	private Node<T>root;
	
	public void insert(T data){
        if (data==null){
            System.out.println("null");
        }
         root= insert(data, this.root);
    }

    private Node<T> insert(T data,Node<T> t){
        if (t==null){
            return new Node<>(data,null,null);
        }
        int compareResult=data.compareTo(t.getData());
        if (compareResult<0){
            Node left=insert(data,t.getLeft());
            t.setLeft(left);
            
        }else if (compareResult>0){
        	Node right=insert(data,t.getRight());
        	t.setRight(right);
            
        }else {
            //Are the same, we do nothing
        }
        return balance(t);
    }
    private Node<T> balance(Node<T> t) {
        if (t==null){
            return null;
        }
        if (height(t.getLeft())-height(t.getRight())>difference){
            // 
            if (height(t.getLeft().getLeft())>=height(t.getLeft().getRight())){
              
                t=rotateRight(t);
            }else {
               
                t=doubleLeftAndRight(t);
            }

        }else if (height(t.getRight())-height(t.getLeft())>difference){
            
            if (height(t.getRight().getLeft())>height(t.getRight().getRight())){
               
                t=doubleRightAndLeft(t);
            }else {
                 
                t=rotateLeft(t);
            }
        }
        
        int depth=Math.max(height(t.getLeft()),height(t.getRight()))+1;
        t.setDepth(depth);
        return t;
    }
     private int height(Node<T> t){
        return t==null?-1:t.getDepth();
    }
     private Node<T>rotateRight(Node<T> node){
         Node<T> left=node.getLeft();
         node.setLeft(left.getRight());
         left.setRight(node);
         int depth=Math.max(height(node.getLeft()),height(node.getRight()))+1;
         node.setDepth(depth);
         depth=Math.max(height(node.getLeft()),node.getDepth())+1;
         left.setDepth(depth);
         return left;
     }
     private Node<T> rotateLeft(Node<T> node){
         Node<T> right=node.getRight();
         node.setRight(right.getLeft());
         right.setLeft(node);
         int depth=Math.max(height(node.getLeft()),height(node.getRight()))+1;
         node.setDepth(depth);
         depth=Math.max(node.getDepth(),height(right.getRight()))+1;
         right.setDepth(depth);
         return right;
     }
     private Node<T> doubleLeftAndRight(Node<T> node){
    	 
         node.setLeft(rotateLeft(node.getLeft()));
         return rotateRight(node);
     }
     private Node<T> doubleRightAndLeft(Node<T> node){
         node.setRight(rotateRight(node.getRight()));
         return rotateLeft(node);
     }
    
     public void search(T data) {
    	search(data,root);
     }
     private void search(T data,Node<T>t){
    	
    	 int compare = data.compareTo(t.getData());
    	 String datanode = (String) t.getData();
         String dataString = (String) data;
        /// System.out.println("root"+t.getData());
        // System.out.println(compare);
        // System.out.println("right"+t.getRight().getData());
        // System.out.println(compare);
         if(datanode.contains(dataString)) {
        	// System.out.println("here");
    		 SearchController.datesRange.add(datanode);
    		 datas.add(datanode);
    	 }
         if(compare>0&&t.getRight()!=null) {
        	
        	 if(t.getData().compareTo(data)>0) {
        		 search(data,t.getLeft());
        	 }else {
        		 search(data,t.getRight());
        	 }
        	 
        	 
         }
        if(compare>0&&t.getLeft()!=null) {
        	 search(data,t.getLeft());
         }
         
         if(compare<0&&t.getLeft()!=null) {
        	 if(t.getData().compareTo(data)<0) {
        		 search(data,t.getRight());
        	 }else {
        	 search(data,t.getLeft());
        	 }
        	
        	 
         }
         if(compare<0&&t.getRight()!=null){
        	 search(data,t.getRight());
         }
     }

     
             


     
}
