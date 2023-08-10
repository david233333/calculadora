package co.com.bancolombia.mongo.repository;


import co.com.bancolombia.model.calculadora.Resultado;
import co.com.bancolombia.model.calculadora.gateways.CalculadoraRespository;
import co.com.bancolombia.mongo.mapper.MapperResultado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ResultadoDataGatewayImpl implements CalculadoraRespository {

    private final MapperResultado mapperResultado;
    private final ResultadoDataRepository resultadoDataRepository;

    @Override
    public Flux<Resultado> consultarResultados() {
        return resultadoDataRepository.findAll()
                .map(mapperResultado::toResultado);
    }

    @Override
    public Mono<Void> sumarYguardarResultados(Resultado resultado) {
        return Mono.just(resultado).map(mapperResultado::toData)
                        .flatMap(resultadoDataRepository::save)
                .then();

    }
}
