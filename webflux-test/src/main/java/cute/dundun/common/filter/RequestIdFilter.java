package cute.dundun.common.filter;

import fc.common.context.UserContext;
import fc.common.enums.AppType;
import fc.common.model.ApiLog;
import fc.common.model.CurrentLoginUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.util.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Slf4j
public class RequestIdFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        RequestPath path = exchange.getRequest().getPath();
        if (listExcludePattern().stream().anyMatch(pathPattern -> pathPattern.matches(path.pathWithinApplication()))) {
            return chain.filter(exchange);
        }

        ServerHttpRequest request = exchange.getRequest();
        String requestId = getRequestId(request.getHeaders());
        return chain.filter(exchange)
                .doOnEach(logOnEach(r -> logPrint(request)))
                .contextWrite(Context.of("trace_id", requestId, "user", CurrentLoginUser.builder().setAppType(AppType.DURIAN)
                        .setOrganizationId(1)
                        .setUserId(1)
                        .setToken("token")));
    }

    private void logPrint(ServerHttpRequest request) {
        ApiLog apiLog = new ApiLog();
        apiLog.setJavaMethod(request.toString());
        apiLog.setUri(request.getURI().getPath());
        apiLog.setMethod(request.getMethodValue());
        log.info("{}", apiLog);
    }

    private String getRequestId(HttpHeaders headers) {
        List<String> requestIdHeaders = headers.get("trace_id");
        return requestIdHeaders == null || requestIdHeaders.isEmpty()
                ? UUID.randomUUID().toString().replaceAll("-", "")
                : requestIdHeaders.get(0);
    }

    public static <T> Consumer<Signal<T>> logOnEach(Consumer<T> logStatement) {
        return signal -> {
            String contextValue = signal.getContextView().get("trace_id");
            try (MDC.MDCCloseable cMdc = MDC.putCloseable("trace_id", contextValue)) {
                logStatement.accept(signal.get());
            }
        };
    }

    public static <T> Consumer<Signal<T>> logOnNext(Consumer<T> logStatement) {
        return signal -> {
            if (!signal.isOnNext()) return;
            String contextValue = signal.getContextView().get("CONTEXT_KEY");
            try (MDC.MDCCloseable cMdc = MDC.putCloseable("trace_id", contextValue)) {
                logStatement.accept(signal.get());
            }
        };
    }

    private List<PathPattern> listExcludePattern() {
        List<PathPattern> excludePathPattern = new ArrayList<>(20);
        excludePathPattern.add(new PathPatternParser().parse("/doc.html"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.js"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.css"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.html"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.svg"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.pdf"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.jpg"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.png"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.ico"));

        excludePathPattern.add(new PathPatternParser().parse("/*/*.ttf"));
        excludePathPattern.add(new PathPatternParser().parse("/*/*.woff"));

        excludePathPattern.add(new PathPatternParser().parse("/druid/*"));
        excludePathPattern.add(new PathPatternParser().parse("/swagger*/*"));
        excludePathPattern.add(new PathPatternParser().parse("/swagger*/*"));

        // 性能监控new PathPatternParser().parse(
        excludePathPattern.add(new PathPatternParser().parse("/actuator/metrics/*"));
        excludePathPattern.add(new PathPatternParser().parse("/actuator/httptrace/*"));
        excludePathPattern.add(new PathPatternParser().parse("/actuator/redis/*"));
        return excludePathPattern;
    }
}
