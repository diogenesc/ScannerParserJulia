package analisadorsintatico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author diogenes
 */
public class AnalisadorSintatico {
    
    static String tokens[];
    static int p,terminal;
    int atual=0;
    
    public void logic_exp(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<OPLN>")){
                atual++;
                logic_exp();
                atual++;
                logic_exp_aux();
            }
            else{
                aux2();
                atual++;
                logic_exp_aux();
            }
        }
    }
    
    public void logic_exp_aux(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<OPL>")){
                atual++;
                logic_exp();
                atual++;
                logic_exp_aux();
            }
        }
    }
    
    public void termo(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<SINAL>")){
                atual++;
                if(tokens[atual].equals("<NUM>")){
                    terminal=1;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): NUM");
                    System.exit(0);
                }
            }
            else if(tokens[atual].equals("<NUM>")){
                terminal=1;
            }
            else if(tokens[atual].equals("<VAR>")){
                terminal=1;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): SINAL OU NUM OU VAR");
                System.exit(0);
            }
        }
    }
    
    public void exp(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<AP>")){
                p=1;
                atual++;
                exp();
                if(tokens[atual].equals("<FP>")){
                    p=0;
                    atual++;
                    exp_aux();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): FP");
                    System.exit(0);
                }
            }
            else{
                termo();
                atual++;
                exp_aux();
            }
        }
    }
    
    public void exp_aux(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<OPAB>") || tokens[atual].equals("<SINAL>") || tokens[atual].equals("<OPB>")){
                atual++;
                exp();
                atual++;
                exp_aux();
            }
            else
                aux3();
        }
    }
    
    public void aux2(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<AP>")){
                p=1;
                atual++;
                aux3();
            }
            else{
                termo();
                atual++;
                exp_aux();
            }
        }
    
    }
    
    public void aux3(){
        int f=0;
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<OPLN>")){
                atual++;
                logic_exp();
                atual++;
                logic_exp_aux();
            }
            else if(tokens[atual].equals("<AP>")){
                p=1;
                atual++;
                aux3();
            }
            else if(tokens[atual].equals("<AP>")){
                p=1;
                atual++;
                exp();
                if(tokens[atual].equals("<FP>")){
                    p=0;
                    atual++;
                    exp_aux();
                }
                else{
                   JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): FP");
                   System.exit(0);
                }
            }
            else if(tokens[atual].equals("<SINAL>")){
                atual++;
                if(tokens[atual].equals("<NUM>")){
                    f=1;
                    terminal=1;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): NUM");
                    System.exit(0);
                }
            }
            else if(tokens[atual].equals("<NUM>")){
                terminal=1;
                f=1;
            }
            else if(tokens[atual].equals("<VAR>")){
                if(tokens[atual+1].equals("<IGUAL>")){
                    atual+=2;
                    exp();
                    bloco_cod();
                }
                else
                    f=1;
            }
            if(f==1){
                atual++;
                exp_aux();
            }
            if(tokens[atual].equals("<FP>")){
                p=0;
                atual++;
                bloco_cod();
            }
            else if(p==0){
                bloco_cod();
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): FP");
                System.exit(0);
            }
        }
    
    }
    
    public void atrib(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<IGUAL>")){
                atual++;
                exp();
                bloco_cod();
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): IGUAL");
                System.exit(0);
            }
        }
    }
    
    public void element_atrib(){
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<IGUAL>")){
                terminal=1;
            }
            else if(tokens[atual].equals("<IN>")){
                terminal=1;
            }
            else if(tokens[atual].equals("<PERT>")){
                terminal=1;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): IGUAL OU IN OU PERT");
                System.exit(0);
            }
        }
    }
    //<NUM><DP><NUM> range_aux
    public void range(){
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<NUM>")){
                atual++;
                if(tokens[atual].equals("<DP>")){
                    atual++;
                    if(tokens[atual].equals("<NUM>")){
                    }
                    else{
                       JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): NUM");
                       System.exit(0); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): DP");
                    System.exit(0); 
                }
                atual++;
                terminal=1;
                range_aux();
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): NUM");
                System.exit(0); 
            }
            atual++;
            range_aux();
        }
    }
    
    public void range_aux(){//<DP><NUM> | lambda
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<DP>")){
                atual++;
                if(tokens[atual].equals("<NUM>")){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): NUM");
                    System.exit(0); 
                }
                terminal=1;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): DP");
                System.exit(0);
            }
        }
    }
    
    public void atrib_for_aux(){
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<VGL>")){
                terminal=1;
                atual++;
                atrib_for();
                atual++;
                atrib_for_aux();
            }
        }
    }
    
    public void atrib_block(){
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<VAR>")){
                terminal=1;
                atual++;
                element_atrib();
                atual++;
                range();
            }
        }
    }
    
    public void atrib_for(){
        if(atual>=tokens.length) finaliza();
        else{
            atrib_block();
            atual++;
            atrib_for_aux();
        }
        
    }
    
    public void bloco_cod(){
        //System.out.println(atual);
        if(atual>=tokens.length) finaliza();
        else{
            if(tokens[atual].equals("<IF>")){
                terminal=0;
                atual++;
                logic_exp();
                atual++;
                bloco_cod();
            }
            else if(tokens[atual].equals("<WHILE>")){
                terminal=0;
                atual++;
                logic_exp();
                atual++;
                bloco_cod();
            }
            else if(tokens[atual].equals("<FOR>")){
                terminal=0;
                atual++;
                atrib_for();
            }
            else if(tokens[atual].equals("<VAR>")){
                terminal=0;
                atual++;
                p=0;
                atrib();
            }
            else if(tokens[atual].equals("<END>")){
                terminal=1;
                atual++;
                bloco_cod();
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro sintático: token encontrado:" + tokens[atual] + "\nera(m) esperado(s): IF OU WHILE OU FOR OU VAR");
                System.exit(0);
                //erro
            }
        }
    }
    
    public void finaliza(){
        if(terminal==0) JOptionPane.showMessageDialog(null, "Tokens insuficientes para análise sintática ou falta de terminais.");
        else JOptionPane.showMessageDialog(null, "Análise realizada com sucesso no arquivo tokens.txt");
        System.exit(0);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int linhas=0;
        p=0;
        terminal=0;
        AnalisadorSintatico n= new AnalisadorSintatico();
        File arq= new File("tokens.txt");
        FileReader fr= new FileReader(arq);
        BufferedReader br= new BufferedReader(fr);
        //contando o numero de tokens
        while(br.ready()){
            linhas++;
            br.readLine();
        }
        fr.close();
        br.close();
        fr= new FileReader(arq);
        br= new BufferedReader(fr);
        tokens= new String[linhas];
        int i=0;
        //criando um vetor com o tokens
        while(br.ready()){
            tokens[i]=br.readLine();
            i++;
        }
        i=0;
        while(i<linhas){
            System.out.println(tokens[i]);
            i++;
        }
        System.out.println(tokens.length);
        n.bloco_cod();
    }
    
}
