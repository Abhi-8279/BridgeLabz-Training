class VolumeEarth5 {
    public static void main(String[] args) {

        double radiusKm = 6378;
        double pi = 3.14159;

        double volumeKm = (4.0 / 3.0) * pi * radiusKm * radiusKm * radiusKm;

        double kmToMile = 0.621371;
        double volumeMiles = volumeKm * kmToMile * kmToMile * kmToMile;

        System.out.println(
            "The volume of earth in cubic kilometers is " + volumeKm +
            " and cubic miles is " + volumeMiles
        );
    }
}

