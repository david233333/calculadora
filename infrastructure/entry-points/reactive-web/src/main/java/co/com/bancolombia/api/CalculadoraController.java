package co.com.bancolombia.api;


import co.com.bancolombia.model.calculadora.CalculadoraRequest;
import co.com.bancolombia.model.calculadora.Resultado;
import co.com.bancolombia.usecase.calculadora.CalculadoraUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/calculadora")

public class CalculadoraController {

    @Autowired
    private CalculadoraUseCase calculadoraUseCase;

    @GetMapping("/resultados")
    public Flux<Resultado> consultarProgramas() {
        return calculadoraUseCase.consultarResultados();
    }

    @PostMapping("/suma")
    public Mono<Void> suma(@RequestBody CalculadoraRequest request) {
        return calculadoraUseCase.suma(request.getValor1(), request.getValor2());
    }
}
