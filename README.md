# Projeto de Microservices com Spring Boot e Spring Cloud

</hr>
</br>
</br>

![GitHub repo size](https://img.shields.io/github/repo-size/DaniloADamasceno/Microservices-with-Spring-Boot-and-Spring-Cloud?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/DaniloADamasceno/Microservices-with-Spring-Boot-and-Spring-Cloud?style=for-the-badge)

[![wakatime](https://wakatime.com/badge/github/DaniloADamasceno/Microservices-with-Spring-Boot-and-Spring-Cloud.svg)](https://wakatime.com/badge/github/DaniloADamasceno/Microservices-with-Spring-Boot-and-Spring-Cloud)

<!-- Imagem da Tela inicial do Aplicativo -->


<div align="center">
<table>
  <tr>
   
<td valign="top">
 <img src="https://github.com/DaniloADamasceno/Image-Bank/assets/71226047/5b35e6f9-230a-490c-856e-78c146e8f484">
</td>

<td valign="top">
 <img src="https://github.com/DaniloADamasceno/Image-Bank/assets/71226047/07c4df6a-e07f-43cf-92c5-942b18b5a0ea">
</td>

  </tr>
</table>
 </div>
  
</br>
</br>

## Descrição do Projeto

</br>

Este é um projeto de exemplo que demonstra como criar uma arquitetura de microservices usando o Spring Boot e o Spring Cloud. 
Este projeto é composto por vários serviços independentes que trabalham juntos para fornecer uma funcionalidade completa.

## Visão Geral

O objetivo deste projeto é criar uma aplicação de e-commerce de exemplo, que consiste em vários microservices para diferentes funcionalidades, incluindo:

1. *Serviço de Autenticação*: Gerencia a autenticação e autorização dos usuários.
2. *Serviço de Catálogo*: Gerencia informações de produtos.
3. *Serviço de Carrinho* de Compras: Gerencia o carrinho de compras dos usuários.
4. *Serviço de Pedidos*: Processa e gerencia pedidos de clientes.
5. *Serviço de Pagamentos*: Gerencia o processamento de pagamentos.

## Pré-requisitos

Antes de iniciar o projeto, verifique se você tem o seguinte software instalado:

- Java Development Kit (JDK) 11 ou superior
- Maven
- Spring Boot
- Spring Cloud

## Configuração

Clone este repositório para sua máquina local:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

## Build e Execução dos Microservices
Para cada serviço individual, você precisará entrar no diretório do serviço e construí-lo usando o Maven. Por exemplo, para construir o Serviço de Autenticação, execute os seguintes comandos:

```bash
cd authentication-service
mvn clean install
mvn spring-boot:run
```

Repita esse processo para cada serviço.

## Uso

A documentação completa da API para cada serviço pode ser encontrada nos seguintes endpoints:

- Serviço de Autenticação: *http://localhost:8080/swagger-ui.html*
- Serviço de Catálogo: *http://localhost:8081/swagger-ui.html*
- Serviço de Carrinho de Compras: *http://localhost:8082/swagger-ui.html*
- Serviço de Pedidos: *http://localhost:8083/swagger-ui.html*
- Serviço de Pagamentos: *http://localhost:8084/swagger-ui.html*

Você pode usar esses endpoints para interagir com os serviços e testar as várias funcionalidades.

