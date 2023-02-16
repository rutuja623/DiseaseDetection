package com.example.diseasedetection;

public class Disease {
    public String diseaseName,plantName, descriptionAndSymptoms, causes, preventionAndTreatment;

    public Disease() {

    }

    public Disease(String diseaseName, String plantName, String descriptionAndSymptoms, String causes, String preventionAndTreatment) {
        this.diseaseName = diseaseName;
        this.descriptionAndSymptoms = descriptionAndSymptoms;
        this.causes = causes;
        this.preventionAndTreatment = preventionAndTreatment;
        this.plantName = plantName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public String getDescriptionAndSymptoms() {
        return descriptionAndSymptoms;
    }

    public String getCauses() {
        return causes;
    }

    public String getPreventionAndTreatment() {
        return preventionAndTreatment;

    }

    public String getPlantName() {
        return plantName;
    }
}
