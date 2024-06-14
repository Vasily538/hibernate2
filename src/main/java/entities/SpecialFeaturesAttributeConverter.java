package entities;

import jakarta.persistence.AttributeConverter;

public class SpecialFeaturesAttributeConverter implements AttributeConverter<SpecialFeatures, String> {
    @Override
    public String convertToDatabaseColumn(SpecialFeatures specialFeatures) {

        if (specialFeatures == null)
            return null;

        switch (specialFeatures) {
            case BehindTheScenes:
                return "Behind the Scenes";

            case Trailers:
                return "Trailers";

            case Commentaries:
                return "Commentaries";

            case DeletedScenes:
                return "Deleted Scenes";
            default:
                throw new IllegalArgumentException(specialFeatures + " not supported.");
        }
    }

    @Override
    public SpecialFeatures convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Behind the Scenes":
                return SpecialFeatures.BehindTheScenes;

            case "Trailers":
                return SpecialFeatures.Trailers;

            case "Commentaries":
                return SpecialFeatures.Commentaries;

            case "Deleted Scenes":
                return SpecialFeatures.DeletedScenes;
            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}
