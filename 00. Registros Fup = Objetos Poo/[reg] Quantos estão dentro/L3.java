// Fiz tudo e passou em todos os testes
// Fiz sozinho
// Levei alguns minutos pra fazer, n lembro com precisão

//OBS: tive que ir atras da formula pra saber se ta dentro ou não, matematica não é comigo 


import java.util.Scanner;


class Ponto{
    float x,y;
}

class Circulo{
    Ponto centro;
    float raio;
    
    
    boolean verifica(Ponto pt) {
        //calcula distancia :D // vai q eu esqueço oque esse d significa
        float d = (float) Math.sqrt(Math.pow(pt.x - centro.x, 2) + Math.pow(pt.y - centro.y, 2));
        return d <= raio;
    }
    
    int calcula(Ponto[] pts) {
        int i = 0;
        for (Ponto pt : pts) {
            if (verifica(pt)) {
                i++;
            }
        }
        return i;
    }
}



class L3{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        Ponto[] pts = new Ponto[n];
        for(int i = 0; i<n;i++){
            pts[i] = new Ponto();
            pts[i].x = in.nextFloat();
            pts[i].y = in.nextFloat();
        }
        Circulo c = new Circulo();
        c.centro = new Ponto();
        c.centro.x = in.nextFloat();
        c.centro.y = in.nextFloat();
        c.raio = in.nextFloat();
        
        System.out.printf("%d\n",c.calcula(pts));
        
        
        
        
    }
}