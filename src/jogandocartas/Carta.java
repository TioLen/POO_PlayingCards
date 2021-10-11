package jogandocartas;



public class Carta {
    private String valor, naipe;
    
    
    // se carta vier com parametro nulo, entao:
    public Carta(){
        //return "[], Curinga";
        
        this.valor = "curinga";
        this.naipe = "";
        
        //System.out.println("Valor da carta :"+cardValue());
        valor = Integer.toString(cardValue());
    }
    
    // do contrario:
    public Carta(String v, String n){       //default "=0"
        valor = v;
        naipe = n;
        
        //System.out.println("Valor da carta :"+cardValue());
        valor = Integer.toString(cardValue());
    }
    
    
    private int cardValue(){
        if (valor == "" || valor == "curinga" || valor == "0"){
            return 0; //CURINGA É O VALOR, o naipe é 0
        }
        
        
        else if (valor.equalsIgnoreCase("as") || valor.equals("1")){
            return 1;
        }
        else if (valor.equalsIgnoreCase("valete") || valor.equals("11")){
            return 11;
        }
        else if (valor.equalsIgnoreCase("dama") || valor.equals("12")){
            return 12;
        }
        else if (valor.equalsIgnoreCase("rei")  || valor.equals("13")){
            return 13;
        }
        
        
        // qualquer valor entre 2 e 10 deve retornar
        else if (Integer.parseInt(this.valor) >= 2 && Integer.parseInt(this.valor) <= 10){
            return Integer.parseInt(this.valor);
        }
        
        return 100;
    }
    
    public String de(){
        
        naipe = this.naipe.toLowerCase();
        
        if (this.valor.equals("0") || this.valor == "curinga")
            return "Curinga.";
        else if (this.valor.equals("1"))
            return "Às de " + naipe+ ".";
        
        else if (this.valor.equals("11"))
            return "Valete de " + naipe + ".";
        
        else if (this.valor.equals("12"))
            return "Dama de " + naipe + ".";
        
        else if (this.valor.equals("13"))
            return "Rei de " + naipe + ".";
        
        return this.valor+" de "+naipe+".";
    }
    
    public int comparar(Carta c2){
        
        int c1 = Integer.parseInt(this.valor);
        int temp = Integer.parseInt(c2.valor);
        
        if (c1 == temp){
            return 0;
        }
        else if (c1 < temp){
            return -1;
        }
        else //if (c1 > temp){
            return -2;
        //}
        //return 5000;  //    so pra ele nao reclamar
    }
    
    
    
    public static void merge( Carta[] v,    int inicio, int fim ) {
        
        if (inicio < fim-1){
            int meio = (inicio+fim)/2;
            merge(v, inicio,meio);
            merge(v, meio,fim);
            sort(v, inicio,meio,fim);
            
        }
    }
    
    public static void sort(Carta[] v, int inicio, int meio, int fim) {
        Carta vFinal[] = new Carta[fim-inicio];
        
        int i=inicio; // NOVO INICIO -----> I
        int j=meio; // NOVO MEIO -----> J
        int k=0; // INDICE ---> acompanha o vFinal (vetor)
        
        
        while(i<meio && j<fim){
            
            if (v[i].comparar(v[j]) == -2)
                vFinal[k++] = v[j++];
            
            else
                vFinal[k++] = v[i++];
            
        }
        
        while (i<meio){
            vFinal[k++] = v[i++];
        }
        
        while (j<fim){
             vFinal[k++] = v[j++];
        }
        for (k=0, i=inicio; k < vFinal.length; k++, i++){
            v[i]=vFinal[k];
        }

    }
    
    public static void descartar(Carta[] v, int inicio, int counter){
        Carta[] vFinal = new Carta[counter]; // vetor do final
        int k=0;
        int j=0;
        Carta[] last = new Carta[1];
        
        while (k <= counter && (counter - k >= 2)){
            
            if (k == 0)
                System.out.println(v[k++].de()); //1st step
            
            if (k == 1)
                last[0] = v[k++];
            
            //move para ultima pos, a segunda posicao
            
            
            if (k%2 == 0){
                System.out.println(v[k++].de());
            }
            else{
                vFinal[j] = v[k];
                k++; j++;
            }
        
        }
        int i=0;
        while (vFinal[i+1] != null){
            
            
            System.out.println(vFinal[i++].de());
        }
        
        System.out.println(last[0].de());
        
    }
    
    
}
