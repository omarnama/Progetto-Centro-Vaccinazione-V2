package it.jac.javadb.service;

import java.util.Iterator;

import it.jac.javadb.entity.Persona;

public class IteratorAssignem implements InitIterator{
	public Iterator createIterator() {

		Iterator<Persona> persone = Persona.iterator();

		return persone;
	}
}
