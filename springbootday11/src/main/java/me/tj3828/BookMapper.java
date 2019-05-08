package me.tj3828;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @author tj3828
 */

@JsonComponent
public class BookMapper {

    public static class BookSerializer extends JsonSerializer<Book> {

        @Override
        public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("isbn", book.getIsbn());
            jsonGenerator.writeEndObject();
        }

    }

}
