package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Interface que define o padrão Strategy no dominio de cliente. Com
 * isso, se necessário, podemos ter múltiplas instancias dessa mesma interface.
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(String id);

    void inserir (Cliente cliente);

    void atualizar (String id, Cliente cliente);

    void deletar (String id);
}
