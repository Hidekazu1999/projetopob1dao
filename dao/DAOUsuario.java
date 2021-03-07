package dao;

import modelo.Usuario;

import com.db4o.query.Query;
import modelo.Visualizacao;

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
    public List<Usuario> consultarUsuarioVideo(String link){
        Query q = manager.query();
        q.constrain(Usuario.class);
        q.descend("visualizacoes").descend("video").descend("link").constrain(link);
        List<Usuario> result = q.execute();
        return result;
    }

}
