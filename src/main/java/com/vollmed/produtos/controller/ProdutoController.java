package com.vollmed.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vollmed.produtos.model.Produto;
import com.vollmed.produtos.model.ProdutoRepository;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository; 
    // EXIBINDO OS PRODUTOS
    //Get -> Litar todos os produtos que estão cadastrados, exibindo ID, nome e preço. 
    //Quando ocorrer um get para produtoController, preciso retornar a listar.html

    @GetMapping("/") // "/" significa para a página principal
    public String listarProdutos(Model model){
        model.addAttribute("todosOsProdutos", repository.findAll());
        return "listar";
    }

    // CADASTRANDO O PRODUTO
    // Get -> Preciso retornar a cadastrar.html
    @GetMapping("/cadastro") // Mostra o formulário 
    public String mostrarFomulario(Model model){
        model.addAttribute("produto", new Produto()); // addAttribute ("nome do model"), construtor do model
        return "cadastrar"; // é o cadastrar.html
    }
    //Post -> Cadastrar um produto com seus atributos, nome e preço. Irá ocorrer quando eu clicar no botão do formulário 
    // da página cadastrar.html

    @PostMapping("/cadastro") // Acontece quando o botão for clicado
    public String cadastrarProdutos(Produto produto){
        
        repository.save(produto);
        return "redirect:/"; //  "/" significa voltar para a página principal
    }


    // Model -> É uma classe/interface (Model.java e não o pacote!) que faz parte do 
    // Spring MVC que é usada para passar dados entre o controlador a view (templates). 
    // Ele atua como um container para os dados que serão exibidos para o usuário final. 
}
