package it.jac.javadb.service;

import java.util.List;

import com.google.protobuf.TextFormat.ParseException;

public interface ComponentPattern<T> {
	
		public void add(List<T> list) throws ParseException, java.text.ParseException;
		public void remove(int id, List<T> list) throws ParseException, java.text.ParseException;
		public void operation() throws ParseException, java.text.ParseException;
	
}
