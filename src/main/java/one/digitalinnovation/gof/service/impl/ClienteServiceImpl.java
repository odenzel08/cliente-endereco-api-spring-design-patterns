package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injetar os componentes do Spring (única instância da classe)
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    //Strategy: Implementação dos métodos da interface
    //Facade: Abstrair integrações com subsistema, promovendo uma interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(String id)  {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        verificacaoParaSalvar(cliente);
    }

    @Override
    public void atualizar(String id, Cliente cliente) {
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()){
            verificacaoParaSalvar(cliente);
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(400));
    }

    @Override
    public void deletar(String id) {
        clienteRepository.deleteById(id);
    }

    private void verificacaoParaSalvar(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
