package br.com.trainning.integracao.resource;

import br.com.trainning.integracao.model.Funcionario;
import br.com.trainning.integracao.service.FuncionarioProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioProducer service;

    @GetMapping("/send")
    @ResponseBody
    public String send(){

        Funcionario funcionario = Funcionario.create("Joao", "041.000.000-01", "10");
        service.send(funcionario);
        return "Enviado messagem";
    }

}
