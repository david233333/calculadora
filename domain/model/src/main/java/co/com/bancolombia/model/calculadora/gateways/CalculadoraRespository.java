package co.com.bancolombia.model.calculadora.gateways;

import co.com.bancolombia.model.calculadora.Resultado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CalculadoraRespository {

    Flux<Resultado> consultarResultados();
    Mono<Void> sumarYguardarResultados(Resultado resultado);
}
