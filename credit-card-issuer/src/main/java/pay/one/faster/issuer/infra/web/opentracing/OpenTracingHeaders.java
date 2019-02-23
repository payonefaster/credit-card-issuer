package pay.one.faster.issuer.infra.web.opentracing;

import io.vertx.core.MultiMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author claudioed on 2019-02-17. Project credit-card-issuer */
public class OpenTracingHeaders {

  public static final List<String> options =
      List.of(
          "x-request-id",
          "x-b3-traceid",
          "x-b3-spanid",
          "x-b3-parentspanid",
          "x-b3-sampled",
          "x-b3-flags",
          "x-ot-span-context");

  private final Map<String, String> headers = new HashMap<>();

  public OpenTracingHeaders add(String header, String value) {
    this.headers.put(header, value);
    return this;
  }

  public String headerValue(String header) {
    return this.headers.getOrDefault(header, "");
  }

  public static OpenTracingHeaders fromHeaders(MultiMap headers) {
    OpenTracingHeaders openTracingHeaders = new OpenTracingHeaders();
    OpenTracingHeaders.options.forEach(el -> openTracingHeaders.add(el, headers.get(el)));
    return openTracingHeaders;
  }

}
