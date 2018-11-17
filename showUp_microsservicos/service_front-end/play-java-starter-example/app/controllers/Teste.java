package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.ws.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletionStage;
import play.libs.ws.WSBodyReadables;

@Singleton
public class Teste extends Controller  implements WSBodyReadables{
    private final WSClient ws;

    @Inject
    public Teste(WSClient ws) {
        this.ws = ws;
    }

    public Result birl()
    {
//        Jsoup.connect(url)
//                .method(Connection.Method.GET)
//                .ignoreContentType(true)
//                .execute()
//                .body();
//        return ok(node);
        return null;
    }
}
