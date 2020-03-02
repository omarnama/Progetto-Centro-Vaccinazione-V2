package it.jac.javadb.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.entity.Persona;
import it.jac.javadb.dao.MalattiaDao;
import it.jac.javadb.entity.Malattia;
import it.jac.javadb.dao.PersonaDao;

public class Utils implements Iterator<Persona> {
	
	private static final Logger log = LogManager.getLogger(Utils.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void stampaLista(List<Persona> list) {
		//List<Item> list
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-----------------------------------\n");
		for(Persona bean : list) {

			sb
			//.append("|")
			//.append(StringUtils.rightPad(bean.getId(), 10))
			.append("|")
			.append(StringUtils.rightPad(bean.getNome(), 30))
			.append("|")
			.append(StringUtils.rightPad(bean.getCognome(), 50))
			.append("|")
			.append(sdf.format(bean.getDataNascita()))
			.append("|")
			.append(StringUtils.rightPad(bean.getRecapito_telefonico(), 15))
			.append("|")
			.append(StringUtils.rightPad(bean.getIndirizzo_residenza(), 100));
			//.append("|")
			//.append(StringUtils.rightPad(bean.getCreationTime()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getCreationUser()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getUpdateTime()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getUpdateUser()));
			sb.append("\n");
		}
		sb.append("-----------------------------------------------------------");	
		System.out.println(sb.toString());
		
		
	
		
		
}
	
	public static int position = -1;
	public static List<Persona> persone = new ArrayList<Persona>();
	
	public void stampaListaPersone(List<Persona> list)
	{
		PersonaDao dao = new PersonaDao();
		list = dao.findAll();
		System.out.println(list.get(0));
		for(int i = 0; i < list.size() - 1; i++)
		{
			System.out.println(next());
		}
	}
	
	public void stampaListaMalattie(List<it.jac.javadb.entity.Malattia> list)
	{
		it.jac.javadb.dao.MalattiaDao dao = new it.jac.javadb.dao.MalattiaDao();
		list = dao.findAll();
		System.out.println(list.get(0));
		for(int i = 0; i < list.size() - 1; i++)
		{
			System.out.println(next());
		}
	}
	

	
	@Override
	public boolean hasNext() {
		return next() != null;
	}
	
	@Override
	public Persona next() {
		position++;
        return position < persone.size() ? persone.get(position) : null;
	}
	
	@Override
	public void remove() 
	{
		Iterator.super.remove();
		persone.remove(persone.get(position));
	}
	
}

/*
 * 
 * public static List<Persona> persone = new ArrayList<Persona>();
public void stampaListaPersone(List<Persona> list)
{
	PersonaDao dao = new PersonaDao();
	list = dao.findAll();
	System.out.println(list.get(0));
	for(int i = 0; i < list.size() - 1; i++)
	{
		System.out.println(next());
	}
}

private char[] next() {
	// TODO Auto-generated method stub
	return null;
}
		*/

