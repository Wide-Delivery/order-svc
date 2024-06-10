package com.widedelivery.order.coverter.mongo;

import com.mongodb.client.model.geojson.LineString;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.List;
import java.util.stream.Collectors;

@ReadingConverter
public class LineStringReadConverter implements Converter<Document, LineString> {
    @Override
    public LineString convert(Document source) {
        List<List<Double>> coordinates = (List<List<Double>>) source.get("route");
        List<Position> positions = coordinates.stream()
                .map(coord -> new Position(coord.get(0), coord.get(1)))
                .collect(Collectors.toList());
        return new LineString(positions);
    }
}
