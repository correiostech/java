package br.com.correios.api.correiostech.client.prepostagem;

import br.com.correios.api.correiostech.client.commons.ApiCorreiosRequestConfiguration;
import br.com.correios.api.correiostech.client.prepostagem.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "prePostagemClient", url = "${correios.client.prepostagem-url}",
        configuration = ApiCorreiosRequestConfiguration.class)
public interface PrePostagemClient {

    @PostMapping(value = "v1/prepostagens")
    CriaPrePostagemResponse cria(@RequestBody CriaPrePostagemRequest request);

    @DeleteMapping(value = "v1/prepostagens/{idPrePostagem}")
    CancelaPrePostagemResponse cancela(@PathVariable("idPrePostagem") String idPrePostagem);

    @PostMapping(value = "v1/prepostagens/rotulo/assincrono/pdf")
    GeraRotuloResponse geraRotulo(@RequestBody GeraRotuloRequest request);

    @GetMapping(value = "v1/prepostagens/rotulo/download/assincrono/{idRecibo}")
    RotuloResponse getRotulo(@PathVariable("idRecibo") String idRecibo);
}
