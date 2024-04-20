package ru.kpfu.itis.gnt.okno.controllers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .servers(buildServers())
                .info(buildInfo());
    }

    private Info buildInfo() {
        return new Info()
                .title("OKNO Tracker API")
                .description("Tracker для ваших задач от команды OKNO.")
                .version("0.1");
    }

    private List<Server> buildServers() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        return List.of(server);
    }

}
