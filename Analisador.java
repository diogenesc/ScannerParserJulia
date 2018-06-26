/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_lfa;

interface Constantes {

    String  DIGITOS    = "0123456789",
               CHAR_VAR =  "abcdefghijklmnopqrstuvwxyz0123456789_",
                VAR    = "abcdefghijklmnopqrstuvwxyz_",
                A_F = "<>",
                M_M = "+-",
                M_R = "*%",
                VAZIOS    = " \r\n\t ";
}


/**
 *
 * @author Milena Bolzan
 */
public class Analisador implements Constantes {
    private int posicao = 0;
    private char proxCaractere;
    private String entrada;
    private String saida = "";
    
    public String run(String entrada){
        this.entrada = entrada;
        int len = entrada.length();
        this.leProxCaractere();
        try{
            while(this.posicao <= len){
                q0();
            }
            return this.saida;
        } catch(Exception ex){
            return ex.toString();
        }
    }
    
    // lê o próximo caractere do buffer. Se fim, retorna EOF
    // avança o ponteiro de leitura 1 posição
    public void leProxCaractere() {
        try {
            this.proxCaractere = this.entrada.charAt(this.posicao++);
        } catch(IndexOutOfBoundsException e) {
            this.proxCaractere = '\n';
        }
    }

    // verifica se o próximo caractere é um dos que estão em ‘s’
    // N O avança o ponteiro de leitura
    public boolean proxCaractereIs(String s) {
        if (s.indexOf(this.proxCaractere) != -1)
            return true;
        else
            return false;
    }
    
    private void q0() throws Exception{
        if(this.proxCaractereIs("i")){
            this.leProxCaractere();
            q1();
        } else if(this.proxCaractereIs("w")) {
            this.leProxCaractere();
            q3();
        } else if(this.proxCaractereIs("f")){
            this.leProxCaractere();
            q8();
        }else if(this.proxCaractereIs("e")){
            this.leProxCaractere();
            q11();
        }else if(this.proxCaractereIs("t")){
            this.leProxCaractere();
            q19();
        }else if(this.proxCaractereIs("b")){
            this.leProxCaractere();
            q21();
        }else if(this.proxCaractereIs("(")){
            this.leProxCaractere();
            q28();
        }else if(this.proxCaractereIs(")")){
            this.leProxCaractere();
            q29();
        }else if(this.proxCaractereIs("=")){
            this.leProxCaractere();
            q30();
        }else if(this.proxCaractereIs(A_F)){
            this.leProxCaractere();
            q39();
        }else if(this.proxCaractereIs(M_M)){
            this.leProxCaractere();
            q31();
        }else if(this.proxCaractereIs(M_R)){
            this.leProxCaractere();
            q32();
        }else if(this.proxCaractereIs("/")){
            this.leProxCaractere();
            q33();
        }else if(this.proxCaractereIs(":")){
            this.leProxCaractere();
            q34();
        }else if(this.proxCaractereIs(",")){
            this.leProxCaractere();
            q35();
        }else if(this.proxCaractereIs("&")){
            this.leProxCaractere();
            q38();
        }else if(this.proxCaractereIs("|")){
            this.leProxCaractere();
            q37();
        }else if(this.proxCaractereIs(".")){
            this.leProxCaractere();
            q44();
        }else if(this.proxCaractereIs("!")){
            this.leProxCaractere();
            q45();
        }else if(this.proxCaractereIs(DIGITOS)){
            this.leProxCaractere();
            q41();
        }else if(this.proxCaractereIs(VAR)){
            this.leProxCaractere();
            q26();
        }else if(this.proxCaractereIs(VAZIOS)){
            this.leProxCaractere();
        }else{
            throw new Exception("ERRO LEXICO");
        }
    }
    
    private void q1(){
        if(this.proxCaractereIs("f")){
            this.leProxCaractere();
            q2();
        } else if(this.proxCaractereIs("n")) {
            this.leProxCaractere();
            q14();
        } else if(this.proxCaractereIs(CHAR_VAR)){
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q2(){
        if(this.proxCaractereIs(CHAR_VAR)){
            this.leProxCaractere();
            q27();
        }else{
            this.saida += "<IF>\n";           
        }
    }
    
    private void q3(){
        if(this.proxCaractereIs("h")){
            this.leProxCaractere();
            q4();
        } else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<VAR>\n";
        }        
        
    }
    
    private void q4(){
        if(this.proxCaractereIs("i")){
            this.leProxCaractere();
            q5();
        } else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<VAR>\n";
        }                
    }
 
