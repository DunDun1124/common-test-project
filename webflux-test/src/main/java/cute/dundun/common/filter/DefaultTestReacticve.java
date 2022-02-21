//package cute.dundun.common.filter;
//
//import com.jayway.jsonpath.DocumentContext;
//import com.jayway.jsonpath.TypeRef;
//import com.netflix.graphql.dgs.reactive.DgsReactiveQueryExecutor;
//import graphql.ExecutionResult;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import reactor.core.publisher.Mono;
//
//import java.util.Map;
//
//@Dgs
//public class DefaultTestReacticve implements DgsReactiveQueryExecutor {
//    @Override
//    public Mono<ExecutionResult> execute(String query, Map<String, Object> variables, Map<String, Object> extensions, HttpHeaders headers, String operationName, ServerRequest serverHttpRequest) {
//        return null;
//    }
//
//    @Override
//    public <T> Mono<T> executeAndExtractJsonPath(String query, String jsonPath, Map<String, Object> variables) {
//        return null;
//    }
//
//    @Override
//    public Mono<DocumentContext> executeAndGetDocumentContext(String query, Map<String, Object> variables) {
//        return null;
//    }
//
//    @Override
//    public <T> Mono<T> executeAndExtractJsonPathAsObject(String query, String jsonPath, Map<String, Object> variables, Class<T> clazz) {
//        return null;
//    }
//
//    @Override
//    public <T> Mono<T> executeAndExtractJsonPathAsObject(String query, String jsonPath, Map<String, Object> variables, TypeRef<T> typeRef) {
//        return null;
//    }
//}
