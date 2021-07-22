pipeline {
    agent any
    environment {
        registry = "kostiakorzh/demoshop-user-service"
        registryCredential = 'Dockerhub'
        dockerImage = ''
    }
    stages {
        stage('Pulling git repo') {
            steps {
                git branch: "main", url: 'https://github.com/KostiantynKorzh/shop-user-service.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}