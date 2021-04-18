package guru.springframework.streamingstockquoteservice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_NDJSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by jt on 4/18/21.
 */
@Configuration
public class QuoteRouteConfig {

    public static final String QUOTES_PATH = "/quotes";

    @Bean
    public RouterFunction<ServerResponse> quoteRoutes(QuoteHandler handler){
        return route().GET(QUOTES_PATH, accept(APPLICATION_JSON), handler::fetchQuotes)
            .GET(QUOTES_PATH, accept(APPLICATION_NDJSON), handler::streamQuotes)
                .build();
    }
}
