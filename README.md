# White Label Notepad App in Kotlin

Este é um aplicativo White Label para inserção de anotações, desenvolvido em Kotlin e utilizando a arquitetura Clean, padrão de arquitetura de software que divide o aplicativo em camadas e permite a separação de responsabilidades. O projeto também utiliza as bibliotecas MVVM, Dagger Hilt e Firebase Firestore.

# Arquitetura

O projeto utiliza a arquitetura Clean, que consiste em três camadas principais:

Camada de Apresentação: é responsável pela interface do usuário e interação com o usuário. No projeto, essa camada é implementada com a arquitetura MVVM. Camada de Domínio: é responsável pelas regras de negócio do aplicativo. Essa camada contém as entidades e os casos de uso do aplicativo. Camada de Dados: é responsável pelo acesso aos dados, que podem ser armazenados localmente ou remotamente. No projeto, essa camada utiliza o Firebase Firestore para armazenar os dados. Bibliotecas utilizadas

# Bibliotecas

O projeto utiliza as seguintes bibliotecas:

MVVM: arquitetura que separa a interface do usuário da lógica de negócios. No projeto, é implementada com as bibliotecas LiveData e ViewModel. Dagger Hilt: biblioteca que facilita a injeção de dependências em aplicativos Android. Firebase Firestore: banco de dados NoSQL da Firebase, utilizado para armazenar as notas do usuário. Como utilizar

Para utilizar o projeto, é necessário ter o Android Studio instalado. Após clonar o repositório, basta abrir o projeto no Android Studio e executá-lo em um dispositivo Android ou em um emulador.

# Testes
Para garantir a qualidade do código, foram implementados testes unitários utilizando as bibliotecas Mockito e JUnit. Essas bibliotecas são amplamente utilizadas para testes em Java e Kotlin e permitem a criação de testes de unidade eficazes e eficientes.

# Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma pull request ou uma issue.
