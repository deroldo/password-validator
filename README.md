# Password-Validator

Componente para validação de senhas

## Requisitos atendidos

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

> - Nove ou mais caracteres
> - Ao menos 1 dígito
> - Ao menos 1 letra minúscula
> - Ao menos 1 letra maiúscula
> - Ao menos 1 caractere especial
> - Não possuir caracteres repetidos

## Design

Foi utilizado o conceito de arquitetura hexagonal para atender as necessidades de isolamento:

> `domain` é onde estão as regras de negócio

> `service` responsável pela orquestração das camadas (gateways, repositories, etc) e prover 
> os dados necessários para a camada de domínio

> `controller` responsável por receber requisições http / https, se comunicar com a camada de serviço
> e converter para o modelo de resposta adequado

## Execução

### Pré requisitos

> 1. [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
> 1. [Docker](https://docs.docker.com/get-docker/)
> 1. [Docker compose](https://docs.docker.com/compose/install/)

### Comandos

Execute os comandos abaixo no terminal para iniciar o aplicativos:

```bash
git clone https://github.com/deroldo/password-validator.git
cd password-validator
./gradlew clean build
docker-compoase up --build
```

Após a mensagem `Started PasswordValidatorApplicationKt in XX.XXX seconds` aparecer,
você poderá testar aplicação através do [swagger](http://localhost:8080/swagger-ui.html).

> Obs.: remova as aspas (") da senha que virá preenchida

Se preferir, execute via:

> curl
```bash
curl --location --request POST 'http://localhost:8080/evaluate' \
--header 'Content-Type: text/plain' \
--data-raw 'A!1bcd3%$'
```

wget
```bash
wget --no-check-certificate --quiet \
  --method POST \
  --header 'Content-Type: text/plain' \
  --body-data 'A!1bcd3%$' \
   'http://localhost:8080/evaluate'
```