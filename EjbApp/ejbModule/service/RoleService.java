package service;

import java.util.List;

import Entities.Role;
import dao.IDao;
import dao.IDaoLocal;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/* This single instance is shared among multiple clients, and it exists for the entire duration of the application*/
@Singleton (name="rs")
public class RoleService  implements IDao<Role> , IDaoLocal<Role>{
	 
		@PersistenceContext
		private EntityManager r;
		
		public RoleService() {}
		
		@Override
		@PermitAll
	    public void delete(Role o) {
	        r.remove(o);
	    }

		@Override
		@PermitAll
	    public List<Role> findAll() {
	        Query req= r.createQuery("select r from Role r");
	        return req.getResultList();
	    }

		@Override
		@PermitAll
	    public Role create(Role o) {
	        r.persist(o);
	        return o;
	    }

		@Override
		@PermitAll
	    public Role update(Role o) {
			r.persist(o);
	        return o;
	    }
		
		@Override
		@PermitAll
	    public Role findById(int id) {
	        Role role = r.find(Role.class, id);
	        if(role == null) throw new RuntimeException("Role introuvable");
	        return role;
	    }

}
