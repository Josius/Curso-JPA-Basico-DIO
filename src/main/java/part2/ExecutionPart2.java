package part2;

import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionPart2 {
    public static void main(String[] args) {
        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        Estado rioDeJaneiro = new Estado("Rio de Janeiro", "RJ");
        Estado saoPaulo = new Estado("Sao Paulo", "SP");
        Aluno daniel = new Aluno("Daniel", 29, rioDeJaneiro);
        Aluno joao = new Aluno("Joao", 29, rioDeJaneiro);
        Aluno aline = new Aluno("Aline", 29, saoPaulo);
        Aluno vera = new Aluno("Vera", 29, saoPaulo);


        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(rioDeJaneiro);
        entityManager.persist(saoPaulo);
        entityManager.persist(daniel);
        entityManager.persist(joao);
        entityManager.persist(aline);
        entityManager.persist(vera);

        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados
        Estado estadoEncontrado = entityManager.find(Estado.class, 1);
        Aluno alunoEncontrado = entityManager.find(Aluno.class, 1);

        System.out.println(estadoEncontrado);
        System.out.println("ANTES DE ALTERAR O BD: " + alunoEncontrado);

        // 4 - Alterar uma entidade
        entityManager.getTransaction().begin();

        alunoEncontrado.setNome("Karam");
        alunoEncontrado.setIdade(20);

        entityManager.getTransaction().commit();
        System.out.println("DEPOIS DE ALTERAR O BD: " + alunoEncontrado);

//         5 - Remover uma entidade
        System.out.println("ANTES DE apagar O BD: " + alunoEncontrado);
        entityManager.getTransaction().begin();
        entityManager.remove(alunoEncontrado);
        entityManager.getTransaction().commit();
        System.out.println("DEPOIS DE apagar O BD: " + alunoEncontrado);
        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
    }
}
