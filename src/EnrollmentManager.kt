class EnrollmentManager(val students : List<User>, var training: TrainingProgram) {

    private val enrolledByRegistration = mutableMapOf<Int, User>()

    private  val enrolledByName = mutableMapOf<String,User>()

    fun studentEnrollment( students : List<User>){

        for(student in students) {

            val name = student.name
            val registration = student.registration
            var level = student.level
            var punctuation = student.punctuation
            var enrollmentStatus = EnrollmentStatus.ENROLLED
            var trainingUser = student.training

            enrolledByRegistration[student.registration] = student
            enrolledByName[student.name] = student

            println("Added Successfully")
        }

    }

    fun getEnrollmentManageByName(): MutableMap<String, User> {
        return enrolledByName
    }

    fun getEnrollementManageByRegistration(): MutableMap<Int, User> {
        return enrolledByRegistration
    }

}
