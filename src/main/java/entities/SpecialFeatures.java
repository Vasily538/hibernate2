package entities;

import static java.util.Objects.isNull;

public enum SpecialFeatures {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    DeletedScenes("Deleted Scenes"),
    BehindTheScenes("Behind the Scenes");

    private String title;

    SpecialFeatures(String title) {
        this.title = title;
    }
public String getValue(){
        return title;
}
    public static SpecialFeatures getFeatureByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }
        SpecialFeatures[] specialFeatures = SpecialFeatures.values();
        for (SpecialFeatures feature : specialFeatures) {
            if (feature.title.equals(value)) {
                return feature;
            }
        }
return null;
    }
}
