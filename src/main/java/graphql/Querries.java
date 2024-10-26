package graphql;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;
import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdv;
    public LogementRepository lrepo;

    public Querries(RendezVousRepository rdv) {
        this.rdv = rdv;
    }

    public List<RendezVous>allrendezvous(){
        return rdv.getListeRendezVous();
}
    public List<RendezVous> getListeRendezVousByLogementRef(int reference)
    {
        return rdv.getListeRendezVousByLogementRef(reference);
    }
public  RendezVous rendezVousById(int id)
    {
        return  rdv.getRendezVousById(id);
    }
    public List<Logement> allLogement (){
        return  lrepo.getAllLogements();
    }
    public Logement getLogementsByReference(int reference){
        return lrepo.getLogementsByReference(reference);
    }
    public Logement getLogementsByType(Logement.Type type){
        return (Logement) lrepo.getLogementsByType(type);
    }
}
