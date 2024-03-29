class EnrollmentManager(val students: List<User>, var training: TrainingProgram) {

    val enrolledByRegistration = mutableMapOf<Int, User>()

    val enrolledByName = mutableMapOf<String, User>()

    fun studentEnrollment(students: List<User>) {
        students.map { user ->
            user.copy(statusUser = EnrollmentStatus.ENROLLED, training = training).let {

                enrolledByRegistration[it.registration] = it
                enrolledByName[it.name] = it

                println("Success Added")
            }
        }
    }

    fun getEnrollmentManageByName(): MutableMap<String, User> {
        return enrolledByName
    }

    fun getEnrollementManageByRegistration(): MutableMap<Int, User> {
        return enrolledByRegistration
    }

}
