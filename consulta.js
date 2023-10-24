const buscarPorId = () => {
    const id = document.getElementById('id').value
 
    fetch(`http://localhost:8080/CDI_JSP/restapi/${id}`)

    // converte a resposta em formato json
    .then((resp) => resp.json())
 
    // recebe os dados da resposta
    .then((aluno) => mostrarDados(aluno))
 
    .catch(() => alert(`Aluno com ID=${id} não encontrado!`))
}

const mostrarDados = (aluno) => {
  
    document.getElementById('nome').value = aluno.nome
    document.getElementById('curso').value = aluno.curso
    document.getElementById('email').value = aluno.email
    const objData = aluno.data
    const data = new Date(objData.year, objData.month, objData.day).toLocaleString('pt-BR').split(',')[0]
    document.getElementById('data').value = data
}