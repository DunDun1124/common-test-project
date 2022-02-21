package cute.dundun.entity.query;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class TestController {
    @GetMapping(path = "test")
    public Mono<String> test() {
        return Mono.deferContextual(ctx -> {
            log.info(ctx.toString());
            return Mono.just(ctx.get("trace_id"));
        });
    }
}