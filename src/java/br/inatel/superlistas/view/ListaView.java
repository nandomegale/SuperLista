package br.inatel.superlistas.view;

import br.inatel.superlistas.dao.SQLDelete;
import br.inatel.superlistas.dao.SQLSelect;
import br.inatel.superlistas.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author MatheusdeOliveiraCam
 */
@ManagedBean
@ViewScoped
public class ListaView implements Serializable {
    
    private List<Produto> produtos;
    
    private Produto produtoSelected;

    public List<Produto> getProdutos() {
        if (produtos == null) {
            SQLSelect select = new SQLSelect();
            produtos = select.getProdutoById(2);
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }  

    public Produto getProdutoSelected() {
        return produtoSelected;
    }

    public void setProdutoSelected(Produto produtoSelected) {
        this.produtoSelected = produtoSelected;
    }
    
    public void deleteProduto(Produto produto) {
        SQLDelete delete = new SQLDelete();
        delete.deleteProduto(produto.getId());
        
        produtos.remove(produto);
    }
    
    public void editProduto(Produto produto) {
        
    }
    
}
