enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val cpf: String, var nome: String)

data class ConteudoEducacional(val id: Int, var nome: String, val duracao: Int = 60)

data class Formacao(val id: Int, val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun printInscritos(){
        println("Inscritos na Formacao ${this.nome}")
        this.inscritos.forEach{
            println("Id: ${it.id}, CPF: ${it.cpf}, Nome: ${it.nome}")
        }
        println("Total de ${this.inscritos.count()} alunos inscritos")
    }
}

fun main() {
    val usuario_1 = Usuario(1, "12345678900", "Fulano");
    val usuario_2 = Usuario(2, "98765432199", "Ciclano");
    
    val conteudos = listOf(
        ConteudoEducacional(1, "Algoritmos I", 78),
        ConteudoEducacional(2, "Android para iniciantes", 96)
    )
    
    val formacao = Formacao(1, "Bootcamp Kotlin", conteudos, Nivel.BASICO)
    
    formacao.matricular(usuario_1)
    formacao.matricular(usuario_2)
    
    formacao.printInscritos()
    
}
