

enum class Level { BASIC, INTERMEDIARY, ADVANCED }

enum class EnrollmentStatus {NOT_ENROLLED, ENROLLED}
data class TrainingProgram(val name: String,private var contents: MutableList<EducationalContent>) {

    private val  training : MutableMap<String, MutableList<EducationalContent>> = mutableMapOf()

    init {
        training[name] = contents
    }

    fun updateTraining( name: String, content: EducationalContent){
        if(training.containsKey(name)){
            training[name]?.add(content)
        }else{
            training[name] = mutableListOf(content)
        }

    }

    fun editContent( name: String, oldContent: EducationalContent, newContent: EducationalContent){

        if(training.containsKey(name)){

            val contents = training[name]!!.toMutableList()
            val index = contents.indexOf(oldContent)
            if (index != null && index > -1) {
                contents[index] = newContent
                training[name] = contents
            } else IllegalArgumentException("Non-existent index or negative index   ")

        } else IllegalArgumentException("Non-existent training")

    }

    fun editName(currentName: String, newName: String) {
        if (training.containsKey(currentName)) {

            val content = training.remove(currentName) // remove a chave correspondente no mapa, o nome da formação
            training[newName] = content ?: mutableListOf() //Caso content for null, será preenchido com uma lista vazia

        } else IllegalArgumentException("Non-existent training")
    }

    fun getTrainingMap(): Map<String, List<EducationalContent>>{
        return training
    }
}


data class EducationalContent(val name: String, var duration: Int = 60, var technologies: String, var description : String)


class EnrollmentManager(val students : List<User>, var training: TrainingProgram) {

    private val enrolledByRegistration = mutableMapOf<Int, User>()

    private  val enrolledByName = mutableMapOf<String,User>()

    fun studentEnrollment( students : List<User>){

        if(students != null ){

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

        }else throw IllegalArgumentException("user can't be null")

    }

    fun getEnrollmentManageByName(): MutableMap<String, User> {
        return enrolledByName
    }

    fun getEnrollementManageByRegistration(): MutableMap<Int, User> {
        return enrolledByRegistration
    }

}
