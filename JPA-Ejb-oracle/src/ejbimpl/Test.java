package ejbimpl;

import java.util.ArrayList;
import java.util.List;

import ejb.ActorEjb;
import entity.Actor;
import exception.DataBaseException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> lista = new ArrayList();
		lista.add("aaaa");
		lista.add("bbbb");
		lista.add("cccc");
		
		
		for(int i = 0 ; i< lista.size(); i++){
			System.out.println(lista.get(i));
			
		}
	
		
		
	}

}
