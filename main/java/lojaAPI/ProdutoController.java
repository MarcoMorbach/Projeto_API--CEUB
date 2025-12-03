package lojaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
		public void deletarProduto(@PathVariable int id) {
			produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	   public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto novoProduto) {
	       Optional<Produto> optionalProduto = produtoRepository.findById(id);
	       if (optionalProduto.isPresent()) {
	    	   Produto produto = optionalProduto.get();
	           produto.setNome(novoProduto.getNome());
	           produto.setPreco(novoProduto.getPreco());
	           produto.setEstoque(novoProduto.getEstoque());
	           produto.setDescricao(novoProduto.getDescricao());
	           return produtoRepository.save(produto);
	       }
	       return null;
	   }
	
	

	
	
	

}