    private void q5(){
        if(this.proxCaractereIs("l")){
            this.leProxCaractere();
            q6();
        } else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<VAR>\n";
        }        
        
    }
    
    private void q6(){
        if(this.proxCaractereIs("e")){
            this.leProxCaractere();
            q7();
        } else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<VAR>\n";
        }               
    }

    private void q7(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        } else {
            this.saida += "<WHILE>\n";
        }             
    }
    
    private void q8(){
        if(this.proxCaractereIs("a")){
            this.leProxCaractere();
            q15();
        } else if(this.proxCaractereIs("o")) {
            this.leProxCaractere();
            q9();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }  
    }
    
    private void q9(){
        if(this.proxCaractereIs("r")){
            this.leProxCaractere();
            q10();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }  
    }
    
    private void q10(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<FOR>\n";
        }  
    }
    
    private void q11(){
        if(this.proxCaractereIs("n")){
            this.leProxCaractere();
            q12();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }  
    }
    
    private void q12(){
        if(this.proxCaractereIs("d")){
            this.leProxCaractere();
            q13();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }  
    }
 
    private void q13(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<END>\n";
        } 
    }
    
    private void q14(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<IN>\n";
        }
    }

    private void q15(){
        if(this.proxCaractereIs("l")){
            this.leProxCaractere();
            q16();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q16(){
        if(this.proxCaractereIs("s")){
            this.leProxCaractere();
            q17();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q17(){
        if(this.proxCaractereIs("e")){
            this.leProxCaractere();
            q18();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q18(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<BOOL>\n";
        }
    }
    
    private void q19(){
        if(this.proxCaractereIs("r")){
            this.leProxCaractere();
            q20();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q20(){
        if(this.proxCaractereIs("u")){
            this.leProxCaractere();
            q17();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
 
    private void q21(){
        if(this.proxCaractereIs("r")){
            this.leProxCaractere();
            q22();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q22(){
        if(this.proxCaractereIs("e")){
            this.leProxCaractere();
            q23();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }

    private void q23(){
        if(this.proxCaractereIs("a")){
            this.leProxCaractere();
            q24();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q24(){
        if(this.proxCaractereIs("k")){
            this.leProxCaractere();
            q25();
        }else if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }  
    }
    
    private void q25(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<BREAK>\n";
        }
    }
    
    private void q26(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q27(){
        if(this.proxCaractereIs(CHAR_VAR)) {
            this.leProxCaractere();
            q27();
        }else {
            this.saida += "<VAR>\n";
        }
    }
    
    private void q28(){
        this.saida += "<AP>\n";
    }
 
    private void q29(){
        this.saida += "<FP>\n";  
    }
    
    private void q30(){
        if(this.proxCaractereIs("=")) {
            this.leProxCaractere();
            q40();
        }else {
            this.saida += "<IGUAL>\n";
        }
    }

    private void q31(){
        this.saida += "<SINAL>\n"; 
    }
    
    private void q32(){
        this.saida += "<OPAB>\n"; 
    }
    
    private void q33(){
        if(this.proxCaractereIs("/")) {
            this.leProxCaractere();
            q32();
        }else {
            this.saida += "<OPAB>\n";
        } 
    }
    
    private void q34(){
        this.saida += "<DP>\n";
    }
    
    private void q35(){
        this.saida += "<VGL>\n";
    }
    
    private void q36(){
        this.saida += "<OPL>\n";
    }
    
    private void q37() throws Exception{
        if(this.proxCaractereIs("|")) {
            this.leProxCaractere();
            q36();
        }else
             throw new Exception("ERRO LEXICO");
    }

    private void q38() throws Exception{
        if(this.proxCaractereIs("&")) {
            this.leProxCaractere();
            q36();
        }else
            throw new Exception("ERRO LEXICO");
    }
    
    private void q39(){
        if(this.proxCaractereIs("=")) {
            this.leProxCaractere();
            q40();
        }else {
            this.saida += "<OPB>\n";
        }
    }
    
    private void q40(){
        this.saida += "<OPB>\n";
    }
    
    private void q41(){
        if(this.proxCaractereIs(DIGITOS)){
            this.leProxCaractere();
            q41();
        }else if(this.proxCaractereIs(".")) {
            this.leProxCaractere();
            q42();
        }else {
            this.saida += "<NUM>\n";
        }  
    }
    
    private void q42(){
        if(this.proxCaractereIs(DIGITOS)){
            this.leProxCaractere();
            q43();
        }else {
            this.saida += "<NUM>\n";
        }  
    }

    private void q43(){
        if(this.proxCaractereIs(DIGITOS)){
            this.leProxCaractere();
            q43();
        }else {
            this.saida += "<NUM>\n";
        } 
    }
    
    private void q44() throws Exception{
        if(this.proxCaractereIs(DIGITOS)){
            this.leProxCaractere();
            q43();
        }else {
            throw new Exception("ERRO LEXICO");
        } 
    }
    
    private void q45(){
        this.saida += "<OPLN>\n";
    }    
    
}
