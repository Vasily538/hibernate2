package entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RatingAttributeConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {

        if (rating == null)
            return null;

        switch (rating) {
            case G:
                return "G";

            case PG:
                return "PG";

            case PG13:
                return "PG-13";

            case R:
                return "R";

            case NC17:
                return "NC-17";

            default:
                throw new IllegalArgumentException(rating + " not supported.");
        }
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "G":
                return Rating.G;

            case "PG":
                return Rating.PG;

            case "PG-13":
                return Rating.PG13;

            case "R":
                return Rating.R;

            case "NC-17":
                return Rating.NC17;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}
