package WeMatch.wematch.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@Getter
@JsonPropertyOrder({"isSuccess","HTTPStatus","msg","result"})
public class Response {

    private boolean isSuccess;
    private int HTTPStatus;
    private String msg;
    private Object result;

    public static Response success(String message) {
        return new Response(true,OK.value(),message,null);
    }

    public static Response success(String message, Object result) {
        return new Response(true, OK.value(),message,result);
    }

    public static Response failure(HttpStatus status,String message) {
        return new Response(false,status.value(),message,null);
    }

}
