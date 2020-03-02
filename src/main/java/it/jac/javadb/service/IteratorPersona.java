package it.jac.javadb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.jac.javadb.entity.Persona;

public class IteratorPersona implements Iterator<Persona> {
	public static List<Persona> persone = new ArrayList<Persona>();
	public static int position = -1;
	
	public static boolean hasNext(List<Persona> persone) {
		return position < persone.size();  
	}

	
	public static Persona getNext(List<Persona> persone) {
		
		position++;
		Persona per = persone.get(position);
		return per != null ? per : null;
		
	}
	
	
	public void remove() 
	{
		Iterator.super.remove();
		persone.remove(persone.get(position));
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	public Persona next() {
		position++;
		Persona per = persone.get(position);
		return per != null ? per : null;
	}
}
