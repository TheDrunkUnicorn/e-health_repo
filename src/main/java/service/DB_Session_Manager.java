package service;

import org.hibernate.Session;

public interface DB_Session_Manager {
	
	public Session getSession();
	
	public void closeSession(Session session);
}
