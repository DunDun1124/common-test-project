package cute.dundun.entity.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import reactor.core.publisher.Mono;

@DgsComponent
public class TestQuery {

    @DgsQuery
    public Mono<String> testFilter() {
        return Mono.just("测试").flatMap(s -> Mono.deferContextual(contextView -> Mono.just(s + contextView.get("user"))));
    }
}
