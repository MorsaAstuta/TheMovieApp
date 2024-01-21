package dii2dam.movieApp.utils;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
  
  public static StandardServiceRegistry registry;
  public static SessionFactory factory;
  public static Session session;
  
  /**
   * Apertura de la conexión
   */
  public static void open() {
	if (factory == null) {
	  registry = new StandardServiceRegistryBuilder().configure().build();
	  factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	  session = factory.openSession();
	  session.setFlushMode(FlushMode.COMMIT);
	  session.setCacheMode(CacheMode.IGNORE);	
	}
  }
  
  /**
   * Comienzo de una transacción
   */
  public static void begin() {
	open();
	  session.getTransaction().begin();
  }
	
  /**
   * Transacción: save or update
   */
  public static void saveOrUpdate(Object object) {
	session.saveOrUpdate(object);
  }
	
  /**
   * Finalizado y guardado de una transacción
   */
  public static void commit() {
	session.getTransaction().commit();
  }
	
  /**
   * Cancelación de una transacción, o limpieza de restos de una transacción anterior
   */
  public static void rollback() {
	session.getTransaction().rollback();
  }

  /**
   * Cierre de la conexión
   */
  public static void close() {
	if (factory != null && !factory.isClosed() && session != null && session.isOpen()) {
		session.close();
		factory.close();
	}
  }
}
