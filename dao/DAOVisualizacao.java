package dao;

import com.db4o.query.Query;
import modelo.Visualizacao;

import java.util.List;

public class DAOVisualizacao extends DAO<Visualizacao> {
    public Visualizacao read (Object chave) {
        int visua = (int) chave;

        Query q = manager.query();
        q.constrain(Visualizacao.class);
        q.descend("id").constrain(visua);
        List<Visualizacao> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
}
