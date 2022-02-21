package cute.dundun.entity.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.context.DgsContext;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@DgsComponent
public class TestQuery {
//    @DgsQuery
//    public Mono<String> testFilter() {
//        return Mono.just("测试").flatMap(s -> {
//            log.info("{}", s);
//            return Mono.deferContextual(contextView ->
//                    Mono.just(s + contextView.getOrDefault("trace_id", "12312")));
//        });
//    }

    @DgsQuery
    public Mono<String> testFilter() {
        return Mono.deferContextual(ctx -> {
            log.info(ctx.getOrDefault("trace_id","21312"));
            return Mono.just(ctx.getOrDefault("trace_id","21312"));
        });
    }
}
