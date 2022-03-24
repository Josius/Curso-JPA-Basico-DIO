package part1;

import Classes.Aluno;
import Classes.Estado;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionPart1 {

    public static void main(String[] args) {
        // OBS: Esse codigo pode ou nao funcionar de acordo com a biblioteca que foi baixada. Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.
        // porem se estiver com a biblioteca de algum framework com implementacao JPA (Hibernate ou EclipseLink), o JPA irá automaticamente utiliza-lo.

        // O ideal eh que nessa parte (Parte 1) o codigo EXECUTE COM ERROR (Ao tentar executar irá mostrar um error afirmando que não foi encontradado nenhuma implementação do JPA).
        // pois aqui nao deveria ter nenhuma implementacao JPA sendo utilizada, apenas o JPA puro para demonstrar que através dele é possivel definir a estrutura do codigo e depois escolher
        // a implementacao que ira utilizar. Apenas na parte 2 do curso sera escolhida uma implementacao para o codigo executar sem error

        //criando um gerenciador de entidades com o BD especificado em persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //instancias à serem add no BD
        Estado estadoParaAdd = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdd = new Aluno("Daniel", 29, estadoParaAdd);

        //iniciar uma transacao para add as instancias ao BD
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdd);
        entityManager.persist(alunoParaAdd);

        entityManager.getTransaction().commit();

        //encerrando o gerenciador de entidade e encerrando a fabrica de gerenciadores de entidade
        entityManager.close();
        entityManagerFactory.close();

    }
}
