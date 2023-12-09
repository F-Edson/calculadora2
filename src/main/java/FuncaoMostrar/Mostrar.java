
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.regex.Pattern;

@Named
@ViewScoped

public class Mostrar implements Serializable {

    private String tela;
    private String operacao;
    private int resultado;

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    
    public void AddNumero(int numero) {
        tela += numero;
    }

    public void AddOperacao(String sinais) {
        operacao = sinais;
        tela += operacao;
    }

    public void calcular() {
        String[] partes = tela.split(Pattern.quote(operacao));

        int num1 = Integer.parseInt(partes[0]);
        int num2 = Integer.parseInt(partes[1]);

        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0 && (num1 != 0) ){
                    resultado = num1/ num2;
                }else{
                    tela = "Erro";
                    return;
                    
                }
               
                break;

        }

        tela = tela + " = " + resultado ;
    }

    public void limpar() {
        tela = "";

    }
    
    
  
    
}


