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
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarCliente(@PathVariable int id) {
	       clienteRepository.deleteById(id);
	   }
	
	@PutMapping("/{id}")
	   public Cliente atualizarCliente(@PathVariable int id, @RequestBody Cliente novoCliente) {
	       Optional<Cliente> optionalCliente = clienteRepository.findById(id);
	       if (optionalCliente.isPresent()) {
	           Cliente cliente = optionalCliente.get();
	           cliente.setNome(novoCliente.getNome());
	           cliente.setEmail(novoCliente.getEmail());
	           cliente.setTelefone(novoCliente.getTelefone());
	           return clienteRepository.save(cliente);
	       }
	       return null;
	   }


}
