package co.com.bancolombia.usecase.calculadora;

import co.com.bancolombia.model.calculadora.Resultado;
import co.com.bancolombia.model.calculadora.gateways.CalculadoraRespository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RequiredArgsConstructor
public class CalculadoraUseCase {

    private final CalculadoraRespository calculadoraRespository;

    public Flux<Resultado> consultarResultados() {
        return calculadoraRespository.consultarResultados();
    }

    public Mono<Void> suma(int operand1, int operand2) {
        int suma = operand1 + operand2;
        Resultado resultado = new Resultado();
        resultado.setValor1(operand1);
        resultado.setValor2(operand2);
        resultado.setResultado(suma);
        resultado.setFechaOperacion(new Date());

        return calculadoraRespository.sumarYguardarResultados(resultado);
    }
}
