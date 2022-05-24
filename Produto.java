public class Produto {
    private int codigo;
    private String nome;
    private double precoUnitario;
    private String unidade;
    private int qtdEstoque;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Produto() {
    }
    public String imprimir(){
        String resp = "";
        
       resp = "Nome do Produto: "+getNome() + "\nPreço Unitário: "+getPrecoUnitario() + "\nUnidade: "+getUnidade()+"\nEstoque Atual: "+getQtdEstoque();
        return resp;
    }
    public String relatorio(){
        String resp = "";
        
       resp = "Nome do Produto: "+getNome() + "\nPreço Unitário: "+getPrecoUnitario() + "\nUnidade: "+getUnidade()+"\nEstoque Atual: "+getQtdEstoque()+"\nValor Total em Estoque: R$ "+(getQtdEstoque() * getPrecoUnitario() );
        return resp;
    }
 
        
}
