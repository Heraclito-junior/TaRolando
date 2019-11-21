package framework.br.com.caelum.vraptor.websocket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import framework.br.com.caelum.vraptor.model.Mensagem;

public class MensagemEncoder implements Encoder.Text<Mensagem> {

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public String encode(Mensagem mensagem) throws EncodeException {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("atletaId", mensagem.getAtleta().getId())
                .add("dataEnvio", mensagem.getDataEnvio().toString())
                .add("mensagem", mensagem.getMensagem()).build();

        return jsonObject.toString();
    }
}
