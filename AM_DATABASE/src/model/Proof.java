package model;

public class Proof {

	public static void main(String[] args) {
		AVL<String>names = new AVL<>();
		names.insert("Lucas");
		names.insert("Rosa");
		names.insert("Sara");
		names.insert("Zacarias");
		names.insert("Lucia");
		names.insert("Salomon");
		names.insert("Sandra");
		names.insert("Luciana");
		names.search("San");
		
		System.out.println(AVL.datas.size());
        for(int i=0;i<AVL.datas.size();i++) {
        	System.out.println(AVL.datas.get(i));
        }
	}

}
