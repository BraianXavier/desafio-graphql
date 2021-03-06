# Desafio GraphQl 1STI

>Pré requisitos: Ter um banco de dados MySql instalado na máquina e configurar o **.properties** com os atributos necessários;

## Startando a aplicação
````shell script
./mvnw spring-boot:run 
````
## Utilizando API
Para utilizar a **API** é preciso fazer uma requisição **post** para a rota **/graphql**
### Criando Usuário 
Request
```graphql
mutation{
    createUsuario(usuario:{
        email:"exemple@exemple.com"
        name: "exemple"
    }){
        name 
        email
    }
}
```
Response 
````json
{
    "data": {
        "createUsuario": {
            "name": "exemple",
            "email": "exemple@exemple.com"
        }
    }
}
````
### Criando Tarefa para usuario cadastrado
Request
```graphql
mutation{
    createTarefa(tarefa:{
        name:"tarefa exemple"
        descricao:"descricao da tarefa do usuario exemple"
        status:"a fazer"
    } email:"exemple@exemple.com"){
        name 
        descricao
        status
    }
}
```
Response
````json
{
    "data": {
        "createTarefa": {
            "name": "tarefa exemple",
            "descricao": "descricao da tarefa do usuario exemple",
            "status": "a fazer"
        }
    }
}
````
## Buscando Usuario pelo email
Request
```graphql
query{
    findUsuario(email:"exemple@exemple.com"){
        name
    }
}
```
Response 
````json
{
    "data": {
        "findUsuario": {
            "name": "exemple"
        }
    }
}
````
>Caso seja de interesse a busca pelas tarefas, basta acrescentar no pedido as tarefas, como no exemplo abaixo;

## Listando as Tarefas do Usuario
````graphql
query{
    findUsuario(email:"exemple@exemple.com"){
        name
        tarefas{
            name 
            descricao
            status
        }
    }
}
````
Response deve conter o nome do usuário com a lista de Tarefas;
````json
{
    "data": {
        "findUsuario": {
            "name": "exemple",
            "tarefas": [
                {
                    "name": "tarefa exemple",
                    "descricao": "descricao da tarefa do usuario exemple",
                    "status": "a fazer"
                }
            ]
        }
    }
}
````

>Você podera buscar o id de tarefa, fazendo a seginte query

Request
````graphql
query{
        findTarefa(name:"tarefa exemple"){
        id
    }   
}
````
Response
````json

{
    "data": {
        "findTarefa": {
            "id": "id da tarefa"
        }
    }
}
````
## Alteração do status da Tarefa
Request
````graphql
mutation{
    alteraStatus(id:"id da tarefa", status:"feito"){
                name
                descricao
                status
    }
}
````
Response 
````json
{
    "data": {
        "alteraStatus": {
            "name": "tarefa exemple",
            "descricao": "descricao da tarefa do usuario exemple",
            "status": "feito"
        }
    }
}
````