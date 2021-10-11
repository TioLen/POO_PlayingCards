

package jogandocartas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    Entrega do Trabalho 1 - Programação Orientada a Objetos - [BJD 4º SEMESTRE]

    Eu,
    Gabriel da Silva Barros
    declaro que
    todas as respostas são fruto de meu próprio trabalho,
    não copiei respostas de colegas externos à equipe,
    não disponibilizei minhas respostas para colegas externos ao grupo e
    não realizei quaisquer outras atividades desonestas para me beneficiar ou
    prejudicar outros.
*/


public class JogandoCartas {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Carta(valor, naipe)
        
        //          ás                              valete, dama, rei
        // valores: [1], 2, 3, 4, 5, 6, 7, 8, 9, 10, [11, 12, 13]
        // naipes: Espadas (♠)    Paus (♣)     Copas (♥)     Ouros (♦)
        
        FileReader lerArquivo = new FileReader ("file.txt");
        BufferedReader lerBufferizado = new BufferedReader (lerArquivo);
        
        Carta cartas [] = new Carta [100];
        
        String acao = "";
        boolean acaoSelected = false;
        
        int counter = 0;
        
        while(true){
            String line = lerBufferizado.readLine();
            
            
            if (line == null){
                
                if (acao.equals("ordenar"))
                {
                Carta.merge(cartas, 0, counter);
                    for (int i = 0; i < counter; i++){
                        System.out.println(cartas[i].de());
                    }
                }
                else if(acao.equals("descartar"))
                    Carta.descartar(cartas, 0, counter);
                else
                    System.out.println("Por favor, escreva direito!\n \"ordenar\" ou \"descartar\".");
                
                System.out.println("\nQuantidade de cartas: "+counter);
                break;
            }
            
            
            if (counter <= 100 && acaoSelected == true){
                
                String [] v = line.split(" ");
                
                if (line.equals("") ||line.equals("curinga"))
                    cartas[counter] = new Carta();
                else
                    cartas[counter] = new Carta(v[0],v[1]);
                
                counter++;
                
            }
            
            // ORDENAR ou DESCARTAR (deixei este 1º depois do 2º passo, para que o Counter fique correto)
            
            if (acao.equals("")){ // se acao estiver vazio (padrão), entao:
                 acao = line;     //   armazena o que tiver na primeira linha
                 if (line != null){
                    acaoSelected = true;
                    acao = line;
                 }
                 else
                     System.out.println("Por favor, escreva no arquivo de texto alguma ordem válida.");
                     
            }
            else if (line.equals("ordenar")){
                acaoSelected = true; acao = line;

            }
            else if (line.equals("descartar")){
                acaoSelected = true; acao = line;
            }
        }
        
    }
    
    
    
}
