package com.widedelivery.order.coverter.mongo;

import com.mongodb.client.model.geojson.LineString;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.util.List;
import java.util.stream.Collectors;

@WritingConverter
public class LineStringWriteConverter implements Converter<LineString, Document> {
    @Override
    public Document convert(LineString source) {
        Document document = new Document();
        document.put("type", "LineString");
        document.put("route", source.getCoordinates().stream()
                .map(pos -> List.of(pos.getValues().get(0), pos.getValues().get(1)))
                .collect(Collectors.toList()));
        return document;
    }
}
