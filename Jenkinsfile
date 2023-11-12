// TODO: fix this pipeline
node {
    stage('Checkout') {
        // Configurar SCM para monitorar o repositório
        checkout scm
    }

    stage('Build and Test') {
        // Comandos para construir e testar a aplicação
        sh 'mvn clean install'
    }

    stage('Generate Jacoco Report') {
        // Comandos para gerar relatórios Jacoco
        sh 'mvn jacoco:report'
    }

    stage('Publish to DockerHub') {
        // Comandos para construir e publicar a imagem no DockerHub
        sh 'docker build -t your-image-name .'
        sh 'docker push your-image-name'
    }
}
