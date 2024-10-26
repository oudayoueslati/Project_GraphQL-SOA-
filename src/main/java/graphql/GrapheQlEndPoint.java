package graphql;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/graphql")

public class GrapheQlEndPoint extends SimpleGraphQLServlet
  {

    public GrapheQlEndPoint()
    {
        super(buildSchema());
    }
    private static GraphQLSchema buildSchema()
    {
        RendezVousRepository rdvRepository = new RendezVousRepository();
        LogementRepository lrRepository = new LogementRepository();

        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Querries(rdvRepository),new Mutation(rdvRepository,lrRepository))
                .build()
                .makeExecutableSchema();
    }
  }
