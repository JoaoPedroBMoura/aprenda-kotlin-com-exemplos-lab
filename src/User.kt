data class User(
    val name: String,
    val registration: Int,
    var level: Level,
    var punctuation: Int,
    var statusUser: EnrollmentStatus,
    var training: TrainingProgram
)