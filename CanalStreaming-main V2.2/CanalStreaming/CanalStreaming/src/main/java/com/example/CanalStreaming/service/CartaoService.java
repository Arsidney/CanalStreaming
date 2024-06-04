package com.example.CanalStreaming.service;

import com.example.CanalStreaming.model.Cartao;
import com.example.CanalStreaming.repository.CartaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao registrar(Cartao cartao){
        return
                cartaoRepository.save(cartao);
    }

    public Cartao atualizar(Cartao cartao, String senha) {
        Integer cartaoId = cartao.getId();
        Cartao cartaoExistente = cartaoRepository.findById(cartaoId.toString())
                .orElseThrow(() -> new EntityNotFoundException("Cartão não encontrado"));

        if (!cartaoExistente.getUsuario().getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        cartaoExistente.setNumero(cartao.getNumero());
        cartaoExistente.setCodigoSeguranca(cartao.getCodigoSeguranca());
        cartaoExistente.setNomeTitular(cartao.getNomeTitular());
        cartaoExistente.setDataValidade(cartao.getDataValidade());

        return cartaoRepository.save(cartaoExistente);
    }

    public List<Cartao> listarTodos(){

        return cartaoRepository.findAll();
    }

    public Cartao buscarPorId(Integer id){
        return
                cartaoRepository.findById(String.valueOf(id)).get();
    }

    public void deletarCartao(Integer id){

        cartaoRepository.deleteById(String.valueOf(id));
    }

    public void excluir(String id, String senha) {
        Integer cartaoId = Integer.parseInt(id);
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cartão não encontrado"));


        if (!cartao.getUsuario().getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        cartaoRepository.delete(cartao);
    }
}
