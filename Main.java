

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {   
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Scanner LerTexto = new Scanner(System.in);
        Scanner LerValor = new Scanner(System.in);
        Scanner LerInteiro = new Scanner(System.in);
        int op = 0;
        
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Produto produto;
        do{
            Menu();
            op = ler.nextInt();
            switch(op){
                case 1:                    
                    do{
                        menuCadastroProduto();
                        op = ler.nextInt();
                        Cabecalho();
                        switch(op){                            
                            case 1:
                                int aux;
                                String resp = "";
                                do{
                                    produto = new Produto();
                                    
                                    
                                    System.out.println("INCLUSÃO DE PRODUTO");
                                    do{
                                        System.out.print("NOME: ");
                                        produto.setNome(LerTexto.nextLine());
                                        aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                        if(aux == 1){
                                            System.out.println("Produto com esse nome já Cadastrado");
                                        }
                                    }while(aux != 0 );

                                    do{
                                        System.out.print("PREÇO: ");
                                        produto.setPrecoUnitario(LerValor.nextDouble());
                                        if(produto.getPrecoUnitario() <= 0){
                                            System.out.println("Valor Invalido, informe valor maior que zero");
                                        }
                                    }while(produto.getPrecoUnitario() <= 0);
                                    System.out.print("UNIDADE: ");
                                    produto.setUnidade(LerTexto.nextLine());
                                    do{
                                        System.out.print("QUANTIDADE: ");
                                        produto.setQtdEstoque(LerInteiro.nextInt());
                                        if(produto.getQtdEstoque() < 0){
                                            System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                        }
                                    }while(produto.getQtdEstoque() < 0);

                                    System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                    resp = LerTexto.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        System.out.println("CADASTRO CONFIRMADO");
                                        listaProdutos.add(produto);
                                    }else{
                                        System.out.println("CADASTRO NÃO CONFIRMADO");
                                    }
                                    System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                    resp = LerTexto.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        aux = 1;
                                    }else{
                                        aux = 0;
                                    }
                                }while(aux != 0);
                                
                                
                            break;
                            case 2:
                                System.out.println("ALTERAÇÃO DE PRODUTO");
                                aux = 0;
                                do{
                                    produto = new Produto();
                                    System.out.print("INFORME O NOME DO PRODUTO PARA ALTERAR: ");
                                    produto.setNome(LerTexto.nextLine());
                                    aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                    if(aux == 1){
                                        int codProduto = 0;
                                        System.out.println("Produto Existente");
                                        codProduto = exibirPorPorduto(listaProdutos, produto.getNome());
                                        
                                        do{
                                            System.out.print("INFORME O NOVO PREÇO: ");
                                            produto.setPrecoUnitario(LerValor.nextDouble());
                                            if(produto.getPrecoUnitario() <= 0){
                                                System.out.println("Valor Invalido, informe valor maior que zero");
                                            }
                                        }while(produto.getPrecoUnitario() <= 0);
                                        System.out.print("INFORME A NOVA UNIDADE: ");
                                        produto.setUnidade(LerTexto.nextLine());
                                        do{
                                            System.out.print("INFORME A NOVA QUANTIDADE: ");
                                            produto.setQtdEstoque(LerInteiro.nextInt());
                                            if(produto.getQtdEstoque() < 0){
                                                System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                            }
                                        }while(produto.getQtdEstoque() < 0);
                                        System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                        resp = LerTexto.nextLine();
                                        if(resp.equals("S") || resp.equals("s")){
                                            System.out.println("ALTERAÇÃO CONFIRMADO");
                                            listaProdutos.set(codProduto ,produto);
                                        }else{
                                            System.out.println("ALTERAÇÃO NÃO CONFIRMADO");
                                        }
                                       
                                        
                                    }else{
                                        System.out.println("Produto não Existente");
                                    }
                                    System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                    resp = LerTexto.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        aux = 1;
                                    }else{
                                        aux = 0;
                                    }
                                    
                                }while(aux != 0);
                            break;
                            case 3:
                                System.out.println("CONSULTA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO PARA CONSULTA: ");
                                produto.setNome(LerTexto.nextLine());
                                aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                if(aux == 1){
                                    consultaPorPorduto(listaProdutos, produto.getNome());
                                }else{
                                   System.out.println("Produto não Existente");
                                }
                            break;
                            case 4:
                                System.out.println("EXCLUSÃO DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO PARA EXCLUSÃO: ");
                                produto.setNome(LerTexto.nextLine());
                                aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("Produto Existente");
                                    codProduto = exibirPorPorduto(listaProdutos, produto.getNome());
                                    System.out.println("CONFIRMA EXCLUSÃO (S/N)?");
                                    resp = LerTexto.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                       System.out.println("EXCLUSÃO CONFIRMADO");
                                       listaProdutos.remove(codProduto);
                                    }else{
                                       System.out.println("EXCLUSÃO NÃO CONFIRMADO");
                                    }
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                            break;
                            case 0:
                                System.out.println("Retorno para Menu Principal");
                            break;
                            
                            default:
                                System.out.println("\nOpção Inválida");
                            break;
                            
                        }
                        
                    }while(op != 0);
                    
                    op = 1;
                break;
                case 2:
                    int aux;
                    String resp = "";
                    do{
                        produto = new Produto();
                        menuMovimentacaoProduto();
                        op = ler.nextInt();
                        Cabecalho();
                        switch(op){
                            case 1:
                                
                                System.out.println("ENTRADA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(LerTexto.nextLine());
                                aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("Produto Existente");
                                    codProduto = exibirPorPorduto(listaProdutos, produto.getNome());
                                    
                                    do{
                                        System.out.print("QUANTIDADE DE ENTRADA: ");
                                        produto.setQtdEstoque(LerInteiro.nextInt());
                                        if(produto.getQtdEstoque() < 0){
                                            System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                        }
                                    }while(produto.getQtdEstoque() < 0);
                                    produto.setQtdEstoque(produto.getQtdEstoque() + listaProdutos.get(codProduto).getQtdEstoque());
                                    produto.setPrecoUnitario(listaProdutos.get(codProduto).getPrecoUnitario());
                                    produto.setUnidade(listaProdutos.get(codProduto).getUnidade());
                                    
                                    System.out.println("CONFIRMA ENTRADA (S/N)?");
                                    resp = LerTexto.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                       System.out.println("ENTRADA CONFIRMADO");
                                       listaProdutos.set(codProduto, produto);
                                    }else{
                                       System.out.println("ENTRADA NÃO CONFIRMADO");
                                    }
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 2:
                                System.out.println("SAÍDA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(LerTexto.nextLine());
                                aux = verificarNomeProduto(listaProdutos, produto.getNome());
                                if(aux == 1){
                                   int codProduto = 0;
                                   System.out.println("Produto Existente");
                                   codProduto = exibirPorPorduto(listaProdutos, produto.getNome());                                    
                                   do{
                                       System.out.print("QUANTIDADE DE SAÍDA: ");
                                       produto.setQtdEstoque(LerInteiro.nextInt());
                                       if(produto.getQtdEstoque() <= 0 || produto.getQtdEstoque() > listaProdutos.get(codProduto).getQtdEstoque()){
                                         System.out.println("Valor Invalido, informe um valor maior que zero ou menor igual a quantidade existente");
                                       }
                                   }while(produto.getQtdEstoque() <= 0 || produto.getQtdEstoque() > listaProdutos.get(codProduto).getQtdEstoque());
                                   System.out.println("CONFIRMA SAÍDA (S/N)?");
                                   resp = LerTexto.nextLine();
                                   if(resp.equals("S") || resp.equals("s")){
                                     System.out.println("SAÍDA CONFIRMADO");
                                     produto.setQtdEstoque(listaProdutos.get(codProduto).getQtdEstoque() - produto.getQtdEstoque());
                                     produto.setPrecoUnitario(listaProdutos.get(codProduto).getPrecoUnitario());
                                     produto.setUnidade(listaProdutos.get(codProduto).getUnidade());
                                     listaProdutos.set(codProduto, produto);
                                   }else{
                                     System.out.println("SAÍDA NÃO CONFIRMADO");
                                   }
                                   
                                   
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 0:
                                System.out.println("Retorno para Menu Principal");
                            break;
                            
                            default:
                                System.out.println("\nOpção Inválida");
                            break;
                            
                        }
                    }while(op != 0);
                    op = 2;
                break;
                case 3:
                    aux = 0;
                    resp = "";
                    System.out.println("REAJUSTE DE PREÇOS");
                    produto = new Produto();
                    System.out.print("INFORME O NOME DO PRODUTO: ");
                    produto.setNome(LerTexto.nextLine());
                    aux = verificarNomeProduto(listaProdutos, produto.getNome());
                    if(aux == 1){
                        int codProduto = 0;
                        System.out.println("Produto Existente");
                        codProduto = exibirPorPorduto(listaProdutos, produto.getNome());    
                        do{
                            System.out.print("INFORME O NOVO PREÇO: ");
                            produto.setPrecoUnitario(LerValor.nextDouble());
                            if(produto.getPrecoUnitario() <= 0){
                                System.out.println("Valor Invalido, informe valor maior que zero");
                            }
                        }while(produto.getPrecoUnitario() <= 0);                        
                        produto.setQtdEstoque(listaProdutos.get(codProduto).getQtdEstoque());
                        produto.setUnidade(listaProdutos.get(codProduto).getUnidade());
                        
                        System.out.println("CONFIRMA REAJUSTE (S/N)?");
                        resp = LerTexto.nextLine();
                        if(resp.equals("S") || resp.equals("s")){
                            System.out.println("REAJUSTE CONFIRMADO");
                            listaProdutos.set(codProduto, produto);
                        }else{
                            System.out.println("REAJUSTE NÃO CONFIRMADO");
                        }
                        
                    }else{
                        System.out.println("PRODUTO NÃO CADASTRADO");
                    }
                    
                break;
                case 4:
                    System.out.println("RELATÓRIOS");
                    if(listaProdutos.size()> 0){
                        relatorio(listaProdutos);
                    }else{
                        System.out.println("NÃO EXISTE PRODUTOS CADASTRADO");
                    }
                break;
                case 0:
                    System.out.println("Fim");
                break;
                
                default:
                    System.out.println("\nOpção Inválida");
                break;
            }
            
        }while(op != 0);
    
    }
    public static void Menu(){        
        Cabecalho();
        System.out.print("MENU PRINCIPAL\n1 - CADASTRO DE PRODUTOS\n2 - MOVIMENTAÇÃO\n3 - REAJUSTE DE PREÇOS\n4 - RELATÓRIOS\n0 - FINALIZAR\nOPÇÃO: ");
    }
    public static void menuCadastroProduto(){
        Cabecalho();
        System.out.print("CADASTRO DE PRODUTOS\n1 - INCLUSÃO\n2 - ALTERAÇÃO\n3 - CONSULTA\n4 - EXCLUSÃO\n0 - RETORNAR\nOPÇÃO: ");
    }
    public static void menuMovimentacaoProduto(){
        Cabecalho();
        System.out.print("MOVIMENTAÇÃO\n1 - ENTRADA\n2 - SAIDA\n0 - RETORNAR\nOPÇÃO: ");
    }
    public static void Cabecalho(){
        System.out.println("=====================================================");
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("=====================================================");
    }
    
    public static int verificarNomeProduto(List<Produto> p, String nome){
        int aux = 0;
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getNome().equals(nome)){
                aux = 1;
                break;
            }
        }
        return aux;
    }
    public static int exibirPorPorduto(List<Produto> p, String nome){
        int aux = 0;
         System.out.println("-----------------Produto---------------------------");
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getNome().equals(nome)){
                System.out.println(p.get(i).imprimir());
                aux = i;
                break;
            }
        }
        System.out.println("---------------------------------------------------");
        return aux;
    }
    public static void consultaPorPorduto(List<Produto> p, String nome){
        System.out.println("-----------------Produto---------------------------");
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getNome().equals(nome)){
                System.out.println(p.get(i).imprimir());               
                break;
            }
        }
        System.out.println("---------------------------------------------------");
    }
    public static void relatorio(List<Produto> p){
        System.out.println("-----------------Relatórios dos Produto---------------------------");
        for (int i = 0; i < p.size(); i++) {
            System.out.println("---------------------------------------------------");
            System.out.println(p.get(i).relatorio());
            
        }
        
    }
}
