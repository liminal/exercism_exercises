class SpaceAge(ageInSeconds: Int) {

    val ageInEarthYears = ageInSeconds / 31557600.0

    fun onEarth(): Double   = ageInEarthYears / 1.0
    fun onMercury(): Double = ageInEarthYears / 0.2408467
    fun onVenus(): Double   = ageInEarthYears / 0.61519726
    fun onMars(): Double    = ageInEarthYears / 1.8808158
    fun onJupiter(): Double = ageInEarthYears / 11.862615
    fun onSaturn(): Double  = ageInEarthYears / 29.447498
    fun onUranus(): Double  = ageInEarthYears / 84.016846
    fun onNeptune(): Double = ageInEarthYears / 164.79132
}

