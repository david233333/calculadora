package co.com.bancolombia.mongo.mapper;


import co.com.bancolombia.model.calculadora.Resultado;
import co.com.bancolombia.mongo.repository.ResultadoData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MapperResultado {

    public Resultado toResultado (ResultadoData resultadoData){
        return new Resultado(
                resultadoData.getId(),
                resultadoData.getValor1(),
                resultadoData.getValor2(),
                resultadoData.getResultado(),
                resultadoData.getFechaOperacion()
        );

    }

    public ResultadoData toData (Resultado resultado){
        return new ResultadoData(
                resultado.getId(),
                resultado.getValor1(),
                resultado.getValor2(),
                resultado.getResultado(),
                resultado.getFechaOperacion()
        );

    }
}
