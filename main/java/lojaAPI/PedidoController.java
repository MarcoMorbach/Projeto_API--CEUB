package lojaAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}

	@PostMapping
	public Pedido salvarPedidos(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPedido(@PathVariable int id) {
		pedidoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	   public Pedido atualizarPedido(@PathVariable int id, @RequestBody Pedido novoPedido) {
	       Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
	       if (optionalPedido.isPresent()) {
	    	   Pedido pedido = optionalPedido.get();
	           pedido.setData_pedido(novoPedido.getData_pedido());
	           pedido.setStatus(novoPedido.getStatus());
	           return pedidoRepository.save(pedido);
	       }
	       return null;
	   }

}
