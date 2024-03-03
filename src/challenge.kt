enum class Level { BASIC, INTERMEDIARY, ADVANCED }

enum class EnrollmentStatus {NOT_ENROLLED, ENROLLED}

class User(val name : String, val registration : Int , var level : Level, var punctuation : Int, var statusUser : EnrollmentStatus, var training: TrainingProgram) {

    constructor(name: String, registration: Int, level: Level, punctuation: Int, statusUser: EnrollmentStatus,training: TrainingProgram) :
            this(name, registration, level.BASIC, 0, statusUser.NOT_ENROLLED,training)

    override fun toString(): String {
        return super.toString("$name,$registration,$punctuation,$statusUser in $training")
    }

}

data class TrainingProgram(val name: String,private var contents: mutableList<EducationalContent>) {

    private val  training : mutableMap<String, mutableList<EducationalContent>> = mutableMapOf()

    init {
        training[name] = contents
    }

    fun updateTraining(val name, content: EducationalContent){
        if(training.containsKey(name)){
            training[name].add(content)
        }else{
            training[name] = mutableListOf(content)
        }

    }

    fun editContent(val name: String, var oldContent: EducationalContent, var newContent: EducationalContent){

        if(training.containsKey(name)){

            val contents = training[name].toMutableList()
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
            training[newName] = content ?: emptyList() //Caso content for null, será preenchido com uma lista vazia

        } else IllegalArgumentException("Non-existent training")
    }

    fun getTrainingMap(): Map<String, List<EducationalContent>>{
        return training
    }
}


data class EducationalContent(val name: String, var duration: Int = 60, var technologies: String, var description : String)


class EnrollmentManager(val students : List<User>, var training: TrainingProgram) {

    internal val enrolledByRegistration = mutableMaptOf<Int, User>()

    internal val enrolledByName = mutableMaptOf<String,User>()

    fun studentEnrollment(val students : List<User>){

        if(students != null ){

            for(student in students) {

                val name = student.name
                val registration = student.registration
                var level = student.level
                var punctuation = student.punctuation
                var enrollmentStatus = student.statusUser = ENROLLED
                var trainingUser = student.training = training

                enrolledByRegistration[student.registration] = student
                enrolledByName[student.name] = student

                pritnln("Added Successfully")
            }

        }else IllegalArgumentException("user can't be null")

    }

    fun getEnrollmentManageByName(){
        return enrolledByName
    }

    fun getEnrollementManageByRegistration(){
        return enrolledByRegistration
    }

}
