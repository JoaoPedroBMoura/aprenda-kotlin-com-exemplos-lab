data class User(
    val name: String,
    val registration: Int,
    var level: Level,
    var punctuation: Int,
    var training: TrainingProgram,
    var statusUser: EnrollmentStatus = EnrollmentStatus.ENROLLED
)