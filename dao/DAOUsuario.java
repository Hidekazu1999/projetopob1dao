package dao;

import modelo.Usuario;

import com.db4o.query.Query;

import java.util.List;

public class DAOUsuario extends DAO<Usuario> {
    public Usuario read (Object chave){
        String email = (String) chave;
        Query q = manager.query();
        q.constrain(Usuario.class);
        q.descend("email").constrain(email);
        List<Usuario> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
}
