// Fiz tudo e passou em todos os testes
// Fiz sozinho
// Levei alguns minutos pra fazer, n lembro com precisão





import java.util.Scanner;

class Aluno{
        String nome;
        int matricula;
        String disc;
        float nota;
        
        void ler(){
            Scanner in = new Scanner(System.in);
            nome = in.nextLine();
            matricula = Integer.parseInt(in.nextLine());
            disc = in.nextLine();
            nota = Float.parseFloat(in.nextLine());
        }
        
        void showInfo(){
            System.out.println("Nome = " + nome);
            System.out.println("Matrícula = " + matricula);
            System.out.println("Disciplina = " + disc);
            System.out.println("Nota = " + nota);
        }
    }

class L1{
    
    
    
    
    
    
    public static void main (String[] args) {
        Aluno al = new Aluno();
        al.ler();
        al.showInfo();
    }
    
    
    
}