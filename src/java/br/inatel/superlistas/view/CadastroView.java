package br.inatel.superlistas.view;

import br.inatel.superlistas.dao.SQLInsert;
import br.inatel.superlistas.model.Produto;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author MatheusdeOliveiraCam
 */
@ManagedBean
public class CadastroView {
    
    private String nomeProduto;
    private int qntProduto;
    private float precoProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }
    

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }
    
    public void cadastrar (ActionEvent actionEvent) {
        SQLInsert insert = new SQLInsert();
        Produto produto = new Produto();
        produto.setNome(getNomeProduto());
        produto.setPrice(getPrecoProduto());
        produto.setQnt(getQntProduto());
        
        insert.insertProduto(produto, 2);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", 
                        "Produto cadastrado com sucesso!!!"));
    }
    
}
