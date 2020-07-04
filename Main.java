import java.util.ArrayList;
import java.util.Scanner;
import java.System;


public class Main{
  public static void main(String []args){
          Scanner leitor = new Scanner(System.in);
          System.out.println("DIGITE O NUMERO DE FUNCIONARIOS: ");
          int cad_func = leitor.nextInt();
          for (int j = 0; j < cad_func ; j++) {  
            Funcionario f = null;
            tipo = new Funcionario();
            System.out.println("DIGITE O ID DO FUNCIONARIO: ");
            int ID = leitor.nextInt();
            
            System.out.println("DIGITE O TIPO DO FUNCIONARIO: ");
            int TIPO_DO_FUNCIONARIO = leitor.nextInt();

            // salario 
            System.out.println("DIGITE O SALARIO : ");
            float salario = leitor.nextInt();

            // numero_de_dependente
            System.out.println("DIGITE O N_de _DEPENDENTES : ");
            int numero_de_dependente = leitor.nextInt();

            // tempo (anos quando e concursado e meses quando e temporario)
            System.out.println("DIGITE O TEMPO : "); // tratar como mes 
            int tempo = leitor.nextInt();

            // lista de dependentes 
            List<Dependente> dependentes = new ArrayList<>();

            
          
            if(TIPO_DO_FUNCIONARIO == 1)
            {

            f = new Concursado(ID,salario,tempo);
            //TEM UM CONSTRUTOR
            
            }
            else
            {
              f = new Temporario(ID,salario,tempo);
            //TEM UM CONSTRUTOR
            }
            
            for (int i = 0;( i < numero_de_dependente && i < 5 ); i++ ){
                Dependente dep = new Dependente();
                System.out.println("DIGITE A IDADE PLSE >///< : ");
                dep.setIdade(leitor.nextInt());
                dependentes.add(dep); // tipo append no python
            }
            f.setDep(dependentes);
  }
 }
}


// classe concursado 
public static Concursado extends Funcionario{

  private int tempoAnos;

  public Concursado(int id, float salario, int tempoAnos) {
    super(id, salario);
    this.tempoAnos = tempoAnos;
  }

  @Override
  public float valormensal() {
        float deps = this.verificade_pendentes_por_funcionario(21) * 100;
        float anos = this.tempoAnos * 200;
        return deps + anos + this.salario;
    }

}

// classe Dependente 
public class Dependente{
  private int idade;

    public int getIdade() {
      return idadeDependente;
    }

    public void setIdade(int idade) {
        this.idadeDependente = idade;
    }

}


// classe Funcionario 
public class Funcionario{

  private int id;
  private float salario;
  private List<Dependente> dep;
  public void setDep (List<Dependente> dep )
  {
      this.dep = dep;
  }

  public Funcionario(int id, float salario){
    this.id = id;
    this.salario = salario;
  }

    public int verificade_pendentes_por_funcionario(int idade) {
        int quantidade_Dependentes = 0;

        for (Dependente de : this.dep) {
            if (de.getIdade() <= idade) {
                quantidade_Dependentes++;
            }

        }

        return quantidade_Dependentes;

    }

  public float valormensal() {
    return 0;
  }

   public void imprimefuncionario() {
        System.out.println("ID: " + this.codigoFuncionario);
        System.out.println("Salario: " + valorMensalFuncionario());
        for (Dependente de : dep) {
            System.out.println("idade dependente: " + d.getIdade());
        }
    }

}



// classe Temporario
public static Temporario extends Funcionario{

  private int tempoMeses;

    public Temporario(int id, float salario, int tempoMeses) {
      super(id, salario);
      this.tempoMeses = tempoMeses;
    }

    @Override
    public float valormensal() {
        float deps = this.verificade_pendentes_por_funcionario(18) * 50;
        float anos = this.tempoMeses * 15;
        return deps + anos + this.salario;
    }

}






